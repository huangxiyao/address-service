package com.hp.it.mdm.addressdoctor;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.hp.it.mdm.addressdoctor.client.AddressDoctorClient;
import com.hp.it.mdm.addressdoctor.client.AddressDoctorFunction;
import com.siperian.common.util.TypedProps;
import com.siperian.mrm.cleanse.api.CleanseException;
import com.siperian.mrm.cleanse.api.CleanseFunction;
import com.siperian.mrm.cleanse.api.CleanseFunctionDescriptor;
import com.siperian.mrm.cleanse.api.CleanseLibrary;
import com.siperian.mrm.cleanse.api.CleanseLibraryDescriptor;


/*
 * This is address doctor of an external cleanse adapter It uses a more elaborate model than many
 * adapters would need as it implements a pooling of the individual clients this would normally be
 * used when the "cost" of opening a connection to the service being used has a significant overhead
 * The pool basically allows for a single connection to be re-used If you do not need pooling you
 * can simplify the model greatly 
 */
public class Library implements CleanseLibrary {
	
	private TypedProps properties;
	private CleanseLibraryDescriptor lib;
    private HashMap<String, CleanseFunction> AddressDoctor = null;
	
	private static final Logger log = Logger.getLogger(Library.class);
	
	public CleanseLibraryDescriptor getLibraryDescriptor() {
		return lib;
	}
	
	public void initialize(Properties props) throws CleanseException {
        log.info("In Address Doctor initialization");
		
		
        AddressDoctor = new HashMap<String, CleanseFunction>(10);
	
		lib = new CleanseLibraryDescriptor();
        lib.setName("Address Doctor");
		lib.setDynamic(true);
		lib.setMajorVersion(1);
		lib.setMinorVersion(0);
        String libDescr = "Address Doctor Client";
		lib.setDescription(libDescr);
		
		TypedProps tProps = new TypedProps(props);
		
        initAddressDoctorFunction(AddressDoctor, tProps);
	}
	
	public CleanseFunction getCleanseFunction(String functionName) {
		AddressDoctorFunction res=null;
        if (AddressDoctor != null) {
            res = (AddressDoctorFunction) AddressDoctor.get(functionName);
		}
		return res;
	}
	
    private void initAddressDoctorFunction(HashMap<String, CleanseFunction> allFunctions, TypedProps tProps) {
		//get the properties file
		/*String configFileName = tProps.getString("config.file");
		
		if (configFileName == null){
			throw new RuntimeException("There must be a propery config.file for the adapter to find its config");
		}

		Properties exampleProps;
		log.debug("Initializing from config file:" + configFileName);
		  if(configFileName!=null){
			  File configFile = new File(configFileName);
			  
			  if(configFile.exists() && configFile.canRead()){
				  log.debug("Reading properties from config file:" + configFileName);
				  try {
					  FileInputStream fi = new FileInputStream(configFile);
					  exampleProps = new Properties();
					  exampleProps.load(fi);
					  properties = new TypedProps(exampleProps);
					  fi.close();
				  } catch (FileNotFoundException e) {
					  exampleProps=null;
					  throw new RuntimeException("could not find config file " + configFileName + " exception was " + e);
				  } catch (IOException e) {
					  exampleProps=null;
					  throw new RuntimeException("IO Exception accessing " + configFileName + " exception was " + e);
				  }
			  } else {
				  if (!configFile.exists()){
					  throw new RuntimeException("Config file " + configFileName + " does not exist ");
				  }
				  if (!configFile.canRead()){
					  throw new RuntimeException("Config file " + configFileName + " not readable ");
				  }
			  }
		  }*/
		
		properties = new TypedProps( new Properties());
		
        // Address Doctor Validations function
        AddressDoctorClient client = new AddressValidationClient(properties);
        CleanseFunctionDescriptor addressDoctorFunction = client.getFunction();

        lib.addFunctionDescriptor(addressDoctorFunction);

        allFunctions.put(addressDoctorFunction.getName(), new AddressDoctorFunction(client, properties));

        // Address Suggestion function
        client = new AddressSuggestionClient(properties);

        addressDoctorFunction = client.getFunction();

        lib.addFunctionDescriptor(addressDoctorFunction);

        allFunctions.put(addressDoctorFunction.getName(), new AddressDoctorFunction(client, properties));
		
        // Address Loose Validation function

        client = new AddressLooseValidationClient(properties);

        addressDoctorFunction = client.getFunction();
		
        lib.addFunctionDescriptor(addressDoctorFunction);

        allFunctions.put(addressDoctorFunction.getName(), new AddressDoctorFunction(client, properties));

        // Address Fast Completion function

        client = new AddressFastCompletionClient(properties);

        addressDoctorFunction = client.getFunction();

        lib.addFunctionDescriptor(addressDoctorFunction);

        allFunctions.put(addressDoctorFunction.getName(), new AddressDoctorFunction(client, properties));

        // Address Certification function

        client = new AddressCertificationClient(properties);

        addressDoctorFunction = client.getFunction();

        lib.addFunctionDescriptor(addressDoctorFunction);

        allFunctions.put(addressDoctorFunction.getName(), new AddressDoctorFunction(client, properties));
	}
	
	public void shutdown(){
		// code needs to be added here to release any required resources
	}
}
