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

	// TODO add java doc
	public AddressInput getAddressInput() {
		return addressInput;
	}

	public void setAddressInput(AddressInput addressInput) {
		this.addressInput = addressInput;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
}
