package com.hp.it.cas.match.address;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

public class AddressQueryValidatorTest {
	private static String IRRELEVANT_VALUE = "addressValue";

	@Test
	public void validateAddressCompleteWithInvalidCombination() {
		AddressQuery query = fullAddressQuery();
		AddressQueryValidator validator = new AddressQueryValidator();
		Set<ConstraintViolation<AddressQuery>> violations = validator.validate(query);
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "building");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "contact");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "countrySpecificLocalityLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "deliveryAddressLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "deliveryService");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "formattedAddressLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "key");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "locality");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "number");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "organization");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "postalCode");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "province");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "recipientLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "residue");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "street");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "addressComplete", "subBuilding");
	}
	
	@Test
	public void validateDeliveryAddressLinesWithInvalidCombination(){
		AddressQuery query = new AddressQuery();
		query.setDeliveryAddressLine1(IRRELEVANT_VALUE);
		query.setCountry1(IRRELEVANT_VALUE);
		query.setFormattedAddressLine1(IRRELEVANT_VALUE);
		query.setStreet1(IRRELEVANT_VALUE);
		query.setNumber1(IRRELEVANT_VALUE);
		query.setBuilding1(IRRELEVANT_VALUE);
		query.setSubBuilding1(IRRELEVANT_VALUE);
		query.setDeliveryService1(IRRELEVANT_VALUE);
		
		AddressQueryValidator validator = new AddressQueryValidator();
		Set<ConstraintViolation<AddressQuery>> violations = validator.validate(query);
		
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "formattedAddressLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "street");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "number");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "building");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "subBuilding");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "deliveryAddressLine", "deliveryService");
	}
	
	@Test
	public void validateFormattedAddressLinesWithInvalidCombination(){
		AddressQuery query = fullAddressQuery();
		
		AddressQueryValidator validator = new AddressQueryValidator();
		Set<ConstraintViolation<AddressQuery>> violations = validator.validate(query);
		
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "building");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "countrySpecificLocalityLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "deliveryAddressLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "locality");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "number");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "postalCode");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "province");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "recipientLine");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "residue");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "street");
		TestUtils.assertIncludes(violations, "{120482.addressDoctor.validation.constraints.InvalidCombination.message}", "", "formattedAddressLine", "subBuilding");
	}
	
	
	private AddressQuery fullAddressQuery(){
		AddressQuery query = new AddressQuery();
		query.setBuilding1(IRRELEVANT_VALUE);
		query.setContact1(IRRELEVANT_VALUE);
		query.setCountry1(IRRELEVANT_VALUE);
		query.setCountrySpecificLocalityLine1(IRRELEVANT_VALUE);
		query.setDeliveryAddressLine1(IRRELEVANT_VALUE);
		query.setDeliveryService1(IRRELEVANT_VALUE);
		query.setFormattedAddressLine1(IRRELEVANT_VALUE);
		query.setKey1(IRRELEVANT_VALUE);
		query.setLocality1(IRRELEVANT_VALUE);
		query.setNumber1(IRRELEVANT_VALUE);
		query.setOrganization1(IRRELEVANT_VALUE);
		query.setPostalCode1(IRRELEVANT_VALUE);
		query.setProvince1(IRRELEVANT_VALUE);
		query.setRecipientLine1(IRRELEVANT_VALUE);
		query.setResidue1(IRRELEVANT_VALUE);
		query.setStreet1(IRRELEVANT_VALUE);
		query.setSubBuilding1(IRRELEVANT_VALUE);
		query.setAddressComplete(IRRELEVANT_VALUE);
		return query;
	}
}
