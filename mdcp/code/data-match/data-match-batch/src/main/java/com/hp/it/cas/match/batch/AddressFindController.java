package com.hp.it.cas.match.batch;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.BeanToCsv;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.cas.data.businessService.LockContext;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.io.adapter.IoFiles;
import com.hp.it.cas.io.adapter.IoPath;
import com.hp.it.cas.io.adapter.IoPaths;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;
import com.hp.it.cas.match.address.rest.AddressSuggestionsAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.CertifiedAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.FastCompletionAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy;
import com.hp.it.cas.match.address.utilities.StringUtils;
import com.hp.it.cas.match.batch.opencsv.bean.AddressDoctorBeanToCsv;
import com.hp.it.cas.match.batch.utilities.Constant;
import com.hp.it.cas.match.batch.utilities.MailHelper;
import com.hp.it.cas.match.batch.utilities.ValidInputData;
import com.hp.it.cas.xa.security.SecurityContextHolder;

/**
 * 1. Each line in the input file call AD service and got the result 2. Save the
 * query and the result in the FEZ output file 3. Send notification email to
 * specified customer of each InputFile
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressFindController implements TransactionController<AddressFind, Void> {
	private static final String ADDRESSDOCTOR_FEZOUTPUTPATH = "addressDoctorFEZOutputPath";
	private static final String ADDRESSDOCTOR_ENV = "addressDoctorEnv";
	private final String addressDoctorEnv;
	private final String addressDoctorFEZOutputPath;
	private final Logger logger = LoggerFactory.getLogger(AddressFindController.class);

	private enum Function {
		looselyValidatedAddress, addressSuggestions, fastCompletionAddress, certifiedAddress, validatedAddress
	};

	/*
	 * temporary variable to save the INPUT and Result for each Input file,
	 * email and outputFileName.
	 */
	private Map<AddressFind, AddressQueryResult> outputMap = new LinkedHashMap<AddressFind, AddressQueryResult>();
	private List<String> emailList = null;
	private String outputFileName;
	private URI outputFileUri;

	public AddressFindController(Configuration configuration) {
		this.addressDoctorEnv = configuration.getJobParameters().get(ADDRESSDOCTOR_ENV);
		this.addressDoctorFEZOutputPath = configuration.getJobParameters().get(ADDRESSDOCTOR_FEZOUTPUTPATH);
	}

	@Override
	public Void process(AddressFind addressFind, MessageContext messageContext, LockContext lockContext) throws Exception {

		/* empty file */
		if (addressFind == null) {
			logger.error("There is an empty file, and just moved it to WIP without processing。");
			return null;
		}

		/* temporary save outputFileName */
		if (outputFileName == null && addressFind.getOutputFileName() != null) {
			outputFileName = addressFind.getOutputFileName();
			return null;
		}

		AddressInput addressInput = addressFind.getAddressInput();
		if (addressInput != null) {
			if (validInputData(addressFind, addressInput)){
				AddressQueryResult result = callADService(addressFind);
				outputMap.put(addressFind, result);
			}

		} else {
			/* save empty data */
			outputMap.put(addressFind, null);
		}

		/* outputFileName + email --> send email */
		if (outputFileName != null && addressFind.getEmailList() != null) {
			emailList = addressFind.getEmailList();
			saveOutputRecord();
			sendEmail();

			/* clear temporary variable */
			outputMap.clear();
			emailList = null;
			outputFileName = null;
			return null;
		}

		return null;
	}

	private boolean validInputData(AddressFind addressFind, AddressInput addressInput) {
		String mode = StringUtils.isNullOrEmpty(addressInput.getModeUsed()) ? addressInput.getModeUsed() : addressInput.getModeUsed().trim();
		if (StringUtils.isNullOrEmpty(mode)) {
			addressFind.setErrorMessage("The modeUsed can't be null. The value should be in the list of {" + ValidInputData.ModeUsed.getModeNames() + "}.");
			outputMap.put(addressFind, null);
			return false;
		} else if (!ValidInputData.ModeUsed.isValidMode(mode)) {
			addressFind.setErrorMessage("The modeUsed(" + mode + ") is invalid. The value should be in the list of {" + ValidInputData.ModeUsed.getModeNames() + "}.");
			outputMap.put(addressFind, null);
			return false;
		}
		
		String preferredLanguage = StringUtils.isNullOrEmpty(addressInput.getPreferredLanguage()) ? addressInput.getPreferredLanguage() : addressInput.getPreferredLanguage().trim();
		if (StringUtils.isNullOrEmpty(preferredLanguage)){
			addressFind.setErrorMessage("The preferredLanguage is invalid. The value should be in the list of {" + ValidInputData.PreferredLanguage.getPreferredLanguageNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		} else if (!ValidInputData.PreferredLanguage.isValidPreferredLanguage(preferredLanguage)){
			addressFind.setErrorMessage("The preferredLanguage is invalid. The value should be in the list of {" + ValidInputData.PreferredLanguage.getPreferredLanguageNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		}
		
		String preferredScript = StringUtils.isNullOrEmpty(addressInput.getPreferredScript()) ? addressInput.getPreferredScript() : addressInput.getPreferredScript().trim();
		if (StringUtils.isNullOrEmpty(preferredScript)){
			addressFind.setErrorMessage("The preferredScript is invalid. The value should be in the list of {" + ValidInputData.PreferredScript.getPreferredScriptNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		} else if (!ValidInputData.PreferredScript.isValidPreferredScript(preferredScript)){
			addressFind.setErrorMessage("The preferredScript is invalid. The value should be in the list of {" + ValidInputData.PreferredScript.getPreferredScriptNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		}
		
		String characterScriptDetectionIndicator = StringUtils.isNullOrEmpty(addressInput.getCharacterScriptDetectionIndicator()) ? addressInput.getCharacterScriptDetectionIndicator() : addressInput.getCharacterScriptDetectionIndicator().trim();
		if (StringUtils.isNullOrEmpty(characterScriptDetectionIndicator)){
			addressFind.setErrorMessage("The characterScriptDetectionIndicator is an invalid boolean value. The value should be TRUE or FALSE.");
			outputMap.put(addressFind, null);
			return false;
		} else if (!("TRUE".equalsIgnoreCase(characterScriptDetectionIndicator) || "FALSE".equalsIgnoreCase(characterScriptDetectionIndicator))) {
			addressFind.setErrorMessage("The characterScriptDetectionIndicator is an invalid boolean value. The value should be TRUE or FALSE.");
			outputMap.put(addressFind, null);
			return false;
		}
		
		return true;
	}

	/**
	 * Call AD service.
	 * 
	 * @param addressFind
	 *            AddressFind
	 * @return result AddressQueryResult
	 */
	private AddressQueryResult callADService(AddressFind addressFind) {
		Principal principal = SecurityContextHolder.getInstance().getAuditPrincipal();

		SecurityContextTestController securityController = new SecurityContextTestController();
		securityController.collectAndSetupSecurityContext(new ClientTestEnvironment("w-mdcp:prd-http", null, null));
		AddressQueryResult result = findAddress(addressFind);

		/* when run the job got NullPointerException of principal */
		SecurityContextHolder.getInstance().addContext(principal);
		return result;
	}

	/**
	 * Each address query call AD service with its specified function.
	 * 
	 * @param addressFind
	 *            AddressFind
	 * @return AddressQueryResult
	 */
	private AddressQueryResult findAddress(AddressFind addressFind) {
		AddressQueryResult result = null;

		String endpoint = addressDoctorEnv;
		
		AddressInput addressInput = addressFind.getAddressInput();
		AddressQuery query = new AddressQuery();
		BeanUtils.copyProperties(addressInput, query, new String[] { "characterScriptDetectionIndicator" });
		query.setCharacterScriptDetectionIndicator(Boolean.valueOf(addressInput.getCharacterScriptDetectionIndicator()));
		
		String mode = StringUtils.isNullOrEmpty(addressInput.getModeUsed()) ? addressInput.getModeUsed() : addressInput.getModeUsed().trim();
		try {
			if (ValidInputData.ModeUsed.BATCH.name().equals(mode)) {
				// TODO not sure map with which function
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputData.ModeUsed.INTERACTIVE.name().equals(mode)) {
				endpoint += Function.addressSuggestions.name();
				AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(endpoint);
				result = proxy.suggest(query);
			} else if (ValidInputData.ModeUsed.FASTCOMPLETION.name().equals(mode)) {
				endpoint += Function.fastCompletionAddress.name();
				FastCompletionAddressFinderRestProxy proxy = new FastCompletionAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputData.ModeUsed.CERTIFIED.name().equals(mode)) {
				endpoint += Function.certifiedAddress.name();
				CertifiedAddressFinderRestProxy proxy = new CertifiedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputData.ModeUsed.PARSE.name().equals(mode)) {
				// TODO not sure map with which function
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputData.ModeUsed.COUNTRYRECOGNITION.name().equals(mode)) {
				// TODO not sure map with which function
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			}
		} catch (Exception e) {
			addressFind.setErrorMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * send email to customer
	 */
	public void sendEmail() {
		StringBuffer emailTo = new StringBuffer("");
		for (int i = 0; i < emailList.size(); i++) {
			if (i == 0) {
				emailTo.append(emailList.get(i));
			} else {
				emailTo.append("," + emailList.get(i));
			}
		}

		String inputFileName = outputFileName.substring(0, outputFileName.indexOf("_OUTPUT")) + ".csv";

		String emailSubject = "[Address Doctor Batch Services] Notification of completion - " + inputFileName;

		StringBuffer bufText = new StringBuffer("<html>");
		bufText.append("<head>");
		bufText.append("</head>");
		bufText.append("<body>");
		bufText.append("Hello,");
		bufText.append("<br><br>");

		bufText.append(" Please find at ");
		bufText.append("<a href='" + outputFileUri + "'>" + outputFileUri + "</a>");
		bufText.append(" the results of the processing of the file ");
		bufText.append(inputFileName);
		bufText.append(" you have submitted to Address Doctor Batch Services.");

		bufText.append("<br><br>");
		bufText.append("For proper handling of non-Latin characters, please avoid double-clicking on the downloaded file when Microsoft Excel is the program associated to the .csv file type.");
		bufText.append("<br>");
		bufText.append("Instead, please use one of the file opening approaches documented in the training material.");
		bufText.append("<br>");
		bufText.append("For example, you can alternatively:");
		bufText.append("<br>");
		bufText.append("&nbsp;&nbsp;&nbsp;&nbsp;1.&nbsp;Start Microsoft Excel and click on Menu Item Data => From Text and select ‘File Origin: 65001:Unicode (UTF-8)’;");
		bufText.append("<br>");
		bufText.append("&nbsp;&nbsp;&nbsp;&nbsp;2.&nbsp;Start Apache OpenOffice and select ‘Character Set: Unicode (UTF-8)’in Text Import Wizard.");

		bufText.append("<br><br>");
		bufText.append("Thanks.");
		bufText.append("<br>");
		bufText.append("Best regards. ");
		bufText.append("<br>");
		bufText.append("</body>");
		bufText.append("</html>");

		Map<String, String> data = new HashMap<String, String>();
		data.put("EMAIL_TO", emailTo.toString());
		data.put("EMAIL_SUBJECT", emailSubject);
		data.put("EMAIL_TEXT", bufText.toString());

		try {
			MailHelper.sendEmail(data);
		} catch (Exception e) {
			String message = String.format("Error occured when sending mail.");
			throw new RuntimeException(message, e);
		} finally {
			/* clear temporary variable */
			outputFileUri = null;
		}
	}

	/* write output file with opencsv */
	private void saveOutputRecord() {

		/* get output file Header */
		ColumnPositionMappingStrategy<OutputRecord> strategy = new ColumnPositionMappingStrategy<OutputRecord>();
		BeanToCsv<OutputRecord> beanToCsv = new AddressDoctorBeanToCsv();

		strategy.setType(OutputRecord.class);
		strategy.setColumnMapping(Constant.OUTPUT_CSV_HEADER_LINE_2);

		/* Parse the OutputRecord */
		CSVWriter csvWriter = null;
		try {
			IoPath path = IoPaths.get(new URI(addressDoctorFEZOutputPath + outputFileName));
			if (IoFiles.exists(path)) {
				IoFiles.delete(path);
			}
			path = IoFiles.createFile(path);
			outputFileUri = path.toUri();
			csvWriter = new CSVWriter(IoFiles.newBufferedWriter(path, Charset.forName("UTF-8")));
			csvWriter.writeNext(Constant.OUTPUT_CSV_HEADER_LINE_1);
			beanToCsv.write(strategy, csvWriter, retriveOutputRecord());
		} catch (URISyntaxException uriException) {
			String message = String.format("Could not create URI for input URL '%s'.", addressDoctorFEZOutputPath + outputFileName);
			throw new RuntimeException(message, uriException);
		} catch (IOException ioException) {
			String message = String.format("Error occured when writing the output file '%s'.", addressDoctorFEZOutputPath + outputFileName);
			throw new RuntimeException(message, ioException);
		} finally {
			try {
				if (csvWriter != null) {
					csvWriter.close();
				}
			} catch (IOException ioException) {
				String message = String.format("Unable to close the writer.");
				throw new RuntimeException(message, ioException);
			}
		}
	}

	private List<OutputRecord> retriveOutputRecord() {
		List<OutputRecord> listOutputRecord = new ArrayList<OutputRecord>();
		Set<AddressFind> keySet = outputMap.keySet();
		for (AddressFind addressFind : keySet) {
			AddressQueryResult result = outputMap.get(addressFind);
			OutputRecord outputRecord = new OutputRecord();
			if (addressFind != null) {
				BeanUtils.copyProperties(addressFind, outputRecord);
				if (addressFind.getAddressInput() != null) {
					BeanUtils.copyProperties(addressFind.getAddressInput(), outputRecord);
				}
			}

			if (result != null) {
				BeanUtils.copyProperties(result, outputRecord, new String[]{"countOverFlow"});
				outputRecord.setMode_Used(result.getModeUsed());
				outputRecord.setCountry_ISO3(result.getIso3());
				outputRecord.setCountOverFlow(result.isCountOverFlow() ? "true" : "false");
				retriveAddressData(outputRecord, result.getAddressData().get(0));
			}
			listOutputRecord.add(outputRecord);
		}
		return listOutputRecord;
	}

	private void retriveAddressData(OutputRecord outputRecord, AddressData addressData) {
		BeanUtils.copyProperties(addressData, outputRecord);

		outputRecord.getMethodWithSameSuffix("Key", outputRecord, addressData.getKeys(), "RECORD_ID");
		outputRecord.getMethodWithSameSuffix("Key", outputRecord, addressData.getKeys(), "TRANSACTION_KEY");

		outputRecord.getMethodWithSameSuffix("Locality", outputRecord, addressData.getLocalities(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("PostalCode", outputRecord, addressData.getPostalCodes(), "FORMATTED");
		outputRecord.getMethodWithSameSuffix("Province", outputRecord, addressData.getProvinces(), "COUNTRY_STANDARD");
		outputRecord.getMethodWithSameSuffix("Street", outputRecord, addressData.getStreets(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("Number", outputRecord, addressData.getNumbers(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("Building", outputRecord, addressData.getBuildings(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("SubBuilding", outputRecord, addressData.getSubBuildings(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("DeliverService", outputRecord, addressData.getDeliveryServices(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("Organization", outputRecord, addressData.getOrganizations(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("Contact", outputRecord, addressData.getContacts(), "COMPLETE");
		outputRecord.getMethodWithSameSuffix("Residue", outputRecord, addressData.getResidues(), "UNRECOGNIZED");

		outputRecord.getMethodWithDiffLine("RecipientLine", outputRecord, addressData.getRecipientLines());
		outputRecord.getMethodWithDiffLine("DeliveryAddressLine", outputRecord, addressData.getDeliveryAddressLines());
		outputRecord.getMethodWithDiffLine("CountrySpecificLocalityLine", outputRecord, addressData.getCountrySpecificLocalityLines());
		outputRecord.getMethodWithDiffLine("FormattedAddressLine", outputRecord, addressData.getFormattedAddressLines());

		retriveCountries(outputRecord, convertAddressElementToMap(addressData.getCountries()));
		retriveLocalities(outputRecord, convertAddressElementToMap(addressData.getLocalities()));
		retrivePostalCodes(outputRecord, convertAddressElementToMap(addressData.getPostalCodes()));
		retriveProvinces(outputRecord, convertAddressElementToMap(addressData.getProvinces()));
		retriveStreets(outputRecord, convertAddressElementToMap(addressData.getStreets()));
		retriveNumbers(outputRecord, convertAddressElementToMap(addressData.getNumbers()));
		retriveBuildings(outputRecord, convertAddressElementToMap(addressData.getBuildings()));
		retriveSubBuildings(outputRecord, convertAddressElementToMap(addressData.getSubBuildings()));
		retriveDeliveryServices(outputRecord, convertAddressElementToMap(addressData.getDeliveryServices()));
		retriveOrganizations(outputRecord, convertAddressElementToMap(addressData.getOrganizations()));
		retriveContacts(outputRecord, convertAddressElementToMap(addressData.getContacts()));
		retriveResidues(outputRecord, convertAddressElementToMap(addressData.getResidues()));

	}

	public Map<String, String> convertAddressElementToMap(List<AddressElement> addressElementList) {
		Map<String, String> addressElementMap = new HashMap<String, String>();
		for (AddressElement element : addressElementList) {
			addressElementMap.put(element.getType(), element.getValue());
		}
		return addressElementMap;
	}

	/**
	 * <ul>
	 * <li>country1_ABBREVIATION</li>
	 * <li>country1_ISO2</li>
	 * <li>country1_ISO3</li>
	 * <li>country1_ISO_NUMBER</li>
	 * <li>country1_NAME_CN</li>
	 * <li>country1_NAME_DA</li>
	 * <li>country1_NAME_DE</li>
	 * <li>country1_NAME_EN</li>
	 * <li>country1_NAME_ES</li>
	 * <li>country1_NAME_FI</li>
	 * <li>country1_NAME_FR</li>
	 * <li>country1_NAME_GR</li>
	 * <li>country1_NAME_HU</li>
	 * <li>country1_NAME_IT</li>
	 * <li>country1_NAME_JP</li>
	 * <li>country1_NAME_KR</li>
	 * <li>country1_NAME_NL</li>
	 * <li>country1_NAME_PL</li>
	 * <li>country1_NAME_PT</li>
	 * <li>country1_NAME_RU</li>
	 * <li>country1_NAME_SA</li>
	 * <li>country1_NAME_SE</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param countriesMap
	 */
	public void retriveCountries(OutputRecord outputRecord, Map<String, String> countriesMap) {
		outputRecord.setCountry1_ABBREVIATION(countriesMap.get("ABBREVIATION"));
		outputRecord.setCountry1_ISO2(countriesMap.get("ISO2"));
		outputRecord.setCountry1_ISO3(countriesMap.get("ISO3"));
		outputRecord.setCountry1_ISO_NUMBER(countriesMap.get("ISO_NUMBER"));
		outputRecord.setCountry1_NAME_CN(countriesMap.get("NAME_CN"));
		outputRecord.setCountry1_NAME_DA(countriesMap.get("NAME_DA"));
		outputRecord.setCountry1_NAME_DE(countriesMap.get("NAME_DE"));
		outputRecord.setCountry1_NAME_EN(countriesMap.get("NAME_EN"));
		outputRecord.setCountry1_NAME_ES(countriesMap.get("NAME_ES"));
		outputRecord.setCountry1_NAME_FI(countriesMap.get("NAME_FI"));
		outputRecord.setCountry1_NAME_FR(countriesMap.get("NAME_FR"));
		outputRecord.setCountry1_NAME_GR(countriesMap.get("NAME_GR"));
		outputRecord.setCountry1_NAME_HU(countriesMap.get("NAME_HU"));
		outputRecord.setCountry1_NAME_IT(countriesMap.get("NAME_IT"));
		outputRecord.setCountry1_NAME_JP(countriesMap.get("NAME_JP"));
		outputRecord.setCountry1_NAME_KR(countriesMap.get("NAME_KR"));
		outputRecord.setCountry1_NAME_NL(countriesMap.get("NAME_NL"));
		outputRecord.setCountry1_NAME_PL(countriesMap.get("NAME_PL"));
		outputRecord.setCountry1_NAME_PT(countriesMap.get("NAME_PT"));
		outputRecord.setCountry1_NAME_RU(countriesMap.get("NAME_RU"));
		outputRecord.setCountry1_NAME_SA(countriesMap.get("NAME_SA"));
		outputRecord.setCountry1_NAME_SE(countriesMap.get("NAME_SE"));
	}

	/**
	 * <ul>
	 * <li>locality1_NAME</li>
	 * <li>locality1_PREFERRED_NAME</li>
	 * <li>locality1_SORTING_CODE</li>
	 * <li>locality1_ADD_INFO</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param localitiesMap
	 */
	public void retriveLocalities(OutputRecord outputRecord, Map<String, String> localitiesMap) {
		outputRecord.setLocality1_NAME(localitiesMap.get("NAME"));
		outputRecord.setLocality1_PREFERRED_NAME(localitiesMap.get("PREFERRED_NAME"));
		outputRecord.setLocality1_SORTING_CODE(localitiesMap.get("SORTING_CODE"));
		outputRecord.setLocality1_ADD_INFO(localitiesMap.get("ADD_INFO"));

	}

	/**
	 * <ul>
	 * <li>postalCode1_UNFORMATTED</li>
	 * <li>postalCode1_BASE</li>
	 * <li>postalCode1_ADD_ON</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param postalCodesMap
	 */
	public void retrivePostalCodes(OutputRecord outputRecord, Map<String, String> postalCodesMap) {
		outputRecord.setPostalCode1_UNFORMATTED(postalCodesMap.get("UNFORMATTED"));
		outputRecord.setPostalCode1_BASE(postalCodesMap.get("BASE"));
		outputRecord.setPostalCode1_ADD_ON(postalCodesMap.get("ADD_ON"));
	}

	/**
	 * <ul>
	 * <li>province1_ABBREVIATION</li>
	 * <li>province1_EXTENDED</li>
	 * <li>province1_ISO</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param provincesMap
	 */
	private void retriveProvinces(OutputRecord outputRecord, Map<String, String> provincesMap) {
		outputRecord.setProvince1_ABBREVIATION(provincesMap.get("ABBREVIATION"));
		outputRecord.setProvince1_EXTENDED(provincesMap.get("EXTENDED"));
		outputRecord.setProvince1_ISO(provincesMap.get("ISO"));
	}

	/**
	 * <ul>
	 * <li>street1_COMPLETE_WITH_NUMBER</li>
	 * <li>street1_NAME</li>
	 * <li>street1_PRE_DESCRIPTOR</li>
	 * <li>street1_POST_DESCRIPTOR</li>
	 * <li>street1_PRE_DIRECTIONAL</li>
	 * <li>street1_POST_DIRECTIONAL</li>
	 * <li>street1_ADD_INFO</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param streetsMap
	 */
	private void retriveStreets(OutputRecord outputRecord, Map<String, String> streetsMap) {
		outputRecord.setStreet1_COMPLETE_WITH_NUMBER(streetsMap.get("COMPLETE_WITH_NUMBER"));
		outputRecord.setStreet1_NAME(streetsMap.get("NAME"));
		outputRecord.setStreet1_PRE_DESCRIPTOR(streetsMap.get("PRE_DESCRIPTOR"));
		outputRecord.setStreet1_POST_DESCRIPTOR(streetsMap.get("POST_DESCRIPTOR"));
		outputRecord.setStreet1_PRE_DIRECTIONAL(streetsMap.get("PRE_DIRECTIONAL"));
		outputRecord.setStreet1_POST_DIRECTIONAL(streetsMap.get("POST_DIRECTIONAL"));
		outputRecord.setStreet1_ADD_INFO(streetsMap.get("ADD_INFO"));
	}

	/**
	 * <ul>
	 * <li>number1_NUMBER</li>
	 * <li>number1_DESCRIPTOR</li>
	 * <li>number1_ADD_INFO</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param numbersMap
	 */
	private void retriveNumbers(OutputRecord outputRecord, Map<String, String> numbersMap) {
		outputRecord.setNumber1_NUMBER(numbersMap.get("NUMBER"));
		outputRecord.setNumber1_DESCRIPTOR(numbersMap.get("DESCRIPTOR"));
		outputRecord.setNumber1_ADD_INFO(numbersMap.get("ADD_INFO"));
	}

	/**
	 * <ul>
	 * <li>building1_COMPLETE_WITH_SUBBUILDING</li>
	 * <li>building1_NAME</li>
	 * <li>building1_NUMBER</li>
	 * <li>building1_DESCRIPTOR</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param buildingsMap
	 */
	public void retriveBuildings(OutputRecord outputRecord, Map<String, String> buildingsMap) {
		outputRecord.setBuilding1_COMPLETE_WITH_SUBBUILDING(buildingsMap.get("COMPLETE_WITH_SUBBUILDING"));
		outputRecord.setBuilding1_NAME(buildingsMap.get("NAME"));
		outputRecord.setBuilding1_NUMBER(buildingsMap.get("NUMBER"));
		outputRecord.setBuilding1_DESCRIPTOR(buildingsMap.get("DESCRIPTOR"));
	}

	/**
	 * <ul>
	 * <li>subBuilding1_NAME</li>
	 * <li>subBuilding1_NUMBER</li>
	 * <li>subBuilding1_DESCRIPTOR</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param subBuildingsMap
	 */
	public void retriveSubBuildings(OutputRecord outputRecord, Map<String, String> subBuildingsMap) {
		outputRecord.setSubBuilding1_NAME(subBuildingsMap.get("NAME"));
		outputRecord.setSubBuilding1_NUMBER(subBuildingsMap.get("NUMBER"));
		outputRecord.setSubBuilding2_DESCRIPTOR(subBuildingsMap.get("DESCRIPTOR"));
	}

	/**
	 * <ul>
	 * <li>deliveryService1_DESCRIPTOR</li>
	 * <li>deliveryService1_NUMBER</li>
	 * <li>deliveryService1_ADD_INFO</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param deliveryServicesMap
	 */
	public void retriveDeliveryServices(OutputRecord outputRecord, Map<String, String> deliveryServicesMap) {
		outputRecord.setDeliveryService1_DESCRIPTOR(deliveryServicesMap.get("DESCRIPTOR"));
		outputRecord.setDeliveryService1_NUMBER(deliveryServicesMap.get("NUMBER"));
		outputRecord.setDeliveryService1_ADD_INFO(deliveryServicesMap.get("ADD_INFO"));
	}

	/**
	 * <ul>
	 * <li>organization1_NAME</li>
	 * <li>organization1_DESCRIPTOR</li>
	 * <li>organization1_DEPARTMENT</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param organizationsMap
	 */
	public void retriveOrganizations(OutputRecord outputRecord, Map<String, String> organizationsMap) {
		outputRecord.setOrganization1_NAME(organizationsMap.get("NAME"));
		outputRecord.setOrganization1_DESCRIPTOR(organizationsMap.get("DESCRIPTOR"));
		outputRecord.setOrganization1_DEPARTMENT(organizationsMap.get("DEPARTMENT"));
	}

	/**
	 * <ul>
	 * <li>contact1_FIRST_NAME</li>
	 * <li>contact1_MIDDLE_NAME</li>
	 * <li>contact1_LAST_NAME</li>
	 * <li>contact1_NAME</li>
	 * <li>contact1_TITLE</li>
	 * <li>contact1_FUNCTION</li>
	 * <li>contact1_SALUTATION</li>
	 * <li>contact1_GENDER</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param contactsMap
	 */
	public void retriveContacts(OutputRecord outputRecord, Map<String, String> contactsMap) {
		outputRecord.setContact1_FIRST_NAME(contactsMap.get("FIRST_NAME"));
		outputRecord.setContact1_MIDDLE_NAME(contactsMap.get("MIDDLE_NAME"));
		outputRecord.setContact1_LAST_NAME(contactsMap.get("LAST_NAME"));
		outputRecord.setContact1_NAME(contactsMap.get("NAME"));
		outputRecord.setContact1_TITLE(contactsMap.get("TITLE"));
		outputRecord.setContact1_FUNCTION(contactsMap.get("FUNCTION"));
		outputRecord.setContact1_SALUTATION(contactsMap.get("SALUTATION"));
		outputRecord.setContact1_GENDER(contactsMap.get("GENDER"));
	}

	/**
	 * <ul>
	 * <li>residue1-NECESSARY</li>
	 * <li>residue1-SUPERFLUOUS</li>
	 * </ul>
	 * 
	 * @param outputRecord
	 * @param residuesMap
	 */
	public void retriveResidues(OutputRecord outputRecord, Map<String, String> residuesMap) {
		outputRecord.setResidue1_NECESSARY(residuesMap.get("NECESSARY"));
		outputRecord.setResidue1_SUPERFLUOUS(residuesMap.get("SUPERFLUOUS"));
	}

}
