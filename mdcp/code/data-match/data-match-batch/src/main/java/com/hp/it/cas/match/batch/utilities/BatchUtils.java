package com.hp.it.cas.match.batch.utilities;

import java.util.regex.Pattern;

public class BatchUtils {
	public static String trimString(String input) {
//		if (input != null) {
//			return input.trim();
//		} else {
//			return input;
//		}
		return input != null? input.trim() : input;
	}
	
	
	public static boolean checkEmail(String input){
		return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(input).matches();
	}
	
	// TODO
	public static boolean checkCSVFileName(String input){
		//return (Pattern.compile("outputFileName*.csv").matcher(input).matches());
		return input.contains("outputFileName");
	}
}
