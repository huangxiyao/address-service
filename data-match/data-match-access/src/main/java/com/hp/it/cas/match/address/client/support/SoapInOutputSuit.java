package com.hp.it.cas.match.address.client.support;

import com.hp.it.cas.match.address.soap.ArrayOfString;

/**
 * Its role is collecting the important attributes together for process
 * ArrayOfString query input to compare the result, bring one SoapInOutputSuitID
 * to identify each SoapInOutputSuit and ArrayOfString input value and
 * representative code of ArrayOfString output string from
 * addressResultProperty.properties together as one SoapInOutputSuit.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class SoapInOutputSuit {

	private String sioID;
	private ArrayOfString input;
	private String outputCode;

	/**
	 * Get SoapInOutputSuitID data
	 * 
	 * @return SoapInOutputSuitID
	 */
	public String getSioID() {
		return sioID;
	}

	/**
	 * Set SoapInOutputSuitID input data.
	 * 
	 * @param sioID
	 *            SoapInOutputSuitID data.
	 */
	public void setSioID(String sioID) {
		this.sioID = sioID;
	}

	/**
	 * Get ArrayOfString input data
	 * 
	 * @return ArrayOfString data
	 */
	public ArrayOfString getInput() {
		return input;
	}

	/**
	 * Set ArrayOfString input data.
	 * 
	 * @param input
	 *            ArrayOfString input data.
	 */
	public void setInput(ArrayOfString input) {
		this.input = input;
	}

	/**
	 * Get output result string code data for soap access
	 * 
	 * @return output result string code data
	 */
	public String getOutputCode() {
		return outputCode;
	}

	/**
	 * Set output result string code data for soap access.
	 * 
	 * @param outputCode
	 *            outputCode data.
	 */
	public void setOutputCode(String outputCode) {
		this.outputCode = outputCode;
	}

}
