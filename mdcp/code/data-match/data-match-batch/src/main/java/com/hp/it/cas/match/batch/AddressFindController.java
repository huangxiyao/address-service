package com.hp.it.cas.match.batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
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
import com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy;

/**
 * 
 */
public class AddressFindController implements TransactionController<AddressFind, Void>{
	
	private static final String ADDRESSDOCTOR_FEZOUTPUTPATH = "addressDoctorFEZOutputPath" ;
	private static final String ADDRESSDOCTOR_ENV = "addressDoctorEnv";
	private final Configuration configuration;
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
	// verify the relationship between MODE and Function
	private enum Function {
		looselyValidatedAddress, addressSuggestions, fastCompletionAddress, certifiedAddress, validatedAddress, 
	};
	
	
	// temporary save the INPUT and Result for each Input file
	private HashMap<AddressFind, AddressQueryResult> outputList = new HashMap<AddressFind, AddressQueryResult>();
	

	// temporary save email
	private ArrayList<String> emailList = null;

	public AddressFindController(Configuration configuration) {
		this.configuration = configuration;
		this.addressDoctorEnv  = configuration.getJobParameters().get(ADDRESSDOCTOR_ENV);
		this.addressDoctorFEZOutputPath = configuration.getJobParameters().get(ADDRESSDOCTOR_FEZOUTPUTPATH);
	}

	@Override
	public Void process(AddressFind addressFind, MessageContext messageContext, LockContext lockContext) throws Exception {
		
		// TODO 
		// need review
		
		if (emailList == null && addressFind.getEmailList() != null){
			emailList = addressFind.getEmailList();
			System.out.println(emailList);
			return null;
		} else if (emailList != null && addressFind.getEmailList() != null) {
			
			sendEmail(emailList, saveOutput(outputList, addressDoctorFEZOutputPath));
			
			emailList = addressFind.getEmailList();

			// clear temporary var 
			outputList.clear();
			
			return null;
		} else if (addressFind.getEmailList() == null){
			
			// call AD Service
			AddressQueryResult result = callADServices(addressFind);

			// save Input and Result
			System.out.println(result);
			outputList.put(addressFind, result);
		} 
		
		return null;
	}
	

	
	// Call AD Service
	public AddressQueryResult callADServices(AddressFind addressFind){
		System.out.println("call AD service....");
//		com.hp.it.cas.match.address.SecurityContextTestController securityController = new com.hp.it.cas.match.address.SecurityContextTestController();
//		securityController.collectAndSetupSecurityContext(new ClientTestEnvironment("w-mdcp:prd-http", null, null));

		
		AddressQueryResult result = null;
//		String endpoint = "";
//		String function = addressFind.getFunction();
		
//		if (ModeUse.BATCH.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.looselyValidatedAddress.name();
//			LooselyValidatedAddressFinderRestProxy proxy = new LooselyValidatedAddressFinderRestProxy(endpoint);

//			endpoint = addressDoctorEnv + Function.validatedAddress.name();
//			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
//			result = proxy.find(addressFind.getQuery());
//		}
//
//		if (ModeUse.INTERACTIVE.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.addressSuggestions.name();
//			AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(endpoint);
//			result = proxy.suggest(addressFind.getQuery());
//		}
//
//		if (ModeUse.FASTCOMPLETION.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.fastCompletionAddress.name();
//			FastCompletionAddressFinderRestProxy proxy = new FastCompletionAddressFinderRestProxy(endpoint);
//			result = proxy.find(addressFind.getQuery());
//		}
//
//		if (ModeUse.CERTIFIED.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.certifiedAddress.name();
//			CertifiedAddressFinderRestProxy proxy = new CertifiedAddressFinderRestProxy(endpoint);
//			result = proxy.find(addressFind.getQuery());
//		}
//
//		if (ModeUse.PARSE.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.validatedAddress.name();
//			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
//			result = proxy.find(addressFind.getQuery());
//		}
//
//		if (ModeUse.COUNTRYRECOGNITION.name().equals(function)) {
//			endpoint = addressDoctorEnv + Function.validatedAddress.name();
//			ValidatedAddressFinderRestProxy proxy = new ValidatedAddressFinderRestProxy(endpoint);
//			result = proxy.find(addressFind.getQuery());
//		}

//		securityController.clearSecurityContext();

		return result;
		
	}
	
	// TODO
	// save the INPUT and Result in Output.csv and upload the OUTPUT 
	public IoPath saveOutput(HashMap<AddressFind, AddressQueryResult> outputList, String addressDoctorFEZOutputPath) throws IOException, URISyntaxException{
		File file = new File("src/test/resources/AddressDoctorBatchServicesOutputTemplate.csv");
		BufferedReader reader = IoFiles.newBufferedReader(IoPaths.get(file.toURI()), Charset.forName("UTF-8"));
		
		// File Path
		// TODO 
		// OUTPUT file name
		int number = (int)(Math.random()*1000);
		System.out.println(number);
		IoPath path = IoPaths.get(new URI(addressDoctorFEZOutputPath + "/AddressDoctorBatchServicesOutputTemplate" + number + ".csv"));
		

        if (IoFiles.exists(path)) {
            IoFiles.delete(path);
        }
        
        path = IoFiles.createFile(path);
        BufferedWriter writer = IoFiles.newBufferedWriter(path, Charset.forName("UTF-8"));
        writer.write(reader.readLine());
        writer.write("\r\n");
        writer.write(reader.readLine());
        writer.write("\r\n");
        
        // add INPUT and Result in the OUTPUT csv
        Iterator iter = outputList.entrySet().iterator();
        while (iter.hasNext()){
        	Map.Entry entry = (Map.Entry) iter.next(); 
        	AddressFind addressFind = (AddressFind)entry.getKey();
        	AddressQueryResult result = (AddressQueryResult)entry.getValue();
        	// TODO
        	writer.write("addressFind, and, result");
        	writer.write("\r\n");
        }
        
        writer.close();
		return path;
	}
	
	// TODO
	// send email to Customer
	public void sendEmail(ArrayList<String> emailList, IoPath path){
		System.out.println(path);
		System.out.println("send email");
		
	}
	
	// TODO
	// batch job run 24*7
	
	
}
