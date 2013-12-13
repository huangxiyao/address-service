package com.hp.it.cas.match.batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.cas.data.businessService.LockContext;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.io.adapter.IoFiles;
import com.hp.it.cas.io.adapter.IoPath;
import com.hp.it.cas.io.adapter.IoPaths;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;
import com.hp.it.cas.match.address.rest.AddressSuggestionsAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.CertifiedAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.FastCompletionAddressFinderRestProxy;
import com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy;
import com.hp.it.cas.match.batch.utilities.MailHelper;
import com.hp.it.cas.xa.security.SecurityContextHolder;

/**
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
	
	//  Correction Only (BATCH) looselyValidatedAddress
	//  Suggestions (INTERACTIVE) addressSuggestions
	//  Fast Completion (FASTCOMPLETION) fastCompletionAddress
	//  Certified (CERTIFIED) certifiedAddress

	// PARSE
	// COUNTRYRECOGNITION

	// validatedAddress
	
	// TODO 
	// 6 MODEUSED, but 5 functions.
	// verify the relationship between MODE and Function
	private enum Function {
		looselyValidatedAddress, addressSuggestions, fastCompletionAddress, certifiedAddress, validatedAddress, 
	};
	
	
	// temporary save the INPUT and Result for each Input file
	private HashMap<AddressFind, AddressQueryResult> outputList = new HashMap<AddressFind, AddressQueryResult>();
	

	// temporary save email
	private ArrayList<String> emailList = null;
	private String outputFileName;

	public AddressFindController(Configuration configuration) {
		this.addressDoctorEnv  = configuration.getJobParameters().get(ADDRESSDOCTOR_ENV);
		this.addressDoctorFEZOutputPath = configuration.getJobParameters().get(ADDRESSDOCTOR_FEZOUTPUTPATH);
	}

	@Override
	public Void process(AddressFind addressFind, MessageContext messageContext, LockContext lockContext) throws Exception {
		
		// TODO 
		// need review
		
		if (outputFileName == null && addressFind.getOutputFileName() != null){
			outputFileName = addressFind.getOutputFileName();
			return null;
		}
		
		// outputfilename + email --> send email
		if ( outputFileName != null && addressFind.getEmailList() != null){
			emailList = addressFind.getEmailList();
			saveOutput();
			sendEmail();
			
			// clear temporary var
			outputList.clear();
			emailList = null;
			outputFileName = null;
			return null;
		} 
		
		if (addressFind.getEmailList() == null){
			// call AD Service
			AddressQueryResult result = callADServices(addressFind);

			// temporary save Input and Result
			outputList.put(addressFind, result);
		} 
		return null;
	}
	

	
	// Call AD Service
	public AddressQueryResult callADServices(AddressFind addressFind){

		Principal principal = SecurityContextHolder.getInstance().getAuditPrincipal(); 

		SecurityContextTestController securityController = new SecurityContextTestController();
		securityController.collectAndSetupSecurityContext(new ClientTestEnvironment("w-mdcp:prd-http", null, null));
		AddressQueryResult result = findAddress(addressFind);
		
		// when run the job got NullPointerException of pricipal
		
		SecurityContextHolder.getInstance().addContext(principal);

		return result;
		
	}
	
	private AddressQueryResult findAddress(AddressFind addressFind) {
		AddressQueryResult result = null;
		
		String endpoint = "";
		String function = addressFind.getModeUsed();
	
		if (ModeUse.BATCH.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.looselyValidatedAddress.name();
//			LooselyValidatedAddressFinderRestProxy proxy = new LooselyValidatedAddressFinderRestProxy(endpoint);

			endpoint = addressDoctorEnv + Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.INTERACTIVE.name().equals(function)) {
			endpoint = addressDoctorEnv + Function.addressSuggestions.name();
			AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(endpoint);
			result = proxy.suggest(addressFind.getQuery());
		}

		if (ModeUse.FASTCOMPLETION.name().equals(function)) {
			endpoint = addressDoctorEnv + Function.fastCompletionAddress.name();
			FastCompletionAddressFinderRestProxy proxy = new FastCompletionAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.CERTIFIED.name().equals(function)) {
			endpoint = addressDoctorEnv + Function.certifiedAddress.name();
			CertifiedAddressFinderRestProxy proxy = new CertifiedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.PARSE.name().equals(function)) {
			endpoint = addressDoctorEnv + Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}

		if (ModeUse.COUNTRYRECOGNITION.name().equals(function)) {
			endpoint = addressDoctorEnv + Function.validatedAddress.name();
			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
			result = proxy.find(addressFind.getQuery());
		}
		
		return result;
	}

	// TODO
	// save the INPUT and Result in Output.csv and upload the OUTPUT file
	// public IoPath saveOutput(HashMap<AddressFind, AddressQueryResult> outputList) throws IOException, URISyntaxException{
	public void saveOutput() throws IOException, URISyntaxException{
		File file = new File(getClass().getClassLoader().getResource("AddressDoctorBatchServicesOutputTemplate.csv").toURI());
		BufferedReader reader = IoFiles.newBufferedReader(IoPaths.get(file.toURI()), Charset.forName("UTF-8"));
		
		// OUTPUT file name
		IoPath path = IoPaths.get(new URI(addressDoctorFEZOutputPath + outputFileName));
		
        if (IoFiles.exists(path)) {
            IoFiles.delete(path);
        }
        
        path = IoFiles.createFile(path);
        BufferedWriter writer = IoFiles.newBufferedWriter(path, Charset.forName("UTF-8"));
        writer.write(reader.readLine());
        writer.write("\r\n");
        writer.write(reader.readLine());
        writer.write("\r\n");
        
        // add INPUT and Result in the OUTPUT csv file
        Iterator iter = outputList.entrySet().iterator();
        while (iter.hasNext()){
        	Map.Entry entry = (Map.Entry) iter.next(); 
        	AddressFind addressFind = (AddressFind)entry.getKey();
        	AddressQueryResult result = (AddressQueryResult)entry.getValue();
        	String output =outputRecord(addressFind, result);
        	System.out.println(output);
        	writer.write(output);
        	writer.write("\r\n");
        }
        writer.close();
    	System.out.println(path.toUri());
	}
	
	// send email to Customer
	public void sendEmail(){
		
		String emailTo = "";
		for (int i = 0; i < emailList.size(); i++) {
			emailTo = emailTo + emailList.get(i);
			if (i < emailList.size()-1 ){
				emailTo = emailTo + ",";
			}
		}
		
		String inputFileName = outputFileName.substring(0, outputFileName.indexOf("_OUTPUT")) + ".csv";
		String outputFileUrl = addressDoctorFEZOutputPath + outputFileName;
		
		String emailSubject = "[Address Doctor Batch Services] Notification of completion - " + inputFileName;
		String emailText = "Hello, \n Please find at " + outputFileUrl + " the results of the processing of the file " + inputFileName + " you have submitted to Address Doctor Batch Services. \n Thanks. \n Best regards. \n";
		
		Map<String,String> data = new HashMap<String, String>();
		data.put("EMAIL_TO", emailTo);
		data.put("EMAIL_SUBJECT", emailSubject);
		data.put("EMAIL_TEXT", emailText);
		boolean result = false;
		try {
			result = MailHelper.sendEmail(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result) {
			System.out.print("success");
		} else {
			System.out.print("failed");
		}
	}
	
	// join input data and result data into OUTPUT file
	public String outputRecord(AddressFind addressFind, AddressQueryResult result){
		StringBuffer strBuf = new StringBuffer();
		
		// INPUT DATA
		strBuf.append((addressFind.getQuery().getKey1()	!= null ?	addressFind.getQuery().getKey1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getKey2()	!= null ?	addressFind.getQuery().getKey2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getKey3()	!= null ?	addressFind.getQuery().getKey3()	: "" )  + ",");
		strBuf.append((addressFind.getModeUsed()	!= null ?	addressFind.getModeUsed()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getPreferredLanguage()	!= null ?	addressFind.getQuery().getPreferredLanguage()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getPreferredScript()	!= null ?	addressFind.getQuery().getPreferredScript()	: "" )  + ",");
		
		strBuf.append((addressFind.getQuery().getCharacterScriptDetectionIndicator() ?	"TRUE"	: "FAULSE") + ",");
		
		strBuf.append((addressFind.getQuery().getCountry1()	!= null ?	addressFind.getQuery().getCountry1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountry2()	!= null ?	addressFind.getQuery().getCountry2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountry3()	!= null ?	addressFind.getQuery().getCountry3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getAddressComplete()	!= null ?	addressFind.getQuery().getAddressComplete()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding1()	!= null ?	addressFind.getQuery().getBuilding1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding2()	!= null ?	addressFind.getQuery().getBuilding2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding3()	!= null ?	addressFind.getQuery().getBuilding3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding4()	!= null ?	addressFind.getQuery().getBuilding4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding5()	!= null ?	addressFind.getQuery().getBuilding5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getBuilding6()	!= null ?	addressFind.getQuery().getBuilding6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality1()	!= null ?	addressFind.getQuery().getLocality1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality2()	!= null ?	addressFind.getQuery().getLocality2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality3()	!= null ?	addressFind.getQuery().getLocality3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality4()	!= null ?	addressFind.getQuery().getLocality4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality5()	!= null ?	addressFind.getQuery().getLocality5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getLocality6()	!= null ?	addressFind.getQuery().getLocality6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getPostalCode1()	!= null ?	addressFind.getQuery().getPostalCode1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getPostalCode2()	!= null ?	addressFind.getQuery().getPostalCode2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getPostalCode3()	!= null ?	addressFind.getQuery().getPostalCode3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine1()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine2()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine3()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine4()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine5()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getCountrySpecificLocalityLine6()	!= null ?	addressFind.getQuery().getCountrySpecificLocalityLine6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet1()	!= null ?	addressFind.getQuery().getStreet1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet2()	!= null ?	addressFind.getQuery().getStreet2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet3()	!= null ?	addressFind.getQuery().getStreet3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet4()	!= null ?	addressFind.getQuery().getStreet4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet5()	!= null ?	addressFind.getQuery().getStreet5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getStreet6()	!= null ?	addressFind.getQuery().getStreet6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber1()	!= null ?	addressFind.getQuery().getNumber1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber2()	!= null ?	addressFind.getQuery().getNumber2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber3()	!= null ?	addressFind.getQuery().getNumber3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber4()	!= null ?	addressFind.getQuery().getNumber4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber5()	!= null ?	addressFind.getQuery().getNumber5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getNumber6()	!= null ?	addressFind.getQuery().getNumber6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince1()	!= null ?	addressFind.getQuery().getProvince1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince2()	!= null ?	addressFind.getQuery().getProvince2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince3()	!= null ?	addressFind.getQuery().getProvince3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince4()	!= null ?	addressFind.getQuery().getProvince4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince5()	!= null ?	addressFind.getQuery().getProvince5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getProvince6()	!= null ?	addressFind.getQuery().getProvince6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine1()	!= null ?	addressFind.getQuery().getDeliveryAddressLine1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine2()	!= null ?	addressFind.getQuery().getDeliveryAddressLine2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine3()	!= null ?	addressFind.getQuery().getDeliveryAddressLine3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine4()	!= null ?	addressFind.getQuery().getDeliveryAddressLine4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine5()	!= null ?	addressFind.getQuery().getDeliveryAddressLine5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryAddressLine6()	!= null ?	addressFind.getQuery().getDeliveryAddressLine6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService1()	!= null ?	addressFind.getQuery().getDeliveryService1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService2()	!= null ?	addressFind.getQuery().getDeliveryService2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService3()	!= null ?	addressFind.getQuery().getDeliveryService3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService4()	!= null ?	addressFind.getQuery().getDeliveryService4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService5()	!= null ?	addressFind.getQuery().getDeliveryService5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getDeliveryService6()	!= null ?	addressFind.getQuery().getDeliveryService6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine1()	!= null ?	addressFind.getQuery().getFormattedAddressLine1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine2()	!= null ?	addressFind.getQuery().getFormattedAddressLine2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine3()	!= null ?	addressFind.getQuery().getFormattedAddressLine3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine4()	!= null ?	addressFind.getQuery().getFormattedAddressLine4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine5()	!= null ?	addressFind.getQuery().getFormattedAddressLine5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine6()	!= null ?	addressFind.getQuery().getFormattedAddressLine6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine7()	!= null ?	addressFind.getQuery().getFormattedAddressLine7()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine8()	!= null ?	addressFind.getQuery().getFormattedAddressLine8()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine9()	!= null ?	addressFind.getQuery().getFormattedAddressLine9()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine10()	!= null ?	addressFind.getQuery().getFormattedAddressLine10()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine11()	!= null ?	addressFind.getQuery().getFormattedAddressLine11()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine12()	!= null ?	addressFind.getQuery().getFormattedAddressLine12()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine13()	!= null ?	addressFind.getQuery().getFormattedAddressLine13()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine14()	!= null ?	addressFind.getQuery().getFormattedAddressLine14()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine15()	!= null ?	addressFind.getQuery().getFormattedAddressLine15()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine16()	!= null ?	addressFind.getQuery().getFormattedAddressLine16()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine17()	!= null ?	addressFind.getQuery().getFormattedAddressLine17()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine18()	!= null ?	addressFind.getQuery().getFormattedAddressLine18()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getFormattedAddressLine19()	!= null ?	addressFind.getQuery().getFormattedAddressLine19()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getOrganization1()	!= null ?	addressFind.getQuery().getOrganization1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getOrganization2()	!= null ?	addressFind.getQuery().getOrganization2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getOrganization3()	!= null ?	addressFind.getQuery().getOrganization3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getContact1()	!= null ?	addressFind.getQuery().getContact1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getContact2()	!= null ?	addressFind.getQuery().getContact2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getContact3()	!= null ?	addressFind.getQuery().getContact3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getRecipientLine1()	!= null ?	addressFind.getQuery().getRecipientLine1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getRecipientLine2()	!= null ?	addressFind.getQuery().getRecipientLine2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getRecipientLine3()	!= null ?	addressFind.getQuery().getRecipientLine3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue1()	!= null ?	addressFind.getQuery().getResidue1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue2()	!= null ?	addressFind.getQuery().getResidue2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue3()	!= null ?	addressFind.getQuery().getResidue3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue4()	!= null ?	addressFind.getQuery().getResidue4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue5()	!= null ?	addressFind.getQuery().getResidue5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getResidue6()	!= null ?	addressFind.getQuery().getResidue6()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding1()	!= null ?	addressFind.getQuery().getSubBuilding1()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding2()	!= null ?	addressFind.getQuery().getSubBuilding2()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding3()	!= null ?	addressFind.getQuery().getSubBuilding3()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding4()	!= null ?	addressFind.getQuery().getSubBuilding4()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding5()	!= null ?	addressFind.getQuery().getSubBuilding5()	: "" )  + ",");
		strBuf.append((addressFind.getQuery().getSubBuilding6()	!= null ?	addressFind.getQuery().getSubBuilding6()	: "" )  + ",");
		
		// OUTPUT 
//		strBuf.append(",");
		
		// TODO
		// 7 rows
		

//		if (result != null){
//			// RESULT
//			strBuf.append(result.getIso3() + "," );
//			strBuf.append(result.getModeUsed() + ",");
//			strBuf.append(result.getPreferredLanguage() + ",");
//			strBuf.append(result.getPreferredScript() + ",");
//			strBuf.append(result.getProcessStatus() + ",");
//			strBuf.append(result.isCountOverFlow() + ",");
//			
//			// RESULT DATA
//			AddressData addressData = result.getAddressData().get(0);
//			strBuf.append(addressData.getElementInputStatus() + ",");
//			strBuf.append(addressData.getElementResultStatus() + ",");
//			strBuf.append(addressData.getElementRelevance() + ",");
//			strBuf.append(addressData.getMailabilityScore() + ",");
//			strBuf.append(addressData.getResultPercentage() + ",");
//			strBuf.append(addressData.getCassStatus() + ",");
//			strBuf.append(addressData.getSerpStatus() + ",");
//			strBuf.append(addressData.getSnaStatus() + ",");
//			strBuf.append(addressData.getSupplementaryGBStatus() + ",");
//			strBuf.append(addressData.getSupplementaryUSStatus() + ",");
//			
//			// ADDRESS ELEMENTS-DEFAULT TYPES
//			
//			//addressData.getSupplementaryUs()
//			
//		}

		return strBuf.toString();
	}
	
	// TODO
	// batch job run 24*7
	
	
}
