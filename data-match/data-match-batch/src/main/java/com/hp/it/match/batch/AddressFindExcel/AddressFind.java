package com.hp.it.match.batch.AddressFindExcel;

import java.util.List;

import com.hp.it.match.batch.AddressFindExcel.bean.AddressInput;

/**
 * AddressFind object contains input and output info.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressFind {
	private AddressInput addressInput;
	private String errorMessage;
	private String outputFileName;
	private List<String> emailList;

	/**
	 * Get the input data from the input file.
	 * 
	 * @return addressInput
	 */
	public AddressInput getAddressInput() {
		return addressInput;
	}

	/**
	 * Set the value of the input data.
	 * 
	 * @param addressInput
	 */
	public void setAddressInput(AddressInput addressInput) {
		this.addressInput = addressInput;
	}

	/**
	 * Get the error message.
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Set error message in the output file.
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Get the output file name from the input file.
	 * 
	 * @return outputFileName
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * Set the output file name in the input file.
	 * 
	 * @param outputFileName
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	/**
	 * Get the email address from the input file.
	 * 
	 * @return emailList
	 * 
	 */
	public List<String> getEmailList() {
		return emailList;
	}

	/**
	 * Set the email address in the input file.
	 * 
	 * @param emailList
	 */
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
}
