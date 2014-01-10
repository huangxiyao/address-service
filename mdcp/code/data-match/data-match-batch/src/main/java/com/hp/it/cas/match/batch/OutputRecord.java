package com.hp.it.cas.match.batch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.hp.it.cas.match.address.AddressElement;

public class OutputRecord extends AddressInput {

	public String errorMessage;
	public String key1_RECORD_ID;
	public String key2_RECORD_ID;
	public String key3_RECORD_ID;
	public String key1_TRANSACTION_KEY;
	public String key2_TRANSACTION_KEY;
	public String key3_TRANSACTION_KEY;
	public String ResultNumber;
	public String country_ISO3;
	public String mode_Used;
	public String preferred_Language;
	public String preferred_Script;
	public String processStatus;
	public String countOverFlow;
	public String elementInputStatus;
	public String elementResultStatus;
	public String elementRelevance;
	public String mailabilityScore;
	public String resultPercentage;
	public String cassStatus;
	public String serpStatus;
	public String snaStatus;
	public String supplementaryGBStatus;
	public String supplementaryUSStatus;
	public String country1_NAME_EN;
	public String locality1_COMPLETE;
	public String locality2_COMPLETE;
	public String locality3_COMPLETE;
	public String locality4_COMPLETE;
	public String locality5_COMPLETE;
	public String locality6_COMPLETE;
	public String postalCode1_FORMATTED;
	public String postalCode2_FORMATTED;
	public String postalCode3_FORMATTED;
	public String province1_COUNTRY_STANDARD;
	public String province2_COUNTRY_STANDARD;
	public String province3_COUNTRY_STANDARD;
	public String province4_COUNTRY_STANDARD;
	public String province5_COUNTRY_STANDARD;
	public String province6_COUNTRY_STANDARD;
	public String street1_COMPLETE;
	public String street2_COMPLETE;
	public String street3_COMPLETE;
	public String street4_COMPLETE;
	public String street5_COMPLETE;
	public String street6_COMPLETE;
	public String number1_COMPLETE;
	public String number2_COMPLETE;
	public String number3_COMPLETE;
	public String number4_COMPLETE;
	public String number5_COMPLETE;
	public String number6_COMPLETE;
	public String building1_COMPLETE;
	public String building2_COMPLETE;
	public String building3_COMPLETE;
	public String building4_COMPLETE;
	public String building5_COMPLETE;
	public String building6_COMPLETE;
	public String subBuilding1_COMPLETE;
	public String subBuilding2_COMPLETE;
	public String subBuilding3_COMPLETE;
	public String subBuilding4_COMPLETE;
	public String subBuilding5_COMPLETE;
	public String subBuilding6_COMPLETE;
	public String deliverService1_COMPLETE;
	public String deliverService2_COMPLETE;
	public String deliverService3_COMPLETE;
	public String deliverService4_COMPLETE;
	public String deliverService5_COMPLETE;
	public String deliverService6_COMPLETE;
	public String organization1_COMPLETE;
	public String organization2_COMPLETE;
	public String organization3_COMPLETE;
	public String contact1_COMPLETE;
	public String contact2_COMPLETE;
	public String contact3_COMPLETE;
	public String residue1_UNRECOGNIZED;
	public String residue2_UNRECOGNIZED;
	public String residue3_UNRECOGNIZED;
	public String residue4_UNRECOGNIZED;
	public String residue5_UNRECOGNIZED;
	public String residue6_UNRECOGNIZED;
	public String recipientLine_1;
	public String recipientLine_2;
	public String recipientLine_3;
	public String deliveryAddressLine_1;
	public String deliveryAddressLine_2;
	public String deliveryAddressLine_3;
	public String deliveryAddressLine_4;
	public String deliveryAddressLine_5;
	public String deliveryAddressLine_6;
	public String countrySpecificLocalityLine_1;
	public String countrySpecificLocalityLine_2;
	public String countrySpecificLocalityLine_3;
	public String countrySpecificLocalityLine_4;
	public String countrySpecificLocalityLine_5;
	public String countrySpecificLocalityLine_6;
	public String formattedAddressLine_1;
	public String formattedAddressLine_2;
	public String formattedAddressLine_3;
	public String formattedAddressLine_4;
	public String formattedAddressLine_5;
	public String formattedAddressLine_6;
	public String formattedAddressLine_7;
	public String formattedAddressLine_8;
	public String formattedAddressLine_9;
	public String formattedAddressLine_10;
	public String formattedAddressLine_11;
	public String formattedAddressLine_12;
	public String formattedAddressLine_13;
	public String formattedAddressLine_14;
	public String formattedAddressLine_15;
	public String formattedAddressLine_16;
	public String formattedAddressLine_17;
	public String formattedAddressLine_18;
	public String formattedAddressLine_19;
	public String completeAddress;
	public String country1_ABBREVIATION;
	public String country1_ISO2;
	public String country1_ISO3;
	public String country1_ISO_NUMBER;
	public String country1_NAME_CN;
	public String country1_NAME_DA;
	public String country1_NAME_DE;
	public String country1_NAME_ES;
	public String country1_NAME_FI;
	public String country1_NAME_FR;
	public String country1_NAME_GR;
	public String country1_NAME_HU;
	public String country1_NAME_IT;
	public String country1_NAME_JP;
	public String country1_NAME_KR;
	public String country1_NAME_NL;
	public String country1_NAME_PL;
	public String country1_NAME_PT;
	public String country1_NAME_RU;
	public String country1_NAME_SA;
	public String country1_NAME_SE;
	public String country2_ABBREVIATION;
	public String country2_ISO2;
	public String country2_ISO3;
	public String country2_ISO_NUMBER;
	public String country2_NAME_CN;
	public String country2_NAME_DA;
	public String country2_NAME_DE;
	public String country2_NAME_ES;
	public String country2_NAME_FI;
	public String country2_NAME_FR;
	public String country2_NAME_GR;
	public String country2_NAME_HU;
	public String country2_NAME_IT;
	public String country2_NAME_JP;
	public String country2_NAME_KR;
	public String country2_NAME_NL;
	public String country2_NAME_PL;
	public String country2_NAME_PT;
	public String country2_NAME_RU;
	public String country2_NAME_SA;
	public String country2_NAME_SE;
	public String country3_ABBREVIATION;
	public String country3_ISO2;
	public String country3_ISO3;
	public String country3_ISO_NUMBER;
	public String country3_NAME_CN;
	public String country3_NAME_DA;
	public String country3_NAME_DE;
	public String country3_NAME_ES;
	public String country3_NAME_FI;
	public String country3_NAME_FR;
	public String country3_NAME_GR;
	public String country3_NAME_HU;
	public String country3_NAME_IT;
	public String country3_NAME_JP;
	public String country3_NAME_KR;
	public String country3_NAME_NL;
	public String country3_NAME_PL;
	public String country3_NAME_PT;
	public String country3_NAME_RU;
	public String country3_NAME_SA;
	public String country3_NAME_SE;
	public String locality1_NAME;
	public String locality1_PREFERRED_NAME;
	public String locality1_SORTING_CODE;
	public String locality1_ADD_INFO;
	public String locality2_NAME;
	public String locality2_PREFERRED_NAME;
	public String locality2_SORTING_CODE;
	public String locality2_ADD_INFO;
	public String locality3_NAME;
	public String locality3_PREFERRED_NAME;
	public String locality3_SORTING_CODE;
	public String locality3_ADD_INFO;
	public String locality4_NAME;
	public String locality4_PREFERRED_NAME;
	public String locality4_SORTING_CODE;
	public String locality4_ADD_INFO;
	public String locality5_NAME;
	public String locality5_PREFERRED_NAME;
	public String locality5_SORTING_CODE;
	public String locality5_ADD_INFO;
	public String locality6_NAME;
	public String locality6_PREFERRED_NAME;
	public String locality6_SORTING_CODE;
	public String locality6_ADD_INFO;
	public String postalCode1_UNFORMATTED;
	public String postalCode1_BASE;
	public String postalCode1_ADD_ON;
	public String postalCode2_UNFORMATTED;
	public String postalCode2_BASE;
	public String postalCode2_ADD_ON;
	public String postalCode3_UNFORMATTED;
	public String postalCode3_BASE;
	public String postalCode3_ADD_ON;
	public String province1_ABBREVIATION;
	public String province1_EXTENDED;
	public String province1_ISO;
	public String province2_ABBREVIATION;
	public String province2_EXTENDED;
	public String province2_ISO;
	public String province3_ABBREVIATION;
	public String province3_EXTENDED;
	public String province3_ISO;
	public String province4_ABBREVIATION;
	public String province4_EXTENDED;
	public String province4_ISO;
	public String province5_ABBREVIATION;
	public String province5_EXTENDED;
	public String province5_ISO;
	public String province6_ABBREVIATION;
	public String province6_EXTENDED;
	public String province6_ISO;
	public String street1_COMPLETE_WITH_NUMBER;
	public String street1_NAME;
	public String street1_PRE_DESCRIPTOR;
	public String street1_POST_DESCRIPTOR;
	public String street1_PRE_DIRECTIONAL;
	public String street1_POST_DIRECTIONAL;
	public String street1_ADD_INFO;
	public String street2_COMPLETE_WITH_NUMBER;
	public String street2_NAME;
	public String street2_PRE_DESCRIPTOR;
	public String street2_POST_DESCRIPTOR;
	public String street2_PRE_DIRECTIONAL;
	public String street2_POST_DIRECTIONAL;
	public String street2_ADD_INFO;
	public String street3_COMPLETE_WITH_NUMBER;
	public String street3_NAME;
	public String street3_PRE_DESCRIPTOR;
	public String street3_POST_DESCRIPTOR;
	public String street3_PRE_DIRECTIONAL;
	public String street3_POST_DIRECTIONAL;
	public String street3_ADD_INFO;
	public String street4_COMPLETE_WITH_NUMBER;
	public String street4_NAME;
	public String street4_PRE_DESCRIPTOR;
	public String street4_POST_DESCRIPTOR;
	public String street4_PRE_DIRECTIONAL;
	public String street4_POST_DIRECTIONAL;
	public String street4_ADD_INFO;
	public String street5_COMPLETE_WITH_NUMBER;
	public String street5_NAME;
	public String street5_PRE_DESCRIPTOR;
	public String street5_POST_DESCRIPTOR;
	public String street5_PRE_DIRECTIONAL;
	public String street5_POST_DIRECTIONAL;
	public String street5_ADD_INFO;
	public String street6_COMPLETE_WITH_NUMBER;
	public String street6_NAME;
	public String street6_PRE_DESCRIPTOR;
	public String street6_POST_DESCRIPTOR;
	public String street6_PRE_DIRECTIONAL;
	public String street6_POST_DIRECTIONAL;
	public String street6_ADD_INFO;
	public String number1_NUMBER;
	public String number1_DESCRIPTOR;
	public String number1_ADD_INFO;
	public String number2_NUMBER;
	public String number2_DESCRIPTOR;
	public String number2_ADD_INFO;
	public String number3_NUMBER;
	public String number3_DESCRIPTOR;
	public String number3_ADD_INFO;
	public String number4_NUMBER;
	public String number4_DESCRIPTOR;
	public String number4_ADD_INFO;
	public String number5_NUMBER;
	public String number5_DESCRIPTOR;
	public String number5_ADD_INFO;
	public String number6_NUMBER;
	public String number6_DESCRIPTOR;
	public String number6_ADD_INFO;
	public String building1_COMPLETE_WITH_SUBBUILDING;
	public String building1_NAME;
	public String building1_NUMBER;
	public String building1_DESCRIPTOR;
	public String building2_COMPLETE_WITH_SUBBUILDING;
	public String building2_NAME;
	public String building2_NUMBER;
	public String building2_DESCRIPTOR;
	public String building3_COMPLETE_WITH_SUBBUILDING;
	public String building3_NAME;
	public String building3_NUMBER;
	public String building3_DESCRIPTOR;
	public String building4_COMPLETE_WITH_SUBBUILDING;
	public String building4_NAME;
	public String building4_NUMBER;
	public String building4_DESCRIPTOR;
	public String building5_COMPLETE_WITH_SUBBUILDING;
	public String building5_NAME;
	public String building5_NUMBER;
	public String building5_DESCRIPTOR;
	public String building6_COMPLETE_WITH_SUBBUILDING;
	public String building6_NAME;
	public String building6_NUMBER;
	public String building6_DESCRIPTOR;
	public String subBuilding1_NAME;
	public String subBuilding1_NUMBER;
	public String subBuilding1_DESCRIPTOR;
	public String subBuilding2_NAME;
	public String subBuilding2_NUMBER;
	public String subBuilding2_DESCRIPTOR;
	public String subBuilding3_NAME;
	public String subBuilding3_NUMBER;
	public String subBuilding3_DESCRIPTOR;
	public String subBuilding4_NAME;
	public String subBuilding4_NUMBER;
	public String subBuilding4_DESCRIPTOR;
	public String subBuilding5_NAME;
	public String subBuilding5_NUMBER;
	public String subBuilding5_DESCRIPTOR;
	public String subBuilding6_NAME;
	public String subBuilding6_NUMBER;
	public String subBuilding6_DESCRIPTOR;
	public String deliveryService1_DESCRIPTOR;
	public String deliveryService1_NUMBER;
	public String deliveryService1_ADD_INFO;
	public String deliveryService2_DESCRIPTOR;
	public String deliveryService2_NUMBER;
	public String deliveryService2_ADD_INFO;
	public String deliveryService3_DESCRIPTOR;
	public String deliveryService3_NUMBER;
	public String deliveryService3_ADD_INFO;
	public String organization1_NAME;
	public String organization1_DESCRIPTOR;
	public String organization1_DEPARTMENT;
	public String organization2_NAME;
	public String organization2_DESCRIPTOR;
	public String organization2_DEPARTMENT;
	public String organization3_NAME;
	public String organization3_DESCRIPTOR;
	public String organization3_DEPARTMENT;
	public String contact1_FIRST_NAME;
	public String contact1_MIDDLE_NAME;
	public String contact1_LAST_NAME;
	public String contact1_NAME;
	public String contact1_TITLE;
	public String contact1_FUNCTION;
	public String contact1_SALUTATION;
	public String contact1_GENDER;
	public String contact2_FIRST_NAME;
	public String contact2_MIDDLE_NAME;
	public String contact2_LAST_NAME;
	public String contact2_NAME;
	public String contact2_TITLE;
	public String contact2_FUNCTION;
	public String contact2_SALUTATION;
	public String contact2_GENDER;
	public String contact3_FIRST_NAME;
	public String contact3_MIDDLE_NAME;
	public String contact3_LAST_NAME;
	public String contact3_NAME;
	public String contact3_TITLE;
	public String contact3_FUNCTION;
	public String contact3_SALUTATION;
	public String contact3_GENDER;
	public String residue1_NECESSARY;
	public String residue1_SUPERFLUOUS;
	public String residue2_NECESSARY;
	public String residue2_SUPERFLUOUS;
	public String residue3_NECESSARY;
	public String residue3_SUPERFLUOUS;
	public String residue4_NECESSARY;
	public String residue4_SUPERFLUOUS;
	public String residue5_NECESSARY;
	public String residue5_SUPERFLUOUS;
	public String residue6_NECESSARY;
	public String residue6_SUPERFLUOUS;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getKey1_RECORD_ID() {
		return key1_RECORD_ID;
	}

	public void setKey1_RECORD_ID(String key1_RECORD_ID) {
		this.key1_RECORD_ID = key1_RECORD_ID;
	}

	public String getKey2_RECORD_ID() {
		return key2_RECORD_ID;
	}

	public void setKey2_RECORD_ID(String key2_RECORD_ID) {
		this.key2_RECORD_ID = key2_RECORD_ID;
	}

	public String getKey3_RECORD_ID() {
		return key3_RECORD_ID;
	}

	public void setKey3_RECORD_ID(String key3_RECORD_ID) {
		this.key3_RECORD_ID = key3_RECORD_ID;
	}

	public String getKey1_TRANSACTION_KEY() {
		return key1_TRANSACTION_KEY;
	}

	public void setKey1_TRANSACTION_KEY(String key1_TRANSACTION_KEY) {
		this.key1_TRANSACTION_KEY = key1_TRANSACTION_KEY;
	}

	public String getKey2_TRANSACTION_KEY() {
		return key2_TRANSACTION_KEY;
	}

	public void setKey2_TRANSACTION_KEY(String key2_TRANSACTION_KEY) {
		this.key2_TRANSACTION_KEY = key2_TRANSACTION_KEY;
	}

	public String getKey3_TRANSACTION_KEY() {
		return key3_TRANSACTION_KEY;
	}

	public void setKey3_TRANSACTION_KEY(String key3_TRANSACTION_KEY) {
		this.key3_TRANSACTION_KEY = key3_TRANSACTION_KEY;
	}

	public String getResultNumber() {
		return ResultNumber;
	}

	public void setResultNumber(String resultNumber) {
		ResultNumber = resultNumber;
	}

	public String getCountry_ISO3() {
		return country_ISO3;
	}

	public void setCountry_ISO3(String country_ISO3) {
		this.country_ISO3 = country_ISO3;
	}

	public String getMode_Used() {
		return mode_Used;
	}

	public void setMode_Used(String mode_Used) {
		this.mode_Used = mode_Used;
	}

	public String getPreferred_Language() {
		return preferred_Language;
	}

	public void setPreferred_Language(String preferred_Language) {
		this.preferred_Language = preferred_Language;
	}

	public String getPreferred_Script() {
		return preferred_Script;
	}

	public void setPreferred_Script(String preferred_Script) {
		this.preferred_Script = preferred_Script;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getCountOverFlow() {
		return countOverFlow;
	}

	public void setCountOverFlow(String countOverFlow) {
		this.countOverFlow = countOverFlow;
	}

	public String getElementInputStatus() {
		return elementInputStatus;
	}

	public void setElementInputStatus(String elementInputStatus) {
		this.elementInputStatus = elementInputStatus;
	}

	public String getElementResultStatus() {
		return elementResultStatus;
	}

	public void setElementResultStatus(String elementResultStatus) {
		this.elementResultStatus = elementResultStatus;
	}

	public String getElementRelevance() {
		return elementRelevance;
	}

	public void setElementRelevance(String elementRelevance) {
		this.elementRelevance = elementRelevance;
	}

	public String getMailabilityScore() {
		return mailabilityScore;
	}

	public void setMailabilityScore(String mailabilityScore) {
		this.mailabilityScore = mailabilityScore;
	}

	public String getResultPercentage() {
		return resultPercentage;
	}

	public void setResultPercentage(String resultPercentage) {
		this.resultPercentage = resultPercentage;
	}

	public String getCassStatus() {
		return cassStatus;
	}

	public void setCassStatus(String cassStatus) {
		this.cassStatus = cassStatus;
	}

	public String getSerpStatus() {
		return serpStatus;
	}

	public void setSerpStatus(String serpStatus) {
		this.serpStatus = serpStatus;
	}

	public String getSnaStatus() {
		return snaStatus;
	}

	public void setSnaStatus(String snaStatus) {
		this.snaStatus = snaStatus;
	}

	public String getSupplementaryGBStatus() {
		return supplementaryGBStatus;
	}

	public void setSupplementaryGBStatus(String supplementaryGBStatus) {
		this.supplementaryGBStatus = supplementaryGBStatus;
	}

	public String getSupplementaryUSStatus() {
		return supplementaryUSStatus;
	}

	public void setSupplementaryUSStatus(String supplementaryUSStatus) {
		this.supplementaryUSStatus = supplementaryUSStatus;
	}

	public String getCountry1_NAME_EN() {
		return country1_NAME_EN;
	}

	public void setCountry1_NAME_EN(String country1_NAME_EN) {
		this.country1_NAME_EN = country1_NAME_EN;
	}

	public String getLocality1_COMPLETE() {
		return locality1_COMPLETE;
	}

	public void setLocality1_COMPLETE(String locality1_COMPLETE) {
		this.locality1_COMPLETE = locality1_COMPLETE;
	}

	public String getLocality2_COMPLETE() {
		return locality2_COMPLETE;
	}

	public void setLocality2_COMPLETE(String locality2_COMPLETE) {
		this.locality2_COMPLETE = locality2_COMPLETE;
	}

	public String getLocality3_COMPLETE() {
		return locality3_COMPLETE;
	}

	public void setLocality3_COMPLETE(String locality3_COMPLETE) {
		this.locality3_COMPLETE = locality3_COMPLETE;
	}

	public String getLocality4_COMPLETE() {
		return locality4_COMPLETE;
	}

	public void setLocality4_COMPLETE(String locality4_COMPLETE) {
		this.locality4_COMPLETE = locality4_COMPLETE;
	}

	public String getLocality5_COMPLETE() {
		return locality5_COMPLETE;
	}

	public void setLocality5_COMPLETE(String locality5_COMPLETE) {
		this.locality5_COMPLETE = locality5_COMPLETE;
	}

	public String getLocality6_COMPLETE() {
		return locality6_COMPLETE;
	}

	public void setLocality6_COMPLETE(String locality6_COMPLETE) {
		this.locality6_COMPLETE = locality6_COMPLETE;
	}

	public String getPostalCode1_FORMATTED() {
		return postalCode1_FORMATTED;
	}

	public void setPostalCode1_FORMATTED(String postalCode1_FORMATTED) {
		this.postalCode1_FORMATTED = postalCode1_FORMATTED;
	}

	public String getPostalCode2_FORMATTED() {
		return postalCode2_FORMATTED;
	}

	public void setPostalCode2_FORMATTED(String postalCode2_FORMATTED) {
		this.postalCode2_FORMATTED = postalCode2_FORMATTED;
	}

	public String getPostalCode3_FORMATTED() {
		return postalCode3_FORMATTED;
	}

	public void setPostalCode3_FORMATTED(String postalCode3_FORMATTED) {
		this.postalCode3_FORMATTED = postalCode3_FORMATTED;
	}

	public String getProvince1_COUNTRY_STANDARD() {
		return province1_COUNTRY_STANDARD;
	}

	public void setProvince1_COUNTRY_STANDARD(String province1_COUNTRY_STANDARD) {
		this.province1_COUNTRY_STANDARD = province1_COUNTRY_STANDARD;
	}

	public String getProvince2_COUNTRY_STANDARD() {
		return province2_COUNTRY_STANDARD;
	}

	public void setProvince2_COUNTRY_STANDARD(String province2_COUNTRY_STANDARD) {
		this.province2_COUNTRY_STANDARD = province2_COUNTRY_STANDARD;
	}

	public String getProvince3_COUNTRY_STANDARD() {
		return province3_COUNTRY_STANDARD;
	}

	public void setProvince3_COUNTRY_STANDARD(String province3_COUNTRY_STANDARD) {
		this.province3_COUNTRY_STANDARD = province3_COUNTRY_STANDARD;
	}

	public String getProvince4_COUNTRY_STANDARD() {
		return province4_COUNTRY_STANDARD;
	}

	public void setProvince4_COUNTRY_STANDARD(String province4_COUNTRY_STANDARD) {
		this.province4_COUNTRY_STANDARD = province4_COUNTRY_STANDARD;
	}

	public String getProvince5_COUNTRY_STANDARD() {
		return province5_COUNTRY_STANDARD;
	}

	public void setProvince5_COUNTRY_STANDARD(String province5_COUNTRY_STANDARD) {
		this.province5_COUNTRY_STANDARD = province5_COUNTRY_STANDARD;
	}

	public String getProvince6_COUNTRY_STANDARD() {
		return province6_COUNTRY_STANDARD;
	}

	public void setProvince6_COUNTRY_STANDARD(String province6_COUNTRY_STANDARD) {
		this.province6_COUNTRY_STANDARD = province6_COUNTRY_STANDARD;
	}

	public String getStreet1_COMPLETE() {
		return street1_COMPLETE;
	}

	public void setStreet1_COMPLETE(String street1_COMPLETE) {
		this.street1_COMPLETE = street1_COMPLETE;
	}

	public String getStreet2_COMPLETE() {
		return street2_COMPLETE;
	}

	public void setStreet2_COMPLETE(String street2_COMPLETE) {
		this.street2_COMPLETE = street2_COMPLETE;
	}

	public String getStreet3_COMPLETE() {
		return street3_COMPLETE;
	}

	public void setStreet3_COMPLETE(String street3_COMPLETE) {
		this.street3_COMPLETE = street3_COMPLETE;
	}

	public String getStreet4_COMPLETE() {
		return street4_COMPLETE;
	}

	public void setStreet4_COMPLETE(String street4_COMPLETE) {
		this.street4_COMPLETE = street4_COMPLETE;
	}

	public String getStreet5_COMPLETE() {
		return street5_COMPLETE;
	}

	public void setStreet5_COMPLETE(String street5_COMPLETE) {
		this.street5_COMPLETE = street5_COMPLETE;
	}

	public String getStreet6_COMPLETE() {
		return street6_COMPLETE;
	}

	public void setStreet6_COMPLETE(String street6_COMPLETE) {
		this.street6_COMPLETE = street6_COMPLETE;
	}

	public String getNumber1_COMPLETE() {
		return number1_COMPLETE;
	}

	public void setNumber1_COMPLETE(String number1_COMPLETE) {
		this.number1_COMPLETE = number1_COMPLETE;
	}

	public String getNumber2_COMPLETE() {
		return number2_COMPLETE;
	}

	public void setNumber2_COMPLETE(String number2_COMPLETE) {
		this.number2_COMPLETE = number2_COMPLETE;
	}

	public String getNumber3_COMPLETE() {
		return number3_COMPLETE;
	}

	public void setNumber3_COMPLETE(String number3_COMPLETE) {
		this.number3_COMPLETE = number3_COMPLETE;
	}

	public String getNumber4_COMPLETE() {
		return number4_COMPLETE;
	}

	public void setNumber4_COMPLETE(String number4_COMPLETE) {
		this.number4_COMPLETE = number4_COMPLETE;
	}

	public String getNumber5_COMPLETE() {
		return number5_COMPLETE;
	}

	public void setNumber5_COMPLETE(String number5_COMPLETE) {
		this.number5_COMPLETE = number5_COMPLETE;
	}

	public String getNumber6_COMPLETE() {
		return number6_COMPLETE;
	}

	public void setNumber6_COMPLETE(String number6_COMPLETE) {
		this.number6_COMPLETE = number6_COMPLETE;
	}

	public String getBuilding1_COMPLETE() {
		return building1_COMPLETE;
	}

	public void setBuilding1_COMPLETE(String building1_COMPLETE) {
		this.building1_COMPLETE = building1_COMPLETE;
	}

	public String getBuilding2_COMPLETE() {
		return building2_COMPLETE;
	}

	public void setBuilding2_COMPLETE(String building2_COMPLETE) {
		this.building2_COMPLETE = building2_COMPLETE;
	}

	public String getBuilding3_COMPLETE() {
		return building3_COMPLETE;
	}

	public void setBuilding3_COMPLETE(String building3_COMPLETE) {
		this.building3_COMPLETE = building3_COMPLETE;
	}

	public String getBuilding4_COMPLETE() {
		return building4_COMPLETE;
	}

	public void setBuilding4_COMPLETE(String building4_COMPLETE) {
		this.building4_COMPLETE = building4_COMPLETE;
	}

	public String getBuilding5_COMPLETE() {
		return building5_COMPLETE;
	}

	public void setBuilding5_COMPLETE(String building5_COMPLETE) {
		this.building5_COMPLETE = building5_COMPLETE;
	}

	public String getBuilding6_COMPLETE() {
		return building6_COMPLETE;
	}

	public void setBuilding6_COMPLETE(String building6_COMPLETE) {
		this.building6_COMPLETE = building6_COMPLETE;
	}

	public String getSubBuilding1_COMPLETE() {
		return subBuilding1_COMPLETE;
	}

	public void setSubBuilding1_COMPLETE(String subBuilding1_COMPLETE) {
		this.subBuilding1_COMPLETE = subBuilding1_COMPLETE;
	}

	public String getSubBuilding2_COMPLETE() {
		return subBuilding2_COMPLETE;
	}

	public void setSubBuilding2_COMPLETE(String subBuilding2_COMPLETE) {
		this.subBuilding2_COMPLETE = subBuilding2_COMPLETE;
	}

	public String getSubBuilding3_COMPLETE() {
		return subBuilding3_COMPLETE;
	}

	public void setSubBuilding3_COMPLETE(String subBuilding3_COMPLETE) {
		this.subBuilding3_COMPLETE = subBuilding3_COMPLETE;
	}

	public String getSubBuilding4_COMPLETE() {
		return subBuilding4_COMPLETE;
	}

	public void setSubBuilding4_COMPLETE(String subBuilding4_COMPLETE) {
		this.subBuilding4_COMPLETE = subBuilding4_COMPLETE;
	}

	public String getSubBuilding5_COMPLETE() {
		return subBuilding5_COMPLETE;
	}

	public void setSubBuilding5_COMPLETE(String subBuilding5_COMPLETE) {
		this.subBuilding5_COMPLETE = subBuilding5_COMPLETE;
	}

	public String getSubBuilding6_COMPLETE() {
		return subBuilding6_COMPLETE;
	}

	public void setSubBuilding6_COMPLETE(String subBuilding6_COMPLETE) {
		this.subBuilding6_COMPLETE = subBuilding6_COMPLETE;
	}

	public String getDeliverService1_COMPLETE() {
		return deliverService1_COMPLETE;
	}

	public void setDeliverService1_COMPLETE(String deliverService1_COMPLETE) {
		this.deliverService1_COMPLETE = deliverService1_COMPLETE;
	}

	public String getDeliverService2_COMPLETE() {
		return deliverService2_COMPLETE;
	}

	public void setDeliverService2_COMPLETE(String deliverService2_COMPLETE) {
		this.deliverService2_COMPLETE = deliverService2_COMPLETE;
	}

	public String getDeliverService3_COMPLETE() {
		return deliverService3_COMPLETE;
	}

	public void setDeliverService3_COMPLETE(String deliverService3_COMPLETE) {
		this.deliverService3_COMPLETE = deliverService3_COMPLETE;
	}

	public String getDeliverService4_COMPLETE() {
		return deliverService4_COMPLETE;
	}

	public void setDeliverService4_COMPLETE(String deliverService4_COMPLETE) {
		this.deliverService4_COMPLETE = deliverService4_COMPLETE;
	}

	public String getDeliverService5_COMPLETE() {
		return deliverService5_COMPLETE;
	}

	public void setDeliverService5_COMPLETE(String deliverService5_COMPLETE) {
		this.deliverService5_COMPLETE = deliverService5_COMPLETE;
	}

	public String getDeliverService6_COMPLETE() {
		return deliverService6_COMPLETE;
	}

	public void setDeliverService6_COMPLETE(String deliverService6_COMPLETE) {
		this.deliverService6_COMPLETE = deliverService6_COMPLETE;
	}

	public String getOrganization1_COMPLETE() {
		return organization1_COMPLETE;
	}

	public void setOrganization1_COMPLETE(String organization1_COMPLETE) {
		this.organization1_COMPLETE = organization1_COMPLETE;
	}

	public String getOrganization2_COMPLETE() {
		return organization2_COMPLETE;
	}

	public void setOrganization2_COMPLETE(String organization2_COMPLETE) {
		this.organization2_COMPLETE = organization2_COMPLETE;
	}

	public String getOrganization3_COMPLETE() {
		return organization3_COMPLETE;
	}

	public void setOrganization3_COMPLETE(String organization3_COMPLETE) {
		this.organization3_COMPLETE = organization3_COMPLETE;
	}

	public String getContact1_COMPLETE() {
		return contact1_COMPLETE;
	}

	public void setContact1_COMPLETE(String contact1_COMPLETE) {
		this.contact1_COMPLETE = contact1_COMPLETE;
	}

	public String getContact2_COMPLETE() {
		return contact2_COMPLETE;
	}

	public void setContact2_COMPLETE(String contact2_COMPLETE) {
		this.contact2_COMPLETE = contact2_COMPLETE;
	}

	public String getContact3_COMPLETE() {
		return contact3_COMPLETE;
	}

	public void setContact3_COMPLETE(String contact3_COMPLETE) {
		this.contact3_COMPLETE = contact3_COMPLETE;
	}

	public String getResidue1_UNRECOGNIZED() {
		return residue1_UNRECOGNIZED;
	}

	public void setResidue1_UNRECOGNIZED(String residue1_UNRECOGNIZED) {
		this.residue1_UNRECOGNIZED = residue1_UNRECOGNIZED;
	}

	public String getResidue2_UNRECOGNIZED() {
		return residue2_UNRECOGNIZED;
	}

	public void setResidue2_UNRECOGNIZED(String residue2_UNRECOGNIZED) {
		this.residue2_UNRECOGNIZED = residue2_UNRECOGNIZED;
	}

	public String getResidue3_UNRECOGNIZED() {
		return residue3_UNRECOGNIZED;
	}

	public void setResidue3_UNRECOGNIZED(String residue3_UNRECOGNIZED) {
		this.residue3_UNRECOGNIZED = residue3_UNRECOGNIZED;
	}

	public String getResidue4_UNRECOGNIZED() {
		return residue4_UNRECOGNIZED;
	}

	public void setResidue4_UNRECOGNIZED(String residue4_UNRECOGNIZED) {
		this.residue4_UNRECOGNIZED = residue4_UNRECOGNIZED;
	}

	public String getResidue5_UNRECOGNIZED() {
		return residue5_UNRECOGNIZED;
	}

	public void setResidue5_UNRECOGNIZED(String residue5_UNRECOGNIZED) {
		this.residue5_UNRECOGNIZED = residue5_UNRECOGNIZED;
	}

	public String getResidue6_UNRECOGNIZED() {
		return residue6_UNRECOGNIZED;
	}

	public void setResidue6_UNRECOGNIZED(String residue6_UNRECOGNIZED) {
		this.residue6_UNRECOGNIZED = residue6_UNRECOGNIZED;
	}

	public String getRecipientLine_1() {
		return recipientLine_1;
	}

	public void setRecipientLine_1(String recipientLine_1) {
		this.recipientLine_1 = recipientLine_1;
	}

	public String getRecipientLine_2() {
		return recipientLine_2;
	}

	public void setRecipientLine_2(String recipientLine_2) {
		this.recipientLine_2 = recipientLine_2;
	}

	public String getRecipientLine_3() {
		return recipientLine_3;
	}

	public void setRecipientLine_3(String recipientLine_3) {
		this.recipientLine_3 = recipientLine_3;
	}

	public String getDeliveryAddressLine_1() {
		return deliveryAddressLine_1;
	}

	public void setDeliveryAddressLine_1(String deliveryAddressLine_1) {
		this.deliveryAddressLine_1 = deliveryAddressLine_1;
	}

	public String getDeliveryAddressLine_2() {
		return deliveryAddressLine_2;
	}

	public void setDeliveryAddressLine_2(String deliveryAddressLine_2) {
		this.deliveryAddressLine_2 = deliveryAddressLine_2;
	}

	public String getDeliveryAddressLine_3() {
		return deliveryAddressLine_3;
	}

	public void setDeliveryAddressLine_3(String deliveryAddressLine_3) {
		this.deliveryAddressLine_3 = deliveryAddressLine_3;
	}

	public String getDeliveryAddressLine_4() {
		return deliveryAddressLine_4;
	}

	public void setDeliveryAddressLine_4(String deliveryAddressLine_4) {
		this.deliveryAddressLine_4 = deliveryAddressLine_4;
	}

	public String getDeliveryAddressLine_5() {
		return deliveryAddressLine_5;
	}

	public void setDeliveryAddressLine_5(String deliveryAddressLine_5) {
		this.deliveryAddressLine_5 = deliveryAddressLine_5;
	}

	public String getDeliveryAddressLine_6() {
		return deliveryAddressLine_6;
	}

	public void setDeliveryAddressLine_6(String deliveryAddressLine_6) {
		this.deliveryAddressLine_6 = deliveryAddressLine_6;
	}

	public String getCountrySpecificLocalityLine_1() {
		return countrySpecificLocalityLine_1;
	}

	public void setCountrySpecificLocalityLine_1(String countrySpecificLocalityLine_1) {
		this.countrySpecificLocalityLine_1 = countrySpecificLocalityLine_1;
	}

	public String getCountrySpecificLocalityLine_2() {
		return countrySpecificLocalityLine_2;
	}

	public void setCountrySpecificLocalityLine_2(String countrySpecificLocalityLine_2) {
		this.countrySpecificLocalityLine_2 = countrySpecificLocalityLine_2;
	}

	public String getCountrySpecificLocalityLine_3() {
		return countrySpecificLocalityLine_3;
	}

	public void setCountrySpecificLocalityLine_3(String countrySpecificLocalityLine_3) {
		this.countrySpecificLocalityLine_3 = countrySpecificLocalityLine_3;
	}

	public String getCountrySpecificLocalityLine_4() {
		return countrySpecificLocalityLine_4;
	}

	public void setCountrySpecificLocalityLine_4(String countrySpecificLocalityLine_4) {
		this.countrySpecificLocalityLine_4 = countrySpecificLocalityLine_4;
	}

	public String getCountrySpecificLocalityLine_5() {
		return countrySpecificLocalityLine_5;
	}

	public void setCountrySpecificLocalityLine_5(String countrySpecificLocalityLine_5) {
		this.countrySpecificLocalityLine_5 = countrySpecificLocalityLine_5;
	}

	public String getCountrySpecificLocalityLine_6() {
		return countrySpecificLocalityLine_6;
	}

	public void setCountrySpecificLocalityLine_6(String countrySpecificLocalityLine_6) {
		this.countrySpecificLocalityLine_6 = countrySpecificLocalityLine_6;
	}

	public String getFormattedAddressLine_1() {
		return formattedAddressLine_1;
	}

	public void setFormattedAddressLine_1(String formattedAddressLine_1) {
		this.formattedAddressLine_1 = formattedAddressLine_1;
	}

	public String getFormattedAddressLine_2() {
		return formattedAddressLine_2;
	}

	public void setFormattedAddressLine_2(String formattedAddressLine_2) {
		this.formattedAddressLine_2 = formattedAddressLine_2;
	}

	public String getFormattedAddressLine_3() {
		return formattedAddressLine_3;
	}

	public void setFormattedAddressLine_3(String formattedAddressLine_3) {
		this.formattedAddressLine_3 = formattedAddressLine_3;
	}

	public String getFormattedAddressLine_4() {
		return formattedAddressLine_4;
	}

	public void setFormattedAddressLine_4(String formattedAddressLine_4) {
		this.formattedAddressLine_4 = formattedAddressLine_4;
	}

	public String getFormattedAddressLine_5() {
		return formattedAddressLine_5;
	}

	public void setFormattedAddressLine_5(String formattedAddressLine_5) {
		this.formattedAddressLine_5 = formattedAddressLine_5;
	}

	public String getFormattedAddressLine_6() {
		return formattedAddressLine_6;
	}

	public void setFormattedAddressLine_6(String formattedAddressLine_6) {
		this.formattedAddressLine_6 = formattedAddressLine_6;
	}

	public String getFormattedAddressLine_7() {
		return formattedAddressLine_7;
	}

	public void setFormattedAddressLine_7(String formattedAddressLine_7) {
		this.formattedAddressLine_7 = formattedAddressLine_7;
	}

	public String getFormattedAddressLine_8() {
		return formattedAddressLine_8;
	}

	public void setFormattedAddressLine_8(String formattedAddressLine_8) {
		this.formattedAddressLine_8 = formattedAddressLine_8;
	}

	public String getFormattedAddressLine_9() {
		return formattedAddressLine_9;
	}

	public void setFormattedAddressLine_9(String formattedAddressLine_9) {
		this.formattedAddressLine_9 = formattedAddressLine_9;
	}

	public String getFormattedAddressLine_10() {
		return formattedAddressLine_10;
	}

	public void setFormattedAddressLine_10(String formattedAddressLine_10) {
		this.formattedAddressLine_10 = formattedAddressLine_10;
	}

	public String getFormattedAddressLine_11() {
		return formattedAddressLine_11;
	}

	public void setFormattedAddressLine_11(String formattedAddressLine_11) {
		this.formattedAddressLine_11 = formattedAddressLine_11;
	}

	public String getFormattedAddressLine_12() {
		return formattedAddressLine_12;
	}

	public void setFormattedAddressLine_12(String formattedAddressLine_12) {
		this.formattedAddressLine_12 = formattedAddressLine_12;
	}

	public String getFormattedAddressLine_13() {
		return formattedAddressLine_13;
	}

	public void setFormattedAddressLine_13(String formattedAddressLine_13) {
		this.formattedAddressLine_13 = formattedAddressLine_13;
	}

	public String getFormattedAddressLine_14() {
		return formattedAddressLine_14;
	}

	public void setFormattedAddressLine_14(String formattedAddressLine_14) {
		this.formattedAddressLine_14 = formattedAddressLine_14;
	}

	public String getFormattedAddressLine_15() {
		return formattedAddressLine_15;
	}

	public void setFormattedAddressLine_15(String formattedAddressLine_15) {
		this.formattedAddressLine_15 = formattedAddressLine_15;
	}

	public String getFormattedAddressLine_16() {
		return formattedAddressLine_16;
	}

	public void setFormattedAddressLine_16(String formattedAddressLine_16) {
		this.formattedAddressLine_16 = formattedAddressLine_16;
	}

	public String getFormattedAddressLine_17() {
		return formattedAddressLine_17;
	}

	public void setFormattedAddressLine_17(String formattedAddressLine_17) {
		this.formattedAddressLine_17 = formattedAddressLine_17;
	}

	public String getFormattedAddressLine_18() {
		return formattedAddressLine_18;
	}

	public void setFormattedAddressLine_18(String formattedAddressLine_18) {
		this.formattedAddressLine_18 = formattedAddressLine_18;
	}

	public String getFormattedAddressLine_19() {
		return formattedAddressLine_19;
	}

	public void setFormattedAddressLine_19(String formattedAddressLine_19) {
		this.formattedAddressLine_19 = formattedAddressLine_19;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getCountry1_ABBREVIATION() {
		return country1_ABBREVIATION;
	}

	public void setCountry1_ABBREVIATION(String country1_ABBREVIATION) {
		this.country1_ABBREVIATION = country1_ABBREVIATION;
	}

	public String getCountry1_ISO2() {
		return country1_ISO2;
	}

	public void setCountry1_ISO2(String country1_ISO2) {
		this.country1_ISO2 = country1_ISO2;
	}

	public String getCountry1_ISO3() {
		return country1_ISO3;
	}

	public void setCountry1_ISO3(String country1_ISO3) {
		this.country1_ISO3 = country1_ISO3;
	}

	public String getCountry1_ISO_NUMBER() {
		return country1_ISO_NUMBER;
	}

	public void setCountry1_ISO_NUMBER(String country1_ISO_NUMBER) {
		this.country1_ISO_NUMBER = country1_ISO_NUMBER;
	}

	public String getCountry1_NAME_CN() {
		return country1_NAME_CN;
	}

	public void setCountry1_NAME_CN(String country1_NAME_CN) {
		this.country1_NAME_CN = country1_NAME_CN;
	}

	public String getCountry1_NAME_DA() {
		return country1_NAME_DA;
	}

	public void setCountry1_NAME_DA(String country1_NAME_DA) {
		this.country1_NAME_DA = country1_NAME_DA;
	}

	public String getCountry1_NAME_DE() {
		return country1_NAME_DE;
	}

	public void setCountry1_NAME_DE(String country1_NAME_DE) {
		this.country1_NAME_DE = country1_NAME_DE;
	}

	public String getCountry1_NAME_ES() {
		return country1_NAME_ES;
	}

	public void setCountry1_NAME_ES(String country1_NAME_ES) {
		this.country1_NAME_ES = country1_NAME_ES;
	}

	public String getCountry1_NAME_FI() {
		return country1_NAME_FI;
	}

	public void setCountry1_NAME_FI(String country1_NAME_FI) {
		this.country1_NAME_FI = country1_NAME_FI;
	}

	public String getCountry1_NAME_FR() {
		return country1_NAME_FR;
	}

	public void setCountry1_NAME_FR(String country1_NAME_FR) {
		this.country1_NAME_FR = country1_NAME_FR;
	}

	public String getCountry1_NAME_GR() {
		return country1_NAME_GR;
	}

	public void setCountry1_NAME_GR(String country1_NAME_GR) {
		this.country1_NAME_GR = country1_NAME_GR;
	}

	public String getCountry1_NAME_HU() {
		return country1_NAME_HU;
	}

	public void setCountry1_NAME_HU(String country1_NAME_HU) {
		this.country1_NAME_HU = country1_NAME_HU;
	}

	public String getCountry1_NAME_IT() {
		return country1_NAME_IT;
	}

	public void setCountry1_NAME_IT(String country1_NAME_IT) {
		this.country1_NAME_IT = country1_NAME_IT;
	}

	public String getCountry1_NAME_JP() {
		return country1_NAME_JP;
	}

	public void setCountry1_NAME_JP(String country1_NAME_JP) {
		this.country1_NAME_JP = country1_NAME_JP;
	}

	public String getCountry1_NAME_KR() {
		return country1_NAME_KR;
	}

	public void setCountry1_NAME_KR(String country1_NAME_KR) {
		this.country1_NAME_KR = country1_NAME_KR;
	}

	public String getCountry1_NAME_NL() {
		return country1_NAME_NL;
	}

	public void setCountry1_NAME_NL(String country1_NAME_NL) {
		this.country1_NAME_NL = country1_NAME_NL;
	}

	public String getCountry1_NAME_PL() {
		return country1_NAME_PL;
	}

	public void setCountry1_NAME_PL(String country1_NAME_PL) {
		this.country1_NAME_PL = country1_NAME_PL;
	}

	public String getCountry1_NAME_PT() {
		return country1_NAME_PT;
	}

	public void setCountry1_NAME_PT(String country1_NAME_PT) {
		this.country1_NAME_PT = country1_NAME_PT;
	}

	public String getCountry1_NAME_RU() {
		return country1_NAME_RU;
	}

	public void setCountry1_NAME_RU(String country1_NAME_RU) {
		this.country1_NAME_RU = country1_NAME_RU;
	}

	public String getCountry1_NAME_SA() {
		return country1_NAME_SA;
	}

	public void setCountry1_NAME_SA(String country1_NAME_SA) {
		this.country1_NAME_SA = country1_NAME_SA;
	}

	public String getCountry1_NAME_SE() {
		return country1_NAME_SE;
	}

	public void setCountry1_NAME_SE(String country1_NAME_SE) {
		this.country1_NAME_SE = country1_NAME_SE;
	}

	public String getCountry2_ABBREVIATION() {
		return country2_ABBREVIATION;
	}

	public void setCountry2_ABBREVIATION(String country2_ABBREVIATION) {
		this.country2_ABBREVIATION = country2_ABBREVIATION;
	}

	public String getCountry2_ISO2() {
		return country2_ISO2;
	}

	public void setCountry2_ISO2(String country2_ISO2) {
		this.country2_ISO2 = country2_ISO2;
	}

	public String getCountry2_ISO3() {
		return country2_ISO3;
	}

	public void setCountry2_ISO3(String country2_ISO3) {
		this.country2_ISO3 = country2_ISO3;
	}

	public String getCountry2_ISO_NUMBER() {
		return country2_ISO_NUMBER;
	}

	public void setCountry2_ISO_NUMBER(String country2_ISO_NUMBER) {
		this.country2_ISO_NUMBER = country2_ISO_NUMBER;
	}

	public String getCountry2_NAME_CN() {
		return country2_NAME_CN;
	}

	public void setCountry2_NAME_CN(String country2_NAME_CN) {
		this.country2_NAME_CN = country2_NAME_CN;
	}

	public String getCountry2_NAME_DA() {
		return country2_NAME_DA;
	}

	public void setCountry2_NAME_DA(String country2_NAME_DA) {
		this.country2_NAME_DA = country2_NAME_DA;
	}

	public String getCountry2_NAME_DE() {
		return country2_NAME_DE;
	}

	public void setCountry2_NAME_DE(String country2_NAME_DE) {
		this.country2_NAME_DE = country2_NAME_DE;
	}

	public String getCountry2_NAME_ES() {
		return country2_NAME_ES;
	}

	public void setCountry2_NAME_ES(String country2_NAME_ES) {
		this.country2_NAME_ES = country2_NAME_ES;
	}

	public String getCountry2_NAME_FI() {
		return country2_NAME_FI;
	}

	public void setCountry2_NAME_FI(String country2_NAME_FI) {
		this.country2_NAME_FI = country2_NAME_FI;
	}

	public String getCountry2_NAME_FR() {
		return country2_NAME_FR;
	}

	public void setCountry2_NAME_FR(String country2_NAME_FR) {
		this.country2_NAME_FR = country2_NAME_FR;
	}

	public String getCountry2_NAME_GR() {
		return country2_NAME_GR;
	}

	public void setCountry2_NAME_GR(String country2_NAME_GR) {
		this.country2_NAME_GR = country2_NAME_GR;
	}

	public String getCountry2_NAME_HU() {
		return country2_NAME_HU;
	}

	public void setCountry2_NAME_HU(String country2_NAME_HU) {
		this.country2_NAME_HU = country2_NAME_HU;
	}

	public String getCountry2_NAME_IT() {
		return country2_NAME_IT;
	}

	public void setCountry2_NAME_IT(String country2_NAME_IT) {
		this.country2_NAME_IT = country2_NAME_IT;
	}

	public String getCountry2_NAME_JP() {
		return country2_NAME_JP;
	}

	public void setCountry2_NAME_JP(String country2_NAME_JP) {
		this.country2_NAME_JP = country2_NAME_JP;
	}

	public String getCountry2_NAME_KR() {
		return country2_NAME_KR;
	}

	public void setCountry2_NAME_KR(String country2_NAME_KR) {
		this.country2_NAME_KR = country2_NAME_KR;
	}

	public String getCountry2_NAME_NL() {
		return country2_NAME_NL;
	}

	public void setCountry2_NAME_NL(String country2_NAME_NL) {
		this.country2_NAME_NL = country2_NAME_NL;
	}

	public String getCountry2_NAME_PL() {
		return country2_NAME_PL;
	}

	public void setCountry2_NAME_PL(String country2_NAME_PL) {
		this.country2_NAME_PL = country2_NAME_PL;
	}

	public String getCountry2_NAME_PT() {
		return country2_NAME_PT;
	}

	public void setCountry2_NAME_PT(String country2_NAME_PT) {
		this.country2_NAME_PT = country2_NAME_PT;
	}

	public String getCountry2_NAME_RU() {
		return country2_NAME_RU;
	}

	public void setCountry2_NAME_RU(String country2_NAME_RU) {
		this.country2_NAME_RU = country2_NAME_RU;
	}

	public String getCountry2_NAME_SA() {
		return country2_NAME_SA;
	}

	public void setCountry2_NAME_SA(String country2_NAME_SA) {
		this.country2_NAME_SA = country2_NAME_SA;
	}

	public String getCountry2_NAME_SE() {
		return country2_NAME_SE;
	}

	public void setCountry2_NAME_SE(String country2_NAME_SE) {
		this.country2_NAME_SE = country2_NAME_SE;
	}

	public String getCountry3_ABBREVIATION() {
		return country3_ABBREVIATION;
	}

	public void setCountry3_ABBREVIATION(String country3_ABBREVIATION) {
		this.country3_ABBREVIATION = country3_ABBREVIATION;
	}

	public String getCountry3_ISO2() {
		return country3_ISO2;
	}

	public void setCountry3_ISO2(String country3_ISO2) {
		this.country3_ISO2 = country3_ISO2;
	}

	public String getCountry3_ISO3() {
		return country3_ISO3;
	}

	public void setCountry3_ISO3(String country3_ISO3) {
		this.country3_ISO3 = country3_ISO3;
	}

	public String getCountry3_ISO_NUMBER() {
		return country3_ISO_NUMBER;
	}

	public void setCountry3_ISO_NUMBER(String country3_ISO_NUMBER) {
		this.country3_ISO_NUMBER = country3_ISO_NUMBER;
	}

	public String getCountry3_NAME_CN() {
		return country3_NAME_CN;
	}

	public void setCountry3_NAME_CN(String country3_NAME_CN) {
		this.country3_NAME_CN = country3_NAME_CN;
	}

	public String getCountry3_NAME_DA() {
		return country3_NAME_DA;
	}

	public void setCountry3_NAME_DA(String country3_NAME_DA) {
		this.country3_NAME_DA = country3_NAME_DA;
	}

	public String getCountry3_NAME_DE() {
		return country3_NAME_DE;
	}

	public void setCountry3_NAME_DE(String country3_NAME_DE) {
		this.country3_NAME_DE = country3_NAME_DE;
	}

	public String getCountry3_NAME_ES() {
		return country3_NAME_ES;
	}

	public void setCountry3_NAME_ES(String country3_NAME_ES) {
		this.country3_NAME_ES = country3_NAME_ES;
	}

	public String getCountry3_NAME_FI() {
		return country3_NAME_FI;
	}

	public void setCountry3_NAME_FI(String country3_NAME_FI) {
		this.country3_NAME_FI = country3_NAME_FI;
	}

	public String getCountry3_NAME_FR() {
		return country3_NAME_FR;
	}

	public void setCountry3_NAME_FR(String country3_NAME_FR) {
		this.country3_NAME_FR = country3_NAME_FR;
	}

	public String getCountry3_NAME_GR() {
		return country3_NAME_GR;
	}

	public void setCountry3_NAME_GR(String country3_NAME_GR) {
		this.country3_NAME_GR = country3_NAME_GR;
	}

	public String getCountry3_NAME_HU() {
		return country3_NAME_HU;
	}

	public void setCountry3_NAME_HU(String country3_NAME_HU) {
		this.country3_NAME_HU = country3_NAME_HU;
	}

	public String getCountry3_NAME_IT() {
		return country3_NAME_IT;
	}

	public void setCountry3_NAME_IT(String country3_NAME_IT) {
		this.country3_NAME_IT = country3_NAME_IT;
	}

	public String getCountry3_NAME_JP() {
		return country3_NAME_JP;
	}

	public void setCountry3_NAME_JP(String country3_NAME_JP) {
		this.country3_NAME_JP = country3_NAME_JP;
	}

	public String getCountry3_NAME_KR() {
		return country3_NAME_KR;
	}

	public void setCountry3_NAME_KR(String country3_NAME_KR) {
		this.country3_NAME_KR = country3_NAME_KR;
	}

	public String getCountry3_NAME_NL() {
		return country3_NAME_NL;
	}

	public void setCountry3_NAME_NL(String country3_NAME_NL) {
		this.country3_NAME_NL = country3_NAME_NL;
	}

	public String getCountry3_NAME_PL() {
		return country3_NAME_PL;
	}

	public void setCountry3_NAME_PL(String country3_NAME_PL) {
		this.country3_NAME_PL = country3_NAME_PL;
	}

	public String getCountry3_NAME_PT() {
		return country3_NAME_PT;
	}

	public void setCountry3_NAME_PT(String country3_NAME_PT) {
		this.country3_NAME_PT = country3_NAME_PT;
	}

	public String getCountry3_NAME_RU() {
		return country3_NAME_RU;
	}

	public void setCountry3_NAME_RU(String country3_NAME_RU) {
		this.country3_NAME_RU = country3_NAME_RU;
	}

	public String getCountry3_NAME_SA() {
		return country3_NAME_SA;
	}

	public void setCountry3_NAME_SA(String country3_NAME_SA) {
		this.country3_NAME_SA = country3_NAME_SA;
	}

	public String getCountry3_NAME_SE() {
		return country3_NAME_SE;
	}

	public void setCountry3_NAME_SE(String country3_NAME_SE) {
		this.country3_NAME_SE = country3_NAME_SE;
	}

	public String getLocality1_NAME() {
		return locality1_NAME;
	}

	public void setLocality1_NAME(String locality1_NAME) {
		this.locality1_NAME = locality1_NAME;
	}

	public String getLocality1_PREFERRED_NAME() {
		return locality1_PREFERRED_NAME;
	}

	public void setLocality1_PREFERRED_NAME(String locality1_PREFERRED_NAME) {
		this.locality1_PREFERRED_NAME = locality1_PREFERRED_NAME;
	}

	public String getLocality1_SORTING_CODE() {
		return locality1_SORTING_CODE;
	}

	public void setLocality1_SORTING_CODE(String locality1_SORTING_CODE) {
		this.locality1_SORTING_CODE = locality1_SORTING_CODE;
	}

	public String getLocality1_ADD_INFO() {
		return locality1_ADD_INFO;
	}

	public void setLocality1_ADD_INFO(String locality1_ADD_INFO) {
		this.locality1_ADD_INFO = locality1_ADD_INFO;
	}

	public String getLocality2_NAME() {
		return locality2_NAME;
	}

	public void setLocality2_NAME(String locality2_NAME) {
		this.locality2_NAME = locality2_NAME;
	}

	public String getLocality2_PREFERRED_NAME() {
		return locality2_PREFERRED_NAME;
	}

	public void setLocality2_PREFERRED_NAME(String locality2_PREFERRED_NAME) {
		this.locality2_PREFERRED_NAME = locality2_PREFERRED_NAME;
	}

	public String getLocality2_SORTING_CODE() {
		return locality2_SORTING_CODE;
	}

	public void setLocality2_SORTING_CODE(String locality2_SORTING_CODE) {
		this.locality2_SORTING_CODE = locality2_SORTING_CODE;
	}

	public String getLocality2_ADD_INFO() {
		return locality2_ADD_INFO;
	}

	public void setLocality2_ADD_INFO(String locality2_ADD_INFO) {
		this.locality2_ADD_INFO = locality2_ADD_INFO;
	}

	public String getLocality3_NAME() {
		return locality3_NAME;
	}

	public void setLocality3_NAME(String locality3_NAME) {
		this.locality3_NAME = locality3_NAME;
	}

	public String getLocality3_PREFERRED_NAME() {
		return locality3_PREFERRED_NAME;
	}

	public void setLocality3_PREFERRED_NAME(String locality3_PREFERRED_NAME) {
		this.locality3_PREFERRED_NAME = locality3_PREFERRED_NAME;
	}

	public String getLocality3_SORTING_CODE() {
		return locality3_SORTING_CODE;
	}

	public void setLocality3_SORTING_CODE(String locality3_SORTING_CODE) {
		this.locality3_SORTING_CODE = locality3_SORTING_CODE;
	}

	public String getLocality3_ADD_INFO() {
		return locality3_ADD_INFO;
	}

	public void setLocality3_ADD_INFO(String locality3_ADD_INFO) {
		this.locality3_ADD_INFO = locality3_ADD_INFO;
	}

	public String getLocality4_NAME() {
		return locality4_NAME;
	}

	public void setLocality4_NAME(String locality4_NAME) {
		this.locality4_NAME = locality4_NAME;
	}

	public String getLocality4_PREFERRED_NAME() {
		return locality4_PREFERRED_NAME;
	}

	public void setLocality4_PREFERRED_NAME(String locality4_PREFERRED_NAME) {
		this.locality4_PREFERRED_NAME = locality4_PREFERRED_NAME;
	}

	public String getLocality4_SORTING_CODE() {
		return locality4_SORTING_CODE;
	}

	public void setLocality4_SORTING_CODE(String locality4_SORTING_CODE) {
		this.locality4_SORTING_CODE = locality4_SORTING_CODE;
	}

	public String getLocality4_ADD_INFO() {
		return locality4_ADD_INFO;
	}

	public void setLocality4_ADD_INFO(String locality4_ADD_INFO) {
		this.locality4_ADD_INFO = locality4_ADD_INFO;
	}

	public String getLocality5_NAME() {
		return locality5_NAME;
	}

	public void setLocality5_NAME(String locality5_NAME) {
		this.locality5_NAME = locality5_NAME;
	}

	public String getLocality5_PREFERRED_NAME() {
		return locality5_PREFERRED_NAME;
	}

	public void setLocality5_PREFERRED_NAME(String locality5_PREFERRED_NAME) {
		this.locality5_PREFERRED_NAME = locality5_PREFERRED_NAME;
	}

	public String getLocality5_SORTING_CODE() {
		return locality5_SORTING_CODE;
	}

	public void setLocality5_SORTING_CODE(String locality5_SORTING_CODE) {
		this.locality5_SORTING_CODE = locality5_SORTING_CODE;
	}

	public String getLocality5_ADD_INFO() {
		return locality5_ADD_INFO;
	}

	public void setLocality5_ADD_INFO(String locality5_ADD_INFO) {
		this.locality5_ADD_INFO = locality5_ADD_INFO;
	}

	public String getLocality6_NAME() {
		return locality6_NAME;
	}

	public void setLocality6_NAME(String locality6_NAME) {
		this.locality6_NAME = locality6_NAME;
	}

	public String getLocality6_PREFERRED_NAME() {
		return locality6_PREFERRED_NAME;
	}

	public void setLocality6_PREFERRED_NAME(String locality6_PREFERRED_NAME) {
		this.locality6_PREFERRED_NAME = locality6_PREFERRED_NAME;
	}

	public String getLocality6_SORTING_CODE() {
		return locality6_SORTING_CODE;
	}

	public void setLocality6_SORTING_CODE(String locality6_SORTING_CODE) {
		this.locality6_SORTING_CODE = locality6_SORTING_CODE;
	}

	public String getLocality6_ADD_INFO() {
		return locality6_ADD_INFO;
	}

	public void setLocality6_ADD_INFO(String locality6_ADD_INFO) {
		this.locality6_ADD_INFO = locality6_ADD_INFO;
	}

	public String getPostalCode1_UNFORMATTED() {
		return postalCode1_UNFORMATTED;
	}

	public void setPostalCode1_UNFORMATTED(String postalCode1_UNFORMATTED) {
		this.postalCode1_UNFORMATTED = postalCode1_UNFORMATTED;
	}

	public String getPostalCode1_BASE() {
		return postalCode1_BASE;
	}

	public void setPostalCode1_BASE(String postalCode1_BASE) {
		this.postalCode1_BASE = postalCode1_BASE;
	}

	public String getPostalCode1_ADD_ON() {
		return postalCode1_ADD_ON;
	}

	public void setPostalCode1_ADD_ON(String postalCode1_ADD_ON) {
		this.postalCode1_ADD_ON = postalCode1_ADD_ON;
	}

	public String getPostalCode2_UNFORMATTED() {
		return postalCode2_UNFORMATTED;
	}

	public void setPostalCode2_UNFORMATTED(String postalCode2_UNFORMATTED) {
		this.postalCode2_UNFORMATTED = postalCode2_UNFORMATTED;
	}

	public String getPostalCode2_BASE() {
		return postalCode2_BASE;
	}

	public void setPostalCode2_BASE(String postalCode2_BASE) {
		this.postalCode2_BASE = postalCode2_BASE;
	}

	public String getPostalCode2_ADD_ON() {
		return postalCode2_ADD_ON;
	}

	public void setPostalCode2_ADD_ON(String postalCode2_ADD_ON) {
		this.postalCode2_ADD_ON = postalCode2_ADD_ON;
	}

	public String getPostalCode3_UNFORMATTED() {
		return postalCode3_UNFORMATTED;
	}

	public void setPostalCode3_UNFORMATTED(String postalCode3_UNFORMATTED) {
		this.postalCode3_UNFORMATTED = postalCode3_UNFORMATTED;
	}

	public String getPostalCode3_BASE() {
		return postalCode3_BASE;
	}

	public void setPostalCode3_BASE(String postalCode3_BASE) {
		this.postalCode3_BASE = postalCode3_BASE;
	}

	public String getPostalCode3_ADD_ON() {
		return postalCode3_ADD_ON;
	}

	public void setPostalCode3_ADD_ON(String postalCode3_ADD_ON) {
		this.postalCode3_ADD_ON = postalCode3_ADD_ON;
	}

	public String getProvince1_ABBREVIATION() {
		return province1_ABBREVIATION;
	}

	public void setProvince1_ABBREVIATION(String province1_ABBREVIATION) {
		this.province1_ABBREVIATION = province1_ABBREVIATION;
	}

	public String getProvince1_EXTENDED() {
		return province1_EXTENDED;
	}

	public void setProvince1_EXTENDED(String province1_EXTENDED) {
		this.province1_EXTENDED = province1_EXTENDED;
	}

	public String getProvince1_ISO() {
		return province1_ISO;
	}

	public void setProvince1_ISO(String province1_ISO) {
		this.province1_ISO = province1_ISO;
	}

	public String getProvince2_ABBREVIATION() {
		return province2_ABBREVIATION;
	}

	public void setProvince2_ABBREVIATION(String province2_ABBREVIATION) {
		this.province2_ABBREVIATION = province2_ABBREVIATION;
	}

	public String getProvince2_EXTENDED() {
		return province2_EXTENDED;
	}

	public void setProvince2_EXTENDED(String province2_EXTENDED) {
		this.province2_EXTENDED = province2_EXTENDED;
	}

	public String getProvince2_ISO() {
		return province2_ISO;
	}

	public void setProvince2_ISO(String province2_ISO) {
		this.province2_ISO = province2_ISO;
	}

	public String getProvince3_ABBREVIATION() {
		return province3_ABBREVIATION;
	}

	public void setProvince3_ABBREVIATION(String province3_ABBREVIATION) {
		this.province3_ABBREVIATION = province3_ABBREVIATION;
	}

	public String getProvince3_EXTENDED() {
		return province3_EXTENDED;
	}

	public void setProvince3_EXTENDED(String province3_EXTENDED) {
		this.province3_EXTENDED = province3_EXTENDED;
	}

	public String getProvince3_ISO() {
		return province3_ISO;
	}

	public void setProvince3_ISO(String province3_ISO) {
		this.province3_ISO = province3_ISO;
	}

	public String getProvince4_ABBREVIATION() {
		return province4_ABBREVIATION;
	}

	public void setProvince4_ABBREVIATION(String province4_ABBREVIATION) {
		this.province4_ABBREVIATION = province4_ABBREVIATION;
	}

	public String getProvince4_EXTENDED() {
		return province4_EXTENDED;
	}

	public void setProvince4_EXTENDED(String province4_EXTENDED) {
		this.province4_EXTENDED = province4_EXTENDED;
	}

	public String getProvince4_ISO() {
		return province4_ISO;
	}

	public void setProvince4_ISO(String province4_ISO) {
		this.province4_ISO = province4_ISO;
	}

	public String getProvince5_ABBREVIATION() {
		return province5_ABBREVIATION;
	}

	public void setProvince5_ABBREVIATION(String province5_ABBREVIATION) {
		this.province5_ABBREVIATION = province5_ABBREVIATION;
	}

	public String getProvince5_EXTENDED() {
		return province5_EXTENDED;
	}

	public void setProvince5_EXTENDED(String province5_EXTENDED) {
		this.province5_EXTENDED = province5_EXTENDED;
	}

	public String getProvince5_ISO() {
		return province5_ISO;
	}

	public void setProvince5_ISO(String province5_ISO) {
		this.province5_ISO = province5_ISO;
	}

	public String getProvince6_ABBREVIATION() {
		return province6_ABBREVIATION;
	}

	public void setProvince6_ABBREVIATION(String province6_ABBREVIATION) {
		this.province6_ABBREVIATION = province6_ABBREVIATION;
	}

	public String getProvince6_EXTENDED() {
		return province6_EXTENDED;
	}

	public void setProvince6_EXTENDED(String province6_EXTENDED) {
		this.province6_EXTENDED = province6_EXTENDED;
	}

	public String getProvince6_ISO() {
		return province6_ISO;
	}

	public void setProvince6_ISO(String province6_ISO) {
		this.province6_ISO = province6_ISO;
	}

	public String getStreet1_COMPLETE_WITH_NUMBER() {
		return street1_COMPLETE_WITH_NUMBER;
	}

	public void setStreet1_COMPLETE_WITH_NUMBER(String street1_COMPLETE_WITH_NUMBER) {
		this.street1_COMPLETE_WITH_NUMBER = street1_COMPLETE_WITH_NUMBER;
	}

	public String getStreet1_NAME() {
		return street1_NAME;
	}

	public void setStreet1_NAME(String street1_NAME) {
		this.street1_NAME = street1_NAME;
	}

	public String getStreet1_PRE_DESCRIPTOR() {
		return street1_PRE_DESCRIPTOR;
	}

	public void setStreet1_PRE_DESCRIPTOR(String street1_PRE_DESCRIPTOR) {
		this.street1_PRE_DESCRIPTOR = street1_PRE_DESCRIPTOR;
	}

	public String getStreet1_POST_DESCRIPTOR() {
		return street1_POST_DESCRIPTOR;
	}

	public void setStreet1_POST_DESCRIPTOR(String street1_POST_DESCRIPTOR) {
		this.street1_POST_DESCRIPTOR = street1_POST_DESCRIPTOR;
	}

	public String getStreet1_PRE_DIRECTIONAL() {
		return street1_PRE_DIRECTIONAL;
	}

	public void setStreet1_PRE_DIRECTIONAL(String street1_PRE_DIRECTIONAL) {
		this.street1_PRE_DIRECTIONAL = street1_PRE_DIRECTIONAL;
	}

	public String getStreet1_POST_DIRECTIONAL() {
		return street1_POST_DIRECTIONAL;
	}

	public void setStreet1_POST_DIRECTIONAL(String street1_POST_DIRECTIONAL) {
		this.street1_POST_DIRECTIONAL = street1_POST_DIRECTIONAL;
	}

	public String getStreet1_ADD_INFO() {
		return street1_ADD_INFO;
	}

	public void setStreet1_ADD_INFO(String street1_ADD_INFO) {
		this.street1_ADD_INFO = street1_ADD_INFO;
	}

	public String getStreet2_COMPLETE_WITH_NUMBER() {
		return street2_COMPLETE_WITH_NUMBER;
	}

	public void setStreet2_COMPLETE_WITH_NUMBER(String street2_COMPLETE_WITH_NUMBER) {
		this.street2_COMPLETE_WITH_NUMBER = street2_COMPLETE_WITH_NUMBER;
	}

	public String getStreet2_NAME() {
		return street2_NAME;
	}

	public void setStreet2_NAME(String street2_NAME) {
		this.street2_NAME = street2_NAME;
	}

	public String getStreet2_PRE_DESCRIPTOR() {
		return street2_PRE_DESCRIPTOR;
	}

	public void setStreet2_PRE_DESCRIPTOR(String street2_PRE_DESCRIPTOR) {
		this.street2_PRE_DESCRIPTOR = street2_PRE_DESCRIPTOR;
	}

	public String getStreet2_POST_DESCRIPTOR() {
		return street2_POST_DESCRIPTOR;
	}

	public void setStreet2_POST_DESCRIPTOR(String street2_POST_DESCRIPTOR) {
		this.street2_POST_DESCRIPTOR = street2_POST_DESCRIPTOR;
	}

	public String getStreet2_PRE_DIRECTIONAL() {
		return street2_PRE_DIRECTIONAL;
	}

	public void setStreet2_PRE_DIRECTIONAL(String street2_PRE_DIRECTIONAL) {
		this.street2_PRE_DIRECTIONAL = street2_PRE_DIRECTIONAL;
	}

	public String getStreet2_POST_DIRECTIONAL() {
		return street2_POST_DIRECTIONAL;
	}

	public void setStreet2_POST_DIRECTIONAL(String street2_POST_DIRECTIONAL) {
		this.street2_POST_DIRECTIONAL = street2_POST_DIRECTIONAL;
	}

	public String getStreet2_ADD_INFO() {
		return street2_ADD_INFO;
	}

	public void setStreet2_ADD_INFO(String street2_ADD_INFO) {
		this.street2_ADD_INFO = street2_ADD_INFO;
	}

	public String getStreet3_COMPLETE_WITH_NUMBER() {
		return street3_COMPLETE_WITH_NUMBER;
	}

	public void setStreet3_COMPLETE_WITH_NUMBER(String street3_COMPLETE_WITH_NUMBER) {
		this.street3_COMPLETE_WITH_NUMBER = street3_COMPLETE_WITH_NUMBER;
	}

	public String getStreet3_NAME() {
		return street3_NAME;
	}

	public void setStreet3_NAME(String street3_NAME) {
		this.street3_NAME = street3_NAME;
	}

	public String getStreet3_PRE_DESCRIPTOR() {
		return street3_PRE_DESCRIPTOR;
	}

	public void setStreet3_PRE_DESCRIPTOR(String street3_PRE_DESCRIPTOR) {
		this.street3_PRE_DESCRIPTOR = street3_PRE_DESCRIPTOR;
	}

	public String getStreet3_POST_DESCRIPTOR() {
		return street3_POST_DESCRIPTOR;
	}

	public void setStreet3_POST_DESCRIPTOR(String street3_POST_DESCRIPTOR) {
		this.street3_POST_DESCRIPTOR = street3_POST_DESCRIPTOR;
	}

	public String getStreet3_PRE_DIRECTIONAL() {
		return street3_PRE_DIRECTIONAL;
	}

	public void setStreet3_PRE_DIRECTIONAL(String street3_PRE_DIRECTIONAL) {
		this.street3_PRE_DIRECTIONAL = street3_PRE_DIRECTIONAL;
	}

	public String getStreet3_POST_DIRECTIONAL() {
		return street3_POST_DIRECTIONAL;
	}

	public void setStreet3_POST_DIRECTIONAL(String street3_POST_DIRECTIONAL) {
		this.street3_POST_DIRECTIONAL = street3_POST_DIRECTIONAL;
	}

	public String getStreet3_ADD_INFO() {
		return street3_ADD_INFO;
	}

	public void setStreet3_ADD_INFO(String street3_ADD_INFO) {
		this.street3_ADD_INFO = street3_ADD_INFO;
	}

	public String getStreet4_COMPLETE_WITH_NUMBER() {
		return street4_COMPLETE_WITH_NUMBER;
	}

	public void setStreet4_COMPLETE_WITH_NUMBER(String street4_COMPLETE_WITH_NUMBER) {
		this.street4_COMPLETE_WITH_NUMBER = street4_COMPLETE_WITH_NUMBER;
	}

	public String getStreet4_NAME() {
		return street4_NAME;
	}

	public void setStreet4_NAME(String street4_NAME) {
		this.street4_NAME = street4_NAME;
	}

	public String getStreet4_PRE_DESCRIPTOR() {
		return street4_PRE_DESCRIPTOR;
	}

	public void setStreet4_PRE_DESCRIPTOR(String street4_PRE_DESCRIPTOR) {
		this.street4_PRE_DESCRIPTOR = street4_PRE_DESCRIPTOR;
	}

	public String getStreet4_POST_DESCRIPTOR() {
		return street4_POST_DESCRIPTOR;
	}

	public void setStreet4_POST_DESCRIPTOR(String street4_POST_DESCRIPTOR) {
		this.street4_POST_DESCRIPTOR = street4_POST_DESCRIPTOR;
	}

	public String getStreet4_PRE_DIRECTIONAL() {
		return street4_PRE_DIRECTIONAL;
	}

	public void setStreet4_PRE_DIRECTIONAL(String street4_PRE_DIRECTIONAL) {
		this.street4_PRE_DIRECTIONAL = street4_PRE_DIRECTIONAL;
	}

	public String getStreet4_POST_DIRECTIONAL() {
		return street4_POST_DIRECTIONAL;
	}

	public void setStreet4_POST_DIRECTIONAL(String street4_POST_DIRECTIONAL) {
		this.street4_POST_DIRECTIONAL = street4_POST_DIRECTIONAL;
	}

	public String getStreet4_ADD_INFO() {
		return street4_ADD_INFO;
	}

	public void setStreet4_ADD_INFO(String street4_ADD_INFO) {
		this.street4_ADD_INFO = street4_ADD_INFO;
	}

	public String getStreet5_COMPLETE_WITH_NUMBER() {
		return street5_COMPLETE_WITH_NUMBER;
	}

	public void setStreet5_COMPLETE_WITH_NUMBER(String street5_COMPLETE_WITH_NUMBER) {
		this.street5_COMPLETE_WITH_NUMBER = street5_COMPLETE_WITH_NUMBER;
	}

	public String getStreet5_NAME() {
		return street5_NAME;
	}

	public void setStreet5_NAME(String street5_NAME) {
		this.street5_NAME = street5_NAME;
	}

	public String getStreet5_PRE_DESCRIPTOR() {
		return street5_PRE_DESCRIPTOR;
	}

	public void setStreet5_PRE_DESCRIPTOR(String street5_PRE_DESCRIPTOR) {
		this.street5_PRE_DESCRIPTOR = street5_PRE_DESCRIPTOR;
	}

	public String getStreet5_POST_DESCRIPTOR() {
		return street5_POST_DESCRIPTOR;
	}

	public void setStreet5_POST_DESCRIPTOR(String street5_POST_DESCRIPTOR) {
		this.street5_POST_DESCRIPTOR = street5_POST_DESCRIPTOR;
	}

	public String getStreet5_PRE_DIRECTIONAL() {
		return street5_PRE_DIRECTIONAL;
	}

	public void setStreet5_PRE_DIRECTIONAL(String street5_PRE_DIRECTIONAL) {
		this.street5_PRE_DIRECTIONAL = street5_PRE_DIRECTIONAL;
	}

	public String getStreet5_POST_DIRECTIONAL() {
		return street5_POST_DIRECTIONAL;
	}

	public void setStreet5_POST_DIRECTIONAL(String street5_POST_DIRECTIONAL) {
		this.street5_POST_DIRECTIONAL = street5_POST_DIRECTIONAL;
	}

	public String getStreet5_ADD_INFO() {
		return street5_ADD_INFO;
	}

	public void setStreet5_ADD_INFO(String street5_ADD_INFO) {
		this.street5_ADD_INFO = street5_ADD_INFO;
	}

	public String getStreet6_COMPLETE_WITH_NUMBER() {
		return street6_COMPLETE_WITH_NUMBER;
	}

	public void setStreet6_COMPLETE_WITH_NUMBER(String street6_COMPLETE_WITH_NUMBER) {
		this.street6_COMPLETE_WITH_NUMBER = street6_COMPLETE_WITH_NUMBER;
	}

	public String getStreet6_NAME() {
		return street6_NAME;
	}

	public void setStreet6_NAME(String street6_NAME) {
		this.street6_NAME = street6_NAME;
	}

	public String getStreet6_PRE_DESCRIPTOR() {
		return street6_PRE_DESCRIPTOR;
	}

	public void setStreet6_PRE_DESCRIPTOR(String street6_PRE_DESCRIPTOR) {
		this.street6_PRE_DESCRIPTOR = street6_PRE_DESCRIPTOR;
	}

	public String getStreet6_POST_DESCRIPTOR() {
		return street6_POST_DESCRIPTOR;
	}

	public void setStreet6_POST_DESCRIPTOR(String street6_POST_DESCRIPTOR) {
		this.street6_POST_DESCRIPTOR = street6_POST_DESCRIPTOR;
	}

	public String getStreet6_PRE_DIRECTIONAL() {
		return street6_PRE_DIRECTIONAL;
	}

	public void setStreet6_PRE_DIRECTIONAL(String street6_PRE_DIRECTIONAL) {
		this.street6_PRE_DIRECTIONAL = street6_PRE_DIRECTIONAL;
	}

	public String getStreet6_POST_DIRECTIONAL() {
		return street6_POST_DIRECTIONAL;
	}

	public void setStreet6_POST_DIRECTIONAL(String street6_POST_DIRECTIONAL) {
		this.street6_POST_DIRECTIONAL = street6_POST_DIRECTIONAL;
	}

	public String getStreet6_ADD_INFO() {
		return street6_ADD_INFO;
	}

	public void setStreet6_ADD_INFO(String street6_ADD_INFO) {
		this.street6_ADD_INFO = street6_ADD_INFO;
	}

	public String getNumber1_NUMBER() {
		return number1_NUMBER;
	}

	public void setNumber1_NUMBER(String number1_NUMBER) {
		this.number1_NUMBER = number1_NUMBER;
	}

	public String getNumber1_DESCRIPTOR() {
		return number1_DESCRIPTOR;
	}

	public void setNumber1_DESCRIPTOR(String number1_DESCRIPTOR) {
		this.number1_DESCRIPTOR = number1_DESCRIPTOR;
	}

	public String getNumber1_ADD_INFO() {
		return number1_ADD_INFO;
	}

	public void setNumber1_ADD_INFO(String number1_ADD_INFO) {
		this.number1_ADD_INFO = number1_ADD_INFO;
	}

	public String getNumber2_NUMBER() {
		return number2_NUMBER;
	}

	public void setNumber2_NUMBER(String number2_NUMBER) {
		this.number2_NUMBER = number2_NUMBER;
	}

	public String getNumber2_DESCRIPTOR() {
		return number2_DESCRIPTOR;
	}

	public void setNumber2_DESCRIPTOR(String number2_DESCRIPTOR) {
		this.number2_DESCRIPTOR = number2_DESCRIPTOR;
	}

	public String getNumber2_ADD_INFO() {
		return number2_ADD_INFO;
	}

	public void setNumber2_ADD_INFO(String number2_ADD_INFO) {
		this.number2_ADD_INFO = number2_ADD_INFO;
	}

	public String getNumber3_NUMBER() {
		return number3_NUMBER;
	}

	public void setNumber3_NUMBER(String number3_NUMBER) {
		this.number3_NUMBER = number3_NUMBER;
	}

	public String getNumber3_DESCRIPTOR() {
		return number3_DESCRIPTOR;
	}

	public void setNumber3_DESCRIPTOR(String number3_DESCRIPTOR) {
		this.number3_DESCRIPTOR = number3_DESCRIPTOR;
	}

	public String getNumber3_ADD_INFO() {
		return number3_ADD_INFO;
	}

	public void setNumber3_ADD_INFO(String number3_ADD_INFO) {
		this.number3_ADD_INFO = number3_ADD_INFO;
	}

	public String getNumber4_NUMBER() {
		return number4_NUMBER;
	}

	public void setNumber4_NUMBER(String number4_NUMBER) {
		this.number4_NUMBER = number4_NUMBER;
	}

	public String getNumber4_DESCRIPTOR() {
		return number4_DESCRIPTOR;
	}

	public void setNumber4_DESCRIPTOR(String number4_DESCRIPTOR) {
		this.number4_DESCRIPTOR = number4_DESCRIPTOR;
	}

	public String getNumber4_ADD_INFO() {
		return number4_ADD_INFO;
	}

	public void setNumber4_ADD_INFO(String number4_ADD_INFO) {
		this.number4_ADD_INFO = number4_ADD_INFO;
	}

	public String getNumber5_NUMBER() {
		return number5_NUMBER;
	}

	public void setNumber5_NUMBER(String number5_NUMBER) {
		this.number5_NUMBER = number5_NUMBER;
	}

	public String getNumber5_DESCRIPTOR() {
		return number5_DESCRIPTOR;
	}

	public void setNumber5_DESCRIPTOR(String number5_DESCRIPTOR) {
		this.number5_DESCRIPTOR = number5_DESCRIPTOR;
	}

	public String getNumber5_ADD_INFO() {
		return number5_ADD_INFO;
	}

	public void setNumber5_ADD_INFO(String number5_ADD_INFO) {
		this.number5_ADD_INFO = number5_ADD_INFO;
	}

	public String getNumber6_NUMBER() {
		return number6_NUMBER;
	}

	public void setNumber6_NUMBER(String number6_NUMBER) {
		this.number6_NUMBER = number6_NUMBER;
	}

	public String getNumber6_DESCRIPTOR() {
		return number6_DESCRIPTOR;
	}

	public void setNumber6_DESCRIPTOR(String number6_DESCRIPTOR) {
		this.number6_DESCRIPTOR = number6_DESCRIPTOR;
	}

	public String getNumber6_ADD_INFO() {
		return number6_ADD_INFO;
	}

	public void setNumber6_ADD_INFO(String number6_ADD_INFO) {
		this.number6_ADD_INFO = number6_ADD_INFO;
	}

	public String getBuilding1_COMPLETE_WITH_SUBBUILDING() {
		return building1_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding1_COMPLETE_WITH_SUBBUILDING(String building1_COMPLETE_WITH_SUBBUILDING) {
		this.building1_COMPLETE_WITH_SUBBUILDING = building1_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding1_NAME() {
		return building1_NAME;
	}

	public void setBuilding1_NAME(String building1_NAME) {
		this.building1_NAME = building1_NAME;
	}

	public String getBuilding1_NUMBER() {
		return building1_NUMBER;
	}

	public void setBuilding1_NUMBER(String building1_NUMBER) {
		this.building1_NUMBER = building1_NUMBER;
	}

	public String getBuilding1_DESCRIPTOR() {
		return building1_DESCRIPTOR;
	}

	public void setBuilding1_DESCRIPTOR(String building1_DESCRIPTOR) {
		this.building1_DESCRIPTOR = building1_DESCRIPTOR;
	}

	public String getBuilding2_COMPLETE_WITH_SUBBUILDING() {
		return building2_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding2_COMPLETE_WITH_SUBBUILDING(String building2_COMPLETE_WITH_SUBBUILDING) {
		this.building2_COMPLETE_WITH_SUBBUILDING = building2_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding2_NAME() {
		return building2_NAME;
	}

	public void setBuilding2_NAME(String building2_NAME) {
		this.building2_NAME = building2_NAME;
	}

	public String getBuilding2_NUMBER() {
		return building2_NUMBER;
	}

	public void setBuilding2_NUMBER(String building2_NUMBER) {
		this.building2_NUMBER = building2_NUMBER;
	}

	public String getBuilding2_DESCRIPTOR() {
		return building2_DESCRIPTOR;
	}

	public void setBuilding2_DESCRIPTOR(String building2_DESCRIPTOR) {
		this.building2_DESCRIPTOR = building2_DESCRIPTOR;
	}

	public String getBuilding3_COMPLETE_WITH_SUBBUILDING() {
		return building3_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding3_COMPLETE_WITH_SUBBUILDING(String building3_COMPLETE_WITH_SUBBUILDING) {
		this.building3_COMPLETE_WITH_SUBBUILDING = building3_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding3_NAME() {
		return building3_NAME;
	}

	public void setBuilding3_NAME(String building3_NAME) {
		this.building3_NAME = building3_NAME;
	}

	public String getBuilding3_NUMBER() {
		return building3_NUMBER;
	}

	public void setBuilding3_NUMBER(String building3_NUMBER) {
		this.building3_NUMBER = building3_NUMBER;
	}

	public String getBuilding3_DESCRIPTOR() {
		return building3_DESCRIPTOR;
	}

	public void setBuilding3_DESCRIPTOR(String building3_DESCRIPTOR) {
		this.building3_DESCRIPTOR = building3_DESCRIPTOR;
	}

	public String getBuilding4_COMPLETE_WITH_SUBBUILDING() {
		return building4_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding4_COMPLETE_WITH_SUBBUILDING(String building4_COMPLETE_WITH_SUBBUILDING) {
		this.building4_COMPLETE_WITH_SUBBUILDING = building4_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding4_NAME() {
		return building4_NAME;
	}

	public void setBuilding4_NAME(String building4_NAME) {
		this.building4_NAME = building4_NAME;
	}

	public String getBuilding4_NUMBER() {
		return building4_NUMBER;
	}

	public void setBuilding4_NUMBER(String building4_NUMBER) {
		this.building4_NUMBER = building4_NUMBER;
	}

	public String getBuilding4_DESCRIPTOR() {
		return building4_DESCRIPTOR;
	}

	public void setBuilding4_DESCRIPTOR(String building4_DESCRIPTOR) {
		this.building4_DESCRIPTOR = building4_DESCRIPTOR;
	}

	public String getBuilding5_COMPLETE_WITH_SUBBUILDING() {
		return building5_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding5_COMPLETE_WITH_SUBBUILDING(String building5_COMPLETE_WITH_SUBBUILDING) {
		this.building5_COMPLETE_WITH_SUBBUILDING = building5_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding5_NAME() {
		return building5_NAME;
	}

	public void setBuilding5_NAME(String building5_NAME) {
		this.building5_NAME = building5_NAME;
	}

	public String getBuilding5_NUMBER() {
		return building5_NUMBER;
	}

	public void setBuilding5_NUMBER(String building5_NUMBER) {
		this.building5_NUMBER = building5_NUMBER;
	}

	public String getBuilding5_DESCRIPTOR() {
		return building5_DESCRIPTOR;
	}

	public void setBuilding5_DESCRIPTOR(String building5_DESCRIPTOR) {
		this.building5_DESCRIPTOR = building5_DESCRIPTOR;
	}

	public String getBuilding6_COMPLETE_WITH_SUBBUILDING() {
		return building6_COMPLETE_WITH_SUBBUILDING;
	}

	public void setBuilding6_COMPLETE_WITH_SUBBUILDING(String building6_COMPLETE_WITH_SUBBUILDING) {
		this.building6_COMPLETE_WITH_SUBBUILDING = building6_COMPLETE_WITH_SUBBUILDING;
	}

	public String getBuilding6_NAME() {
		return building6_NAME;
	}

	public void setBuilding6_NAME(String building6_NAME) {
		this.building6_NAME = building6_NAME;
	}

	public String getBuilding6_NUMBER() {
		return building6_NUMBER;
	}

	public void setBuilding6_NUMBER(String building6_NUMBER) {
		this.building6_NUMBER = building6_NUMBER;
	}

	public String getBuilding6_DESCRIPTOR() {
		return building6_DESCRIPTOR;
	}

	public void setBuilding6_DESCRIPTOR(String building6_DESCRIPTOR) {
		this.building6_DESCRIPTOR = building6_DESCRIPTOR;
	}

	public String getSubBuilding1_NAME() {
		return subBuilding1_NAME;
	}

	public void setSubBuilding1_NAME(String subBuilding1_NAME) {
		this.subBuilding1_NAME = subBuilding1_NAME;
	}

	public String getSubBuilding1_NUMBER() {
		return subBuilding1_NUMBER;
	}

	public void setSubBuilding1_NUMBER(String subBuilding1_NUMBER) {
		this.subBuilding1_NUMBER = subBuilding1_NUMBER;
	}

	public String getSubBuilding1_DESCRIPTOR() {
		return subBuilding1_DESCRIPTOR;
	}

	public void setSubBuilding1_DESCRIPTOR(String subBuilding1_DESCRIPTOR) {
		this.subBuilding1_DESCRIPTOR = subBuilding1_DESCRIPTOR;
	}

	public String getSubBuilding2_NAME() {
		return subBuilding2_NAME;
	}

	public void setSubBuilding2_NAME(String subBuilding2_NAME) {
		this.subBuilding2_NAME = subBuilding2_NAME;
	}

	public String getSubBuilding2_NUMBER() {
		return subBuilding2_NUMBER;
	}

	public void setSubBuilding2_NUMBER(String subBuilding2_NUMBER) {
		this.subBuilding2_NUMBER = subBuilding2_NUMBER;
	}

	public String getSubBuilding2_DESCRIPTOR() {
		return subBuilding2_DESCRIPTOR;
	}

	public void setSubBuilding2_DESCRIPTOR(String subBuilding2_DESCRIPTOR) {
		this.subBuilding2_DESCRIPTOR = subBuilding2_DESCRIPTOR;
	}

	public String getSubBuilding3_NAME() {
		return subBuilding3_NAME;
	}

	public void setSubBuilding3_NAME(String subBuilding3_NAME) {
		this.subBuilding3_NAME = subBuilding3_NAME;
	}

	public String getSubBuilding3_NUMBER() {
		return subBuilding3_NUMBER;
	}

	public void setSubBuilding3_NUMBER(String subBuilding3_NUMBER) {
		this.subBuilding3_NUMBER = subBuilding3_NUMBER;
	}

	public String getSubBuilding3_DESCRIPTOR() {
		return subBuilding3_DESCRIPTOR;
	}

	public void setSubBuilding3_DESCRIPTOR(String subBuilding3_DESCRIPTOR) {
		this.subBuilding3_DESCRIPTOR = subBuilding3_DESCRIPTOR;
	}

	public String getSubBuilding4_NAME() {
		return subBuilding4_NAME;
	}

	public void setSubBuilding4_NAME(String subBuilding4_NAME) {
		this.subBuilding4_NAME = subBuilding4_NAME;
	}

	public String getSubBuilding4_NUMBER() {
		return subBuilding4_NUMBER;
	}

	public void setSubBuilding4_NUMBER(String subBuilding4_NUMBER) {
		this.subBuilding4_NUMBER = subBuilding4_NUMBER;
	}

	public String getSubBuilding4_DESCRIPTOR() {
		return subBuilding4_DESCRIPTOR;
	}

	public void setSubBuilding4_DESCRIPTOR(String subBuilding4_DESCRIPTOR) {
		this.subBuilding4_DESCRIPTOR = subBuilding4_DESCRIPTOR;
	}

	public String getSubBuilding5_NAME() {
		return subBuilding5_NAME;
	}

	public void setSubBuilding5_NAME(String subBuilding5_NAME) {
		this.subBuilding5_NAME = subBuilding5_NAME;
	}

	public String getSubBuilding5_NUMBER() {
		return subBuilding5_NUMBER;
	}

	public void setSubBuilding5_NUMBER(String subBuilding5_NUMBER) {
		this.subBuilding5_NUMBER = subBuilding5_NUMBER;
	}

	public String getSubBuilding5_DESCRIPTOR() {
		return subBuilding5_DESCRIPTOR;
	}

	public void setSubBuilding5_DESCRIPTOR(String subBuilding5_DESCRIPTOR) {
		this.subBuilding5_DESCRIPTOR = subBuilding5_DESCRIPTOR;
	}

	public String getSubBuilding6_NAME() {
		return subBuilding6_NAME;
	}

	public void setSubBuilding6_NAME(String subBuilding6_NAME) {
		this.subBuilding6_NAME = subBuilding6_NAME;
	}

	public String getSubBuilding6_NUMBER() {
		return subBuilding6_NUMBER;
	}

	public void setSubBuilding6_NUMBER(String subBuilding6_NUMBER) {
		this.subBuilding6_NUMBER = subBuilding6_NUMBER;
	}

	public String getSubBuilding6_DESCRIPTOR() {
		return subBuilding6_DESCRIPTOR;
	}

	public void setSubBuilding6_DESCRIPTOR(String subBuilding6_DESCRIPTOR) {
		this.subBuilding6_DESCRIPTOR = subBuilding6_DESCRIPTOR;
	}

	public String getDeliveryService1_DESCRIPTOR() {
		return deliveryService1_DESCRIPTOR;
	}

	public void setDeliveryService1_DESCRIPTOR(String deliveryService1_DESCRIPTOR) {
		this.deliveryService1_DESCRIPTOR = deliveryService1_DESCRIPTOR;
	}

	public String getDeliveryService1_NUMBER() {
		return deliveryService1_NUMBER;
	}

	public void setDeliveryService1_NUMBER(String deliveryService1_NUMBER) {
		this.deliveryService1_NUMBER = deliveryService1_NUMBER;
	}

	public String getDeliveryService1_ADD_INFO() {
		return deliveryService1_ADD_INFO;
	}

	public void setDeliveryService1_ADD_INFO(String deliveryService1_ADD_INFO) {
		this.deliveryService1_ADD_INFO = deliveryService1_ADD_INFO;
	}

	public String getDeliveryService2_DESCRIPTOR() {
		return deliveryService2_DESCRIPTOR;
	}

	public void setDeliveryService2_DESCRIPTOR(String deliveryService2_DESCRIPTOR) {
		this.deliveryService2_DESCRIPTOR = deliveryService2_DESCRIPTOR;
	}

	public String getDeliveryService2_NUMBER() {
		return deliveryService2_NUMBER;
	}

	public void setDeliveryService2_NUMBER(String deliveryService2_NUMBER) {
		this.deliveryService2_NUMBER = deliveryService2_NUMBER;
	}

	public String getDeliveryService2_ADD_INFO() {
		return deliveryService2_ADD_INFO;
	}

	public void setDeliveryService2_ADD_INFO(String deliveryService2_ADD_INFO) {
		this.deliveryService2_ADD_INFO = deliveryService2_ADD_INFO;
	}

	public String getDeliveryService3_DESCRIPTOR() {
		return deliveryService3_DESCRIPTOR;
	}

	public void setDeliveryService3_DESCRIPTOR(String deliveryService3_DESCRIPTOR) {
		this.deliveryService3_DESCRIPTOR = deliveryService3_DESCRIPTOR;
	}

	public String getDeliveryService3_NUMBER() {
		return deliveryService3_NUMBER;
	}

	public void setDeliveryService3_NUMBER(String deliveryService3_NUMBER) {
		this.deliveryService3_NUMBER = deliveryService3_NUMBER;
	}

	public String getDeliveryService3_ADD_INFO() {
		return deliveryService3_ADD_INFO;
	}

	public void setDeliveryService3_ADD_INFO(String deliveryService3_ADD_INFO) {
		this.deliveryService3_ADD_INFO = deliveryService3_ADD_INFO;
	}

	public String getOrganization1_NAME() {
		return organization1_NAME;
	}

	public void setOrganization1_NAME(String organization1_NAME) {
		this.organization1_NAME = organization1_NAME;
	}

	public String getOrganization1_DESCRIPTOR() {
		return organization1_DESCRIPTOR;
	}

	public void setOrganization1_DESCRIPTOR(String organization1_DESCRIPTOR) {
		this.organization1_DESCRIPTOR = organization1_DESCRIPTOR;
	}

	public String getOrganization1_DEPARTMENT() {
		return organization1_DEPARTMENT;
	}

	public void setOrganization1_DEPARTMENT(String organization1_DEPARTMENT) {
		this.organization1_DEPARTMENT = organization1_DEPARTMENT;
	}

	public String getOrganization2_NAME() {
		return organization2_NAME;
	}

	public void setOrganization2_NAME(String organization2_NAME) {
		this.organization2_NAME = organization2_NAME;
	}

	public String getOrganization2_DESCRIPTOR() {
		return organization2_DESCRIPTOR;
	}

	public void setOrganization2_DESCRIPTOR(String organization2_DESCRIPTOR) {
		this.organization2_DESCRIPTOR = organization2_DESCRIPTOR;
	}

	public String getOrganization2_DEPARTMENT() {
		return organization2_DEPARTMENT;
	}

	public void setOrganization2_DEPARTMENT(String organization2_DEPARTMENT) {
		this.organization2_DEPARTMENT = organization2_DEPARTMENT;
	}

	public String getOrganization3_NAME() {
		return organization3_NAME;
	}

	public void setOrganization3_NAME(String organization3_NAME) {
		this.organization3_NAME = organization3_NAME;
	}

	public String getOrganization3_DESCRIPTOR() {
		return organization3_DESCRIPTOR;
	}

	public void setOrganization3_DESCRIPTOR(String organization3_DESCRIPTOR) {
		this.organization3_DESCRIPTOR = organization3_DESCRIPTOR;
	}

	public String getOrganization3_DEPARTMENT() {
		return organization3_DEPARTMENT;
	}

	public void setOrganization3_DEPARTMENT(String organization3_DEPARTMENT) {
		this.organization3_DEPARTMENT = organization3_DEPARTMENT;
	}

	public String getContact1_FIRST_NAME() {
		return contact1_FIRST_NAME;
	}

	public void setContact1_FIRST_NAME(String contact1_FIRST_NAME) {
		this.contact1_FIRST_NAME = contact1_FIRST_NAME;
	}

	public String getContact1_MIDDLE_NAME() {
		return contact1_MIDDLE_NAME;
	}

	public void setContact1_MIDDLE_NAME(String contact1_MIDDLE_NAME) {
		this.contact1_MIDDLE_NAME = contact1_MIDDLE_NAME;
	}

	public String getContact1_LAST_NAME() {
		return contact1_LAST_NAME;
	}

	public void setContact1_LAST_NAME(String contact1_LAST_NAME) {
		this.contact1_LAST_NAME = contact1_LAST_NAME;
	}

	public String getContact1_NAME() {
		return contact1_NAME;
	}

	public void setContact1_NAME(String contact1_NAME) {
		this.contact1_NAME = contact1_NAME;
	}

	public String getContact1_TITLE() {
		return contact1_TITLE;
	}

	public void setContact1_TITLE(String contact1_TITLE) {
		this.contact1_TITLE = contact1_TITLE;
	}

	public String getContact1_FUNCTION() {
		return contact1_FUNCTION;
	}

	public void setContact1_FUNCTION(String contact1_FUNCTION) {
		this.contact1_FUNCTION = contact1_FUNCTION;
	}

	public String getContact1_SALUTATION() {
		return contact1_SALUTATION;
	}

	public void setContact1_SALUTATION(String contact1_SALUTATION) {
		this.contact1_SALUTATION = contact1_SALUTATION;
	}

	public String getContact1_GENDER() {
		return contact1_GENDER;
	}

	public void setContact1_GENDER(String contact1_GENDER) {
		this.contact1_GENDER = contact1_GENDER;
	}

	public String getContact2_FIRST_NAME() {
		return contact2_FIRST_NAME;
	}

	public void setContact2_FIRST_NAME(String contact2_FIRST_NAME) {
		this.contact2_FIRST_NAME = contact2_FIRST_NAME;
	}

	public String getContact2_MIDDLE_NAME() {
		return contact2_MIDDLE_NAME;
	}

	public void setContact2_MIDDLE_NAME(String contact2_MIDDLE_NAME) {
		this.contact2_MIDDLE_NAME = contact2_MIDDLE_NAME;
	}

	public String getContact2_LAST_NAME() {
		return contact2_LAST_NAME;
	}

	public void setContact2_LAST_NAME(String contact2_LAST_NAME) {
		this.contact2_LAST_NAME = contact2_LAST_NAME;
	}

	public String getContact2_NAME() {
		return contact2_NAME;
	}

	public void setContact2_NAME(String contact2_NAME) {
		this.contact2_NAME = contact2_NAME;
	}

	public String getContact2_TITLE() {
		return contact2_TITLE;
	}

	public void setContact2_TITLE(String contact2_TITLE) {
		this.contact2_TITLE = contact2_TITLE;
	}

	public String getContact2_FUNCTION() {
		return contact2_FUNCTION;
	}

	public void setContact2_FUNCTION(String contact2_FUNCTION) {
		this.contact2_FUNCTION = contact2_FUNCTION;
	}

	public String getContact2_SALUTATION() {
		return contact2_SALUTATION;
	}

	public void setContact2_SALUTATION(String contact2_SALUTATION) {
		this.contact2_SALUTATION = contact2_SALUTATION;
	}

	public String getContact2_GENDER() {
		return contact2_GENDER;
	}

	public void setContact2_GENDER(String contact2_GENDER) {
		this.contact2_GENDER = contact2_GENDER;
	}

	public String getContact3_FIRST_NAME() {
		return contact3_FIRST_NAME;
	}

	public void setContact3_FIRST_NAME(String contact3_FIRST_NAME) {
		this.contact3_FIRST_NAME = contact3_FIRST_NAME;
	}

	public String getContact3_MIDDLE_NAME() {
		return contact3_MIDDLE_NAME;
	}

	public void setContact3_MIDDLE_NAME(String contact3_MIDDLE_NAME) {
		this.contact3_MIDDLE_NAME = contact3_MIDDLE_NAME;
	}

	public String getContact3_LAST_NAME() {
		return contact3_LAST_NAME;
	}

	public void setContact3_LAST_NAME(String contact3_LAST_NAME) {
		this.contact3_LAST_NAME = contact3_LAST_NAME;
	}

	public String getContact3_NAME() {
		return contact3_NAME;
	}

	public void setContact3_NAME(String contact3_NAME) {
		this.contact3_NAME = contact3_NAME;
	}

	public String getContact3_TITLE() {
		return contact3_TITLE;
	}

	public void setContact3_TITLE(String contact3_TITLE) {
		this.contact3_TITLE = contact3_TITLE;
	}

	public String getContact3_FUNCTION() {
		return contact3_FUNCTION;
	}

	public void setContact3_FUNCTION(String contact3_FUNCTION) {
		this.contact3_FUNCTION = contact3_FUNCTION;
	}

	public String getContact3_SALUTATION() {
		return contact3_SALUTATION;
	}

	public void setContact3_SALUTATION(String contact3_SALUTATION) {
		this.contact3_SALUTATION = contact3_SALUTATION;
	}

	public String getContact3_GENDER() {
		return contact3_GENDER;
	}

	public void setContact3_GENDER(String contact3_GENDER) {
		this.contact3_GENDER = contact3_GENDER;
	}

	public String getResidue1_NECESSARY() {
		return residue1_NECESSARY;
	}

	public void setResidue1_NECESSARY(String residue1_NECESSARY) {
		this.residue1_NECESSARY = residue1_NECESSARY;
	}

	public String getResidue1_SUPERFLUOUS() {
		return residue1_SUPERFLUOUS;
	}

	public void setResidue1_SUPERFLUOUS(String residue1_SUPERFLUOUS) {
		this.residue1_SUPERFLUOUS = residue1_SUPERFLUOUS;
	}

	public String getResidue2_NECESSARY() {
		return residue2_NECESSARY;
	}

	public void setResidue2_NECESSARY(String residue2_NECESSARY) {
		this.residue2_NECESSARY = residue2_NECESSARY;
	}

	public String getResidue2_SUPERFLUOUS() {
		return residue2_SUPERFLUOUS;
	}

	public void setResidue2_SUPERFLUOUS(String residue2_SUPERFLUOUS) {
		this.residue2_SUPERFLUOUS = residue2_SUPERFLUOUS;
	}

	public String getResidue3_NECESSARY() {
		return residue3_NECESSARY;
	}

	public void setResidue3_NECESSARY(String residue3_NECESSARY) {
		this.residue3_NECESSARY = residue3_NECESSARY;
	}

	public String getResidue3_SUPERFLUOUS() {
		return residue3_SUPERFLUOUS;
	}

	public void setResidue3_SUPERFLUOUS(String residue3_SUPERFLUOUS) {
		this.residue3_SUPERFLUOUS = residue3_SUPERFLUOUS;
	}

	public String getResidue4_NECESSARY() {
		return residue4_NECESSARY;
	}

	public void setResidue4_NECESSARY(String residue4_NECESSARY) {
		this.residue4_NECESSARY = residue4_NECESSARY;
	}

	public String getResidue4_SUPERFLUOUS() {
		return residue4_SUPERFLUOUS;
	}

	public void setResidue4_SUPERFLUOUS(String residue4_SUPERFLUOUS) {
		this.residue4_SUPERFLUOUS = residue4_SUPERFLUOUS;
	}

	public String getResidue5_NECESSARY() {
		return residue5_NECESSARY;
	}

	public void setResidue5_NECESSARY(String residue5_NECESSARY) {
		this.residue5_NECESSARY = residue5_NECESSARY;
	}

	public String getResidue5_SUPERFLUOUS() {
		return residue5_SUPERFLUOUS;
	}

	public void setResidue5_SUPERFLUOUS(String residue5_SUPERFLUOUS) {
		this.residue5_SUPERFLUOUS = residue5_SUPERFLUOUS;
	}

	public String getResidue6_NECESSARY() {
		return residue6_NECESSARY;
	}

	public void setResidue6_NECESSARY(String residue6_NECESSARY) {
		this.residue6_NECESSARY = residue6_NECESSARY;
	}

	public String getResidue6_SUPERFLUOUS() {
		return residue6_SUPERFLUOUS;
	}

	public void setResidue6_SUPERFLUOUS(String residue6_SUPERFLUOUS) {
		this.residue6_SUPERFLUOUS = residue6_SUPERFLUOUS;
	}

	public void getMethodWithSameSuffix(String prefix, OutputRecord outputRecord, List<AddressElement> list, String type) {
		int num = 1;
		for (AddressElement element : list) {
			if (type.equals(element.getType())) {
				String methodName = "set" + prefix + num + "_" + type;
				setMethodValue(outputRecord, element.getValue(), methodName);
				num++;
			}
		}
	}

	public void getMethodWithDiffLine(String prefix, OutputRecord outputRecord, List<String> list) {
		int num = 1;
		for (String element : list) {
			String methodName = "set" + prefix + "_" + num;
			setMethodValue(outputRecord, element, methodName);
			num++;
		}
	}

	private void setMethodValue(OutputRecord outputRecord, String value, String methodName) {
		Class<? extends OutputRecord> clazz = outputRecord.getClass();
		Method method;
		try {
			method = clazz.getDeclaredMethod(methodName, String.class);
			method.invoke(outputRecord, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
