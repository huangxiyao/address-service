package com.hp.it.cas.match.address.engine.legacy;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.addressdoctor.AddressDoctorException;
import com.addressdoctor.AddressObject;
import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.validation.Verifier;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.utilities.XmlUtilities;


/**
 * Implementation of the address analyzer built to mimic the legacy CID CAS address standardization interface.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class LegacyAddressDoctorAddressAnalyzer {
	private final AddressDoctorEngine addressDoctorEngine;
	private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	private final int outputSize = 50;
	private final int hybridSizeMin = 8;
	private final int hybridSizeMax = 13;
	private final int discreteSizeMin = 13;
	private final int discreteSizeMax = 15;
	
	private final String legacyDefaultParametersXmlString;
	private final String legacyCertifiedModeParametersXmlString;
	private final String legacyWideOptimizationModeParametersXmlString;

	final Logger logger = LoggerFactory.getLogger(LegacyAddressDoctorAddressAnalyzer.class);
	final Logger requestLogger = LoggerFactory.getLogger(LegacyAddressDoctorAddressAnalyzer.class.getName()+"RequestLogger");

	/**
	 * Initialize the address doctor analyzer with an instance of the address doctor engine.
	 * 
	 * @param value
	 *            the address doctor engine
	 */
	public LegacyAddressDoctorAddressAnalyzer(AddressDoctorEngine value) {
		this.addressDoctorEngine = value;
		URL legacyDefaultParametersUrl;
		URL legacyWideOptimizationModeParametersUrl;
		URL legacyCertifiedModeParametersUrl;

		DocumentBuilder builder;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
						
			legacyDefaultParametersUrl = AddressDoctorEngine.class.getResource("/LegacyDefaultParameters.xml");
			legacyWideOptimizationModeParametersUrl = AddressDoctorEngine.class.getResource("/LegacyWideOptimizationParameters.xml");
			legacyCertifiedModeParametersUrl = AddressDoctorEngine.class.getResource("/LegacyCertifiedModeParameters.xml");
			
			this.legacyDefaultParametersXmlString = XmlUtilities.getXmlText(builder.parse(legacyDefaultParametersUrl.openStream()));
			this.legacyWideOptimizationModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(legacyWideOptimizationModeParametersUrl.openStream()));
			this.legacyCertifiedModeParametersXmlString = XmlUtilities.getXmlText(builder.parse(legacyCertifiedModeParametersUrl.openStream()));
			
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}

	/**
	 * Analyze a hybrid address
	 * 
	 * 
	 * @param input
	 *            <ol>
	 *            <li>Delivery Address Line 1</li>
	 *            <li>Delivery Address Line 2</li>
	 *            <li>Delivery Address Line 3</li>
	 *            <li>Complete Locality 1: Primary place name. Typically a "province is subdivided into localities. Some
	 *            countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in
	 *            the US and Kreise in Germany. City is also stored here often.</li>
	 *            <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias
	 *            in Mexico, Urbanisaciones in Spain.</li>
	 *            <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a
	 *            country.</li>
	 *            <li>Unformatted Postal Code</li>
	 *            <li>Country Name</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            </ol>
	 * @return Standardized Address
	 *         <ol>
	 *         <li>Complete Building Name</li>
	 *         <li>Complete SubBuilding: Information that further subdivides a building. e.g. the floor</li>
	 *         <li>Delivery Address Line 1</li>
	 *         <li>Complete Delivery Service 1: Post Box descriptor (POBox, Postfach, Case Postale etc.) and number.</li>
	 *         <li>Complete Locality 3: Dependent place name that further subdivides a Locality. An example would be
	 *         Mahalle in Turkey.</li>
	 *         <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias in
	 *         Mexico, Urbanisaciones in Spain.</li>
	 *         <li>Complete Locality 1: Primary place name. Typically a �province is subdivided into localities. Some
	 *         countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in the
	 *         US and Kreise in Germany. City is also stored here often.</li>
	 *         <li>Country Standard Province 2: Dependent province information that further subdivides a province. An
	 *         example would be a US county.</li>
	 *         <li>Abbreviated Province 1: The state, province, canton, prefecture or other sub-division of a country.</li>
	 *         <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a country</li>
	 *         <li>Complete Street 2: Dependent street or thoroughfare</li>
	 *         <li>Unformatted Postal Code: Postal code or ZIP code.</li>
	 *         <li>PO Box Label: Currently not being used</li>
	 *         <li>ISO2 Country Code</li>
	 *         <li>Delivery Address Line 1</li>
	 *         <li>Delivery Address Line 2</li>
	 *         <li>Delivery Address Line 3</li>
	 *         <li>Complete Locality 3: Dependent place name that further subdivides a Locality. An example would be
	 *         Mahalle in Turkey.</li>
	 *         <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias in
	 *         Mexico, Urbanisaciones in Spain.</li></li>
	 *         <li>Complete Locality 1: Primary place name. Typically a �province is subdivided into localities. Some
	 *         countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in the
	 *         US and Kreise in Germany. City is also stored here often.</li>
	 *         <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a country.</li>
	 *         <li>Unformatted Postal Code: Postal code or ZIP code.</li>
	 *         <li>CountryCode: ISO2 Country Code</li>
	 *         <li>Fault Code</li>
	 *         <li>Fault Text</li>
	 *         <li>Status Code</li>
	 *         <li>Status Text</li>
	 *         <li>NOT USED</li>
	 *         <li>Unrecognized Residue 1</li>
	 *         <li>Unrecognized Residue 2</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>Result percentage</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         </ol>
	 */
	public List<String> analyzeHybridAddress(List<String> input) {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Input address: {}", input);
		List<String> result = emptyList(outputSize);
		String certifiedStatusCode = "";
		String defaultStatusCode = "";
		new Verifier().isNotNull(input, "Input must not be null").throwIfError();
		new Verifier().isTrue(isBetween(input.size(), hybridSizeMin, hybridSizeMax, true), "String array must be between %s and %s elements long", hybridSizeMin, hybridSizeMax).throwIfError();
		new Verifier().isFalse(isNullOrEmpty(input), "Entire input is empty.").throwIfError();
		registerHybridContingencyExceptions(input, result);

		// if their are no contingency exceptions, then continue
		if (result.get(23) == null || result.get(23).isEmpty()) {
			result = process(input, legacyCertifiedModeParametersXmlString, true);
			certifiedStatusCode = (result == null) ? "" : result.get(23);
			
			if(certifiedStatusCode.equals("E000") || isCountryInCertifiedExclusionList(result)) {
				logger.debug("CERTIFIED mode unsuccessful or country in exclusion list for hybrid address {}, using BATCH-INTERACTIVE mode.", input.toString());
				result = process(input, legacyDefaultParametersXmlString, true);
				defaultStatusCode = (result == null) ? "" : result.get(23);
			}

			if (defaultStatusCode.equals("E000")) {
				logger.debug("BATCH-INTERACTIVE mode unsuccessful for hybrid address {}, widening optimization level.", input.toString());
				result = process(input, legacyWideOptimizationModeParametersXmlString, true);
			}
		}
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

	private void mapHybridInputToAddressObject(List<String> input, AddressObject addressObject)
			throws AddressDoctorException {
		if (!isNullOrEmpty(input.get(0))) {
			addressObject.setInputAddressLine("DeliveryAddressLine", 1, input.get(0));
		}

		if (!isNullOrEmpty(input.get(1))) {
			addressObject.setInputAddressLine("DeliveryAddressLine", 2, input.get(1));
		}

		if (!isNullOrEmpty(input.get(2))) {
			addressObject.setInputAddressLine("DeliveryAddressLine", 3, input.get(2));
		}

		if (!isNullOrEmpty(input.get(3))) {
			addressObject.setInputAddressElement("Locality", 1, "COMPLETE", input.get(3));
		}

		if (!isNullOrEmpty(input.get(4))) {
			addressObject.setInputAddressElement("Locality", 2, "COMPLETE", input.get(4));
		}

		if (!isNullOrEmpty(input.get(5))) {
			addressObject.setInputAddressElement("Province", 1, "COUNTRY_STANDARD", input.get(5));
		}

		if (!isNullOrEmpty(input.get(6))) {
			addressObject.setInputAddressElement("PostalCode", 1, "UNFORMATTED", input.get(6));
		}

		if (!isNullOrEmpty(input.get(7))) {
			addressObject.setInputAddressElement("Country", 1, "NAME", input.get(7));
		}
	}

	/**
	 * Analyze a discrete address
	 * 
	 * @param input
	 *            <ol>
	 *            <li>Complete Building</li>
	 *            <li>Complete SubBuilding: Information that further subdivides a building. e.g. the floor</li>
	 *            <li>Delivery Address Line 1</li>
	 *            <li>Complete Delivery Service 2: Post Box descriptor (POBox, Postfach, Case Postale etc.) and number.</li>
	 *            <li>Complete Locality 3: Dependent place name that further subdivides a Locality. An example would be
	 *            Mahalle in Turkey.</li>
	 *            <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias
	 *            in Mexico, Urbanisaciones in Spain.</li>
	 *            <li>Complete Locality 1: Primary place name. Typically a �province is subdivided into localities. Some
	 *            countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in
	 *            the US and Kreise in Germany. City is also stored here often.</li>
	 *            <li>Country Standard Province 2: Dependent province information that further subdivides a province. An
	 *            example would be a US county</li>
	 *            <li>Abbreviated Province 1: The state, province, canton, prefecture or other sub-division of a country
	 *            </li>
	 *            <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a
	 *            country.</li>
	 *            <li>Complete Street 2: Dependent street or thoroughfare</li>
	 *            <li>Unformatted Postal Code</li>
	 *            <li>Country Name</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            <li>NOT USED and NOT REQUIRED</li>
	 *            </ol>
	 * @return Standardized Address
	 *         <ol>
	 *         <li>Complete Building Name</li>
	 *         <li>Complete SubBuilding: Information that further subdivides a building. e.g. the floor</li>
	 *         <li>Delivery Address Line 1</li>
	 *         <li>Delivery Service 1 Number: Post Box number.</li>
	 *         <li>Complete Locality 3: Dependent place name that further subdivides a Locality. An example would be
	 *         Mahalle in Turkey.</li>
	 *         <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias in
	 *         Mexico, Urbanisaciones in Spain.</li>
	 *         <li>Complete Locality 1: Primary place name. Typically a �province is subdivided into localities. Some
	 *         countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in the
	 *         US and Kreise in Germany. City is also stored here often.</li>
	 *         <li>Country Standard Province 2: Dependent province information that further subdivides a province. An
	 *         example would be a US county.</li>
	 *         <li>Abbreviated Province 1: The state, province, canton, prefecture or other sub-division of a country.</li>
	 *         <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a country</li>
	 *         <li>Complete Street 2: Dependent street or thoroughfare</li>
	 *         <li>Unformatted Postal Code: Postal code or ZIP code.</li>
	 *         <li>Delivery Service 1 Descriptor: PO Box Descriptor</li>
	 *         <li>ISO2 Country Code</li>
	 *         <li>Delivery Address Line 1</li>
	 *         <li>Delivery Address Line 2</li>
	 *         <li>Delivery Address Line 3</li>
	 *         <li>Complete Locality 3: Dependent place name that further subdivides a Locality. An example would be
	 *         Mahalle in Turkey.</li>
	 *         <li>Complete Locality 2: Dependent place name that further subdivies a Locality. Examples are colonias in
	 *         Mexico, Urbanisaciones in Spain.</li></li>
	 *         <li>Complete Locality 1: Primary place name. Typically a �province is subdivided into localities. Some
	 *         countries may contain yet another hierarchy level for subdividing provinces. Examples are counties in the
	 *         US and Kreise in Germany. City is also stored here often.</li>
	 *         <li>Country Standard Province 1: State, province, canton, prefecture or other sub-division of a country.</li>
	 *         <li>Unformatted Postal Code: Postal code or ZIP code.</li>
	 *         <li>CountryCode: ISO2 Country Code</li>
	 *         <li>Fault Code</li>
	 *         <li>Fault Text</li>
	 *         <li>Status Code</li>
	 *         <li>Status Text</li>
	 *         <li>Not used</li>
	 *         <li>Unrecognized Residue 1</li>
	 *         <li>Unrecognized Residue 2</li>
	 *         <li>Not used</li>
	 *         <li>Not used</li>
	 *         <li>Result percentage</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         <li>NOT USED</li>
	 *         </ol>
	 * @return
	 */
	public List<String> analyzeDiscreteAddress(List<String> input) {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Input address: {}", input);
		List<String> result = emptyList(outputSize);
		String certifiedStatusCode = "";
		String defaultStatusCode = "";

		new Verifier().isNotNull(input, "Input must not be null").throwIfError();
		new Verifier().isTrue((input.size() == discreteSizeMin || input.size() == discreteSizeMax),	"String array must be of size %s or %s", discreteSizeMin, discreteSizeMax).throwIfError();
		new Verifier().isFalse(isNullOrEmpty(input), "Entire input is empty.").throwIfError();

		registerDiscreteContingencyExceptions(input, result);

		// if their are no contingency exceptions, then continue
		if (result.get(23) == null || result.get(23).isEmpty()) {
			result = process(input, legacyCertifiedModeParametersXmlString, false);
			certifiedStatusCode = (result == null) ? "" : result.get(23);
			
			if(certifiedStatusCode.equals("E000") || isCountryInCertifiedExclusionList(result)) {
				logger.debug("CERTIFIED mode unsuccessful or country in exclusion list for discrete address {}, using BATCH-INTERACTIVE mode.", input.toString());
				result = process(input, legacyDefaultParametersXmlString, false);
				defaultStatusCode = (result == null) ? "" : result.get(23);
			}

			if (defaultStatusCode.equals("E000")) {
				logger.debug("BATCH-INTERACTIVE mode unsuccessful for discrete address {}, widening optimization level.", input.toString());
				result = process(input, legacyWideOptimizationModeParametersXmlString, false);
			}
		}
		
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

	private void mapDiscreteInputToAddressObject(List<String> input, AddressObject addressObject)
			throws AddressDoctorException {
		if (!isNullOrEmpty(input.get(0))) {
			addressObject.setInputAddressElement("Building", 1, "COMPLETE", input.get(0));
		}

		if (!isNullOrEmpty(input.get(1))) {
			addressObject.setInputAddressElement("SubBuilding", 1, "COMPLETE", input.get(1));
		}

		if (!isNullOrEmpty(input.get(2))) {
			addressObject.setInputAddressLine("DeliveryAddressLine", 1, input.get(2));
		}

		if (!isNullOrEmpty(input.get(3))) {
			addressObject.setInputAddressElement("DeliveryService", 1, "COMPLETE", input.get(3));
		}

		if (!isNullOrEmpty(input.get(4))) {
			addressObject.setInputAddressElement("Locality", 3, "COMPLETE", input.get(4));
		}

		if (!isNullOrEmpty(input.get(5))) {
			addressObject.setInputAddressElement("Locality", 2, "COMPLETE", input.get(5));
		}

		if (!isNullOrEmpty(input.get(6))) {
			addressObject.setInputAddressElement("Locality", 1, "COMPLETE", input.get(6));
		}

		if (!isNullOrEmpty(input.get(7))) {
			addressObject.setInputAddressElement("Province", 2, "COUNTRY_STANDARD", input.get(7));
		}

		if (!isNullOrEmpty(input.get(8))) {
			addressObject.setInputAddressElement("Province", 1, "ABBREVIATION", input.get(8));
		}

		if (!isNullOrEmpty(input.get(9))) {
			addressObject.setInputAddressElement("Province", 1, "COUNTRY_STANDARD", input.get(9));
		}

		if (!isNullOrEmpty(input.get(10))) {
			addressObject.setInputAddressElement("Street", 2, "COMPLETE", input.get(10));
		}

		if (!isNullOrEmpty(input.get(11))) {
			addressObject.setInputAddressElement("PostalCode", 1, "UNFORMATTED", input.get(11));
		}

		if (!isNullOrEmpty(input.get(12))) {
			addressObject.setInputAddressElement("Country", 1, "NAME", input.get(12));
		}

	}

	/**
	 * Ping server and interact with the address doctor engine to make sure that connection is healthy.
	 * 
	 * @return indication that address doctor engine is responding
	 */
	public boolean pingServer() {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		boolean systemHealthy = true;
		String version = addressDoctorEngine.getVersion();
		logger.debug("pingServer(): Version number returned: {}", version);
		if (version == null) {
			systemHealthy = false;
		}
		logger.debug("RETURN: {}", sw.toString());
		return systemHealthy;
	}

	private List<String> from(AddressObject addressObject) throws AddressDoctorException {
		int resultCount = addressObject.getResultCount();
		logger.debug("Output XML: {}", addressObject.getResultXML());

		List<String> result = emptyList(outputSize);

		if (resultCount > 0) {
			// Building
			if (addressObject.getResultAddressElementItemCount(1, "Building") > 0) {
				result.set(0, addressObject.getResultAddressElement(1, "Building", 1, "COMPLETE"));
			}

			// StreetDesignatorName
			if (addressObject.getResultAddressElementItemCount(1, "SubBuilding") > 0) {
				result.set(1, addressObject.getResultAddressElement(1, "SubBuilding", 1, "COMPLETE"));

			}

			// StreetAddressName
			if (addressObject.getResultAddressLineCount(1, "DeliveryAddressLine") > 0) {
				result.set(2, addressObject.getResultAddressLine(1, "DeliveryAddressLine", 1));
			}

			// PostBoxNumber
			if (addressObject.getResultAddressElementItemCount(1, "DeliveryService") > 0) {
				result.set(3, addressObject.getResultAddressElement(1, "DeliveryService", 1, "NUMBER"));
			}

			// CitySubAreaName / CityAreaName / CityName
			int localityCount = addressObject.getResultAddressElementItemCount(1, "Locality");
			if (localityCount > 2) {
				result.set(4, addressObject.getResultAddressElement(1, "Locality", 3, "COMPLETE"));
			}

			if (localityCount > 1) {
				result.set(5, addressObject.getResultAddressElement(1, "Locality", 2, "COMPLETE"));
			}

			if (localityCount > 0) {
				result.set(6, addressObject.getResultAddressElement(1, "Locality", 1, "COMPLETE"));
			}

			// GeoSubAreaName / GeoAreaAbbrName / GeoAreaName
			int provinceCount = addressObject.getResultAddressElementItemCount(1, "Province");
			if (provinceCount > 1) {
				result.set(7, addressObject.getResultAddressElement(1, "Province", 2, "COUNTRY_STANDARD"));
			}

			if (provinceCount > 0) {
				result.set(8, addressObject.getResultAddressElement(1, "Province", 1, "ABBREVIATION"));
				result.set(9, addressObject.getResultAddressElement(1, "Province", 1, "COUNTRY_STANDARD"));
			}

			// PostAddressName
			if (addressObject.getResultAddressElementItemCount(1, "Street") > 1) {
				result.set(10, addressObject.getResultAddressElement(1, "Street", 2, "COMPLETE"));
			}

			// PostCode
			if (addressObject.getResultAddressElementItemCount(1, "PostalCode") > 0) {
				result.set(11, addressObject.getResultAddressElement(1, "PostalCode", 1, "FORMATTED"));
			}

			// PostBoxLabel
			// TODO Fix this one
			if (addressObject.getResultAddressElementItemCount(1, "DeliveryService") > 0) {
				result.set(12, addressObject.getResultAddressElement(1, "DeliveryService", 1, "DESCRIPTOR"));

			}

			// CountryCode
			if (addressObject.getResultAddressElementItemCount(1, "Country") > 0) {
				result.set(13, addressObject.getResultAddressElement(1, "Country", 1, "ISO2"));
			}

			// StreetAddrLine1 / StreetAddrLine2 / StreetAddrLine3
			int deliveryAddressLineCount = addressObject.getResultAddressLineCount(1, "DeliveryAddressLine");
			if (deliveryAddressLineCount > 0) {
				result.set(14, addressObject.getResultAddressLine(1, "DeliveryAddressLine", 1));
			}
			if (deliveryAddressLineCount > 1) {
				result.set(15, addressObject.getResultAddressLine(1, "DeliveryAddressLine", 2));
			}
			if (deliveryAddressLineCount > 2) {
				result.set(16, addressObject.getResultAddressLine(1, "DeliveryAddressLine", 3));
			}

			// CitySubAreaName / CityAreaName / CityName
			if (localityCount > 2) {
				result.set(17, addressObject.getResultAddressElement(1, "Locality", 3, "COMPLETE"));
			}

			if (localityCount > 1) {
				result.set(18, addressObject.getResultAddressElement(1, "Locality", 2, "COMPLETE"));
			}

			if (localityCount > 0) {
				result.set(19, addressObject.getResultAddressElement(1, "Locality", 1, "COMPLETE"));
			}

			// GeoAreaName
			if (provinceCount > 0) {
				result.set(20, addressObject.getResultAddressElement(1, "Province", 1, "COUNTRY_STANDARD"));
			}

			// PostCode
			if (addressObject.getResultAddressElementItemCount(1, "PostalCode") > 0) {
				result.set(21, addressObject.getResultAddressElement(1, "PostalCode", 1, "FORMATTED"));
			}

			// CountryCode
			if (addressObject.getResultAddressElementItemCount(1, "Country") > 0) {
				result.set(22, addressObject.getResultAddressElement(1, "Country", 1, "ISO2"));
			}

			// StatusCode
			String inputStatus = addressObject.getResultDataParameter(1, "ElementInputStatus");
			String resultStatus = addressObject.getResultDataParameter(1, "ElementResultStatus");

			result.set(25, inputStatus + "," + resultStatus);

			// StatusText
			result.set(26, new ElementInputStatus(inputStatus).toString() + "\n"
					+ new ElementResultStatus(resultStatus).toString());

			// NPSecAddr

			// Remainder1
			int residueCount = addressObject.getResultAddressElementItemCount(1, "Residue");
			if (residueCount > 0) {
				result.set(28, addressObject.getResultAddressElement(1, "Residue", 1, "UNRECOGNIZED"));
			}

			// Remainder2
			if (residueCount > 1) {
				result.set(29, addressObject.getResultAddressElement(1, "Residue", 2, "UNRECOGNIZED"));
			}

			// AssignmentType
			result.set(30, "NO Mapping");

			// AddressType
			result.set(31, "NO Mapping");

			// MatchPotential
			result.set(32, addressObject.getResultDataParameter(1, "ResultPercentage"));
		}
		
		if (addressObject.getResultEnrichmentElementExists(1, "SupplementaryUS")) {
			result.set(33, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "COUNTY_FIPS_CODE"));
			result.set(34, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "STATE_FIPS_CODE"));
			result.set(35, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "MSA_ID"));
			result.set(36, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "CBSA_ID"));
			result.set(37, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "FINANCE_NUMBER"));
			result.set(38, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "RECORD_TYPE"));
			result.set(39, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "CMSA_ID"));
			result.set(40, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "CENSUS_TRACT_NO"));
			result.set(41, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "CENSUS_BLOCK_NO"));
			result.set(42, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "CENSUS_BLOCK_GROUP"));
			result.set(43, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "PMSA_ID"));
			result.set(44, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "PLACE_FIPS_CODE"));
			result.set(45, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "TIME_ZONE_CODE"));
			result.set(46, addressObject.getResultEnrichmentElement(1, "SupplementaryUS", "TIME_ZONE_NAME"));
		}

		// FaultCode
		LegacyProcessStatus status = LegacyProcessStatus.valueOf(addressObject.getResultParameter("ProcessStatus"));
		result.set(23, status.getMappedStatusCode());
		// FaultText
		result.set(24, status.getStatusText());

		return result;
	}

	private boolean isNullOrEmpty(List<String> input) {
		boolean isNullOrEmpty = true;
		if (input != null) {
			Iterator<String> iterator = input.iterator();
			while (iterator.hasNext() && isNullOrEmpty) {
				isNullOrEmpty = isNullOrEmpty(iterator.next());
			}
		}
		return isNullOrEmpty;
	}

	private boolean isNullOrEmpty(String input) {
		boolean nullOrEmpty = true;
		if (input != null && !input.equals("")) {
			nullOrEmpty = false;
		}
		return nullOrEmpty;
	}

	private List<String> emptyList(int size) {
		List<String> returnList = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			returnList.add("");
		}
		return returnList;
	}

	private boolean isBetween(int val, int low, int high, boolean inclusive) {
		boolean isBetween = false;
		if (inclusive) {
			isBetween = (val >= low && val <= high) ? true : false;
		} else {
			isBetween = (val > low && val < high) ? true : false;
		}
		return isBetween;
	}

	private boolean isCountrySpecifiedInHybrid(List<String> input) {
		boolean countrySpecified = false;
		countrySpecified = (input.get(7) == null || input.get(7).equals("")) ? false : true;
		return countrySpecified;
	}

	private boolean isCountrySpecifiedInDiscrete(List<String> input) {
		boolean countrySpecified = false;
		countrySpecified = (input.get(12) == null || input.get(12).equals("")) ? false : true;
		return countrySpecified;
	}

	private void registerHybridContingencyExceptions(List<String> input, List<String> result) {
		if (!isCountrySpecifiedInHybrid(input)) {
			result.add(23, "E275");
			result.add(24, "No country was specified.");
		}
	}

	private void registerDiscreteContingencyExceptions(List<String> input, List<String> result) {
		if (!isCountrySpecifiedInDiscrete(input)) {
			result.add(23, "E275");
			result.add(24, "No country was specified.");
		}
	}

	private List<String> process(List<String> input, String parms, boolean hybridMode) {
		List<String> result = null;
		AddressObject addressObject = addressDoctorEngine.borrowObject();
		try {
			addressObject.setParametersXML(parms, null);
			if (hybridMode) {
				mapHybridInputToAddressObject(input, addressObject);
			} else {
				mapDiscreteInputToAddressObject(input, addressObject);
			}
			addressDoctorEngine.process(addressObject);
			result = from(addressObject);
			logger.debug(addressObject.getResultXML());
			logger.debug("Mode Used: {}", addressObject.getResultParameter("ModeUsed"));
		} catch (AddressDoctorException e) {
			logger.error(e.getExtendedMessage());
			result = new AddressDoctorExceptionResolver().resolve(e);
		} finally {
			addressDoctorEngine.returnObject(addressObject);
		}
		return result;

	}
	
	private boolean isCountryInCertifiedExclusionList(List<String> result){
		List<String> excludeList = Arrays.asList("FR");
		boolean isExcludedCountry = false;
		String parsedCountry = (result == null) ? "" : result.get(13);
		for (String country : excludeList) {
			if(parsedCountry.equalsIgnoreCase(country)){
				isExcludedCountry = true;
				logger.debug("{} on exclude list.", parsedCountry);
				break;
			}
		}
		return isExcludedCountry;
	}

}
