package com.hp.it.match.batch.AddressFindExcel.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * An AddressInput object mapped with a record from an input excel file.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class AddressInput {
	private final Logger logger = LoggerFactory.getLogger(AddressInput.class);

	private String key1;
	private String key2;
	private String key3;
	private String modeUsed;
	private String preferredLanguage;
	private String preferredScript;
	private String characterScriptDetectionIndicator;
	private String country1;
	private String country2;
	private String country3;
	private String addressComplete;
	private String building1;
	private String building2;
	private String building3;
	private String building4;
	private String building5;
	private String building6;
	private String locality1;
	private String locality2;
	private String locality3;
	private String locality4;
	private String locality5;
	private String locality6;
	private String postalCode1;
	private String postalCode2;
	private String postalCode3;
	private String countrySpecificLocalityLine1;
	private String countrySpecificLocalityLine2;
	private String countrySpecificLocalityLine3;
	private String countrySpecificLocalityLine4;
	private String countrySpecificLocalityLine5;
	private String countrySpecificLocalityLine6;
	private String street1;
	private String street2;
	private String street3;
	private String street4;
	private String street5;
	private String street6;
	private String number1;
	private String number2;
	private String number3;
	private String number4;
	private String number5;
	private String number6;
	private String province1;
	private String province2;
	private String province3;
	private String province4;
	private String province5;
	private String province6;
	private String deliveryAddressLine1;
	private String deliveryAddressLine2;
	private String deliveryAddressLine3;
	private String deliveryAddressLine4;
	private String deliveryAddressLine5;
	private String deliveryAddressLine6;
	private String deliveryService1;
	private String deliveryService2;
	private String deliveryService3;
	private String deliveryService4;
	private String deliveryService5;
	private String deliveryService6;
	private String formattedAddressLine1;
	private String formattedAddressLine2;
	private String formattedAddressLine3;
	private String formattedAddressLine4;
	private String formattedAddressLine5;
	private String formattedAddressLine6;
	private String formattedAddressLine7;
	private String formattedAddressLine8;
	private String formattedAddressLine9;
	private String formattedAddressLine10;
	private String formattedAddressLine11;
	private String formattedAddressLine12;
	private String formattedAddressLine13;
	private String formattedAddressLine14;
	private String formattedAddressLine15;
	private String formattedAddressLine16;
	private String formattedAddressLine17;
	private String formattedAddressLine18;
	private String formattedAddressLine19;
	private String organization1;
	private String organization2;
	private String organization3;
	private String contact1;
	private String contact2;
	private String contact3;
	private String recipientLine1;
	private String recipientLine2;
	private String recipientLine3;
	private String residue1;
	private String residue2;
	private String residue3;
	private String residue4;
	private String residue5;
	private String residue6;
	private String subBuilding1;
	private String subBuilding2;
	private String subBuilding3;
	private String subBuilding4;
	private String subBuilding5;
	private String subBuilding6;

	private static Map<String, Method> fieldMethodsMap = new HashMap<String, Method>();
	
	/**
	 * Get the value of column key1.
	 * 
	 * @return key1
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * Set the value of column key1.
	 * 
	 * @param key1
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * Get the value of column key2.
	 * 
	 * @return key2
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * Set the value of column key2.
	 * 
	 * @param key2
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * Get the value of column key3.
	 * 
	 * @return key3
	 */
	public String getKey3() {
		return key3;
	}

	/**
	 * Set the value of column key3.
	 * 
	 * @param key3
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}

	/**
	 * Get the value of column modeUsed.
	 * 
	 * @return modeUsed
	 */
	public String getModeUsed() {
		return modeUsed;
	}

	/**
	 * Set the value of column modeUsed.
	 * 
	 * @param modeUsed
	 */
	public void setModeUsed(String modeUsed) {
		this.modeUsed = modeUsed;
	}

	/**
	 * Get the value of column preferredLanguage.
	 * 
	 * @return preferredLanguage
	 */
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	/**
	 * Set the value of column preferredLanguage.
	 * 
	 * @param preferredLanguage
	 */
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	/**
	 * Get the value of column preferredScript.
	 * 
	 * @return preferredScript
	 */
	public String getPreferredScript() {
		return preferredScript;
	}

	/**
	 * Set the value of column preferredScript.
	 * 
	 * @param preferredScript
	 */
	public void setPreferredScript(String preferredScript) {
		this.preferredScript = preferredScript;
	}

	/**
	 * Get the value of column characterScriptDetectionIndicator.
	 * 
	 * @return characterScriptDetectionIndicator
	 */
	public String getCharacterScriptDetectionIndicator() {
		return characterScriptDetectionIndicator;
	}

	/**
	 * Set the value of column characterScriptDetectionIndicator.
	 * 
	 * @param characterScriptDetectionIndicator
	 */
	public void setCharacterScriptDetectionIndicator(String characterScriptDetectionIndicator) {
		this.characterScriptDetectionIndicator = characterScriptDetectionIndicator;
	}

	/**
	 * Get the value of column country1.
	 * 
	 * @return country1
	 */
	public String getCountry1() {
		return country1;
	}

	/**
	 * Set the value of column country1.
	 * 
	 * @param country1
	 */
	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	/**
	 * Get the value of column country2.
	 * 
	 * @return country2
	 */
	public String getCountry2() {
		return country2;
	}

	/**
	 * Set the value of column country2.
	 * 
	 * @param country2
	 */
	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	/**
	 * Get the value of column country3.
	 * 
	 * @return country3
	 */
	public String getCountry3() {
		return country3;
	}

	/**
	 * Set the value of column country3.
	 * 
	 * @param country3
	 */
	public void setCountry3(String country3) {
		this.country3 = country3;
	}

	/**
	 * Get the value of column addressComplete.
	 * 
	 * @return addressComplete
	 */
	public String getAddressComplete() {
		return addressComplete;
	}

	/**
	 * Set the value of column addressComplete.
	 * 
	 * @param addressComplete
	 */
	public void setAddressComplete(String addressComplete) {
		this.addressComplete = addressComplete;
	}

	/**
	 * Get the value of column building1.
	 * 
	 * @return building1
	 */
	public String getBuilding1() {
		return building1;
	}

	/**
	 * Set the value of column building1.
	 * 
	 * @param building1
	 */
	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	/**
	 * Get the value of column building2.
	 * 
	 * @return building2
	 */
	public String getBuilding2() {
		return building2;
	}

	/**
	 * Set the value of column building2.
	 * 
	 * @param building2
	 */
	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	/**
	 * Get the value of column building3.
	 * 
	 * @return building3
	 */
	public String getBuilding3() {
		return building3;
	}

	/**
	 * Set the value of column building3.
	 * 
	 * @return building3
	 */
	public void setBuilding3(String building3) {
		this.building3 = building3;
	}

	/**
	 * Get the value of column building4.
	 * 
	 * @return building4
	 */
	public String getBuilding4() {
		return building4;
	}

	/**
	 * Set the value of column building4.
	 * 
	 * @param building4
	 */
	public void setBuilding4(String building4) {
		this.building4 = building4;
	}

	/**
	 * Get the value of column building5.
	 * 
	 * @return building5
	 */
	public String getBuilding5() {
		return building5;
	}

	/**
	 * Set the value of column building5.
	 * 
	 * @param building5
	 */
	public void setBuilding5(String building5) {
		this.building5 = building5;
	}

	/**
	 * Get the value of column building6.
	 * 
	 * @return building6
	 */
	public String getBuilding6() {
		return building6;
	}

	/**
	 * Set the value of column building6.
	 * 
	 * @param building6
	 */
	public void setBuilding6(String building6) {
		this.building6 = building6;
	}

	/**
	 * Get the value of column locality1.
	 * 
	 * @return locality1
	 */
	public String getLocality1() {
		return locality1;
	}

	/**
	 * Set the value of column locality1.
	 * 
	 * @param locality1
	 */
	public void setLocality1(String locality1) {
		this.locality1 = locality1;
	}

	/**
	 * Get the value of column locality2.
	 * 
	 * @return locality2
	 */
	public String getLocality2() {
		return locality2;
	}

	/**
	 * Set the value of column locality2.
	 * 
	 * @param locality2
	 */
	public void setLocality2(String locality2) {
		this.locality2 = locality2;
	}

	/**
	 * Get the value of column locality3.
	 * 
	 * @return locality3
	 */
	public String getLocality3() {
		return locality3;
	}

	/**
	 * Set the value of column locality3.
	 * 
	 * @param locality3
	 */
	public void setLocality3(String locality3) {
		this.locality3 = locality3;
	}

	/**
	 * Get the value of column locality4.
	 * 
	 * @return locality4
	 */
	public String getLocality4() {
		return locality4;
	}

	/**
	 * Set the value of column of locality4.
	 * 
	 * @param locality4
	 */
	public void setLocality4(String locality4) {
		this.locality4 = locality4;
	}

	/**
	 * Get the value of column locality5.
	 * 
	 * @return locality5
	 */
	public String getLocality5() {
		return locality5;
	}

	/**
	 * Set the value of column locality5.
	 * 
	 * @param locality5
	 */
	public void setLocality5(String locality5) {
		this.locality5 = locality5;
	}

	/**
	 * Get the value of column locality6.
	 * 
	 * @return locality6
	 */
	public String getLocality6() {
		return locality6;
	}

	/**
	 * Set the value of column locality6.
	 * 
	 * @param locality6
	 */
	public void setLocality6(String locality6) {
		this.locality6 = locality6;
	}

	/**
	 * Get the value of column postalCode1.
	 * 
	 * @return postalCode1
	 */
	public String getPostalCode1() {
		return postalCode1;
	}

	/**
	 * Set the value of column postalCode1.
	 * 
	 * @param postalCode1
	 */
	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	/**
	 * Get the value of column postalCode2.
	 * 
	 * @return postalCode2
	 */
	public String getPostalCode2() {
		return postalCode2;
	}

	/**
	 * Set the value of column postalCode2
	 * 
	 * @param postalCode2
	 */
	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	/**
	 * Get the value of column postalCode3.
	 * 
	 * @return postalCode3
	 */
	public String getPostalCode3() {
		return postalCode3;
	}

	/**
	 * Set the value of column postalCode3
	 * 
	 * @param postalCode3
	 */
	public void setPostalCode3(String postalCode3) {
		this.postalCode3 = postalCode3;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine1.
	 * 
	 * @return countrySpecificLocalityLine1
	 */
	public String getCountrySpecificLocalityLine1() {
		return countrySpecificLocalityLine1;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine1.
	 * 
	 * @param countrySpecificLocalityLine1
	 */
	public void setCountrySpecificLocalityLine1(String countrySpecificLocalityLine1) {
		this.countrySpecificLocalityLine1 = countrySpecificLocalityLine1;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine2.
	 * 
	 * @return countrySpecificLocalityLine2
	 */
	public String getCountrySpecificLocalityLine2() {
		return countrySpecificLocalityLine2;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine2.
	 * 
	 * @param countrySpecificLocalityLine2
	 */
	public void setCountrySpecificLocalityLine2(String countrySpecificLocalityLine2) {
		this.countrySpecificLocalityLine2 = countrySpecificLocalityLine2;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine3.
	 * 
	 * @return countrySpecificLocalityLine3
	 */
	public String getCountrySpecificLocalityLine3() {
		return countrySpecificLocalityLine3;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine3.
	 * 
	 * @param countrySpecificLocalityLine3
	 */
	public void setCountrySpecificLocalityLine3(String countrySpecificLocalityLine3) {
		this.countrySpecificLocalityLine3 = countrySpecificLocalityLine3;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine4.
	 * 
	 * @return countrySpecificLocalityLine4
	 */
	public String getCountrySpecificLocalityLine4() {
		return countrySpecificLocalityLine4;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine4.
	 * 
	 * @param countrySpecificLocalityLine4
	 */
	public void setCountrySpecificLocalityLine4(String countrySpecificLocalityLine4) {
		this.countrySpecificLocalityLine4 = countrySpecificLocalityLine4;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine5.
	 * 
	 * @return countrySpecificLocalityLine5
	 */
	public String getCountrySpecificLocalityLine5() {
		return countrySpecificLocalityLine5;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine5
	 * 
	 * @param countrySpecificLocalityLine5
	 */
	public void setCountrySpecificLocalityLine5(String countrySpecificLocalityLine5) {
		this.countrySpecificLocalityLine5 = countrySpecificLocalityLine5;
	}

	/**
	 * Get the value of column countrySpecificLocalityLine6.
	 * 
	 * @return countrySpecificLocalityLine6
	 */
	public String getCountrySpecificLocalityLine6() {
		return countrySpecificLocalityLine6;
	}

	/**
	 * Set the value of column countrySpecificLocalityLine6.
	 * 
	 * @param countrySpecificLocalityLine6
	 */
	public void setCountrySpecificLocalityLine6(String countrySpecificLocalityLine6) {
		this.countrySpecificLocalityLine6 = countrySpecificLocalityLine6;
	}

	/**
	 * Get the value of column street1.
	 * 
	 * @return street1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Set the value of column street1.
	 * 
	 * @param street1
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Get the value of column street2.
	 * 
	 * @return street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * Set the value of street2.
	 * 
	 * @param street2
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * Get the value of column street3.
	 * 
	 * @return street3
	 */
	public String getStreet3() {
		return street3;
	}

	/**
	 * Set the value of column street3.
	 * 
	 * @param street3
	 */
	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	/**
	 * Get the value of column street4.
	 * 
	 * @return street4
	 */
	public String getStreet4() {
		return street4;
	}

	/**
	 * Set the value of column street4.
	 * 
	 * @param street4
	 */
	public void setStreet4(String street4) {
		this.street4 = street4;
	}

	/**
	 * Get the value of column street5.
	 * 
	 * @return street5
	 */
	public String getStreet5() {
		return street5;
	}

	/**
	 * Set the value of column street5.
	 * 
	 * @param street5
	 */
	public void setStreet5(String street5) {
		this.street5 = street5;
	}

	/**
	 * Get the value of column street6.
	 * 
	 * @return street6
	 */
	public String getStreet6() {
		return street6;
	}

	/**
	 * Set the value of column street6.
	 * 
	 * @param street6
	 */
	public void setStreet6(String street6) {
		this.street6 = street6;
	}

	/**
	 * Get the value of column number1.
	 * 
	 * @return number1
	 */
	public String getNumber1() {
		return number1;
	}

	/**
	 * Set the value of column number1.
	 * 
	 * @param number1
	 */
	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	/**
	 * Get the value of column number2.
	 * 
	 * @return number2
	 */
	public String getNumber2() {
		return number2;
	}

	/**
	 * Set the value of column number2.
	 * 
	 * @param number2
	 */
	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	/**
	 * Get the value of column number3.
	 * 
	 * @return number3
	 */
	public String getNumber3() {
		return number3;
	}

	/**
	 * Set the value of column number3.
	 * 
	 * @param number3
	 */
	public void setNumber3(String number3) {
		this.number3 = number3;
	}

	/**
	 * Get the value of column number4.
	 * 
	 * @return number4.
	 */
	public String getNumber4() {
		return number4;
	}

	/**
	 * Set the value of column number4.
	 * 
	 * @param number4
	 */
	public void setNumber4(String number4) {
		this.number4 = number4;
	}

	/**
	 * Get the value of column number5.
	 * 
	 * @return number5
	 */
	public String getNumber5() {
		return number5;
	}

	/**
	 * Set the value of column number5.
	 * 
	 * @param number5
	 */
	public void setNumber5(String number5) {
		this.number5 = number5;
	}

	/**
	 * Get the value of column number6.
	 * 
	 * @return number6
	 */
	public String getNumber6() {
		return number6;
	}

	/**
	 * Set the value of column number6.
	 * 
	 * @param number6
	 */
	public void setNumber6(String number6) {
		this.number6 = number6;
	}

	/**
	 * Get the value of column province1.
	 * 
	 * @return province1
	 */
	public String getProvince1() {
		return province1;
	}

	/**
	 * Set the value of column province1.
	 * 
	 * @param province1
	 */
	public void setProvince1(String province1) {
		this.province1 = province1;
	}

	/**
	 * Get the value of column province2.
	 * 
	 * @return province2
	 */
	public String getProvince2() {
		return province2;
	}

	/**
	 * Set the value of column province2.
	 * 
	 * @param province2
	 */
	public void setProvince2(String province2) {
		this.province2 = province2;
	}

	/**
	 * Get the value of column province3.
	 * 
	 * @return province3.
	 */
	public String getProvince3() {
		return province3;
	}

	/**
	 * Set the value of column province3.
	 * 
	 * @param province3
	 */
	public void setProvince3(String province3) {
		this.province3 = province3;
	}

	/**
	 * Get the value of column province4.
	 * 
	 * @return province4
	 */
	public String getProvince4() {
		return province4;
	}

	/**
	 * Set the value of column province4.
	 * 
	 * @param province4
	 */
	public void setProvince4(String province4) {
		this.province4 = province4;
	}

	/**
	 * Get the value of column province5.
	 * 
	 * @return province5
	 */
	public String getProvince5() {
		return province5;
	}

	/**
	 * Set the value of column province5.
	 * 
	 * @param province5
	 */
	public void setProvince5(String province5) {
		this.province5 = province5;
	}

	/**
	 * Get the value of column province6.
	 * 
	 * @return province6
	 */
	public String getProvince6() {
		return province6;
	}

	/**
	 * Set the value of column province6.
	 * 
	 * @param province6
	 */
	public void setProvince6(String province6) {
		this.province6 = province6;
	}

	/**
	 * Get the value of column deliveryAddressLine1.
	 * 
	 * @return deliveryAddressLine1
	 */
	public String getDeliveryAddressLine1() {
		return deliveryAddressLine1;
	}

	/**
	 * Set the value of column deliveryAddressLine1.
	 * 
	 * @param deliveryAddressLine1
	 */
	public void setDeliveryAddressLine1(String deliveryAddressLine1) {
		this.deliveryAddressLine1 = deliveryAddressLine1;
	}

	/**
	 * Get the value of column deliveryAddressLine2.
	 * 
	 * @return deliveryAddressLine2
	 */
	public String getDeliveryAddressLine2() {
		return deliveryAddressLine2;
	}

	/**
	 * Set the value of column deliveryAddressLine2.
	 * 
	 * @param deliveryAddressLine2
	 */
	public void setDeliveryAddressLine2(String deliveryAddressLine2) {
		this.deliveryAddressLine2 = deliveryAddressLine2;
	}

	/**
	 * Get the value of column deliveryAddressLine3.
	 * 
	 * @return deliveryAddressLine2
	 */
	public String getDeliveryAddressLine3() {
		return deliveryAddressLine3;
	}

	/**
	 * Set the value of column deliveryAddressLine3.
	 * 
	 * @param deliveryAddressLine3
	 */
	public void setDeliveryAddressLine3(String deliveryAddressLine3) {
		this.deliveryAddressLine3 = deliveryAddressLine3;
	}

	/**
	 * Get the value of column deliveryAddressLine4.
	 * 
	 * @return deliveryAddressLine4
	 */
	public String getDeliveryAddressLine4() {
		return deliveryAddressLine4;
	}

	/**
	 * Set the value of column deliveryAddressLine4.
	 * 
	 * @param deliveryAddressLine4
	 */
	public void setDeliveryAddressLine4(String deliveryAddressLine4) {
		this.deliveryAddressLine4 = deliveryAddressLine4;
	}

	/**
	 * Get the value of column deliveryAddressLine5.
	 * 
	 * @return deliveryAddressLine5
	 */
	public String getDeliveryAddressLine5() {
		return deliveryAddressLine5;
	}

	/**
	 * Set the value of column deliveryAddressLine5.
	 * 
	 * @param deliveryAddressLine5
	 */
	public void setDeliveryAddressLine5(String deliveryAddressLine5) {
		this.deliveryAddressLine5 = deliveryAddressLine5;
	}

	/**
	 * Get the value of column deliveryAddressLine6.
	 * 
	 * @return deliveryAddressLine6
	 */
	public String getDeliveryAddressLine6() {
		return deliveryAddressLine6;
	}

	/**
	 * Set the value of column deliveryAddressLine6.
	 * 
	 * @param deliveryAddressLine6
	 */
	public void setDeliveryAddressLine6(String deliveryAddressLine6) {
		this.deliveryAddressLine6 = deliveryAddressLine6;
	}

	/**
	 * Get the value of column deliveryService1.
	 * 
	 * @return deliveryService1
	 */
	public String getDeliveryService1() {
		return deliveryService1;
	}

	/**
	 * Set the value of column deliveryService1.
	 * 
	 * @param deliveryService1
	 */
	public void setDeliveryService1(String deliveryService1) {
		this.deliveryService1 = deliveryService1;
	}

	/**
	 * Get the value of column deliveryService2.
	 * 
	 * @return deliveryService2
	 */
	public String getDeliveryService2() {
		return deliveryService2;
	}

	/**
	 * Set the value of column deliveryService2.
	 * 
	 * @param deliveryService2
	 */
	public void setDeliveryService2(String deliveryService2) {
		this.deliveryService2 = deliveryService2;
	}

	/**
	 * Get the value of column deliveryService3.
	 * 
	 * @return deliveryService3
	 */
	public String getDeliveryService3() {
		return deliveryService3;
	}

	/**
	 * Set the value of column deliveryService3.
	 * 
	 * @param deliveryService3
	 */
	public void setDeliveryService3(String deliveryService3) {
		this.deliveryService3 = deliveryService3;
	}

	/**
	 * Get the value of column deliveryService4.
	 * 
	 * @return deliveryService4
	 */
	public String getDeliveryService4() {
		return deliveryService4;
	}

	/**
	 * Set the value of column deliveryService4.
	 * 
	 * @param deliveryService4
	 */
	public void setDeliveryService4(String deliveryService4) {
		this.deliveryService4 = deliveryService4;
	}

	/**
	 * Get the value of column deliveryService5.
	 * 
	 * @return deliveryService5
	 */
	public String getDeliveryService5() {
		return deliveryService5;
	}

	/**
	 * Set the value of column deliveryService5.
	 * 
	 * @param deliveryService5
	 */
	public void setDeliveryService5(String deliveryService5) {
		this.deliveryService5 = deliveryService5;
	}

	/**
	 * Get the value of column deliveryService6.
	 * 
	 * @return deliveryService6
	 */
	public String getDeliveryService6() {
		return deliveryService6;
	}

	/**
	 * Set the value of column deliveryService6.
	 * 
	 * @param deliveryService6
	 */
	public void setDeliveryService6(String deliveryService6) {
		this.deliveryService6 = deliveryService6;
	}

	/**
	 * Get the value of column formattedAddressLine1.
	 * 
	 * @return formattedAddressLine1
	 */
	public String getFormattedAddressLine1() {
		return formattedAddressLine1;
	}

	/**
	 * Set the value of column formattedAddressLine1.
	 * 
	 * @param formattedAddressLine1
	 */
	public void setFormattedAddressLine1(String formattedAddressLine1) {
		this.formattedAddressLine1 = formattedAddressLine1;
	}

	/**
	 * Get the value of column formattedAddressLine2.
	 * 
	 * @return formattedAddressLine2
	 */
	public String getFormattedAddressLine2() {
		return formattedAddressLine2;
	}

	public void setFormattedAddressLine2(String formattedAddressLine2) {
		this.formattedAddressLine2 = formattedAddressLine2;
	}

	/**
	 * Get the value of column formattedAddressLine3.
	 * 
	 * @return formattedAddressLine3
	 */
	public String getFormattedAddressLine3() {
		return formattedAddressLine3;
	}

	/**
	 * Set the value of column formattedAddressLine3.
	 * 
	 * @param formattedAddressLine3
	 */
	public void setFormattedAddressLine3(String formattedAddressLine3) {
		this.formattedAddressLine3 = formattedAddressLine3;
	}

	/**
	 * Get the value of column formattedAddressLine4.
	 * 
	 * @return formattedAddressLine4
	 */
	public String getFormattedAddressLine4() {
		return formattedAddressLine4;
	}

	/**
	 * Set the value of column formattedAddressLine4.
	 * 
	 * @param formattedAddressLine4
	 */
	public void setFormattedAddressLine4(String formattedAddressLine4) {
		this.formattedAddressLine4 = formattedAddressLine4;
	}

	/**
	 * Get the value of column formattedAddressLine5.
	 * 
	 * @return formattedAddressLine5
	 */
	public String getFormattedAddressLine5() {
		return formattedAddressLine5;
	}

	/**
	 * Set the value of column formattedAddressLine5.
	 * 
	 * @param formattedAddressLine5
	 */
	public void setFormattedAddressLine5(String formattedAddressLine5) {
		this.formattedAddressLine5 = formattedAddressLine5;
	}

	/**
	 * Get the value of column formattedAddressLine6.
	 * 
	 * @return formattedAddressLine6
	 */
	public String getFormattedAddressLine6() {
		return formattedAddressLine6;
	}

	/**
	 * Set the value of column formattedAddressLine6.
	 * 
	 * @param formattedAddressLine6
	 */
	public void setFormattedAddressLine6(String formattedAddressLine6) {
		this.formattedAddressLine6 = formattedAddressLine6;
	}

	/**
	 * Get the value of column formattedAddressLine7.
	 * 
	 * @return formattedAddressLine7
	 */
	public String getFormattedAddressLine7() {
		return formattedAddressLine7;
	}

	/**
	 * Set the value of column formattedAddressLine7.
	 * 
	 * @param formattedAddressLine7
	 */
	public void setFormattedAddressLine7(String formattedAddressLine7) {
		this.formattedAddressLine7 = formattedAddressLine7;
	}

	/**
	 * Get the value of column formattedAddressLine8.
	 * 
	 * @return formattedAddressLine8.
	 */
	public String getFormattedAddressLine8() {
		return formattedAddressLine8;
	}

	/**
	 * Set the value of column formattedAddressLine8.
	 * 
	 * @param formattedAddressLine8
	 */
	public void setFormattedAddressLine8(String formattedAddressLine8) {
		this.formattedAddressLine8 = formattedAddressLine8;
	}

	/**
	 * Get the value of column formattedAddressLine9.
	 * 
	 * @return formattedAddressLine9
	 */
	public String getFormattedAddressLine9() {
		return formattedAddressLine9;
	}

	/**
	 * Set the value of column formattedAddressLine9.
	 * 
	 * @param formattedAddressLine9
	 */
	public void setFormattedAddressLine9(String formattedAddressLine9) {
		this.formattedAddressLine9 = formattedAddressLine9;
	}

	/**
	 * Get the value of column formattedAddressLine10.
	 * 
	 * @return formattedAddressLine10
	 */
	public String getFormattedAddressLine10() {
		return formattedAddressLine10;
	}

	/**
	 * Set the value of column formattedAddressLine10.
	 * 
	 * @param formattedAddressLine10
	 */
	public void setFormattedAddressLine10(String formattedAddressLine10) {
		this.formattedAddressLine10 = formattedAddressLine10;
	}

	/**
	 * Get the value of column formattedAddressLine11.
	 * 
	 * @return formattedAddressLine11
	 */
	public String getFormattedAddressLine11() {
		return formattedAddressLine11;
	}

	/**
	 * Set the value of column formattedAddressLine11.
	 * 
	 * @param formattedAddressLine11
	 */
	public void setFormattedAddressLine11(String formattedAddressLine11) {
		this.formattedAddressLine11 = formattedAddressLine11;
	}

	/**
	 * Get the value of column formattedAddressLine12.
	 * 
	 * @return formattedAddressLine12
	 */
	public String getFormattedAddressLine12() {
		return formattedAddressLine12;
	}

	/**
	 * Set the value of column formattedAddressLine12.
	 * 
	 * @param formattedAddressLine12
	 */
	public void setFormattedAddressLine12(String formattedAddressLine12) {
		this.formattedAddressLine12 = formattedAddressLine12;
	}

	/**
	 * Get the value of column formattedAddressLine13.
	 * 
	 * @return formattedAddressLine13
	 */
	public String getFormattedAddressLine13() {
		return formattedAddressLine13;
	}

	/**
	 * Set the value of column formattedAddressLine13.
	 * 
	 * @param formattedAddressLine13
	 */
	public void setFormattedAddressLine13(String formattedAddressLine13) {
		this.formattedAddressLine13 = formattedAddressLine13;
	}

	/**
	 * Get the value of column formattedAddressLine14.
	 * 
	 * @return formattedAddressLine14
	 */
	public String getFormattedAddressLine14() {
		return formattedAddressLine14;
	}

	/**
	 * Set the value of column formattedAddressLine14.
	 * 
	 * @param formattedAddressLine14
	 */
	public void setFormattedAddressLine14(String formattedAddressLine14) {
		this.formattedAddressLine14 = formattedAddressLine14;
	}

	/**
	 * Get the value of column formattedAddressLine15.
	 * 
	 * @return formattedAddressLine15
	 */
	public String getFormattedAddressLine15() {
		return formattedAddressLine15;
	}

	/**
	 * Set the value of column formattedAddressLine15.
	 * 
	 * @param formattedAddressLine15
	 */
	public void setFormattedAddressLine15(String formattedAddressLine15) {
		this.formattedAddressLine15 = formattedAddressLine15;
	}

	/**
	 * Get the value of column formattedAddressLine16.
	 * 
	 * @return formattedAddressLine16
	 */
	public String getFormattedAddressLine16() {
		return formattedAddressLine16;
	}

	/**
	 * Set the value of column formattedAddressLine16.
	 * 
	 * @param formattedAddressLine16
	 */
	public void setFormattedAddressLine16(String formattedAddressLine16) {
		this.formattedAddressLine16 = formattedAddressLine16;
	}

	/**
	 * Get the value of column formattedAddressLine17.
	 * 
	 * @return formattedAddressLine17
	 */
	public String getFormattedAddressLine17() {
		return formattedAddressLine17;
	}

	/**
	 * Set the value of column formattedAddressLine17.
	 * 
	 * @param formattedAddressLine17
	 */
	public void setFormattedAddressLine17(String formattedAddressLine17) {
		this.formattedAddressLine17 = formattedAddressLine17;
	}

	/**
	 * Get the value of column formattedAddressLine18.
	 * 
	 * @return formattedAddressLine18
	 */
	public String getFormattedAddressLine18() {
		return formattedAddressLine18;
	}

	/**
	 * Set the value of column formattedAddressLine18.
	 * 
	 * @param formattedAddressLine18
	 */
	public void setFormattedAddressLine18(String formattedAddressLine18) {
		this.formattedAddressLine18 = formattedAddressLine18;
	}

	/**
	 * Get the value of column formattedAddressLine19.
	 * 
	 * @return formattedAddressLine19
	 */
	public String getFormattedAddressLine19() {
		return formattedAddressLine19;
	}

	/**
	 * Set the value of column formattedAddressLine19.
	 * 
	 * @param formattedAddressLine19
	 */
	public void setFormattedAddressLine19(String formattedAddressLine19) {
		this.formattedAddressLine19 = formattedAddressLine19;
	}

	/**
	 * Get the value of column organization1.
	 * 
	 * @return organization1
	 */
	public String getOrganization1() {
		return organization1;
	}

	/**
	 * Set the value of column organization1.
	 * 
	 * @param organization1
	 */
	public void setOrganization1(String organization1) {
		this.organization1 = organization1;
	}

	/**
	 * Get the value of column organization2.
	 * 
	 * @return organization2.
	 */
	public String getOrganization2() {
		return organization2;
	}

	/**
	 * Set the value of column organization2.
	 * 
	 * @param organization2
	 */
	public void setOrganization2(String organization2) {
		this.organization2 = organization2;
	}

	/**
	 * Get the value of column organization3.
	 * 
	 * @return organization3
	 */
	public String getOrganization3() {
		return organization3;
	}

	/**
	 * Set the value of column organization3.
	 * 
	 * @param organization3
	 */
	public void setOrganization3(String organization3) {
		this.organization3 = organization3;
	}

	/**
	 * Get the value of column contact1.
	 * 
	 * @return contact1
	 */
	public String getContact1() {
		return contact1;
	}

	/**
	 * Set the value of column contact1.
	 * 
	 * @param contact1
	 */
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	/**
	 * Get the value of column contact2.
	 * 
	 * @return contact2.
	 */
	public String getContact2() {
		return contact2;
	}

	/**
	 * Set the value of column contact2.
	 * 
	 * @param contact2
	 */
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	/**
	 * Get the value of column contact3.
	 * 
	 * @return contact3
	 */
	public String getContact3() {
		return contact3;
	}

	/**
	 * Set the value of column contact3.
	 * 
	 * @param contact3
	 */
	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}

	/**
	 * Get the value of column recipientLine1.
	 * 
	 * @return recipientLine1
	 */
	public String getRecipientLine1() {
		return recipientLine1;
	}

	/**
	 * Set the value of column recipientLine1.
	 * 
	 * @param recipientLine1
	 */
	public void setRecipientLine1(String recipientLine1) {
		this.recipientLine1 = recipientLine1;
	}

	/**
	 * Get the value of column recipientLine2.
	 * 
	 * @return recipientLine2
	 */
	public String getRecipientLine2() {
		return recipientLine2;
	}

	/**
	 * Set the value of column recipientLine2
	 * 
	 * @param recipientLine2
	 */
	public void setRecipientLine2(String recipientLine2) {
		this.recipientLine2 = recipientLine2;
	}

	/**
	 * Get the value of column recipientLine3.
	 * 
	 * @return recipientLine3
	 */
	public String getRecipientLine3() {
		return recipientLine3;
	}

	/**
	 * Set the value of column recipientLine3.
	 * 
	 * @param recipientLine3
	 */
	public void setRecipientLine3(String recipientLine3) {
		this.recipientLine3 = recipientLine3;
	}

	/**
	 * Set the value of column residue1.
	 * 
	 * @return residue1.
	 */
	public String getResidue1() {
		return residue1;
	}

	/**
	 * Get the value of column residue1.
	 * 
	 * @param residue1
	 */
	public void setResidue1(String residue1) {
		this.residue1 = residue1;
	}

	/**
	 * Set the value of column residue2.
	 * 
	 * @return residue2
	 */
	public String getResidue2() {
		return residue2;
	}

	/**
	 * Set the value of column residue2.
	 * 
	 * @param residue2
	 */
	public void setResidue2(String residue2) {
		this.residue2 = residue2;
	}

	/**
	 * Get the value of column residue3.
	 * 
	 * @return residue3
	 */
	public String getResidue3() {
		return residue3;
	}

	/**
	 * Set the value of column residue3.
	 * 
	 * @param residue3
	 */
	public void setResidue3(String residue3) {
		this.residue3 = residue3;
	}

	/**
	 * Get the value of column residue4.
	 * 
	 * @return residue4
	 */
	public String getResidue4() {
		return residue4;
	}

	/**
	 * Set the value of column residue4.
	 * 
	 * @param residue4
	 */
	public void setResidue4(String residue4) {
		this.residue4 = residue4;
	}

	/**
	 * Get the value of column residue5.
	 * 
	 * @return residue5
	 */
	public String getResidue5() {
		return residue5;
	}

	/**
	 * Set the value of column residue5.
	 * 
	 * @param residue5
	 */
	public void setResidue5(String residue5) {
		this.residue5 = residue5;
	}

	/**
	 * Get the value of column residue6.
	 * 
	 * @return residue6
	 */
	public String getResidue6() {
		return residue6;
	}

	/**
	 * Set the value of column residue6.
	 * 
	 * @param residue6
	 */
	public void setResidue6(String residue6) {
		this.residue6 = residue6;
	}

	/**
	 * Get the value of column subBuilding1.
	 * 
	 * @return subBuilding1
	 */
	public String getSubBuilding1() {
		return subBuilding1;
	}

	/**
	 * Set the value of column subBuilding1.
	 * 
	 * @param subBuilding1
	 */
	public void setSubBuilding1(String subBuilding1) {
		this.subBuilding1 = subBuilding1;
	}

	/**
	 * Get the value of column subBuilding2.
	 * 
	 * @return subBuilding2
	 */
	public String getSubBuilding2() {
		return subBuilding2;
	}

	/**
	 * Set the value of column subBuilding2.
	 * 
	 * @param subBuilding2
	 */
	public void setSubBuilding2(String subBuilding2) {
		this.subBuilding2 = subBuilding2;
	}

	/**
	 * Get the value of column subBuilding3.
	 * 
	 * @return subBuilding3
	 */
	public String getSubBuilding3() {
		return subBuilding3;
	}

	/**
	 * Set the value of column subBuilding3.
	 * 
	 * @param subBuilding3
	 */
	public void setSubBuilding3(String subBuilding3) {
		this.subBuilding3 = subBuilding3;
	}

	/**
	 * Get the value of column subBuilding4.
	 * 
	 * @return subBuilding4
	 */
	public String getSubBuilding4() {
		return subBuilding4;
	}

	/**
	 * Set the value of column subBuilding4.
	 * 
	 * @param subBuilding4
	 */
	public void setSubBuilding4(String subBuilding4) {
		this.subBuilding4 = subBuilding4;
	}

	/**
	 * Get the value of column subBuilding5.
	 * 
	 * @return subBuilding5
	 */
	public String getSubBuilding5() {
		return subBuilding5;
	}

	/**
	 * Set the value of column subBuilding5.
	 * 
	 * @param subBuilding5
	 */
	public void setSubBuilding5(String subBuilding5) {
		this.subBuilding5 = subBuilding5;
	}

	/**
	 * Get the value of column subBuilding6.
	 * 
	 * @return subBuilding6
	 */
	public String getSubBuilding6() {
		return subBuilding6;
	}

	/**
	 * Set the value of column subBuilding6.
	 * 
	 * @param subBuilding6
	 */
	public void setSubBuilding6(String subBuilding6) {
		this.subBuilding6 = subBuilding6;
	}

	/**
	 * Set field value of AddressInput object.
	 * 
	 * @param addressInput
	 *            an AddressInput object
	 * @param fieldName
	 *            the name of the field
	 * @param fieldValue
	 *            the value of the field
	 */
	public void setFieldValue(AddressInput addressInput, String fieldName, String fieldValue) {
		Class<? extends AddressInput> clazz = addressInput.getClass();
		String methodName = "set" + StringUtils.capitalize(fieldName);
		Method method = fieldMethodsMap.get(methodName);
		try {
			if (method == null) {
				method = clazz.getDeclaredMethod(methodName, String.class);
				fieldMethodsMap.put(methodName, method);
			}
			method.invoke(addressInput, fieldValue);
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

}
