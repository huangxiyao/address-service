package com.hp.it.match.batch.AddressFindExcel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

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
import com.hp.it.match.batch.AddressFindExcel.AddressFind;
import com.hp.it.match.batch.AddressFindExcel.bean.AddressInput;
import com.hp.it.match.batch.AddressFindExcel.bean.OutputRecord;
import com.hp.it.match.batch.AddressFindExcel.utilities.BatchUtils;
import com.hp.it.match.batch.AddressFindExcel.utilities.Constant;
import com.hp.it.match.batch.AddressFindExcel.utilities.MailHelper;
import com.hp.it.match.batch.AddressFindExcel.utilities.ValidInputFields;
import com.hp.it.cas.xa.security.SecurityContextHolder;

/**
 * 1. Each line in the input file call AD service and get the result 
 * 2. Save the input data and its result into the specified FEZ output file 
 * 3. Send notification email to specified customer of each InputFile
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressFindExcelController implements TransactionController<AddressFind, Void> {
	private static final String ADDRESSDOCTOR_FEZOUTPUTPATH = "addressDoctorFEZOutputPath";
	private static final String ADDRESSDOCTOR_ENV = "addressDoctorEnv";
	private final String addressDoctorEnv;
	private final String addressDoctorFEZOutputPath;
	private final Logger logger = LoggerFactory.getLogger(AddressFindExcelController.class);

	private enum Function {
		looselyValidatedAddress, addressSuggestions, fastCompletionAddress, certifiedAddress, validatedAddress
	};

	/* temporary variable to save the INPUT data and Result data of each Input file, email address, outputFileName and outputFileUri. */
	private Map<AddressFind, AddressQueryResult> outputMap = new LinkedHashMap<AddressFind, AddressQueryResult>();
	private String outputFileName;
	private URI outputFileUri;

	public AddressFindExcelController(Configuration configuration) {
		this.addressDoctorEnv = configuration.getJobParameters().get(ADDRESSDOCTOR_ENV);
		this.addressDoctorFEZOutputPath = configuration.getJobParameters().get(ADDRESSDOCTOR_FEZOUTPUTPATH);
	}

	@Override
	public Void process(AddressFind addressFind, MessageContext messageContext, LockContext lockContext) throws Exception {

		/* empty file */
		if (addressFind == null) {
			logger.info("Meet an empty file, it will be deleted after processing.");
			return null;
		}
		
		AddressInput addressInput = addressFind.getAddressInput();
		if (addressInput != null) {
			if (validInputFileds(addressFind, addressInput)) {
				AddressQueryResult result = callADService(addressFind);
				addressFind.setAddressInput(addressInput);
				outputMap.put(addressFind, result);
			}
		} else if (! StringUtils.isNullOrEmpty(addressFind.getErrorMessage())){
			/* save empty data */
			outputMap.put(addressFind, null);
		}

		/* temporary save outputFileName */
		if (outputFileName == null && addressFind.getOutputFileName() != null) {
			outputFileName = addressFind.getOutputFileName();
			return null;
		}


		/* when the outputFileName and emailList are both exist, then save the output file and send the notification email */
		if (outputFileName != null && addressFind.getEmailList() != null) {
			List<String> emailList = addressFind.getEmailList();
			saveOutputRecord();
			sendEmail(emailList);

			/* clear temporary variable */
			outputMap.clear();
			outputFileName = null;
			return null;
		}

		return null;
	}

	private boolean validInputFileds(AddressFind addressFind, AddressInput addressInput) {
		String mode = BatchUtils.trimString(addressInput.getModeUsed());
		if (StringUtils.isNullOrEmpty(mode)) {
			addressFind.setErrorMessage("The modeUsed must not be null. The value should be in the list of {" + ValidInputFields.ModeUsed.getModeNames() + "}.");
			outputMap.put(addressFind, null);
			return false;
		} else if (!ValidInputFields.ModeUsed.isValidMode(mode)) {
			addressFind.setErrorMessage("The modeUsed(" + mode + ") is invalid. The value should be in the list of {" + ValidInputFields.ModeUsed.getModeNames() + "}.");
			outputMap.put(addressFind, null);
			return false;
		}

		String preferredLanguage = BatchUtils.trimString(addressInput.getPreferredLanguage());
		if (!ValidInputFields.PreferredLanguage.isValidPreferredLanguage(preferredLanguage)) {
			addressFind.setErrorMessage("The preferredLanguage is invalid. The value should be in the list of {" + ValidInputFields.PreferredLanguage.getPreferredLanguageNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		}

		String preferredScript = BatchUtils.trimString(addressInput.getPreferredScript());
		if (!ValidInputFields.PreferredScript.isValidPreferredScript(preferredScript)) {
			addressFind.setErrorMessage("The preferredScript is invalid. The value should be in the list of {" + ValidInputFields.PreferredScript.getPreferredScriptNames() + "}");
			outputMap.put(addressFind, null);
			return false;
		}

		String characterScriptDetectionIndicator = BatchUtils.trimString(addressInput.getCharacterScriptDetectionIndicator());
		if (!("TRUE".equalsIgnoreCase(characterScriptDetectionIndicator) || "FALSE".equalsIgnoreCase(characterScriptDetectionIndicator))) {
			addressFind.setErrorMessage("The characterScriptDetectionIndicator is an invalid boolean value. The value should be TRUE or FALSE.");
			outputMap.put(addressFind, null);
			return false;
		}

		if (StringUtils.isNullOrEmpty(addressInput.getCountry1())) {
			addressFind.setErrorMessage("The country1 must not be null.");
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
		securityController.collectAndSetupSecurityContext(new ClientTestEnvironment("w-addr-serv:ad-batch", null, null));
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

		String mode = BatchUtils.trimString(addressInput.getModeUsed());
		try {
			if (ValidInputFields.ModeUsed.BATCH.name().equals(mode)) {
				// use default method validatedAddress
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputFields.ModeUsed.INTERACTIVE.name().equals(mode)) {
				endpoint += Function.addressSuggestions.name();
				AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(endpoint);
				result = proxy.suggest(query);
			} else if (ValidInputFields.ModeUsed.FASTCOMPLETION.name().equals(mode)) {
				endpoint += Function.fastCompletionAddress.name();
				FastCompletionAddressFinderRestProxy proxy = new FastCompletionAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputFields.ModeUsed.CERTIFIED.name().equals(mode)) {
				endpoint += Function.certifiedAddress.name();
				CertifiedAddressFinderRestProxy proxy = new CertifiedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputFields.ModeUsed.PARSE.name().equals(mode)) {
				// use default method validatedAddress
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			} else if (ValidInputFields.ModeUsed.COUNTRYRECOGNITION.name().equals(mode)) {
				// use default method validatedAddress
				endpoint += Function.validatedAddress.name();
				ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
				result = proxy.find(query);
			}
		} catch (Exception e) {
			addressFind.setErrorMessage(e.getMessage());
		}

		return result;
	}

	private void sendEmail(List<String> emailList) {
		StringBuffer emailTo = new StringBuffer("");
		for (int i = 0; i < emailList.size(); i++) {
			if (i == 0) {
				emailTo.append(emailList.get(i));
			} else {
				emailTo.append("," + emailList.get(i));
			}
		}

		String inputFileName = outputFileName.substring(0, outputFileName.indexOf("_OUTPUT")) + ".xlsx";
		String emailSubject = "[Address Doctor Batch Services] Notification of completion - " + inputFileName;
		String emailText = setEmailText(inputFileName);

		Map<String, String> data = new HashMap<String, String>();
		data.put("EMAIL_TO", emailTo.toString());
		data.put("EMAIL_SUBJECT", emailSubject);
		data.put("EMAIL_TEXT", emailText);

		try {
			MailHelper.sendEmail(data);
		} catch (Exception e) {
			throw new RuntimeException("Error occured when sending mail.", e);
		} finally {
			/* clear temporary variable */
			outputFileUri = null;
		}
	}

	private String setEmailText(String inputFileName) {
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
		bufText.append("Thanks.");
		bufText.append("<br>");
		bufText.append("Best regards.");
		bufText.append("<br>");
		bufText.append("</body>");
		bufText.append("</html>");
		return bufText.toString();
	}

	private void saveOutputRecord() {
		OutputStream out = null;
		try {
			IoPath path = IoPaths.get(new URI(addressDoctorFEZOutputPath + outputFileName));
			if (IoFiles.exists(path)) {
				IoFiles.delete(path);
			}

			path = IoFiles.createFile(path);
			/* temporary save outputFileUri */
			outputFileUri = path.toUri();
			out = IoFiles.newOutputStream(path);

			SXSSFWorkbook outputXLSXWorkBook = new SXSSFWorkbook();
			Sheet outputXLSXSheet = outputXLSXWorkBook.createSheet("OUTPUT");
			
			setOutputFileHeaderLines(outputXLSXSheet);
			saveOutputData(outputXLSXSheet);

			outputXLSXWorkBook.write(out);
		} catch (URISyntaxException uriException) {
			String message = String.format("Could not create URI for input URL '%s'.", outputFileUri);
			throw new RuntimeException(message, uriException);
		} catch (IOException ioException) {
			String message = String.format("Error occured when writing the output file '%s'.", outputFileUri);
			throw new RuntimeException(message, ioException);
		} finally {
			close(out);
		}
	}

	private void close(OutputStream out) {
		try {
			if (out != null) {
				out.close();
			}
		} catch (IOException ioException) {
			throw new RuntimeException("Unable to close the output stream.", ioException);
		}
	}

	/**
	 * start from the third row to save the output data into output excel file
	 * 
	 * @param outputXLSXSheet
	 * 		the sheet of and output excel file 
	 */
	private void saveOutputData(Sheet outputXLSXSheet) {
		int rowNum = 2;
		Row outputXLSXRow;
		List<OutputRecord> listOutputRecord = retriveOutputRecord();
		for (OutputRecord outputRecord : listOutputRecord) {
			outputXLSXRow = outputXLSXSheet.createRow(rowNum++);

			Set<Integer> keyset = Constant.getOutputRecordColumnNamesMap().keySet();
			int cellNum = 0;
			for (int key : keyset) {
				Cell cell = outputXLSXRow.createCell(cellNum++);
				cell.setCellValue(outputRecord.getMethodValue(outputRecord, Constant.getOutputRecordColumnNamesMap().get(key)));
			}
		}
	}

	private void setOutputFileHeaderLines(Sheet outputXLSXSheet) {
		/* set OUTPUT EXCEL FILE HEADER LINE 1 */
		Row firstRow = outputXLSXSheet.createRow(0);
		for (int cellNum = 0; cellNum < Constant.OUTPUT_EXCEL_HEADER_LINE_1.length; cellNum++) {
			firstRow.createCell(cellNum).setCellValue(Constant.OUTPUT_EXCEL_HEADER_LINE_1[cellNum]);
		}
		/* set OUTPUT EXCEL FILE HEADER LINE 2 */
		Row secondRow = outputXLSXSheet.createRow(1);
		for (int cellNum = 0; cellNum < Constant.OUTPUT_EXCEL_HEADER_LINE_2.length; cellNum++) {
			secondRow.createCell(cellNum).setCellValue(Constant.OUTPUT_EXCEL_HEADER_LINE_2[cellNum]);
		}
	}

	private List<OutputRecord> retriveOutputRecord() {
		List<OutputRecord> listOutputRecord = new ArrayList<OutputRecord>();
		Set<AddressFind> keySet = outputMap.keySet();

		for (AddressFind addressFind : keySet) {
			AddressQueryResult result = outputMap.get(addressFind);
			if (addressFind != null) {
				OutputRecord outputRecord = new OutputRecord();
				BeanUtils.copyProperties(addressFind, outputRecord);
				if (addressFind.getAddressInput() != null) {
					BeanUtils.copyProperties(addressFind.getAddressInput(), outputRecord, new String[] { "characterScriptDetectionIndicator" });
					String characterScriptDetectionIndicator = addressFind.getAddressInput().getCharacterScriptDetectionIndicator();
					if ("true".equals(characterScriptDetectionIndicator) || "false".equals(characterScriptDetectionIndicator)){
						characterScriptDetectionIndicator = org.apache.commons.lang.StringUtils.upperCase(characterScriptDetectionIndicator);
					}
					outputRecord.setCharacterScriptDetectionIndicator(characterScriptDetectionIndicator);
					if (result != null) {
						/* escape the same fields between AddressQueryResult and AddressFind, AddressInput */
						String[] sameProperties = new String[] { "modeUsed", "preferredLanguage", "preferredScript", "countOverFlow" };
						BeanUtils.copyProperties(result, outputRecord, sameProperties);
						outputRecord.setMode_Used(result.getModeUsed());
						outputRecord.setCountry_ISO3(result.getIso3());
						outputRecord.setPreferred_Language(result.getPreferredLanguage());
						outputRecord.setPreferred_Script(result.getPreferredScript());
						outputRecord.setCountOverFlow(result.isCountOverFlow() ? "true" : "false");
						if (result.getAddressData() != null && result.getAddressData().size() > 0) {
							retriveAddressData(outputRecord, result.getAddressData().get(0));
						}
					}
				}
				listOutputRecord.add(outputRecord);
			}
		}

		return listOutputRecord;
	}

	private void retriveAddressData(OutputRecord outputRecord, AddressData addressData) {
		/* escape the same fields between AddressQueryResult and AddressFind, AddressInput */
		String[] sameProperties = new String[] { "recipientLine1", "recipientLine2", "recipientLine3", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5", "deliveryAddressLine6",
				"countrySpecificLocalityLine1", "countrySpecificLocalityLine2", "countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "formattedAddressLine1", "formattedAddressLine2",
				"formattedAddressLine3", "formattedAddressLine4", "formattedAddressLine5", "formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11",
				"formattedAddressLine12", "formattedAddressLine13", "formattedAddressLine14", "formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19" };
		BeanUtils.copyProperties(addressData, outputRecord, sameProperties);

		outputRecord.setMethodWithSameSuffix("Key", outputRecord, addressData.getKeys(), "RECORD_ID");
		outputRecord.setMethodWithSameSuffix("Key", outputRecord, addressData.getKeys(), "TRANSACTION_KEY");

		outputRecord.setMethodWithSameSuffix("Locality", outputRecord, addressData.getLocalities(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("PostalCode", outputRecord, addressData.getPostalCodes(), "FORMATTED");
		outputRecord.setMethodWithSameSuffix("Province", outputRecord, addressData.getProvinces(), "COUNTRY_STANDARD");
		outputRecord.setMethodWithSameSuffix("Street", outputRecord, addressData.getStreets(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("Number", outputRecord, addressData.getNumbers(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("Building", outputRecord, addressData.getBuildings(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("SubBuilding", outputRecord, addressData.getSubBuildings(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("DeliverService", outputRecord, addressData.getDeliveryServices(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("Organization", outputRecord, addressData.getOrganizations(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("Contact", outputRecord, addressData.getContacts(), "COMPLETE");
		outputRecord.setMethodWithSameSuffix("Residue", outputRecord, addressData.getResidues(), "UNRECOGNIZED");

		outputRecord.setMethodWithDiffLine("RecipientLine", outputRecord, addressData.getRecipientLines());
		outputRecord.setMethodWithDiffLine("DeliveryAddressLine", outputRecord, addressData.getDeliveryAddressLines());
		outputRecord.setMethodWithDiffLine("CountrySpecificLocalityLine", outputRecord, addressData.getCountrySpecificLocalityLines());
		outputRecord.setMethodWithDiffLine("FormattedAddressLine", outputRecord, addressData.getFormattedAddressLines());

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

	private Map<String, String> convertAddressElementToMap(List<AddressElement> addressElementList) {
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
	private void retriveCountries(OutputRecord outputRecord, Map<String, String> countriesMap) {
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
	private void retriveLocalities(OutputRecord outputRecord, Map<String, String> localitiesMap) {
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
	private void retrivePostalCodes(OutputRecord outputRecord, Map<String, String> postalCodesMap) {
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
	private void retriveBuildings(OutputRecord outputRecord, Map<String, String> buildingsMap) {
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
	private void retriveSubBuildings(OutputRecord outputRecord, Map<String, String> subBuildingsMap) {
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
	private void retriveDeliveryServices(OutputRecord outputRecord, Map<String, String> deliveryServicesMap) {
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
	private void retriveOrganizations(OutputRecord outputRecord, Map<String, String> organizationsMap) {
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
	private void retriveContacts(OutputRecord outputRecord, Map<String, String> contactsMap) {
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
	private void retriveResidues(OutputRecord outputRecord, Map<String, String> residuesMap) {
		outputRecord.setResidue1_NECESSARY(residuesMap.get("NECESSARY"));
		outputRecord.setResidue1_SUPERFLUOUS(residuesMap.get("SUPERFLUOUS"));
	}

}
