/**
 * Copyright 2010 Hewlett-Packard. All rights reserved. <br>
 * HP Confidential. Use is subject to license terms.
 */
package com.hp.it.mdm.addressdoctor;

import java.util.Map;
import com.hp.it.cas.match.address.AddressQuery;

/**
 * @author liang.wu4@hp.com
 */
public class AddressDoctorQuery {

    public AddressQuery addressQuery(Map input) {
        AddressQuery query = new AddressQuery();

        query.setKey1((String) input.get(AddressDoctorInputs.key1));
        query.setKey2((String) input.get(AddressDoctorInputs.key2));
        query.setKey3((String) input.get(AddressDoctorInputs.key3));
        query.setCountry1((String) input.get(AddressDoctorInputs.country1));
        query.setCountry2((String) input.get(AddressDoctorInputs.country2));
        query.setCountry3((String) input.get(AddressDoctorInputs.country3));
        query.setLocality1((String) input.get(AddressDoctorInputs.locality1));
        query.setLocality2((String) input.get(AddressDoctorInputs.locality2));
        query.setLocality3((String) input.get(AddressDoctorInputs.locality3));
        query.setLocality4((String) input.get(AddressDoctorInputs.locality4));
        query.setLocality5((String) input.get(AddressDoctorInputs.locality5));
        query.setLocality6((String) input.get(AddressDoctorInputs.locality6));
        query.setProvince1((String) input.get(AddressDoctorInputs.province1));
        query.setProvince2((String) input.get(AddressDoctorInputs.province2));
        query.setProvince3((String) input.get(AddressDoctorInputs.province3));
        query.setProvince4((String) input.get(AddressDoctorInputs.province4));
        query.setProvince5((String) input.get(AddressDoctorInputs.province5));
        query.setProvince6((String) input.get(AddressDoctorInputs.province6));
        query.setPostalCode1((String) input.get(AddressDoctorInputs.postalCode1));
        query.setPostalCode2((String) input.get(AddressDoctorInputs.postalCode2));
        query.setPostalCode3((String) input.get(AddressDoctorInputs.postalCode3));
        query.setStreet1((String) input.get(AddressDoctorInputs.street1));
        query.setStreet2((String) input.get(AddressDoctorInputs.street2));
        query.setStreet3((String) input.get(AddressDoctorInputs.street3));
        query.setStreet4((String) input.get(AddressDoctorInputs.street4));
        query.setStreet5((String) input.get(AddressDoctorInputs.street5));
        query.setStreet6((String) input.get(AddressDoctorInputs.street6));
        query.setNumber1((String) input.get(AddressDoctorInputs.number1));
        query.setNumber2((String) input.get(AddressDoctorInputs.number2));
        query.setNumber3((String) input.get(AddressDoctorInputs.number3));
        query.setNumber3((String) input.get(AddressDoctorInputs.number3));
        query.setNumber4((String) input.get(AddressDoctorInputs.number4));
        query.setNumber5((String) input.get(AddressDoctorInputs.number5));
        query.setNumber6((String) input.get(AddressDoctorInputs.number6));
        query.setBuilding1((String) input.get(AddressDoctorInputs.building1));
        query.setBuilding2((String) input.get(AddressDoctorInputs.building2));
        query.setBuilding3((String) input.get(AddressDoctorInputs.building3));
        query.setBuilding4((String) input.get(AddressDoctorInputs.building4));
        query.setBuilding5((String) input.get(AddressDoctorInputs.building5));
        query.setBuilding6((String) input.get(AddressDoctorInputs.building6));
        query.setSubBuilding1((String) input.get(AddressDoctorInputs.subBuilding1));
        query.setSubBuilding2((String) input.get(AddressDoctorInputs.subBuilding2));
        query.setSubBuilding3((String) input.get(AddressDoctorInputs.subBuilding3));
        query.setSubBuilding4((String) input.get(AddressDoctorInputs.subBuilding4));
        query.setSubBuilding5((String) input.get(AddressDoctorInputs.subBuilding5));
        query.setSubBuilding6((String) input.get(AddressDoctorInputs.subBuilding6));
        query.setDeliveryService1((String) input.get(AddressDoctorInputs.deliveryService1));
        query.setDeliveryService2((String) input.get(AddressDoctorInputs.deliveryService2));
        query.setDeliveryService3((String) input.get(AddressDoctorInputs.deliveryService3));
        query.setDeliveryService4((String) input.get(AddressDoctorInputs.deliveryService4));
        query.setDeliveryService5((String) input.get(AddressDoctorInputs.deliveryService5));
        query.setDeliveryService6((String) input.get(AddressDoctorInputs.deliveryService6));
        query.setOrganization1((String) input.get(AddressDoctorInputs.organization1));
        query.setOrganization2((String) input.get(AddressDoctorInputs.organization2));
        query.setOrganization3((String) input.get(AddressDoctorInputs.organization3));
        query.setContact1((String) input.get(AddressDoctorInputs.contact1));
        query.setContact2((String) input.get(AddressDoctorInputs.contact2));
        query.setContact3((String) input.get(AddressDoctorInputs.contact3));
        query.setResidue1((String) input.get(AddressDoctorInputs.residue1));
        query.setResidue2((String) input.get(AddressDoctorInputs.residue2));
        query.setResidue3((String) input.get(AddressDoctorInputs.residue3));
        query.setResidue4((String) input.get(AddressDoctorInputs.residue4));
        query.setResidue5((String) input.get(AddressDoctorInputs.residue5));
        query.setResidue6((String) input.get(AddressDoctorInputs.residue6));
        query.setRecipientLine1((String) input.get(AddressDoctorInputs.recipientLine1));
        query.setRecipientLine2((String) input.get(AddressDoctorInputs.recipientLine2));
        query.setRecipientLine3((String) input.get(AddressDoctorInputs.recipientLine3));
        query.setDeliveryAddressLine1((String) input.get(AddressDoctorInputs.deliveryAddressLine1));
        query.setDeliveryAddressLine2((String) input.get(AddressDoctorInputs.deliveryAddressLine2));
        query.setDeliveryAddressLine3((String) input.get(AddressDoctorInputs.deliveryAddressLine3));
        query.setDeliveryAddressLine4((String) input.get(AddressDoctorInputs.deliveryAddressLine4));
        query.setDeliveryAddressLine5((String) input.get(AddressDoctorInputs.deliveryAddressLine5));
        query.setDeliveryAddressLine6((String) input.get(AddressDoctorInputs.deliveryAddressLine6));
        query.setCountrySpecificLocalityLine1((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine1));
        query.setCountrySpecificLocalityLine2((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine2));
        query.setCountrySpecificLocalityLine3((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine3));
        query.setCountrySpecificLocalityLine4((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine4));
        query.setCountrySpecificLocalityLine5((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine5));
        query.setCountrySpecificLocalityLine6((String) input.get(AddressDoctorInputs.countrySpecificLocalityLine6));
        query.setFormattedAddressLine1((String) input.get(AddressDoctorInputs.formattedAddressLine1));
        query.setFormattedAddressLine2((String) input.get(AddressDoctorInputs.formattedAddressLine2));
        query.setFormattedAddressLine3((String) input.get(AddressDoctorInputs.formattedAddressLine3));
        query.setFormattedAddressLine4((String) input.get(AddressDoctorInputs.formattedAddressLine4));
        query.setFormattedAddressLine5((String) input.get(AddressDoctorInputs.formattedAddressLine5));
        query.setFormattedAddressLine6((String) input.get(AddressDoctorInputs.formattedAddressLine6));
        query.setFormattedAddressLine7((String) input.get(AddressDoctorInputs.formattedAddressLine7));
        query.setFormattedAddressLine8((String) input.get(AddressDoctorInputs.formattedAddressLine8));
        query.setFormattedAddressLine9((String) input.get(AddressDoctorInputs.formattedAddressLine9));
        query.setFormattedAddressLine10((String) input.get(AddressDoctorInputs.formattedAddressLine10));
        query.setFormattedAddressLine11((String) input.get(AddressDoctorInputs.formattedAddressLine11));
        query.setFormattedAddressLine12((String) input.get(AddressDoctorInputs.formattedAddressLine12));
        query.setFormattedAddressLine13((String) input.get(AddressDoctorInputs.formattedAddressLine13));
        query.setFormattedAddressLine14((String) input.get(AddressDoctorInputs.formattedAddressLine14));
        query.setFormattedAddressLine15((String) input.get(AddressDoctorInputs.formattedAddressLine15));
        query.setFormattedAddressLine16((String) input.get(AddressDoctorInputs.formattedAddressLine16));
        query.setFormattedAddressLine17((String) input.get(AddressDoctorInputs.formattedAddressLine17));
        query.setFormattedAddressLine18((String) input.get(AddressDoctorInputs.formattedAddressLine18));
        query.setFormattedAddressLine18((String) input.get(AddressDoctorInputs.formattedAddressLine18));
        query.setFormattedAddressLine19((String) input.get(AddressDoctorInputs.formattedAddressLine19));
        query.setAddressComplete((String) input.get(AddressDoctorInputs.addressComplete));
        query.setPreferredLanguage((String) input.get(AddressDoctorInputs.preferredLanguage));
        query.setPreferredScript((String) input.get(AddressDoctorInputs.preferredScript));
        if (null != (String) input.get(AddressDoctorInputs.characterScriptDetectionIndicator)
            && !"".equals((String) input.get(AddressDoctorInputs.characterScriptDetectionIndicator))) {
            if ("Y".equalsIgnoreCase((String) input.get(AddressDoctorInputs.characterScriptDetectionIndicator)))
                query.setCharacterScriptDetectionIndicator(true);
            else if ("N".equalsIgnoreCase((String) input.get(AddressDoctorInputs.characterScriptDetectionIndicator)))
                query.setCharacterScriptDetectionIndicator(false);
            else
                query.setCharacterScriptDetectionIndicator(Boolean.valueOf((String) input.get(AddressDoctorInputs.characterScriptDetectionIndicator)));
        }
        
        return query;
    }
}
