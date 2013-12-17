package com.hp.it.cas.match.batch.utilities;

import java.util.regex.Pattern;

/**
 * Utils Class
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class BatchUtils {
	
	public static String OUTPUTFILENAME = "outputFileName";
	
	// Output file Template
	public static String OUTPUT_TEMPLATE_LINE_1 = "INPUT,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,OUTPUT,,,,,,,,RESULT,,,,,RESULTDATA,,,,,,,,,,,ADDRESS ELEMENTS-DEFAULT TYPES,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,ADDRESS LINES,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,ADDRESSELEMENTS-NONDEFAULTS,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
	public static String OUTPUT_TEMPLATE_LINE_2 = "key1,key2,key3,modeUsed,preferredLanguage,preferredScript,characterScriptDetectionIndicator,country1,country2,country3,addressComplete,building1,building2,building3,building4,building5,building6,locality1,locality2,locality3,locality4,locality5,locality6,postalCode1,postalCode2,postalCode3,countrySpecificLocalityLine1,countrySpecificLocalityLine2,countrySpecificLocalityLine3,countrySpecificLocalityLine4,countrySpecificLocalityLine5,countrySpecificLocalityLine6,street1,street2,street3,street4,street5,street6,number1,number2,number3,number4,number5,number6,province1,province2,province3,province4,province5,province6,deliveryAddressLine1,deliveryAddressLine2,deliveryAddressLine3,deliveryAddressLine4,deliveryAddressLine5,deliveryAddressLine6,deliveryService1,deliveryService2,deliveryService3,deliveryService4,deliveryService5,deliveryService6,formattedAddressLine1,formattedAddressLine2,formattedAddressLine3,formattedAddressLine4,formattedAddressLine5,formattedAddressLine6,formattedAddressLine7,formattedAddressLine8,formattedAddressLine9,formattedAddressLine10,formattedAddressLine11,formattedAddressLine12,formattedAddressLine13,formattedAddressLine14,formattedAddressLine15,formattedAddressLine16,formattedAddressLine17,formattedAddressLine18,formattedAddressLine19,organization1,organization2,organization3,contact1,contact2,contact3,recipientLine1,recipientLine2,recipientLine3,residue1,residue2,residue3,residue4,residue5,residue6,subBuilding1,subBuilding2,subBuilding3,subBuilding4,subBuilding5,subBuilding6,,key1-RECORD_ID,key2-RECORD_ID,key3-RECORD_ID,key1-TRANSACTION_KEY,key2-TRANSACTION_KEY,key3-TRANSACTION_KEY,ResultNumber,country-ISO3,modeUsed,preferredLanguage,preferredScript,processStatus,countOverflow,elementInputStatus,elementResultStatus,elementRelevance,mailabilityScore,resultPercentage,cassStatus,serpStatus,snaStatus,supplementaryGBStatus,supplementaryUSStatus,country1-NAME_EN,locality1-COMPLETE,locality2-COMPLETE,locality3-COMPLETE,locality4-COMPLETE,locality5-COMPLETE,locality6-COMPLETE,postalCode1-FORMATTED,postalCode2-FORMATTED,postalCode3-FORMATTED,province1-COUNTRY_STANDARD,province2-COUNTRY_STANDARD,province3-COUNTRY_STANDARD,province4-COUNTRY_STANDARD,province5-COUNTRY_STANDARD,province6-COUNTRY_STANDARD,street1-COMPLETE,street2-COMPLETE,street3-COMPLETE,street4-COMPLETE,street5-COMPLETE,street6-COMPLETE,number1-COMPLETE,number2-COMPLETE,number3-COMPLETE,number4-COMPLETE,number5-COMPLETE,number6-COMPLETE,building1-COMPLETE,building2-COMPLETE,building3-COMPLETE,building4-COMPLETE,building5-COMPLETE,building6-COMPLETE,subBuilding1-COMPLETE,subBuilding2-COMPLETE,subBuilding3-COMPLETE,subBuilding4-COMPLETE,subBuilding5-COMPLETE,subBuilding6-COMPLETE,deliverService1-COMPLETE,deliverService2-COMPLETE,deliverService3-COMPLETE,deliverService4-COMPLETE,deliverService5-COMPLETE,deliverService6-COMPLETE,organization1-COMPLETE,organization2-COMPLETE,organization3-COMPLETE,contact1-COMPLETE,contact2-COMPLETE,contact3-COMPLETE,residue1-UNRECOGNIZED,residue2-UNRECOGNIZED,residue3-UNRECOGNIZED,residue4-UNRECOGNIZED,residue5-UNRECOGNIZED,residue6-UNRECOGNIZED,recipientLine1,recipientLine2,recipientLine3,deliveryAddressLine1,deliveryAddressLine2,deliveryAddressLine3,deliveryAddressLine4,deliveryAddressLine5,deliveryAddressLine6,countrySpecificLocalityLine1,countrySpecificLocalityLine2,countrySpecificLocalityLine3,countrySpecificLocalityLine4,countrySpecificLocalityLine5,countrySpecificLocalityLine6,FormattedAddressLine1,FormattedAddressLine2,FormattedAddressLine3,FormattedAddressLine4,FormattedAddressLine5,FormattedAddressLine6,FormattedAddressLine7,FormattedAddressLine8,FormattedAddressLine9,FormattedAddressLine10,FormattedAddressLine11,FormattedAddressLine12,FormattedAddressLine13,FormattedAddressLine14,FormattedAddressLine15,FormattedAddressLine16,FormattedAddressLine17,FormattedAddressLine18,FormattedAddressLine19,addressComplete,country1-ABBREVIATION,country1-ISO2,country1-ISO3,country1- ISO_NUMBER,country1-NAME_CN,country1-NAME_DA,country1-NAME_DE,country1-NAME_ES,country1-NAME_FI,country1-NAME_FR,country1-NAME_GR,country1-NAME_HU,country1-NAME_IT,country1-NAME_JP,country1-NAME_KR,country1-NAME_NL,country1-NAME_PL,country1-NAME_PT,country1-NAME_RU,country1-NAME_SA,country1-NAME_SE,country2-ABBREVIATION,country2-ISO2,country2-ISO3,country2- ISO_NUMBER,country2-NAME_CN,country2-NAME_DA,country2-NAME_DE,country2-NAME_ES,country2-NAME_FI,country2-NAME_FR,country2-NAME_GR,country2-NAME_HU,country2-NAME_IT,country2-NAME_JP,country2-NAME_KR,country2-NAME_NL,country2-NAME_PL,country2-NAME_PT,country2-NAME_RU,country2-NAME_SA,country2-NAME_SE,country3-ABBREVIATION,country3-ISO2,country3-ISO3,country3- ISO_NUMBER,country3-NAME_CN,country3-NAME_DA,country3-NAME_DE,country3-NAME_ES,country3-NAME_FI,country3-NAME_FR,country3-NAME_GR,country3-NAME_HU,country3-NAME_IT,country3-NAME_JP,country3-NAME_KR,country3-NAME_NL,country3-NAME_PL,country3-NAME_PT,country3-NAME_RU,country3-NAME_SA,country3-NAME_SE,locality1-NAME,locality1-PREFERRED_NAME,locality1-SORTING_CODE,locality1-ADD_INFO,locality2-NAME,locality2-PREFERRED_NAME,locality2-SORTING_CODE,locality2-ADD_INFO,locality3-NAME,locality3-PREFERRED_NAME,locality3-SORTING_CODE,locality3-ADD_INFO,locality4-NAME,locality4-PREFERRED_NAME,locality4-SORTING_CODE,locality4-ADD_INFO,locality5-NAME,locality5-PREFERRED_NAME,locality5-SORTING_CODE,locality5-ADD_INFO,locality6-NAME,locality6-PREFERRED_NAME,locality6-SORTING_CODE,locality6-ADD_INFO,postalCode1-UNFORMATTED,postalCode1-BASE,postalCode1-ADD_ON,postalCode2-UNFORMATTED,postalCode2-BASE,postalCode2-ADD_ON,postalCode3-UNFORMATTED,postalCode3-BASE,postalCode3-ADD_ON,province1-ABBREVIATION,province1-EXTENDED,province1-ISO,province2-ABBREVIATION,province2-EXTENDED,province2-ISO,province3-ABBREVIATION,province3-EXTENDED,province3-ISO,province4-ABBREVIATION,province4-EXTENDED,province4-ISO,province5-ABBREVIATION,province5-EXTENDED,province5-ISO,province6-ABBREVIATION,province6-EXTENDED,province6-ISO,street1-COMPLETE_WITH_NUMBER,street1-NAME,street1-PRE_DESCRIPTOR,street1-POST_DESCRIPTOR,street1-PRE_DIRECTIONAL,street1-POST_DIRECTIONAL,street1-ADD_INFO,street2-COMPLETE_WITH_NUMBER,street2-NAME,street2-PRE_DESCRIPTOR,street2-POST_DESCRIPTOR,street2-PRE_DIRECTIONAL,street2-POST_DIRECTIONAL,street2-ADD_INFO,street3-COMPLETE_WITH_NUMBER,street3-NAME,street3-PRE_DESCRIPTOR,street3-POST_DESCRIPTOR,street3-PRE_DIRECTIONAL,street3-POST_DIRECTIONAL,street3-ADD_INFO,street4-COMPLETE_WITH_NUMBER,street4-NAME,street4-PRE_DESCRIPTOR,street4-POST_DESCRIPTOR,street4-PRE_DIRECTIONAL,street4-POST_DIRECTIONAL,street4-ADD_INFO,street5-COMPLETE_WITH_NUMBER,street5-NAME,street5-PRE_DESCRIPTOR,street5-POST_DESCRIPTOR,street5-PRE_DIRECTIONAL,street5-POST_DIRECTIONAL,street5-ADD_INFO,street6-COMPLETE_WITH_NUMBER,street6-NAME,street6-PRE_DESCRIPTOR,street6-POST_DESCRIPTOR,street6-PRE_DIRECTIONAL,street6-POST_DIRECTIONAL,street6-ADD_INFO,number1-NUMBER,number1-DESCRIPTOR,number1-ADD_INFO,number2-NUMBER,number2-DESCRIPTOR,number2-ADD_INFO,number3-NUMBER,number3-DESCRIPTOR,number3-ADD_INFO,number4-NUMBER,number4-DESCRIPTOR,number4-ADD_INFO,number5-NUMBER,number5-DESCRIPTOR,number5-ADD_INFO,number6-NUMBER,number6-DESCRIPTOR,number6-ADD_INFO,building1-COMPLETE_WITH_SUBBUILDING,building1-NAME,building1-NUMBER ,building1-DESCRIPTOR,building2-COMPLETE_WITH_SUBBUILDING,building2-NAME,building2-NUMBER ,building2-DESCRIPTOR,building3-COMPLETE_WITH_SUBBUILDING,building3-NAME,building3-NUMBER ,building3-DESCRIPTOR,building4-COMPLETE_WITH_SUBBUILDING,building4-NAME,building4-NUMBER ,building4-DESCRIPTOR,building5-COMPLETE_WITH_SUBBUILDING,building5-NAME,building5-NUMBER ,building5-DESCRIPTOR,building6-COMPLETE_WITH_SUBBUILDING,building6-NAME,building6-NUMBER ,building6-DESCRIPTOR,subBuilding1-NAME,subBuilding1-NUMBER ,subBuilding1-DESCRIPTOR,subBuilding2-NAME,subBuilding2-NUMBER ,subBuilding2-DESCRIPTOR,subBuilding3-NAME,subBuilding3-NUMBER ,subBuilding3-DESCRIPTOR,subBuilding4-NAME,subBuilding4-NUMBER ,subBuilding4-DESCRIPTOR,subBuilding5-NAME,subBuilding5-NUMBER ,subBuilding5-DESCRIPTOR,subBuilding6-NAME,subBuilding6-NUMBER ,subBuilding6-DESCRIPTOR,deliveryService1-DESCRIPTOR,deliveryService1-NUMBER,deliveryService1-ADD_INFO,deliveryService2-DESCRIPTOR,deliveryService2-NUMBER,deliveryService2-ADD_INFO,deliveryService3-DESCRIPTOR,deliveryService3-NUMBER,deliveryService3-ADD_INFO,organization1-NAME,organization1-DESCRIPTOR,organization1-DEPARTMENT,organization2-NAME,organization2-DESCRIPTOR,organization2-DEPARTMENT,organization3-NAME,organization3-DESCRIPTOR,organization3-DEPARTMENT,contact1-FIRST_NAME,contact1-MIDDLE_NAME,contact1-LAST_NAME,contact1-NAME,contact1-TITLE,contact1-FUNCTION,contact1-SALUTATION,contact1-GENDER,contact2-FIRST_NAME,contact2-MIDDLE_NAME,contact2-LAST_NAME,contact2-NAME,contact2-TITLE,contact2-FUNCTION,contact2-SALUTATION,contact2-GENDER,contact3-FIRST_NAME,contact3-MIDDLE_NAME,contact3-LAST_NAME,contact3-NAME,contact3-TITLE,contact3-FUNCTION,contact3-SALUTATION,contact3-GENDER,residue1-NECESSARY,residue1-SUPERFLUOUS,residue2-NECESSARY,residue2-SUPERFLUOUS,residue3-NECESSARY,residue3-SUPERFLUOUS,residue4-NECESSARY,residue4-SUPERFLUOUS,residue5-NECESSARY,residue5-SUPERFLUOUS,residue6-NECESSARY,residue6-SUPERFLUOUS";
	
	/**
	 * Trim the space and double quota in the field of the input data.
	 * 
	 * @param field
	 * 		the field of the input data
	 * @return 
	 * 		the String without the space and double quota
	 */
	public static String trimInputField(String field) {
		StringBuffer buf = new StringBuffer("");

		if (field != null) {
			field = field.trim();

			// escape double quota in the beginning and end of the field
			if (field.startsWith("\"") && field.endsWith("\"") ) {
				field = field.substring(1,field.length()-1);
			}
			
			// escape double quota in the middle of the field
			if (field.contains("\"")) {
				StringBuffer buff = new StringBuffer("");
				char[] charArray = field.toCharArray();
				for (int i = 0; i < charArray.length ; i ++){
					buff.append(charArray[i]);
					if (charArray[i] == '\"') {
						if ( i < charArray.length-1 && charArray[i+1] == '\"') {
							i ++;
						}
					}
				}
				field = buff.toString();
			}
			
			buf.append(field);
		}
		return buf.toString();
	}
	
	/**
	 * Escape (space \r\n COMMA) in the field of output data.
	 * 
	 * @param field
	 * 		the field of the output data
	 * @return
	 * 		the String without space \r\n COMMA
	 */
	public static String trimOutputField(String field){
		StringBuffer buf = new StringBuffer("");
		if (field != null){
			field = field.trim().replace("\r\n", "");

			if (field.contains("\"")){
				StringBuffer buff = new StringBuffer("");
				char[] charArray = field.toCharArray();
				for (int i = 0; i < charArray.length; i++) {
					buff.append(charArray[i]);
					if (charArray[i] == '\"') {
						buff.append('\"');
					}
				}
				
				field = "\"" + buff.toString() + "\"";
			} else if (field.contains(",")) {
				field = "\"" + field + "\"";
			}
			
			buf.append(field);
		}
		
		return buf.toString();
	}
	
	/**
	 * Check the input data if it is an email address.
	 * 	
	 * @param field
	 * 		the input data
	 * @return
	 * 		true if it is an email, otherwise return false
	 */
	public static boolean checkEmail(String field){
		return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(field).matches();
	}
	
	/**
	 * Check the input data if it contains OutputFileName.
	 * 
	 * @param field
	 * 		the input data
	 * @return
	 * 		true if it contains OutputFileName, otherwise return false
	 */
	public static boolean checkOutputFileName(String field){
		return field == null ? false : field.startsWith(OUTPUTFILENAME);
	}

}
