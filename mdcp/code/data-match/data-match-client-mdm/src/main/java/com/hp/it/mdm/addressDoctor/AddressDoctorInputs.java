/**
 * Copyright 2010 Hewlett-Packard. All rights reserved. <br>
 * HP Confidential. Use is subject to license terms.
 */
package com.hp.it.mdm.addressDoctor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.siperian.mrm.cleanse.api.ParameterTypes;

/**
 * @author liang.wu4@hp.com
 */
public class AddressDoctorInputs {
	/**
	 * Create the logger instance for logging when the error happens
	 */
	static Logger logger = Logger.getLogger(AddressDoctorInputs.class.getName());
	
    public final static String key1 = "key1";
    public final static String key2 = "key2";
    public final static String key3 = "key3";
    public final static String country1 = "country1";
    public final static String country2 = "country2";
    public final static String country3 = "country3";
    public final static String locality1 = "locality1";
    public final static String locality2 = "locality2";
    public final static String locality3 = "locality3";
    public final static String locality4 = "locality4";
    public final static String locality5 = "locality5";
    public final static String locality6 = "locality6";
    public final static String province1 = "province1";
    public final static String province2 = "province2";
    public final static String province3 = "province3";
    public final static String province4 = "province4";
    public final static String province5 = "province5";
    public final static String province6 = "province6";
    public final static String postalCode1 = "postalCode1";
    public final static String postalCode2 = "postalCode2";
    public final static String postalCode3 = "postalCode3";
    public final static String street1 = "street1";
    public final static String street2 = "street2";
    public final static String street3 = "street3";
    public final static String street4 = "street4";
    public final static String street5 = "street5";
    public final static String street6 = "street6";
    public final static String number1 = "number1";
    public final static String number2 = "number2";
    public final static String number3 = "number3";
    public final static String number4 = "number4";
    public final static String number5 = "number5";
    public final static String number6 = "number6";
    public final static String building1 = "building1";
    public final static String building2 = "building2";
    public final static String building3 = "building3";
    public final static String building4 = "building4";
    public final static String building5 = "building5";
    public final static String building6 = "building6";
    public final static String subBuilding1 = "subBuilding1";
    public final static String subBuilding2 = "subBuilding2";
    public final static String subBuilding3 = "subBuilding3";
    public final static String subBuilding4 = "subBuilding4";
    public final static String subBuilding5 = "subBuilding5";
    public final static String subBuilding6 = "subBuilding6";
    public final static String deliveryService1 = "deliveryService1";
    public final static String deliveryService2 = "deliveryService2";
    public final static String deliveryService3 = "deliveryService3";
    public final static String deliveryService4 = "deliveryService4";
    public final static String deliveryService5 = "deliveryService5";
    public final static String deliveryService6 = "deliveryService6";
    public final static String organization1 = "organization1";
    public final static String organization2 = "organization2";
    public final static String organization3 = "organization3";
    public final static String contact1 = "contact1";
    public final static String contact2 = "contact2";
    public final static String contact3 = "contact3";
    public final static String residue1 = "residue1";
    public final static String residue2 = "residue2";
    public final static String residue3 = "residue3";
    public final static String residue4 = "residue4";
    public final static String residue5 = "residue5";
    public final static String residue6 = "residue6";
    public final static String recipientLine1 = "recipientLine1";
    public final static String recipientLine2 = "recipientLine2";
    public final static String recipientLine3 = "recipientLine3";
    public final static String deliveryAddressLine1 = "deliveryAddressLine1";
    public final static String deliveryAddressLine2 = "deliveryAddressLine2";
    public final static String deliveryAddressLine3 = "deliveryAddressLine3";
    public final static String deliveryAddressLine4 = "deliveryAddressLine4";
    public final static String deliveryAddressLine5 = "deliveryAddressLine5";
    public final static String deliveryAddressLine6 = "deliveryAddressLine6";
    public final static String countrySpecificLocalityLine1 = "countrySpecificLocalityLine1";
    public final static String countrySpecificLocalityLine2 = "countrySpecificLocalityLine2";
    public final static String countrySpecificLocalityLine3 = "countrySpecificLocalityLine3";
    public final static String countrySpecificLocalityLine4 = "countrySpecificLocalityLine4";
    public final static String countrySpecificLocalityLine5 = "countrySpecificLocalityLine5";
    public final static String countrySpecificLocalityLine6 = "countrySpecificLocalityLine6";
    public final static String formattedAddressLine1 = "formattedAddressLine1";
    public final static String formattedAddressLine2 = "formattedAddressLine2";
    public final static String formattedAddressLine3 = "formattedAddressLine3";
    public final static String formattedAddressLine4 = "formattedAddressLine4";
    public final static String formattedAddressLine5 = "formattedAddressLine5";
    public final static String formattedAddressLine6 = "formattedAddressLine6";
    public final static String formattedAddressLine7 = "formattedAddressLine7";
    public final static String formattedAddressLine8 = "formattedAddressLine8";
    public final static String formattedAddressLine9 = "formattedAddressLine9";
    public final static String formattedAddressLine10 = "formattedAddressLine10";
    public final static String formattedAddressLine11 = "formattedAddressLine11";
    public final static String formattedAddressLine12 = "formattedAddressLine12";
    public final static String formattedAddressLine13 = "formattedAddressLine13";
    public final static String formattedAddressLine14 = "formattedAddressLine14";
    public final static String formattedAddressLine15 = "formattedAddressLine15";
    public final static String formattedAddressLine16 = "formattedAddressLine16";
    public final static String formattedAddressLine17 = "formattedAddressLine17";
    public final static String formattedAddressLine18 = "formattedAddressLine18";
    public final static String formattedAddressLine19 = "formattedAddressLine19";
    public final static String addressComplete = "addressComplete";
    public final static String preferredScript = "preferredScript";
    public final static String preferredLanguage = "preferredLanguage";
    public final static String characterScriptDetectionIndicator = "characterScriptDetectionIndicator";
    public final static String NAMEIN = "Name Input";

    public final static String[] fInputName = {
        key1, key2, key3, country1, country2, country3, locality1, locality2, locality3, locality4, locality5,
        locality6, province1, province2, province3, province4, province5, province6, postalCode1, postalCode2,
        postalCode3, street1, street2, street3, street4, street5, street6, number1, number2, number3, number4, number5,
        number6, building1, building2, building3, building4, building5, building6, subBuilding1, subBuilding2,
        subBuilding3, subBuilding4, subBuilding5, subBuilding6, deliveryService1, deliveryService2, deliveryService3,
        deliveryService4, deliveryService5, deliveryService6, organization1, organization2, organization3, contact1,
        contact2, contact3, residue1, residue2, residue3, residue4, residue5, residue6, recipientLine1, recipientLine2,
        recipientLine3, deliveryAddressLine1, deliveryAddressLine2, deliveryAddressLine3, deliveryAddressLine4,
        deliveryAddressLine5, deliveryAddressLine6, countrySpecificLocalityLine1, countrySpecificLocalityLine2,
        countrySpecificLocalityLine3, countrySpecificLocalityLine4, countrySpecificLocalityLine5,
        countrySpecificLocalityLine6, formattedAddressLine1, formattedAddressLine2, formattedAddressLine3,
        formattedAddressLine4, formattedAddressLine5, formattedAddressLine6, formattedAddressLine7,
        formattedAddressLine8, formattedAddressLine9, formattedAddressLine10, formattedAddressLine11,
        formattedAddressLine12, formattedAddressLine13, formattedAddressLine14, formattedAddressLine15,
        formattedAddressLine16, formattedAddressLine17, formattedAddressLine18, formattedAddressLine19,
        addressComplete, preferredScript, preferredLanguage, characterScriptDetectionIndicator, NAMEIN };
    public final static String[] fInputType = {

        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING };
    
    public static Properties loadPropertyFile(String path) {

		Properties props = new java.util.Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			props.load(fis);
		} catch (FileNotFoundException e) {
			logger.error(e.toString(), e);
		} catch (IOException e) {
			logger.error(e.toString(), e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				logger.error(e.toString(), e);
			}
		}
		return props;
	}
}
