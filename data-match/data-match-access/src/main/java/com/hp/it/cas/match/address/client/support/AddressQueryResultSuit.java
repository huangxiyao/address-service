package com.hp.it.cas.match.address.client.support;

import com.hp.it.cas.match.address.AddressQuery;

/**
 * Its role is collecting the important attributes together for process address
 * query input to compare the result.Every query has one the unique result, but
 * because of five results formation for rest access, every query may have five
 * different result.So bring one AddressQuery instance and five result string
 * representative code from addressResultProperty.properties and add the unique
 * AddressQueryResultSuitID together as one AddressQueryResultSuit.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class AddressQueryResultSuit {

	private AddressQuery addressQuery;
	private String aqsID;
	private String validatedAddressResultCode;
	private String addressSuggestionsResultCode;
	private String certifiedAddressResultCode;
	private String looselyValidatedResultCode;
	private String fastCompletionAddressResultCode;

	/**
	 * Get AddressQuery input data
	 * 
	 * @return AddressQuery
	 */
	public AddressQuery getAddressQuery() {
		return addressQuery;
	}

	/**
	 * Set AddressQuery input data.
	 * 
	 * @param addressQuery
	 *            AddressQuery data.
	 */
	public void setAddressQuery(AddressQuery addressQuery) {
		this.addressQuery = addressQuery;
	}

	/**
	 * Get AddressQuerySuitID data
	 * 
	 * @return AddressQuerySuitID
	 */
	public String getAqsID() {
		return aqsID;
	}

	/**
	 * Set AddressQuerySuitID input data
	 * 
	 * @param aqsID
	 *            AddressQuerySuitID data
	 */
	public void setAqsID(String aqsID) {
		this.aqsID = aqsID;
	}

	/**
	 * Get ValidatedAddressResultCode data, The ID for result string for
	 * validatedAddress access
	 * 
	 * @return ValidatedAddressResultCode
	 */
	public String getValidatedAddressResultCode() {
		return validatedAddressResultCode;
	}

	/**
	 * Set ValidatedAddressResultCode data.
	 * 
	 * @param validatedAddressResultCode
	 *            validatedAddressResultCode data
	 */
	public void setValidatedAddressResultCode(String validatedAddressResultCode) {
		this.validatedAddressResultCode = validatedAddressResultCode;
	}

	/**
	 * Get AddressSuggestionsResultCode data, The ID for result string for
	 * AddressSuggestions access
	 * 
	 * @return AddressSuggestionsResultCode data
	 */
	public String getAddressSuggestionsResultCode() {
		return addressSuggestionsResultCode;
	}

	/**
	 * Set addressSuggestionsResultCode data
	 * 
	 * @param addressSuggestionsResulCode
	 *            addressSuggestionsResultCode data
	 */
	public void setAddressSuggestionsResultCode(String addressSuggestionsResultCode) {
		this.addressSuggestionsResultCode = addressSuggestionsResultCode;
	}

	/**
	 * Get CertifiedAddressResultCode, The ID for result string for
	 * CertifiedAddress access
	 * 
	 * @return CertifiedAddressResultCode data
	 */
	public String getCertifiedAddressResultCode() {
		return certifiedAddressResultCode;
	}

	/**
	 * Set CertifiedAddressResultCode data.
	 * 
	 * @param certifiedAddressResultCode
	 *            certifiedAddressResultCode data
	 */
	public void setCertifiedAddressResultCode(String certifiedAddressResultCode) {
		this.certifiedAddressResultCode = certifiedAddressResultCode;
	}

	/**
	 * Get LooselyValidatedResultCode, The ID for result string for
	 * LooselyValidated access
	 * 
	 * @return LooselyValidatedResultCode data
	 */
	public String getLooselyValidatedResultCode() {
		return looselyValidatedResultCode;
	}

	/**
	 * Set looselyValidatedResultCode data
	 * 
	 * @param looselyValidatedResultCode
	 *            looselyValidatedResultCode data
	 * 
	 */
	public void setLooselyValidatedResultCode(String looselyValidatedResultCode) {
		this.looselyValidatedResultCode = looselyValidatedResultCode;
	}

	/**
	 * Set fastCompletionAddressResultCode data
	 * 
	 * @param fastCompletionAddressResultCode
	 */
	public void setFastCompletionAddressResultCode(String fastCompletionAddressResultCode) {
		this.fastCompletionAddressResultCode = fastCompletionAddressResultCode;
	}

	/**
	 * Get fastCompletionAddressResultCode, The ID for result string for
	 * fastCompletionAddressResultCode access
	 * @return fastCompletionAddressResultCode
	 */
	public String getFastCompletionAddressResultCode() {
		return fastCompletionAddressResultCode;
	}

}
