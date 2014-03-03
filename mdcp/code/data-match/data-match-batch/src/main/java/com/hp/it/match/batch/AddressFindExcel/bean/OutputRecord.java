package com.hp.it.match.batch.AddressFindExcel.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.match.address.AddressElement;

/**
 * An OutputRecord object mapped with a record from output excel file.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class OutputRecord extends AddressInput {
	private final Logger logger = LoggerFactory.getLogger(OutputRecord.class);

	private String errorMessage;
	private String key1_RECORD_ID;
	private String key2_RECORD_ID;
	private String key3_RECORD_ID;
	private String key1_TRANSACTION_KEY;
	private String key2_TRANSACTION_KEY;
	private String key3_TRANSACTION_KEY;
	private String resultNumber;
	private String country_ISO3;
	private String mode_Used;
	private String preferred_Language;
	private String preferred_Script;
	private String processStatus;
	private String countOverFlow;
	private String elementInputStatus;
	private String elementResultStatus;
	private String elementRelevance;
	private String mailabilityScore;
	private String resultPercentage;
	private String cassStatus;
	private String serpStatus;
	private String snaStatus;
	private String supplementaryGBStatus;
	private String supplementaryUSStatus;
	private String country1_NAME_EN;
	private String locality1_COMPLETE;
	private String locality2_COMPLETE;
	private String locality3_COMPLETE;
	private String locality4_COMPLETE;
	private String locality5_COMPLETE;
	private String locality6_COMPLETE;
	private String postalCode1_FORMATTED;
	private String postalCode2_FORMATTED;
	private String postalCode3_FORMATTED;
	private String province1_COUNTRY_STANDARD;
	private String province2_COUNTRY_STANDARD;
	private String province3_COUNTRY_STANDARD;
	private String province4_COUNTRY_STANDARD;
	private String province5_COUNTRY_STANDARD;
	private String province6_COUNTRY_STANDARD;
	private String street1_COMPLETE;
	private String street2_COMPLETE;
	private String street3_COMPLETE;
	private String street4_COMPLETE;
	private String street5_COMPLETE;
	private String street6_COMPLETE;
	private String number1_COMPLETE;
	private String number2_COMPLETE;
	private String number3_COMPLETE;
	private String number4_COMPLETE;
	private String number5_COMPLETE;
	private String number6_COMPLETE;
	private String building1_COMPLETE;
	private String building2_COMPLETE;
	private String building3_COMPLETE;
	private String building4_COMPLETE;
	private String building5_COMPLETE;
	private String building6_COMPLETE;
	private String subBuilding1_COMPLETE;
	private String subBuilding2_COMPLETE;
	private String subBuilding3_COMPLETE;
	private String subBuilding4_COMPLETE;
	private String subBuilding5_COMPLETE;
	private String subBuilding6_COMPLETE;
	private String deliverService1_COMPLETE;
	private String deliverService2_COMPLETE;
	private String deliverService3_COMPLETE;
	private String deliverService4_COMPLETE;
	private String deliverService5_COMPLETE;
	private String deliverService6_COMPLETE;
	private String organization1_COMPLETE;
	private String organization2_COMPLETE;
	private String organization3_COMPLETE;
	private String contact1_COMPLETE;
	private String contact2_COMPLETE;
	private String contact3_COMPLETE;
	private String residue1_UNRECOGNIZED;
	private String residue2_UNRECOGNIZED;
	private String residue3_UNRECOGNIZED;
	private String residue4_UNRECOGNIZED;
	private String residue5_UNRECOGNIZED;
	private String residue6_UNRECOGNIZED;
	private String recipientLine_1;
	private String recipientLine_2;
	private String recipientLine_3;
	private String deliveryAddressLine_1;
	private String deliveryAddressLine_2;
	private String deliveryAddressLine_3;
	private String deliveryAddressLine_4;
	private String deliveryAddressLine_5;
	private String deliveryAddressLine_6;
	private String countrySpecificLocalityLine_1;
	private String countrySpecificLocalityLine_2;
	private String countrySpecificLocalityLine_3;
	private String countrySpecificLocalityLine_4;
	private String countrySpecificLocalityLine_5;
	private String countrySpecificLocalityLine_6;
	private String formattedAddressLine_1;
	private String formattedAddressLine_2;
	private String formattedAddressLine_3;
	private String formattedAddressLine_4;
	private String formattedAddressLine_5;
	private String formattedAddressLine_6;
	private String formattedAddressLine_7;
	private String formattedAddressLine_8;
	private String formattedAddressLine_9;
	private String formattedAddressLine_10;
	private String formattedAddressLine_11;
	private String formattedAddressLine_12;
	private String formattedAddressLine_13;
	private String formattedAddressLine_14;
	private String formattedAddressLine_15;
	private String formattedAddressLine_16;
	private String formattedAddressLine_17;
	private String formattedAddressLine_18;
	private String formattedAddressLine_19;
	private String completeAddress;
	private String country1_ABBREVIATION;
	private String country1_ISO2;
	private String country1_ISO3;
	private String country1_ISO_NUMBER;
	private String country1_NAME_CN;
	private String country1_NAME_DA;
	private String country1_NAME_DE;
	private String country1_NAME_ES;
	private String country1_NAME_FI;
	private String country1_NAME_FR;
	private String country1_NAME_GR;
	private String country1_NAME_HU;
	private String country1_NAME_IT;
	private String country1_NAME_JP;
	private String country1_NAME_KR;
	private String country1_NAME_NL;
	private String country1_NAME_PL;
	private String country1_NAME_PT;
	private String country1_NAME_RU;
	private String country1_NAME_SA;
	private String country1_NAME_SE;
	private String country2_ABBREVIATION;
	private String country2_ISO2;
	private String country2_ISO3;
	private String country2_ISO_NUMBER;
	private String country2_NAME_CN;
	private String country2_NAME_DA;
	private String country2_NAME_DE;
	private String country2_NAME_ES;
	private String country2_NAME_FI;
	private String country2_NAME_FR;
	private String country2_NAME_GR;
	private String country2_NAME_HU;
	private String country2_NAME_IT;
	private String country2_NAME_JP;
	private String country2_NAME_KR;
	private String country2_NAME_NL;
	private String country2_NAME_PL;
	private String country2_NAME_PT;
	private String country2_NAME_RU;
	private String country2_NAME_SA;
	private String country2_NAME_SE;
	private String country3_ABBREVIATION;
	private String country3_ISO2;
	private String country3_ISO3;
	private String country3_ISO_NUMBER;
	private String country3_NAME_CN;
	private String country3_NAME_DA;
	private String country3_NAME_DE;
	private String country3_NAME_ES;
	private String country3_NAME_FI;
	private String country3_NAME_FR;
	private String country3_NAME_GR;
	private String country3_NAME_HU;
	private String country3_NAME_IT;
	private String country3_NAME_JP;
	private String country3_NAME_KR;
	private String country3_NAME_NL;
	private String country3_NAME_PL;
	private String country3_NAME_PT;
	private String country3_NAME_RU;
	private String country3_NAME_SA;
	private String country3_NAME_SE;
	private String locality1_NAME;
	private String locality1_PREFERRED_NAME;
	private String locality1_SORTING_CODE;
	private String locality1_ADD_INFO;
	private String locality2_NAME;
	private String locality2_PREFERRED_NAME;
	private String locality2_SORTING_CODE;
	private String locality2_ADD_INFO;
	private String locality3_NAME;
	private String locality3_PREFERRED_NAME;
	private String locality3_SORTING_CODE;
	private String locality3_ADD_INFO;
	private String locality4_NAME;
	private String locality4_PREFERRED_NAME;
	private String locality4_SORTING_CODE;
	private String locality4_ADD_INFO;
	private String locality5_NAME;
	private String locality5_PREFERRED_NAME;
	private String locality5_SORTING_CODE;
	private String locality5_ADD_INFO;
	private String locality6_NAME;
	private String locality6_PREFERRED_NAME;
	private String locality6_SORTING_CODE;
	private String locality6_ADD_INFO;
	private String postalCode1_UNFORMATTED;
	private String postalCode1_BASE;
	private String postalCode1_ADD_ON;
	private String postalCode2_UNFORMATTED;
	private String postalCode2_BASE;
	private String postalCode2_ADD_ON;
	private String postalCode3_UNFORMATTED;
	private String postalCode3_BASE;
	private String postalCode3_ADD_ON;
	private String province1_ABBREVIATION;
	private String province1_EXTENDED;
	private String province1_ISO;
	private String province2_ABBREVIATION;
	private String province2_EXTENDED;
	private String province2_ISO;
	private String province3_ABBREVIATION;
	private String province3_EXTENDED;
	private String province3_ISO;
	private String province4_ABBREVIATION;
	private String province4_EXTENDED;
	private String province4_ISO;
	private String province5_ABBREVIATION;
	private String province5_EXTENDED;
	private String province5_ISO;
	private String province6_ABBREVIATION;
	private String province6_EXTENDED;
	private String province6_ISO;
	private String street1_COMPLETE_WITH_NUMBER;
	private String street1_NAME;
	private String street1_PRE_DESCRIPTOR;
	private String street1_POST_DESCRIPTOR;
	private String street1_PRE_DIRECTIONAL;
	private String street1_POST_DIRECTIONAL;
	private String street1_ADD_INFO;
	private String street2_COMPLETE_WITH_NUMBER;
	private String street2_NAME;
	private String street2_PRE_DESCRIPTOR;
	private String street2_POST_DESCRIPTOR;
	private String street2_PRE_DIRECTIONAL;
	private String street2_POST_DIRECTIONAL;
	private String street2_ADD_INFO;
	private String street3_COMPLETE_WITH_NUMBER;
	private String street3_NAME;
	private String street3_PRE_DESCRIPTOR;
	private String street3_POST_DESCRIPTOR;
	private String street3_PRE_DIRECTIONAL;
	private String street3_POST_DIRECTIONAL;
	private String street3_ADD_INFO;
	private String street4_COMPLETE_WITH_NUMBER;
	private String street4_NAME;
	private String street4_PRE_DESCRIPTOR;
	private String street4_POST_DESCRIPTOR;
	private String street4_PRE_DIRECTIONAL;
	private String street4_POST_DIRECTIONAL;
	private String street4_ADD_INFO;
	private String street5_COMPLETE_WITH_NUMBER;
	private String street5_NAME;
	private String street5_PRE_DESCRIPTOR;
	private String street5_POST_DESCRIPTOR;
	private String street5_PRE_DIRECTIONAL;
	private String street5_POST_DIRECTIONAL;
	private String street5_ADD_INFO;
	private String street6_COMPLETE_WITH_NUMBER;
	private String street6_NAME;
	private String street6_PRE_DESCRIPTOR;
	private String street6_POST_DESCRIPTOR;
	private String street6_PRE_DIRECTIONAL;
	private String street6_POST_DIRECTIONAL;
	private String street6_ADD_INFO;
	private String number1_NUMBER;
	private String number1_DESCRIPTOR;
	private String number1_ADD_INFO;
	private String number2_NUMBER;
	private String number2_DESCRIPTOR;
	private String number2_ADD_INFO;
	private String number3_NUMBER;
	private String number3_DESCRIPTOR;
	private String number3_ADD_INFO;
	private String number4_NUMBER;
	private String number4_DESCRIPTOR;
	private String number4_ADD_INFO;
	private String number5_NUMBER;
	private String number5_DESCRIPTOR;
	private String number5_ADD_INFO;
	private String number6_NUMBER;
	private String number6_DESCRIPTOR;
	private String number6_ADD_INFO;
	private String building1_COMPLETE_WITH_SUBBUILDING;
	private String building1_NAME;
	private String building1_NUMBER;
	private String building1_DESCRIPTOR;
	private String building2_COMPLETE_WITH_SUBBUILDING;
	private String building2_NAME;
	private String building2_NUMBER;
	private String building2_DESCRIPTOR;
	private String building3_COMPLETE_WITH_SUBBUILDING;
	private String building3_NAME;
	private String building3_NUMBER;
	private String building3_DESCRIPTOR;
	private String building4_COMPLETE_WITH_SUBBUILDING;
	private String building4_NAME;
	private String building4_NUMBER;
	private String building4_DESCRIPTOR;
	private String building5_COMPLETE_WITH_SUBBUILDING;
	private String building5_NAME;
	private String building5_NUMBER;
	private String building5_DESCRIPTOR;
	private String building6_COMPLETE_WITH_SUBBUILDING;
	private String building6_NAME;
	private String building6_NUMBER;
	private String building6_DESCRIPTOR;
	private String subBuilding1_NAME;
	private String subBuilding1_NUMBER;
	private String subBuilding1_DESCRIPTOR;
	private String subBuilding2_NAME;
	private String subBuilding2_NUMBER;
	private String subBuilding2_DESCRIPTOR;
	private String subBuilding3_NAME;
	private String subBuilding3_NUMBER;
	private String subBuilding3_DESCRIPTOR;
	private String subBuilding4_NAME;
	private String subBuilding4_NUMBER;
	private String subBuilding4_DESCRIPTOR;
	private String subBuilding5_NAME;
	private String subBuilding5_NUMBER;
	private String subBuilding5_DESCRIPTOR;
	private String subBuilding6_NAME;
	private String subBuilding6_NUMBER;
	private String subBuilding6_DESCRIPTOR;
	private String deliveryService1_DESCRIPTOR;
	private String deliveryService1_NUMBER;
	private String deliveryService1_ADD_INFO;
	private String deliveryService2_DESCRIPTOR;
	private String deliveryService2_NUMBER;
	private String deliveryService2_ADD_INFO;
	private String deliveryService3_DESCRIPTOR;
	private String deliveryService3_NUMBER;
	private String deliveryService3_ADD_INFO;
	private String organization1_NAME;
	private String organization1_DESCRIPTOR;
	private String organization1_DEPARTMENT;
	private String organization2_NAME;
	private String organization2_DESCRIPTOR;
	private String organization2_DEPARTMENT;
	private String organization3_NAME;
	private String organization3_DESCRIPTOR;
	private String organization3_DEPARTMENT;
	private String contact1_FIRST_NAME;
	private String contact1_MIDDLE_NAME;
	private String contact1_LAST_NAME;
	private String contact1_NAME;
	private String contact1_TITLE;
	private String contact1_FUNCTION;
	private String contact1_SALUTATION;
	private String contact1_GENDER;
	private String contact2_FIRST_NAME;
	private String contact2_MIDDLE_NAME;
	private String contact2_LAST_NAME;
	private String contact2_NAME;
	private String contact2_TITLE;
	private String contact2_FUNCTION;
	private String contact2_SALUTATION;
	private String contact2_GENDER;
	private String contact3_FIRST_NAME;
	private String contact3_MIDDLE_NAME;
	private String contact3_LAST_NAME;
	private String contact3_NAME;
	private String contact3_TITLE;
	private String contact3_FUNCTION;
	private String contact3_SALUTATION;
	private String contact3_GENDER;
	private String residue1_NECESSARY;
	private String residue1_SUPERFLUOUS;
	private String residue2_NECESSARY;
	private String residue2_SUPERFLUOUS;
	private String residue3_NECESSARY;
	private String residue3_SUPERFLUOUS;
	private String residue4_NECESSARY;
	private String residue4_SUPERFLUOUS;
	private String residue5_NECESSARY;
	private String residue5_SUPERFLUOUS;
	private String residue6_NECESSARY;
	private String residue6_SUPERFLUOUS;

	/**
	 * Get the value of column errorMessage.
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Set the value of column errorMessage.
	 * 
	 * @param errorMessage
	 *            the errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Get the value of column key1_RECORD_ID.
	 * 
	 * @return key1_RECORD_ID
	 */
	public String getKey1_RECORD_ID() {
		return key1_RECORD_ID;
	}

	/**
	 * Set the value of column key1_RECORD_ID.
	 * 
	 * @param key1_RECORD_ID
	 *            the key1_RECORD_ID
	 */
	public void setKey1_RECORD_ID(String key1_RECORD_ID) {
		this.key1_RECORD_ID = key1_RECORD_ID;
	}

	/**
	 * Get the value of column key2_RECORD_ID.
	 * 
	 * @return key2_RECORD_ID
	 */
	public String getKey2_RECORD_ID() {
		return key2_RECORD_ID;
	}

	/**
	 * Set the value of column key2_RECORD_ID.
	 * 
	 * @param key2_RECORD_ID
	 *            the key2_RECORD_ID
	 */
	public void setKey2_RECORD_ID(String key2_RECORD_ID) {
		this.key2_RECORD_ID = key2_RECORD_ID;
	}

	/**
	 * Get the value of column key3_RECORD_ID.
	 * 
	 * @return key3_RECORD_ID
	 */
	public String getKey3_RECORD_ID() {
		return key3_RECORD_ID;
	}

	/**
	 * Set the value of column key3_RECORD_ID.
	 * 
	 * @param key3_RECORD_ID
	 *            the key3_RECORD_ID
	 */
	public void setKey3_RECORD_ID(String key3_RECORD_ID) {
		this.key3_RECORD_ID = key3_RECORD_ID;
	}

	/**
	 * Get the value of column key1_TRANSACTION_KEY.
	 * 
	 * @return key1_TRANSACTION_KEY
	 */
	public String getKey1_TRANSACTION_KEY() {
		return key1_TRANSACTION_KEY;
	}

	/**
	 * Set the value of column key1_TRANSACTION_KEY.
	 * 
	 * @param key1_TRANSACTION_KEY
	 *            the key1_TRANSACTION_KEY
	 */
	public void setKey1_TRANSACTION_KEY(String key1_TRANSACTION_KEY) {
		this.key1_TRANSACTION_KEY = key1_TRANSACTION_KEY;
	}

	/**
	 * Get the value of column key2_TRANSACTION_KEY.
	 * 
	 * @return key2_TRANSACTION_KEY
	 */
	public String getKey2_TRANSACTION_KEY() {
		return key2_TRANSACTION_KEY;
	}

	/**
	 * Set the value of column key2_TRANSACTION_KEY.
	 * 
	 * @param key2_TRANSACTION_KEY
	 *            the key2_TRANSACTION_KEY
	 */
	public void setKey2_TRANSACTION_KEY(String key2_TRANSACTION_KEY) {
		this.key2_TRANSACTION_KEY = key2_TRANSACTION_KEY;
	}

	/**
	 * Get the value of column key3_TRANSACTION_KEY.
	 * 
	 * @return key3_TRANSACTION_KEY
	 */
	public String getKey3_TRANSACTION_KEY() {
		return key3_TRANSACTION_KEY;
	}

	/**
	 * Set the value of column key3_TRANSACTION_KEY.
	 * 
	 * @param key3_TRANSACTION_KEY
	 *            the key3_TRANSACTION_KEY
	 */
	public void setKey3_TRANSACTION_KEY(String key3_TRANSACTION_KEY) {
		this.key3_TRANSACTION_KEY = key3_TRANSACTION_KEY;
	}

	/**
	 * Get the value of column resultNumber.
	 * 
	 * @return resultNumber
	 */
	public String getResultNumber() {
		return resultNumber;
	}

	/**
	 * Set the value of column resultNumber.
	 * 
	 * @param resultNumber
	 *            the resultNumber
	 */
	public void setResultNumber(String resultNumber) {
		this.resultNumber = resultNumber;
	}

	/**
	 * Get the value of column country_ISO3.
	 * 
	 * @return country_ISO3
	 */
	public String getCountry_ISO3() {
		return country_ISO3;
	}

	/**
	 * Set the value of column country_ISO3.
	 * 
	 * @param country_ISO3
	 *            the country_ISO3
	 */
	public void setCountry_ISO3(String country_ISO3) {
		this.country_ISO3 = country_ISO3;
	}

	/**
	 * Get the value of column mode_Used.
	 * 
	 * @return mode_Used
	 */
	public String getMode_Used() {
		return mode_Used;
	}

	/**
	 * Set the value of column mode_Used.
	 * 
	 * @param mode_Used
	 *            the mode_Used
	 */
	public void setMode_Used(String mode_Used) {
		this.mode_Used = mode_Used;
	}

	/**
	 * Get the value of column preferred_Language.
	 * 
	 * @return preferred_Language
	 */
	public String getPreferred_Language() {
		return preferred_Language;
	}

	/**
	 * Set the value of column preferred_Language.
	 * 
	 * @param preferred_Language
	 *            the preferred_Language
	 */
	public void setPreferred_Language(String preferred_Language) {
		this.preferred_Language = preferred_Language;
	}

	/**
	 * Get the value of column preferred_Script.
	 * 
	 * @return preferred_Script
	 */
	public String getPreferred_Script() {
		return preferred_Script;
	}

	/**
	 * Set the value of column preferred_Script.
	 * 
	 * @param preferred_Script
	 *            the preferred_Script
	 */
	public void setPreferred_Script(String preferred_Script) {
		this.preferred_Script = preferred_Script;
	}

	/**
	 * Get the value of column processStatus.
	 * 
	 * @return processStatus
	 */
	public String getProcessStatus() {
		return processStatus;
	}

	/**
	 * Set the value of column processStatus.
	 * 
	 * @param processStatus
	 *            the processStatus
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * Get the value of column countOverFlow.
	 * 
	 * @return countOverFlow
	 */
	public String getCountOverFlow() {
		return countOverFlow;
	}

	/**
	 * Set the value of column countOverFlow.
	 * 
	 * @param countOverFlow
	 *            the countOverFlow
	 */
	public void setCountOverFlow(String countOverFlow) {
		this.countOverFlow = countOverFlow;
	}

	/**
	 * Get the value of column elementInputStatus.
	 * 
	 * @return elementInputStatus
	 */
	public String getElementInputStatus() {
		return elementInputStatus;
	}

	/**
	 * Set the value of column elementInputStatus.
	 * 
	 * @param elementInputStatus
	 *            the elementInputStatus
	 */
	public void setElementInputStatus(String elementInputStatus) {
		this.elementInputStatus = elementInputStatus;
	}

	/**
	 * Get the value of column elementResultStatus.
	 * 
	 * @return elementResultStatus
	 */
	public String getElementResultStatus() {
		return elementResultStatus;
	}

	/**
	 * Set the value of column elementResultStatus.
	 * 
	 * @param elementResultStatus
	 *            the elementResultStatus
	 */
	public void setElementResultStatus(String elementResultStatus) {
		this.elementResultStatus = elementResultStatus;
	}

	/**
	 * Get the value of column elementRelevance.
	 * 
	 * @return elementRelevance
	 */
	public String getElementRelevance() {
		return elementRelevance;
	}

	/**
	 * Set the value of column elementRelevance.
	 * 
	 * @param elementRelevance
	 *            the elementRelevance
	 */
	public void setElementRelevance(String elementRelevance) {
		this.elementRelevance = elementRelevance;
	}

	/**
	 * Get the value of column mailabilityScore.
	 * 
	 * @return mailabilityScore
	 */
	public String getMailabilityScore() {
		return mailabilityScore;
	}

	/**
	 * Set the value of column mailabilityScore.
	 * 
	 * @param mailabilityScore
	 *            the mailabilityScore
	 */
	public void setMailabilityScore(String mailabilityScore) {
		this.mailabilityScore = mailabilityScore;
	}

	/**
	 * Get the value of column resultPercentage.
	 * 
	 * @return resultPercentage
	 */
	public String getResultPercentage() {
		return resultPercentage;
	}

	/**
	 * Set the value of column resultPercentage.
	 * 
	 * @param resultPercentage
	 *            the resultPercentage
	 */
	public void setResultPercentage(String resultPercentage) {
		this.resultPercentage = resultPercentage;
	}

	/**
	 * Get the value of column cassStatus.
	 * 
	 * @return cassStatus
	 */
	public String getCassStatus() {
		return cassStatus;
	}

	/**
	 * Set the value of column cassStatus.
	 * 
	 * @param cassStatus
	 *            the cassStatus
	 */
	public void setCassStatus(String cassStatus) {
		this.cassStatus = cassStatus;
	}

	/**
	 * Get the value of column serpStatus.
	 * 
	 * @return serpStatus
	 */
	public String getSerpStatus() {
		return serpStatus;
	}

	/**
	 * Set the value of column serpStatus.
	 * 
	 * @param serpStatus
	 *            the serpStatus
	 */
	public void setSerpStatus(String serpStatus) {
		this.serpStatus = serpStatus;
	}

	/**
	 * Get the value of column snaStatus.
	 * 
	 * @return snaStatus
	 */
	public String getSnaStatus() {
		return snaStatus;
	}

	/**
	 * Set the value of column snaStatus.
	 * 
	 * @param snaStatus
	 *            the snaStatus
	 */
	public void setSnaStatus(String snaStatus) {
		this.snaStatus = snaStatus;
	}

	/**
	 * Get the value of column supplementaryGBStatus.
	 * 
	 * @return supplementaryGBStatus
	 */
	public String getSupplementaryGBStatus() {
		return supplementaryGBStatus;
	}

	/**
	 * Set the value of column supplementaryGBStatus.
	 * 
	 * @param supplementaryGBStatus
	 *            the supplementaryGBStatus
	 */
	public void setSupplementaryGBStatus(String supplementaryGBStatus) {
		this.supplementaryGBStatus = supplementaryGBStatus;
	}

	/**
	 * Get the value of column supplementaryUSStatus.
	 * 
	 * @return supplementaryUSStatus
	 */
	public String getSupplementaryUSStatus() {
		return supplementaryUSStatus;
	}

	/**
	 * Set the value of column supplementaryUSStatus.
	 * 
	 * @param supplementaryUSStatus
	 *            the supplementaryUSStatus
	 */
	public void setSupplementaryUSStatus(String supplementaryUSStatus) {
		this.supplementaryUSStatus = supplementaryUSStatus;
	}

	/**
	 * Get the value of column country1_NAME_EN.
	 * 
	 * @return country1_NAME_EN
	 */
	public String getCountry1_NAME_EN() {
		return country1_NAME_EN;
	}

	/**
	 * Set the value of column country1_NAME_EN.
	 * 
	 * @param country1_NAME_EN
	 *            the country1_NAME_EN
	 */
	public void setCountry1_NAME_EN(String country1_NAME_EN) {
		this.country1_NAME_EN = country1_NAME_EN;
	}

	/**
	 * Get the value of column locality1_COMPLETE.
	 * 
	 * @return locality1_COMPLETE
	 */
	public String getLocality1_COMPLETE() {
		return locality1_COMPLETE;
	}

	/**
	 * Set the value of column locality1_COMPLETE
	 * 
	 * @param locality1_COMPLETE
	 *            the locality1_COMPLETE
	 */
	public void setLocality1_COMPLETE(String locality1_COMPLETE) {
		this.locality1_COMPLETE = locality1_COMPLETE;
	}

	/**
	 * Get the value of column locality2_COMPLETE.
	 * 
	 * @return locality2_COMPLETE
	 */
	public String getLocality2_COMPLETE() {
		return locality2_COMPLETE;
	}

	/**
	 * Set the value of column locality2_COMPLETE.
	 * 
	 * @param locality2_COMPLETE
	 *            the locality2_COMPLETE
	 */
	public void setLocality2_COMPLETE(String locality2_COMPLETE) {
		this.locality2_COMPLETE = locality2_COMPLETE;
	}

	/**
	 * Get the value of column locality3_COMPLETE.
	 * 
	 * @return locality3_COMPLETE
	 */
	public String getLocality3_COMPLETE() {
		return locality3_COMPLETE;
	}

	/**
	 * Set the value of column locality3_COMPLETE.
	 * 
	 * @param locality3_COMPLETE
	 *            the locality3_COMPLETE
	 */
	public void setLocality3_COMPLETE(String locality3_COMPLETE) {
		this.locality3_COMPLETE = locality3_COMPLETE;
	}

	/**
	 * Get the value of column locality4_COMPLETE.
	 * 
	 * @return locality4_COMPLETE
	 */
	public String getLocality4_COMPLETE() {
		return locality4_COMPLETE;
	}

	/**
	 * Set the value of column locality4_COMPLETE.
	 * 
	 * @param locality4_COMPLETE
	 *            the locality4_COMPLETE
	 */
	public void setLocality4_COMPLETE(String locality4_COMPLETE) {
		this.locality4_COMPLETE = locality4_COMPLETE;
	}

	/**
	 * Get the value of column locality5_COMPLETE.
	 * 
	 * @return locality5_COMPLETE
	 */
	public String getLocality5_COMPLETE() {
		return locality5_COMPLETE;
	}

	/**
	 * Set the value of column locality5_COMPLETE.
	 * 
	 * @param locality5_COMPLETE
	 *            the locality5_COMPLETE
	 */
	public void setLocality5_COMPLETE(String locality5_COMPLETE) {
		this.locality5_COMPLETE = locality5_COMPLETE;
	}

	/**
	 * Get the value of column locality6_COMPLETE.
	 * 
	 * @return locality6_COMPLETE
	 */
	public String getLocality6_COMPLETE() {
		return locality6_COMPLETE;
	}

	/**
	 * Set the value of column locality6_COMPLETE.
	 * 
	 * @param locality6_COMPLETE
	 *            the locality6_COMPLETE
	 */
	public void setLocality6_COMPLETE(String locality6_COMPLETE) {
		this.locality6_COMPLETE = locality6_COMPLETE;
	}

	/**
	 * Get the value of column postalCode1_FORMATTED.
	 * 
	 * @return postalCode1_FORMATTED
	 */
	public String getPostalCode1_FORMATTED() {
		return postalCode1_FORMATTED;
	}

	/**
	 * Set the value of column postalCode1_FORMATTED.
	 * 
	 * @param postalCode1_FORMATTED
	 *            the postalCode1_FORMATTED
	 */
	public void setPostalCode1_FORMATTED(String postalCode1_FORMATTED) {
		this.postalCode1_FORMATTED = postalCode1_FORMATTED;
	}

	/**
	 * Get the value of column postalCode2_FORMATTED.
	 * 
	 * @return postalCode2_FORMATTED
	 */
	public String getPostalCode2_FORMATTED() {
		return postalCode2_FORMATTED;
	}

	/**
	 * Set the value of column postalCode2_FORMATTED.
	 * 
	 * @param postalCode2_FORMATTED
	 *            the postalCode2_FORMATTED
	 */
	public void setPostalCode2_FORMATTED(String postalCode2_FORMATTED) {
		this.postalCode2_FORMATTED = postalCode2_FORMATTED;
	}

	/**
	 * Get the value of column postalCode3_FORMATTED.
	 * 
	 * @return postalCode3_FORMATTED
	 */
	public String getPostalCode3_FORMATTED() {
		return postalCode3_FORMATTED;
	}

	/**
	 * Set the value of column postalCode3_FORMATTED.
	 * 
	 * @param postalCode3_FORMATTED
	 *            the postalCode3_FORMATTED
	 */
	public void setPostalCode3_FORMATTED(String postalCode3_FORMATTED) {
		this.postalCode3_FORMATTED = postalCode3_FORMATTED;
	}

	/**
	 * Get the value of column province1_COUNTRY_STANDARD.
	 * 
	 * @return province1_COUNTRY_STANDARD
	 */
	public String getProvince1_COUNTRY_STANDARD() {
		return province1_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province1_COUNTRY_STANDARD.
	 * 
	 * @param province1_COUNTRY_STANDARD
	 *            the province1_COUNTRY_STANDARD
	 */
	public void setProvince1_COUNTRY_STANDARD(String province1_COUNTRY_STANDARD) {
		this.province1_COUNTRY_STANDARD = province1_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column province2_COUNTRY_STANDARD.
	 * 
	 * @return province2_COUNTRY_STANDARD
	 */
	public String getProvince2_COUNTRY_STANDARD() {
		return province2_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province2_COUNTRY_STANDARD.
	 * 
	 * @param province2_COUNTRY_STANDARD
	 *            the province2_COUNTRY_STANDARD
	 */
	public void setProvince2_COUNTRY_STANDARD(String province2_COUNTRY_STANDARD) {
		this.province2_COUNTRY_STANDARD = province2_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column province3_COUNTRY_STANDARD.
	 * 
	 * @return province3_COUNTRY_STANDARD
	 */
	public String getProvince3_COUNTRY_STANDARD() {
		return province3_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province3_COUNTRY_STANDARD.
	 * 
	 * @param province3_COUNTRY_STANDARD
	 *            the province3_COUNTRY_STANDARD
	 */
	public void setProvince3_COUNTRY_STANDARD(String province3_COUNTRY_STANDARD) {
		this.province3_COUNTRY_STANDARD = province3_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column province4_COUNTRY_STANDARD.
	 * 
	 * @return province4_COUNTRY_STANDARD
	 */
	public String getProvince4_COUNTRY_STANDARD() {
		return province4_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province4_COUNTRY_STANDARD.
	 * 
	 * @param province4_COUNTRY_STANDARD
	 *            the province4_COUNTRY_STANDARD
	 */
	public void setProvince4_COUNTRY_STANDARD(String province4_COUNTRY_STANDARD) {
		this.province4_COUNTRY_STANDARD = province4_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column province5_COUNTRY_STANDARD.
	 * 
	 * @return province5_COUNTRY_STANDARD
	 */
	public String getProvince5_COUNTRY_STANDARD() {
		return province5_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province5_COUNTRY_STANDARD.
	 * 
	 * @param province5_COUNTRY_STANDARD
	 *            the province5_COUNTRY_STANDARD
	 */
	public void setProvince5_COUNTRY_STANDARD(String province5_COUNTRY_STANDARD) {
		this.province5_COUNTRY_STANDARD = province5_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column province6_COUNTRY_STANDARD.
	 * 
	 * @return province6_COUNTRY_STANDARD
	 */
	public String getProvince6_COUNTRY_STANDARD() {
		return province6_COUNTRY_STANDARD;
	}

	/**
	 * Set the value of column province6_COUNTRY_STANDARD.
	 * 
	 * @param province6_COUNTRY_STANDARD
	 *            the province6_COUNTRY_STANDARD
	 */
	public void setProvince6_COUNTRY_STANDARD(String province6_COUNTRY_STANDARD) {
		this.province6_COUNTRY_STANDARD = province6_COUNTRY_STANDARD;
	}

	/**
	 * Get the value of column street1_COMPLETE.
	 * 
	 * @return street1_COMPLETE
	 */
	public String getStreet1_COMPLETE() {
		return street1_COMPLETE;
	}

	/**
	 * Set the value of column street1_COMPLETE.
	 * 
	 * @param street1_COMPLETE
	 *            the street1_COMPLETE
	 */
	public void setStreet1_COMPLETE(String street1_COMPLETE) {
		this.street1_COMPLETE = street1_COMPLETE;
	}

	/**
	 * Get the value of column street2_COMPLETE.
	 * 
	 * @return street2_COMPLETE
	 */
	public String getStreet2_COMPLETE() {
		return street2_COMPLETE;
	}

	/**
	 * Set the value of column street2_COMPLETE.
	 * 
	 * @param street2_COMPLETE
	 *            the street2_COMPLETE
	 */
	public void setStreet2_COMPLETE(String street2_COMPLETE) {
		this.street2_COMPLETE = street2_COMPLETE;
	}

	/**
	 * Get the value of column street3_COMPLETE.
	 * 
	 * @return street3_COMPLETE
	 */
	public String getStreet3_COMPLETE() {
		return street3_COMPLETE;
	}

	/**
	 * Set the value of column street3_COMPLETE.
	 * 
	 * @param street3_COMPLETE
	 *            the street3_COMPLETE
	 */
	public void setStreet3_COMPLETE(String street3_COMPLETE) {
		this.street3_COMPLETE = street3_COMPLETE;
	}

	/**
	 * Get the value of column street4_COMPLETE.
	 * 
	 * @return street4_COMPLETE
	 */
	public String getStreet4_COMPLETE() {
		return street4_COMPLETE;
	}

	/**
	 * Set the value of column street4_COMPLETE.
	 * 
	 * @param street4_COMPLETE
	 *            the street4_COMPLETE
	 */
	public void setStreet4_COMPLETE(String street4_COMPLETE) {
		this.street4_COMPLETE = street4_COMPLETE;
	}

	/**
	 * Get the value of column street5_COMPLETE.
	 * 
	 * @return street5_COMPLETE
	 */
	public String getStreet5_COMPLETE() {
		return street5_COMPLETE;
	}

	/**
	 * Set the value of column street5_COMPLETE.
	 * 
	 * @param street5_COMPLETE
	 *            the street5_COMPLETE
	 */
	public void setStreet5_COMPLETE(String street5_COMPLETE) {
		this.street5_COMPLETE = street5_COMPLETE;
	}

	/**
	 * Get the value of column street6_COMPLETE.
	 * 
	 * @return street6_COMPLETE
	 */
	public String getStreet6_COMPLETE() {
		return street6_COMPLETE;
	}

	/**
	 * Set the value of column street6_COMPLETE.
	 * 
	 * @param street6_COMPLETE
	 *            the street6_COMPLETE
	 */
	public void setStreet6_COMPLETE(String street6_COMPLETE) {
		this.street6_COMPLETE = street6_COMPLETE;
	}

	/**
	 * Get the value of column number1_COMPLETE.
	 * 
	 * @return number1_COMPLETE
	 */
	public String getNumber1_COMPLETE() {
		return number1_COMPLETE;
	}

	/**
	 * Set the value of column number1_COMPLETE.
	 * 
	 * @param number1_COMPLETE
	 *            the number1_COMPLETE
	 */
	public void setNumber1_COMPLETE(String number1_COMPLETE) {
		this.number1_COMPLETE = number1_COMPLETE;
	}

	/**
	 * Get the value of column number2_COMPLETE.
	 * 
	 * @return number2_COMPLETE
	 */
	public String getNumber2_COMPLETE() {
		return number2_COMPLETE;
	}

	/**
	 * Set the value of column number2_COMPLETE.
	 * 
	 * @param number2_COMPLETE
	 *            the number2_COMPLETE
	 */
	public void setNumber2_COMPLETE(String number2_COMPLETE) {
		this.number2_COMPLETE = number2_COMPLETE;
	}

	/**
	 * Get the value of column number3_COMPLETE.
	 * 
	 * @return number3_COMPLETE
	 */
	public String getNumber3_COMPLETE() {
		return number3_COMPLETE;
	}

	/**
	 * Set the value of column number3_COMPLETE.
	 * 
	 * @param number3_COMPLETE
	 *            the number3_COMPLETE
	 */
	public void setNumber3_COMPLETE(String number3_COMPLETE) {
		this.number3_COMPLETE = number3_COMPLETE;
	}

	/**
	 * Get the value of column number4_COMPLETE.
	 * 
	 * @return number4_COMPLETE
	 */
	public String getNumber4_COMPLETE() {
		return number4_COMPLETE;
	}

	/**
	 * Set the value of column number4_COMPLETE
	 * 
	 * @param number4_COMPLETE
	 *            the number4_COMPLETE
	 */
	public void setNumber4_COMPLETE(String number4_COMPLETE) {
		this.number4_COMPLETE = number4_COMPLETE;
	}

	/**
	 * Get the value of column number5_COMPLETE.
	 * 
	 * @return number5_COMPLETE
	 */
	public String getNumber5_COMPLETE() {
		return number5_COMPLETE;
	}

	/**
	 * Set the value of column number5_COMPLETE.
	 * 
	 * @param number5_COMPLETE
	 *            the number5_COMPLETE
	 */
	public void setNumber5_COMPLETE(String number5_COMPLETE) {
		this.number5_COMPLETE = number5_COMPLETE;
	}

	/**
	 * Get the value of column number6_COMPLETE.
	 * 
	 * @return number6_COMPLETE
	 */
	public String getNumber6_COMPLETE() {
		return number6_COMPLETE;
	}

	/**
	 * Set the value of column number6_COMPLETE.
	 * 
	 * @param number6_COMPLETE
	 *            the number6_COMPLETE
	 */
	public void setNumber6_COMPLETE(String number6_COMPLETE) {
		this.number6_COMPLETE = number6_COMPLETE;
	}

	/**
	 * Get the value of column building1_COMPLETE.
	 * 
	 * @return building1_COMPLETE
	 */
	public String getBuilding1_COMPLETE() {
		return building1_COMPLETE;
	}

	/**
	 * Set the value of column building1_COMPLETE.
	 * 
	 * @param building1_COMPLETE
	 *            the building1_COMPLETE
	 */
	public void setBuilding1_COMPLETE(String building1_COMPLETE) {
		this.building1_COMPLETE = building1_COMPLETE;
	}

	/**
	 * Get the value of column building2_COMPLETE.
	 * 
	 * @return building2_COMPLETE
	 */
	public String getBuilding2_COMPLETE() {
		return building2_COMPLETE;
	}

	/**
	 * Set the value of column building2_COMPLETE.
	 * 
	 * @param building2_COMPLETE
	 *            the building2_COMPLETE
	 */
	public void setBuilding2_COMPLETE(String building2_COMPLETE) {
		this.building2_COMPLETE = building2_COMPLETE;
	}

	/**
	 * Get the value of column building3_COMPLETE.
	 * 
	 * @return building3_COMPLETE
	 */
	public String getBuilding3_COMPLETE() {
		return building3_COMPLETE;
	}

	/**
	 * Set the value of column building3_COMPLETE.
	 * 
	 * @param building3_COMPLETE
	 *            the building3_COMPLETE
	 */
	public void setBuilding3_COMPLETE(String building3_COMPLETE) {
		this.building3_COMPLETE = building3_COMPLETE;
	}

	/**
	 * Get the value of column building4_COMPLETE.
	 * 
	 * @return building4_COMPLETE
	 */
	public String getBuilding4_COMPLETE() {
		return building4_COMPLETE;
	}

	/**
	 * Set the value of column building4_COMPLETE.
	 * 
	 * @param building4_COMPLETE
	 *            the building4_COMPLETE
	 */
	public void setBuilding4_COMPLETE(String building4_COMPLETE) {
		this.building4_COMPLETE = building4_COMPLETE;
	}

	/**
	 * Get the value of column building5_COMPLETE.
	 * 
	 * @return building5_COMPLETE
	 */
	public String getBuilding5_COMPLETE() {
		return building5_COMPLETE;
	}

	/**
	 * Set the value of column building5_COMPLETE.
	 * 
	 * @param building5_COMPLETE
	 *            the building5_COMPLETE
	 */
	public void setBuilding5_COMPLETE(String building5_COMPLETE) {
		this.building5_COMPLETE = building5_COMPLETE;
	}

	/**
	 * Get the value of column building6_COMPLETE.
	 * 
	 * @return building6_COMPLETE
	 */
	public String getBuilding6_COMPLETE() {
		return building6_COMPLETE;
	}

	/**
	 * Set the value of column building6_COMPLETE.
	 * 
	 * @param building6_COMPLETE
	 *            the building6_COMPLETE
	 */
	public void setBuilding6_COMPLETE(String building6_COMPLETE) {
		this.building6_COMPLETE = building6_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding1_COMPLETE.
	 * 
	 * @return subBuilding1_COMPLETE
	 */
	public String getSubBuilding1_COMPLETE() {
		return subBuilding1_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding1_COMPLETE.
	 * 
	 * @param subBuilding1_COMPLETE
	 *            the subBuilding1_COMPLETE
	 */
	public void setSubBuilding1_COMPLETE(String subBuilding1_COMPLETE) {
		this.subBuilding1_COMPLETE = subBuilding1_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding2_COMPLETE.
	 * 
	 * @return subBuilding2_COMPLETE
	 */
	public String getSubBuilding2_COMPLETE() {
		return subBuilding2_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding2_COMPLETE.
	 * 
	 * @param subBuilding2_COMPLETE
	 *            the subBuilding2_COMPLETE
	 */
	public void setSubBuilding2_COMPLETE(String subBuilding2_COMPLETE) {
		this.subBuilding2_COMPLETE = subBuilding2_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding3_COMPLETE.
	 * 
	 * @return subBuilding3_COMPLETE
	 */
	public String getSubBuilding3_COMPLETE() {
		return subBuilding3_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding3_COMPLETE.
	 * 
	 * @param subBuilding3_COMPLETE
	 *            the subBuilding3_COMPLETE
	 */
	public void setSubBuilding3_COMPLETE(String subBuilding3_COMPLETE) {
		this.subBuilding3_COMPLETE = subBuilding3_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding4_COMPLETE.
	 * 
	 * @return subBuilding4_COMPLETE
	 */
	public String getSubBuilding4_COMPLETE() {
		return subBuilding4_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding4_COMPLETE.
	 * 
	 * @param subBuilding4_COMPLETE
	 *            the subBuilding4_COMPLETE
	 */
	public void setSubBuilding4_COMPLETE(String subBuilding4_COMPLETE) {
		this.subBuilding4_COMPLETE = subBuilding4_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding5_COMPLETE.
	 * 
	 * @return subBuilding5_COMPLETE
	 */
	public String getSubBuilding5_COMPLETE() {
		return subBuilding5_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding5_COMPLETE.
	 * 
	 * @param subBuilding5_COMPLETE
	 *            the subBuilding5_COMPLETE
	 */
	public void setSubBuilding5_COMPLETE(String subBuilding5_COMPLETE) {
		this.subBuilding5_COMPLETE = subBuilding5_COMPLETE;
	}

	/**
	 * Get the value of column subBuilding6_COMPLETE.
	 * 
	 * @return subBuilding6_COMPLETE
	 */
	public String getSubBuilding6_COMPLETE() {
		return subBuilding6_COMPLETE;
	}

	/**
	 * Set the value of column subBuilding6_COMPLETE.
	 * 
	 * @param subBuilding6_COMPLETE
	 *            the subBuilding6_COMPLETE
	 */
	public void setSubBuilding6_COMPLETE(String subBuilding6_COMPLETE) {
		this.subBuilding6_COMPLETE = subBuilding6_COMPLETE;
	}

	/**
	 * Get the value of column deliverService1_COMPLETE.
	 * 
	 * @return deliverService1_COMPLETE
	 */
	public String getDeliverService1_COMPLETE() {
		return deliverService1_COMPLETE;
	}

	/**
	 * Set the value of column deliverService1_COMPLETE.
	 * 
	 * @param deliverService1_COMPLETE
	 *            the deliverService1_COMPLETE
	 */
	public void setDeliverService1_COMPLETE(String deliverService1_COMPLETE) {
		this.deliverService1_COMPLETE = deliverService1_COMPLETE;
	}

	/**
	 * Get the value of column deliverService2_COMPLETE.
	 * 
	 * @return deliverService2_COMPLETE
	 */
	public String getDeliverService2_COMPLETE() {
		return deliverService2_COMPLETE;
	}

	/**
	 * Set the value of column deliverService2_COMPLETE.
	 * 
	 * @param deliverService2_COMPLETE
	 *            the deliverService2_COMPLETE
	 */
	public void setDeliverService2_COMPLETE(String deliverService2_COMPLETE) {
		this.deliverService2_COMPLETE = deliverService2_COMPLETE;
	}

	/**
	 * Get the value of column deliverService3_COMPLETE.
	 * 
	 * @return deliverService3_COMPLETE
	 */
	public String getDeliverService3_COMPLETE() {
		return deliverService3_COMPLETE;
	}

	/**
	 * Set the value of column deliverService3_COMPLETE.
	 * 
	 * @param deliverService3_COMPLETE
	 */
	public void setDeliverService3_COMPLETE(String deliverService3_COMPLETE) {
		this.deliverService3_COMPLETE = deliverService3_COMPLETE;
	}

	/**
	 * Get the value of column deliverService4_COMPLETE.
	 * 
	 * @return deliverService4_COMPLETE
	 */
	public String getDeliverService4_COMPLETE() {
		return deliverService4_COMPLETE;
	}

	/**
	 * Set the value of column deliverService4_COMPLETE.
	 * 
	 * @param deliverService4_COMPLETE
	 *            the deliverService4_COMPLETE
	 */
	public void setDeliverService4_COMPLETE(String deliverService4_COMPLETE) {
		this.deliverService4_COMPLETE = deliverService4_COMPLETE;
	}

	/**
	 * Get the value of column deliverService5_COMPLETE.
	 * 
	 * @return deliverService5_COMPLETE
	 */
	public String getDeliverService5_COMPLETE() {
		return deliverService5_COMPLETE;
	}

	/**
	 * Set the value of column deliverService5_COMPLETE.
	 * 
	 * @param deliverService5_COMPLETE
	 *            the deliverService5_COMPLETE
	 */
	public void setDeliverService5_COMPLETE(String deliverService5_COMPLETE) {
		this.deliverService5_COMPLETE = deliverService5_COMPLETE;
	}

	/**
	 * Get the value of column deliverService6_COMPLETE.
	 * 
	 * @return deliverService6_COMPLETE
	 */
	public String getDeliverService6_COMPLETE() {
		return deliverService6_COMPLETE;
	}

	/**
	 * Set the value of column deliverService6_COMPLETE.
	 * 
	 * @param deliverService6_COMPLETE
	 *            the deliverService6_COMPLETE
	 */
	public void setDeliverService6_COMPLETE(String deliverService6_COMPLETE) {
		this.deliverService6_COMPLETE = deliverService6_COMPLETE;
	}

	/**
	 * Get the value of column organization1_COMPLETE.
	 * 
	 * @return organization1_COMPLETE
	 */
	public String getOrganization1_COMPLETE() {
		return organization1_COMPLETE;
	}

	/**
	 * Set the value of column organization1_COMPLETE.
	 * 
	 * @param organization1_COMPLETE
	 *            the organization1_COMPLETE
	 */
	public void setOrganization1_COMPLETE(String organization1_COMPLETE) {
		this.organization1_COMPLETE = organization1_COMPLETE;
	}

	/**
	 * Get the value of column organization2_COMPLETE.
	 * 
	 * @return organization2_COMPLETE
	 */
	public String getOrganization2_COMPLETE() {
		return organization2_COMPLETE;
	}

	/**
	 * Set the value of column organization2_COMPLETE.
	 * 
	 * @param organization2_COMPLETE
	 *            the organization2_COMPLETE
	 */
	public void setOrganization2_COMPLETE(String organization2_COMPLETE) {
		this.organization2_COMPLETE = organization2_COMPLETE;
	}

	/**
	 * Get the value of column organization3_COMPLETE.
	 * 
	 * @return organization3_COMPLETE
	 */
	public String getOrganization3_COMPLETE() {
		return organization3_COMPLETE;
	}

	/**
	 * Set the value of column organization3_COMPLETE.
	 * 
	 * @param organization3_COMPLETE
	 *            the organization3_COMPLETE
	 */
	public void setOrganization3_COMPLETE(String organization3_COMPLETE) {
		this.organization3_COMPLETE = organization3_COMPLETE;
	}

	/**
	 * Get the value of column contact1_COMPLETE.
	 * 
	 * @return contact1_COMPLETE
	 */
	public String getContact1_COMPLETE() {
		return contact1_COMPLETE;
	}

	/**
	 * Set the value of column contact1_COMPLETE.
	 * 
	 * @param contact1_COMPLETE
	 *            the contact1_COMPLETE
	 */
	public void setContact1_COMPLETE(String contact1_COMPLETE) {
		this.contact1_COMPLETE = contact1_COMPLETE;
	}

	/**
	 * Get the value of column contact2_COMPLETE.
	 * 
	 * @return contact2_COMPLETE
	 */
	public String getContact2_COMPLETE() {
		return contact2_COMPLETE;
	}

	/**
	 * Set the value of column contact2_COMPLETE.
	 * 
	 * @param contact2_COMPLETE
	 *            the contact2_COMPLETE
	 */
	public void setContact2_COMPLETE(String contact2_COMPLETE) {
		this.contact2_COMPLETE = contact2_COMPLETE;
	}

	/**
	 * Get the value of column contact3_COMPLETE.
	 * 
	 * @return contact3_COMPLETE
	 */
	public String getContact3_COMPLETE() {
		return contact3_COMPLETE;
	}

	/**
	 * Set the value of column contact3_COMPLETE.
	 * 
	 * @param contact3_COMPLETE
	 *            the contact3_COMPLETE
	 */
	public void setContact3_COMPLETE(String contact3_COMPLETE) {
		this.contact3_COMPLETE = contact3_COMPLETE;
	}

	/**
	 * Get the value of column residue1_UNRECOGNIZED.
	 * 
	 * @return residue1_UNRECOGNIZED
	 */
	public String getResidue1_UNRECOGNIZED() {
		return residue1_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue1_UNRECOGNIZED.
	 * 
	 * @param residue1_UNRECOGNIZED
	 *            the residue1_UNRECOGNIZED
	 */
	public void setResidue1_UNRECOGNIZED(String residue1_UNRECOGNIZED) {
		this.residue1_UNRECOGNIZED = residue1_UNRECOGNIZED;
	}

	/**
	 * Get the value of column residue2_UNRECOGNIZED.
	 * 
	 * @return residue2_UNRECOGNIZED
	 */
	public String getResidue2_UNRECOGNIZED() {
		return residue2_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue2_UNRECOGNIZED
	 * 
	 * @param residue2_UNRECOGNIZED
	 *            the residue2_UNRECOGNIZED
	 */
	public void setResidue2_UNRECOGNIZED(String residue2_UNRECOGNIZED) {
		this.residue2_UNRECOGNIZED = residue2_UNRECOGNIZED;
	}

	/**
	 * Get the value of column residue3_UNRECOGNIZED.
	 * 
	 * @return residue3_UNRECOGNIZED
	 */
	public String getResidue3_UNRECOGNIZED() {
		return residue3_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue3_UNRECOGNIZED.
	 * 
	 * @param residue3_UNRECOGNIZED
	 *            the residue3_UNRECOGNIZED
	 */
	public void setResidue3_UNRECOGNIZED(String residue3_UNRECOGNIZED) {
		this.residue3_UNRECOGNIZED = residue3_UNRECOGNIZED;
	}

	/**
	 * Get the value of column residue4_UNRECOGNIZED.
	 * 
	 * @return residue4_UNRECOGNIZED
	 */
	public String getResidue4_UNRECOGNIZED() {
		return residue4_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue4_UNRECOGNIZED.
	 * 
	 * @param residue4_UNRECOGNIZED
	 *            the residue4_UNRECOGNIZED
	 */
	public void setResidue4_UNRECOGNIZED(String residue4_UNRECOGNIZED) {
		this.residue4_UNRECOGNIZED = residue4_UNRECOGNIZED;
	}

	/**
	 * Get the value of column residue5_UNRECOGNIZED.
	 * 
	 * @return residue5_UNRECOGNIZED
	 */
	public String getResidue5_UNRECOGNIZED() {
		return residue5_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue5_UNRECOGNIZED.
	 * 
	 * @param residue5_UNRECOGNIZED
	 *            the residue5_UNRECOGNIZED
	 */
	public void setResidue5_UNRECOGNIZED(String residue5_UNRECOGNIZED) {
		this.residue5_UNRECOGNIZED = residue5_UNRECOGNIZED;
	}

	/**
	 * Get the value of columnresidue6_UNRECOGNIZED.
	 * 
	 * @return residue6_UNRECOGNIZED
	 */
	public String getResidue6_UNRECOGNIZED() {
		return residue6_UNRECOGNIZED;
	}

	/**
	 * Set the value of column residue6_UNRECOGNIZED.
	 * 
	 * @param residue6_UNRECOGNIZED
	 *            the residue6_UNRECOGNIZED
	 */
	public void setResidue6_UNRECOGNIZED(String residue6_UNRECOGNIZED) {
		this.residue6_UNRECOGNIZED = residue6_UNRECOGNIZED;
	}

	/**
	 * Get the value of column recipientLine_1.
	 * 
	 * @return recipientLine_1
	 */
	public String getRecipientLine_1() {
		return recipientLine_1;
	}

	/**
	 * Set the value of column recipientLine_1.
	 * 
	 * @param recipientLine_1
	 *            the recipientLine_1
	 */
	public void setRecipientLine_1(String recipientLine_1) {
		this.recipientLine_1 = recipientLine_1;
	}

	/**
	 * Get the value of column recipientLine_2.
	 * 
	 * @return recipientLine_2
	 */
	public String getRecipientLine_2() {
		return recipientLine_2;
	}

	/**
	 * Set the value of column recipientLine_2.
	 * 
	 * @param recipientLine_2
	 *            the recipientLine_2
	 */
	public void setRecipientLine_2(String recipientLine_2) {
		this.recipientLine_2 = recipientLine_2;
	}

	/**
	 * Get the value of column recipientLine_3.
	 * 
	 * @return recipientLine_3
	 */
	public String getRecipientLine_3() {
		return recipientLine_3;
	}

	/**
	 * Set the value of column recipientLine_3.
	 * 
	 * @param recipientLine_3
	 *            the recipientLine_3
	 */
	public void setRecipientLine_3(String recipientLine_3) {
		this.recipientLine_3 = recipientLine_3;
	}

	/**
	 * Get the value of column deliveryAddressLine_1.
	 * 
	 * @return deliveryAddressLine_1
	 */
	public String getDeliveryAddressLine_1() {
		return deliveryAddressLine_1;
	}

	/**
	 * Set the value of column deliveryAddressLine_1.
	 * 
	 * @param deliveryAddressLine_1
	 *            the deliveryAddressLine_1
	 */
	public void setDeliveryAddressLine_1(String deliveryAddressLine_1) {
		this.deliveryAddressLine_1 = deliveryAddressLine_1;
	}

	/**
	 * Get the value of column deliveryAddressLine_2.
	 * 
	 * @return deliveryAddressLine_2
	 */
	public String getDeliveryAddressLine_2() {
		return deliveryAddressLine_2;
	}

	/**
	 * Set the value of column deliveryAddressLine_2.
	 * 
	 * @param deliveryAddressLine_2
	 *            the deliveryAddressLine_2
	 */
	public void setDeliveryAddressLine_2(String deliveryAddressLine_2) {
		this.deliveryAddressLine_2 = deliveryAddressLine_2;
	}

	/**
	 * Get the value of column deliveryAddressLine_3.
	 * 
	 * @return deliveryAddressLine_3
	 */
	public String getDeliveryAddressLine_3() {
		return deliveryAddressLine_3;
	}

	/**
	 * Set the value of column deliveryAddressLine_3.
	 * 
	 * @param deliveryAddressLine_3
	 *            the deliveryAddressLine_3
	 */
	public void setDeliveryAddressLine_3(String deliveryAddressLine_3) {
		this.deliveryAddressLine_3 = deliveryAddressLine_3;
	}

	/**
	 * Get the value of column deliveryAddressLine_4.
	 * 
	 * @return deliveryAddressLine_4
	 */
	public String getDeliveryAddressLine_4() {
		return deliveryAddressLine_4;
	}

	/**
	 * Set the value of column deliveryAddressLine_4.
	 * 
	 * @param deliveryAddressLine_4
	 *            the deliveryAddressLine_4
	 */
	public void setDeliveryAddressLine_4(String deliveryAddressLine_4) {
		this.deliveryAddressLine_4 = deliveryAddressLine_4;
	}

	/**
	 * Get the value of column deliveryAddressLine_5.
	 * 
	 * @return deliveryAddressLine_5
	 */
	public String getDeliveryAddressLine_5() {
		return deliveryAddressLine_5;
	}

	/**
	 * Set the value of column deliveryAddressLine_5.
	 * 
	 * @param deliveryAddressLine_5
	 *            the deliveryAddressLine_5
	 */
	public void setDeliveryAddressLine_5(String deliveryAddressLine_5) {
		this.deliveryAddressLine_5 = deliveryAddressLine_5;
	}

	/**
	 * Get the value of column deliveryAddressLine_6.
	 * 
	 * @return deliveryAddressLine_6
	 */
	public String getDeliveryAddressLine_6() {
		return deliveryAddressLine_6;
	}

	/**
	 * Set the value of column deliveryAddressLine_6.
	 * 
	 * @param deliveryAddressLine_6
	 *            the deliveryAddressLine_6
	 */
	public void setDeliveryAddressLine_6(String deliveryAddressLine_6) {
		this.deliveryAddressLine_6 = deliveryAddressLine_6;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_1.
	 * 
	 * @return countrySpecificLocalityLine_1
	 */
	public String getCountrySpecificLocalityLine_1() {
		return countrySpecificLocalityLine_1;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_1.
	 * 
	 * @param countrySpecificLocalityLine_1
	 *            the countrySpecificLocalityLine_1
	 */
	public void setCountrySpecificLocalityLine_1(String countrySpecificLocalityLine_1) {
		this.countrySpecificLocalityLine_1 = countrySpecificLocalityLine_1;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine_2.
	 * 
	 * @return countrySpecificLocalityLine_2
	 */
	public String getCountrySpecificLocalityLine_2() {
		return countrySpecificLocalityLine_2;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_2.
	 * 
	 * @param countrySpecificLocalityLine_2
	 *            the countrySpecificLocalityLine_2
	 */
	public void setCountrySpecificLocalityLine_2(String countrySpecificLocalityLine_2) {
		this.countrySpecificLocalityLine_2 = countrySpecificLocalityLine_2;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine_3.
	 * 
	 * @return countrySpecificLocalityLine_3
	 */
	public String getCountrySpecificLocalityLine_3() {
		return countrySpecificLocalityLine_3;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_3.
	 * 
	 * @param countrySpecificLocalityLine_3
	 *            the countrySpecificLocalityLine_3
	 */
	public void setCountrySpecificLocalityLine_3(String countrySpecificLocalityLine_3) {
		this.countrySpecificLocalityLine_3 = countrySpecificLocalityLine_3;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine_4.
	 * 
	 * @return countrySpecificLocalityLine_4
	 */
	public String getCountrySpecificLocalityLine_4() {
		return countrySpecificLocalityLine_4;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_4.
	 * 
	 * @param countrySpecificLocalityLine_4
	 *            the countrySpecificLocalityLine_4
	 */
	public void setCountrySpecificLocalityLine_4(String countrySpecificLocalityLine_4) {
		this.countrySpecificLocalityLine_4 = countrySpecificLocalityLine_4;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine_5.
	 * 
	 * @return countrySpecificLocalityLine_5
	 */
	public String getCountrySpecificLocalityLine_5() {
		return countrySpecificLocalityLine_5;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_5.
	 * 
	 * @param countrySpecificLocalityLine_5
	 *            the countrySpecificLocalityLine_5
	 */
	public void setCountrySpecificLocalityLine_5(String countrySpecificLocalityLine_5) {
		this.countrySpecificLocalityLine_5 = countrySpecificLocalityLine_5;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine_6.
	 * 
	 * @return countrySpecificLocalityLine_6
	 */
	public String getCountrySpecificLocalityLine_6() {
		return countrySpecificLocalityLine_6;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine_6.
	 * 
	 * @param countrySpecificLocalityLine_6
	 *            the countrySpecificLocalityLine_6
	 */
	public void setCountrySpecificLocalityLine_6(String countrySpecificLocalityLine_6) {
		this.countrySpecificLocalityLine_6 = countrySpecificLocalityLine_6;
	}

	/**
	 * Get the value of column formattedAddressLine_1.
	 * 
	 * @return formattedAddressLine_1
	 */
	public String getFormattedAddressLine_1() {
		return formattedAddressLine_1;
	}

	/**
	 * Set the value of column formattedAddressLine_1.
	 * 
	 * @param formattedAddressLine_1
	 *            the formattedAddressLine_1
	 */
	public void setFormattedAddressLine_1(String formattedAddressLine_1) {
		this.formattedAddressLine_1 = formattedAddressLine_1;
	}

	/**
	 * Get the value of column formattedAddressLine_2.
	 * 
	 * @return formattedAddressLine_2
	 */
	public String getFormattedAddressLine_2() {
		return formattedAddressLine_2;
	}

	/**
	 * Set the value of column formattedAddressLine_2.
	 * 
	 * @param formattedAddressLine_2
	 *            the formattedAddressLine_2
	 */
	public void setFormattedAddressLine_2(String formattedAddressLine_2) {
		this.formattedAddressLine_2 = formattedAddressLine_2;
	}

	/**
	 * Get the value of column formattedAddressLine_3.
	 * 
	 * @return formattedAddressLine_3
	 */
	public String getFormattedAddressLine_3() {
		return formattedAddressLine_3;
	}

	/**
	 * Set the value of column formattedAddressLine_3.
	 * 
	 * @param formattedAddressLine_3
	 *            the formattedAddressLine_3
	 */
	public void setFormattedAddressLine_3(String formattedAddressLine_3) {
		this.formattedAddressLine_3 = formattedAddressLine_3;
	}

	/**
	 * Get the value of column formattedAddressLine_4.
	 * 
	 * @return formattedAddressLine_4
	 */
	public String getFormattedAddressLine_4() {
		return formattedAddressLine_4;
	}

	/**
	 * Set the value of column formattedAddressLine_4.
	 * 
	 * @param formattedAddressLine_4
	 *            the formattedAddressLine_4
	 */
	public void setFormattedAddressLine_4(String formattedAddressLine_4) {
		this.formattedAddressLine_4 = formattedAddressLine_4;
	}

	/**
	 * Get the value of column formattedAddressLine_5.
	 * 
	 * @return formattedAddressLine_5
	 */
	public String getFormattedAddressLine_5() {
		return formattedAddressLine_5;
	}

	/**
	 * Set the value of column formattedAddressLine_5.
	 * 
	 * @param formattedAddressLine_5
	 *            the formattedAddressLine_5
	 */
	public void setFormattedAddressLine_5(String formattedAddressLine_5) {
		this.formattedAddressLine_5 = formattedAddressLine_5;
	}

	/**
	 * Get the value of column formattedAddressLine_6.
	 * 
	 * @return formattedAddressLine_6
	 */
	public String getFormattedAddressLine_6() {
		return formattedAddressLine_6;
	}

	/**
	 * Set the value of column formattedAddressLine_6.
	 * 
	 * @param formattedAddressLine_6
	 *            the formattedAddressLine_6
	 */
	public void setFormattedAddressLine_6(String formattedAddressLine_6) {
		this.formattedAddressLine_6 = formattedAddressLine_6;
	}

	/**
	 * Get the value of column formattedAddressLine_7.
	 * 
	 * @return formattedAddressLine_7
	 */
	public String getFormattedAddressLine_7() {
		return formattedAddressLine_7;
	}

	/**
	 * Set the value of column formattedAddressLine_7.
	 * 
	 * @param formattedAddressLine_7
	 *            the formattedAddressLine_7
	 */
	public void setFormattedAddressLine_7(String formattedAddressLine_7) {
		this.formattedAddressLine_7 = formattedAddressLine_7;
	}

	/**
	 * Get the value of column formattedAddressLine_8.
	 * 
	 * @return formattedAddressLine_8
	 */
	public String getFormattedAddressLine_8() {
		return formattedAddressLine_8;
	}

	/**
	 * Set the value of column formattedAddressLine_8.
	 * 
	 * @param formattedAddressLine_8
	 *            the formattedAddressLine_8
	 */
	public void setFormattedAddressLine_8(String formattedAddressLine_8) {
		this.formattedAddressLine_8 = formattedAddressLine_8;
	}

	/**
	 * Get the value of column formattedAddressLine_9.
	 * 
	 * @return formattedAddressLine_9
	 */
	public String getFormattedAddressLine_9() {
		return formattedAddressLine_9;
	}

	/**
	 * Set the value of column formattedAddressLine_9.
	 * 
	 * @param formattedAddressLine_9
	 *            the formattedAddressLine_9
	 */
	public void setFormattedAddressLine_9(String formattedAddressLine_9) {
		this.formattedAddressLine_9 = formattedAddressLine_9;
	}

	/**
	 * Get the value of column formattedAddressLine_10.
	 * 
	 * @return formattedAddressLine_10
	 */
	public String getFormattedAddressLine_10() {
		return formattedAddressLine_10;
	}

	/**
	 * Set the value of column formattedAddressLine_10.
	 * 
	 * @param formattedAddressLine_10
	 *            the formattedAddressLine_10
	 */
	public void setFormattedAddressLine_10(String formattedAddressLine_10) {
		this.formattedAddressLine_10 = formattedAddressLine_10;
	}

	/**
	 * Get the value of column formattedAddressLine_11.
	 * 
	 * @return formattedAddressLine_11
	 */
	public String getFormattedAddressLine_11() {
		return formattedAddressLine_11;
	}

	/**
	 * Set the value of column formattedAddressLine_11.
	 * 
	 * @param formattedAddressLine_11
	 *            the formattedAddressLine_11
	 */
	public void setFormattedAddressLine_11(String formattedAddressLine_11) {
		this.formattedAddressLine_11 = formattedAddressLine_11;
	}

	/**
	 * Get the value of column formattedAddressLine_12.
	 * 
	 * @return formattedAddressLine_12
	 */
	public String getFormattedAddressLine_12() {
		return formattedAddressLine_12;
	}

	/**
	 * Set the value of column formattedAddressLine_12.
	 * 
	 * @param formattedAddressLine_12
	 *            the formattedAddressLine_12
	 */
	public void setFormattedAddressLine_12(String formattedAddressLine_12) {
		this.formattedAddressLine_12 = formattedAddressLine_12;
	}

	/**
	 * Get the value of column formattedAddressLine_13.
	 * 
	 * @return formattedAddressLine_13
	 */
	public String getFormattedAddressLine_13() {
		return formattedAddressLine_13;
	}

	/**
	 * Set the value of column formattedAddressLine_13.
	 * 
	 * @param formattedAddressLine_13
	 *            the formattedAddressLine_13
	 */
	public void setFormattedAddressLine_13(String formattedAddressLine_13) {
		this.formattedAddressLine_13 = formattedAddressLine_13;
	}

	/**
	 * Get the value of column formattedAddressLine_14.
	 * 
	 * @return formattedAddressLine_14
	 */
	public String getFormattedAddressLine_14() {
		return formattedAddressLine_14;
	}

	/**
	 * Set the value of column formattedAddressLine_14.
	 * 
	 * @param formattedAddressLine_14
	 *            the formattedAddressLine_14
	 */
	public void setFormattedAddressLine_14(String formattedAddressLine_14) {
		this.formattedAddressLine_14 = formattedAddressLine_14;
	}

	/**
	 * Get the value of column formattedAddressLine_15.
	 * 
	 * @return formattedAddressLine_15
	 */
	public String getFormattedAddressLine_15() {
		return formattedAddressLine_15;
	}

	/**
	 * Set the value of column formattedAddressLine_15.
	 * 
	 * @param formattedAddressLine_15
	 *            the formattedAddressLine_15
	 */
	public void setFormattedAddressLine_15(String formattedAddressLine_15) {
		this.formattedAddressLine_15 = formattedAddressLine_15;
	}

	/**
	 * Get the value of column formattedAddressLine_16.
	 * 
	 * @return formattedAddressLine_16
	 */
	public String getFormattedAddressLine_16() {
		return formattedAddressLine_16;
	}

	/**
	 * Set the value of column formattedAddressLine_16.
	 * 
	 * @param formattedAddressLine_16
	 *            the formattedAddressLine_16
	 */
	public void setFormattedAddressLine_16(String formattedAddressLine_16) {
		this.formattedAddressLine_16 = formattedAddressLine_16;
	}

	/**
	 * Get the value of column formattedAddressLine_17.
	 * 
	 * @return formattedAddressLine_17
	 */
	public String getFormattedAddressLine_17() {
		return formattedAddressLine_17;
	}

	/**
	 * Set the value of column formattedAddressLine_17.
	 * 
	 * @param formattedAddressLine_17
	 *            the formattedAddressLine_17
	 */
	public void setFormattedAddressLine_17(String formattedAddressLine_17) {
		this.formattedAddressLine_17 = formattedAddressLine_17;
	}

	/**
	 * Get the value of column formattedAddressLine_18.
	 * 
	 * @return formattedAddressLine_18
	 */
	public String getFormattedAddressLine_18() {
		return formattedAddressLine_18;
	}

	/**
	 * Set the value of column formattedAddressLine_18.
	 * 
	 * @param formattedAddressLine_18
	 *            the formattedAddressLine_18
	 */
	public void setFormattedAddressLine_18(String formattedAddressLine_18) {
		this.formattedAddressLine_18 = formattedAddressLine_18;
	}

	/**
	 * Get the value of column formattedAddressLine_19.
	 * 
	 * @return formattedAddressLine_19
	 */
	public String getFormattedAddressLine_19() {
		return formattedAddressLine_19;
	}

	/**
	 * Set the value of column formattedAddressLine_19.
	 * 
	 * @param formattedAddressLine_19
	 *            the formattedAddressLine_19
	 */
	public void setFormattedAddressLine_19(String formattedAddressLine_19) {
		this.formattedAddressLine_19 = formattedAddressLine_19;
	}

	/**
	 * Get the value of column completeAddress.
	 * 
	 * @return completeAddress
	 */
	public String getCompleteAddress() {
		return completeAddress;
	}

	/**
	 * Set the value of column completeAddress.
	 * 
	 * @param completeAddress
	 *            the completeAddress
	 */
	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	/**
	 * Get the value of column country1_ABBREVIATION.
	 * 
	 * @return country1_ABBREVIATION
	 */
	public String getCountry1_ABBREVIATION() {
		return country1_ABBREVIATION;
	}

	/**
	 * Set the value of column country1_ABBREVIATION.
	 * 
	 * @param country1_ABBREVIATION
	 *            the country1_ABBREVIATION
	 */
	public void setCountry1_ABBREVIATION(String country1_ABBREVIATION) {
		this.country1_ABBREVIATION = country1_ABBREVIATION;
	}

	/**
	 * Get the value of column country1_ISO2.
	 * 
	 * @return country1_ISO2
	 */
	public String getCountry1_ISO2() {
		return country1_ISO2;
	}

	/**
	 * Set the value of column country1_ISO2.
	 * 
	 * @param country1_ISO2
	 *            the country1_ISO2
	 */
	public void setCountry1_ISO2(String country1_ISO2) {
		this.country1_ISO2 = country1_ISO2;
	}

	/**
	 * Get the value of column country1_ISO3.
	 * 
	 * @return country1_ISO3
	 */
	public String getCountry1_ISO3() {
		return country1_ISO3;
	}

	/**
	 * Set the value of column country1_ISO3.
	 * 
	 * @param country1_ISO3
	 *            the country1_ISO3
	 */
	public void setCountry1_ISO3(String country1_ISO3) {
		this.country1_ISO3 = country1_ISO3;
	}

	/**
	 * Get the value of column country1_ISO_NUMBER.
	 * 
	 * @return country1_ISO_NUMBER
	 */
	public String getCountry1_ISO_NUMBER() {
		return country1_ISO_NUMBER;
	}

	/**
	 * Set the value of column country1_ISO_NUMBER.
	 * 
	 * @param country1_ISO_NUMBER
	 *            the country1_ISO_NUMBER
	 */
	public void setCountry1_ISO_NUMBER(String country1_ISO_NUMBER) {
		this.country1_ISO_NUMBER = country1_ISO_NUMBER;
	}

	/**
	 * Get the value of column country1_NAME_CN.
	 * 
	 * @return country1_NAME_CN
	 */
	public String getCountry1_NAME_CN() {
		return country1_NAME_CN;
	}

	/**
	 * Set the value of column country1_NAME_CN.
	 * 
	 * @param country1_NAME_CN
	 *            the country1_NAME_CN
	 */
	public void setCountry1_NAME_CN(String country1_NAME_CN) {
		this.country1_NAME_CN = country1_NAME_CN;
	}

	/**
	 * Get the value of column country1_NAME_DA.
	 * 
	 * @return country1_NAME_DA
	 */
	public String getCountry1_NAME_DA() {
		return country1_NAME_DA;
	}

	/**
	 * Set the value of column country1_NAME_DA.
	 * 
	 * @param country1_NAME_DA
	 *            the country1_NAME_DA
	 */
	public void setCountry1_NAME_DA(String country1_NAME_DA) {
		this.country1_NAME_DA = country1_NAME_DA;
	}

	/**
	 * Get the value of column country1_NAME_DE.
	 * 
	 * @return country1_NAME_DE
	 */
	public String getCountry1_NAME_DE() {
		return country1_NAME_DE;
	}

	/**
	 * Set the value of column country1_NAME_DE.
	 * 
	 * @param country1_NAME_DE
	 *            the country1_NAME_DE
	 */
	public void setCountry1_NAME_DE(String country1_NAME_DE) {
		this.country1_NAME_DE = country1_NAME_DE;
	}

	/**
	 * Get the value of column country1_NAME_ES.
	 * 
	 * @return country1_NAME_ES
	 */
	public String getCountry1_NAME_ES() {
		return country1_NAME_ES;
	}

	/**
	 * Set the value of column country1_NAME_ES.
	 * 
	 * @param country1_NAME_ES
	 *            the country1_NAME_ES
	 */
	public void setCountry1_NAME_ES(String country1_NAME_ES) {
		this.country1_NAME_ES = country1_NAME_ES;
	}

	/**
	 * Get the value of column country1_NAME_FI.
	 * 
	 * @return country1_NAME_FI
	 */
	public String getCountry1_NAME_FI() {
		return country1_NAME_FI;
	}

	/**
	 * Set the value of column country1_NAME_FI.
	 * 
	 * @param country1_NAME_FI
	 *            the country1_NAME_FI
	 */
	public void setCountry1_NAME_FI(String country1_NAME_FI) {
		this.country1_NAME_FI = country1_NAME_FI;
	}

	/**
	 * Get the value of column country1_NAME_FR.
	 * 
	 * @return country1_NAME_FR
	 */
	public String getCountry1_NAME_FR() {
		return country1_NAME_FR;
	}

	/**
	 * Set the value of column country1_NAME_FR.
	 * 
	 * @param country1_NAME_FR
	 *            the country1_NAME_FR
	 */
	public void setCountry1_NAME_FR(String country1_NAME_FR) {
		this.country1_NAME_FR = country1_NAME_FR;
	}

	/**
	 * Get the value of column country1_NAME_GR.
	 * 
	 * @return country1_NAME_GR
	 */
	public String getCountry1_NAME_GR() {
		return country1_NAME_GR;
	}

	/**
	 * Set the value of column country1_NAME_GR.
	 * 
	 * @param country1_NAME_GR
	 *            the country1_NAME_GR
	 */
	public void setCountry1_NAME_GR(String country1_NAME_GR) {
		this.country1_NAME_GR = country1_NAME_GR;
	}

	/**
	 * Get the value of column country1_NAME_HU.
	 * 
	 * @return country1_NAME_HU
	 */
	public String getCountry1_NAME_HU() {
		return country1_NAME_HU;
	}

	/**
	 * Set the value of column country1_NAME_HU.
	 * 
	 * @param country1_NAME_HU
	 *            the country1_NAME_HU
	 */
	public void setCountry1_NAME_HU(String country1_NAME_HU) {
		this.country1_NAME_HU = country1_NAME_HU;
	}

	/**
	 * Get the value of column country1_NAME_IT.
	 * 
	 * @return country1_NAME_IT
	 */
	public String getCountry1_NAME_IT() {
		return country1_NAME_IT;
	}

	/**
	 * Set the value of column country1_NAME_IT.
	 * 
	 * @param country1_NAME_IT
	 *            the country1_NAME_IT
	 */
	public void setCountry1_NAME_IT(String country1_NAME_IT) {
		this.country1_NAME_IT = country1_NAME_IT;
	}

	/**
	 * Get the value of column country1_NAME_JP.
	 * 
	 * @return country1_NAME_JP
	 */
	public String getCountry1_NAME_JP() {
		return country1_NAME_JP;
	}

	/**
	 * Set the value of column country1_NAME_JP.
	 * 
	 * @param country1_NAME_JP
	 *            the country1_NAME_JP
	 */
	public void setCountry1_NAME_JP(String country1_NAME_JP) {
		this.country1_NAME_JP = country1_NAME_JP;
	}

	/**
	 * Get the value of column country1_NAME_KR.
	 * 
	 * @return country1_NAME_KR
	 */
	public String getCountry1_NAME_KR() {
		return country1_NAME_KR;
	}

	/**
	 * Set the value of column country1_NAME_KR.
	 * 
	 * @param country1_NAME_KR
	 *            the country1_NAME_KR
	 */
	public void setCountry1_NAME_KR(String country1_NAME_KR) {
		this.country1_NAME_KR = country1_NAME_KR;
	}

	/**
	 * Get the value of column country1_NAME_NL.
	 * 
	 * @return country1_NAME_NL
	 */
	public String getCountry1_NAME_NL() {
		return country1_NAME_NL;
	}

	/**
	 * Set the value of column country1_NAME_NL.
	 * 
	 * @param country1_NAME_NL
	 *            the country1_NAME_NL
	 */
	public void setCountry1_NAME_NL(String country1_NAME_NL) {
		this.country1_NAME_NL = country1_NAME_NL;
	}

	/**
	 * Get the value of column country1_NAME_PL.
	 * 
	 * @return country1_NAME_PL
	 */
	public String getCountry1_NAME_PL() {
		return country1_NAME_PL;
	}

	/**
	 * Set the value of column country1_NAME_PL.
	 * 
	 * @param country1_NAME_PL
	 *            the country1_NAME_PL
	 */
	public void setCountry1_NAME_PL(String country1_NAME_PL) {
		this.country1_NAME_PL = country1_NAME_PL;
	}

	/**
	 * Get the value of column country1_NAME_PT.
	 * 
	 * @return country1_NAME_PT
	 */
	public String getCountry1_NAME_PT() {
		return country1_NAME_PT;
	}

	/**
	 * Set the value of column country1_NAME_PT.
	 * 
	 * @param country1_NAME_PT
	 *            the country1_NAME_PT
	 */
	public void setCountry1_NAME_PT(String country1_NAME_PT) {
		this.country1_NAME_PT = country1_NAME_PT;
	}

	/**
	 * Get the value of column country1_NAME_RU.
	 * 
	 * @return country1_NAME_RU
	 */
	public String getCountry1_NAME_RU() {
		return country1_NAME_RU;
	}

	/**
	 * Set the value of column country1_NAME_RU.
	 * 
	 * @param country1_NAME_RU
	 *            the country1_NAME_RU
	 */
	public void setCountry1_NAME_RU(String country1_NAME_RU) {
		this.country1_NAME_RU = country1_NAME_RU;
	}

	/**
	 * Get the value of column country1_NAME_SA.
	 * 
	 * @return country1_NAME_SA
	 */
	public String getCountry1_NAME_SA() {
		return country1_NAME_SA;
	}

	/**
	 * Set the value of column country1_NAME_SA.
	 * 
	 * @param country1_NAME_SA
	 *            the country1_NAME_SA
	 */
	public void setCountry1_NAME_SA(String country1_NAME_SA) {
		this.country1_NAME_SA = country1_NAME_SA;
	}

	/**
	 * Get the value of column country1_NAME_SE.
	 * 
	 * @return country1_NAME_SE
	 */
	public String getCountry1_NAME_SE() {
		return country1_NAME_SE;
	}

	/**
	 * Set the value of column country1_NAME_SE.
	 * 
	 * @param country1_NAME_SE
	 *            the country1_NAME_SE
	 */
	public void setCountry1_NAME_SE(String country1_NAME_SE) {
		this.country1_NAME_SE = country1_NAME_SE;
	}

	/**
	 * Get the value of column country2_ABBREVIATION.
	 * 
	 * @return country2_ABBREVIATION
	 */
	public String getCountry2_ABBREVIATION() {
		return country2_ABBREVIATION;
	}

	/**
	 * Set the value of column country2_ABBREVIATION.
	 * 
	 * @param country2_ABBREVIATION
	 *            the country2_ABBREVIATION
	 */
	public void setCountry2_ABBREVIATION(String country2_ABBREVIATION) {
		this.country2_ABBREVIATION = country2_ABBREVIATION;
	}

	/**
	 * Get the value of column country2_ISO2.
	 * 
	 * @return country2_ISO2
	 */
	public String getCountry2_ISO2() {
		return country2_ISO2;
	}

	/**
	 * Set the value of column country2_ISO2.
	 * 
	 * @param country2_ISO2
	 *            the country2_ISO2
	 */
	public void setCountry2_ISO2(String country2_ISO2) {
		this.country2_ISO2 = country2_ISO2;
	}

	/**
	 * Get the value of column country2_ISO3.
	 * 
	 * @return country2_ISO3
	 */
	public String getCountry2_ISO3() {
		return country2_ISO3;
	}

	/**
	 * Set the value of column country2_ISO3.
	 * 
	 * @param country2_ISO3
	 *            the country2_ISO3
	 */
	public void setCountry2_ISO3(String country2_ISO3) {
		this.country2_ISO3 = country2_ISO3;
	}

	/**
	 * Get the value of column country2_ISO_NUMBER.
	 * 
	 * @return country2_ISO_NUMBER
	 */
	public String getCountry2_ISO_NUMBER() {
		return country2_ISO_NUMBER;
	}

	/**
	 * Set the value of column country2_ISO_NUMBER.
	 * 
	 * @param country2_ISO_NUMBER
	 *            the country2_ISO_NUMBER
	 */
	public void setCountry2_ISO_NUMBER(String country2_ISO_NUMBER) {
		this.country2_ISO_NUMBER = country2_ISO_NUMBER;
	}

	/**
	 * Get the value of column country2_NAME_CN.
	 * 
	 * @return country2_NAME_CN
	 */
	public String getCountry2_NAME_CN() {
		return country2_NAME_CN;
	}

	/**
	 * Set the value of column country2_NAME_CN.
	 * 
	 * @param country2_NAME_CN
	 *            the country2_NAME_CN
	 */
	public void setCountry2_NAME_CN(String country2_NAME_CN) {
		this.country2_NAME_CN = country2_NAME_CN;
	}

	/**
	 * Get the value of column country2_NAME_DA.
	 * 
	 * @return country2_NAME_DA
	 */
	public String getCountry2_NAME_DA() {
		return country2_NAME_DA;
	}

	/**
	 * Set the value of column country2_NAME_DA.
	 * 
	 * @param country2_NAME_DA
	 *            the country2_NAME_DA
	 */
	public void setCountry2_NAME_DA(String country2_NAME_DA) {
		this.country2_NAME_DA = country2_NAME_DA;
	}

	/**
	 * Get the value of column country2_NAME_DE.
	 * 
	 * @return country2_NAME_DE
	 */
	public String getCountry2_NAME_DE() {
		return country2_NAME_DE;
	}

	/**
	 * Set the value of column country2_NAME_DE.
	 * 
	 * @param country2_NAME_DE
	 *            the country2_NAME_DE
	 */
	public void setCountry2_NAME_DE(String country2_NAME_DE) {
		this.country2_NAME_DE = country2_NAME_DE;
	}

	/**
	 * Get the value of column country2_NAME_ES.
	 * 
	 * @return country2_NAME_ES
	 */
	public String getCountry2_NAME_ES() {
		return country2_NAME_ES;
	}

	/**
	 * Set the value of column country2_NAME_ES.
	 * 
	 * @param country2_NAME_ES
	 *            the country2_NAME_ES
	 */
	public void setCountry2_NAME_ES(String country2_NAME_ES) {
		this.country2_NAME_ES = country2_NAME_ES;
	}

	/**
	 * Get the value of column country2_NAME_FI.
	 * 
	 * @return country2_NAME_FI
	 */
	public String getCountry2_NAME_FI() {
		return country2_NAME_FI;
	}

	/**
	 * Set the value of column country2_NAME_FI.
	 * 
	 * @param country2_NAME_FI
	 *            the country2_NAME_FI
	 */
	public void setCountry2_NAME_FI(String country2_NAME_FI) {
		this.country2_NAME_FI = country2_NAME_FI;
	}

	/**
	 * Get the value of column country2_NAME_FR.
	 * 
	 * @return country2_NAME_FR
	 */
	public String getCountry2_NAME_FR() {
		return country2_NAME_FR;
	}

	/**
	 * Set the value of column country2_NAME_FR.
	 * 
	 * @param country2_NAME_FR
	 *            the country2_NAME_FR
	 */
	public void setCountry2_NAME_FR(String country2_NAME_FR) {
		this.country2_NAME_FR = country2_NAME_FR;
	}

	/**
	 * Get the value of column country2_NAME_GR.
	 * 
	 * @return country2_NAME_GR
	 */
	public String getCountry2_NAME_GR() {
		return country2_NAME_GR;
	}

	/**
	 * Set the value of column country2_NAME_GR.
	 * 
	 * @param country2_NAME_GR
	 *            the country2_NAME_GR
	 */
	public void setCountry2_NAME_GR(String country2_NAME_GR) {
		this.country2_NAME_GR = country2_NAME_GR;
	}

	/**
	 * Get the value of column country2_NAME_HU.
	 * 
	 * @return country2_NAME_HU
	 */
	public String getCountry2_NAME_HU() {
		return country2_NAME_HU;
	}

	/**
	 * Set the value of column country2_NAME_HU.
	 * 
	 * @param country2_NAME_HU
	 *            the country2_NAME_HU
	 */
	public void setCountry2_NAME_HU(String country2_NAME_HU) {
		this.country2_NAME_HU = country2_NAME_HU;
	}

	/**
	 * Get the value of column country2_NAME_IT.
	 * 
	 * @return country2_NAME_IT.
	 */
	public String getCountry2_NAME_IT() {
		return country2_NAME_IT;
	}

	/**
	 * Set the value of column country2_NAME_IT.
	 * 
	 * @param country2_NAME_IT
	 *            the country2_NAME_IT
	 */
	public void setCountry2_NAME_IT(String country2_NAME_IT) {
		this.country2_NAME_IT = country2_NAME_IT;
	}

	/**
	 * Get the value of column country2_NAME_JP.
	 * 
	 * @return country2_NAME_JP
	 */
	public String getCountry2_NAME_JP() {
		return country2_NAME_JP;
	}

	/**
	 * Set the value of column country2_NAME_JP.
	 * 
	 * @param country2_NAME_JP
	 *            the country2_NAME_JP
	 */
	public void setCountry2_NAME_JP(String country2_NAME_JP) {
		this.country2_NAME_JP = country2_NAME_JP;
	}

	/**
	 * Get the value of column country2_NAME_KR.
	 * 
	 * @return country2_NAME_KR
	 */
	public String getCountry2_NAME_KR() {
		return country2_NAME_KR;
	}

	/**
	 * Set the value of column country2_NAME_KR.
	 * 
	 * @param country2_NAME_KR
	 *            the country2_NAME_KR
	 */
	public void setCountry2_NAME_KR(String country2_NAME_KR) {
		this.country2_NAME_KR = country2_NAME_KR;
	}

	/**
	 * Get the value of column country2_NAME_NL.
	 * 
	 * @return country2_NAME_NL
	 */
	public String getCountry2_NAME_NL() {
		return country2_NAME_NL;
	}

	/**
	 * Set the value of column country2_NAME_NL.
	 * 
	 * @param country2_NAME_NL
	 *            the country2_NAME_NL
	 */
	public void setCountry2_NAME_NL(String country2_NAME_NL) {
		this.country2_NAME_NL = country2_NAME_NL;
	}

	/**
	 * Get the value of column country2_NAME_PL.
	 * 
	 * @return country2_NAME_PL
	 */
	public String getCountry2_NAME_PL() {
		return country2_NAME_PL;
	}

	/**
	 * Set the value of column country2_NAME_PL.
	 * 
	 * @param country2_NAME_PL
	 *            the country2_NAME_PL
	 */
	public void setCountry2_NAME_PL(String country2_NAME_PL) {
		this.country2_NAME_PL = country2_NAME_PL;
	}

	/**
	 * Get the value of column country2_NAME_PT.
	 * 
	 * @return country2_NAME_PT
	 */
	public String getCountry2_NAME_PT() {
		return country2_NAME_PT;
	}

	/**
	 * Set the value of column country2_NAME_PT.
	 * 
	 * @param country2_NAME_PT
	 *            the country2_NAME_PT
	 */
	public void setCountry2_NAME_PT(String country2_NAME_PT) {
		this.country2_NAME_PT = country2_NAME_PT;
	}

	/**
	 * Get the value of column country2_NAME_RU.
	 * 
	 * @return country2_NAME_RU
	 */
	public String getCountry2_NAME_RU() {
		return country2_NAME_RU;
	}

	/**
	 * Set the value of column country2_NAME_RU.
	 * 
	 * @param country2_NAME_RU
	 *            the country2_NAME_RU
	 */
	public void setCountry2_NAME_RU(String country2_NAME_RU) {
		this.country2_NAME_RU = country2_NAME_RU;
	}

	/**
	 * Get the value of column country2_NAME_SA.
	 * 
	 * @return country2_NAME_SA
	 */
	public String getCountry2_NAME_SA() {
		return country2_NAME_SA;
	}

	/**
	 * Set the value of column country2_NAME_SA.
	 * 
	 * @param country2_NAME_SA
	 *            the country2_NAME_SA
	 */
	public void setCountry2_NAME_SA(String country2_NAME_SA) {
		this.country2_NAME_SA = country2_NAME_SA;
	}

	/**
	 * Get the value of column country2_NAME_SE.
	 * 
	 * @return country2_NAME_SE
	 */
	public String getCountry2_NAME_SE() {
		return country2_NAME_SE;
	}

	/**
	 * Set the value of column country2_NAME_SE.
	 * 
	 * @param country2_NAME_SE
	 *            the country2_NAME_SE
	 */
	public void setCountry2_NAME_SE(String country2_NAME_SE) {
		this.country2_NAME_SE = country2_NAME_SE;
	}

	/**
	 * Get the value of column country3_ABBREVIATION.
	 * 
	 * @return country3_ABBREVIATION
	 */
	public String getCountry3_ABBREVIATION() {
		return country3_ABBREVIATION;
	}

	/**
	 * Set the value of column country3_ABBREVIATION.
	 * 
	 * @param country3_ABBREVIATION
	 *            the country3_ABBREVIATION
	 */
	public void setCountry3_ABBREVIATION(String country3_ABBREVIATION) {
		this.country3_ABBREVIATION = country3_ABBREVIATION;
	}

	/**
	 * Get the value of column country3_ISO2.
	 * 
	 * @return country3_ISO2
	 */
	public String getCountry3_ISO2() {
		return country3_ISO2;
	}

	/**
	 * Set the value of column country3_ISO2.
	 * 
	 * @param country3_ISO2
	 *            the country3_ISO2
	 */
	public void setCountry3_ISO2(String country3_ISO2) {
		this.country3_ISO2 = country3_ISO2;
	}

	/**
	 * Get the value of column country3_ISO3.
	 * 
	 * @return country3_ISO3
	 */
	public String getCountry3_ISO3() {
		return country3_ISO3;
	}

	/**
	 * Set the value of column country3_ISO3.
	 * 
	 * @param country3_ISO3
	 *            the country3_ISO3
	 */
	public void setCountry3_ISO3(String country3_ISO3) {
		this.country3_ISO3 = country3_ISO3;
	}

	/**
	 * Get the value of column country3_ISO_NUMBER.
	 * 
	 * @return country3_ISO_NUMBER
	 */
	public String getCountry3_ISO_NUMBER() {
		return country3_ISO_NUMBER;
	}

	/**
	 * Set the value of column country3_ISO_NUMBER.
	 * 
	 * @param country3_ISO_NUMBER
	 *            the country3_ISO_NUMBER
	 */
	public void setCountry3_ISO_NUMBER(String country3_ISO_NUMBER) {
		this.country3_ISO_NUMBER = country3_ISO_NUMBER;
	}

	/**
	 * Get the value of column country3_NAME_CN.
	 * 
	 * @return country3_NAME_CN
	 */
	public String getCountry3_NAME_CN() {
		return country3_NAME_CN;
	}

	/**
	 * Set the value of column country3_NAME_CN.
	 * 
	 * @param country3_NAME_CN
	 *            the country3_NAME_CN
	 */
	public void setCountry3_NAME_CN(String country3_NAME_CN) {
		this.country3_NAME_CN = country3_NAME_CN;
	}

	/**
	 * Get the value of column country3_NAME_DA.
	 * 
	 * @return country3_NAME_DA
	 */
	public String getCountry3_NAME_DA() {
		return country3_NAME_DA;
	}

	/**
	 * Set the value of column country3_NAME_DA.
	 * 
	 * @param country3_NAME_DA
	 *            the country3_NAME_DA
	 */
	public void setCountry3_NAME_DA(String country3_NAME_DA) {
		this.country3_NAME_DA = country3_NAME_DA;
	}

	/**
	 * Get the value of column country3_NAME_DE.
	 * 
	 * @return country3_NAME_DE
	 */
	public String getCountry3_NAME_DE() {
		return country3_NAME_DE;
	}

	/**
	 * Set the value of column country3_NAME_DE.
	 * 
	 * @param country3_NAME_DE
	 *            the country3_NAME_DE
	 */
	public void setCountry3_NAME_DE(String country3_NAME_DE) {
		this.country3_NAME_DE = country3_NAME_DE;
	}

	/**
	 * Get the value of column country3_NAME_ES.
	 * 
	 * @return country3_NAME_ES
	 */
	public String getCountry3_NAME_ES() {
		return country3_NAME_ES;
	}

	/**
	 * Set the value of column country3_NAME_ES.
	 * 
	 * @param country3_NAME_ES
	 *            the country3_NAME_ES
	 */
	public void setCountry3_NAME_ES(String country3_NAME_ES) {
		this.country3_NAME_ES = country3_NAME_ES;
	}

	/**
	 * Get the value of column country3_NAME_FI.
	 * 
	 * @return country3_NAME_FI
	 */
	public String getCountry3_NAME_FI() {
		return country3_NAME_FI;
	}

	/**
	 * Set the value of column country3_NAME_FI.
	 * 
	 * @param country3_NAME_FI
	 *            the country3_NAME_FI
	 */
	public void setCountry3_NAME_FI(String country3_NAME_FI) {
		this.country3_NAME_FI = country3_NAME_FI;
	}

	/**
	 * Get the value of column country3_NAME_FR.
	 * 
	 * @return country3_NAME_FR
	 */
	public String getCountry3_NAME_FR() {
		return country3_NAME_FR;
	}

	/**
	 * Set the value of column country3_NAME_FR.
	 * 
	 * @param country3_NAME_FR
	 *            the country3_NAME_FR
	 */
	public void setCountry3_NAME_FR(String country3_NAME_FR) {
		this.country3_NAME_FR = country3_NAME_FR;
	}

	/**
	 * Get the value of column country3_NAME_GR.
	 * 
	 * @return country3_NAME_GR
	 */
	public String getCountry3_NAME_GR() {
		return country3_NAME_GR;
	}

	/**
	 * Set the value of column country3_NAME_GR.
	 * 
	 * @param country3_NAME_GR
	 *            the country3_NAME_GR
	 */
	public void setCountry3_NAME_GR(String country3_NAME_GR) {
		this.country3_NAME_GR = country3_NAME_GR;
	}

	/**
	 * Get the value of column country3_NAME_HU.
	 * 
	 * @return country3_NAME_HU
	 */
	public String getCountry3_NAME_HU() {
		return country3_NAME_HU;
	}

	/**
	 * Set the value of column country3_NAME_HU.
	 * 
	 * @param country3_NAME_HU
	 *            the country3_NAME_HU
	 */
	public void setCountry3_NAME_HU(String country3_NAME_HU) {
		this.country3_NAME_HU = country3_NAME_HU;
	}

	/**
	 * Get the value of column country3_NAME_IT.
	 * 
	 * @return country3_NAME_IT
	 */
	public String getCountry3_NAME_IT() {
		return country3_NAME_IT;
	}

	/**
	 * Set the value of column country3_NAME_IT.
	 * 
	 * @param country3_NAME_IT
	 *            the country3_NAME_IT
	 */
	public void setCountry3_NAME_IT(String country3_NAME_IT) {
		this.country3_NAME_IT = country3_NAME_IT;
	}

	/**
	 * Get the value of column country3_NAME_JP.
	 * 
	 * @return country3_NAME_JP.
	 */
	public String getCountry3_NAME_JP() {
		return country3_NAME_JP;
	}

	/**
	 * Set the value of column country3_NAME_JP.
	 * 
	 * @param country3_NAME_JP
	 *            the country3_NAME_JP
	 */
	public void setCountry3_NAME_JP(String country3_NAME_JP) {
		this.country3_NAME_JP = country3_NAME_JP;
	}

	/**
	 * Get the value of column country3_NAME_KR.
	 * 
	 * @return country3_NAME_KR
	 */
	public String getCountry3_NAME_KR() {
		return country3_NAME_KR;
	}

	/**
	 * Set the value of column country3_NAME_KR.
	 * 
	 * @param country3_NAME_KR
	 *            the country3_NAME_KR
	 */
	public void setCountry3_NAME_KR(String country3_NAME_KR) {
		this.country3_NAME_KR = country3_NAME_KR;
	}

	/**
	 * Get the value of column country3_NAME_NL.
	 * 
	 * @return country3_NAME_NL
	 */
	public String getCountry3_NAME_NL() {
		return country3_NAME_NL;
	}

	/**
	 * Set the value of column country3_NAME_NL.
	 * 
	 * @param country3_NAME_NL
	 *            the country3_NAME_NL
	 */
	public void setCountry3_NAME_NL(String country3_NAME_NL) {
		this.country3_NAME_NL = country3_NAME_NL;
	}

	/**
	 * Get the value of column country3_NAME_PL.
	 * 
	 * @return country3_NAME_PL
	 */
	public String getCountry3_NAME_PL() {
		return country3_NAME_PL;
	}

	/**
	 * Set the value of column country3_NAME_PL.
	 * 
	 * @param country3_NAME_PL
	 *            the country3_NAME_PL
	 */
	public void setCountry3_NAME_PL(String country3_NAME_PL) {
		this.country3_NAME_PL = country3_NAME_PL;
	}

	/**
	 * Get the value of column country3_NAME_PT.
	 * 
	 * @return country3_NAME_PT
	 */
	public String getCountry3_NAME_PT() {
		return country3_NAME_PT;
	}

	/**
	 * Set the value of column country3_NAME_PT.
	 * 
	 * @param country3_NAME_PT
	 *            the country3_NAME_PT
	 */
	public void setCountry3_NAME_PT(String country3_NAME_PT) {
		this.country3_NAME_PT = country3_NAME_PT;
	}

	/**
	 * Get the value of column country3_NAME_RU.
	 * 
	 * @return country3_NAME_RU
	 */
	public String getCountry3_NAME_RU() {
		return country3_NAME_RU;
	}

	/**
	 * Set the value of column country3_NAME_RU.
	 * 
	 * @param country3_NAME_RU
	 *            the country3_NAME_RU
	 */
	public void setCountry3_NAME_RU(String country3_NAME_RU) {
		this.country3_NAME_RU = country3_NAME_RU;
	}

	/**
	 * Get the value of column country3_NAME_SA.
	 * 
	 * @return country3_NAME_SA
	 */
	public String getCountry3_NAME_SA() {
		return country3_NAME_SA;
	}

	/**
	 * Set the value of column country3_NAME_SA.
	 * 
	 * @param country3_NAME_SA
	 *            the country3_NAME_SA
	 */
	public void setCountry3_NAME_SA(String country3_NAME_SA) {
		this.country3_NAME_SA = country3_NAME_SA;
	}

	/**
	 * Get the value of column country3_NAME_SE.
	 * 
	 * @return country3_NAME_SE
	 */
	public String getCountry3_NAME_SE() {
		return country3_NAME_SE;
	}

	/**
	 * Set the value of column country3_NAME_SE.
	 * 
	 * @param country3_NAME_SE
	 *            the country3_NAME_SE
	 */
	public void setCountry3_NAME_SE(String country3_NAME_SE) {
		this.country3_NAME_SE = country3_NAME_SE;
	}

	/**
	 * Get the value of column locality1_NAME.
	 * 
	 * @return locality1_NAME
	 */
	public String getLocality1_NAME() {
		return locality1_NAME;
	}

	/**
	 * Set the value of column locality1_NAME.
	 * 
	 * @param locality1_NAME
	 *            the locality1_NAME
	 */
	public void setLocality1_NAME(String locality1_NAME) {
		this.locality1_NAME = locality1_NAME;
	}

	/**
	 * Get the value of column locality1_PREFERRED_NAME.
	 * 
	 * @return locality1_PREFERRED_NAME
	 */
	public String getLocality1_PREFERRED_NAME() {
		return locality1_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality1_PREFERRED_NAME.
	 * 
	 * @param locality1_PREFERRED_NAME
	 *            the locality1_PREFERRED_NAME
	 */
	public void setLocality1_PREFERRED_NAME(String locality1_PREFERRED_NAME) {
		this.locality1_PREFERRED_NAME = locality1_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality1_SORTING_CODE.
	 * 
	 * @return locality1_SORTING_CODE
	 */
	public String getLocality1_SORTING_CODE() {
		return locality1_SORTING_CODE;
	}

	/**
	 * Set the value of column locality1_SORTING_CODE.
	 * 
	 * @param locality1_SORTING_CODE
	 *            the locality1_SORTING_CODE
	 */
	public void setLocality1_SORTING_CODE(String locality1_SORTING_CODE) {
		this.locality1_SORTING_CODE = locality1_SORTING_CODE;
	}

	/**
	 * Get the value of column locality1_ADD_INFO.
	 * 
	 * @return locality1_ADD_INFO
	 */
	public String getLocality1_ADD_INFO() {
		return locality1_ADD_INFO;
	}

	/**
	 * Set the value of column locality1_ADD_INFO.
	 * 
	 * @param locality1_ADD_INFO
	 *            the locality1_ADD_INFO
	 */
	public void setLocality1_ADD_INFO(String locality1_ADD_INFO) {
		this.locality1_ADD_INFO = locality1_ADD_INFO;
	}

	/**
	 * Get the value of column locality2_NAME.
	 * 
	 * @return locality2_NAME
	 */
	public String getLocality2_NAME() {
		return locality2_NAME;
	}

	/**
	 * Set the value of column locality2_NAME.
	 * 
	 * @param locality2_NAME
	 *            the locality2_NAME
	 */
	public void setLocality2_NAME(String locality2_NAME) {
		this.locality2_NAME = locality2_NAME;
	}

	/**
	 * Get the value of column locality2_PREFERRED_NAME.
	 * 
	 * @return locality2_PREFERRED_NAME
	 */
	public String getLocality2_PREFERRED_NAME() {
		return locality2_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality2_PREFERRED_NAME.
	 * 
	 * @param locality2_PREFERRED_NAME
	 *            the locality2_PREFERRED_NAME
	 */
	public void setLocality2_PREFERRED_NAME(String locality2_PREFERRED_NAME) {
		this.locality2_PREFERRED_NAME = locality2_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality2_SORTING_CODE.
	 * 
	 * @return locality2_SORTING_CODE
	 */
	public String getLocality2_SORTING_CODE() {
		return locality2_SORTING_CODE;
	}

	/**
	 * Set the value of column locality2_SORTING_CODE.
	 * 
	 * @param locality2_SORTING_CODE
	 *            the locality2_SORTING_CODE
	 */
	public void setLocality2_SORTING_CODE(String locality2_SORTING_CODE) {
		this.locality2_SORTING_CODE = locality2_SORTING_CODE;
	}

	/**
	 * Get the value of column locality2_ADD_INFO.
	 * 
	 * @return locality2_ADD_INFO
	 */
	public String getLocality2_ADD_INFO() {
		return locality2_ADD_INFO;
	}

	/**
	 * Set the value of column locality2_ADD_INFO.
	 * 
	 * @param locality2_ADD_INFO
	 *            the locality2_ADD_INFO
	 */
	public void setLocality2_ADD_INFO(String locality2_ADD_INFO) {
		this.locality2_ADD_INFO = locality2_ADD_INFO;
	}

	/**
	 * Get the value of column locality3_NAME.
	 * 
	 * @return locality3_NAME
	 */
	public String getLocality3_NAME() {
		return locality3_NAME;
	}

	/**
	 * Set the value of column locality3_NAME.
	 * 
	 * @param locality3_NAME
	 *            the locality3_NAME
	 */
	public void setLocality3_NAME(String locality3_NAME) {
		this.locality3_NAME = locality3_NAME;
	}

	/**
	 * Get the value of column locality3_PREFERRED_NAME.
	 * 
	 * @return locality3_PREFERRED_NAME
	 */
	public String getLocality3_PREFERRED_NAME() {
		return locality3_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality3_PREFERRED_NAME.
	 * 
	 * @param locality3_PREFERRED_NAME
	 *            the locality3_PREFERRED_NAME
	 */
	public void setLocality3_PREFERRED_NAME(String locality3_PREFERRED_NAME) {
		this.locality3_PREFERRED_NAME = locality3_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality3_SORTING_CODE.
	 * 
	 * @return locality3_SORTING_CODE
	 */
	public String getLocality3_SORTING_CODE() {
		return locality3_SORTING_CODE;
	}

	/**
	 * Set the value of column locality3_SORTING_CODE.
	 * 
	 * @param locality3_SORTING_CODE
	 *            the locality3_SORTING_CODE
	 */
	public void setLocality3_SORTING_CODE(String locality3_SORTING_CODE) {
		this.locality3_SORTING_CODE = locality3_SORTING_CODE;
	}

	/**
	 * Get the value of column locality3_ADD_INFO.
	 * 
	 * @return locality3_ADD_INFO
	 */
	public String getLocality3_ADD_INFO() {
		return locality3_ADD_INFO;
	}

	/**
	 * Set the value of column locality3_ADD_INFO.
	 * 
	 * @param locality3_ADD_INFO
	 *            the locality3_ADD_INFO
	 */
	public void setLocality3_ADD_INFO(String locality3_ADD_INFO) {
		this.locality3_ADD_INFO = locality3_ADD_INFO;
	}

	/**
	 * Get the value of column locality4_NAME.
	 * 
	 * @return locality4_NAME
	 */
	public String getLocality4_NAME() {
		return locality4_NAME;
	}

	/**
	 * Set the value of column locality4_NAME.
	 * 
	 * @param locality4_NAME
	 *            the locality4_NAME
	 */
	public void setLocality4_NAME(String locality4_NAME) {
		this.locality4_NAME = locality4_NAME;
	}

	/**
	 * Get the value of column locality4_PREFERRED_NAME.
	 * 
	 * @return locality4_PREFERRED_NAME
	 */
	public String getLocality4_PREFERRED_NAME() {
		return locality4_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality4_PREFERRED_NAME.
	 * 
	 * @param locality4_PREFERRED_NAME
	 *            the locality4_PREFERRED_NAME
	 */
	public void setLocality4_PREFERRED_NAME(String locality4_PREFERRED_NAME) {
		this.locality4_PREFERRED_NAME = locality4_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality4_SORTING_CODE.
	 * 
	 * @return locality4_SORTING_CODE
	 */
	public String getLocality4_SORTING_CODE() {
		return locality4_SORTING_CODE;
	}

	/**
	 * Set the value of column locality4_SORTING_CODE.
	 * 
	 * @param locality4_SORTING_CODE
	 *            the locality4_SORTING_CODE
	 */
	public void setLocality4_SORTING_CODE(String locality4_SORTING_CODE) {
		this.locality4_SORTING_CODE = locality4_SORTING_CODE;
	}

	/**
	 * Get the value of column locality4_ADD_INFO.
	 * 
	 * @return locality4_ADD_INFO
	 */
	public String getLocality4_ADD_INFO() {
		return locality4_ADD_INFO;
	}

	/**
	 * Set the value of column locality4_ADD_INFO.
	 * 
	 * @param locality4_ADD_INFO
	 *            the locality4_ADD_INFO
	 */
	public void setLocality4_ADD_INFO(String locality4_ADD_INFO) {
		this.locality4_ADD_INFO = locality4_ADD_INFO;
	}

	/**
	 * Get the value of column locality5_NAME.
	 * 
	 * @return locality5_NAME
	 */
	public String getLocality5_NAME() {
		return locality5_NAME;
	}

	/**
	 * Set the value of column locality5_NAME.
	 * 
	 * @param locality5_NAME
	 *            the locality5_NAME
	 */
	public void setLocality5_NAME(String locality5_NAME) {
		this.locality5_NAME = locality5_NAME;
	}

	/**
	 * Get the value of column locality5_PREFERRED_NAME.
	 * 
	 * @return locality5_PREFERRED_NAME
	 */
	public String getLocality5_PREFERRED_NAME() {
		return locality5_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality5_PREFERRED_NAME.
	 * 
	 * @param locality5_PREFERRED_NAME
	 *            the locality5_PREFERRED_NAME
	 */
	public void setLocality5_PREFERRED_NAME(String locality5_PREFERRED_NAME) {
		this.locality5_PREFERRED_NAME = locality5_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality5_SORTING_CODE.
	 * 
	 * @return locality5_SORTING_CODE
	 */
	public String getLocality5_SORTING_CODE() {
		return locality5_SORTING_CODE;
	}

	/**
	 * Set the value of column locality5_SORTING_CODE.
	 * 
	 * @param locality5_SORTING_CODE
	 *            the locality5_SORTING_CODE
	 */
	public void setLocality5_SORTING_CODE(String locality5_SORTING_CODE) {
		this.locality5_SORTING_CODE = locality5_SORTING_CODE;
	}

	/**
	 * Get the value of column locality5_ADD_INFO.
	 * 
	 * @return locality5_ADD_INFO
	 */
	public String getLocality5_ADD_INFO() {
		return locality5_ADD_INFO;
	}

	/**
	 * Set the value of column locality5_ADD_INFO.
	 * 
	 * @param locality5_ADD_INFO
	 *            the locality5_ADD_INFO
	 */
	public void setLocality5_ADD_INFO(String locality5_ADD_INFO) {
		this.locality5_ADD_INFO = locality5_ADD_INFO;
	}

	/**
	 * Get the value of column locality6_NAME.
	 * 
	 * @return locality6_NAME
	 */
	public String getLocality6_NAME() {
		return locality6_NAME;
	}

	/**
	 * Set the value of column locality6_NAME.
	 * 
	 * @param locality6_NAME
	 *            the locality6_NAME
	 */
	public void setLocality6_NAME(String locality6_NAME) {
		this.locality6_NAME = locality6_NAME;
	}

	/**
	 * Get the value of column locality6_PREFERRED_NAME.
	 * 
	 * @return locality6_PREFERRED_NAME
	 */
	public String getLocality6_PREFERRED_NAME() {
		return locality6_PREFERRED_NAME;
	}

	/**
	 * Set the value of column locality6_PREFERRED_NAME.
	 * 
	 * @param locality6_PREFERRED_NAME
	 *            the locality6_PREFERRED_NAME
	 */
	public void setLocality6_PREFERRED_NAME(String locality6_PREFERRED_NAME) {
		this.locality6_PREFERRED_NAME = locality6_PREFERRED_NAME;
	}

	/**
	 * Get the value of column locality6_SORTING_CODE.
	 * 
	 * @return locality6_SORTING_CODE
	 */
	public String getLocality6_SORTING_CODE() {
		return locality6_SORTING_CODE;
	}

	/**
	 * Set the value of column locality6_SORTING_CODE.
	 * 
	 * @param locality6_SORTING_CODE
	 *            the locality6_SORTING_CODE
	 */
	public void setLocality6_SORTING_CODE(String locality6_SORTING_CODE) {
		this.locality6_SORTING_CODE = locality6_SORTING_CODE;
	}

	/**
	 * Get the value of column locality6_ADD_INFO.
	 * 
	 * @return locality6_ADD_INFO
	 */
	public String getLocality6_ADD_INFO() {
		return locality6_ADD_INFO;
	}

	/**
	 * Set the value of column locality6_ADD_INFO.
	 * 
	 * @param locality6_ADD_INFO
	 *            the locality6_ADD_INFO
	 */
	public void setLocality6_ADD_INFO(String locality6_ADD_INFO) {
		this.locality6_ADD_INFO = locality6_ADD_INFO;
	}

	/**
	 * Get the value of column postalCode1_UNFORMATTED.
	 * 
	 * @return postalCode1_UNFORMATTED
	 */
	public String getPostalCode1_UNFORMATTED() {
		return postalCode1_UNFORMATTED;
	}

	/**
	 * Set the value of column postalCode1_UNFORMATTED.
	 * 
	 * @param postalCode1_UNFORMATTED
	 *            the postalCode1_UNFORMATTED
	 */
	public void setPostalCode1_UNFORMATTED(String postalCode1_UNFORMATTED) {
		this.postalCode1_UNFORMATTED = postalCode1_UNFORMATTED;
	}

	/**
	 * Get the value of column postalCode1_BASE.
	 * 
	 * @return postalCode1_BASE
	 */
	public String getPostalCode1_BASE() {
		return postalCode1_BASE;
	}

	/**
	 * Set the value of column postalCode1_BASE.
	 * 
	 * @param postalCode1_BASE
	 *            the postalCode1_BASE
	 */
	public void setPostalCode1_BASE(String postalCode1_BASE) {
		this.postalCode1_BASE = postalCode1_BASE;
	}

	/**
	 * Get the value of column postalCode1_ADD_ON.
	 * 
	 * @return postalCode1_ADD_ON
	 */
	public String getPostalCode1_ADD_ON() {
		return postalCode1_ADD_ON;
	}

	/**
	 * Set the value of column postalCode1_ADD_ON.
	 * 
	 * @param postalCode1_ADD_ON
	 *            the postalCode1_ADD_ON
	 */
	public void setPostalCode1_ADD_ON(String postalCode1_ADD_ON) {
		this.postalCode1_ADD_ON = postalCode1_ADD_ON;
	}

	/**
	 * Get the value of column postalCode2_UNFORMATTED.
	 * 
	 * @return postalCode2_UNFORMATTED
	 */
	public String getPostalCode2_UNFORMATTED() {
		return postalCode2_UNFORMATTED;
	}

	/**
	 * Set the value of column postalCode2_UNFORMATTED.
	 * 
	 * @param postalCode2_UNFORMATTED
	 *            the postalCode2_UNFORMATTED
	 */
	public void setPostalCode2_UNFORMATTED(String postalCode2_UNFORMATTED) {
		this.postalCode2_UNFORMATTED = postalCode2_UNFORMATTED;
	}

	/**
	 * Get the value of column postalCode2_BASE.
	 * 
	 * @return postalCode2_BASE
	 */
	public String getPostalCode2_BASE() {
		return postalCode2_BASE;
	}

	/**
	 * Set the value of column postalCode2_BASE.
	 * 
	 * @param postalCode2_BASE
	 *            the postalCode2_BASE
	 */
	public void setPostalCode2_BASE(String postalCode2_BASE) {
		this.postalCode2_BASE = postalCode2_BASE;
	}

	/**
	 * Get the value of column postalCode2_ADD_ON.
	 * 
	 * @return postalCode2_ADD_ON
	 */
	public String getPostalCode2_ADD_ON() {
		return postalCode2_ADD_ON;
	}

	/**
	 * Set the value of column postalCode2_ADD_ON.
	 * 
	 * @param postalCode2_ADD_ON
	 *            the postalCode2_ADD_ON
	 */
	public void setPostalCode2_ADD_ON(String postalCode2_ADD_ON) {
		this.postalCode2_ADD_ON = postalCode2_ADD_ON;
	}

	/**
	 * Get the value of column postalCode3_UNFORMATTED.
	 * 
	 * @return postalCode3_UNFORMATTED
	 */
	public String getPostalCode3_UNFORMATTED() {
		return postalCode3_UNFORMATTED;
	}

	/**
	 * Set the value of column postalCode3_UNFORMATTED.
	 * 
	 * @param postalCode3_UNFORMATTED
	 *            the postalCode3_UNFORMATTED
	 */
	public void setPostalCode3_UNFORMATTED(String postalCode3_UNFORMATTED) {
		this.postalCode3_UNFORMATTED = postalCode3_UNFORMATTED;
	}

	/**
	 * Get the value of column postalCode3_BASE.
	 * 
	 * @return postalCode3_BASE
	 */
	public String getPostalCode3_BASE() {
		return postalCode3_BASE;
	}

	/**
	 * Set the value of column postalCode3_BASE.
	 * 
	 * @param postalCode3_BASE
	 *            the postalCode3_BASE
	 */
	public void setPostalCode3_BASE(String postalCode3_BASE) {
		this.postalCode3_BASE = postalCode3_BASE;
	}

	/**
	 * Get the value of column postalCode3_ADD_ON.
	 * 
	 * @return postalCode3_ADD_ON
	 */
	public String getPostalCode3_ADD_ON() {
		return postalCode3_ADD_ON;
	}

	/**
	 * Set the value of column postalCode3_ADD_ON.
	 * 
	 * @param postalCode3_ADD_ON
	 *            the postalCode3_ADD_ON
	 */
	public void setPostalCode3_ADD_ON(String postalCode3_ADD_ON) {
		this.postalCode3_ADD_ON = postalCode3_ADD_ON;
	}

	/**
	 * Get the value of column province1_ABBREVIATION.
	 * 
	 * @return province1_ABBREVIATION.
	 */
	public String getProvince1_ABBREVIATION() {
		return province1_ABBREVIATION;
	}

	/**
	 * Set the value of column province1_ABBREVIATION.
	 * 
	 * @param province1_ABBREVIATION
	 *            the province1_ABBREVIATION
	 */
	public void setProvince1_ABBREVIATION(String province1_ABBREVIATION) {
		this.province1_ABBREVIATION = province1_ABBREVIATION;
	}

	/**
	 * Get the value of column province1_EXTENDED.
	 * 
	 * @return province1_EXTENDED
	 */
	public String getProvince1_EXTENDED() {
		return province1_EXTENDED;
	}

	/**
	 * Set the value of column province1_EXTENDED.
	 * 
	 * @param province1_EXTENDED
	 *            the province1_EXTENDED
	 */
	public void setProvince1_EXTENDED(String province1_EXTENDED) {
		this.province1_EXTENDED = province1_EXTENDED;
	}

	/**
	 * Get the value of column province1_ISO.
	 * 
	 * @return province1_ISO
	 */
	public String getProvince1_ISO() {
		return province1_ISO;
	}

	/**
	 * Set the value of column province1_ISO.
	 * 
	 * @param province1_ISO
	 *            the province1_ISO
	 */
	public void setProvince1_ISO(String province1_ISO) {
		this.province1_ISO = province1_ISO;
	}

	/**
	 * Get the value of column province2_ABBREVIATION.
	 * 
	 * @return province2_ABBREVIATION
	 */
	public String getProvince2_ABBREVIATION() {
		return province2_ABBREVIATION;
	}

	/**
	 * Set the value of column province2_ABBREVIATION.
	 * 
	 * @param province2_ABBREVIATION
	 *            the province2_ABBREVIATION
	 */
	public void setProvince2_ABBREVIATION(String province2_ABBREVIATION) {
		this.province2_ABBREVIATION = province2_ABBREVIATION;
	}

	/**
	 * Get the value of column province2_EXTENDED.
	 * 
	 * @return province2_EXTENDED
	 */
	public String getProvince2_EXTENDED() {
		return province2_EXTENDED;
	}

	/**
	 * Set the value of column province2_EXTENDED.
	 * 
	 * @param province2_EXTENDED
	 *            the province2_EXTENDED
	 */
	public void setProvince2_EXTENDED(String province2_EXTENDED) {
		this.province2_EXTENDED = province2_EXTENDED;
	}

	/**
	 * Get the value of column province2_ISO.
	 * 
	 * @return province2_ISO
	 */
	public String getProvince2_ISO() {
		return province2_ISO;
	}

	/**
	 * Set the value of column province2_ISO.
	 * 
	 * @param province2_ISO
	 *            the province2_ISO
	 */
	public void setProvince2_ISO(String province2_ISO) {
		this.province2_ISO = province2_ISO;
	}

	/**
	 * Get the value of column province3_ABBREVIATION.
	 * 
	 * @return province3_ABBREVIATION
	 */
	public String getProvince3_ABBREVIATION() {
		return province3_ABBREVIATION;
	}

	/**
	 * Set the value of column province3_ABBREVIATION.
	 * 
	 * @param province3_ABBREVIATION
	 *            the province3_ABBREVIATION
	 */
	public void setProvince3_ABBREVIATION(String province3_ABBREVIATION) {
		this.province3_ABBREVIATION = province3_ABBREVIATION;
	}

	/**
	 * Get the value of column province3_EXTENDED.
	 * 
	 * @return province3_EXTENDED
	 */
	public String getProvince3_EXTENDED() {
		return province3_EXTENDED;
	}

	/**
	 * Set the value of column province3_EXTENDED.
	 * 
	 * @param province3_EXTENDED
	 *            the province3_EXTENDED
	 */
	public void setProvince3_EXTENDED(String province3_EXTENDED) {
		this.province3_EXTENDED = province3_EXTENDED;
	}

	/**
	 * Get the value of column province3_ISO.
	 * 
	 * @return province3_ISO
	 */
	public String getProvince3_ISO() {
		return province3_ISO;
	}

	/**
	 * Set the value of column province3_ISO.
	 * 
	 * @param province3_ISO
	 *            the province3_ISO
	 */
	public void setProvince3_ISO(String province3_ISO) {
		this.province3_ISO = province3_ISO;
	}

	/**
	 * Get the value of column province4_ABBREVIATION.
	 * 
	 * @return province4_ABBREVIATION
	 */
	public String getProvince4_ABBREVIATION() {
		return province4_ABBREVIATION;
	}

	/**
	 * Set the value of column province4_ABBREVIATION.
	 * 
	 * @param province4_ABBREVIATION
	 *            the province4_ABBREVIATION
	 */
	public void setProvince4_ABBREVIATION(String province4_ABBREVIATION) {
		this.province4_ABBREVIATION = province4_ABBREVIATION;
	}

	/**
	 * Get the value of column province4_EXTENDED.
	 * 
	 * @return province4_EXTENDED
	 */
	public String getProvince4_EXTENDED() {
		return province4_EXTENDED;
	}

	/**
	 * Set the value of column province4_EXTENDED.
	 * 
	 * @param province4_EXTENDED
	 *            the province4_EXTENDED
	 */
	public void setProvince4_EXTENDED(String province4_EXTENDED) {
		this.province4_EXTENDED = province4_EXTENDED;
	}

	/**
	 * Get the value of column province4_ISO.
	 * 
	 * @return province4_ISO
	 */
	public String getProvince4_ISO() {
		return province4_ISO;
	}

	/**
	 * Set the value of column province4_ISO.
	 * 
	 * @param province4_ISO
	 *            the province4_ISO
	 */
	public void setProvince4_ISO(String province4_ISO) {
		this.province4_ISO = province4_ISO;
	}

	/**
	 * Get the value of column province5_ABBREVIATION.
	 * 
	 * @return province5_ABBREVIATION
	 */
	public String getProvince5_ABBREVIATION() {
		return province5_ABBREVIATION;
	}

	/**
	 * Set the value of column province5_ABBREVIATION.
	 * 
	 * @param province5_ABBREVIATION
	 *            the province5_ABBREVIATION
	 */
	public void setProvince5_ABBREVIATION(String province5_ABBREVIATION) {
		this.province5_ABBREVIATION = province5_ABBREVIATION;
	}

	/**
	 * Get the value of column province5_EXTENDED.
	 * 
	 * @return province5_EXTENDED
	 */
	public String getProvince5_EXTENDED() {
		return province5_EXTENDED;
	}

	/**
	 * Set the value of column province5_EXTENDED.
	 * 
	 * @param province5_EXTENDED
	 *            the province5_EXTENDED
	 */
	public void setProvince5_EXTENDED(String province5_EXTENDED) {
		this.province5_EXTENDED = province5_EXTENDED;
	}

	/**
	 * Get the value of column province5_ISO.
	 * 
	 * @return province5_ISO
	 */
	public String getProvince5_ISO() {
		return province5_ISO;
	}

	/**
	 * Set the value of column province5_ISO.
	 * 
	 * @param province5_ISO
	 *            the province5_ISO
	 */
	public void setProvince5_ISO(String province5_ISO) {
		this.province5_ISO = province5_ISO;
	}

	/**
	 * Get the value of column province6_ABBREVIATION.
	 * 
	 * @return province6_ABBREVIATION
	 */
	public String getProvince6_ABBREVIATION() {
		return province6_ABBREVIATION;
	}

	/**
	 * Set the value of column province6_ABBREVIATION.
	 * 
	 * @param province6_ABBREVIATION
	 *            the province6_ABBREVIATION
	 */
	public void setProvince6_ABBREVIATION(String province6_ABBREVIATION) {
		this.province6_ABBREVIATION = province6_ABBREVIATION;
	}

	/**
	 * Get the value of column province6_EXTENDED.
	 * 
	 * @return province6_EXTENDED
	 */
	public String getProvince6_EXTENDED() {
		return province6_EXTENDED;
	}

	/**
	 * Set the value of column province6_EXTENDED.
	 * 
	 * @param province6_EXTENDED
	 *            the province6_EXTENDED
	 */
	public void setProvince6_EXTENDED(String province6_EXTENDED) {
		this.province6_EXTENDED = province6_EXTENDED;
	}

	/**
	 * Get the value of column province6_ISO.
	 * 
	 * @return province6_ISO
	 */
	public String getProvince6_ISO() {
		return province6_ISO;
	}

	/**
	 * Set the value of column province6_ISO.
	 * 
	 * @param province6_ISO
	 *            the province6_ISO
	 */
	public void setProvince6_ISO(String province6_ISO) {
		this.province6_ISO = province6_ISO;
	}

	/**
	 * Get the value of column street1_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street1_COMPLETE_WITH_NUMBER
	 */
	public String getStreet1_COMPLETE_WITH_NUMBER() {
		return street1_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street1_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street1_COMPLETE_WITH_NUMBER
	 *            the street1_COMPLETE_WITH_NUMBER
	 */
	public void setStreet1_COMPLETE_WITH_NUMBER(String street1_COMPLETE_WITH_NUMBER) {
		this.street1_COMPLETE_WITH_NUMBER = street1_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street1_NAME.
	 * 
	 * @return street1_NAME
	 */
	public String getStreet1_NAME() {
		return street1_NAME;
	}

	/**
	 * Set the value of column street1_NAME.
	 * 
	 * @param street1_NAME
	 *            the street1_NAME
	 */
	public void setStreet1_NAME(String street1_NAME) {
		this.street1_NAME = street1_NAME;
	}

	/**
	 * Get the value of column street1_PRE_DESCRIPTOR.
	 * 
	 * @return street1_PRE_DESCRIPTOR
	 */
	public String getStreet1_PRE_DESCRIPTOR() {
		return street1_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street1_PRE_DESCRIPTOR.
	 * 
	 * @param street1_PRE_DESCRIPTOR
	 *            the street1_PRE_DESCRIPTOR
	 */
	public void setStreet1_PRE_DESCRIPTOR(String street1_PRE_DESCRIPTOR) {
		this.street1_PRE_DESCRIPTOR = street1_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street1_POST_DESCRIPTOR.
	 * 
	 * @return street1_POST_DESCRIPTOR
	 */
	public String getStreet1_POST_DESCRIPTOR() {
		return street1_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street1_POST_DESCRIPTOR.
	 * 
	 * @param street1_POST_DESCRIPTOR
	 *            the street1_POST_DESCRIPTOR
	 */
	public void setStreet1_POST_DESCRIPTOR(String street1_POST_DESCRIPTOR) {
		this.street1_POST_DESCRIPTOR = street1_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street1_PRE_DIRECTIONAL.
	 * 
	 * @return street1_PRE_DIRECTIONAL
	 */
	public String getStreet1_PRE_DIRECTIONAL() {
		return street1_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street1_PRE_DIRECTIONAL.
	 * 
	 * @param street1_PRE_DIRECTIONAL
	 *            the street1_PRE_DIRECTIONAL
	 */
	public void setStreet1_PRE_DIRECTIONAL(String street1_PRE_DIRECTIONAL) {
		this.street1_PRE_DIRECTIONAL = street1_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street1_POST_DIRECTIONAL.
	 * 
	 * @return street1_POST_DIRECTIONAL
	 */
	public String getStreet1_POST_DIRECTIONAL() {
		return street1_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street1_POST_DIRECTIONAL.
	 * 
	 * @param street1_POST_DIRECTIONAL
	 *            the street1_POST_DIRECTIONAL
	 */
	public void setStreet1_POST_DIRECTIONAL(String street1_POST_DIRECTIONAL) {
		this.street1_POST_DIRECTIONAL = street1_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street1_ADD_INFO.
	 * 
	 * @return street1_ADD_INFO
	 */
	public String getStreet1_ADD_INFO() {
		return street1_ADD_INFO;
	}

	/**
	 * Set the value of column street1_ADD_INFO.
	 * 
	 * @param street1_ADD_INFO
	 *            the street1_ADD_INFO
	 */
	public void setStreet1_ADD_INFO(String street1_ADD_INFO) {
		this.street1_ADD_INFO = street1_ADD_INFO;
	}

	/**
	 * Get the value of column street2_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street2_COMPLETE_WITH_NUMBER
	 */
	public String getStreet2_COMPLETE_WITH_NUMBER() {
		return street2_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street2_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street2_COMPLETE_WITH_NUMBER
	 *            the street2_COMPLETE_WITH_NUMBER
	 */
	public void setStreet2_COMPLETE_WITH_NUMBER(String street2_COMPLETE_WITH_NUMBER) {
		this.street2_COMPLETE_WITH_NUMBER = street2_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street2_NAME.
	 * 
	 * @return street2_NAME
	 */
	public String getStreet2_NAME() {
		return street2_NAME;
	}

	/**
	 * Set the value of column street2_NAME.
	 * 
	 * @param street2_NAME
	 *            the street2_NAME
	 */
	public void setStreet2_NAME(String street2_NAME) {
		this.street2_NAME = street2_NAME;
	}

	/**
	 * Get the value of column street2_PRE_DESCRIPTOR.
	 * 
	 * @return street2_PRE_DESCRIPTOR
	 */
	public String getStreet2_PRE_DESCRIPTOR() {
		return street2_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street2_PRE_DESCRIPTOR.
	 * 
	 * @param street2_PRE_DESCRIPTOR
	 *            the street2_PRE_DESCRIPTOR
	 */
	public void setStreet2_PRE_DESCRIPTOR(String street2_PRE_DESCRIPTOR) {
		this.street2_PRE_DESCRIPTOR = street2_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street2_POST_DESCRIPTOR.
	 * 
	 * @return street2_POST_DESCRIPTOR
	 */
	public String getStreet2_POST_DESCRIPTOR() {
		return street2_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street2_POST_DESCRIPTOR.
	 * 
	 * @param street2_POST_DESCRIPTOR
	 *            the street2_POST_DESCRIPTOR
	 */
	public void setStreet2_POST_DESCRIPTOR(String street2_POST_DESCRIPTOR) {
		this.street2_POST_DESCRIPTOR = street2_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street2_PRE_DIRECTIONAL.
	 * 
	 * @return street2_PRE_DIRECTIONAL
	 */
	public String getStreet2_PRE_DIRECTIONAL() {
		return street2_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street2_PRE_DIRECTIONAL.
	 * 
	 * @param street2_PRE_DIRECTIONAL
	 *            the street2_PRE_DIRECTIONAL
	 */
	public void setStreet2_PRE_DIRECTIONAL(String street2_PRE_DIRECTIONAL) {
		this.street2_PRE_DIRECTIONAL = street2_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street2_POST_DIRECTIONAL.
	 * 
	 * @return street2_POST_DIRECTIONAL
	 */
	public String getStreet2_POST_DIRECTIONAL() {
		return street2_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street2_POST_DIRECTIONAL.
	 * 
	 * @param street2_POST_DIRECTIONAL
	 *            the street2_POST_DIRECTIONAL
	 */
	public void setStreet2_POST_DIRECTIONAL(String street2_POST_DIRECTIONAL) {
		this.street2_POST_DIRECTIONAL = street2_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street2_ADD_INFO.
	 * 
	 * @return street2_ADD_INFO
	 */
	public String getStreet2_ADD_INFO() {
		return street2_ADD_INFO;
	}

	/**
	 * Set the value of column street2_ADD_INFO.
	 * 
	 * @param street2_ADD_INFO
	 *            the street2_ADD_INFO
	 */
	public void setStreet2_ADD_INFO(String street2_ADD_INFO) {
		this.street2_ADD_INFO = street2_ADD_INFO;
	}

	/**
	 * Get the value of column street3_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street3_COMPLETE_WITH_NUMBER
	 */
	public String getStreet3_COMPLETE_WITH_NUMBER() {
		return street3_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street3_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street3_COMPLETE_WITH_NUMBER
	 *            the street3_COMPLETE_WITH_NUMBER
	 */
	public void setStreet3_COMPLETE_WITH_NUMBER(String street3_COMPLETE_WITH_NUMBER) {
		this.street3_COMPLETE_WITH_NUMBER = street3_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street3_NAME.
	 * 
	 * @return street3_NAME
	 */
	public String getStreet3_NAME() {
		return street3_NAME;
	}

	/**
	 * Set the value of column street3_NAME.
	 * 
	 * @param street3_NAME
	 *            the street3_NAME
	 */
	public void setStreet3_NAME(String street3_NAME) {
		this.street3_NAME = street3_NAME;
	}

	/**
	 * get the value of column street3_PRE_DESCRIPTOR.
	 * 
	 * @return street3_PRE_DESCRIPTOR
	 */
	public String getStreet3_PRE_DESCRIPTOR() {
		return street3_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street3_PRE_DESCRIPTOR.
	 * 
	 * @param street3_PRE_DESCRIPTOR
	 *            the street3_PRE_DESCRIPTOR
	 */
	public void setStreet3_PRE_DESCRIPTOR(String street3_PRE_DESCRIPTOR) {
		this.street3_PRE_DESCRIPTOR = street3_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street3_POST_DESCRIPTOR.
	 * 
	 * @return street3_POST_DESCRIPTOR
	 */
	public String getStreet3_POST_DESCRIPTOR() {
		return street3_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street3_POST_DESCRIPTOR.
	 * 
	 * @param street3_POST_DESCRIPTOR
	 *            the street3_POST_DESCRIPTOR
	 */
	public void setStreet3_POST_DESCRIPTOR(String street3_POST_DESCRIPTOR) {
		this.street3_POST_DESCRIPTOR = street3_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street3_PRE_DIRECTIONAL.
	 * 
	 * @return street3_PRE_DIRECTIONAL
	 */
	public String getStreet3_PRE_DIRECTIONAL() {
		return street3_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street3_PRE_DIRECTIONAL.
	 * 
	 * @param street3_PRE_DIRECTIONAL
	 *            the street3_PRE_DIRECTIONAL
	 */
	public void setStreet3_PRE_DIRECTIONAL(String street3_PRE_DIRECTIONAL) {
		this.street3_PRE_DIRECTIONAL = street3_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street3_POST_DIRECTIONAL.
	 * 
	 * @return street3_POST_DIRECTIONAL
	 */
	public String getStreet3_POST_DIRECTIONAL() {
		return street3_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street3_POST_DIRECTIONAL.
	 * 
	 * @param street3_POST_DIRECTIONAL
	 *            the street3_POST_DIRECTIONAL
	 */
	public void setStreet3_POST_DIRECTIONAL(String street3_POST_DIRECTIONAL) {
		this.street3_POST_DIRECTIONAL = street3_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street3_ADD_INFO.
	 * 
	 * @return street3_ADD_INFO
	 */
	public String getStreet3_ADD_INFO() {
		return street3_ADD_INFO;
	}

	/**
	 * Set the value of column street3_ADD_INFO.
	 * 
	 * @param street3_ADD_INFO
	 *            the street3_ADD_INFO
	 */
	public void setStreet3_ADD_INFO(String street3_ADD_INFO) {
		this.street3_ADD_INFO = street3_ADD_INFO;
	}

	/**
	 * Get the value of column street4_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street4_COMPLETE_WITH_NUMBER
	 */
	public String getStreet4_COMPLETE_WITH_NUMBER() {
		return street4_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street4_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street4_COMPLETE_WITH_NUMBER
	 *            the street4_COMPLETE_WITH_NUMBER
	 */
	public void setStreet4_COMPLETE_WITH_NUMBER(String street4_COMPLETE_WITH_NUMBER) {
		this.street4_COMPLETE_WITH_NUMBER = street4_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street4_NAME.
	 * 
	 * @return street4_NAME
	 */
	public String getStreet4_NAME() {
		return street4_NAME;
	}

	/**
	 * Set the value of column street4_NAME.
	 * 
	 * @param street4_NAME
	 *            the street4_NAME
	 */
	public void setStreet4_NAME(String street4_NAME) {
		this.street4_NAME = street4_NAME;
	}

	/**
	 * Get the value of column street4_PRE_DESCRIPTOR.
	 * 
	 * @return street4_PRE_DESCRIPTOR
	 */
	public String getStreet4_PRE_DESCRIPTOR() {
		return street4_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street4_PRE_DESCRIPTOR.
	 * 
	 * @param street4_PRE_DESCRIPTOR
	 *            the street4_PRE_DESCRIPTOR
	 */
	public void setStreet4_PRE_DESCRIPTOR(String street4_PRE_DESCRIPTOR) {
		this.street4_PRE_DESCRIPTOR = street4_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street4_POST_DESCRIPTOR.
	 * 
	 * @return street4_POST_DESCRIPTOR
	 */
	public String getStreet4_POST_DESCRIPTOR() {
		return street4_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street4_POST_DESCRIPTOR.
	 * 
	 * @param street4_POST_DESCRIPTOR
	 *            the street4_POST_DESCRIPTOR
	 */
	public void setStreet4_POST_DESCRIPTOR(String street4_POST_DESCRIPTOR) {
		this.street4_POST_DESCRIPTOR = street4_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street4_PRE_DIRECTIONAL.
	 * 
	 * @return street4_PRE_DIRECTIONAL
	 */
	public String getStreet4_PRE_DIRECTIONAL() {
		return street4_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street4_PRE_DIRECTIONAL.
	 * 
	 * @param street4_PRE_DIRECTIONAL
	 *            the street4_PRE_DIRECTIONAL
	 */
	public void setStreet4_PRE_DIRECTIONAL(String street4_PRE_DIRECTIONAL) {
		this.street4_PRE_DIRECTIONAL = street4_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street4_POST_DIRECTIONAL.
	 * 
	 * @return street4_POST_DIRECTIONAL
	 */
	public String getStreet4_POST_DIRECTIONAL() {
		return street4_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street4_POST_DIRECTIONAL.
	 * 
	 * @param street4_POST_DIRECTIONAL
	 *            the street4_POST_DIRECTIONAL
	 */
	public void setStreet4_POST_DIRECTIONAL(String street4_POST_DIRECTIONAL) {
		this.street4_POST_DIRECTIONAL = street4_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street4_ADD_INFO.
	 * 
	 * @return street4_ADD_INFO
	 */
	public String getStreet4_ADD_INFO() {
		return street4_ADD_INFO;
	}

	/**
	 * Set the value of column street4_ADD_INFO.
	 * 
	 * @param street4_ADD_INFO
	 *            the street4_ADD_INFO
	 */
	public void setStreet4_ADD_INFO(String street4_ADD_INFO) {
		this.street4_ADD_INFO = street4_ADD_INFO;
	}

	/**
	 * Get the value of column street5_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street5_COMPLETE_WITH_NUMBER
	 */
	public String getStreet5_COMPLETE_WITH_NUMBER() {
		return street5_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street5_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street5_COMPLETE_WITH_NUMBER
	 *            the street5_COMPLETE_WITH_NUMBER
	 */
	public void setStreet5_COMPLETE_WITH_NUMBER(String street5_COMPLETE_WITH_NUMBER) {
		this.street5_COMPLETE_WITH_NUMBER = street5_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street5_NAME.
	 * 
	 * @return street5_NAME
	 */
	public String getStreet5_NAME() {
		return street5_NAME;
	}

	/**
	 * Set the value of column street5_NAME.
	 * 
	 * @param street5_NAME
	 *            the street5_NAME
	 */
	public void setStreet5_NAME(String street5_NAME) {
		this.street5_NAME = street5_NAME;
	}

	/**
	 * Get the value of column street5_PRE_DESCRIPTOR.
	 * 
	 * @return street5_PRE_DESCRIPTOR
	 */
	public String getStreet5_PRE_DESCRIPTOR() {
		return street5_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street5_PRE_DESCRIPTOR.
	 * 
	 * @param street5_PRE_DESCRIPTOR
	 *            thestreet5_PRE_DESCRIPTOR
	 */
	public void setStreet5_PRE_DESCRIPTOR(String street5_PRE_DESCRIPTOR) {
		this.street5_PRE_DESCRIPTOR = street5_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street5_POST_DESCRIPTOR.
	 * 
	 * @return street5_POST_DESCRIPTOR
	 */
	public String getStreet5_POST_DESCRIPTOR() {
		return street5_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street5_PRE_DIRECTIONAL.
	 * 
	 * @param street5_POST_DESCRIPTOR
	 *            the street5_POST_DESCRIPTOR
	 */
	public void setStreet5_POST_DESCRIPTOR(String street5_POST_DESCRIPTOR) {
		this.street5_POST_DESCRIPTOR = street5_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street5_PRE_DIRECTIONAL.
	 * 
	 * @return street5_PRE_DIRECTIONAL
	 */
	public String getStreet5_PRE_DIRECTIONAL() {
		return street5_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street5_PRE_DIRECTIONAL.
	 * 
	 * @param street5_PRE_DIRECTIONAL
	 *            the street5_PRE_DIRECTIONAL
	 */
	public void setStreet5_PRE_DIRECTIONAL(String street5_PRE_DIRECTIONAL) {
		this.street5_PRE_DIRECTIONAL = street5_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street5_POST_DIRECTIONAL.
	 * 
	 * @return street5_POST_DIRECTIONAL
	 */
	public String getStreet5_POST_DIRECTIONAL() {
		return street5_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street5_POST_DIRECTIONAL.
	 * 
	 * @param street5_POST_DIRECTIONAL
	 *            the street5_POST_DIRECTIONAL
	 */
	public void setStreet5_POST_DIRECTIONAL(String street5_POST_DIRECTIONAL) {
		this.street5_POST_DIRECTIONAL = street5_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street5_ADD_INFO.
	 * 
	 * @return street5_ADD_INFO
	 */
	public String getStreet5_ADD_INFO() {
		return street5_ADD_INFO;
	}

	/**
	 * Set the value of column street5_ADD_INFO.
	 * 
	 * @param street5_ADD_INFO
	 *            the street5_ADD_INFO
	 */
	public void setStreet5_ADD_INFO(String street5_ADD_INFO) {
		this.street5_ADD_INFO = street5_ADD_INFO;
	}

	/**
	 * Get the value of column street6_COMPLETE_WITH_NUMBER.
	 * 
	 * @return street6_COMPLETE_WITH_NUMBER
	 */
	public String getStreet6_COMPLETE_WITH_NUMBER() {
		return street6_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Set the value of column street6_COMPLETE_WITH_NUMBER.
	 * 
	 * @param street6_COMPLETE_WITH_NUMBER
	 *            the street6_COMPLETE_WITH_NUMBER
	 */
	public void setStreet6_COMPLETE_WITH_NUMBER(String street6_COMPLETE_WITH_NUMBER) {
		this.street6_COMPLETE_WITH_NUMBER = street6_COMPLETE_WITH_NUMBER;
	}

	/**
	 * Get the value of column street6_NAME.
	 * 
	 * @return street6_NAME
	 */
	public String getStreet6_NAME() {
		return street6_NAME;
	}

	/**
	 * Set the value of column street6_NAME.
	 * 
	 * @param street6_NAME
	 *            the street6_NAME
	 */
	public void setStreet6_NAME(String street6_NAME) {
		this.street6_NAME = street6_NAME;
	}

	/**
	 * Get the value of column street6_PRE_DESCRIPTOR.
	 * 
	 * @return street6_PRE_DESCRIPTOR
	 */
	public String getStreet6_PRE_DESCRIPTOR() {
		return street6_PRE_DESCRIPTOR;
	}

	/**
	 * Set the value of column street6_PRE_DESCRIPTOR.
	 * 
	 * @param street6_PRE_DESCRIPTOR
	 *            the street6_PRE_DESCRIPTOR
	 */
	public void setStreet6_PRE_DESCRIPTOR(String street6_PRE_DESCRIPTOR) {
		this.street6_PRE_DESCRIPTOR = street6_PRE_DESCRIPTOR;
	}

	/**
	 * Get the value of column street6_POST_DESCRIPTOR
	 * 
	 * @return street6_POST_DESCRIPTOR
	 */
	public String getStreet6_POST_DESCRIPTOR() {
		return street6_POST_DESCRIPTOR;
	}

	/**
	 * Set the value of column street6_POST_DESCRIPTOR.
	 * 
	 * @param street6_POST_DESCRIPTOR
	 *            the street6_POST_DESCRIPTOR
	 */
	public void setStreet6_POST_DESCRIPTOR(String street6_POST_DESCRIPTOR) {
		this.street6_POST_DESCRIPTOR = street6_POST_DESCRIPTOR;
	}

	/**
	 * Get the value of column street6_PRE_DIRECTIONAL.
	 * 
	 * @return street6_PRE_DIRECTIONAL
	 */
	public String getStreet6_PRE_DIRECTIONAL() {
		return street6_PRE_DIRECTIONAL;
	}

	/**
	 * Set the value of column street6_PRE_DIRECTIONAL.
	 * 
	 * @param street6_PRE_DIRECTIONAL
	 *            the street6_PRE_DIRECTIONAL
	 */
	public void setStreet6_PRE_DIRECTIONAL(String street6_PRE_DIRECTIONAL) {
		this.street6_PRE_DIRECTIONAL = street6_PRE_DIRECTIONAL;
	}

	/**
	 * Get the value of column street6_POST_DIRECTIONAL.
	 * 
	 * @return street6_POST_DIRECTIONAL
	 */
	public String getStreet6_POST_DIRECTIONAL() {
		return street6_POST_DIRECTIONAL;
	}

	/**
	 * Set the value of column street6_POST_DIRECTIONAL.
	 * 
	 * @param street6_POST_DIRECTIONAL
	 *            the street6_POST_DIRECTIONAL
	 */
	public void setStreet6_POST_DIRECTIONAL(String street6_POST_DIRECTIONAL) {
		this.street6_POST_DIRECTIONAL = street6_POST_DIRECTIONAL;
	}

	/**
	 * Get the value of column street6_ADD_INFO.
	 * 
	 * @return street6_ADD_INFO
	 */
	public String getStreet6_ADD_INFO() {
		return street6_ADD_INFO;
	}

	/**
	 * Set the value of column street6_ADD_INFO.
	 * 
	 * @param street6_ADD_INFO
	 *            the street6_ADD_INFO
	 */
	public void setStreet6_ADD_INFO(String street6_ADD_INFO) {
		this.street6_ADD_INFO = street6_ADD_INFO;
	}

	/**
	 * Get the value of column number1_NUMBER.
	 * 
	 * @return number1_NUMBER
	 */
	public String getNumber1_NUMBER() {
		return number1_NUMBER;
	}

	/**
	 * Set the value of column number1_NUMBER.
	 * 
	 * @param number1_NUMBER
	 *            the number1_NUMBER
	 */
	public void setNumber1_NUMBER(String number1_NUMBER) {
		this.number1_NUMBER = number1_NUMBER;
	}

	/**
	 * Get the value of column number1_DESCRIPTOR.
	 * 
	 * @return number1_DESCRIPTOR
	 */
	public String getNumber1_DESCRIPTOR() {
		return number1_DESCRIPTOR;
	}

	/**
	 * Set the value of column number1_DESCRIPTOR.
	 * 
	 * @param number1_DESCRIPTOR
	 *            the number1_DESCRIPTOR
	 */
	public void setNumber1_DESCRIPTOR(String number1_DESCRIPTOR) {
		this.number1_DESCRIPTOR = number1_DESCRIPTOR;
	}

	/**
	 * Get the value of column number1_ADD_INFO.
	 * 
	 * @return number1_ADD_INFO
	 */
	public String getNumber1_ADD_INFO() {
		return number1_ADD_INFO;
	}

	/**
	 * Set the value of column number1_ADD_INFO.
	 * 
	 * @param number1_ADD_INFO
	 *            the number1_ADD_INFO
	 */
	public void setNumber1_ADD_INFO(String number1_ADD_INFO) {
		this.number1_ADD_INFO = number1_ADD_INFO;
	}

	/**
	 * Get the value of column number2_NUMBER.
	 * 
	 * @return number2_NUMBER
	 */
	public String getNumber2_NUMBER() {
		return number2_NUMBER;
	}

	/**
	 * Set the value of column number2_NUMBER.
	 * 
	 * @param number2_NUMBER
	 *            the number2_NUMBER
	 */
	public void setNumber2_NUMBER(String number2_NUMBER) {
		this.number2_NUMBER = number2_NUMBER;
	}

	/**
	 * Get the value of column number2_DESCRIPTOR.
	 * 
	 * @return number2_DESCRIPTOR
	 */
	public String getNumber2_DESCRIPTOR() {
		return number2_DESCRIPTOR;
	}

	/**
	 * Set the value of column number2_DESCRIPTOR.
	 * 
	 * @param number2_DESCRIPTOR
	 *            the number2_DESCRIPTOR
	 */
	public void setNumber2_DESCRIPTOR(String number2_DESCRIPTOR) {
		this.number2_DESCRIPTOR = number2_DESCRIPTOR;
	}

	/**
	 * Get the value of column number2_ADD_INFO.
	 * 
	 * @return number2_ADD_INFO
	 */
	public String getNumber2_ADD_INFO() {
		return number2_ADD_INFO;
	}

	/**
	 * Set the value of column number2_ADD_INFO.
	 * 
	 * @param number2_ADD_INFO
	 *            the number2_ADD_INFO
	 */
	public void setNumber2_ADD_INFO(String number2_ADD_INFO) {
		this.number2_ADD_INFO = number2_ADD_INFO;
	}

	/**
	 * Get the value of column number3_NUMBER.
	 * 
	 * @return number3_NUMBER
	 */
	public String getNumber3_NUMBER() {
		return number3_NUMBER;
	}

	/**
	 * Set the value of column number3_NUMBER.
	 * 
	 * @param number3_NUMBER
	 *            the number3_NUMBER
	 */
	public void setNumber3_NUMBER(String number3_NUMBER) {
		this.number3_NUMBER = number3_NUMBER;
	}

	/**
	 * Get the value of column number3_DESCRIPTOR.
	 * 
	 * @return number3_DESCRIPTOR
	 */
	public String getNumber3_DESCRIPTOR() {
		return number3_DESCRIPTOR;
	}

	/**
	 * Set the value of column number3_DESCRIPTOR.
	 * 
	 * @param number3_DESCRIPTOR
	 *            the number3_DESCRIPTOR
	 */
	public void setNumber3_DESCRIPTOR(String number3_DESCRIPTOR) {
		this.number3_DESCRIPTOR = number3_DESCRIPTOR;
	}

	/**
	 * Get the value of column number3_ADD_INFO.
	 * 
	 * @return number3_ADD_INFO
	 */
	public String getNumber3_ADD_INFO() {
		return number3_ADD_INFO;
	}

	/**
	 * Set the value of column number3_ADD_INFO.
	 * 
	 * @param number3_ADD_INFO
	 *            the number3_ADD_INFO
	 */
	public void setNumber3_ADD_INFO(String number3_ADD_INFO) {
		this.number3_ADD_INFO = number3_ADD_INFO;
	}

	/**
	 * Get the value of column number4_NUMBER.
	 * 
	 * @return number4_NUMBER
	 */
	public String getNumber4_NUMBER() {
		return number4_NUMBER;
	}

	/**
	 * Set the value of column number4_NUMBER.
	 * 
	 * @param number4_NUMBER
	 *            the number4_NUMBER
	 */
	public void setNumber4_NUMBER(String number4_NUMBER) {
		this.number4_NUMBER = number4_NUMBER;
	}

	/**
	 * Get the value of column number4_DESCRIPTOR.
	 * 
	 * @return number4_DESCRIPTOR
	 */
	public String getNumber4_DESCRIPTOR() {
		return number4_DESCRIPTOR;
	}

	/**
	 * Set the value of column number4_DESCRIPTOR.
	 * 
	 * @param number4_DESCRIPTOR
	 *            the number4_DESCRIPTOR
	 */
	public void setNumber4_DESCRIPTOR(String number4_DESCRIPTOR) {
		this.number4_DESCRIPTOR = number4_DESCRIPTOR;
	}

	/**
	 * Get the value of column number4_ADD_INFO.
	 * 
	 * @return number4_ADD_INFO
	 */
	public String getNumber4_ADD_INFO() {
		return number4_ADD_INFO;
	}

	/**
	 * Set the value of column number4_ADD_INFO.
	 * 
	 * @param number4_ADD_INFO
	 *            the number4_ADD_INFO
	 */
	public void setNumber4_ADD_INFO(String number4_ADD_INFO) {
		this.number4_ADD_INFO = number4_ADD_INFO;
	}

	/**
	 * Get the value of column number5_NUMBER.
	 * 
	 * @return number5_NUMBER
	 */
	public String getNumber5_NUMBER() {
		return number5_NUMBER;
	}

	/**
	 * Set the value of column number5_NUMBER.
	 * 
	 * @param number5_NUMBER
	 *            the number5_NUMBER
	 */
	public void setNumber5_NUMBER(String number5_NUMBER) {
		this.number5_NUMBER = number5_NUMBER;
	}

	/**
	 * Get the value of column number5_DESCRIPTOR.
	 * 
	 * @return number5_DESCRIPTOR
	 */
	public String getNumber5_DESCRIPTOR() {
		return number5_DESCRIPTOR;
	}

	/**
	 * Set the value of column number5_DESCRIPTOR.
	 * 
	 * @param number5_DESCRIPTOR
	 *            the number5_DESCRIPTOR
	 */
	public void setNumber5_DESCRIPTOR(String number5_DESCRIPTOR) {
		this.number5_DESCRIPTOR = number5_DESCRIPTOR;
	}

	/**
	 * Get the value of column number5_ADD_INFO.
	 * 
	 * @return number5_ADD_INFO
	 */
	public String getNumber5_ADD_INFO() {
		return number5_ADD_INFO;
	}

	/**
	 * Set the value of column number5_ADD_INFO.
	 * 
	 * @param number5_ADD_INFO
	 *            the number5_ADD_INFO
	 */
	public void setNumber5_ADD_INFO(String number5_ADD_INFO) {
		this.number5_ADD_INFO = number5_ADD_INFO;
	}

	/**
	 * Get the value of column number6_NUMBER.
	 * 
	 * @return number6_NUMBER
	 */
	public String getNumber6_NUMBER() {
		return number6_NUMBER;
	}

	/**
	 * Set the value of column number6_NUMBER.
	 * 
	 * @param number6_NUMBER
	 *            the number6_NUMBER
	 */
	public void setNumber6_NUMBER(String number6_NUMBER) {
		this.number6_NUMBER = number6_NUMBER;
	}

	/**
	 * Get the value of column number6_DESCRIPTOR.
	 * 
	 * @return number6_DESCRIPTOR
	 */
	public String getNumber6_DESCRIPTOR() {
		return number6_DESCRIPTOR;
	}

	/**
	 * Set the value of column number6_DESCRIPTOR.
	 * 
	 * @param number6_DESCRIPTOR
	 *            the number6_DESCRIPTOR
	 */
	public void setNumber6_DESCRIPTOR(String number6_DESCRIPTOR) {
		this.number6_DESCRIPTOR = number6_DESCRIPTOR;
	}

	/**
	 * Get the value of column number6_ADD_INFO.
	 * 
	 * @return number6_ADD_INFO
	 */
	public String getNumber6_ADD_INFO() {
		return number6_ADD_INFO;
	}

	/**
	 * Set the value of column number6_ADD_INFO.
	 * 
	 * @param number6_ADD_INFO
	 *            the number6_ADD_INFO
	 */
	public void setNumber6_ADD_INFO(String number6_ADD_INFO) {
		this.number6_ADD_INFO = number6_ADD_INFO;
	}

	/**
	 * Get the value of column building1_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building1_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding1_COMPLETE_WITH_SUBBUILDING() {
		return building1_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building1_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building1_COMPLETE_WITH_SUBBUILDING
	 *            the building1_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding1_COMPLETE_WITH_SUBBUILDING(String building1_COMPLETE_WITH_SUBBUILDING) {
		this.building1_COMPLETE_WITH_SUBBUILDING = building1_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building1_NAME.
	 * 
	 * @return building1_NAME
	 */
	public String getBuilding1_NAME() {
		return building1_NAME;
	}

	/**
	 * Set the value of column building1_NAME.
	 * 
	 * @param building1_NAME
	 *            the building1_NAME
	 */
	public void setBuilding1_NAME(String building1_NAME) {
		this.building1_NAME = building1_NAME;
	}

	/**
	 * Get the value of column building1_NUMBER.
	 * 
	 * @return building1_NUMBER
	 */
	public String getBuilding1_NUMBER() {
		return building1_NUMBER;
	}

	/**
	 * Set the value of column building1_NUMBER.
	 * 
	 * @param building1_NUMBER
	 *            the building1_NUMBER
	 */
	public void setBuilding1_NUMBER(String building1_NUMBER) {
		this.building1_NUMBER = building1_NUMBER;
	}

	/**
	 * Get the value of column building1_DESCRIPTOR.
	 * 
	 * @return building1_DESCRIPTOR
	 */
	public String getBuilding1_DESCRIPTOR() {
		return building1_DESCRIPTOR;
	}

	/**
	 * Set the value of column building1_DESCRIPTOR.
	 * 
	 * @param building1_DESCRIPTOR
	 *            the building1_DESCRIPTOR
	 */
	public void setBuilding1_DESCRIPTOR(String building1_DESCRIPTOR) {
		this.building1_DESCRIPTOR = building1_DESCRIPTOR;
	}

	/**
	 * Get the value of column building2_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building2_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding2_COMPLETE_WITH_SUBBUILDING() {
		return building2_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building2_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building2_COMPLETE_WITH_SUBBUILDING
	 *            the building2_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding2_COMPLETE_WITH_SUBBUILDING(String building2_COMPLETE_WITH_SUBBUILDING) {
		this.building2_COMPLETE_WITH_SUBBUILDING = building2_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building2_NAME.
	 * 
	 * @return building2_NAME
	 */
	public String getBuilding2_NAME() {
		return building2_NAME;
	}

	/**
	 * Set the value of column building2_NAME.
	 * 
	 * @param building2_NAME
	 *            the building2_NAME
	 */
	public void setBuilding2_NAME(String building2_NAME) {
		this.building2_NAME = building2_NAME;
	}

	/**
	 * Get the value of column building2_NUMBER.
	 * 
	 * @return building2_NUMBER
	 */
	public String getBuilding2_NUMBER() {
		return building2_NUMBER;
	}

	/**
	 * Set the value of column building2_NUMBER.
	 * 
	 * @param building2_NUMBER
	 *            the building2_NUMBER
	 */
	public void setBuilding2_NUMBER(String building2_NUMBER) {
		this.building2_NUMBER = building2_NUMBER;
	}

	/**
	 * Get the value of column building2_DESCRIPTOR.
	 * 
	 * @return building2_DESCRIPTOR
	 */
	public String getBuilding2_DESCRIPTOR() {
		return building2_DESCRIPTOR;
	}

	/**
	 * Set the value of column building2_DESCRIPTOR.
	 * 
	 * @param building2_DESCRIPTOR
	 *            the building2_DESCRIPTOR
	 */
	public void setBuilding2_DESCRIPTOR(String building2_DESCRIPTOR) {
		this.building2_DESCRIPTOR = building2_DESCRIPTOR;
	}

	/**
	 * Get the value of column building3_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building3_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding3_COMPLETE_WITH_SUBBUILDING() {
		return building3_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building3_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building3_COMPLETE_WITH_SUBBUILDING
	 *            the building3_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding3_COMPLETE_WITH_SUBBUILDING(String building3_COMPLETE_WITH_SUBBUILDING) {
		this.building3_COMPLETE_WITH_SUBBUILDING = building3_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building3_NAME.
	 * 
	 * @return building3_NAME
	 */
	public String getBuilding3_NAME() {
		return building3_NAME;
	}

	/**
	 * Set the value of column building3_NAME.
	 * 
	 * @param building3_NAME
	 *            the building3_NAME
	 */
	public void setBuilding3_NAME(String building3_NAME) {
		this.building3_NAME = building3_NAME;
	}

	/**
	 * Get the value of column building3_NUMBER.
	 * 
	 * @return building3_NUMBER
	 */
	public String getBuilding3_NUMBER() {
		return building3_NUMBER;
	}

	/**
	 * Set the value of column building3_NUMBER.
	 * 
	 * @param building3_NUMBER
	 *            the building3_NUMBER
	 */
	public void setBuilding3_NUMBER(String building3_NUMBER) {
		this.building3_NUMBER = building3_NUMBER;
	}

	/**
	 * Get the value of column building3_DESCRIPTOR.
	 * 
	 * @return building3_DESCRIPTOR
	 */
	public String getBuilding3_DESCRIPTOR() {
		return building3_DESCRIPTOR;
	}

	/**
	 * Set the value of column building3_DESCRIPTOR.
	 * 
	 * @param building3_DESCRIPTOR
	 *            the building3_DESCRIPTOR
	 */
	public void setBuilding3_DESCRIPTOR(String building3_DESCRIPTOR) {
		this.building3_DESCRIPTOR = building3_DESCRIPTOR;
	}

	/**
	 * Get the value of column building4_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building4_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding4_COMPLETE_WITH_SUBBUILDING() {
		return building4_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building4_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building4_COMPLETE_WITH_SUBBUILDING
	 *            the building4_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding4_COMPLETE_WITH_SUBBUILDING(String building4_COMPLETE_WITH_SUBBUILDING) {
		this.building4_COMPLETE_WITH_SUBBUILDING = building4_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building4_NAME.
	 * 
	 * @return building4_NAME
	 */
	public String getBuilding4_NAME() {
		return building4_NAME;
	}

	/**
	 * Set the value of column building4_NAME.
	 * 
	 * @param building4_NAME
	 *            the building4_NAME
	 */
	public void setBuilding4_NAME(String building4_NAME) {
		this.building4_NAME = building4_NAME;
	}

	/**
	 * Get the value of column building4_NUMBER.
	 * 
	 * @return building4_NUMBER
	 */
	public String getBuilding4_NUMBER() {
		return building4_NUMBER;
	}

	/**
	 * Set the value of column building4_NUMBER.
	 * 
	 * @param building4_NUMBER
	 *            the building4_NUMBER
	 */
	public void setBuilding4_NUMBER(String building4_NUMBER) {
		this.building4_NUMBER = building4_NUMBER;
	}

	/**
	 * Get the value of column building4_DESCRIPTOR.
	 * 
	 * @return building4_DESCRIPTOR
	 */
	public String getBuilding4_DESCRIPTOR() {
		return building4_DESCRIPTOR;
	}

	/**
	 * Set the value of column building4_DESCRIPTOR.
	 * 
	 * @param building4_DESCRIPTOR
	 *            the building4_DESCRIPTOR
	 */
	public void setBuilding4_DESCRIPTOR(String building4_DESCRIPTOR) {
		this.building4_DESCRIPTOR = building4_DESCRIPTOR;
	}

	/**
	 * Get the value of column building5_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building5_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding5_COMPLETE_WITH_SUBBUILDING() {
		return building5_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building5_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building5_COMPLETE_WITH_SUBBUILDING
	 *            the building5_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding5_COMPLETE_WITH_SUBBUILDING(String building5_COMPLETE_WITH_SUBBUILDING) {
		this.building5_COMPLETE_WITH_SUBBUILDING = building5_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building5_NAME.
	 * 
	 * @return building5_NAME
	 */
	public String getBuilding5_NAME() {
		return building5_NAME;
	}

	/**
	 * Set the value of column building5_NAME.
	 * 
	 * @param building5_NAME
	 *            the building5_NAME
	 */
	public void setBuilding5_NAME(String building5_NAME) {
		this.building5_NAME = building5_NAME;
	}

	/**
	 * Get the value of column building5_NUMBER.
	 * 
	 * @return building5_NUMBER
	 */
	public String getBuilding5_NUMBER() {
		return building5_NUMBER;
	}

	/**
	 * Set the value of column building5_NUMBER.
	 * 
	 * @param building5_NUMBER
	 *            the building5_NUMBER
	 */
	public void setBuilding5_NUMBER(String building5_NUMBER) {
		this.building5_NUMBER = building5_NUMBER;
	}

	/**
	 * Get the value of column building5_DESCRIPTOR.
	 * 
	 * @return building5_DESCRIPTOR.
	 */
	public String getBuilding5_DESCRIPTOR() {
		return building5_DESCRIPTOR;
	}

	/**
	 * Set the value of column building5_DESCRIPTOR.
	 * 
	 * @param building5_DESCRIPTOR
	 *            the building5_DESCRIPTOR
	 */
	public void setBuilding5_DESCRIPTOR(String building5_DESCRIPTOR) {
		this.building5_DESCRIPTOR = building5_DESCRIPTOR;
	}

	/**
	 * Get the value of column building6_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @return building6_COMPLETE_WITH_SUBBUILDING
	 */
	public String getBuilding6_COMPLETE_WITH_SUBBUILDING() {
		return building6_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Set the value of column building6_COMPLETE_WITH_SUBBUILDING.
	 * 
	 * @param building6_COMPLETE_WITH_SUBBUILDING
	 *            the building6_COMPLETE_WITH_SUBBUILDING
	 */
	public void setBuilding6_COMPLETE_WITH_SUBBUILDING(String building6_COMPLETE_WITH_SUBBUILDING) {
		this.building6_COMPLETE_WITH_SUBBUILDING = building6_COMPLETE_WITH_SUBBUILDING;
	}

	/**
	 * Get the value of column building6_NAME.
	 * 
	 * @return building6_NAME
	 */
	public String getBuilding6_NAME() {
		return building6_NAME;
	}

	/**
	 * Set the value of column building6_NAME.
	 * 
	 * @param building6_NAME
	 *            the building6_NAME
	 */
	public void setBuilding6_NAME(String building6_NAME) {
		this.building6_NAME = building6_NAME;
	}

	/**
	 * Get the value of column building6_NUMBER.
	 * 
	 * @return building6_NUMBER
	 */
	public String getBuilding6_NUMBER() {
		return building6_NUMBER;
	}

	/**
	 * Set the value of column building6_NUMBER.
	 * 
	 * @param building6_NUMBER
	 *            the building6_NUMBER
	 */
	public void setBuilding6_NUMBER(String building6_NUMBER) {
		this.building6_NUMBER = building6_NUMBER;
	}

	/**
	 * Get the value of column building6_DESCRIPTOR.
	 * 
	 * @return building6_DESCRIPTOR
	 */
	public String getBuilding6_DESCRIPTOR() {
		return building6_DESCRIPTOR;
	}

	/**
	 * Set the value of column building6_DESCRIPTOR.
	 * 
	 * @param building6_DESCRIPTOR
	 *            the building6_DESCRIPTOR
	 */
	public void setBuilding6_DESCRIPTOR(String building6_DESCRIPTOR) {
		this.building6_DESCRIPTOR = building6_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding1_NAME.
	 * 
	 * @return subBuilding1_NAME
	 */
	public String getSubBuilding1_NAME() {
		return subBuilding1_NAME;
	}

	/**
	 * Set the value of column subBuilding1_NAME.
	 * 
	 * @param subBuilding1_NAME
	 *            the subBuilding1_NAME
	 */
	public void setSubBuilding1_NAME(String subBuilding1_NAME) {
		this.subBuilding1_NAME = subBuilding1_NAME;
	}

	/**
	 * Get the value of column subBuilding1_NUMBER.
	 * 
	 * @return subBuilding1_NUMBER
	 */
	public String getSubBuilding1_NUMBER() {
		return subBuilding1_NUMBER;
	}

	/**
	 * Set the value of column subBuilding1_NUMBER.
	 * 
	 * @param subBuilding1_NUMBER
	 *            the subBuilding1_NUMBER
	 */
	public void setSubBuilding1_NUMBER(String subBuilding1_NUMBER) {
		this.subBuilding1_NUMBER = subBuilding1_NUMBER;
	}

	/**
	 * Get the value of column subBuilding1_DESCRIPTOR.
	 * 
	 * @return subBuilding1_DESCRIPTOR
	 */
	public String getSubBuilding1_DESCRIPTOR() {
		return subBuilding1_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding1_DESCRIPTOR.
	 * 
	 * @param subBuilding1_DESCRIPTOR
	 *            the subBuilding1_DESCRIPTOR
	 */
	public void setSubBuilding1_DESCRIPTOR(String subBuilding1_DESCRIPTOR) {
		this.subBuilding1_DESCRIPTOR = subBuilding1_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding2_NAME.
	 * 
	 * @return subBuilding2_NAME
	 */
	public String getSubBuilding2_NAME() {
		return subBuilding2_NAME;
	}

	/**
	 * Set the value of column subBuilding2_NAME.
	 * 
	 * @param subBuilding2_NAME
	 *            the subBuilding2_NAME
	 */
	public void setSubBuilding2_NAME(String subBuilding2_NAME) {
		this.subBuilding2_NAME = subBuilding2_NAME;
	}

	/**
	 * Get the value of column subBuilding2_NUMBER.
	 * 
	 * @return subBuilding2_NUMBER
	 */
	public String getSubBuilding2_NUMBER() {
		return subBuilding2_NUMBER;
	}

	/**
	 * Set the value of column subBuilding2_NUMBER.
	 * 
	 * @param subBuilding2_NUMBER
	 *            the subBuilding2_NUMBER
	 */
	public void setSubBuilding2_NUMBER(String subBuilding2_NUMBER) {
		this.subBuilding2_NUMBER = subBuilding2_NUMBER;
	}

	/**
	 * Get the value of column subBuilding2_DESCRIPTOR.
	 * 
	 * @return subBuilding2_DESCRIPTOR
	 */
	public String getSubBuilding2_DESCRIPTOR() {
		return subBuilding2_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding2_DESCRIPTOR.
	 * 
	 * @param subBuilding2_DESCRIPTOR
	 *            the subBuilding2_DESCRIPTOR
	 */
	public void setSubBuilding2_DESCRIPTOR(String subBuilding2_DESCRIPTOR) {
		this.subBuilding2_DESCRIPTOR = subBuilding2_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding3_NAME.
	 * 
	 * @return subBuilding3_NAME
	 */
	public String getSubBuilding3_NAME() {
		return subBuilding3_NAME;
	}

	/**
	 * Set the value of column subBuilding3_NAME.
	 * 
	 * @param subBuilding3_NAME
	 *            the subBuilding3_NAME
	 */
	public void setSubBuilding3_NAME(String subBuilding3_NAME) {
		this.subBuilding3_NAME = subBuilding3_NAME;
	}

	/**
	 * Get the value of column subBuilding3_NUMBER.
	 * 
	 * @return subBuilding3_NUMBER
	 */
	public String getSubBuilding3_NUMBER() {
		return subBuilding3_NUMBER;
	}

	/**
	 * Set the value of column subBuilding3_NUMBER.
	 * 
	 * @param subBuilding3_NUMBER
	 *            the subBuilding3_NUMBER
	 */
	public void setSubBuilding3_NUMBER(String subBuilding3_NUMBER) {
		this.subBuilding3_NUMBER = subBuilding3_NUMBER;
	}

	/**
	 * Get the value of column subBuilding3_DESCRIPTOR.
	 * 
	 * @return subBuilding3_DESCRIPTOR
	 */
	public String getSubBuilding3_DESCRIPTOR() {
		return subBuilding3_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding3_DESCRIPTOR.
	 * 
	 * @param subBuilding3_DESCRIPTOR
	 *            the subBuilding3_DESCRIPTOR
	 */
	public void setSubBuilding3_DESCRIPTOR(String subBuilding3_DESCRIPTOR) {
		this.subBuilding3_DESCRIPTOR = subBuilding3_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding4_NAME.
	 * 
	 * @return subBuilding4_NAME
	 */
	public String getSubBuilding4_NAME() {
		return subBuilding4_NAME;
	}

	/**
	 * Set the value of column subBuilding4_NAME.
	 * 
	 * @param subBuilding4_NAME
	 *            the subBuilding4_NAME
	 */
	public void setSubBuilding4_NAME(String subBuilding4_NAME) {
		this.subBuilding4_NAME = subBuilding4_NAME;
	}

	/**
	 * Get the value of column subBuilding4_NUMBER.
	 * 
	 * @return subBuilding4_NUMBER
	 */
	public String getSubBuilding4_NUMBER() {
		return subBuilding4_NUMBER;
	}

	/**
	 * Set the value of column subBuilding4_NUMBER.
	 * 
	 * @param subBuilding4_NUMBER
	 *            the subBuilding4_NUMBER
	 */
	public void setSubBuilding4_NUMBER(String subBuilding4_NUMBER) {
		this.subBuilding4_NUMBER = subBuilding4_NUMBER;
	}

	/**
	 * Get the value of column subBuilding4_DESCRIPTOR.
	 * 
	 * @return subBuilding4_DESCRIPTOR
	 */
	public String getSubBuilding4_DESCRIPTOR() {
		return subBuilding4_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding4_DESCRIPTOR.
	 * 
	 * @param subBuilding4_DESCRIPTOR
	 *            the subBuilding4_DESCRIPTOR
	 */
	public void setSubBuilding4_DESCRIPTOR(String subBuilding4_DESCRIPTOR) {
		this.subBuilding4_DESCRIPTOR = subBuilding4_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding5_NAME.
	 * 
	 * @return subBuilding5_NAME
	 */
	public String getSubBuilding5_NAME() {
		return subBuilding5_NAME;
	}

	/**
	 * Set the value of column subBuilding5_NAME.
	 * 
	 * @param subBuilding5_NAME
	 *            the subBuilding5_NAME
	 */
	public void setSubBuilding5_NAME(String subBuilding5_NAME) {
		this.subBuilding5_NAME = subBuilding5_NAME;
	}

	/**
	 * Get the value of column subBuilding5_NUMBER.
	 * 
	 * @return subBuilding5_NUMBER
	 */
	public String getSubBuilding5_NUMBER() {
		return subBuilding5_NUMBER;
	}

	/**
	 * Set the value of column subBuilding5_NUMBER.
	 * 
	 * @param subBuilding5_NUMBER
	 *            the subBuilding5_NUMBER
	 */
	public void setSubBuilding5_NUMBER(String subBuilding5_NUMBER) {
		this.subBuilding5_NUMBER = subBuilding5_NUMBER;
	}

	/**
	 * Get the value of column subBuilding5_DESCRIPTOR.
	 * 
	 * @return subBuilding5_DESCRIPTOR
	 */
	public String getSubBuilding5_DESCRIPTOR() {
		return subBuilding5_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding5_DESCRIPTOR.
	 * 
	 * @param subBuilding5_DESCRIPTOR
	 *            the subBuilding5_DESCRIPTOR
	 */
	public void setSubBuilding5_DESCRIPTOR(String subBuilding5_DESCRIPTOR) {
		this.subBuilding5_DESCRIPTOR = subBuilding5_DESCRIPTOR;
	}

	/**
	 * Get the value of column subBuilding6_NAME.
	 * 
	 * @return subBuilding6_NAME
	 */
	public String getSubBuilding6_NAME() {
		return subBuilding6_NAME;
	}

	/**
	 * Set the value of column subBuilding6_NAME.
	 * 
	 * @param subBuilding6_NAME
	 *            the subBuilding6_NAME
	 */
	public void setSubBuilding6_NAME(String subBuilding6_NAME) {
		this.subBuilding6_NAME = subBuilding6_NAME;
	}

	/**
	 * Get the value of column subBuilding6_NUMBER.
	 * 
	 * @return subBuilding6_NUMBER
	 */
	public String getSubBuilding6_NUMBER() {
		return subBuilding6_NUMBER;
	}

	/**
	 * Set the value of column subBuilding6_NUMBER.
	 * 
	 * @param subBuilding6_NUMBER
	 *            the subBuilding6_NUMBER
	 */
	public void setSubBuilding6_NUMBER(String subBuilding6_NUMBER) {
		this.subBuilding6_NUMBER = subBuilding6_NUMBER;
	}

	/**
	 * Get the value of column subBuilding6_DESCRIPTOR.
	 * 
	 * @return subBuilding6_DESCRIPTOR
	 */
	public String getSubBuilding6_DESCRIPTOR() {
		return subBuilding6_DESCRIPTOR;
	}

	/**
	 * Set the value of column subBuilding6_DESCRIPTOR.
	 * 
	 * @param subBuilding6_DESCRIPTOR
	 *            the subBuilding6_DESCRIPTOR
	 */
	public void setSubBuilding6_DESCRIPTOR(String subBuilding6_DESCRIPTOR) {
		this.subBuilding6_DESCRIPTOR = subBuilding6_DESCRIPTOR;
	}

	/**
	 * Get the value of column deliveryService1_DESCRIPTOR.
	 * 
	 * @return deliveryService1_DESCRIPTOR
	 */
	public String getDeliveryService1_DESCRIPTOR() {
		return deliveryService1_DESCRIPTOR;
	}

	/**
	 * Set the value of column deliveryService1_DESCRIPTOR.
	 * 
	 * @param deliveryService1_DESCRIPTOR
	 *            the deliveryService1_DESCRIPTOR
	 */
	public void setDeliveryService1_DESCRIPTOR(String deliveryService1_DESCRIPTOR) {
		this.deliveryService1_DESCRIPTOR = deliveryService1_DESCRIPTOR;
	}

	/**
	 * Get the value of column deliveryService1_NUMBER.
	 * 
	 * @return deliveryService1_NUMBER
	 */
	public String getDeliveryService1_NUMBER() {
		return deliveryService1_NUMBER;
	}

	/**
	 * Set the value of column deliveryService1_NUMBER.
	 * 
	 * @param deliveryService1_NUMBER
	 *            the deliveryService1_NUMBER
	 */
	public void setDeliveryService1_NUMBER(String deliveryService1_NUMBER) {
		this.deliveryService1_NUMBER = deliveryService1_NUMBER;
	}

	/**
	 * Get the value of column deliveryService1_ADD_INFO.
	 * 
	 * @return deliveryService1_ADD_INFO
	 */
	public String getDeliveryService1_ADD_INFO() {
		return deliveryService1_ADD_INFO;
	}

	/**
	 * Set the value of column deliveryService1_ADD_INFO.
	 * 
	 * @param deliveryService1_ADD_INFO
	 *            the deliveryService1_ADD_INFO
	 */
	public void setDeliveryService1_ADD_INFO(String deliveryService1_ADD_INFO) {
		this.deliveryService1_ADD_INFO = deliveryService1_ADD_INFO;
	}

	/**
	 * Get the value of column deliveryService2_DESCRIPTOR.
	 * 
	 * @return deliveryService2_DESCRIPTOR.
	 */
	public String getDeliveryService2_DESCRIPTOR() {
		return deliveryService2_DESCRIPTOR;
	}

	/**
	 * Set the value of column deliveryService2_DESCRIPTOR.
	 * 
	 * @param deliveryService2_DESCRIPTOR
	 *            the deliveryService2_DESCRIPTOR
	 */
	public void setDeliveryService2_DESCRIPTOR(String deliveryService2_DESCRIPTOR) {
		this.deliveryService2_DESCRIPTOR = deliveryService2_DESCRIPTOR;
	}

	/**
	 * Get the value of column deliveryService2_NUMBER.
	 * 
	 * @return deliveryService2_NUMBER
	 */
	public String getDeliveryService2_NUMBER() {
		return deliveryService2_NUMBER;
	}

	/**
	 * Set the value of column deliveryService2_NUMBER.
	 * 
	 * @param deliveryService2_NUMBER
	 *            the deliveryService2_NUMBER
	 */
	public void setDeliveryService2_NUMBER(String deliveryService2_NUMBER) {
		this.deliveryService2_NUMBER = deliveryService2_NUMBER;
	}

	/**
	 * Set the value of column deliveryService2_ADD_INFO.
	 * 
	 * @return deliveryService2_ADD_INFO
	 */
	public String getDeliveryService2_ADD_INFO() {
		return deliveryService2_ADD_INFO;
	}

	/**
	 * Set the value of column deliveryService2_ADD_INFO.
	 * 
	 * @param deliveryService2_ADD_INFO
	 *            the deliveryService2_ADD_INFO
	 */
	public void setDeliveryService2_ADD_INFO(String deliveryService2_ADD_INFO) {
		this.deliveryService2_ADD_INFO = deliveryService2_ADD_INFO;
	}

	/**
	 * Get the value of column deliveryService3_DESCRIPTOR.
	 * 
	 * @return deliveryService3_DESCRIPTOR
	 */
	public String getDeliveryService3_DESCRIPTOR() {
		return deliveryService3_DESCRIPTOR;
	}

	/**
	 * Set the value of column deliveryService3_DESCRIPTOR.
	 * 
	 * @param deliveryService3_DESCRIPTOR
	 *            the deliveryService3_DESCRIPTOR
	 */
	public void setDeliveryService3_DESCRIPTOR(String deliveryService3_DESCRIPTOR) {
		this.deliveryService3_DESCRIPTOR = deliveryService3_DESCRIPTOR;
	}

	/**
	 * Get the value of column deliveryService3_NUMBER.
	 * 
	 * @return deliveryService3_NUMBER
	 */
	public String getDeliveryService3_NUMBER() {
		return deliveryService3_NUMBER;
	}

	/**
	 * Set the value of column deliveryService3_NUMBER.
	 * 
	 * @param deliveryService3_NUMBER
	 *            the deliveryService3_NUMBER
	 */
	public void setDeliveryService3_NUMBER(String deliveryService3_NUMBER) {
		this.deliveryService3_NUMBER = deliveryService3_NUMBER;
	}

	/**
	 * Get the value of column deliveryService3_ADD_INFO.
	 * 
	 * @return deliveryService3_ADD_INFO
	 */
	public String getDeliveryService3_ADD_INFO() {
		return deliveryService3_ADD_INFO;
	}

	/**
	 * Set the value of column deliveryService3_ADD_INFO.
	 * 
	 * @param deliveryService3_ADD_INFO
	 *            the deliveryService3_ADD_INFO
	 */
	public void setDeliveryService3_ADD_INFO(String deliveryService3_ADD_INFO) {
		this.deliveryService3_ADD_INFO = deliveryService3_ADD_INFO;
	}

	/**
	 * Get the value of column organization1_NAME.
	 * 
	 * @return organization1_NAME
	 */
	public String getOrganization1_NAME() {
		return organization1_NAME;
	}

	/**
	 * Set the value of column organization1_NAME.
	 * 
	 * @param organization1_NAME
	 *            the organization1_NAME
	 */
	public void setOrganization1_NAME(String organization1_NAME) {
		this.organization1_NAME = organization1_NAME;
	}

	/**
	 * Get the value of column organization1_DESCRIPTOR.
	 * 
	 * @return organization1_DESCRIPTOR
	 */
	public String getOrganization1_DESCRIPTOR() {
		return organization1_DESCRIPTOR;
	}

	/**
	 * Set the value of column organization1_DESCRIPTOR.
	 * 
	 * @param organization1_DESCRIPTOR
	 *            the organization1_DESCRIPTOR
	 */
	public void setOrganization1_DESCRIPTOR(String organization1_DESCRIPTOR) {
		this.organization1_DESCRIPTOR = organization1_DESCRIPTOR;
	}

	/**
	 * Get the value of column organization1_DEPARTMENT.
	 * 
	 * @return organization1_DEPARTMENT
	 */
	public String getOrganization1_DEPARTMENT() {
		return organization1_DEPARTMENT;
	}

	/**
	 * Set the value of column organization1_DEPARTMENT.
	 * 
	 * @param organization1_DEPARTMENT
	 *            the organization1_DEPARTMENT
	 */
	public void setOrganization1_DEPARTMENT(String organization1_DEPARTMENT) {
		this.organization1_DEPARTMENT = organization1_DEPARTMENT;
	}

	/**
	 * Get the value of column organization2_NAME.
	 * 
	 * @return organization2_NAME
	 */
	public String getOrganization2_NAME() {
		return organization2_NAME;
	}

	/**
	 * Set the value of column organization2_NAME.
	 * 
	 * @param organization2_NAME
	 *            the organization2_NAME
	 */
	public void setOrganization2_NAME(String organization2_NAME) {
		this.organization2_NAME = organization2_NAME;
	}

	/**
	 * Get the value of column organization2_DESCRIPTOR.
	 * 
	 * @return organization2_DESCRIPTOR
	 */
	public String getOrganization2_DESCRIPTOR() {
		return organization2_DESCRIPTOR;
	}

	/**
	 * Set the value of column organization2_DESCRIPTOR.
	 * 
	 * @param organization2_DESCRIPTOR
	 *            the organization2_DESCRIPTOR
	 */
	public void setOrganization2_DESCRIPTOR(String organization2_DESCRIPTOR) {
		this.organization2_DESCRIPTOR = organization2_DESCRIPTOR;
	}

	/**
	 * Get the value of column organization2_DEPARTMENT.
	 * 
	 * @return organization2_DEPARTMENT
	 */
	public String getOrganization2_DEPARTMENT() {
		return organization2_DEPARTMENT;
	}

	/**
	 * Set the value of column organization2_DEPARTMENT.
	 * 
	 * @param organization2_DEPARTMENT
	 *            the organization2_DEPARTMENT
	 */
	public void setOrganization2_DEPARTMENT(String organization2_DEPARTMENT) {
		this.organization2_DEPARTMENT = organization2_DEPARTMENT;
	}

	/**
	 * Get the value of column organization3_NAME.
	 * 
	 * @return organization3_NAME
	 */
	public String getOrganization3_NAME() {
		return organization3_NAME;
	}

	/**
	 * Set the value of column organization3_NAME.
	 * 
	 * @param organization3_NAME
	 *            the organization3_NAME
	 */
	public void setOrganization3_NAME(String organization3_NAME) {
		this.organization3_NAME = organization3_NAME;
	}

	/**
	 * Get the value of column organization3_DESCRIPTOR.
	 * 
	 * @return organization3_DESCRIPTOR
	 */
	public String getOrganization3_DESCRIPTOR() {
		return organization3_DESCRIPTOR;
	}

	/**
	 * Set the value of column organization3_DESCRIPTOR.
	 * 
	 * @param organization3_DESCRIPTOR
	 *            the organization3_DESCRIPTOR
	 */
	public void setOrganization3_DESCRIPTOR(String organization3_DESCRIPTOR) {
		this.organization3_DESCRIPTOR = organization3_DESCRIPTOR;
	}

	/**
	 * Get the value of column organization3_DEPARTMENT.
	 * 
	 * @return organization3_DEPARTMENT.
	 */
	public String getOrganization3_DEPARTMENT() {
		return organization3_DEPARTMENT;
	}

	/**
	 * Set the value of column organization3_DEPARTMENT.
	 * 
	 * @param organization3_DEPARTMENT
	 *            the organization3_DEPARTMENT
	 */
	public void setOrganization3_DEPARTMENT(String organization3_DEPARTMENT) {
		this.organization3_DEPARTMENT = organization3_DEPARTMENT;
	}

	/**
	 * Get the value of column contact1_FIRST_NAME.
	 * 
	 * @return contact1_FIRST_NAME
	 */
	public String getContact1_FIRST_NAME() {
		return contact1_FIRST_NAME;
	}

	/**
	 * Set the value of column contact1_FIRST_NAME.
	 * 
	 * @param contact1_FIRST_NAME
	 *            the contact1_FIRST_NAME
	 */
	public void setContact1_FIRST_NAME(String contact1_FIRST_NAME) {
		this.contact1_FIRST_NAME = contact1_FIRST_NAME;
	}

	/**
	 * Get the value of column contact1_MIDDLE_NAME.
	 * 
	 * @return contact1_MIDDLE_NAME
	 */
	public String getContact1_MIDDLE_NAME() {
		return contact1_MIDDLE_NAME;
	}

	/**
	 * Set the value of column contact1_MIDDLE_NAME.
	 * 
	 * @param contact1_MIDDLE_NAME
	 *            the contact1_MIDDLE_NAME
	 */
	public void setContact1_MIDDLE_NAME(String contact1_MIDDLE_NAME) {
		this.contact1_MIDDLE_NAME = contact1_MIDDLE_NAME;
	}

	/**
	 * Get the value of column contact1_LAST_NAME.
	 * 
	 * @return contact1_LAST_NAME
	 */
	public String getContact1_LAST_NAME() {
		return contact1_LAST_NAME;
	}

	/**
	 * Set the value of column contact1_LAST_NAME.
	 * 
	 * @param contact1_LAST_NAME
	 *            the contact1_LAST_NAME
	 */
	public void setContact1_LAST_NAME(String contact1_LAST_NAME) {
		this.contact1_LAST_NAME = contact1_LAST_NAME;
	}

	/**
	 * Get the value of column contact1_NAME.
	 * 
	 * @return contact1_NAME
	 */
	public String getContact1_NAME() {
		return contact1_NAME;
	}

	/**
	 * Set the value of column contact1_NAME.
	 * 
	 * @param contact1_NAME
	 *            the contact1_NAME
	 */
	public void setContact1_NAME(String contact1_NAME) {
		this.contact1_NAME = contact1_NAME;
	}

	/**
	 * Get the value of column contact1_TITLE.
	 * 
	 * @return contact1_TITLE
	 */
	public String getContact1_TITLE() {
		return contact1_TITLE;
	}

	/**
	 * Set the value of column contact1_TITLE.
	 * 
	 * @param contact1_TITLE
	 *            the contact1_TITLE
	 */
	public void setContact1_TITLE(String contact1_TITLE) {
		this.contact1_TITLE = contact1_TITLE;
	}

	/**
	 * Get the value of column contact1_FUNCTION.
	 * 
	 * @return contact1_FUNCTION
	 */
	public String getContact1_FUNCTION() {
		return contact1_FUNCTION;
	}

	/**
	 * Set the value of column contact1_FUNCTION.
	 * 
	 * @param contact1_FUNCTION
	 *            the contact1_FUNCTION
	 */
	public void setContact1_FUNCTION(String contact1_FUNCTION) {
		this.contact1_FUNCTION = contact1_FUNCTION;
	}

	/**
	 * Get the value of column contact1_SALUTATION.
	 * 
	 * @return contact1_SALUTATION
	 */
	public String getContact1_SALUTATION() {
		return contact1_SALUTATION;
	}

	/**
	 * Set the value of column contact1_SALUTATION.
	 * 
	 * @param contact1_SALUTATION
	 *            the contact1_SALUTATION
	 */
	public void setContact1_SALUTATION(String contact1_SALUTATION) {
		this.contact1_SALUTATION = contact1_SALUTATION;
	}

	/**
	 * Get the value of column contact1_GENDER.
	 * 
	 * @return contact1_GENDER
	 */
	public String getContact1_GENDER() {
		return contact1_GENDER;
	}

	/**
	 * Set the value of column contact1_GENDER.
	 * 
	 * @param contact1_GENDER
	 *            the contact1_GENDER
	 */
	public void setContact1_GENDER(String contact1_GENDER) {
		this.contact1_GENDER = contact1_GENDER;
	}

	/**
	 * Get the value of column contact2_FIRST_NAME.
	 * 
	 * @return contact2_FIRST_NAME
	 */
	public String getContact2_FIRST_NAME() {
		return contact2_FIRST_NAME;
	}

	/**
	 * Set the value of column contact2_FIRST_NAME.
	 * 
	 * @param contact2_FIRST_NAME
	 *            the contact2_FIRST_NAME
	 */
	public void setContact2_FIRST_NAME(String contact2_FIRST_NAME) {
		this.contact2_FIRST_NAME = contact2_FIRST_NAME;
	}

	/**
	 * Get the value of column contact2_MIDDLE_NAME.
	 * 
	 * @return contact2_MIDDLE_NAME
	 */
	public String getContact2_MIDDLE_NAME() {
		return contact2_MIDDLE_NAME;
	}

	/**
	 * Set the value of column contact2_MIDDLE_NAME.
	 * 
	 * @param contact2_MIDDLE_NAME
	 *            the contact2_MIDDLE_NAME
	 */
	public void setContact2_MIDDLE_NAME(String contact2_MIDDLE_NAME) {
		this.contact2_MIDDLE_NAME = contact2_MIDDLE_NAME;
	}

	/**
	 * Get the value of column contact2_LAST_NAME.
	 * 
	 * @return contact2_LAST_NAME
	 */
	public String getContact2_LAST_NAME() {
		return contact2_LAST_NAME;
	}

	/**
	 * Set the value of column contact2_LAST_NAME.
	 * 
	 * @param contact2_LAST_NAME
	 *            the contact2_LAST_NAME
	 */
	public void setContact2_LAST_NAME(String contact2_LAST_NAME) {
		this.contact2_LAST_NAME = contact2_LAST_NAME;
	}

	/**
	 * Get the value of column contact2_NAME.
	 * 
	 * @return contact2_NAME
	 */
	public String getContact2_NAME() {
		return contact2_NAME;
	}

	/**
	 * Set the value of column contact2_NAME.
	 * 
	 * @param contact2_NAME
	 *            the contact2_NAME
	 */
	public void setContact2_NAME(String contact2_NAME) {
		this.contact2_NAME = contact2_NAME;
	}

	/**
	 * Get the value of column contact2_TITLE.
	 * 
	 * @return contact2_TITLE
	 */
	public String getContact2_TITLE() {
		return contact2_TITLE;
	}

	/**
	 * Set the value of column contact2_TITLE.
	 * 
	 * @param contact2_TITLE
	 *            the contact2_TITLE
	 */
	public void setContact2_TITLE(String contact2_TITLE) {
		this.contact2_TITLE = contact2_TITLE;
	}

	/**
	 * Get the value of column contact2_FUNCTION.
	 * 
	 * @return contact2_FUNCTION
	 */
	public String getContact2_FUNCTION() {
		return contact2_FUNCTION;
	}

	/**
	 * Set the value of column contact2_FUNCTION.
	 * 
	 * @param contact2_FUNCTION
	 *            the contact2_FUNCTION
	 */
	public void setContact2_FUNCTION(String contact2_FUNCTION) {
		this.contact2_FUNCTION = contact2_FUNCTION;
	}

	/**
	 * Get the value of column contact2_SALUTATION.
	 * 
	 * @return contact2_SALUTATION
	 */
	public String getContact2_SALUTATION() {
		return contact2_SALUTATION;
	}

	/**
	 * Set the value of column contact2_SALUTATION.
	 * 
	 * @param contact2_SALUTATION
	 *            the contact2_SALUTATION
	 */
	public void setContact2_SALUTATION(String contact2_SALUTATION) {
		this.contact2_SALUTATION = contact2_SALUTATION;
	}

	/**
	 * Get the value of column contact2_GENDER.
	 * 
	 * @return contact2_GENDER
	 */
	public String getContact2_GENDER() {
		return contact2_GENDER;
	}

	/**
	 * Set the value of column contact2_GENDER.
	 * 
	 * @param contact2_GENDER
	 *            the contact2_GENDER
	 */
	public void setContact2_GENDER(String contact2_GENDER) {
		this.contact2_GENDER = contact2_GENDER;
	}

	/**
	 * Get the value of column contact3_FIRST_NAME.
	 * 
	 * @return contact3_FIRST_NAME
	 */
	public String getContact3_FIRST_NAME() {
		return contact3_FIRST_NAME;
	}

	/**
	 * Set the value of column contact3_FIRST_NAME.
	 * 
	 * @param contact3_FIRST_NAME
	 *            the contact3_FIRST_NAME
	 */
	public void setContact3_FIRST_NAME(String contact3_FIRST_NAME) {
		this.contact3_FIRST_NAME = contact3_FIRST_NAME;
	}

	/**
	 * Get the value of column contact3_MIDDLE_NAME.
	 * 
	 * @return contact3_MIDDLE_NAME
	 */
	public String getContact3_MIDDLE_NAME() {
		return contact3_MIDDLE_NAME;
	}

	/**
	 * Set the value of column contact3_MIDDLE_NAME.
	 * 
	 * @param contact3_MIDDLE_NAME
	 *            the contact3_MIDDLE_NAME
	 */
	public void setContact3_MIDDLE_NAME(String contact3_MIDDLE_NAME) {
		this.contact3_MIDDLE_NAME = contact3_MIDDLE_NAME;
	}

	/**
	 * Get the value of column contact3_LAST_NAME.
	 * 
	 * @return contact3_LAST_NAME
	 */
	public String getContact3_LAST_NAME() {
		return contact3_LAST_NAME;
	}

	/**
	 * Set the value of column contact3_LAST_NAME.
	 * 
	 * @param contact3_LAST_NAME
	 *            the contact3_LAST_NAME
	 */
	public void setContact3_LAST_NAME(String contact3_LAST_NAME) {
		this.contact3_LAST_NAME = contact3_LAST_NAME;
	}

	/**
	 * Get the value of column contact3_NAME.
	 * 
	 * @return contact3_NAME
	 */
	public String getContact3_NAME() {
		return contact3_NAME;
	}

	/**
	 * Set the value of column contact3_NAME.
	 * 
	 * @param contact3_NAME
	 *            the contact3_NAME
	 */
	public void setContact3_NAME(String contact3_NAME) {
		this.contact3_NAME = contact3_NAME;
	}

	/**
	 * Get the value of column contact3_TITLE.
	 * 
	 * @return contact3_TITLE
	 */
	public String getContact3_TITLE() {
		return contact3_TITLE;
	}

	/**
	 * Set the value of column contact3_TITLE.
	 * 
	 * @param contact3_TITLE
	 *            the contact3_TITLE
	 */
	public void setContact3_TITLE(String contact3_TITLE) {
		this.contact3_TITLE = contact3_TITLE;
	}

	/**
	 * Get the value of column contact3_FUNCTION.
	 * 
	 * @return contact3_FUNCTION
	 */
	public String getContact3_FUNCTION() {
		return contact3_FUNCTION;
	}

	/**
	 * Set the value of column contact3_FUNCTION.
	 * 
	 * @param contact3_FUNCTION
	 *            the contact3_FUNCTION
	 */
	public void setContact3_FUNCTION(String contact3_FUNCTION) {
		this.contact3_FUNCTION = contact3_FUNCTION;
	}

	/**
	 * Get the value of column contact3_SALUTATION.
	 * 
	 * @return contact3_SALUTATION
	 */
	public String getContact3_SALUTATION() {
		return contact3_SALUTATION;
	}

	/**
	 * Set the value of column contact3_SALUTATION.
	 * 
	 * @param contact3_SALUTATION
	 *            the contact3_SALUTATION
	 */
	public void setContact3_SALUTATION(String contact3_SALUTATION) {
		this.contact3_SALUTATION = contact3_SALUTATION;
	}

	/**
	 * Get the value of column contact3_GENDER.
	 * 
	 * @return contact3_GENDER
	 */
	public String getContact3_GENDER() {
		return contact3_GENDER;
	}

	/**
	 * Set the value of column contact3_GENDER.
	 * 
	 * @param contact3_GENDER
	 *            the contact3_GENDER
	 */
	public void setContact3_GENDER(String contact3_GENDER) {
		this.contact3_GENDER = contact3_GENDER;
	}

	/**
	 * Get the value of column residue1_NECESSARY.
	 * 
	 * @return residue1_NECESSARY
	 */
	public String getResidue1_NECESSARY() {
		return residue1_NECESSARY;
	}

	/**
	 * Set the value of column residue1_NECESSARY.
	 * 
	 * @param residue1_NECESSARY
	 *            the residue1_NECESSARY
	 */
	public void setResidue1_NECESSARY(String residue1_NECESSARY) {
		this.residue1_NECESSARY = residue1_NECESSARY;
	}

	/**
	 * Get the value of column residue1_SUPERFLUOUS.
	 * 
	 * @return residue1_SUPERFLUOUS
	 */
	public String getResidue1_SUPERFLUOUS() {
		return residue1_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue1_SUPERFLUOUS.
	 * 
	 * @param residue1_SUPERFLUOUS
	 *            the residue1_SUPERFLUOUS
	 */
	public void setResidue1_SUPERFLUOUS(String residue1_SUPERFLUOUS) {
		this.residue1_SUPERFLUOUS = residue1_SUPERFLUOUS;
	}

	/**
	 * Get the value of column residue2_NECESSARY.
	 * 
	 * @return residue2_NECESSARY
	 */
	public String getResidue2_NECESSARY() {
		return residue2_NECESSARY;
	}

	/**
	 * Set the value of column residue2_NECESSARY.
	 * 
	 * @param residue2_NECESSARY
	 *            the residue2_NECESSARY
	 */
	public void setResidue2_NECESSARY(String residue2_NECESSARY) {
		this.residue2_NECESSARY = residue2_NECESSARY;
	}

	/**
	 * Get the value of column residue2_SUPERFLUOUS.
	 * 
	 * @return residue2_SUPERFLUOUS
	 */
	public String getResidue2_SUPERFLUOUS() {
		return residue2_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue2_SUPERFLUOUS.
	 * 
	 * @param residue2_SUPERFLUOUS
	 *            the residue2_SUPERFLUOUS
	 */
	public void setResidue2_SUPERFLUOUS(String residue2_SUPERFLUOUS) {
		this.residue2_SUPERFLUOUS = residue2_SUPERFLUOUS;
	}

	/**
	 * Get the value of column residue3_NECESSARY.
	 * 
	 * @return residue3_NECESSARY
	 */
	public String getResidue3_NECESSARY() {
		return residue3_NECESSARY;
	}

	/**
	 * Set the value of column residue3_NECESSARY.
	 * 
	 * @param residue3_NECESSARY
	 *            the residue3_NECESSARY
	 */
	public void setResidue3_NECESSARY(String residue3_NECESSARY) {
		this.residue3_NECESSARY = residue3_NECESSARY;
	}

	/**
	 * Get the value of column residue3_SUPERFLUOUS.
	 * 
	 * @return residue3_SUPERFLUOUS
	 */
	public String getResidue3_SUPERFLUOUS() {
		return residue3_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue3_SUPERFLUOUS.
	 * 
	 * @param residue3_SUPERFLUOUS
	 *            the residue3_SUPERFLUOUS
	 */
	public void setResidue3_SUPERFLUOUS(String residue3_SUPERFLUOUS) {
		this.residue3_SUPERFLUOUS = residue3_SUPERFLUOUS;
	}

	/**
	 * Get the value of column residue4_NECESSARY.
	 * 
	 * @return residue4_NECESSARY
	 */
	public String getResidue4_NECESSARY() {
		return residue4_NECESSARY;
	}

	/**
	 * Set the value of column residue4_NECESSARY.
	 * 
	 * @param residue4_NECESSARY
	 *            the residue4_NECESSARY
	 */
	public void setResidue4_NECESSARY(String residue4_NECESSARY) {
		this.residue4_NECESSARY = residue4_NECESSARY;
	}

	/**
	 * Get the value of column residue4_SUPERFLUOUS.
	 * 
	 * @return residue4_SUPERFLUOUS
	 */
	public String getResidue4_SUPERFLUOUS() {
		return residue4_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue4_SUPERFLUOUS.
	 * 
	 * @param residue4_SUPERFLUOUS
	 *            the residue4_SUPERFLUOUS
	 */
	public void setResidue4_SUPERFLUOUS(String residue4_SUPERFLUOUS) {
		this.residue4_SUPERFLUOUS = residue4_SUPERFLUOUS;
	}

	/**
	 * Get the value of column residue5_NECESSARY.
	 * 
	 * @return residue5_NECESSARY
	 */
	public String getResidue5_NECESSARY() {
		return residue5_NECESSARY;
	}

	/**
	 * Set the value of column residue5_NECESSARY.
	 * 
	 * @param residue5_NECESSARY
	 *            the residue5_NECESSARY
	 */
	public void setResidue5_NECESSARY(String residue5_NECESSARY) {
		this.residue5_NECESSARY = residue5_NECESSARY;
	}

	/**
	 * Get the value of column residue5_SUPERFLUOUS.
	 * 
	 * @return residue5_SUPERFLUOUS
	 */
	public String getResidue5_SUPERFLUOUS() {
		return residue5_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue5_SUPERFLUOUS.
	 * 
	 * @param residue5_SUPERFLUOUS
	 *            the residue5_SUPERFLUOUS
	 */
	public void setResidue5_SUPERFLUOUS(String residue5_SUPERFLUOUS) {
		this.residue5_SUPERFLUOUS = residue5_SUPERFLUOUS;
	}

	/**
	 * Get the value of column residue6_NECESSARY.
	 * 
	 * @return residue6_NECESSARY
	 */
	public String getResidue6_NECESSARY() {
		return residue6_NECESSARY;
	}

	/**
	 * Set the value of column residue6_NECESSARY.
	 * 
	 * @param residue6_NECESSARY
	 *            the residue6_NECESSARY
	 */
	public void setResidue6_NECESSARY(String residue6_NECESSARY) {
		this.residue6_NECESSARY = residue6_NECESSARY;
	}

	/**
	 * Get the value of column residue6_SUPERFLUOUS.
	 * 
	 * @return residue6_SUPERFLUOUS
	 */
	public String getResidue6_SUPERFLUOUS() {
		return residue6_SUPERFLUOUS;
	}

	/**
	 * Set the value of column residue6_SUPERFLUOUS.
	 * 
	 * @param residue6_SUPERFLUOUS
	 *            the residue6_SUPERFLUOUS
	 */
	public void setResidue6_SUPERFLUOUS(String residue6_SUPERFLUOUS) {
		this.residue6_SUPERFLUOUS = residue6_SUPERFLUOUS;
	}

	/**
	 * Set the value of the field that with the same suffix.
	 * 
	 * @param prefix
	 *            the prefix of the field
	 * @param outputRecord
	 *            the object of the field
	 * @param list
	 *            List<AddressElement>
	 * @param type
	 *            the suffix of the field
	 */
	public void setMethodWithSameSuffix(String prefix, OutputRecord outputRecord, List<AddressElement> list, String type) {
		if (!StringUtils.isNotEmpty(type)) {
			return;
		}

		int num = 1;
		for (AddressElement element : list) {
			if (type.equals(element.getType())) {
				StringBuffer methodName = new StringBuffer("set");
				methodName.append(prefix).append(num).append("_").append(type);
				setMethodValue(outputRecord, element.getValue(), methodName.toString());
				num++;
			}
		}
	}

	/**
	 * Set the value of the field that with different line number.
	 * 
	 * @param prefix
	 *            the prefix of the field
	 * @param outputRecord
	 *            the object of the field
	 * @param list
	 *            List<String>, the value of the field
	 */
	public void setMethodWithDiffLine(String prefix, OutputRecord outputRecord, List<String> list) {
		int num = 1;
		for (String element : list) {
			StringBuffer methodName = new StringBuffer("set");
			methodName.append(prefix).append("_").append(num);
			setMethodValue(outputRecord, element, methodName.toString());
			num++;
		}
	}

	/**
	 * Set the value of the field of object OutputRecord.
	 * 
	 * @param outputRecord
	 *            the object
	 * @param value
	 *            the value of the field
	 * @param methodName
	 *            the setter of the OutputRecord object
	 */
	public void setMethodValue(OutputRecord outputRecord, String value, String methodName) {
		Class<? extends OutputRecord> clazz = outputRecord.getClass();
		Method method;
		try {
			method = clazz.getMethod(methodName, String.class);
			method.invoke(outputRecord, value);
		} catch (SecurityException e) {
			logger.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Get the value of the field of an OutputRecord object.
	 * 
	 * @param outputRecord
	 *            the object
	 * @param fieldName
	 *            the name of the field
	 * @return String the value of the field
	 */
	public String getMethodValue(OutputRecord outputRecord, String fieldName) {
		Class<? extends OutputRecord> clazz = outputRecord.getClass();
		Method method;
		String value = "";
		try {
			String methodName = "get" + StringUtils.capitalize(fieldName);
			method = clazz.getMethod(methodName);
			value = (String) method.invoke(outputRecord);
		} catch (SecurityException e) {
			logger.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage());
		}
		return value;
	}

}
