package com.hp.it.cas.match.address.client.support;

import java.util.Map;

import com.hp.it.cas.match.address.AddressQuery;

/**
 * The purpose of this class is providing some useful tool to parse the address
 * input for both rest and soap visit.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class AddressInputParse {

	/**
	 * Assembling the AddressQuery by every attribute of AddressQuery.
	 * 
	 * @param query
	 *            The empty query need to be assembled
	 * @param attributes
	 *            The name of attributes
	 * @param value
	 *            The value of attributes
	 * @param map
	 * @see AbstractAddressFinderRestProxy.parameterize
	 * 
	 */
	public static void assembleAddressQueryByEveryAttribute(AddressQuery query, String attribute, String value,
			Map<String, String> map) {

		if (attribute == null || value == null || attribute.isEmpty() || value.isEmpty()) {
			return;
		} else if (("AddressComplete").equals(attribute)) {
			query.setAddressComplete(value);
		} else if (("Building1").equals(attribute)) {
			query.setBuilding1(value);
		} else if (("Building2").equals(attribute)) {
			query.setBuilding2(value);
		} else if (("Building3").equals(attribute)) {
			query.setBuilding3(value);
		} else if (("Building4").equals(attribute)) {
			query.setBuilding4(value);
		} else if (("Building5").equals(attribute)) {
			query.setBuilding5(value);
		} else if (("Building6").equals(attribute)) {
			query.setBuilding6(value);
		} else if (("Contact1").equals(attribute)) {
			query.setContact1(value);
		} else if (("Contact2").equals(attribute)) {
			query.setContact2(value);
		} else if (("Contact3").equals(attribute)) {
			query.setContact3(value);
		} else if (("Country1").equals(attribute)) {
			query.setCountry1(value);
		} else if (("Country2").equals(attribute)) {
			query.setCountry2(value);
		} else if (("Country3").equals(attribute)) {
			query.setCountry3(value);
		} else if (("CountrySpecificLocalityLine1").equals(attribute)) {
			query.setCountrySpecificLocalityLine1(value);
		} else if (("CountrySpecificLocalityLine2").equals(attribute)) {
			query.setCountrySpecificLocalityLine2(value);
		} else if (("CountrySpecificLocalityLine3").equals(attribute)) {
			query.setCountrySpecificLocalityLine3(value);
		} else if (("CountrySpecificLocalityLine4").equals(attribute)) {
			query.setCountrySpecificLocalityLine4(value);
		} else if (("CountrySpecificLocalityLine5").equals(attribute)) {
			query.setCountrySpecificLocalityLine5(value);
		} else if (("CountrySpecificLocalityLine6").equals(attribute)) {
			query.setCountrySpecificLocalityLine6(value);
		} else if (("DeliveryAddressLine1").equals(attribute)) {
			query.setDeliveryAddressLine1(value);
		} else if (("DeliveryAddressLine2").equals(attribute)) {
			query.setDeliveryAddressLine2(value);
		} else if (("DeliveryAddressLine3").equals(attribute)) {
			query.setDeliveryAddressLine3(value);
		} else if (("DeliveryAddressLine4").equals(attribute)) {
			query.setDeliveryAddressLine4(value);
		} else if (("DeliveryAddressLine5").equals(attribute)) {
			query.setDeliveryAddressLine5(value);
		} else if (("DeliveryAddressLine6").equals(attribute)) {
			query.setDeliveryAddressLine6(value);
		} else if (("DeliveryService1").equals(attribute)) {
			query.setDeliveryService1(value);
		} else if (("DeliveryService2").equals(attribute)) {
			query.setDeliveryService2(value);
		} else if (("DeliveryService3").equals(attribute)) {
			query.setDeliveryService3(value);
		} else if (("DeliveryService4").equals(attribute)) {
			query.setDeliveryService4(value);
		} else if (("DeliveryService5").equals(attribute)) {
			query.setDeliveryService5(value);
		} else if (("DeliveryService6").equals(attribute)) {
			query.setDeliveryService6(value);
		} else if (("FormattedAddressLine1").equals(attribute)) {
			query.setFormattedAddressLine1(value);
		} else if (("FormattedAddressLine2").equals(attribute)) {
			query.setFormattedAddressLine2(value);
		} else if (("FormattedAddressLine3").equals(attribute)) {
			query.setFormattedAddressLine3(value);
		} else if (("FormattedAddressLine4").equals(attribute)) {
			query.setFormattedAddressLine4(value);
		} else if (("FormattedAddressLine5").equals(attribute)) {
			query.setFormattedAddressLine5(value);
		} else if (("FormattedAddressLine6").equals(attribute)) {
			query.setFormattedAddressLine6(value);
		} else if (("FormattedAddressLine7").equals(attribute)) {
			query.setFormattedAddressLine7(value);
		} else if (("FormattedAddressLine8").equals(attribute)) {
			query.setFormattedAddressLine8(value);
		} else if (("FormattedAddressLine9").equals(attribute)) {
			query.setFormattedAddressLine9(value);
		} else if (("FormattedAddressLine10").equals(attribute)) {
			query.setFormattedAddressLine10(value);
		} else if (("FormattedAddressLine11").equals(attribute)) {
			query.setFormattedAddressLine11(value);
		} else if (("FormattedAddressLine12").equals(attribute)) {
			query.setFormattedAddressLine12(value);
		} else if (("FormattedAddressLine13").equals(attribute)) {
			query.setFormattedAddressLine13(value);
		} else if (("FormattedAddressLine14").equals(attribute)) {
			query.setFormattedAddressLine14(value);
		} else if (("FormattedAddressLine15").equals(attribute)) {
			query.setFormattedAddressLine15(value);
		} else if (("FormattedAddressLine16").equals(attribute)) {
			query.setFormattedAddressLine16(value);
		} else if (("FormattedAddressLine17").equals(attribute)) {
			query.setFormattedAddressLine17(value);
		} else if (("FormattedAddressLine18").equals(attribute)) {
			query.setFormattedAddressLine18(value);
		} else if (("FormattedAddressLine19").equals(attribute)) {
			query.setFormattedAddressLine19(value);
		} else if (("Key1").equals(attribute)) {
			query.setKey1(value);
		} else if (("Key2").equals(attribute)) {
			query.setKey2(value);
		} else if (("Key3").equals(attribute)) {
			query.setKey3(value);
		} else if (("Locality1").equals(attribute)) {
			query.setLocality1(value);
		} else if (("Locality2").equals(attribute)) {
			query.setLocality2(value);
		} else if (("Locality3").equals(attribute)) {
			query.setLocality3(value);
		} else if (("Locality4").equals(attribute)) {
			query.setLocality4(value);
		} else if (("Locality5").equals(attribute)) {
			query.setLocality5(value);
		} else if (("Locality6").equals(attribute)) {
			query.setLocality6(value);
		} else if (("Number1").equals(attribute)) {
			query.setNumber1(value);
		} else if (("Number2").equals(attribute)) {
			query.setNumber2(value);
		} else if (("Number3").equals(attribute)) {
			query.setNumber3(value);
		} else if (("Number4").equals(attribute)) {
			query.setNumber4(value);
		} else if (("Number5").equals(attribute)) {
			query.setNumber5(value);
		} else if (("Number6").equals(attribute)) {
			query.setNumber6(value);
		} else if (("Organization1").equals(attribute)) {
			query.setOrganization1(value);
		} else if (("Organization2").equals(attribute)) {
			query.setOrganization2(value);
		} else if (("Organization3").equals(attribute)) {
			query.setOrganization3(value);
		} else if (("PostalCode1").equals(attribute)) {
			query.setPostalCode1(value);
		} else if (("PostalCode2").equals(attribute)) {
			query.setPostalCode2(value);
		} else if (("PostalCode3").equals(attribute)) {
			query.setPostalCode3(value);
		} else if (("Province1").equals(attribute)) {
			query.setProvince1(value);
		} else if (("Province2").equals(attribute)) {
			query.setProvince2(value);
		} else if (("Province3").equals(attribute)) {
			query.setProvince3(value);
		} else if (("Province4").equals(attribute)) {
			query.setProvince4(value);
		} else if (("Province5").equals(attribute)) {
			query.setProvince5(value);
		} else if (("Province6").equals(attribute)) {
			query.setProvince6(value);
		} else if (("RecipientLine1").equals(attribute)) {
			query.setRecipientLine1(value);
		} else if (("RecipientLine2").equals(attribute)) {
			query.setRecipientLine2(value);
		} else if (("RecipientLine3").equals(attribute)) {
			query.setRecipientLine3(value);
		} else if (("Residue1").equals(attribute)) {
			query.setResidue1(value);
		} else if (("Residue2").equals(attribute)) {
			query.setResidue2(value);
		} else if (("Residue3").equals(attribute)) {
			query.setResidue3(value);
		} else if (("Residue4").equals(attribute)) {
			query.setResidue4(value);
		} else if (("Residue5").equals(attribute)) {
			query.setResidue5(value);
		} else if (("Residue6").equals(attribute)) {
			query.setResidue6(value);
		} else if (("Street1").equals(attribute)) {
			query.setStreet1(value);
		} else if (("Street2").equals(attribute)) {
			query.setStreet2(value);
		} else if (("Street3").equals(attribute)) {
			query.setStreet3(value);
		} else if (("Street4").equals(attribute)) {
			query.setStreet4(value);
		} else if (("Street5").equals(attribute)) {
			query.setStreet5(value);
		} else if (("Street6").equals(attribute)) {
			query.setStreet6(value);
		} else if (("SubBuilding1").equals(attribute)) {
			query.setSubBuilding1(value);
		} else if (("SubBuilding2").equals(attribute)) {
			query.setSubBuilding2(value);
		} else if (("SubBuilding3").equals(attribute)) {
			query.setSubBuilding3(value);
		} else if (("SubBuilding4").equals(attribute)) {
			query.setSubBuilding4(value);
		} else if (("SubBuilding5").equals(attribute)) {
			query.setSubBuilding5(value);
		} else if (("SubBuilding6").equals(attribute)) {
			query.setSubBuilding6(value);
		} else if (("PreferredScript").equals(attribute)) {
			query.setPreferredScript(value);
		} else if (("PreferredLanguage").equals(attribute)) {
			query.setPreferredLanguage(value);
		} else if (("CharacterScriptDetectionIndicator").equals(attribute)) {
			Boolean csi = "true".equals(value) ? true : false;
			query.setCharacterScriptDetectionIndicator(csi);
		} else if ("ValidatedAddress_Result".equals(attribute)) {
			map.put("ValidatedAddress_Result", value);
		} else if ("CertifiedAddress_Result".equals(attribute)) {
			map.put("CertifiedAddress_Result", value);
		} else if ("LooselyValidated_Result".equals(attribute)) {
			map.put("LooselyValidated_Result", value);
		} else if ("AddressSuggestions_Result".equals(attribute)) {
			map.put("AddressSuggestions_Result", value);
		} else if ("FastCompletionAddress_Result".equals(attribute)) {
			map.put("FastCompletionAddress_Result", value);
		}else {
			return;
		}
	}
}
