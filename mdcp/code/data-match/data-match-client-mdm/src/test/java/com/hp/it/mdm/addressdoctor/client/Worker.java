package com.hp.it.mdm.addressDoctor.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.siperian.mrm.cleanse.api.CleanseException;
import com.siperian.mrm.cleanse.api.CleanseFunction;
import com.siperian.mrm.cleanse.api.CleanseFunctionDescriptor;
import com.siperian.mrm.cleanse.api.CleanseLibrary;
import com.siperian.mrm.cleanse.api.Parameter;
import com.siperian.mrm.cleanse.api.ParameterTypes;

public class Worker extends Thread
{
	//cleanse properties file name
	String configFile = Worker.class
			.getResource("/cleanse.properties").getPath();
	String inputFile = Worker.class
			.getResource("/inputs.txt").getPath();
	String outputFile = Worker.class
			.getResource("/outputs.txt").getPath();
	//name of the property key for function to test
	String funcToTest = "function_to_test";
	//Name of the function (service) to be called in cleanse
	String funcName; 

	Properties cleanseProps = new Properties();
	CleanseLibrary lib;
	CleanseFunction func;
	//names of the outputs specified 
	//in the adapter function descriptor
	String[] adapterOutputNames;
	//names of the inputs specified
	//in the adapter function descriptor
	Parameter[] adapterInputs;
	//names of the inputs specified in the file
	String[] fileInputNames;
	int[] fileInputPtr;

	//create UTF8-aware reader and writer:
	BufferedReader bufRead = null;
	BufferedWriter bufWrite = null;
	

	boolean allGood = true;

	Logger log = Logger.getLogger(Worker.class);

	Worker(){

	}

	/**Tests single-threaded adapter functionality*/
	public void run()
	{
		log.info("Starting log4j configuration");

		loadProps();

		initLib();

		getFunction();

		preProcessing();

		performCleanse();

		if (allGood) {
			System.out.println("Operation completed successfully");
		}
	}

	/**Loads the cleanse properties file*/
	private void loadProps()
	{
		try 
		{
			FileInputStream fi = new FileInputStream(configFile);
			cleanseProps.load(fi);
			fi.close();
		}
		catch (Exception e)
		{
			handleError("loading properties", e);
		}
	}

	/**Initialize cleanse library*/
	private void initLib()
	{
		try 
		{ 
			//get the name of the library to load
			String className = cleanseProps.getProperty("classname");
			//get the class loader
			ClassLoader cl = ClassLoader.getSystemClassLoader();
			//load class
			Class libraryClass = cl.loadClass(className);
			//create new instance of the loaded class
			Object object = libraryClass.newInstance();
			//check that instance is of proper type
			if(!(object instanceof CleanseLibrary)) {
				throw new CleanseException("SIP-11090", className, null, null);
			}
			//initilize the library
			lib = (CleanseLibrary)object;
			lib.initialize(cleanseProps);
		}
		catch (Exception e)
		{
			handleError("initializing library", e);
		}
	}

	/**gets the function to be called*/
	private void getFunction() {
		//get function name
		funcName = cleanseProps.getProperty(funcToTest);
		//get function from the cleanse library
		func = (CleanseFunction) lib.getCleanseFunction(funcName);
		//if function not found, display error
		if (func == null)
		{
			System.err.println("There is no function by the names "+funcName+" in Library "+lib.getLibraryDescriptor().getName() );
			System.exit(1);
		}
	}

	/**Initialize UTF8-aware buffered reader and writer*/
	private void initReaderAndWriter() {
		try
		{
			FileInputStream fis = new FileInputStream(inputFile);
			bufRead = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			bufWrite = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
		}
		catch(Exception e){
			handleError("initializing buffered reader and writer", e);
		}
	}

	/**Perform pre-processing checks and operations*/
	private void preProcessing()
	{
		//contents of the first non-empty line in the file
		String inputNamesLine = null;

		//initialize buffered reader and writer
		initReaderAndWriter();

		//get the names of inputs and outputs from adapter
		getInputOutputNames();

		//get the names of inputs from file
		inputNamesLine = getInputNamesFromFile();

		//tokenize the line of input names
		fileInputNames = inputNamesLine.split("~",-1);

		//Allocate an array to store pointers to adapter input fields
		fileInputPtr = new int[fileInputNames.length];

		//make sure that the input names in the 
		//file are what is expected by the function
		checkInputNames();

		//print the names of the outputs to the output file
		printOutputNames();


	}

	/**Gets the input names from input file*/
	private String getInputNamesFromFile() 
	{
		//contents of the current line
		String curLine = null;

		try
		{
			//read the first line
			curLine = bufRead.readLine();

			//while file contains more lines
			while (curLine != null)
				//if line is empty, read next
				if (curLine.length() == 0)
					curLine = bufRead.readLine();
				else //otherwise break out of loop
					break;

			//if input file is empty,
			//populate it with input names
			if (curLine == null)
			{
				populateFileInputNames();
			}
		}
		catch (Exception e)
		{
			handleError("getting inputs from file", e);
		}

		return curLine;
	}



	/**Populates inputs.txt with the input names 
	 * for the current function*/
	private void populateFileInputNames() 
	{
		try
		{
			//the line to write to the file
			StringBuffer inputsLine = new StringBuffer();
			//create output stream for inputs.txt
			FileOutputStream fos = new FileOutputStream(inputFile);
			//create UTF8-aware bufferedWriter
			BufferedWriter bWrite = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
			System.out.println("Populating input names in inputs.txt automatically...");
			//append the tilde-delimited input names
			for (int i = 0; i < adapterInputs.length; i++)
				inputsLine.append(adapterInputs[i].getName()+"~");
			//remove terminating tilde
			inputsLine.deleteCharAt(inputsLine.length()-1);
			//write the line containing input names
			bWrite.write(inputsLine.toString());
			bWrite.close();
			//display a notification message
			System.out.println("Please populate inputs.txt with input values and rerun");
			errorWrapUp();
			System.out.println("Exiting");
			System.exit(0);
		}
		catch (Exception e)
		{
			handleError("populating empty input file with input names", e);
		}
	}



	/**process inputs.txt, cleanse the data
	 * and populate outputs.txt*/
	private  void performCleanse()
	{
		long totalTime;
		int numCalls = 0;
		
		Map contextMap = new HashMap();
		try 
		{
			//read first line of values
			String curLine = bufRead.readLine();

			//get the current time
			totalTime = System.currentTimeMillis();
			while (curLine != null)
			{
				Map inputMap = new HashMap(10);
				Map outputMap = new HashMap(10);
				//increment call counter
				if (numCalls % 500 == 0){
					log.info("current record "+ numCalls+" is '"+curLine+"'");
				}
				if (numCalls % 5000 == 0){
					Runtime rt = Runtime.getRuntime();
					log.info("Total Memory = "
							+ rt.totalMemory()
							+ " Free Memory = "
							+ rt.freeMemory());
					
				}
				numCalls++;
				//populate the input map
				populateInputs(curLine, inputMap);
				populateOutputsWithNull(outputMap);
				//perform the cleanse
				func.cleanse(contextMap, inputMap, outputMap);

				//print the outputs to a file only print out every 100th to reduce volume
				//if (numCalls % 100 == 0){
				printOutputs(outputMap);
				//}


				//read next line
				curLine = bufRead.readLine();

			}
			//update the timer
			totalTime = System.currentTimeMillis() - totalTime;
			//print timing info
			printTimeInfo(totalTime, numCalls);

			bufRead.close();
			bufWrite.close();
		}
		catch (Exception e)
		{
			handleError("cleansing", e);
		}
	}

	/**Prints the timing information*/
	private void printTimeInfo(long totalTime, int numCalls) {
		long timePerCall;
		System.out.println("Time to cleanse "+numCalls+
				" records: "+totalTime+" ms");
		if (numCalls==0)
			timePerCall = 0;
		else
			timePerCall = totalTime/numCalls;

		System.out.println("Time per record: "
				+timePerCall+" ms");
	}

	/**Makes sure that the input names in the input 
	file are what is expected by the function*/
	private void checkInputNames() 
	{
		//flag whether the input name from input.txt
		//is found in the function input names
		boolean found = false;

		//iterate through all keys in the input name array
		for (int i = 0; i < fileInputNames.length; i++)
		{
			//for all input names in the function
			for (int j = 0; j < adapterInputs.length; j++)
				//if name found in the function, set flag to true
				if (adapterInputs[j].getName().compareTo(fileInputNames[i])==0) {
					found = true;
					fileInputPtr[i] = j;
					break;
				}
			//if the name is not found at the end of the
			//cycle, display the error message
			if (!found) {
				System.err.println("Input name "+fileInputNames[i]+" from the inputs.txt is not found in the function descriptor for "+funcName);
				fileInputPtr[i] = -1;
			}
			//reset the flag for the next cycle
			found = false;
		}
	}

	/**Prints the output names to the output file*/
	private void printOutputNames()
	{
		try
		{
			for (int i = 0; i< adapterOutputNames.length; i++)
			{
				bufWrite.write(adapterOutputNames[i]);
				bufWrite.write("~");
			}
			bufWrite.newLine();
		}
		catch (IOException e)
		{
			handleError("printing outputs", e);
		}
	}

	/**Retrieves the names of the inputs and outputs for the current function*/
	private  void getInputOutputNames() 
	{
		//get the cleanse function descriptor
		CleanseFunctionDescriptor funcDesc;
		Iterator iter = lib.getLibraryDescriptor().getFunctionDescriptors().iterator();
		do //iterate through functions
		{
			funcDesc = (CleanseFunctionDescriptor)iter.next();
		} //until the one corresponding to funcName found
		while (funcDesc.getName().compareTo(funcName)!=0);


		//get output parameters
		List outputNames = funcDesc.getOutputs();
		adapterOutputNames = getParametersNames(outputNames);

		//get input parameters
		List inputNames = funcDesc.getInputs();
		adapterInputs = getParameters(inputNames);


	}

	/**Retrieves the parameter names from the list*/
	private String[] getParametersNames(List list) {

		//convert parameter list to array
		Object[] params = list.toArray();

		//populate the names array
		String[] names = new String[params.length];

		for (int i = 0; i<params.length; i++)
			names[i]= ((Parameter)params[i]).getName();

		return names;
	}

	/**Retrieves the parameter names from the list*/
	private Parameter[] getParameters(List list) {

		//convert parameter list to array
		Object[] params = list.toArray();

		//populate the names array
		Parameter[] parm = new Parameter[params.length];

		for (int i = 0; i<params.length; i++)
			parm[i]= (Parameter)params[i];

		return parm;
	}

	/**Populates the adapter input map*/
	private void populateInputs(String curLine, Map inputMap)
	{
		//tokenize the line of input values
		String[] inputValues = curLine.split("~",-1);

		//put the input values into the map
		for (int i = 0; i < fileInputNames.length; i++) {
			Object val = convertToType(fileInputPtr[i], inputValues[i]);
			if (val != null){
				logdebug("Setting '" +fileInputNames[i] + "' to value '"+ val +"'");
				inputMap.put(fileInputNames[i], val);
			}
		}
	}
	
	/**Populates the adapter output map*/
	private void populateOutputsWithNull(Map outputMap)
	{
		// required for Address Doctor adapter
		String[] fieldsToGather = {
				"Building_COMPLETE_ALL",
				"CountryCode_ISO_3",
				"Locality_ALL",
				"POBox_COMPLETE",
				"PostalCode_FORMATTED",
				"Province_ABBREVIATION",
				"Street_COMPLETE_ALL",
				"ValidationStatus",
				"ValidationStatusCode"
		};
		
		//put the required output values into the map
		for (int i = 0; i < adapterOutputNames.length; i++) {
			outputMap.put(adapterOutputNames[i], null);
		}
	}


	private final Object convertToType(int typePtr, String inValue) {
		/* return value of appropriate type */

		if (inValue.equals("")){
			return null;
		}

		if (adapterInputs[typePtr].getType().equals(ParameterTypes.STRING)){
			return inValue;
		}
		
		if (typePtr == -1)
			return null;

		if (adapterInputs[typePtr].getType().equals(ParameterTypes.BOOLEAN)){
			return Boolean.valueOf(inValue);
		}
		if (adapterInputs[typePtr].getType().equals(ParameterTypes.DATE)){
			DateFormat df = DateFormat.getDateInstance();
			try {
				return df.parse(inValue);
			} catch (Exception e){
				log.warn("Could not format Date "+inValue + " to a date returning current date");
				return new Date();
			}
		}
		if (adapterInputs[typePtr].getType().equals(ParameterTypes.FLOAT)){
			return Float.valueOf(inValue);
		}
		if (adapterInputs[typePtr].getType().equals(ParameterTypes.INTEGER)){
			return Integer.valueOf(inValue);
		}
		
		return null;
	}

	/**Prints the tilde-delimited outputs to outputs.txt*/
	private void printOutputs(Map outputMap)
	{
		logdebug("Output map size :" + outputMap.size());
		//current output value
		Object curVal;
		try 
		{
			for (int i = 0; i< adapterOutputNames.length; i++)
			{
				//get the current value from the map

				curVal = outputMap.get(adapterOutputNames[i]);

				//set to empty string if null
				if (curVal == null){
					curVal = "";
				} else {
					logdebug("field name '"+ adapterOutputNames[i] + "' value '"+ curVal+"'");
				}

				//print curVal followed by tilde to the file
				bufWrite.write(curVal.toString());
				bufWrite.write("~");
			}
			bufWrite.newLine();
		} 
		catch (IOException e) 
		{
			handleError("printing outputs", e);
		}
	}
	
	private void logdebug(String text){
		if (log.isDebugEnabled()){
			log.debug(text);
		}
	}

	/**Handle erroneous situations*/
	private void handleError(String action, Exception e)
	{
		System.err.println("Problem "+action+": "+e.getLocalizedMessage());
		e.printStackTrace();
		errorWrapUp();
		allGood = false;
	}


	/**Perform wrap-up operations if error occured*/
	private void errorWrapUp() 
	{
		//close buffered reader and writer if instantiated
		try 
		{
			if (bufRead != null)
				bufRead.close();
			if (bufWrite != null)
				bufWrite.close();
		}
		catch (IOException ioE)
		{
			System.err.println("Problem closing buffered reader or writer: "+ioE.getLocalizedMessage());
			ioE.printStackTrace();
		}

	}

}