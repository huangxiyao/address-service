package com.hp.it.cas.match.batch;

import java.util.ArrayList;

import com.hp.it.cas.match.address.AddressQuery;

public class AddressFind {
	private ArrayList<String> emailList;
	private String function;
	private AddressQuery query;

	public ArrayList<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public AddressQuery getQuery() {
		return query;
	}

	public void setQuery(AddressQuery query) {
		this.query = query;
	}

}
