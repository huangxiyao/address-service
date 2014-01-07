package com.hp.it.cas.match.batch.utilities;

public class Constant {

	// INPUT FILE HEADER
	public static String[] INPUT_CSV_HEADER = new String[] { "key1", "key2", "key3", "modeUsed", "preferredLanguage", "preferredScript", "characterScriptDetectionIndicator", "country1", "country2", "country3", "addressComplete", "building1", "building2",
			"building3", "building4", "building5", "building6", "locality1", "locality2", "locality3", "locality4", "locality5", "locality6", "postalCode1", "postalCode2", "postalCode3", "countrySpecificLocalityLine1", "countrySpecificLocalityLine2",
			"countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "street1", "street2", "street3", "street4", "street5", "street6", "number1", "number2", "number3", "number4",
			"number5", "number6", "province1", "province2", "province3", "province4", "province5", "province6", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5", "deliveryAddressLine6",
			"deliveryService1", "deliveryService2", "deliveryService3", "deliveryService4", "deliveryService5", "deliveryService6", "formattedAddressLine1", "formattedAddressLine2", "formattedAddressLine3", "formattedAddressLine4", "formattedAddressLine5",
			"formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11", "formattedAddressLine12", "formattedAddressLine13", "formattedAddressLine14",
			"formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19", "organization1", "organization2", "organization3", "contact1", "contact2", "contact3", "recipientLine1",
			"recipientLine2", "recipientLine3", "residue1", "residue2", "residue3", "residue4", "residue5", "residue6", "subBuilding1", "subBuilding2", "subBuilding3", "subBuilding4", "subBuilding5", "subBuilding6" };

	// OUTPUT FILE HEADER LINE 1
	public static String[] OUTPUT_CSV_HEADER_LINE_1 = new String[] { "INPUT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OUTPUT", "", "", "",
			"", "", "", "", "RESULT", "", "", "", "", "RESULTDATA", "", "", "", "", "", "", "", "", "", "", "ADDRESS ELEMENTS_DEFAULT TYPES", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ADDRESS LINES", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "ADDRESSELEMENTS_NONDEFAULTS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

	// OUTPUT FILE HEADER LINE 2
	public static String[] OUTPUT_CSV_HEADER_LINE_2 = new String[] { "key1", "key2", "key3", "modeUsed", "preferredLanguage", "preferredScript", "characterScriptDetectionIndicator", "country1", "country2", "country3", "addressComplete", "building1",
			"building2", "building3", "building4", "building5", "building6", "locality1", "locality2", "locality3", "locality4", "locality5", "locality6", "postalCode1", "postalCode2", "postalCode3", "countrySpecificLocalityLine1",
			"countrySpecificLocalityLine2", "countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "street1", "street2", "street3", "street4", "street5", "street6", "number1", "number2",
			"number3", "number4", "number5", "number6", "province1", "province2", "province3", "province4", "province5", "province6", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5",
			"deliveryAddressLine6", "deliveryService1", "deliveryService2", "deliveryService3", "deliveryService4", "deliveryService5", "deliveryService6", "formattedAddressLine1", "formattedAddressLine2", "formattedAddressLine3", "formattedAddressLine4",
			"formattedAddressLine5", "formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11", "formattedAddressLine12", "formattedAddressLine13",
			"formattedAddressLine14", "formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19", "organization1", "organization2", "organization3", "contact1", "contact2", "contact3",
			"recipientLine1", "recipientLine2", "recipientLine3", "residue1", "residue2", "residue3", "residue4", "residue5", "residue6", "subBuilding1", "subBuilding2", "subBuilding3", "subBuilding4", "subBuilding5", "subBuilding6", "errorMessage",
			"key1_RECORD_ID", "key2_RECORD_ID", "key3_RECORD_ID", "key1_TRANSACTION_KEY", "key2_TRANSACTION_KEY", "key3_TRANSACTION_KEY", "ResultNumber", "country_ISO3", "mode_Used", "preferred_Language", "preferred_Script", "processStatus", "countOverFlow",
			"elementInputStatus", "elementResultStatus", "elementRelevance", "mailabilityScore", "resultPercentage", "cassStatus", "serpStatus", "snaStatus", "supplementaryGBStatus", "supplementaryUSStatus", "country1_NAME_EN", "locality1_COMPLETE",
			"locality2_COMPLETE", "locality3_COMPLETE", "locality4_COMPLETE", "locality5_COMPLETE", "locality6_COMPLETE", "postalCode1_FORMATTED", "postalCode2_FORMATTED", "postalCode3_FORMATTED", "province1_COUNTRY_STANDARD", "province2_COUNTRY_STANDARD",
			"province3_COUNTRY_STANDARD", "province4_COUNTRY_STANDARD", "province5_COUNTRY_STANDARD", "province6_COUNTRY_STANDARD", "street1_COMPLETE", "street2_COMPLETE", "street3_COMPLETE", "street4_COMPLETE", "street5_COMPLETE", "street6_COMPLETE",
			"number1_COMPLETE", "number2_COMPLETE", "number3_COMPLETE", "number4_COMPLETE", "number5_COMPLETE", "number6_COMPLETE", "building1_COMPLETE", "building2_COMPLETE", "building3_COMPLETE", "building4_COMPLETE", "building5_COMPLETE",
			"building6_COMPLETE", "subBuilding1_COMPLETE", "subBuilding2_COMPLETE", "subBuilding3_COMPLETE", "subBuilding4_COMPLETE", "subBuilding5_COMPLETE", "subBuilding6_COMPLETE", "deliverService1_COMPLETE", "deliverService2_COMPLETE",
			"deliverService3_COMPLETE", "deliverService4_COMPLETE", "deliverService5_COMPLETE", "deliverService6_COMPLETE", "organization1_COMPLETE", "organization2_COMPLETE", "organization3_COMPLETE", "contact1_COMPLETE", "contact2_COMPLETE",
			"contact3_COMPLETE", "residue1_UNRECOGNIZED", "residue2_UNRECOGNIZED", "residue3_UNRECOGNIZED", "residue4_UNRECOGNIZED", "residue5_UNRECOGNIZED", "residue6_UNRECOGNIZED", "recipientLine_1", "recipientLine_2", "recipientLine_3",
			"deliveryAddressLine_1", "deliveryAddressLine_2", "deliveryAddressLine_3", "deliveryAddressLine_4", "deliveryAddressLine_5", "deliveryAddressLine_6", "countrySpecificLocalityLine_1", "countrySpecificLocalityLine_2",
			"countrySpecificLocalityLine_3", "countrySpecificLocalityLine_4", "countrySpecificLocalityLine_5", "countrySpecificLocalityLine_6", "FormattedAddressLine_1", "FormattedAddressLine_2", "FormattedAddressLine_3", "FormattedAddressLine_4",
			"FormattedAddressLine_5", "FormattedAddressLine_6", "FormattedAddressLine_7", "FormattedAddressLine_8", "FormattedAddressLine_9", "FormattedAddressLine_10", "FormattedAddressLine_11", "FormattedAddressLine_12", "FormattedAddressLine_13",
			"FormattedAddressLine_14", "FormattedAddressLine_15", "FormattedAddressLine_16", "FormattedAddressLine_17", "FormattedAddressLine_18", "FormattedAddressLine_19", "completeAddress", "country1_ABBREVIATION", "country1_ISO2", "country1_ISO3",
			"country1_ISO_NUMBER", "country1_NAME_CN", "country1_NAME_DA", "country1_NAME_DE", "country1_NAME_ES", "country1_NAME_FI", "country1_NAME_FR", "country1_NAME_GR", "country1_NAME_HU", "country1_NAME_IT", "country1_NAME_JP", "country1_NAME_KR",
			"country1_NAME_NL", "country1_NAME_PL", "country1_NAME_PT", "country1_NAME_RU", "country1_NAME_SA", "country1_NAME_SE", "country2_ABBREVIATION", "country2_ISO2", "country2_ISO3", "country2_ISO_NUMBER", "country2_NAME_CN", "country2_NAME_DA",
			"country2_NAME_DE", "country2_NAME_ES", "country2_NAME_FI", "country2_NAME_FR", "country2_NAME_GR", "country2_NAME_HU", "country2_NAME_IT", "country2_NAME_JP", "country2_NAME_KR", "country2_NAME_NL", "country2_NAME_PL", "country2_NAME_PT",
			"country2_NAME_RU", "country2_NAME_SA", "country2_NAME_SE", "country3_ABBREVIATION", "country3_ISO2", "country3_ISO3", "country3_ISO_NUMBER", "country3_NAME_CN", "country3_NAME_DA", "country3_NAME_DE", "country3_NAME_ES", "country3_NAME_FI",
			"country3_NAME_FR", "country3_NAME_GR", "country3_NAME_HU", "country3_NAME_IT", "country3_NAME_JP", "country3_NAME_KR", "country3_NAME_NL", "country3_NAME_PL", "country3_NAME_PT", "country3_NAME_RU", "country3_NAME_SA", "country3_NAME_SE",
			"locality1_NAME", "locality1_PREFERRED_NAME", "locality1_SORTING_CODE", "locality1_ADD_INFO", "locality2_NAME", "locality2_PREFERRED_NAME", "locality2_SORTING_CODE", "locality2_ADD_INFO", "locality3_NAME", "locality3_PREFERRED_NAME",
			"locality3_SORTING_CODE", "locality3_ADD_INFO", "locality4_NAME", "locality4_PREFERRED_NAME", "locality4_SORTING_CODE", "locality4_ADD_INFO", "locality5_NAME", "locality5_PREFERRED_NAME", "locality5_SORTING_CODE", "locality5_ADD_INFO",
			"locality6_NAME", "locality6_PREFERRED_NAME", "locality6_SORTING_CODE", "locality6_ADD_INFO", "postalCode1_UNFORMATTED", "postalCode1_BASE", "postalCode1_ADD_ON", "postalCode2_UNFORMATTED", "postalCode2_BASE", "postalCode2_ADD_ON",
			"postalCode3_UNFORMATTED", "postalCode3_BASE", "postalCode3_ADD_ON", "province1_ABBREVIATION", "province1_EXTENDED", "province1_ISO", "province2_ABBREVIATION", "province2_EXTENDED", "province2_ISO", "province3_ABBREVIATION", "province3_EXTENDED",
			"province3_ISO", "province4_ABBREVIATION", "province4_EXTENDED", "province4_ISO", "province5_ABBREVIATION", "province5_EXTENDED", "province5_ISO", "province6_ABBREVIATION", "province6_EXTENDED", "province6_ISO", "street1_COMPLETE_WITH_NUMBER",
			"street1_NAME", "street1_PRE_DESCRIPTOR", "street1_POST_DESCRIPTOR", "street1_PRE_DIRECTIONAL", "street1_POST_DIRECTIONAL", "street1_ADD_INFO", "street2_COMPLETE_WITH_NUMBER", "street2_NAME", "street2_PRE_DESCRIPTOR", "street2_POST_DESCRIPTOR",
			"street2_PRE_DIRECTIONAL", "street2_POST_DIRECTIONAL", "street2_ADD_INFO", "street3_COMPLETE_WITH_NUMBER", "street3_NAME", "street3_PRE_DESCRIPTOR", "street3_POST_DESCRIPTOR", "street3_PRE_DIRECTIONAL", "street3_POST_DIRECTIONAL",
			"street3_ADD_INFO", "street4_COMPLETE_WITH_NUMBER", "street4_NAME", "street4_PRE_DESCRIPTOR", "street4_POST_DESCRIPTOR", "street4_PRE_DIRECTIONAL", "street4_POST_DIRECTIONAL", "street4_ADD_INFO", "street5_COMPLETE_WITH_NUMBER", "street5_NAME",
			"street5_PRE_DESCRIPTOR", "street5_POST_DESCRIPTOR", "street5_PRE_DIRECTIONAL", "street5_POST_DIRECTIONAL", "street5_ADD_INFO", "street6_COMPLETE_WITH_NUMBER", "street6_NAME", "street6_PRE_DESCRIPTOR", "street6_POST_DESCRIPTOR",
			"street6_PRE_DIRECTIONAL", "street6_POST_DIRECTIONAL", "street6_ADD_INFO", "number1_NUMBER", "number1_DESCRIPTOR", "number1_ADD_INFO", "number2_NUMBER", "number2_DESCRIPTOR", "number2_ADD_INFO", "number3_NUMBER", "number3_DESCRIPTOR",
			"number3_ADD_INFO", "number4_NUMBER", "number4_DESCRIPTOR", "number4_ADD_INFO", "number5_NUMBER", "number5_DESCRIPTOR", "number5_ADD_INFO", "number6_NUMBER", "number6_DESCRIPTOR", "number6_ADD_INFO", "building1_COMPLETE_WITH_SUBBUILDING",
			"building1_NAME", "building1_NUMBER", "building1_DESCRIPTOR", "building2_COMPLETE_WITH_SUBBUILDING", "building2_NAME", "building2_NUMBER", "building2_DESCRIPTOR", "building3_COMPLETE_WITH_SUBBUILDING", "building3_NAME", "building3_NUMBER",
			"building3_DESCRIPTOR", "building4_COMPLETE_WITH_SUBBUILDING", "building4_NAME", "building4_NUMBER", "building4_DESCRIPTOR", "building5_COMPLETE_WITH_SUBBUILDING", "building5_NAME", "building5_NUMBER", "building5_DESCRIPTOR",
			"building6_COMPLETE_WITH_SUBBUILDING", "building6_NAME", "building6_NUMBER", "building6_DESCRIPTOR", "subBuilding1_NAME", "subBuilding1_NUMBER", "subBuilding1_DESCRIPTOR", "subBuilding2_NAME", "subBuilding2_NUMBER", "subBuilding2_DESCRIPTOR",
			"subBuilding3_NAME", "subBuilding3_NUMBER", "subBuilding3_DESCRIPTOR", "subBuilding4_NAME", "subBuilding4_NUMBER", "subBuilding4_DESCRIPTOR", "subBuilding5_NAME", "subBuilding5_NUMBER", "subBuilding5_DESCRIPTOR", "subBuilding6_NAME",
			"subBuilding6_NUMBER", "subBuilding6_DESCRIPTOR", "deliveryService1_DESCRIPTOR", "deliveryService1_NUMBER", "deliveryService1_ADD_INFO", "deliveryService2_DESCRIPTOR", "deliveryService2_NUMBER", "deliveryService2_ADD_INFO",
			"deliveryService3_DESCRIPTOR", "deliveryService3_NUMBER", "deliveryService3_ADD_INFO", "organization1_NAME", "organization1_DESCRIPTOR", "organization1_DEPARTMENT", "organization2_NAME", "organization2_DESCRIPTOR", "organization2_DEPARTMENT",
			"organization3_NAME", "organization3_DESCRIPTOR", "organization3_DEPARTMENT", "contact1_FIRST_NAME", "contact1_MIDDLE_NAME", "contact1_LAST_NAME", "contact1_NAME", "contact1_TITLE", "contact1_FUNCTION", "contact1_SALUTATION", "contact1_GENDER",
			"contact2_FIRST_NAME", "contact2_MIDDLE_NAME", "contact2_LAST_NAME", "contact2_NAME", "contact2_TITLE", "contact2_FUNCTION", "contact2_SALUTATION", "contact2_GENDER", "contact3_FIRST_NAME", "contact3_MIDDLE_NAME", "contact3_LAST_NAME",
			"contact3_NAME", "contact3_TITLE", "contact3_FUNCTION", "contact3_SALUTATION", "contact3_GENDER", "residue1_NECESSARY", "residue1_SUPERFLUOUS", "residue2_NECESSARY", "residue2_SUPERFLUOUS", "residue3_NECESSARY", "residue3_SUPERFLUOUS",
			"residue4_NECESSARY", "residue4_SUPERFLUOUS", "residue5_NECESSARY", "residue5_SUPERFLUOUS", "residue6_NECESSARY", "residue6_SUPERFLUOUS" };

}
