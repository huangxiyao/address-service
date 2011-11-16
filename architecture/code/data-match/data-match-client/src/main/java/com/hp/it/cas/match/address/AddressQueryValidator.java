package com.hp.it.cas.match.address;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.foundation.validation.Validations;

/**
 * Validates an Address Query.
 * 
 * @author paul.truax@hp.com
 *
 */
public class AddressQueryValidator extends AbstractQueryValidator {
	
	/**
	 * Validate an address query and return back a set of constraint violations.
	 * 
	 * @param query the address query
	 * @return set of constraint violations
	 */
	public Set<ConstraintViolation<AddressQuery>> validate(@NotNull AddressQuery query){
		ConstraintViolationContext<AddressQuery> context = new ConstraintViolationContext<AddressQuery>(query);
		Set<ConstraintViolation<AddressQuery>> annotationViolations = Validations.getValidator().validate(query);
		context.addAll(annotationViolations);
		if(annotationViolations.isEmpty()){
			validateCombinations(query, context);
		}
		return context.getConstraintViolations();
	}
	
	private void validateCombinations(AddressQuery query, ConstraintViolationContext<AddressQuery> errors){
		
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isFormattedAddressLinePopulated(query), "deliveryAddressLine", "formattedAddressLine", errors);
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isStreetPopulated(query), "deliveryAddressLine", "street", errors);
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isNumberPopulated(query), "deliveryAddressLine", "number", errors);
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isBuildingPopulated(query), "deliveryAddressLine", "building", errors);
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isSubBuildingPopulated(query), "deliveryAddressLine", "subBuilding", errors);
		checkForInvalidCombination(isDeliveryAddressLinePopulated(query), isDeliveryServicePopulated(query), "deliveryAddressLine", "deliveryService", errors);

		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isBuildingPopulated(query), "formattedAddressLine", "building", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isCountrySpecificLocalityLinePopulated(query), "formattedAddressLine", "countrySpecificLocalityLine", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isDeliveryAddressLinePopulated(query), "formattedAddressLine", "deliveryAddressLine", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isDeliveryServicePopulated(query), "formattedAddressLine", "deliveryService", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isLocalityPopulated(query), "formattedAddressLine", "locality", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isNumberPopulated(query), "formattedAddressLine", "number", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isPostalCodePopulated(query), "formattedAddressLine", "postalCode", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isProvincePopulated(query), "formattedAddressLine", "province", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isRecipientLinePopulated(query), "formattedAddressLine", "recipientLine", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isResiduePopulated(query), "formattedAddressLine", "residue", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isStreetPopulated(query), "formattedAddressLine", "street", errors);
		checkForInvalidCombination(isFormattedAddressLinePopulated(query), isSubBuildingPopulated(query), "formattedAddressLine", "subBuilding", errors);

		checkForInvalidCombination(isAddressCompletePopulated(query), isBuildingPopulated(query), "addressComplete", "building", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isContactsPopulated(query), "addressComplete", "contact", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isCountrySpecificLocalityLinePopulated(query), "addressComplete", "countrySpecificLocalityLine", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isDeliveryAddressLinePopulated(query), "addressComplete", "deliveryAddressLine", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isDeliveryServicePopulated(query), "addressComplete", "deliveryService", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isFormattedAddressLinePopulated(query), "addressComplete", "formattedAddressLine", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isKeyPopulated(query), "addressComplete", "key", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isLocalityPopulated(query), "addressComplete", "locality", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isNumberPopulated(query), "addressComplete", "number", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isOrganizationPopulated(query), "addressComplete", "organization", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isPostalCodePopulated(query), "addressComplete", "postalCode", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isProvincePopulated(query), "addressComplete", "province", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isRecipientLinePopulated(query), "addressComplete", "recipientLine", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isResiduePopulated(query), "addressComplete", "residue", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isStreetPopulated(query), "addressComplete", "street", errors);
		checkForInvalidCombination(isAddressCompletePopulated(query), isSubBuildingPopulated(query), "addressComplete", "subBuilding", errors);

}

	private void checkForInvalidCombination(boolean attribute1, boolean attribute2, String attribute1Name, String attribute2Name, ConstraintViolationContext<AddressQuery> errors){
		if(attribute1 && attribute2){
			errors.buildConstraintViolationWithTemplate("{120482.addressDoctor.validation.constraints.InvalidCombination.message}")
				  .putAttribute("attribute1", attribute1Name)
				  .putAttribute("attribute2", attribute2Name)
				  .addConstraintViolationForValue(null);
		}
	}

}
