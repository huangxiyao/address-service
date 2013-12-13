package com.hp.it.cas.match.batch.utilities;

import java.util.regex.Pattern;

public class BatchUtils {
	public static String trimString(String input) {
		if (input != null) {
			input = input.trim();
			if (input.startsWith("\"") && input.endsWith("\"") ) {
				input = input.substring(1,input.length()-1);
			}
			return input;
		} else {
			return input;
		}
		
		//return input != null? input.trim() : input;
	}
	
	// escape "\r\n" in the output field 
	public static String trimCRLF(String output){
		return output.trim().replace("\r\n", "");
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
