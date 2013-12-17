package com.hp.it.cas.match.batch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.cas.data.businessService.LockContext;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.io.adapter.IoFiles;
import com.hp.it.cas.io.adapter.IoPath;
import com.hp.it.cas.io.adapter.IoPaths;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;
import com.hp.it.cas.match.address.rest.AddressSuggestionsAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.CertifiedAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.FastCompletionAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy;
import com.hp.it.cas.match.batch.utilities.BatchUtils;
import com.hp.it.cas.match.batch.utilities.MailHelper;
import com.hp.it.cas.xa.security.SecurityContextHolder;

/**
 * 1. Each line in the input file call AD service and got the result
 * 2. Save the query and the result in the FEZ output file
 * 3. Send notification email to specified customer of each InputFile
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindController implements TransactionController<AddressFind, Void>{
	
	private static final String ADDRESSDOCTOR_FEZOUTPUTPATH = "addressDoctorFEZOutputPath" ;
	private static final String ADDRESSDOCTOR_ENV = "addressDoctorEnv";
	private final String addressDoctorEnv;
	private final String addressDoctorFEZOutputPath;
	
	private enum ModeUse {
		BATCH, INTERACTIVE, FASTCOMPLETION, CERTIFIED, PARSE, COUNTRYRECOGNITION
	};
	
	// TODO 
	// 6 MODEUSED, but 5 functions.
	// verify the relationship between MODE and Function
	private enum Function {
		looselyValidatedAddress, addressSuggestions, fastCompletionAddress, certifiedAddress, validatedAddress
	};
	
	/* temporary variable to save the INPUT and Result for each Input file, email and outputFileName */
	private Map<AddressFind, AddressQueryResult> outputMap = new LinkedHashMap<AddressFind, AddressQueryResult>();
	private List<String> emailList = null;
	private String outputFileName;

	public AddressFindController(Configuration configuration) {
		this.addressDoctorEnv  = configuration.getJobParameters().get(ADDRESSDOCTOR_ENV);
		this.addressDoctorFEZOutputPath = configuration.getJobParameters().get(ADDRESSDOCTOR_FEZOUTPUTPATH);
	}

	@Override
	public Void process(AddressFind addressFind, MessageContext messageContext, LockContext lockContext) throws Exception {
		/* temporary save outputFileName */
		if (outputFileName == null && addressFind.getOutputFileName() != null) {
			outputFileName = addressFind.getOutputFileName();
			return null;
		}

		/* outputFileName + email --> send email */
		if (outputFileName != null && addressFind.getEmailList() != null) {
			emailList = addressFind.getEmailList();
			saveOutput();
			sendEmail();

			/* clear temporary variable */
			outputMap.clear();
			emailList = null;
			outputFileName = null;
			return null;
		}

		if (addressFind.getEmailList() == null && addressFind.getEmailList() == null) {
			/* call AD Service */
			AddressQueryResult result = callADService(addressFind);
			/* temporary save Input and Result */
			outputMap.put(addressFind, result);
		}
		return null;
	}
	
	/**
	 * Call AD service.
	 * 
	 * @param addressFind
	 * 		AddressFind
	 * @return result
	 * 		AddressQueryResult
	 */
	private AddressQueryResult callADService(AddressFind addressFind){
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
	 * 		AddressFind
	 * @return
	 * 		AddressQueryResult
	 */
	private AddressQueryResult findAddress(AddressFind addressFind) {
		AddressQueryResult result = null;
		
		String endpoint = addressDoctorEnv;
		String function = addressFind.getModeUsed();
	
		// TODO
		if (ModeUse.BATCH.name().equals(function)) {
			endpoint += Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.INTERACTIVE.name().equals(function)) {
			endpoint += Function.addressSuggestions.name();
			AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(endpoint);
			result = proxy.suggest(addressFind.getQuery());
		}

		if (ModeUse.FASTCOMPLETION.name().equals(function)) {
			endpoint += Function.fastCompletionAddress.name();
			FastCompletionAddressFinderRestProxy proxy = new FastCompletionAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.CERTIFIED.name().equals(function)) {
			endpoint += Function.certifiedAddress.name();
			CertifiedAddressFinderRestProxy proxy = new CertifiedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		// TODO
		if (ModeUse.PARSE.name().equals(function)) {
			endpoint += Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		// TODO
		if (ModeUse.COUNTRYRECOGNITION.name().equals(function)) {
			endpoint += Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}
		
		return result;
	}

	/**
	 * Save the INPUT and Result in InputFileName_Output.csv and upload the OUTPUT file
	 */
	private void saveOutput() {
		BufferedWriter writer = null;
		try {
			IoPath path = IoPaths.get(new URI(addressDoctorFEZOutputPath + outputFileName));
			if (IoFiles.exists(path)) {
				IoFiles.delete(path);
			}
			path = IoFiles.createFile(path);
			writer = IoFiles.newBufferedWriter(path, Charset.forName("UTF-8"));
			writer.write(BatchUtils.OUTPUT_TEMPLATE_LINE_1);
			writer.write("\r\n");
			writer.write(BatchUtils.OUTPUT_TEMPLATE_LINE_2);
			writer.write("\r\n");

			/* add INPUT and Result in the InputFileName_OUTPUT.csv file */
			Set<AddressFind> keySet = outputMap.keySet();
			for(AddressFind addressFind : keySet){
				AddressQueryResult result = outputMap.get(addressFind);
				writer.write(outputRecord(addressFind, result));
				writer.write("\r\n");
			}
		} catch (URISyntaxException uriException) {
			String message = String.format("Could not create URI for input URL '%s'.", addressDoctorFEZOutputPath + outputFileName);
			throw new RuntimeException(message, uriException);
		} catch (IOException ioException) {
			String message = String.format("Error occured when writing the output file '%s'.", addressDoctorFEZOutputPath + outputFileName);
			throw new RuntimeException(message, ioException);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException ioException) {
				String message = String.format("Unable to close the writer.");
				throw new RuntimeException(message, ioException);
			}
		}
	}
	
	/**
	 * send email to Customer
	 */
	public void sendEmail(){
		
		StringBuffer emailTo = new StringBuffer("");
		for (int i = 0; i < emailList.size(); i++) {
			if(i == 0){
				emailTo.append(emailList.get(i));
			} else {
				emailTo.append("," + emailList.get(i));
			}
		}
		
		String inputFileName = outputFileName.substring(0, outputFileName.indexOf("_OUTPUT")) + ".csv";
		String outputFileUrl = addressDoctorFEZOutputPath + outputFileName;
		
		String emailSubject = "[Address Doctor Batch Services] Notification of completion - " + inputFileName;
		
		StringBuffer bufText = new StringBuffer("<html>");
		bufText.append("<head>");
		bufText.append("</head>");
		bufText.append("<body>");
		bufText.append("Hello,");
		bufText.append("<br><br>");
		bufText.append(" Please find at " + outputFileUrl
				+ " the results of the processing of the file " + inputFileName
				+ " you have submitted to Address Doctor Batch Services.");
		bufText.append("<br><br>");
		bufText.append("Thanks.");
		bufText.append("<br>");
		bufText.append("Best regards. ");
		bufText.append("<br>");
		bufText.append("</body>");
		bufText.append("</html>");

		Map<String,String> data = new HashMap<String, String>();
		data.put("EMAIL_TO", emailTo.toString());
		data.put("EMAIL_SUBJECT", emailSubject);
		data.put("EMAIL_TEXT", bufText.toString());
		
		try {
			MailHelper.sendEmail(data);
		} catch (Exception e) {
			String message = String.format("Error occured when sending mail.");
			throw new RuntimeException(message, e);
		}
		
	}
	
	/**
	 * save input data and result data into OUTPUT file
	 * 
	 * @param addressFind
	 * 		AddressFind
	 * @param result
	 * 		AddressQueryResult
	 * @return String
	 * 		split each field with COMMA in the string
	 */
	public String outputRecord(AddressFind addressFind, AddressQueryResult result){
		StringBuffer strBuf = new StringBuffer();
		
		// INPUT DATA
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getKey1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getKey2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getKey3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getModeUsed())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getPreferredLanguage())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getPreferredScript())).append(",");
		
		strBuf.append(addressFind.getQuery().getCharacterScriptDetectionIndicator() ?	"TRUE"	: "FAULSE").append(",");
		
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountry1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountry2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountry3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getAddressComplete())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getBuilding6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getLocality6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getPostalCode1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getPostalCode2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getPostalCode3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getCountrySpecificLocalityLine6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getStreet6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getNumber6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getProvince6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryAddressLine6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getDeliveryService6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine7())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine8())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine9())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine10())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine11())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine12())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine13())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine14())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine15())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine16())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine17())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine18())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getFormattedAddressLine19())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getOrganization1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getOrganization2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getOrganization3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getContact1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getContact2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getContact3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getRecipientLine1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getRecipientLine2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getRecipientLine3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getResidue6())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding1())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding2())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding3())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding4())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding5())).append(",");
		strBuf.append(BatchUtils.trimOutputField(addressFind.getQuery().getSubBuilding6())).append(",");
		
		// OUTPUT 
		strBuf.append(",");
		
		// TODO
		// key1-RECORD_ID key2-RECORD_ID	key3-RECORD_ID
		// key1-TRANSACTION_KEY	key2-TRANSACTION_KEY key3-TRANSACTION_KEY	
		// ResultNumber
		for (int i = 0; i < 7 ; i ++  ) {
			strBuf.append(",");
		}

		if (result != null){
			// RESULT
			strBuf.append(result.getIso3()).append(",");
			strBuf.append(result.getModeUsed()).append(",");
			strBuf.append(result.getPreferredLanguage()).append(",");
			strBuf.append(result.getPreferredScript()).append(",");
			strBuf.append(result.getProcessStatus()).append(",");
			strBuf.append(result.isCountOverFlow()).append(",");
			
			// RESULT DATA
			// each result of an address query, there will be one AddressData item returned
			AddressData addressData = result.getAddressData().get(0);
			strBuf.append(addressData.getElementInputStatus()).append(",");
			strBuf.append(addressData.getElementResultStatus()).append(",");
			strBuf.append(addressData.getElementRelevance()).append(",");
			strBuf.append(addressData.getMailabilityScore()).append(",");
			strBuf.append(addressData.getResultPercentage()).append(",");
			strBuf.append(addressData.getCassStatus()).append(",");
			strBuf.append(addressData.getSerpStatus()).append(",");
			strBuf.append(addressData.getSnaStatus()).append(",");
			strBuf.append(addressData.getSupplementaryGBStatus()).append(",");
			strBuf.append(addressData.getSupplementaryUSStatus()).append(",");
			
			// ADDRESS ELEMENTS-DEFAULT TYPES
			// country1-NAME_EN	
			// TODO
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_EN", addressData.getCountries()));
			
			// locality1-COMPLETE	locality2-COMPLETE	locality3-COMPLETE	locality4-COMPLETE	locality5-COMPLETE	locality6-COMPLETE	
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getLocalities()));
			
			// postalCode1-FORMATTED	postalCode2-FORMATTED	postalCode3-FORMATTED
			strBuf.append(retrieveAddresssDataWithSameSuffix("FORMATTED", 3 , addressData.getPostalCodes()));
			
			// province1-COUNTRY_STANDARD	province2-COUNTRY_STANDARD	province3-COUNTRY_STANDARD	province4-COUNTRY_STANDARD	province5-COUNTRY_STANDARD	province6-COUNTRY_STANDARD		
			strBuf.append(retrieveAddresssDataWithSameSuffix("COUNTRY_STANDARD", 6 , addressData.getProvinces()));
			// street1-COMPLETE	street2-COMPLETE	street3-COMPLETE	street4-COMPLETE	street5-COMPLETE	street6-COMPLETE	
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getStreets()));
			// number1-COMPLETE	number2-COMPLETE	number3-COMPLETE	number4-COMPLETE	number5-COMPLETE	number6-COMPLETE
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getNumbers()));
			// building1-COMPLETE	building2-COMPLETE	building3-COMPLETE	building4-COMPLETE	building5-COMPLETE	building6-COMPLETE
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getBuildings()));
			// subBuilding1-COMPLETE	subBuilding2-COMPLETE	subBuilding3-COMPLETE	subBuilding4-COMPLETE	subBuilding5-COMPLETE	subBuilding6-COMPLETE	
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getSubBuildings()));
			// deliverService1-COMPLETE	deliverService2-COMPLETE	deliverService3-COMPLETE	deliverService4-COMPLETE	deliverService5-COMPLETE	deliverService6-COMPLETE	
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 6 , addressData.getDeliveryServices()));
			// organization1-COMPLETE	organization2-COMPLETE	organization3-COMPLETE	
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 3 , addressData.getOrganizations()));
			// contact1-COMPLETE	contact2-COMPLETE	contact3-COMPLETE
			strBuf.append(retrieveAddresssDataWithSameSuffix("COMPLETE", 3 , addressData.getContacts()));
			// residue1-UNRECOGNIZED	residue2-UNRECOGNIZED	residue3-UNRECOGNIZED	residue4-UNRECOGNIZED	residue5-UNRECOGNIZED	residue6-UNRECOGNIZED	
			strBuf.append(retrieveAddresssDataWithSameSuffix("UNRECOGNIZED", 6 , addressData.getResidues()));
			
			// recipientLine1	recipientLine2	recipientLine3	
			strBuf.append(retrieveAddresssDataWithDiffLine(3, addressData.getRecipientLines()));
			// deliveryAddressLine1	deliveryAddressLine2	deliveryAddressLine3	deliveryAddressLine4	deliveryAddressLine5	deliveryAddressLine6	
			strBuf.append(retrieveAddresssDataWithDiffLine(6, addressData.getDeliveryAddressLines()));
			// countrySpecificLocalityLine1	countrySpecificLocalityLine2	countrySpecificLocalityLine3	countrySpecificLocalityLine4	countrySpecificLocalityLine5	countrySpecificLocalityLine6	
			strBuf.append(retrieveAddresssDataWithDiffLine(6, addressData.getCountrySpecificLocalityLines()));
			// FormattedAddressLine1	FormattedAddressLine2	FormattedAddressLine3	FormattedAddressLine4	FormattedAddressLine5	FormattedAddressLine6	FormattedAddressLine7	FormattedAddressLine8	FormattedAddressLine9	FormattedAddressLine10	FormattedAddressLine11	FormattedAddressLine12	FormattedAddressLine13	FormattedAddressLine14	FormattedAddressLine15	FormattedAddressLine16	FormattedAddressLine17	FormattedAddressLine18	FormattedAddressLine19	
			strBuf.append(retrieveAddresssDataWithDiffLine(19, addressData.getFormattedAddressLines()));
			
			// addressComplete
			// escape \r\n in the field
			strBuf.append(BatchUtils.trimOutputField(addressData.getCompleteAddress())).append(",");
			
			// country1-ABBREVIATION	country1-ISO2	country1-ISO3	country1- ISO_NUMBER	country1-NAME_CN	country1-NAME_DA	country1-NAME_DE	country1-NAME_ES	country1-NAME_FI	country1-NAME_FR	country1-NAME_GR	country1-NAME_HU	country1-NAME_IT	country1-NAME_JP	country1-NAME_KR	country1-NAME_NL	country1-NAME_PL	country1-NAME_PT	country1-NAME_RU	country1-NAME_SA	country1-NAME_SE	
			strBuf.append(retrieveAddresssDataWithSamePrefix("ABBREVIATION", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ISO2", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ISO3", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ISO_NUMBER", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_CN", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_DA", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_DE", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_ES", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_FI", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_FR", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_GR", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_HU", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_IT", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_JP", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_KR", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_NL", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_PL", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_PT", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_RU", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_SA", addressData.getCountries()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME_SE", addressData.getCountries()));
			
			// TODO
			// not sure
			// country2-ABBREVIATION	country2-ISO2	country2-ISO3	country2- ISO_NUMBER	country2-NAME_CN	country2-NAME_DA	country2-NAME_DE	country2-NAME_ES	country2-NAME_FI	country2-NAME_FR	country2-NAME_GR	country2-NAME_HU	country2-NAME_IT	country2-NAME_JP	country2-NAME_KR	country2-NAME_NL	country2-NAME_PL	country2-NAME_PT	country2-NAME_RU	country2-NAME_SA	country2-NAME_SE	
			// country3-ABBREVIATION	country3-ISO2	country3-ISO3	country3- ISO_NUMBER	country3-NAME_CN	country3-NAME_DA	country3-NAME_DE	country3-NAME_ES	country3-NAME_FI	country3-NAME_FR	country3-NAME_GR	country3-NAME_HU	country3-NAME_IT	country3-NAME_JP	country3-NAME_KR	country3-NAME_NL	country3-NAME_PL	country3-NAME_PT	country3-NAME_RU	country3-NAME_SA	country3-NAME_SE	
			for (int i = 0; i < 42; i++) {
				strBuf.append(",");
			}
			
			// locality1-NAME	locality1-PREFERRED_NAME	locality1-SORTING_CODE	locality1-ADD_INFO	
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getLocalities()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("PREFERRED_NAME", addressData.getLocalities()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("SORTING_CODE", addressData.getLocalities()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ADD_INFO", addressData.getLocalities()));
			
			// TODO
			// not sure
			// locality2-NAME	locality2-PREFERRED_NAME	locality2-SORTING_CODE	locality2-ADD_INFO	
			// locality3-NAME	locality3-PREFERRED_NAME	locality3-SORTING_CODE	locality3-ADD_INFO	
			// locality4-NAME	locality4-PREFERRED_NAME	locality4-SORTING_CODE	locality4-ADD_INFO	
			// locality5-NAME	locality5-PREFERRED_NAME	locality5-SORTING_CODE	locality5-ADD_INFO	
			// locality6-NAME	locality6-PREFERRED_NAME	locality6-SORTING_CODE	locality6-ADD_INFO
			for (int i = 0; i < 20; i++) {
				strBuf.append(",");
			}
			
			// postalCode1-UNFORMATTED	postalCode1-BASE	postalCode1-ADD_ON
			strBuf.append(retrieveAddresssDataWithSamePrefix("UNFORMATTED", addressData.getPostalCodes()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("BASE", addressData.getPostalCodes()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ADD_ON", addressData.getPostalCodes()));
			
			// TODO
			// not sure
			// postalCode2-UNFORMATTED	postalCode2-BASE	postalCode2-ADD_ON	
			// postalCode3-UNFORMATTED	postalCode3-BASE	postalCode3-ADD_ON	
			for (int i = 0; i < 6; i++) {
				strBuf.append(",");
			}
			
			// province1-ABBREVIATION	province1-EXTENDED	province1-ISO	
			strBuf.append(retrieveAddresssDataWithSamePrefix("ABBREVIATION", addressData.getProvinces()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("EXTENDED", addressData.getProvinces()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ISO", addressData.getProvinces()));
			
			// TODO
			// province2-ABBREVIATION	province2-EXTENDED	province2-ISO	
			// province3-ABBREVIATION	province3-EXTENDED	province3-ISO	
			// province4-ABBREVIATION	province4-EXTENDED	province4-ISO	
			// province5-ABBREVIATION	province5-EXTENDED	province5-ISO	
			// province6-ABBREVIATION	province6-EXTENDED	province6-ISO
			for (int i = 0; i < 20; i++) {
				strBuf.append(",");
			}
			
			// street1-COMPLETE_WITH_NUMBER	street1-NAME	street1-PRE_DESCRIPTOR	street1-POST_DESCRIPTOR	street1-PRE_DIRECTIONAL	street1-POST_DIRECTIONAL	street1-ADD_INFO	
			strBuf.append(retrieveAddresssDataWithSamePrefix("COMPLETE_WITH_NUMBER", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("PRE_DESCRIPTOR", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("POST_DESCRIPTOR", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("PRE_DIRECTIONAL", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("POST_DIRECTIONAL", addressData.getStreets()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ADD_INFO", addressData.getStreets()));
			
			// TODO
			// street2-COMPLETE_WITH_NUMBER	street2-NAME	street2-PRE_DESCRIPTOR	street2-POST_DESCRIPTOR	street2-PRE_DIRECTIONAL	street2-POST_DIRECTIONAL	street2-ADD_INFO	
			// street3-COMPLETE_WITH_NUMBER	street3-NAME	street3-PRE_DESCRIPTOR	street3-POST_DESCRIPTOR	street3-PRE_DIRECTIONAL	street3-POST_DIRECTIONAL	street3-ADD_INFO	
			// street4-COMPLETE_WITH_NUMBER	street4-NAME	street4-PRE_DESCRIPTOR	street4-POST_DESCRIPTOR	street4-PRE_DIRECTIONAL	street4-POST_DIRECTIONAL	street4-ADD_INFO	
			// street5-COMPLETE_WITH_NUMBER	street5-NAME	street5-PRE_DESCRIPTOR	street5-POST_DESCRIPTOR	street5-PRE_DIRECTIONAL	street5-POST_DIRECTIONAL	street5-ADD_INFO	
			// street6-COMPLETE_WITH_NUMBER	street6-NAME	street6-PRE_DESCRIPTOR	street6-POST_DESCRIPTOR	street6-PRE_DIRECTIONAL	street6-POST_DIRECTIONAL	street6-ADD_INFO	
			for (int i = 0; i < 35; i++) {
				strBuf.append(",");
			}
			
			// number1-NUMBER	number1-DESCRIPTOR	number1-ADD_INFO
			strBuf.append(retrieveAddresssDataWithSamePrefix("NUMBER", addressData.getNumbers()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("DESCRIPTOR", addressData.getNumbers()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ADD_INFO", addressData.getNumbers()));
			
			// TODO
			// number2-NUMBER	number2-DESCRIPTOR	number2-ADD_INFO	
			// number3-NUMBER	number3-DESCRIPTOR	number3-ADD_INFO	
			// number4-NUMBER	number4-DESCRIPTOR	number4-ADD_INFO	
			// number5-NUMBER	number5-DESCRIPTOR	number5-ADD_INFO	
			// number6-NUMBER	number6-DESCRIPTOR	number6-ADD_INFO
			for (int i = 0; i < 15; i++) {
				strBuf.append(",");
			}
			
			// building1-COMPLETE_WITH_SUBBUILDING	building1-NAME	building1-NUMBER 	building1-DESCRIPTOR	
			strBuf.append(retrieveAddresssDataWithSamePrefix("COMPLETE_WITH_SUBBUILDING", addressData.getBuildings()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getBuildings()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NUMBER", addressData.getBuildings()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("DESCRIPTOR", addressData.getBuildings()));
			
			// TODO
			// building2-COMPLETE_WITH_SUBBUILDING	building2-NAME	building2-NUMBER 	building2-DESCRIPTOR	
			// building3-COMPLETE_WITH_SUBBUILDING	building3-NAME	building3-NUMBER 	building3-DESCRIPTOR	
			// building4-COMPLETE_WITH_SUBBUILDING	building4-NAME	building4-NUMBER 	building4-DESCRIPTOR	
			// building5-COMPLETE_WITH_SUBBUILDING	building5-NAME	building5-NUMBER 	building5-DESCRIPTOR	
			// building6-COMPLETE_WITH_SUBBUILDING	building6-NAME	building6-NUMBER 	building6-DESCRIPTOR	
			for (int i = 0; i < 20; i++) {
				strBuf.append(",");
			}
			
			
			// subBuilding1-NAME	subBuilding1-NUMBER 	subBuilding1-DESCRIPTOR
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getSubBuildings()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NUMBER", addressData.getSubBuildings()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("DESCRIPTOR", addressData.getSubBuildings()));
			
			// TODO
			// subBuilding2-NAME	subBuilding2-NUMBER 	subBuilding2-DESCRIPTOR	
			// subBuilding3-NAME	subBuilding3-NUMBER 	subBuilding3-DESCRIPTOR	
			// subBuilding4-NAME	subBuilding4-NUMBER 	subBuilding4-DESCRIPTOR	
			// subBuilding5-NAME	subBuilding5-NUMBER 	subBuilding5-DESCRIPTOR	
			// subBuilding6-NAME	subBuilding6-NUMBER 	subBuilding6-DESCRIPTOR	
			for (int i = 0; i < 15; i++) {
				strBuf.append(",");
			}			
			
			// deliveryService1-DESCRIPTOR	deliveryService1-NUMBER	deliveryService1-ADD_INFO
			strBuf.append(retrieveAddresssDataWithSamePrefix("DESCRIPTOR", addressData.getDeliveryServices()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NUMBER", addressData.getDeliveryServices()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("ADD_INFO", addressData.getDeliveryServices()));
			
			// TODO
			// deliveryService2-DESCRIPTOR	deliveryService2-NUMBER	deliveryService2-ADD_INFO	
			// deliveryService3-DESCRIPTOR	deliveryService3-NUMBER	deliveryService3-ADD_INFO	
			for (int i = 0; i < 6; i++) {
				strBuf.append(",");
			}
			
			// organization1-NAME	organization1-DESCRIPTOR	organization1-DEPARTMENT
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getOrganizations()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("DESCRIPTOR", addressData.getOrganizations()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("DEPARTMENT", addressData.getOrganizations()));
			
			//TODO
			// organization2-NAME	organization2-DESCRIPTOR	organization2-DEPARTMENT	
			// organization3-NAME	organization3-DESCRIPTOR	organization3-DEPARTMENT	
			for (int i = 0; i < 6; i++) {
				strBuf.append(",");
			}
			
			// contact1-FIRST_NAME	contact1-MIDDLE_NAME	contact1-LAST_NAME	contact1-NAME	contact1-TITLE	contact1-FUNCTION	contact1-SALUTATION	contact1-GENDER	
			strBuf.append(retrieveAddresssDataWithSamePrefix("FIRST_NAME", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("MIDDLE_NAME", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("LAST_NAME", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("NAME", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("TITLE", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("FUNCTION", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("SALUTATION", addressData.getContacts()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("GENDER", addressData.getContacts()));
			
			// TODO
			// contact2-FIRST_NAME	contact2-MIDDLE_NAME	contact2-LAST_NAME	contact2-NAME	contact2-TITLE	contact2-FUNCTION	contact2-SALUTATION	contact2-GENDER	
			// contact3-FIRST_NAME	contact3-MIDDLE_NAME	contact3-LAST_NAME	contact3-NAME	contact3-TITLE	contact3-FUNCTION	contact3-SALUTATION	contact3-GENDER	
			for (int i = 0; i < 16; i++) {
				strBuf.append(",");
			}
			
			// residue1-NECESSARY	residue1-SUPERFLUOUS
			strBuf.append(retrieveAddresssDataWithSamePrefix("NECESSARY", addressData.getResidues()));
			strBuf.append(retrieveAddresssDataWithSamePrefix("SUPERFLUOUS", addressData.getResidues()));
			
			// TODO
			// residue2-NECESSARY	residue2-SUPERFLUOUS
			// residue3-NECESSARY	residue3-SUPERFLUOUS	
			// residue4-NECESSARY	residue4-SUPERFLUOUS	
			// residue5-NECESSARY	residue5-SUPERFLUOUS	
			// residue6-NECESSARY	residue6-SUPERFLUOUS
			for (int i = 0; i < 10; i++) {
				strBuf.append(",");
			}
		}
		
		return strBuf.toString();
	}
	
	private String retrieveAddresssDataWithSamePrefix(String type, List<AddressElement> list) {
		StringBuffer buf = new StringBuffer();
		int i = 0;
		for (AddressElement element : list) {
			i++;
			boolean flag = false;
			if (type.equals(element.getType())) {
				flag = true;
				buf.append(BatchUtils.trimOutputField(element.getValue())).append(",");
			}

			if (flag) {
				break;
			} else if (i >= list.size()) {
				// not exist, then set null
				buf.append(",");
			}
		}

		return buf.toString();
	}

	private String retrieveAddresssDataWithDiffLine(int count, List<String> list) {
		StringBuffer buf = new StringBuffer();
		if (list.size() == 0) {
			for (int i = 0; i < count; i++) {
				buf.append(",");
			}
		} else if (list.size() <= count) {
			for (String element : list) {
				buf.append(BatchUtils.trimOutputField(element)).append(",");
			}
			for (int i = 0; i < count - list.size(); i++) {
				// not exist, then set null
				buf.append(",");
			}
		}
		return buf.toString();
	}

	private String retrieveAddresssDataWithSameSuffix(String type, int count,
			List<AddressElement> list) {
		StringBuffer buf = new StringBuffer();
		int num = 0;
		for (AddressElement element : list) {
			if (type.equals(element.getType())) {
				num++;
				buf.append(BatchUtils.trimOutputField(element.getValue())).append(",");
			}
		}

		if (num <= count) {
			for (int i = 0; i < count - num; i++) {
				// not exist, then set null
				buf.append(",");
			}
		}
		return buf.toString();
	}
}
