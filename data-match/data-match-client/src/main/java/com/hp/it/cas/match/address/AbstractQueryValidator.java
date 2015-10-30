package com.hp.it.cas.match.address;

import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;

public abstract class AbstractQueryValidator {

	boolean isDeliveryAddressLinePopulated(AddressQuery addressQuery) {
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryAddressLine6());
		}
		return hasContent;
	}

	boolean isFormattedAddressLinePopulated(AddressQuery addressQuery) {
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine1());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine2());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine3());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine4());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine5());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine6());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine7());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine8());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine9());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine10());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine11());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine12());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine13());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine14());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine15());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine16());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine17());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine18());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getFormattedAddressLine19());
		}

		return hasContent;
	}

	boolean isStreetPopulated(AddressQuery addressQuery) {
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getStreet1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getStreet2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getStreet3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getStreet4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getStreet5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getStreet6());
		}

		return hasContent;
	}

	boolean isNumberPopulated(AddressQuery addressQuery) {
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getNumber1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getNumber2());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getNumber3());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getNumber4());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getNumber5());
		}

		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getNumber6());
		}

		return hasContent;
	}

	boolean isBuildingPopulated(AddressQuery addressQuery) {
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getBuilding1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getBuilding2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getBuilding3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getBuilding4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getBuilding5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getBuilding6());
		}

		return hasContent;
	}
	
	boolean isSubBuildingPopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getSubBuilding1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getSubBuilding2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getSubBuilding3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getSubBuilding4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getSubBuilding5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getSubBuilding6());
		}
		return hasContent;
	}
	
	boolean isDeliveryServicePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getDeliveryService1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryService2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryService3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryService4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryService5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getDeliveryService6());
		}
		return hasContent;
	}
	
	boolean isCountrySpecificLocalityLinePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getCountrySpecificLocalityLine6());
		}
		return hasContent;
	}
	
	boolean isLocalityPopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getLocality1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getLocality2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getLocality3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getLocality4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getLocality5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getLocality6());
		}
		return hasContent;
	}
	
	boolean isPostalCodePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getPostalCode1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getPostalCode2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getPostalCode3());
		}
		return hasContent;
	}
	
	boolean isProvincePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getProvince1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getProvince2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getProvince3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getProvince4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getProvince5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getProvince6());
		}
		return hasContent;
	}
	
	boolean isRecipientLinePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getRecipientLine1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getRecipientLine2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getRecipientLine3());
		}
		return hasContent;
	}
	
	boolean isResiduePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getResidue1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getResidue2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getResidue3());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getResidue4());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getResidue5());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getResidue6());
		}
		return hasContent;
	}
	
	boolean isContactsPopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getContact1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getContact2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getContact2());
		}
		return hasContent;
	}
	
	boolean isAddressCompletePopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getAddressComplete());
		return hasContent;
	}
	
	boolean isKeyPopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getKey1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getKey2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getKey3());
		}
		return hasContent;
	}
	
	boolean isOrganizationPopulated(AddressQuery addressQuery){
		boolean hasContent = false;
		hasContent = !isNullOrEmpty(addressQuery.getOrganization1());
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getOrganization2());
		}
		if (!hasContent) {
			hasContent = !isNullOrEmpty(addressQuery.getOrganization3());
		}
		return hasContent;
	}



}
