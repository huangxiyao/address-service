package com.hp.it.match.batch.AddressFindExcel.utilities;

import java.util.regex.Pattern;

import com.hp.it.cas.match.address.utilities.StringUtils;

/**
 * Utils Class
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class BatchUtils {
	
	public static String OUTPUTFILENAME = "outputFileName";
	
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
	
	/**
	 * Trim one string.
	 * @param str
	 * 		the string need to trim
	 * @return String
	 * 		the string after trim
	 */
	public static String trimString(String str) {
		return StringUtils.isNullOrEmpty(str) ? str : str.trim();
	}

}
