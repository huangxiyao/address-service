package com.hp.it.cas.match.batch;

import java.util.ArrayList;

import com.hp.it.cas.match.address.AddressQuery;

/**
 * a record from the input file.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressFind {
	private ArrayList<String> emailList;
	private String outputFileName;
	private String modeUsed;
	private AddressQuery query;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public String getModeUsed() {
		return modeUsed;
	}

	public void setModeUsed(String modeUsed) {
		this.modeUsed = modeUsed;
	}

	public AddressQuery getQuery() {
		return query;
	}

	public void setQuery(AddressQuery query) {
		this.query = query;
	}

}
