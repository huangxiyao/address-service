package com.hp.it.cas.match.batch;

import java.util.List;

/**
 * a record from the input file.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressFind {
	private List<String> emailList;
	private String outputFileName;
	private AddressInput addressInput;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public AddressInput getAddressInput() {
		return addressInput;
	}

	public void setAddressInput(AddressInput addressInput) {
		this.addressInput = addressInput;
	}
}
