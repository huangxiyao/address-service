package com.hp.it.match.batch.AddressFindExcel.utilities;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Constant of input and output excel file header.
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class Constant {
	private static Map<Integer, String> inputColumnNamesMap; 
	private static Map<Integer, String> outputRecordColumnNameMap;

	/**
	 * INPUT FILE HEADER.
	 * Each column mapped with a field of the AddressInput object.
	 */
	public static String[] INPUT_HEADER = new String[] { "key1", "key2", "key3", "modeUsed", "preferredLanguage", "preferredScript", "characterScriptDetectionIndicator", "country1", "country2", "country3", "addressComplete", "building1", "building2",
			"building3", "building4", "building5", "building6", "locality1", "locality2", "locality3", "locality4", "locality5", "locality6", "postalCode1", "postalCode2", "postalCode3", "countrySpecificLocalityLine1", "countrySpecificLocalityLine2",
			"countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "street1", "street2", "street3", "street4", "street5", "street6", "number1", "number2", "number3", "number4",
			"number5", "number6", "province1", "province2", "province3", "province4", "province5", "province6", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5", "deliveryAddressLine6",
			"deliveryService1", "deliveryService2", "deliveryService3", "deliveryService4", "deliveryService5", "deliveryService6", "formattedAddressLine1", "formattedAddressLine2", "formattedAddressLine3", "formattedAddressLine4", "formattedAddressLine5",
			"formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11", "formattedAddressLine12", "formattedAddressLine13", "formattedAddressLine14",
			"formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19", "organization1", "organization2", "organization3", "contact1", "contact2", "contact3", "recipientLine1",
			"recipientLine2", "recipientLine3", "residue1", "residue2", "residue3", "residue4", "residue5", "residue6", "subBuilding1", "subBuilding2", "subBuilding3", "subBuilding4", "subBuilding5", "subBuilding6" };

	/**
	 * OUTPUT FILE HEADER LINE 2.
	 * Each column mapped with a field of the OutputRecord object.
	 */
	public static String[] OUTPUT_HEADER_LINE_2 = new String[] { "key1", "key2", "key3", "modeUsed", "preferredLanguage", "preferredScript", "characterScriptDetectionIndicator", "country1", "country2", "country3", "addressComplete", "building1", "building2",
			"building3", "building4", "building5", "building6", "locality1", "locality2", "locality3", "locality4", "locality5", "locality6", "postalCode1", "postalCode2", "postalCode3", "countrySpecificLocalityLine1", "countrySpecificLocalityLine2",
			"countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "street1", "street2", "street3", "street4", "street5", "street6", "number1", "number2", "number3", "number4",
			"number5", "number6", "province1", "province2", "province3", "province4", "province5", "province6", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5", "deliveryAddressLine6",
			"deliveryService1", "deliveryService2", "deliveryService3", "deliveryService4", "deliveryService5", "deliveryService6", "formattedAddressLine1", "formattedAddressLine2", "formattedAddressLine3", "formattedAddressLine4", "formattedAddressLine5",
			"formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11", "formattedAddressLine12", "formattedAddressLine13", "formattedAddressLine14",
			"formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19", "organization1", "organization2", "organization3", "contact1", "contact2", "contact3", "recipientLine1",
			"recipientLine2", "recipientLine3", "residue1", "residue2", "residue3", "residue4", "residue5", "residue6", "subBuilding1", "subBuilding2", "subBuilding3", "subBuilding4", "subBuilding5", "subBuilding6", "errorMessage", "key1_RECORD_ID",
			"key2_RECORD_ID", "key3_RECORD_ID", "key1_TRANSACTION_KEY", "key2_TRANSACTION_KEY", "key3_TRANSACTION_KEY", "resultNumber", "country_ISO3", "mode_Used", "preferred_Language", "preferred_Script", "processStatus", "countOverFlow",
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

	/**
	 * Actual OUTPUT EXCEL FILE HEADER LINE1.
	 */
	public static String[] OUTPUT_EXCEL_HEADER_LINE_1 = new String[] { "INPUT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OUTPUT", "", "", "",
			"", "", "", "", "RESULT", "", "", "", "", "RESULTDATA", "", "", "", "", "", "", "", "", "", "", "ADDRESS ELEMENTS-DEFAULT TYPES", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ADDRESS LINES", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "ADDRESSELEMENTS-NONDEFAULTS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

	/**
	 * Actual OUTPUT EXCEL FILE HEADER LINE2.
	 */
	public static String[] OUTPUT_EXCEL_HEADER_LINE_2 = new String[] { "key1", "key2", "key3", "modeUsed", "preferredLanguage", "preferredScript", "characterScriptDetectionIndicator", "country1", "country2", "country3", "addressComplete", "building1",
			"building2", "building3", "building4", "building5", "building6", "locality1", "locality2", "locality3", "locality4", "locality5", "locality6", "postalCode1", "postalCode2", "postalCode3", "countrySpecificLocalityLine1",
			"countrySpecificLocalityLine2", "countrySpecificLocalityLine3", "countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "street1", "street2", "street3", "street4", "street5", "street6", "number1", "number2",
			"number3", "number4", "number5", "number6", "province1", "province2", "province3", "province4", "province5", "province6", "deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5",
			"deliveryAddressLine6", "deliveryService1", "deliveryService2", "deliveryService3", "deliveryService4", "deliveryService5", "deliveryService6", "formattedAddressLine1", "formattedAddressLine2", "formattedAddressLine3", "formattedAddressLine4",
			"formattedAddressLine5", "formattedAddressLine6", "formattedAddressLine7", "formattedAddressLine8", "formattedAddressLine9", "formattedAddressLine10", "formattedAddressLine11", "formattedAddressLine12", "formattedAddressLine13",
			"formattedAddressLine14", "formattedAddressLine15", "formattedAddressLine16", "formattedAddressLine17", "formattedAddressLine18", "formattedAddressLine19", "organization1", "organization2", "organization3", "contact1", "contact2", "contact3",
			"recipientLine1", "recipientLine2", "recipientLine3", "residue1", "residue2", "residue3", "residue4", "residue5", "residue6", "subBuilding1", "subBuilding2", "subBuilding3", "subBuilding4", "subBuilding5", "subBuilding6", "errorMessage",
			"key1-RECORD_ID", "key2-RECORD_ID", "key3-RECORD_ID", "key1-TRANSACTION_KEY", "key2-TRANSACTION_KEY", "key3-TRANSACTION_KEY", "ResultNumber", "country-ISO3", "modeUsed", "preferredLanguage", "preferredScript", "processStatus", "countOverflow",
			"elementInputStatus", "elementResultStatus", "elementRelevance", "mailabilityScore", "resultPercentage", "cassStatus", "serpStatus", "snaStatus", "supplementaryGBStatus", "supplementaryUSStatus", "country1-NAME_EN", "locality1-COMPLETE",
			"locality2-COMPLETE", "locality3-COMPLETE", "locality4-COMPLETE", "locality5-COMPLETE", "locality6-COMPLETE", "postalCode1-FORMATTED", "postalCode2-FORMATTED", "postalCode3-FORMATTED", "province1-COUNTRY_STANDARD", "province2-COUNTRY_STANDARD",
			"province3-COUNTRY_STANDARD", "province4-COUNTRY_STANDARD", "province5-COUNTRY_STANDARD", "province6-COUNTRY_STANDARD", "street1-COMPLETE", "street2-COMPLETE", "street3-COMPLETE", "street4-COMPLETE", "street5-COMPLETE", "street6-COMPLETE",
			"number1-COMPLETE", "number2-COMPLETE", "number3-COMPLETE", "number4-COMPLETE", "number5-COMPLETE", "number6-COMPLETE", "building1-COMPLETE", "building2-COMPLETE", "building3-COMPLETE", "building4-COMPLETE", "building5-COMPLETE",
			"building6-COMPLETE", "subBuilding1-COMPLETE", "subBuilding2-COMPLETE", "subBuilding3-COMPLETE", "subBuilding4-COMPLETE", "subBuilding5-COMPLETE", "subBuilding6-COMPLETE", "deliverService1-COMPLETE", "deliverService2-COMPLETE",
			"deliverService3-COMPLETE", "deliverService4-COMPLETE", "deliverService5-COMPLETE", "deliverService6-COMPLETE", "organization1-COMPLETE", "organization2-COMPLETE", "organization3-COMPLETE", "contact1-COMPLETE", "contact2-COMPLETE",
			"contact3-COMPLETE", "residue1-UNRECOGNIZED", "residue2-UNRECOGNIZED", "residue3-UNRECOGNIZED", "residue4-UNRECOGNIZED", "residue5-UNRECOGNIZED", "residue6-UNRECOGNIZED", "recipientLine1", "recipientLine2", "recipientLine3",
			"deliveryAddressLine1", "deliveryAddressLine2", "deliveryAddressLine3", "deliveryAddressLine4", "deliveryAddressLine5", "deliveryAddressLine6", "countrySpecificLocalityLine1", "countrySpecificLocalityLine2", "countrySpecificLocalityLine3",
			"countrySpecificLocalityLine4", "countrySpecificLocalityLine5", "countrySpecificLocalityLine6", "FormattedAddressLine1", "FormattedAddressLine2", "FormattedAddressLine3", "FormattedAddressLine4", "FormattedAddressLine5", "FormattedAddressLine6",
			"FormattedAddressLine7", "FormattedAddressLine8", "FormattedAddressLine9", "FormattedAddressLine10", "FormattedAddressLine11", "FormattedAddressLine12", "FormattedAddressLine13", "FormattedAddressLine14", "FormattedAddressLine15",
			"FormattedAddressLine16", "FormattedAddressLine17", "FormattedAddressLine18", "FormattedAddressLine19", "addressComplete", "country1-ABBREVIATION", "country1-ISO2", "country1-ISO3", "country1-ISO_NUMBER", "country1-NAME_CN", "country1-NAME_DA",
			"country1-NAME_DE", "country1-NAME_ES", "country1-NAME_FI", "country1-NAME_FR", "country1-NAME_GR", "country1-NAME_HU", "country1-NAME_IT", "country1-NAME_JP", "country1-NAME_KR", "country1-NAME_NL", "country1-NAME_PL", "country1-NAME_PT",
			"country1-NAME_RU", "country1-NAME_SA", "country1-NAME_SE", "country2-ABBREVIATION", "country2-ISO2", "country2-ISO3", "country2-ISO_NUMBER", "country2-NAME_CN", "country2-NAME_DA", "country2-NAME_DE", "country2-NAME_ES", "country2-NAME_FI",
			"country2-NAME_FR", "country2-NAME_GR", "country2-NAME_HU", "country2-NAME_IT", "country2-NAME_JP", "country2-NAME_KR", "country2-NAME_NL", "country2-NAME_PL", "country2-NAME_PT", "country2-NAME_RU", "country2-NAME_SA", "country2-NAME_SE",
			"country3-ABBREVIATION", "country3-ISO2", "country3-ISO3", "country3-ISO_NUMBER", "country3-NAME_CN", "country3-NAME_DA", "country3-NAME_DE", "country3-NAME_ES", "country3-NAME_FI", "country3-NAME_FR", "country3-NAME_GR", "country3-NAME_HU",
			"country3-NAME_IT", "country3-NAME_JP", "country3-NAME_KR", "country3-NAME_NL", "country3-NAME_PL", "country3-NAME_PT", "country3-NAME_RU", "country3-NAME_SA", "country3-NAME_SE", "locality1-NAME", "locality1-PREFERRED_NAME",
			"locality1-SORTING_CODE", "locality1-ADD_INFO", "locality2-NAME", "locality2-PREFERRED_NAME", "locality2-SORTING_CODE", "locality2-ADD_INFO", "locality3-NAME", "locality3-PREFERRED_NAME", "locality3-SORTING_CODE", "locality3-ADD_INFO",
			"locality4-NAME", "locality4-PREFERRED_NAME", "locality4-SORTING_CODE", "locality4-ADD_INFO", "locality5-NAME", "locality5-PREFERRED_NAME", "locality5-SORTING_CODE", "locality5-ADD_INFO", "locality6-NAME", "locality6-PREFERRED_NAME",
			"locality6-SORTING_CODE", "locality6-ADD_INFO", "postalCode1-UNFORMATTED", "postalCode1-BASE", "postalCode1-ADD_ON", "postalCode2-UNFORMATTED", "postalCode2-BASE", "postalCode2-ADD_ON", "postalCode3-UNFORMATTED", "postalCode3-BASE",
			"postalCode3-ADD_ON", "province1-ABBREVIATION", "province1-EXTENDED", "province1-ISO", "province2-ABBREVIATION", "province2-EXTENDED", "province2-ISO", "province3-ABBREVIATION", "province3-EXTENDED", "province3-ISO", "province4-ABBREVIATION",
			"province4-EXTENDED", "province4-ISO", "province5-ABBREVIATION", "province5-EXTENDED", "province5-ISO", "province6-ABBREVIATION", "province6-EXTENDED", "province6-ISO", "street1-COMPLETE_WITH_NUMBER", "street1-NAME", "street1-PRE_DESCRIPTOR",
			"street1-POST_DESCRIPTOR", "street1-PRE_DIRECTIONAL", "street1-POST_DIRECTIONAL", "street1-ADD_INFO", "street2-COMPLETE_WITH_NUMBER", "street2-NAME", "street2-PRE_DESCRIPTOR", "street2-POST_DESCRIPTOR", "street2-PRE_DIRECTIONAL",
			"street2-POST_DIRECTIONAL", "street2-ADD_INFO", "street3-COMPLETE_WITH_NUMBER", "street3-NAME", "street3-PRE_DESCRIPTOR", "street3-POST_DESCRIPTOR", "street3-PRE_DIRECTIONAL", "street3-POST_DIRECTIONAL", "street3-ADD_INFO",
			"street4-COMPLETE_WITH_NUMBER", "street4-NAME", "street4-PRE_DESCRIPTOR", "street4-POST_DESCRIPTOR", "street4-PRE_DIRECTIONAL", "street4-POST_DIRECTIONAL", "street4-ADD_INFO", "street5-COMPLETE_WITH_NUMBER", "street5-NAME",
			"street5-PRE_DESCRIPTOR", "street5-POST_DESCRIPTOR", "street5-PRE_DIRECTIONAL", "street5-POST_DIRECTIONAL", "street5-ADD_INFO", "street6-COMPLETE_WITH_NUMBER", "street6-NAME", "street6-PRE_DESCRIPTOR", "street6-POST_DESCRIPTOR",
			"street6-PRE_DIRECTIONAL", "street6-POST_DIRECTIONAL", "street6-ADD_INFO", "number1-NUMBER", "number1-DESCRIPTOR", "number1-ADD_INFO", "number2-NUMBER", "number2-DESCRIPTOR", "number2-ADD_INFO", "number3-NUMBER", "number3-DESCRIPTOR",
			"number3-ADD_INFO", "number4-NUMBER", "number4-DESCRIPTOR", "number4-ADD_INFO", "number5-NUMBER", "number5-DESCRIPTOR", "number5-ADD_INFO", "number6-NUMBER", "number6-DESCRIPTOR", "number6-ADD_INFO", "building1-COMPLETE_WITH_SUBBUILDING",
			"building1-NAME", "building1-NUMBER", "building1-DESCRIPTOR", "building2-COMPLETE_WITH_SUBBUILDING", "building2-NAME", "building2-NUMBER", "building2-DESCRIPTOR", "building3-COMPLETE_WITH_SUBBUILDING", "building3-NAME", "building3-NUMBER",
			"building3-DESCRIPTOR", "building4-COMPLETE_WITH_SUBBUILDING", "building4-NAME", "building4-NUMBER", "building4-DESCRIPTOR", "building5-COMPLETE_WITH_SUBBUILDING", "building5-NAME", "building5-NUMBER", "building5-DESCRIPTOR",
			"building6-COMPLETE_WITH_SUBBUILDING", "building6-NAME", "building6-NUMBER", "building6-DESCRIPTOR", "subBuilding1-NAME", "subBuilding1-NUMBER", "subBuilding1-DESCRIPTOR", "subBuilding2-NAME", "subBuilding2-NUMBER", "subBuilding2-DESCRIPTOR",
			"subBuilding3-NAME", "subBuilding3-NUMBER", "subBuilding3-DESCRIPTOR", "subBuilding4-NAME", "subBuilding4-NUMBER", "subBuilding4-DESCRIPTOR", "subBuilding5-NAME", "subBuilding5-NUMBER", "subBuilding5-DESCRIPTOR", "subBuilding6-NAME",
			"subBuilding6-NUMBER", "subBuilding6-DESCRIPTOR", "deliveryService1-DESCRIPTOR", "deliveryService1-NUMBER", "deliveryService1-ADD_INFO", "deliveryService2-DESCRIPTOR", "deliveryService2-NUMBER", "deliveryService2-ADD_INFO",
			"deliveryService3-DESCRIPTOR", "deliveryService3-NUMBER", "deliveryService3-ADD_INFO", "organization1-NAME", "organization1-DESCRIPTOR", "organization1-DEPARTMENT", "organization2-NAME", "organization2-DESCRIPTOR", "organization2-DEPARTMENT",
			"organization3-NAME", "organization3-DESCRIPTOR", "organization3-DEPARTMENT", "contact1-FIRST_NAME", "contact1-MIDDLE_NAME", "contact1-LAST_NAME", "contact1-NAME", "contact1-TITLE", "contact1-FUNCTION", "contact1-SALUTATION", "contact1-GENDER",
			"contact2-FIRST_NAME", "contact2-MIDDLE_NAME", "contact2-LAST_NAME", "contact2-NAME", "contact2-TITLE", "contact2-FUNCTION", "contact2-SALUTATION", "contact2-GENDER", "contact3-FIRST_NAME", "contact3-MIDDLE_NAME", "contact3-LAST_NAME",
			"contact3-NAME", "contact3-TITLE", "contact3-FUNCTION", "contact3-SALUTATION", "contact3-GENDER", "residue1-NECESSARY", "residue1-SUPERFLUOUS", "residue2-NECESSARY", "residue2-SUPERFLUOUS", "residue3-NECESSARY", "residue3-SUPERFLUOUS",
			"residue4-NECESSARY", "residue4-SUPERFLUOUS", "residue5-NECESSARY", "residue5-SUPERFLUOUS", "residue6-NECESSARY", "residue6-SUPERFLUOUS" };

	
	/**
	 * Initial the inputColumnNamesMap to store each column name of an input file. 
	 * @return inputColumnNamesMap
	 */
	public static Map<Integer, String> getInputColumnNamesMap() {
		if (inputColumnNamesMap != null){
			return inputColumnNamesMap;
		}
		
		inputColumnNamesMap = new LinkedHashMap<Integer, String>();
		for (int columnNum = 0; columnNum < Constant.INPUT_HEADER.length; columnNum++) {
			inputColumnNamesMap.put(columnNum, Constant.INPUT_HEADER[columnNum]);
		}
		
		return inputColumnNamesMap;
	}

	/**
	 * Initial the outputRecordColumnNameMap to store each column name of an output file. 
	 * @return outputRecordColumnNameMap
	 */
	public static Map<Integer, String> getOutputRecordColumnNamesMap() {
		if (outputRecordColumnNameMap != null ) {
			return outputRecordColumnNameMap;
		}
		outputRecordColumnNameMap = new LinkedHashMap<Integer, String>();
		for (int columnNum = 0; columnNum < Constant.OUTPUT_HEADER_LINE_2.length; columnNum++) {
			outputRecordColumnNameMap.put(columnNum, Constant.OUTPUT_HEADER_LINE_2[columnNum]);
		}
		return outputRecordColumnNameMap;
	}
}
