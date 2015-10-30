package com.hp.it.mdm.addressdoctor.client;

import java.util.Map;
import com.siperian.mrm.cleanse.api.CleanseFunctionDescriptor;
import com.siperian.mrm.cleanse.api.Parameter;
import org.apache.log4j.Logger;

public abstract class AddressDoctorClient {
	protected String functionName;
	protected String functionDesc = null;
	protected String[] functionInputName = null;
	protected String[] functionInputType = null;
	protected String[] functionInputDesc = null;
	protected String[] functionOutputName = null;
	protected String[] functionOutputType = null;
	protected String[] functionOutputDesc = null;

	public static final Logger log = Logger.getLogger(AddressDoctorClient.class);

	public CleanseFunctionDescriptor getFunction() {
		CleanseFunctionDescriptor Function = new CleanseFunctionDescriptor();

		Function = new CleanseFunctionDescriptor();

		Function.setName(functionName);
		log.debug("Function name in init " + functionName);

		Function.setDescription(functionDesc);

		for (int i = 0, j = functionInputName.length; i < j; i++) {
			Function.addInput(new Parameter(functionInputName[i],
					functionInputType[i], functionInputDesc[i]));
		}

		for (int i = 0, j = functionOutputName.length; i < j; i++) {
			Function.addOutput(new Parameter(functionOutputName[i],
					functionOutputType[i], functionOutputDesc[i]));
		}

		return Function;
	}

	// object needs to be available;
	public Object clone() {
		return null;
	}

	abstract public void disconnect();

	abstract public void init();

	abstract public void cleanse(Map context, Map input, Map output);

}