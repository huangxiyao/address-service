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
	 * Array to String
	 * @param array
	 * @return String
	 */
	public static String arrayToString(Object[] array) {
		if (array == null)
			return "null";
		int iMax = array.length - 1;
		if (iMax == -1)
			return "";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(String.valueOf(array[i]));
			if (i == iMax)
				return b.toString();
			b.append(",");
		}
	}
}
