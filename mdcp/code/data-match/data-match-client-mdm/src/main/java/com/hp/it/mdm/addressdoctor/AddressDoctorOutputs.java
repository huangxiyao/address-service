/**
 * Copyright 2010 Hewlett-Packard. All rights reserved. <br>
 * HP Confidential. Use is subject to license terms.
 */
package com.hp.it.mdm.addressdoctor;

import java.util.Map;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;
import com.siperian.mrm.cleanse.api.ParameterTypes;

/**
 * @author liang.wu4@hp.com
 */
public class AddressDoctorOutputs {

    public final static String processStatus = "processStatus";
    public final static String modeUsed = "modeUsed";
    public final static String preferredLanguage = "preferredLanguage";
    public final static String preferredScript = "preferredScript";
    public final static String countryCode = "countryCode";
    public final static String countOverflow = "countOverflow";
    public final static String elementInputStatus = "elementInputStatus";
    public final static String elementResultStatus = "elementResultStatus";
    public final static String elementRelevance = "elementRelevance";
    public final static String mailabilityScore = "mailabilityScore";
    public final static String resultPercentage = "resultPercentage";
    public final static String cassStatus = "cassStatus";
    public final static String serpStatus = "serpStatus";
    public final static String snaStatus = "snaStatus";
    public final static String supplementaryGBStatus = "supplementaryGBStatus";
    public final static String supplementaryUSStatus = "supplementaryUSStatus";
    public final static String key = "key";
    public final static String country = "country";
    public final static String supplementaryUS = "supplementaryUS";
    public final static String locality = "locality";
    public final static String postalCode = "postalCode";
    public final static String province = "province";
    public final static String subProvince = "subProvince";
    public final static String street = "street";
    public final static String number = "number";
    public final static String building = "building";
    public final static String subBuilding = "subBuilding";
    public final static String deliveryService = "deliveryService";
    public final static String organization = "organization";
    public final static String contact = "contact";
    public final static String residue = "residue";
    public final static String recipientLines = "recipientLines";
    public final static String deliveryAddressLine = "deliveryAddressLine";
    public final static String countrySpecificLocalityLine = "countrySpecificLocalityLine";
    public final static String formattedAddressLine = "formattedAddressLine";
    public final static String completeAddress = "completeAddress";

    public final static String[] fOutputName = {
        processStatus, modeUsed, preferredLanguage, preferredScript, countryCode, countOverflow, elementInputStatus, elementResultStatus,
        elementRelevance, mailabilityScore, resultPercentage, cassStatus, serpStatus, snaStatus, supplementaryGBStatus,
        supplementaryUSStatus, key, country, supplementaryUS,locality, postalCode, province, subProvince, street, number, building, subBuilding,
        deliveryService,
        organization, contact, residue, recipientLines, deliveryAddressLine, countrySpecificLocalityLine,
 formattedAddressLine, completeAddress };

    public final static String[] fOutputType = {

        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.BOOLEAN, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING, ParameterTypes.STRING,
        ParameterTypes.STRING,ParameterTypes.STRING,ParameterTypes.STRING, ParameterTypes.STRING};

    public static Map populateRsltMap(AddressQueryResult result, Map output) {
        StringBuffer keyBuf = new StringBuffer();
        StringBuffer countryBuf = new StringBuffer();
        StringBuffer supplementaryUSBuf = new StringBuffer();
        StringBuffer localityBuf = new StringBuffer();
        StringBuffer postalCodeBuf = new StringBuffer();
        StringBuffer provinceBuf = new StringBuffer();
        StringBuffer subProvinceBuf = new StringBuffer();
        StringBuffer streetBuf = new StringBuffer();
        StringBuffer numberBuf = new StringBuffer();
        StringBuffer buildingBuf = new StringBuffer();
        StringBuffer subBuildingBuf = new StringBuffer();
        StringBuffer deliveryServiceBuf = new StringBuffer();
        StringBuffer organizationBuf = new StringBuffer();
        StringBuffer contactBuf = new StringBuffer();
        StringBuffer residueBuf = new StringBuffer();
        StringBuffer recipientLinesBuf = new StringBuffer();
        StringBuffer deliveryAddressLineBuf = new StringBuffer();
        StringBuffer countrySpecificLocalityLineBuf = new StringBuffer();
        StringBuffer formattedAddressLineBuf = new StringBuffer();
        output.put(countryCode,result.getIso3());
        output.put(modeUsed,result.getModeUsed());
        output.put(preferredLanguage,result.getPreferredLanguage());
        output.put(preferredScript,result.getPreferredScript());
        output.put(processStatus, result.getProcessStatus());
        output.put(countOverflow, result.isCountOverFlow());
        if(result.getAddressData().size() > 0){
            for(AddressData addt : result.getAddressData()){
            	 keyBuf.append("[");
            	 countryBuf.append("[");
            	 supplementaryUSBuf.append("[");
            	 localityBuf.append("[");
            	 postalCodeBuf.append("[");
            	 provinceBuf.append("[");
            	 subProvinceBuf.append("[");
            	 streetBuf.append("[");
            	 numberBuf.append("[");
            	 buildingBuf.append("[");
            	 subBuildingBuf.append("[");
            	 deliveryServiceBuf.append("[");
            	 organizationBuf.append("[");
            	 contactBuf.append("[");
            	 residueBuf.append("[");
            	 recipientLinesBuf.append("[");
            	 deliveryAddressLineBuf.append("[");
            	 countrySpecificLocalityLineBuf.append("[");
            	 formattedAddressLineBuf.append("[");
                output.put(elementInputStatus,addt.getElementInputStatus());
                output.put(elementResultStatus,addt.getElementResultStatus());
                output.put(elementRelevance,addt.getElementRelevance());
                output.put(mailabilityScore,addt.getMailabilityScore());
                output.put(resultPercentage,addt.getResultPercentage());
                output.put(cassStatus,addt.getCassStatus());
                output.put(serpStatus,addt.getSerpStatus());
                output.put(snaStatus,addt.getSnaStatus());
                output.put(supplementaryGBStatus,addt.getSupplementaryGBStatus());
                output.put(supplementaryUSStatus,addt.getSupplementaryUSStatus());
                AddressElement adellst = null;
                String ade = null;
//                for (AddressElement adel : addt.getKeys()) {
//                    keyBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    keyBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getKeys().size();i<j;i++){
                	adellst = addt.getKeys().get(i);
                	if(i<(addt.getKeys().size()-1)){
                		keyBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		keyBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		keyBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		keyBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(key, keyBuf.append("],").toString());
                
//                for (AddressElement adel : addt.getCountries()) {
//                    countryBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    countryBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getCountries().size();i<j;i++){
                	adellst = addt.getCountries().get(i);
                	if(i<(addt.getCountries().size()-1)){
                		countryBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		countryBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		countryBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		countryBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(country, countryBuf.append("],").toString());
                
//                for (AddressElement adel : addt.getSupplementaryUs()) {
//                	supplementaryUSBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                	supplementaryUSBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getSupplementaryUs().size();i<j;i++){
                	adellst = addt.getSupplementaryUs().get(i);
                	if(i<(addt.getSupplementaryUs().size()-1)){
                		supplementaryUSBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		supplementaryUSBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		supplementaryUSBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		supplementaryUSBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(supplementaryUS, supplementaryUSBuf.append("],").toString());
                
//                for (AddressElement adel : addt.getLocalities()) {
//                    localityBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    localityBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getLocalities().size();i<j;i++){
                	adellst = addt.getLocalities().get(i);
                	if(i<(addt.getLocalities().size()-1)){
                		localityBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		localityBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		localityBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		localityBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(locality, localityBuf.append("],").toString());

//                for (AddressElement adel : addt.getPostalCodes()) {
//                    postalCodeBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    postalCodeBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getPostalCodes().size();i<j;i++){
                	adellst = addt.getPostalCodes().get(i);
                	if(i<(addt.getPostalCodes().size()-1)){
                		postalCodeBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		postalCodeBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		postalCodeBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		postalCodeBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(postalCode, postalCodeBuf.append("],").toString());

//                for (AddressElement adel : addt.getProvinces()) {
//                    provinceBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    provinceBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getProvinces().size();i<j;i++){
                	adellst = addt.getProvinces().get(i);
                	if(i<(addt.getProvinces().size()-1)){
                		provinceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		provinceBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		provinceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		provinceBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(province, provinceBuf.append("],").toString());
                
//                for (AddressElement adel : addt.getSubProvinces()) {
//                	subProvinceBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                	subProvinceBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getSubProvinces().size();i<j;i++){
                	adellst = addt.getSubProvinces().get(i);
                	if(i<(addt.getSubProvinces().size()-1)){
                		subProvinceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		subProvinceBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		subProvinceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		subProvinceBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(subProvince, subProvinceBuf.append("],").toString());

//                for (AddressElement adel : addt.getStreets()) {
//                    streetBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    streetBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getStreets().size();i<j;i++){
                	adellst = addt.getStreets().get(i);
                	if(i<(addt.getStreets().size()-1)){
                		streetBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		streetBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		streetBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		streetBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(street, streetBuf.append("],").toString());

//                for (AddressElement adel : addt.getNumbers()) {
//                    numberBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    numberBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getNumbers().size();i<j;i++){
                	adellst = addt.getNumbers().get(i);
                	if(i<(addt.getNumbers().size()-1)){
                		numberBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		numberBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		numberBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		numberBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(number, numberBuf.append("],").toString());

//                for (AddressElement adel : addt.getBuildings()) {
//                    buildingBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    buildingBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getBuildings().size();i<j;i++){
                	adellst = addt.getBuildings().get(i);
                	if(i<(addt.getBuildings().size()-1)){
                		buildingBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		buildingBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		buildingBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		buildingBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(building, buildingBuf.append("],").toString());

//                for (AddressElement adel : addt.getSubBuildings()) {
//                    subBuildingBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    subBuildingBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getSubBuildings().size();i<j;i++){
                	adellst = addt.getSubBuildings().get(i);
                	if(i<(addt.getSubBuildings().size()-1)){
                		subBuildingBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		subBuildingBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		subBuildingBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		subBuildingBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(subBuilding, subBuildingBuf.append("],").toString());

//                for (AddressElement adel : addt.getDeliveryServices()) {
//                    deliveryServiceBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    deliveryServiceBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getDeliveryServices().size();i<j;i++){
                	adellst = addt.getDeliveryServices().get(i);
                	if(i<(addt.getDeliveryServices().size()-1)){
                		deliveryServiceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		deliveryServiceBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		deliveryServiceBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		deliveryServiceBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(deliveryService, deliveryServiceBuf.append("],").toString());

//                for (AddressElement adel : addt.getOrganizations()) {
//                    organizationBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    organizationBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getOrganizations().size();i<j;i++){
                	adellst = addt.getOrganizations().get(i);
                	if(i<(addt.getOrganizations().size()-1)){
                		organizationBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		organizationBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		organizationBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		organizationBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(organization, organizationBuf.append("],").toString());

//                for (AddressElement adel : addt.getContacts()) {
//                    contactBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    contactBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getContacts().size();i<j;i++){
                	adellst = addt.getContacts().get(i);
                	if(i<(addt.getContacts().size()-1)){
                		contactBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		contactBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		contactBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		contactBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(contact, contactBuf.append("],").toString());

//                for (AddressElement adel : addt.getResidues()) {
//                    residueBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
//                    residueBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
//                }
                for (int i=0,j=addt.getResidues().size();i<j;i++){
                	adellst = addt.getResidues().get(i);
                	if(i<(addt.getResidues().size()-1)){
                		residueBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		residueBuf.append("value:" + adellst.getValue() + "\r\n},\r\n");
                	}else{
                		residueBuf.append("{\r\ntype:" + adellst.getType() + ",\r\n");
                		residueBuf.append("value:" + adellst.getValue() + "\r\n}\r\n");
                	}
                }
                output.put(residue, residueBuf.append("],").toString());

//                for (String recipientline : addt.getRecipientLines()) {
//                    recipientLinesBuf.append(recipientline + ",\r\n");
//                }
                for (int i=0,j=addt.getRecipientLines().size();i<j;i++){
                	ade = addt.getRecipientLines().get(i);
                	if(i<(addt.getRecipientLines().size()-1)){
                		recipientLinesBuf.append(ade + ",\r\n");
                	}else{
                		recipientLinesBuf.append(ade + "\r\n");
                	}
                }
                output.put(recipientLines, recipientLinesBuf.append("],").toString());

//                for (String deliveryAddLine : addt.getDeliveryAddressLines()) {
//                    deliveryAddressLineBuf.append(deliveryAddLine + ",\r\n");
//                }
                for (int i=0,j=addt.getDeliveryAddressLines().size();i<j;i++){
                	ade = addt.getDeliveryAddressLines().get(i);
                	if(i<(addt.getDeliveryAddressLines().size()-1)){
                		deliveryAddressLineBuf.append(ade + ",\r\n");
                	}else{
                		deliveryAddressLineBuf.append(ade + "\r\n");
                	}
                }
                output.put(deliveryAddressLine, deliveryAddressLineBuf.append("],").toString());

//                for (String ctrySpeLocLine : addt.getCountrySpecificLocalityLines()) {
//                    countrySpecificLocalityLineBuf.append(ctrySpeLocLine + ",\r\n");
//                }
                for (int i=0,j=addt.getCountrySpecificLocalityLines().size();i<j;i++){
                	ade = addt.getCountrySpecificLocalityLines().get(i);
                	if(i<(addt.getCountrySpecificLocalityLines().size()-1)){
                		countrySpecificLocalityLineBuf.append(ade + ",\r\n");
                	}else{
                		countrySpecificLocalityLineBuf.append(ade + "\r\n");
                	}
                }
                output.put(countrySpecificLocalityLine, countrySpecificLocalityLineBuf.append("],").toString());

//                for (String formatAddLine : addt.getFormattedAddressLines()) {
//                    formattedAddressLineBuf.append(formatAddLine + ",\r\n");
//                }
                for (int i=0,j=addt.getFormattedAddressLines().size();i<j;i++){
                	ade = addt.getFormattedAddressLines().get(i);
                	if(i<(addt.getFormattedAddressLines().size()-1)){
                		formattedAddressLineBuf.append(ade + ",\r\n");
                	}else{
                		formattedAddressLineBuf.append(ade + "\r\n");
                	}
                }
                output.put(formattedAddressLine, formattedAddressLineBuf.append("],").toString());

                output.put(completeAddress, addt.getCompleteAddress());

            }
        }
        
        
        return output;
    }

    public final static String populateAddressDoctorResultToString(AddressQueryResult result) {
        StringBuffer contentBuf = new StringBuffer("content:{" + "\r\n");
        StringBuffer resultBuf = null;
        StringBuffer resultDataBuf = null;
        resultBuf = new StringBuffer("result:{" + "\r\n");

        resultBuf.append("processStatus:" + result.getProcessStatus() + ";\r\n");
        resultBuf.append("modeUsed:" + result.getModeUsed() + ";\r\n");
        resultBuf.append("preferredLanguage:" + result.getPreferredLanguage() + ";\r\n");
        resultBuf.append("preferredScript:" + result.getPreferredScript() + ";\r\n");
        resultBuf.append("countryCode:" + result.getIso3() + ";\r\n" + "}\r\n");

        if (result.getAddressData().size() > 0) {
            for (AddressData addt : result.getAddressData()) {
                resultDataBuf = new StringBuffer("resultData:[" + "\r\n" + "{\r\n");
                resultDataBuf.append("elementInputStatus:" + addt.getElementInputStatus() + ",\r\n");
                resultDataBuf.append("elementResultStatus:" + addt.getElementResultStatus() + ",\r\n");
                resultDataBuf.append("elementRelevance:" + addt.getElementRelevance() + ",\r\n");
                resultDataBuf.append("mailabilityScore:" + addt.getMailabilityScore() + ",\r\n");
                resultDataBuf.append("resultPercentage:" + addt.getResultPercentage() + ",\r\n");
                resultDataBuf.append("cassStatus:" + addt.getCassStatus() + ",\r\n");
                resultDataBuf.append("serpStatus:" + addt.getSerpStatus() + ",\r\n");
                resultDataBuf.append("snaStatus:" + addt.getSnaStatus() + ",\r\n");
                resultDataBuf.append("supplementaryGBStatus:" + addt.getSupplementaryGBStatus() + ",\r\n");
                resultDataBuf.append("supplementaryUSStatus:" + addt.getSupplementaryUSStatus() + ",\r\n");
                resultDataBuf.append("key:[" + "\r\n");
                
                for (AddressElement adel : addt.getKeys()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("country:[\r\n");
                for (AddressElement adel : addt.getCountries()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("locality:[\r\n");
                for (AddressElement adel : addt.getLocalities()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("postalCode:[\r\n");
                for (AddressElement adel : addt.getPostalCodes()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("province:[\r\n");
                for (AddressElement adel : addt.getProvinces()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("street:[\r\n");
                for (AddressElement adel : addt.getStreets()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("number:[\r\n");
                for (AddressElement adel : addt.getNumbers()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("building:[\r\n");
                for (AddressElement adel : addt.getBuildings()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("subBuilding:[\r\n");
                for (AddressElement adel : addt.getSubBuildings()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("deliveryService:[\r\n");
                for (AddressElement adel : addt.getDeliveryServices()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("organization:[\r\n");
                for (AddressElement adel : addt.getOrganizations()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("contact:[\r\n");
                for (AddressElement adel : addt.getContacts()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("residue:[\r\n");
                for (AddressElement adel : addt.getResidues()) {
                    resultDataBuf.append("{\r\ntype:" + adel.getType() + ",\r\n");
                    resultDataBuf.append("value:" + adel.getValue() + "\r\n},\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("recipientLines:[\r\n");
                for (String recipientline : addt.getRecipientLines()) {
                    resultDataBuf.append(recipientline + ",\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("deliveryAddressLine:[\r\n");
                for (String deliveryAddLine : addt.getDeliveryAddressLines()) {
                    resultDataBuf.append(deliveryAddLine + ",\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("countrySpecificLocalityLine:[\r\n");
                for (String ctrySpeLocLine : addt.getCountrySpecificLocalityLines()) {
                    resultDataBuf.append(ctrySpeLocLine + ",\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("formattedAddressLine:[\r\n");
                for (String formatAddLine : addt.getFormattedAddressLines()) {
                    resultDataBuf.append(formatAddLine + ",\r\n");
                }
                resultDataBuf.append("],\r\n");
                resultDataBuf.append("completeAddress:" + addt.getCompleteAddress() + "\r\n]\r\n}\r\n");
            }
        }
        resultBuf.append(resultDataBuf);
        return contentBuf.append(resultBuf).append("}").toString();
    }
}
