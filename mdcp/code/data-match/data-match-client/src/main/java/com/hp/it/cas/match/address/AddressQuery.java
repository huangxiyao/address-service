package com.hp.it.cas.match.address;

import javax.validation.constraints.NotNull;
import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;

/**
 * An inbound address search.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class AddressQuery {
	private String key1;
	private String key2;
	private String key3;
	private String country1;
	private String country2;
	private String country3;
	private String locality1;
	private String locality2;
	private String locality3;
	private String locality4;
	private String locality5;
	private String locality6;
	private String province1;
	private String province2;
	private String province3;
	private String province4;
	private String province5;
	private String province6;
	private String postalCode1;
	private String postalCode2;
	private String postalCode3;
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
	private String building1;
	private String building2;
	private String building3;
	private String building4;
	private String building5;
	private String building6;
	private String subBuilding1;
	private String subBuilding2;
	private String subBuilding3;
	private String subBuilding4;
	private String subBuilding5;
	private String subBuilding6;
	private String deliveryService1;
	private String deliveryService2;
	private String deliveryService3;
	private String deliveryService4;
	private String deliveryService5;
	private String deliveryService6;
	private String organization1;
	private String organization2;
	private String organization3;
	private String contact1;
	private String contact2;
	private String contact3;
	private String residue1;
	private String residue2;
	private String residue3;
	private String residue4;
	private String residue5;
	private String residue6;
	private String recipientLine1;
	private String recipientLine2;
	private String recipientLine3;
	private String deliveryAddressLine1;
	private String deliveryAddressLine2;
	private String deliveryAddressLine3;
	private String deliveryAddressLine4;
	private String deliveryAddressLine5;
	private String deliveryAddressLine6;
	private String countrySpecificLocalityLine1;
	private String countrySpecificLocalityLine2;
	private String countrySpecificLocalityLine3;
	private String countrySpecificLocalityLine4;
	private String countrySpecificLocalityLine5;
	private String countrySpecificLocalityLine6;
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
	private String addressComplete;
	// Santhosh TODO
	private String preferredScript;
	private String preferredLanguage;

	/**
	 * The complete address as one string, lines are separated by delimiters
	 * 
	 * @return complete address
	 */
	public String getAddressComplete() {
		return addressComplete;
	}

	/**
	 * The complete address as one string, lines are separated by delimiters
	 * 
	 * @param addressComplete
	 *            the complete address
	 */
	public void setAddressComplete(String addressComplete) {
		this.addressComplete = addressComplete;
	}

	/**
	 * Reflected value. The key that is handed in will be returned with the address query result.
	 * 
	 * @param key1
	 *            the key
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * Reflected value. The key that is handed in will be returned with the address query result.
	 * 
	 * @param key2
	 *            the key
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * Reflected value. The key that is handed in will be returned with the address query result.
	 * 
	 * @param key3
	 *            the key
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}

	/**
	 * Sets the country level 1.
	 * 
	 * @param country1
	 *            the country
	 */
	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	/**
	 * Set the country level 2
	 * 
	 * @param country2
	 *            the country
	 */
	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	/**
	 * Set the country level 3
	 * 
	 * @param country3
	 *            the country
	 */
	public void setCountry3(String country3) {
		this.country3 = country3;
	}

	/**
	 * Set the locality level 1
	 * 
	 * @param locality1
	 *            the country city
	 */
	public void setLocality1(String locality1) {
		this.locality1 = locality1;
	}

	/**
	 * Set the locality level 2
	 * 
	 * @param locality2
	 *            the country city
	 */
	public void setLocality2(String locality2) {
		this.locality2 = locality2;
	}

	/**
	 * Set the locality level 3
	 * 
	 * @param locality3
	 *            the country city
	 */
	public void setLocality3(String locality3) {
		this.locality3 = locality3;
	}

	/**
	 * Set the locality level 4
	 * 
	 * @param locality4
	 *            the country city
	 */
	public void setLocality4(String locality4) {
		this.locality4 = locality4;
	}

	/**
	 * Set the locality level 5
	 * 
	 * @param locality5
	 *            the country city
	 */
	public void setLocality5(String locality5) {
		this.locality5 = locality5;
	}

	/**
	 * Set the locality level 6
	 * 
	 * @param locality6
	 *            the country city
	 */
	public void setLocality6(String locality6) {
		this.locality6 = locality6;
	}

	/**
	 * Set a state, province, canton, prefecture or other subdivision of a country level 1
	 * 
	 * @param province1
	 *            country subdivision
	 */
	public void setProvince1(String province1) {
		this.province1 = province1;
	}

	/**
	 * Set a state, province, canton, prefecture or other su-division of a country level 2
	 * 
	 * @param province2
	 *            country subdivision
	 */
	public void setProvince2(String province2) {
		this.province2 = province2;
	}

	/**
	 * Set a state, province, canton, prefecture or other su-division of a country level 3
	 * 
	 * @param province3
	 *            country subdivision
	 */
	public void setProvince3(String province3) {
		this.province3 = province3;
	}

	/**
	 * Set a state, province, canton, prefecture or other su-division of a country level 4
	 * 
	 * @param province4
	 *            country subdivision
	 */
	public void setProvince4(String province4) {
		this.province4 = province4;
	}

	/**
	 * Set a state, province, canton, prefecture or other su-division of a country level 5
	 * 
	 * @param province5
	 *            country subdivision
	 */
	public void setProvince5(String province5) {
		this.province5 = province5;
	}

	/**
	 * Set a state, province, canton, prefecture or other su-division of a country level 6
	 * 
	 * @param province6
	 *            country subdivision
	 */
	public void setProvince6(String province6) {
		this.province6 = province6;
	}

	/**
	 * Set postal code or zip code level 1
	 * 
	 * @param postalCode1
	 *            postal codes
	 */
	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	/**
	 * Set postal code or zip code level 2
	 * 
	 * @param postalCode2
	 *            postal codes
	 */
	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	/**
	 * Set postal code or zip code level 3
	 * 
	 * @param postalCode3
	 *            postal codes
	 */
	public void setPostalCode3(String postalCode3) {
		this.postalCode3 = postalCode3;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 1
	 * 
	 * @param street1
	 *            streets or thoroughfares
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 2
	 * 
	 * @param street2
	 *            streets or thoroughfares
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 3
	 * 
	 * @param street3
	 *            streets or thoroughfares
	 */
	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 4
	 * 
	 * @param street4
	 *            streets or thoroughfares
	 */
	public void setStreet4(String street4) {
		this.street4 = street4;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 5
	 * 
	 * @param street5
	 *            streets or thoroughfares
	 */
	public void setStreet5(String street5) {
		this.street5 = street5;
	}

	/**
	 * Sets the names of a streets or thoroughfare level 6
	 * 
	 * @param street6
	 *            streets or thoroughfares
	 */
	public void setStreet6(String street6) {
		this.street6 = street6;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 1
	 * 
	 * @param number1
	 *            country street numbers
	 */
	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 2
	 * 
	 * @param number2
	 *            country street numbers
	 */
	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 3
	 * 
	 * @param number3
	 *            country street numbers
	 */
	public void setNumber3(String number3) {
		this.number3 = number3;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 4
	 * 
	 * @param number4
	 *            country street numbers
	 */
	public void setNumber4(String number4) {
		this.number4 = number4;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 5
	 * 
	 * @param number5
	 *            country street numbers
	 */
	public void setNumber5(String number5) {
		this.number5 = number5;
	}

	/**
	 * Sets numbers of a building/house in a street. Placement varies by country level 6
	 * 
	 * @param number6
	 *            country street numbers
	 */
	public void setNumber6(String number6) {
		this.number6 = number6;
	}

	/**
	 * Sets building name level 1. Frequently used in the United Kindom.
	 * 
	 * @param building1
	 *            building names
	 */
	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	/**
	 * Sets building name level 2. Frequently used in the United Kindom.
	 * 
	 * @param building1
	 *            building names
	 */
	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	/**
	 * Sets building name level 3. Frequently used in the United Kindom.
	 * 
	 * @param building3
	 *            building names
	 */
	public void setBuilding3(String building3) {
		this.building3 = building3;
	}

	/**
	 * Sets building name level 4. Frequently used in the United Kindom.
	 * 
	 * @param building4
	 *            building names
	 */
	public void setBuilding4(String building4) {
		this.building4 = building4;
	}

	/**
	 * Sets building name level 5. Frequently used in the United Kindom.
	 * 
	 * @param building5
	 *            building names
	 */
	public void setBuilding5(String building5) {
		this.building5 = building5;
	}

	/**
	 * Sets building name level 6. Frequently used in the United Kindom.
	 * 
	 * @param building6
	 *            building names
	 */
	public void setBuilding6(String building6) {
		this.building6 = building6;
	}

	/**
	 * Set level 1 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding1
	 *            subBuildings
	 */
	public void setSubBuilding1(String subBuilding1) {
		this.subBuilding1 = subBuilding1;
	}

	/**
	 * Set level 2 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding2
	 *            subBuildings
	 */
	public void setSubBuilding2(String subBuilding2) {
		this.subBuilding2 = subBuilding2;
	}

	/**
	 * Set level 3 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding3
	 *            subBuildings
	 */
	public void setSubBuilding3(String subBuilding3) {
		this.subBuilding3 = subBuilding3;
	}

	/**
	 * Set level 4 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding4
	 *            subBuildings
	 */
	public void setSubBuilding4(String subBuilding4) {
		this.subBuilding4 = subBuilding4;
	}

	/**
	 * Set level 5 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding5
	 *            subBuildings
	 */
	public void setSubBuilding5(String subBuilding5) {
		this.subBuilding5 = subBuilding5;
	}

	/**
	 * Set level 6 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @param subBuilding6
	 *            subBuildings
	 */
	public void setSubBuilding6(String subBuilding6) {
		this.subBuilding6 = subBuilding6;
	}

	/**
	 * Set the level 1 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService1
	 *            delivery services
	 */
	public void setDeliveryService1(String deliveryService1) {
		this.deliveryService1 = deliveryService1;
	}

	/**
	 * Set the level 2 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService2
	 *            delivery services
	 */
	public void setDeliveryService2(String deliveryService2) {
		this.deliveryService2 = deliveryService2;
	}

	/**
	 * Set the level 3 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService3
	 *            delivery services
	 */
	public void setDeliveryService3(String deliveryService3) {
		this.deliveryService3 = deliveryService3;
	}

	/**
	 * Set the level 4 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService4
	 *            delivery services
	 */
	public void setDeliveryService4(String deliveryService4) {
		this.deliveryService4 = deliveryService4;
	}

	/**
	 * Set the level 5 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService5
	 *            delivery services
	 */
	public void setDeliveryService5(String deliveryService5) {
		this.deliveryService5 = deliveryService5;
	}

	/**
	 * Set the level 6 code of the respective post office in charge of delivery
	 * 
	 * @param deliveryService6
	 *            delivery services
	 */
	public void setDeliveryService6(String deliveryService6) {
		this.deliveryService6 = deliveryService6;
	}

	/**
	 * Set the level 1 company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @param organization1
	 *            organizations
	 */
	public void setOrganization1(String organization1) {
		this.organization1 = organization1;
	}

	/**
	 * Set the level 2 company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @param organization2
	 *            organizations
	 */
	public void setOrganization2(String organization2) {
		this.organization2 = organization2;
	}

	/**
	 * Set the level 3 company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @param organization3
	 *            organizations
	 */
	public void setOrganization3(String organization3) {
		this.organization3 = organization3;
	}

	/**
	 * Set the level 1 contact name
	 * 
	 * @param contact1
	 *            names of person
	 */
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	/**
	 * Set the level 2 contact name
	 * 
	 * @param contact2
	 *            names of person
	 */
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	/**
	 * Set the level 3 contact name
	 * 
	 * @param contact3
	 *            names of person
	 */
	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}

	/**
	 * Set level 1 postally irrelevant information
	 * 
	 * @param residue
	 *            residue1
	 */
	public void setResidue1(String residue1) {
		this.residue1 = residue1;
	}

	/**
	 * Set level 2 postally irrelevant information
	 * 
	 * @param residue
	 *            residue2
	 */
	public void setResidue2(String residue2) {
		this.residue2 = residue2;
	}

	/**
	 * Set level 3 postally irrelevant information
	 * 
	 * @param residue
	 *            residue3
	 */
	public void setResidue3(String residue3) {
		this.residue3 = residue3;
	}

	/**
	 * Set level 4 postally irrelevant information
	 * 
	 * @param residue
	 *            residue4
	 */
	public void setResidue4(String residue4) {
		this.residue4 = residue4;
	}

	/**
	 * Set level 5 postally irrelevant information
	 * 
	 * @param residue
	 *            residue5
	 */
	public void setResidue5(String residue5) {
		this.residue5 = residue5;
	}

	/**
	 * Set level 6 postally irrelevant information
	 * 
	 * @param residue
	 *            residue6
	 */
	public void setResidue6(String residue6) {
		this.residue6 = residue6;
	}

	/**
	 * Set level 1 recipient line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param recipientLine1
	 *            recipient lines
	 */
	public void setRecipientLine1(String recipientLine1) {
		this.recipientLine1 = recipientLine1;
	}

	/**
	 * Set level 2 recipient line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param recipientLine2
	 *            recipient lines
	 */
	public void setRecipientLine2(String recipientLine2) {
		this.recipientLine2 = recipientLine2;
	}

	/**
	 * Set level 3 recipient line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param recipientLine3
	 *            recipient lines
	 */
	public void setRecipientLine3(String recipientLine3) {
		this.recipientLine3 = recipientLine3;
	}

	/**
	 * Set level 1 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine1
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine1(String deliveryAddressLine1) {
		this.deliveryAddressLine1 = deliveryAddressLine1;
	}

	/**
	 * Set level 2 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine2
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine2(String deliveryAddressLine2) {
		this.deliveryAddressLine2 = deliveryAddressLine2;
	}

	/**
	 * Set level 3 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine3
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine3(String deliveryAddressLine3) {
		this.deliveryAddressLine3 = deliveryAddressLine3;
	}

	/**
	 * Set level 4 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine4
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine4(String deliveryAddressLine4) {
		this.deliveryAddressLine4 = deliveryAddressLine4;
	}

	/**
	 * Set level 5 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine5
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine5(String deliveryAddressLine5) {
		this.deliveryAddressLine5 = deliveryAddressLine5;
	}

	/**
	 * Set level 6 delivery address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param deliveryAddressLine6
	 *            delivery address lines
	 */
	public void setDeliveryAddressLine6(String deliveryAddressLine6) {
		this.deliveryAddressLine6 = deliveryAddressLine6;
	}

	public void setCountrySpecificLocalityLine1(String countrySpecificLocalityLine1) {
		this.countrySpecificLocalityLine1 = countrySpecificLocalityLine1;
	}

	public void setCountrySpecificLocalityLine2(String countrySpecificLocalityLine2) {
		this.countrySpecificLocalityLine2 = countrySpecificLocalityLine2;
	}

	public void setCountrySpecificLocalityLine3(String countrySpecificLocalityLine3) {
		this.countrySpecificLocalityLine3 = countrySpecificLocalityLine3;
	}

	public void setCountrySpecificLocalityLine4(String countrySpecificLocalityLine4) {
		this.countrySpecificLocalityLine4 = countrySpecificLocalityLine4;
	}

	public void setCountrySpecificLocalityLine5(String countrySpecificLocalityLine5) {
		this.countrySpecificLocalityLine5 = countrySpecificLocalityLine5;
	}

	public void setCountrySpecificLocalityLine6(String countrySpecificLocalityLine6) {
		this.countrySpecificLocalityLine6 = countrySpecificLocalityLine6;
	}

	/**
	 * Set level 2 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine2
	 *            formatted address lines
	 */
	public void setFormattedAddressLine1(String formattedAddressLine1) {
		this.formattedAddressLine1 = formattedAddressLine1;
	}

	/**
	 * Set level 3 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine3
	 *            formatted address lines
	 */
	public void setFormattedAddressLine2(String formattedAddressLine2) {
		this.formattedAddressLine2 = formattedAddressLine2;
	}

	/**
	 * Set level 4 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine4
	 *            formatted address lines
	 */
	public void setFormattedAddressLine3(String formattedAddressLine3) {
		this.formattedAddressLine3 = formattedAddressLine3;
	}

	/**
	 * Set level 5 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine5
	 *            formatted address lines
	 */
	public void setFormattedAddressLine4(String formattedAddressLine4) {
		this.formattedAddressLine4 = formattedAddressLine4;
	}

	/**
	 * Set level 6 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine6
	 *            formatted address lines
	 */
	public void setFormattedAddressLine5(String formattedAddressLine5) {
		this.formattedAddressLine5 = formattedAddressLine5;
	}

	/**
	 * Set level 7 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine7
	 *            formatted address lines
	 */
	public void setFormattedAddressLine6(String formattedAddressLine6) {
		this.formattedAddressLine6 = formattedAddressLine6;
	}

	/**
	 * Set level 8 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine8
	 *            formatted address lines
	 */
	public void setFormattedAddressLine7(String formattedAddressLine7) {
		this.formattedAddressLine7 = formattedAddressLine7;
	}

	/**
	 * Set level 9 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine9
	 *            formatted address lines
	 */
	public void setFormattedAddressLine8(String formattedAddressLine8) {
		this.formattedAddressLine8 = formattedAddressLine8;
	}

	/**
	 * Set level 10 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine10
	 *            formatted address lines
	 */
	public void setFormattedAddressLine9(String formattedAddressLine9) {
		this.formattedAddressLine9 = formattedAddressLine9;
	}

	/**
	 * Set level 11 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine11
	 *            formatted address lines
	 */
	public void setFormattedAddressLine10(String formattedAddressLine10) {
		this.formattedAddressLine10 = formattedAddressLine10;
	}

	public void setFormattedAddressLine11(String formattedAddressLine11) {
		this.formattedAddressLine11 = formattedAddressLine11;
	}

	/**
	 * Set level 12 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine12
	 *            formatted address lines
	 */
	public void setFormattedAddressLine12(String formattedAddressLine12) {
		this.formattedAddressLine12 = formattedAddressLine12;
	}

	/**
	 * Set level 13 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine13
	 *            formatted address lines
	 */
	public void setFormattedAddressLine13(String formattedAddressLine13) {
		this.formattedAddressLine13 = formattedAddressLine13;
	}

	/**
	 * Set level 14 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine14
	 *            formatted address lines
	 */
	public void setFormattedAddressLine14(String formattedAddressLine14) {
		this.formattedAddressLine14 = formattedAddressLine14;
	}

	/**
	 * Set level 15 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine15
	 *            formatted address lines
	 */
	public void setFormattedAddressLine15(String formattedAddressLine15) {
		this.formattedAddressLine15 = formattedAddressLine15;
	}

	/**
	 * Set level 16 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine16
	 *            formatted address lines
	 */
	public void setFormattedAddressLine16(String formattedAddressLine16) {
		this.formattedAddressLine16 = formattedAddressLine16;
	}

	/**
	 * Set level 17 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine17
	 *            formatted address lines
	 */
	public void setFormattedAddressLine17(String formattedAddressLine17) {
		this.formattedAddressLine17 = formattedAddressLine17;
	}

	/**
	 * Set level 18 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine18
	 *            formatted address lines
	 */
	public void setFormattedAddressLine18(String formattedAddressLine18) {
		this.formattedAddressLine18 = formattedAddressLine18;
	}

	/**
	 * Set level 19 formatted address line
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @param formattedAddressLine19
	 *            formatted address lines
	 */
	public void setFormattedAddressLine19(String formattedAddressLine19) {
		this.formattedAddressLine19 = formattedAddressLine19;
	}

	/**
	 * Reflected value. The level 1 key that was handed in originally.
	 * 
	 * @return key1
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * Reflected value. The level 2 key that was handed in originally.
	 * 
	 * @return key2
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * Reflected value. The level 3 key that was handed in originally.
	 * 
	 * @return key3
	 */
	public String getKey3() {
		return key3;
	}

	/**
	 * Returns the level 1 country.
	 * 
	 * @return country level 1
	 */

	@NotNull(message = "{120482.addressDoctor.validation.constraints.NotNull.message}")
	public String getCountry1() {
		return country1;
	}

	/**
	 * Returns the level 2 country.
	 * 
	 * @return country level 2
	 */
	public String getCountry2() {
		return country2;
	}

	/**
	 * Returns the level 3 country.
	 * 
	 * @return country level 3
	 */
	public String getCountry3() {
		return country3;
	}

	/**
	 * Get level 1 city
	 * 
	 * @return level 1 city
	 */
	public String getLocality1() {
		return locality1;
	}

	/**
	 * Get level 2 city
	 * 
	 * @return level 2 city
	 */
	public String getLocality2() {
		return locality2;
	}

	/**
	 * Get level 3 city
	 * 
	 * @return level 3 city
	 */
	public String getLocality3() {
		return locality3;
	}

	/**
	 * Get level 4 city
	 * 
	 * @return level 4 city
	 */
	public String getLocality4() {
		return locality4;
	}

	/**
	 * Get level 5 city
	 * 
	 * @return level 5 city
	 */
	public String getLocality5() {
		return locality5;
	}

	/**
	 * Get level 6 city
	 * 
	 * @return level 6 city
	 */
	public String getLocality6() {
		return locality6;
	}

	/**
	 * Returns a level 1 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 1
	 */
	public String getProvince1() {
		return province1;
	}

	/**
	 * Returns a level 2 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 2
	 */
	public String getProvince2() {
		return province2;
	}

	/**
	 * Returns a level 3 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 3
	 */
	public String getProvince3() {
		return province3;
	}

	/**
	 * Returns a level 4 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 4
	 */
	public String getProvince4() {
		return province4;
	}

	/**
	 * Returns a level 5 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 5
	 */
	public String getProvince5() {
		return province5;
	}

	/**
	 * Returns a level 6 state, province, canton, prefecture or other sub-division of a country.
	 * 
	 * @return country subdivision level 6
	 */
	public String getProvince6() {
		return province6;
	}

	/**
	 * Returns the level 1 postal codes or zip codes.
	 * 
	 * @return level 1 postal code
	 */
	public String getPostalCode1() {
		return postalCode1;
	}

	/**
	 * Returns the level 2 postal codes or zip codes.
	 * 
	 * @return level 2 postal code
	 */
	public String getPostalCode2() {
		return postalCode2;
	}

	/**
	 * Returns the level 3 postal codes or zip codes.
	 * 
	 * @return level 3 postal code
	 */
	public String getPostalCode3() {
		return postalCode3;
	}

	/**
	 * Returns level 1 name of the street or thoroughfare
	 * 
	 * @return level 1 name of street or thoroughfare
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Returns level 2 name of the street or thoroughfare
	 * 
	 * @return level 2 name of street or thoroughfare
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * Returns level 3 name of the street or thoroughfare
	 * 
	 * @return level 3 name of street or thoroughfare
	 */
	public String getStreet3() {
		return street3;
	}

	/**
	 * Returns level 4 name of the street or thoroughfare
	 * 
	 * @return level 4 name of street or thoroughfare
	 */
	public String getStreet4() {
		return street4;
	}

	/**
	 * Returns level 5 name of the street or thoroughfare
	 * 
	 * @return level 5 name of street or thoroughfare
	 */
	public String getStreet5() {
		return street5;
	}

	/**
	 * Returns level 6 name of the street or thoroughfare
	 * 
	 * @return level 6 name of street or thoroughfare
	 */
	public String getStreet6() {
		return street6;
	}

	/**
	 * Returns the level 1 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 1 country street number
	 */
	public String getNumber1() {
		return number1;
	}

	/**
	 * Returns the level 2 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 2 country street number
	 */
	public String getNumber2() {
		return number2;
	}

	/**
	 * Returns the level 3 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 3 country street number
	 */
	public String getNumber3() {
		return number3;
	}

	/**
	 * Returns the level 4 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 4 country street number
	 */
	public String getNumber4() {
		return number4;
	}

	/**
	 * Returns the level 5 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 5 country street number
	 */
	public String getNumber5() {
		return number5;
	}

	/**
	 * Returns the level 6 number of a Building/House in a street. Placement varies by country.
	 * 
	 * @return level 6 country street number
	 */
	public String getNumber6() {
		return number6;
	}

	/**
	 * Level 1 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 1 building name
	 */
	public String getBuilding1() {
		return building1;
	}

	/**
	 * Level 2 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 2 building name
	 */
	public String getBuilding2() {
		return building2;
	}

	/**
	 * Level 3 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 3 building name
	 */
	public String getBuilding3() {
		return building3;
	}

	/**
	 * Level 4 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 4 building name
	 */
	public String getBuilding4() {
		return building4;
	}

	/**
	 * Level 5 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 5 building name
	 */
	public String getBuilding5() {
		return building5;
	}

	/**
	 * Level 6 Building name. Frequently used in the United Kingdom
	 * 
	 * @return level 6 building name
	 */
	public String getBuilding6() {
		return building6;
	}

	/**
	 * Level 1 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 1 subBuilding
	 */
	public String getSubBuilding1() {
		return subBuilding1;
	}

	/**
	 * Level 2 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 2 subBuilding
	 */
	public String getSubBuilding2() {
		return subBuilding2;
	}

	/**
	 * Level 3 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 3 subBuilding
	 */
	public String getSubBuilding3() {
		return subBuilding3;
	}

	/**
	 * Level 4 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 4 subBuilding
	 */
	public String getSubBuilding4() {
		return subBuilding4;
	}

	/**
	 * Level 5 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 5 subBuilding
	 */
	public String getSubBuilding5() {
		return subBuilding5;
	}

	/**
	 * Level 6 information that further subdivides a Building, e.g. the floor.
	 * 
	 * @return level 6 subBuilding
	 */
	public String getSubBuilding6() {
		return subBuilding6;
	}

	/**
	 * Level 1 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 1
	 */
	public String getDeliveryService1() {
		return deliveryService1;
	}

	/**
	 * Level 2 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 2
	 */
	public String getDeliveryService2() {
		return deliveryService2;
	}

	/**
	 * Level 3 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 3
	 */
	public String getDeliveryService3() {
		return deliveryService3;
	}

	/**
	 * Level 4 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 4
	 */
	public String getDeliveryService4() {
		return deliveryService4;
	}

	/**
	 * Level 5 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 5
	 */
	public String getDeliveryService5() {
		return deliveryService5;
	}

	/**
	 * Level 6 code of the respective post office in charge of delivery.
	 * 
	 * @return delivery services level 6
	 */
	public String getDeliveryService6() {
		return deliveryService6;
	}

	/**
	 * Level 1 Company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @return organization level 1
	 */
	public String getOrganization1() {
		return organization1;
	}

	/**
	 * Level 2 Company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @return organization level 2
	 */
	public String getOrganization2() {
		return organization2;
	}

	/**
	 * Level 3 Company or Organization name including a company type descriptor such as Inc., AG, or GmbH
	 * 
	 * @return organization level 3
	 */
	public String getOrganization3() {
		return organization3;
	}

	/**
	 * Level 1 name of contact
	 * 
	 * @return person level 1
	 */
	public String getContact1() {
		return contact1;
	}

	/**
	 * Level 2 name of contact
	 * 
	 * @return person level 2
	 */
	public String getContact2() {
		return contact2;
	}

	/**
	 * Level 3 name of contact
	 * 
	 * @return person level 3
	 */
	public String getContact3() {
		return contact3;
	}

	/**
	 * Level 1 postally irrelevant information.
	 * 
	 * @return residue level 1
	 */
	public String getResidue1() {
		return residue1;
	}

	/**
	 * Level 2 postally irrelevant information.
	 * 
	 * @return residue level 2
	 */
	public String getResidue2() {
		return residue2;
	}

	/**
	 * Level 3 postally irrelevant information.
	 * 
	 * @return residue level 3
	 */
	public String getResidue3() {
		return residue3;
	}

	/**
	 * Level 4 postally irrelevant information.
	 * 
	 * @return residue level 4
	 */
	public String getResidue4() {
		return residue4;
	}

	/**
	 * Level 5 postally irrelevant information.
	 * 
	 * @return residue level 5
	 */
	public String getResidue5() {
		return residue5;
	}

	/**
	 * Level 6 postally irrelevant information.
	 * 
	 * @return residue level 6
	 */
	public String getResidue6() {
		return residue6;
	}

	/**
	 * Returns recipient line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return recipient line level 1
	 */
	public String getRecipientLine1() {
		return recipientLine1;
	}

	/**
	 * Returns recipient line level 2
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return recipient line level 2
	 */
	public String getRecipientLine2() {
		return recipientLine2;
	}

	/**
	 * Returns recipient line level 3
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return recipient line level 3
	 */
	public String getRecipientLine3() {
		return recipientLine3;
	}

	/**
	 * Returns delivery address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 1
	 */
	public String getDeliveryAddressLine1() {
		return deliveryAddressLine1;
	}

	/**
	 * Returns delivery address line level 2
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 2
	 */
	public String getDeliveryAddressLine2() {
		return deliveryAddressLine2;
	}

	/**
	 * Returns delivery address line level 3
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 3
	 */
	public String getDeliveryAddressLine3() {
		return deliveryAddressLine3;
	}

	/**
	 * Returns delivery address line level 4
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 4
	 */
	public String getDeliveryAddressLine4() {
		return deliveryAddressLine4;
	}

	/**
	 * Returns delivery address line level 5
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 5
	 */
	public String getDeliveryAddressLine5() {
		return deliveryAddressLine5;
	}

	/**
	 * Returns delivery address line level 6
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return delivery address line level 6
	 */
	public String getDeliveryAddressLine6() {
		return deliveryAddressLine6;
	}

	/**
	 * Get country specific locality line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 1
	 */
	public String getCountrySpecificLocalityLine1() {
		return countrySpecificLocalityLine1;
	}

	/**
	 * Get country specific locality line level 2
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 2
	 */
	public String getCountrySpecificLocalityLine2() {
		return countrySpecificLocalityLine2;
	}

	/**
	 * Get country specific locality line level 3
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 3
	 */
	public String getCountrySpecificLocalityLine3() {
		return countrySpecificLocalityLine3;
	}

	/**
	 * Get country specific locality line level 4
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 4
	 */
	public String getCountrySpecificLocalityLine4() {
		return countrySpecificLocalityLine4;
	}

	/**
	 * Get country specific locality line level 5
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 5
	 */
	public String getCountrySpecificLocalityLine5() {
		return countrySpecificLocalityLine5;
	}

	/**
	 * Get country specific locality line level 6
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return country specific locality line level 6
	 */
	public String getCountrySpecificLocalityLine6() {
		return countrySpecificLocalityLine6;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine1() {
		return formattedAddressLine1;
	}

	/**
	 * Get formatted address line level 2
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 2
	 */
	public String getFormattedAddressLine2() {
		return formattedAddressLine2;
	}

	/**
	 * Get formatted address line level 3
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 3
	 */
	public String getFormattedAddressLine3() {
		return formattedAddressLine3;
	}

	/**
	 * Get formatted address line level 4
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 4
	 */
	public String getFormattedAddressLine4() {
		return formattedAddressLine4;
	}

	/**
	 * Get formatted address line level 5
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 5
	 */
	public String getFormattedAddressLine5() {
		return formattedAddressLine5;
	}

	/**
	 * Get formatted address line level 6
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 6
	 */
	public String getFormattedAddressLine6() {
		return formattedAddressLine6;
	}

	/**
	 * Get formatted address line level 7
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine7() {
		return formattedAddressLine7;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine8() {
		return formattedAddressLine8;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine9() {
		return formattedAddressLine9;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine10() {
		return formattedAddressLine10;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine11() {
		return formattedAddressLine11;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine12() {
		return formattedAddressLine12;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine13() {
		return formattedAddressLine13;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine14() {
		return formattedAddressLine14;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine15() {
		return formattedAddressLine15;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine16() {
		return formattedAddressLine16;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine17() {
		return formattedAddressLine17;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine18() {
		return formattedAddressLine18;
	}

	/**
	 * Get formatted address line level 1
	 * 
	 * TODO Don't have a very good definition of address lines
	 * 
	 * @return formatted address line level 1
	 */
	public String getFormattedAddressLine19() {
		return formattedAddressLine19;
	}

	private String separator(boolean firstInvocation) {
		return firstInvocation ? "" : ", ";
	}

	/**
	 * TODO
	 * 
	 * TODO 
	 * 
	 * @return preferred script
	 */
	public String getPreferredScript() {
		return preferredScript;
	}

	/**
	 * TODO
	 * 
	 * TODO 
	 * 
	 * @return 
	 */
	public void setPreferredScript(String preferredScript) {
		this.preferredScript = preferredScript;
	}
	
	
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	@Override
	public String toString() {
		boolean firstInvocation = true;
		StringBuilder builder = new StringBuilder();
		builder.append("AddressQuery [");

		if (!isNullOrEmpty(key1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("key1=");
			builder.append(key1);
		}
		if (!isNullOrEmpty(key2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("key2=");
			builder.append(key2);
		}
		if (!isNullOrEmpty(key3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("key3=");
			builder.append(key3);
		}

		if (!isNullOrEmpty(country1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("country1=");
			builder.append(country1);
		}

		if (!isNullOrEmpty(country2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("country2=");
			builder.append(country2);
		}

		if (!isNullOrEmpty(country3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("country3=");
			builder.append(country3);
		}

		if (!isNullOrEmpty(locality1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality1=");
			builder.append(locality1);
		}

		if (!isNullOrEmpty(locality2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality2=");
			builder.append(locality2);
		}

		if (!isNullOrEmpty(locality3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality3=");
			builder.append(locality3);
		}

		if (!isNullOrEmpty(locality3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality3=");
			builder.append(locality3);
		}

		if (!isNullOrEmpty(locality4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality4=");
			builder.append(locality4);
		}

		if (!isNullOrEmpty(locality5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality5=");
			builder.append(locality5);
		}

		if (!isNullOrEmpty(locality6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("locality6=");
			builder.append(locality6);
		}

		if (!isNullOrEmpty(province1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province1=");
			builder.append(province1);
		}

		if (!isNullOrEmpty(province2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province2=");
			builder.append(province2);
		}

		if (!isNullOrEmpty(province3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province3=");
			builder.append(province3);
		}

		if (!isNullOrEmpty(province4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province4=");
			builder.append(province4);
		}

		if (!isNullOrEmpty(province5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province5=");
			builder.append(province5);
		}

		if (!isNullOrEmpty(province6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("province6=");
			builder.append(province6);
		}

		if (!isNullOrEmpty(postalCode1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("postalCode1=");
			builder.append(postalCode1);
		}

		if (!isNullOrEmpty(postalCode2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("postalCode2=");
			builder.append(postalCode2);
		}

		if (!isNullOrEmpty(postalCode3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("postalCode3=");
			builder.append(postalCode3);
		}

		if (!isNullOrEmpty(street1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street1=");
			builder.append(street1);
		}

		if (!isNullOrEmpty(street2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street2=");
			builder.append(street2);
		}

		if (!isNullOrEmpty(street3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street3=");
			builder.append(street3);
		}

		if (!isNullOrEmpty(street4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street4=");
			builder.append(street4);
		}

		if (!isNullOrEmpty(street5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street5=");
			builder.append(street5);
		}

		if (!isNullOrEmpty(street6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("street6=");
			builder.append(street6);
		}

		if (!isNullOrEmpty(number1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number1=");
			builder.append(number1);
		}
		if (!isNullOrEmpty(number2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number2=");
			builder.append(number2);
		}
		if (!isNullOrEmpty(number3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number3=");
			builder.append(number3);
		}
		if (!isNullOrEmpty(number4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number4=");
			builder.append(number4);
		}
		if (!isNullOrEmpty(number5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number5=");
			builder.append(number5);
		}
		if (!isNullOrEmpty(number6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("number6=");
			builder.append(number6);
		}

		if (!isNullOrEmpty(building1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building1=");
			builder.append(building1);
		}

		if (!isNullOrEmpty(building2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building2=");
			builder.append(building2);
		}

		if (!isNullOrEmpty(building3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building3=");
			builder.append(building3);
		}

		if (!isNullOrEmpty(building4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building4=");
			builder.append(building4);
		}

		if (!isNullOrEmpty(building5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building5=");
			builder.append(building5);
		}

		if (!isNullOrEmpty(building6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("building6=");
			builder.append(building6);
		}

		if (!isNullOrEmpty(subBuilding1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding1=");
			builder.append(subBuilding1);
		}

		if (!isNullOrEmpty(subBuilding2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding2=");
			builder.append(subBuilding2);
		}

		if (!isNullOrEmpty(subBuilding3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding3=");
			builder.append(subBuilding3);
		}

		if (!isNullOrEmpty(subBuilding4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding4=");
			builder.append(subBuilding4);
		}

		if (!isNullOrEmpty(subBuilding5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding5=");
			builder.append(subBuilding5);
		}

		if (!isNullOrEmpty(subBuilding6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("subBuilding6=");
			builder.append(subBuilding6);
		}

		if (!isNullOrEmpty(deliveryService1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService1=");
			builder.append(deliveryService1);
		}

		if (!isNullOrEmpty(deliveryService2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService2=");
			builder.append(deliveryService2);
		}

		if (!isNullOrEmpty(deliveryService3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService3=");
			builder.append(deliveryService3);
		}

		if (!isNullOrEmpty(deliveryService4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService4=");
			builder.append(deliveryService4);
		}

		if (!isNullOrEmpty(deliveryService5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService5=");
			builder.append(deliveryService5);
		}

		if (!isNullOrEmpty(deliveryService6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryService6=");
			builder.append(deliveryService6);
		}

		if (!isNullOrEmpty(organization1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("organization1=");
			builder.append(organization1);
		}

		if (!isNullOrEmpty(organization2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("organization2=");
			builder.append(organization2);
		}

		if (!isNullOrEmpty(organization3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("organization3=");
			builder.append(organization3);
		}

		if (!isNullOrEmpty(contact1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("contact1=");
			builder.append(contact1);
		}

		if (!isNullOrEmpty(contact2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("contact2=");
			builder.append(contact2);
		}

		if (!isNullOrEmpty(contact3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("contact3=");
			builder.append(contact3);
		}

		if (!isNullOrEmpty(residue1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue1=");
			builder.append(residue1);
		}

		if (!isNullOrEmpty(residue2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue2=");
			builder.append(residue2);
		}

		if (!isNullOrEmpty(residue3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue3=");
			builder.append(residue3);
		}

		if (!isNullOrEmpty(residue4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue4=");
			builder.append(residue4);
		}

		if (!isNullOrEmpty(residue5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue5=");
			builder.append(residue5);
		}

		if (!isNullOrEmpty(residue6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("residue6=");
			builder.append(residue6);
		}

		if (!isNullOrEmpty(recipientLine1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("recipientLine1=");
			builder.append(recipientLine1);
		}

		if (!isNullOrEmpty(recipientLine2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("recipientLine2=");
			builder.append(recipientLine2);
		}

		if (!isNullOrEmpty(recipientLine3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("recipientLine3=");
			builder.append(recipientLine3);
		}

		if (!isNullOrEmpty(deliveryAddressLine1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine1=");
			builder.append(deliveryAddressLine1);
		}

		if (!isNullOrEmpty(deliveryAddressLine2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine2=");
			builder.append(deliveryAddressLine2);
		}

		if (!isNullOrEmpty(deliveryAddressLine3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine3=");
			builder.append(deliveryAddressLine3);
		}

		if (!isNullOrEmpty(deliveryAddressLine4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine4=");
			builder.append(deliveryAddressLine4);
		}

		if (!isNullOrEmpty(deliveryAddressLine5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine5=");
			builder.append(deliveryAddressLine5);
		}

		if (!isNullOrEmpty(deliveryAddressLine6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("deliveryAddressLine6=");
			builder.append(deliveryAddressLine6);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine1=");
			builder.append(countrySpecificLocalityLine1);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine2=");
			builder.append(countrySpecificLocalityLine2);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine3=");
			builder.append(countrySpecificLocalityLine3);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine4=");
			builder.append(countrySpecificLocalityLine4);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine5=");
			builder.append(countrySpecificLocalityLine5);
		}

		if (!isNullOrEmpty(countrySpecificLocalityLine6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("countrySpecificLocalityLine6=");
			builder.append(countrySpecificLocalityLine6);
		}

		if (!isNullOrEmpty(formattedAddressLine1)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine1=");
			builder.append(formattedAddressLine1);
		}

		if (!isNullOrEmpty(formattedAddressLine2)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine2=");
			builder.append(formattedAddressLine2);
		}

		if (!isNullOrEmpty(formattedAddressLine3)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine3=");
			builder.append(formattedAddressLine3);
		}

		if (!isNullOrEmpty(formattedAddressLine4)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine4=");
			builder.append(formattedAddressLine4);
		}

		if (!isNullOrEmpty(formattedAddressLine5)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine5=");
			builder.append(formattedAddressLine5);
		}

		if (!isNullOrEmpty(formattedAddressLine6)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine6=");
			builder.append(formattedAddressLine6);
		}

		if (!isNullOrEmpty(formattedAddressLine7)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine7=");
			builder.append(formattedAddressLine7);
		}

		if (!isNullOrEmpty(formattedAddressLine8)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine8=");
			builder.append(formattedAddressLine8);
		}

		if (!isNullOrEmpty(formattedAddressLine9)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine9=");
			builder.append(formattedAddressLine9);
		}

		if (!isNullOrEmpty(formattedAddressLine10)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine10=");
			builder.append(formattedAddressLine10);
		}

		if (!isNullOrEmpty(formattedAddressLine11)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine11=");
			builder.append(formattedAddressLine11);
		}

		if (!isNullOrEmpty(formattedAddressLine12)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine12=");
			builder.append(formattedAddressLine12);
		}

		if (!isNullOrEmpty(formattedAddressLine13)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine13=");
			builder.append(formattedAddressLine13);
		}

		if (!isNullOrEmpty(formattedAddressLine14)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine14=");
			builder.append(formattedAddressLine14);
		}

		if (!isNullOrEmpty(formattedAddressLine15)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine15=");
			builder.append(formattedAddressLine15);
		}

		if (!isNullOrEmpty(formattedAddressLine16)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine16=");
			builder.append(formattedAddressLine16);
		}

		if (!isNullOrEmpty(formattedAddressLine17)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine17=");
			builder.append(formattedAddressLine17);
		}

		if (!isNullOrEmpty(formattedAddressLine18)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine18=");
			builder.append(formattedAddressLine18);
		}

		if (!isNullOrEmpty(formattedAddressLine19)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("formattedAddressLine19=");
			builder.append(formattedAddressLine19);
		}

		if (!isNullOrEmpty(addressComplete)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("addressComplete=");
			builder.append(addressComplete);
		}
		
		if (!isNullOrEmpty(preferredScript)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("preferredScript=");
			builder.append(preferredScript);
		}		
		
		if (!isNullOrEmpty(preferredLanguage)) {
			builder.append(separator(firstInvocation));
			firstInvocation = false;
			builder.append("preferredLanguage=");
			builder.append(preferredLanguage);
		}		

		builder.append("]");
		return builder.toString();
	}

}
