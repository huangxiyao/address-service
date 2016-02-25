package com.hp.it.cas.match.address.engine;

import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xml.sax.SAXException;

import com.addressdoctor.AddressDoctorException;
import com.addressdoctor.AddressObject;
import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.foundation.validation.Verifier;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;
import com.hp.it.cas.match.address.AddressQueryValidator;
import com.hp.it.cas.match.address.engine.utilities.XmlUtilities;

/**
 * Address finder.
 * 
 * @author paul.truax@hp.com
 * 
 */
public abstract class AbstractAddressFinder {
	protected AddressDoctorEngine addressDoctorEngine;
	protected DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	protected final Logger logger = LoggerFactory.getLogger(AbstractAddressFinder.class);
	protected final Logger requestLogger = LoggerFactory.getLogger(AbstractAddressFinder.class.getName() + "RequestLogger");

	protected final AddressQueryValidator validator = new AddressQueryValidator();

	protected String defaultParametersXmlString;
	protected String certifiedModeParametersXmlString;
	protected String wideOptimizationModeParametersXmlString;
	protected String interactiveModeParametersXmlString;
	protected String fastCompletionModeParametersXmlString;
	
	private static final String DEFAULT_PREFERRED_TOKEN = "DATABASE";
	private static final String PREFERRED_SCRIPT_TOKEN = "PreferredScript";
	private static final String PREFERRED_LANGUAGE_TOKEN = "PreferredLanguage";

	protected final boolean doValidation;

	/**
	 * Construct an address finder.
	 */
	public AbstractAddressFinder(boolean doValidation) {
		this.doValidation = doValidation;
		addressDoctorEngine = AddressDoctorEngine.INSTANCE;
		URL defaultParametersUrl;
		URL wideOptimizationModeParametersUrl;
		URL certifiedModeParametersUrl;
		URL interactiveModeParametersUrl;
		URL fastCompletionModeParametersUrl;

		DocumentBuilder builder;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();

			defaultParametersUrl = AddressDoctorEngine.class.getResource("/DefaultParameters.xml");
			wideOptimizationModeParametersUrl = AddressDoctorEngine.class.getResource("/WideOptimizationParameters.xml");
			certifiedModeParametersUrl = AddressDoctorEngine.class.getResource("/CertifiedModeParameters.xml");
			interactiveModeParametersUrl = AddressDoctorEngine.class.getResource("/InteractiveModeParameters.xml");
			fastCompletionModeParametersUrl = AddressDoctorEngine.class.getResource("/FastCompletionModeParameters.xml");

			this.defaultParametersXmlString = XmlUtilities.getXmlText(builder.parse(defaultParametersUrl.openStream()));
			this.wideOptimizationModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(wideOptimizationModeParametersUrl.openStream()));
			this.certifiedModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(certifiedModeParametersUrl.openStream()));
			this.interactiveModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(interactiveModeParametersUrl.openStream()));
			this.fastCompletionModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(fastCompletionModeParametersUrl.openStream()));

		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	protected AddressQueryResult process(AddressQuery query, String parmsXml, InvokedMethod method) {
		Stopwatch sw = Stopwatch.start();
		requestLogger.debug("ENTRY {}", query);
		requestLogger.trace("METHOD '{}'", method);
		new Verifier().isNotNull(query, "AddressQuery must not be null.").throwIfError();
		AddressObject addressObject = addressDoctorEngine.borrowObject();
		try {
			addressObject.setParametersXML(queryParameterOverride(query, parmsXml), null);
			mapAddressQueryToAddressObject(query, addressObject);			
			requestLogger.trace("Input XML: {}", addressObject.getInputDataXML());
			addressDoctorEngine.process(addressObject);
			requestLogger.trace("Output XML: {}", addressObject.getResultXML());
			return from(addressObject);
		} catch (AddressDoctorException e) {
			throw new RuntimeException(e.toString(), e);
		} finally {
			addressDoctorEngine.returnObject(addressObject);
			requestLogger.debug("RETURN {}, '{}'", sw, query);
		}
	}
	
	// Requirement from CMU team post 2012.04 release.
	// AddressDoctor ReST service should be able to accept PreferredScript and PreferredLanguage parameters.
	// The default for PreferredScript and PreferredLanguage is "DATABASE".
	// CMU team will do the character script determination and will pass the required values for PreferredScript and PreferredLanguage.
	// To keep the AddressService (ReST) based as generic as possible, we will just accept and output the PreferredScript and PreferredLanguage parameters.
	// This capability is done only to the ReST interface, SOAP is being deprecated and no changes can be done on SOAP interface as this will
	// affect a whole lot of SAP and downstream systems.
	// If invalid PreferredScript and PreferredLanguage parameters are passed, Address DOctor engine will default to DATABASE.
	
	private String queryParameterOverride(AddressQuery query, String parmsXml)
	{
		String preferredLanguage = query.getPreferredLanguage();
		
		String preferredScript = PreferredScript.resolve(query);
		
		if (preferredScript != DEFAULT_PREFERRED_TOKEN){
			String configured = String.format("%s=\"%s\"",PREFERRED_SCRIPT_TOKEN, DEFAULT_PREFERRED_TOKEN);
			String override = String.format("%s=\"%s\"",PREFERRED_SCRIPT_TOKEN, preferredScript);
			parmsXml = parmsXml.replaceAll(configured, override);
		}
		/*
		if (!(isNullOrEmpty(preferredLanguage) || preferredLanguage == DEFAULT_PREFERRED_TOKEN)){
			String configured = String.format("%s=\"%s\"",PREFERRED_LANGUAGE_TOKEN, DEFAULT_PREFERRED_TOKEN);
			String override = String.format("%s=\"%s\"",PREFERRED_LANGUAGE_TOKEN, preferredLanguage);
			parmsXml = parmsXml.replaceAll(configured, override);
		}
		*/

		return parmsXml;
	}
	
	private void mapAddressQueryToAddressObject(AddressQuery query, AddressObject addressObject) throws AddressDoctorException {
		populateInputAddressElement(query.getBuilding1(), addressObject, "Building", "COMPLETE", 1);
		populateInputAddressElement(query.getBuilding2(), addressObject, "Building", "COMPLETE", 2);
		populateInputAddressElement(query.getBuilding3(), addressObject, "Building", "COMPLETE", 3);
		populateInputAddressElement(query.getBuilding4(), addressObject, "Building", "COMPLETE", 4);
		populateInputAddressElement(query.getBuilding5(), addressObject, "Building", "COMPLETE", 5);
		populateInputAddressElement(query.getBuilding6(), addressObject, "Building", "COMPLETE", 6);

		populateInputAddressElement(query.getContact1(), addressObject, "Contact", "COMPLETE", 1);
		populateInputAddressElement(query.getContact2(), addressObject, "Contact", "COMPLETE", 2);
		populateInputAddressElement(query.getContact3(), addressObject, "Contact", "COMPLETE", 3);

		populateInputAddressElement(query.getCountry1(), addressObject, "Country", "NAME", 1);
		populateInputAddressElement(query.getCountry2(), addressObject, "Country", "NAME", 2);
		populateInputAddressElement(query.getCountry3(), addressObject, "Country", "NAME", 3);

		populateInputAddressElement(query.getDeliveryService1(), addressObject, "DeliveryService", "COMPLETE", 1);
		populateInputAddressElement(query.getDeliveryService2(), addressObject, "DeliveryService", "COMPLETE", 2);
		populateInputAddressElement(query.getDeliveryService3(), addressObject, "DeliveryService", "COMPLETE", 3);
		populateInputAddressElement(query.getDeliveryService4(), addressObject, "DeliveryService", "COMPLETE", 4);
		populateInputAddressElement(query.getDeliveryService5(), addressObject, "DeliveryService", "COMPLETE", 5);
		populateInputAddressElement(query.getDeliveryService6(), addressObject, "DeliveryService", "COMPLETE", 6);

		populateInputAddressElement(query.getLocality1(), addressObject, "Locality", "COMPLETE", 1);
		populateInputAddressElement(query.getLocality2(), addressObject, "Locality", "COMPLETE", 2);
		populateInputAddressElement(query.getLocality3(), addressObject, "Locality", "COMPLETE", 3);
		populateInputAddressElement(query.getLocality4(), addressObject, "Locality", "COMPLETE", 4);
		populateInputAddressElement(query.getLocality5(), addressObject, "Locality", "COMPLETE", 5);
		populateInputAddressElement(query.getLocality6(), addressObject, "Locality", "COMPLETE", 6);

		populateInputAddressElement(query.getNumber1(), addressObject, "Number", "COMPLETE", 1);
		populateInputAddressElement(query.getNumber2(), addressObject, "Number", "COMPLETE", 2);
		populateInputAddressElement(query.getNumber3(), addressObject, "Number", "COMPLETE", 3);
		populateInputAddressElement(query.getNumber4(), addressObject, "Number", "COMPLETE", 4);
		populateInputAddressElement(query.getNumber5(), addressObject, "Number", "COMPLETE", 5);
		populateInputAddressElement(query.getNumber6(), addressObject, "Number", "COMPLETE", 6);

		populateInputAddressElement(query.getOrganization1(), addressObject, "Organization", "COMPLETE", 1);
		populateInputAddressElement(query.getOrganization2(), addressObject, "Organization", "COMPLETE", 2);
		populateInputAddressElement(query.getOrganization3(), addressObject, "Organization", "COMPLETE", 3);

		populateInputAddressElement(query.getPostalCode1(), addressObject, "PostalCode", "UNFORMATTED", 1);
		populateInputAddressElement(query.getPostalCode2(), addressObject, "PostalCode", "UNFORMATTED", 2);
		populateInputAddressElement(query.getPostalCode3(), addressObject, "PostalCode", "UNFORMATTED", 3);

		populateInputAddressElement(query.getProvince1(), addressObject, "Province", "COUNTRY_STANDARD", 1);
		populateInputAddressElement(query.getProvince2(), addressObject, "Province", "COUNTRY_STANDARD", 2);
		populateInputAddressElement(query.getProvince3(), addressObject, "Province", "COUNTRY_STANDARD", 3);
		populateInputAddressElement(query.getProvince4(), addressObject, "Province", "COUNTRY_STANDARD", 4);
		populateInputAddressElement(query.getProvince5(), addressObject, "Province", "COUNTRY_STANDARD", 5);
		populateInputAddressElement(query.getProvince6(), addressObject, "Province", "COUNTRY_STANDARD", 6);

		populateInputAddressElement(query.getKey1(), addressObject, "Key", "RECORD_ID", 1);
		populateInputAddressElement(query.getKey2(), addressObject, "Key", "RECORD_ID", 2);
		populateInputAddressElement(query.getKey3(), addressObject, "Key", "RECORD_ID", 3);

		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 1);
		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 2);
		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 3);
		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 4);
		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 5);
		populateInputAddressElement(query.getResidue1(), addressObject, "Residue", "NECESSARY", 6);

		populateInputAddressElement(query.getStreet1(), addressObject, "Street", "COMPLETE", 1);
		populateInputAddressElement(query.getStreet2(), addressObject, "Street", "COMPLETE", 2);
		populateInputAddressElement(query.getStreet3(), addressObject, "Street", "COMPLETE", 3);
		populateInputAddressElement(query.getStreet4(), addressObject, "Street", "COMPLETE", 4);
		populateInputAddressElement(query.getStreet5(), addressObject, "Street", "COMPLETE", 5);
		populateInputAddressElement(query.getStreet6(), addressObject, "Street", "COMPLETE", 6);

		populateInputAddressElement(query.getSubBuilding1(), addressObject, "SubBuilding", "COMPLETE", 1);
		populateInputAddressElement(query.getSubBuilding2(), addressObject, "SubBuilding", "COMPLETE", 2);
		populateInputAddressElement(query.getSubBuilding3(), addressObject, "SubBuilding", "COMPLETE", 3);
		populateInputAddressElement(query.getSubBuilding4(), addressObject, "SubBuilding", "COMPLETE", 4);
		populateInputAddressElement(query.getSubBuilding5(), addressObject, "SubBuilding", "COMPLETE", 5);
		populateInputAddressElement(query.getSubBuilding6(), addressObject, "SubBuilding", "COMPLETE", 6);

		populateInputAddressLine(query.getDeliveryAddressLine1(), addressObject, "DeliveryAddressLine", 1);
		populateInputAddressLine(query.getDeliveryAddressLine2(), addressObject, "DeliveryAddressLine", 2);
		populateInputAddressLine(query.getDeliveryAddressLine3(), addressObject, "DeliveryAddressLine", 3);
		populateInputAddressLine(query.getDeliveryAddressLine4(), addressObject, "DeliveryAddressLine", 4);
		populateInputAddressLine(query.getDeliveryAddressLine5(), addressObject, "DeliveryAddressLine", 5);
		populateInputAddressLine(query.getDeliveryAddressLine6(), addressObject, "DeliveryAddressLine", 6);

		populateInputAddressLine(query.getRecipientLine1(), addressObject, "RecipientLine", 1);
		populateInputAddressLine(query.getRecipientLine2(), addressObject, "RecipientLine", 2);
		populateInputAddressLine(query.getRecipientLine3(), addressObject, "RecipientLine", 3);

		populateInputAddressLine(query.getCountrySpecificLocalityLine1(), addressObject, "CountrySpecificLocalityLine", 1);
		populateInputAddressLine(query.getCountrySpecificLocalityLine2(), addressObject, "CountrySpecificLocalityLine", 2);
		populateInputAddressLine(query.getCountrySpecificLocalityLine3(), addressObject, "CountrySpecificLocalityLine", 3);
		populateInputAddressLine(query.getCountrySpecificLocalityLine4(), addressObject, "CountrySpecificLocalityLine", 4);
		populateInputAddressLine(query.getCountrySpecificLocalityLine5(), addressObject, "CountrySpecificLocalityLine", 5);
		populateInputAddressLine(query.getCountrySpecificLocalityLine6(), addressObject, "CountrySpecificLocalityLine", 6);

		populateInputAddressLine(query.getFormattedAddressLine1(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine2(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine3(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine4(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine5(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine6(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine7(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine8(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine9(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine10(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine11(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine12(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine13(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine14(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine15(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine16(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine17(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine18(), addressObject, "FormattedAddressLine", 1);
		populateInputAddressLine(query.getFormattedAddressLine19(), addressObject, "FormattedAddressLine", 1);

		populateCompleteAddress(query.getAddressComplete(), addressObject);
	}

	private void populateInputAddressElement(String input, AddressObject addressObject, String type, String discriminator, int level) throws AddressDoctorException {
		if (!isNullOrEmpty(input)) {
			addressObject.setInputAddressElement(type, level, discriminator, input);
		}
	}

	private void populateInputAddressLine(String input, AddressObject addressObject, String type, int level) throws AddressDoctorException {
		if (!isNullOrEmpty(input)) {
			addressObject.setInputAddressLine(type, level, input);
		}
	}

	private void populateCompleteAddress(String input, AddressObject addressObject) throws AddressDoctorException {
		if (!isNullOrEmpty(input)) {
			addressObject.setInputAddressComplete(input);
		}
	}

	private AddressQueryResult from(AddressObject addressObject) throws AddressDoctorException {
		int resultCount = addressObject.getResultCount();
		AddressQueryResult result = new AddressQueryResult();
		logger.debug("Output XML: {}", addressObject.getResultXML());
		result.setModeUsed(addressObject.getResultParameter("ModeUsed"));
		result.setPreferredLanguage(addressObject.getResultParameter("PreferredLanguage"));
		result.setPreferredScript(addressObject.getResultParameter("PreferredScript"));
		result.setProcessStatus(addressObject.getResultParameter("ProcessStatus"));
		result.setIso3(addressObject.getResultParameter("CountryISO3"));

		String overFlow = addressObject.getResultParameter("CountOverflow");

		if (overFlow.equals("YES")) {
			result.setCountOverFlow(true);
		} else {
			result.setCountOverFlow(false);
		}

		for (int resultIndex = 0; resultIndex < resultCount; resultIndex++) {
			result.getAddressData().add(result.new AddressData());
			AddressData addressData = result.getAddressData().get(resultIndex);

			addressData.setElementInputStatus(addressObject.getResultDataParameter(resultIndex + 1, "ElementInputStatus"));
			addressData.setElementRelevance(addressObject.getResultDataParameter(resultIndex + 1, "ElementRelevance"));
			addressData.setElementResultStatus(addressObject.getResultDataParameter(resultIndex + 1, "ElementResultStatus"));
			addressData.setMailabilityScore(addressObject.getResultDataParameter(resultIndex + 1, "MailabilityScore"));
			addressData.setResultPercentage(addressObject.getResultDataParameter(resultIndex + 1, "ResultPercentage"));
			addressData.setCassStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "CASSStatus"));
			addressData.setSerpStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SERPStatus"));
			addressData.setSnaStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SNAStatus"));
			addressData.setSupplementaryGBStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryGBStatus"));
			addressData.setSupplementaryUSStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryUSStatus"));
			addressData.setGeoCodingStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "GeoCodingStatus"));
			addressData.setSupplementaryATStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryATStatus"));
			addressData.setSupplementaryBRStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryBRStatus"));
			addressData.setSupplementaryCHStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryCHStatus"));
			addressData.setSupplementaryDEStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryDEStatus"));
			addressData.setSupplementaryFRStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryFRStatus"));
			addressData.setSupplementaryJPStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryJPStatus"));
			addressData.setSupplementaryPLStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryPLStatus"));
			addressData.setSupplementaryRSStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryRSStatus"));
			addressData.setSupplementaryZAStatus(addressObject.getResultEnrichmentDataParameter(resultIndex + 1, "SupplementaryZAStatus"));

			String token = "Building";
			int numBuildings = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numBuildings; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE_WITH_SUBBUILDING"), "COMPLETE_WITH_SUBBUILDING",
						addressData.getBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DESCRIPTOR"), "DESCRIPTOR", addressData.getBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"), "NAME", addressData.getBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NUMBER"), "NUMBER", addressData.getBuildings());

			}

			token = "Street";
			int numStreets = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numStreets; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ADD_INFO"), "ADD_INFO", addressData.getStreets());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getStreets());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE_WITH_NUMBER"), "COMPLETE_WITH_NUMBER",
						addressData.getStreets());
				// TODO Calling the following method with country="AU", Delivery Address Line="Lagoon Rd", Postal
				// Code="2898" causes a sigfault. Registered bug with address doctor 16-Sept-2011
				// addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"),
				// "NAME", addressData.getCountryStreet());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "POST_DESCRIPTOR"), "POST_DESCRIPTOR", addressData.getStreets());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "POST_DIRECTIONAL"), "POST_DIRECTIONAL", addressData.getStreets());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "PRE_DESCRIPTOR"), "PRE_DESCRIPTOR", addressData.getStreets());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "PRE_DIRECTIONAL"), "PRE_DIRECTIONAL", addressData.getStreets());
			}

			token = "Contact";
			int numContacts = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numContacts; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "FIRST_NAME"), "FIRST_NAME", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "FUNCTION"), "FUNCTION", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "GENDER"), "GENDER", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "LAST_NAME"), "LAST_NAME", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "MIDDLE_NAME"), "MIDDLE_NAME", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"), "NAME", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "SALUTATION"), "SALUTATION", addressData.getContacts());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "TITLE"), "TITLE", addressData.getContacts());
			}

			token = "Country";
			int numCountries = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numCountries; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ABBREVIATION"), "ABBREVIATION", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ISO2"), "ISO2", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ISO3"), "ISO3", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ISO_NUMBER"), "ISO_NUMBER", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_CN"), "NAME_CN", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_DA"), "NAME_DA", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_DE"), "NAME_DE", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_EN"), "NAME_EN", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_ES"), "NAME_ES", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_FI"), "NAME_FI", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_FR"), "NAME_FR", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_GR"), "NAME_GR", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_HU"), "NAME_HU", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_IT"), "NAME_IT", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_JP"), "NAME_JP", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_KR"), "NAME_KR", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_NL"), "NAME_NL", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_PL"), "NAME_PL", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_PT"), "NAME_PT", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_RU"), "NAME_RU", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_SA"), "NAME_SA", addressData.getCountries());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME_SE"), "NAME_SE", addressData.getCountries());
			}

			token = "DeliveryService";
			int numDeliveryServices = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numDeliveryServices; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ADD_INFO"), "ADD_INFO", addressData.getDeliveryServices());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getDeliveryServices());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DESCRIPTOR"), "DESCRIPTOR", addressData.getDeliveryServices());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NUMBER"), "NUMBER", addressData.getDeliveryServices());
			}

			token = "Locality";
			int numLocality = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numLocality; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ADD_INFO"), "ADD_INFO", addressData.getLocalities());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getLocalities());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"), "NAME", addressData.getLocalities());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "SORTING_CODE"), "SORTING_CODE", addressData.getLocalities());
			}

			token = "Number";
			int numNumbers = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numNumbers; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NUMBER"), "NUMBER", addressData.getNumbers());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ADD_INFO"), "ADD_INFO", addressData.getNumbers());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getNumbers());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DESCRIPTOR"), "DESCRIPTOR", addressData.getNumbers());
			}

			token = "Organization";
			int numOrganizations = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numOrganizations; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getOrganizations());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DEPARTMENT"), "DEPARTMENT", addressData.getOrganizations());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DESCRIPTOR"), "DESCRIPTOR", addressData.getOrganizations());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"), "NAME", addressData.getOrganizations());
			}

			token = "PostalCode";
			int numPostalCodes = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numPostalCodes; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ADD_ON"), "ADD_ON", addressData.getPostalCodes());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "BASE"), "BASE", addressData.getPostalCodes());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "FORMATTED"), "FORMATTED", addressData.getPostalCodes());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "UNFORMATTED"), "UNFORMATTED", addressData.getPostalCodes());
			}

			token = "Province";
			int numProvinces = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numProvinces; index++) {
				if (index == 0) {
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ABBREVIATION"), "ABBREVIATION", addressData.getProvinces());
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COUNTRY_STANDARD"), "COUNTRY_STANDARD", addressData.getProvinces());
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "EXTENDED"), "EXTENDED", addressData.getProvinces());
				} else {
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "ABBREVIATION"), "ABBREVIATION", addressData.getSubProvinces());
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COUNTRY_STANDARD"), "COUNTRY_STANDARD", addressData.getSubProvinces());
					addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "EXTENDED"), "EXTENDED", addressData.getSubProvinces());
				}
			}

			token = "Key";
			int numKeys = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numKeys; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "RECORD_ID"), "RECORD_ID", addressData.getKeys());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "TRANSACTION_KEY"), "TRANSACTION_KEY", addressData.getKeys());
			}

			token = "Residue";
			int numResidues = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numResidues; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NECESSARY"), "NECESSARY", addressData.getResidues());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "SUPERFLUOUS"), "SUPERFLUOUS", addressData.getResidues());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "UNRECOGNIZED"), "UNRECOGNIZED", addressData.getResidues());
			}

			token = "SubBuilding";
			int numSubBuildings = addressObject.getResultAddressElementItemCount(resultIndex + 1, token);
			for (int index = 0; index < numSubBuildings; index++) {
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "COMPLETE"), "COMPLETE", addressData.getSubBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "DESCRIPTOR"), "DESCRIPTOR", addressData.getSubBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NAME"), "NAME", addressData.getSubBuildings());
				addAddressElement(addressObject.getResultAddressElement(resultIndex + 1, token, index + 1, "NUMBER"), "NUMBER", addressData.getSubBuildings());
			}

			token = "RecipientLine";
			int numRecipientLines = addressObject.getResultAddressLineCount(resultIndex + 1, token);
			for (int index = 0; index < numRecipientLines; index++) {
				addressData.getRecipientLines().add(addressObject.getResultAddressLine(resultIndex + 1, token, index + 1));
			}

			token = "CountrySpecificLocalityLine";
			int numCountrySpecificLocalityLines = addressObject.getResultAddressLineCount(resultIndex + 1, token);
			for (int index = 0; index < numCountrySpecificLocalityLines; index++) {
				addressData.getCountrySpecificLocalityLines().add(addressObject.getResultAddressLine(resultIndex + 1, token, index + 1));
			}

			token = "DeliveryAddressLine";
			int numDeliveryAddressLines = addressObject.getResultAddressLineCount(resultIndex + 1, token);
			for (int index = 0; index < numDeliveryAddressLines; index++) {
				addressData.getDeliveryAddressLines().add(addressObject.getResultAddressLine(resultIndex + 1, token, index + 1));
			}

			token = "FormattedAddressLine";
			int numFormattedAddressLines = addressObject.getResultAddressLineCount(resultIndex + 1, token);
			for (int index = 0; index < numFormattedAddressLines; index++) {
				addressData.getFormattedAddressLines().add(addressObject.getResultAddressLine(resultIndex + 1, token, index + 1));
			}
			
			token = "SupplementaryGB";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1, token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "DELIVERY_POINT_SUFFIXES"),"DELIVERY_POINT_SUFFIXES", addressData.getSupplementaryGb());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "UDPRN"),"UDPRN", addressData.getSupplementaryGb());
			}
			
			token = "SupplementaryUS";			
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1, token)) {
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "COUNTY_FIPS_CODE"),"COUNTY_FIPS_CODE", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "STATE_FIPS_CODE"),"STATE_FIPS_CODE", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "MSA_ID"),"MSA_ID", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "CBSA_ID"),"CBSA_ID", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "FINANCE_NUMBER"),"FINANCE_NUMBER", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "RECORD_TYPE"),"RECORD_TYPE", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "CMSA_ID"),"CMSA_ID", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "CENSUS_TRACT_NO"),"CENSUS_TRACT_NO", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "CENSUS_BLOCK_NO"),"CENSUS_BLOCK_NO", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "CENSUS_BLOCK_GROUP"),"CENSUS_BLOCK_GROUP", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "PMSA_ID"),"PMSA_ID", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "PLACE_FIPS_CODE"),"PLACE_FIPS_CODE", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "TIME_ZONE_CODE"),"TIME_ZONE_CODE", addressData.getSupplementaryUs());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1 , token, "TIME_ZONE_NAME"),"TIME_ZONE_NAME", addressData.getSupplementaryUs());
			}
			
			token = "GeoCoding";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "COMPLETE"), "COMPLETE", addressData.getGeoCoding());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LATITUDE"), "LATITUDE", addressData.getGeoCoding());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LONGITUDE"), "LONGITUDE", addressData.getGeoCoding());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LAT_LONG_UNIT"), "LAT_LONG_UNIT", addressData.getGeoCoding());
			}
			
			token = "SupplementaryAT";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "POSTAL_ADDRESS_CODE"), "POSTAL_ADDRESS_CODE", addressData.getSupplementaryAt());
			}
			
			token = "SupplementaryBR";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "IBGE_CODE"), "IBGE_CODE", addressData.getSupplementaryBr());
			}
			
			token = "SupplementaryCH";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "POCO_EXT"), "POCO_EXT", addressData.getSupplementaryCh());
			}
			
			token = "SupplementaryDE";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DEU_AGS"), "DEU_AGS", addressData.getSupplementaryDe());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DEU_LOCALITY_ID"), "DEU_LOCALITY_ID", addressData.getSupplementaryDe());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DEU_STREET_ID"), "DEU_STREET_ID", addressData.getSupplementaryDe());
			}
			
			token = "SupplementaryFR";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "INSEE_CODE"), "INSEE_CODE", addressData.getSupplementaryFr());
			}
			
			token = "SupplementaryJP";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "NEW_CHOUMEI_AZA_CODE"), "NEW_CHOUMEI_AZA_CODE", addressData.getSupplementaryJp());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "CHOUMEI_AZA_CODE"), "CHOUMEI_AZA_CODE", addressData.getSupplementaryJp());
			}
			
			token = "SupplementaryPL";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "GMINA_CODE"), "GMINA_CODE", addressData.getSupplementaryPl());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LOCALITY_TERYT_ID"), "LOCALITY_TERYT_ID", addressData.getSupplementaryPl());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "STREET_TERYT_ID"), "STREET_TERYT_ID", addressData.getSupplementaryPl());
			}
			
			token = "SupplementaryRS";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "POSTAL_ADDRESS_CODE"), "POSTAL_ADDRESS_CODE", addressData.getSupplementaryRs());
			}

			token = "SupplementaryZA";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "NAD_ID"), "NAD_ID", addressData.getSupplementaryZa());
			}
			
			/* */
			token = "CASS";
			if (addressObject.getResultEnrichmentElementExists(resultIndex + 1,  token)){
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "ERRORCODE"), "ERRORCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "BARCODE"), "BARCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DELIVERY_POINT"), "DELIVERY_POINT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "RECORDTYPE"), "RECORDTYPE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "CARRIER_ROUTE"), "CARRIER_ROUTE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "CONGRESSIONAL_DISTRICT"), "CONGRESSIONAL_DISTRICT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DELIVERY_POINT_CHECK_DIGIT"), "DELIVERY_POINT_CHECK_DIGIT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "HIGHRISE_DEFAULT"), "HIGHRISE_DEFAULT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "HIGHRISE_EXACT"), "HIGHRISE_EXACT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "RURALROUTE_DEFAULT"), "RURALROUTE_DEFAULT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "RURALROUTE_EXACT"), "RURALROUTE_EXACT", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LACS"), "LACS", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_CONFIRMATION"), "DPV_CONFIRMATION", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_CMRA"), "DPV_CMRA", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_FALSE_POSITIVE"), "DPV_FALSE_POSITIVE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_FOOTNOTE_1"), "DPV_FOOTNOTE_1", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_FOOTNOTE_2"), "DPV_FOOTNOTE_2", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_FOOTNOTE_3"), "DPV_FOOTNOTE_3", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DPV_FOOTNOTE_COMPLETE"), "DPV_FOOTNOTE_COMPLETE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LACSLINK_RETURNCODE"), "LACSLINK_RETURNCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "SUITELINK_RETURNCODE"), "SUITELINK_RETURNCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "EWS_RETURNCODE"), "EWS_RETURNCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "ZIPMOVE_RETURNCODE"), "ZIPMOVE_RETURNCODE", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DSF2_NOSTATS_INDICATOR"), "DSF2_NOSTATS_INDICATOR", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DSF2_VACANT_INDICATOR"), "DSF2_VACANT_INDICATOR", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "DEFAULT_FLAG"), "DEFAULT_FLAG", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "LACSLINK_INDICATOR"), "LACSLINK_INDICATOR", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "RDI"), "RDI", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "ELOT_FLAG"), "ELOT_FLAG", addressData.getCass());
				addAddressElement(addressObject.getResultEnrichmentElement(resultIndex + 1, token, "ELOT_SEQUENCE"), "ELOT_SEQUENCE", addressData.getCass());
			}

			addressData.setCompleteAddress(addressObject.getResultAddressComplete(resultIndex + 1));

		}

		return result;
	}

	private boolean isNullOrEmpty(String input) {
		boolean nullOrEmpty = true;

		if (!(input == null || input.trim().equals(""))) {
			nullOrEmpty = false;
		}

		return nullOrEmpty;
	}

	private void addAddressElement(String input, String elementType, List<AddressElement> elementList) {
		if (!isNullOrEmpty(input)) {
			elementList.add(new AddressElement(elementType, input));
		}
	}

	protected void validate(AddressQuery query, ConstraintViolationContext<AddressQuery> errors) {
		Set<ConstraintViolation<AddressQuery>> violations = validator.validate(query);
		violations.addAll(errors.getConstraintViolations());
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new LinkedHashSet<ConstraintViolation<?>>(violations));
		}
	}
	
	protected AddressQueryResult withLogging(AddressQuery query, String xmlConfiguration, InvokedMethod method){
		AddressQueryResult result = null;
//		try{
//			if(SecurityContextHolder.isSecurityContextSet()){
//				@SuppressWarnings("rawtypes")
//				SecurityContext context = SecurityContextHolder.get();
//				if(context instanceof RichSecurityContext){
//					RichSecurityContext richSecurityContext = (RichSecurityContext)context;
//					ApplicationProcessAccess applicationProcessAccess = richSecurityContext.getCallerApplicationProcess();
//					applicationProcessAccess.getApplicationProcessUid();
//					MDC.put("ap-uid", applicationProcessAccess.getApplicationProcessUid());
//					result = withTiming(query, xmlConfiguration, method);
//				}
//			}

			result = withTiming(query, xmlConfiguration, method);
//		} finally{
//			MDC.remove("ap-uid");
//		}
		
		return result;
	}
	
	protected AddressQueryResult withTiming(AddressQuery query, String xmlConfiguration, InvokedMethod method){
		Stopwatch sw = Stopwatch.start();
		AddressQueryResult result = process(query,  xmlConfiguration, method);
		logger.debug("{} Time: {}", method, sw);
		return result;
	}

}
