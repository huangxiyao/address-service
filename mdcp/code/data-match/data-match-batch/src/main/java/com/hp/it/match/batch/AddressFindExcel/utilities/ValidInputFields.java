package com.hp.it.match.batch.AddressFindExcel.utilities;

/**
 * Valid the input fields.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
public class ValidInputFields {
	
	/**
	 * The modeUsed field of an input data.
	 *
	 */
	public static enum ModeUsed {
		BATCH, INTERACTIVE, FASTCOMPLETION, CERTIFIED, PARSE, COUNTRYRECOGNITION;
		
		/**
		 * Validates the modeUsed field.
		 * @param value
		 * 		the value of the modeUsed field.
		 * @return 
		 * 		true if it is an valid modeUsed, otherwise false.
		 */
		public static boolean isValidMode(String value) {
			try {
				ModeUsed.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		/**
		 * Get all the alternative values of the modeUsed field.
		 * @return String
		 */
		public static String getModeNames() {
			StringBuffer buf = new StringBuffer("");
			for(ModeUsed modeUsed: ModeUsed.values()){
				buf.append(modeUsed.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};

	/**
	 * The preferredLanguage field of an input data.
	 */
	public static enum PreferredLanguage {
		DATABASE, ENGLISH, ALTERNATIVE_1, ALTERNATIVE_2, ALTERNATIVE_3;
		/**
		 * Validates the preferredLanguage field.
		 * @param value
		 * 		the value of the preferredLanguage field
		 * @return
		 *      true if it is an valid preferredLanguage, otherwise false 
		 */
		public static boolean isValidPreferredLanguage(String value) {
			try {
				PreferredLanguage.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		/**
		 * Get all the alternative values of the preferredLanguage field.
		 * @return String
		 */
		public static String getPreferredLanguageNames() {
			StringBuffer buf = new StringBuffer("");
			for(PreferredLanguage preferredLanguage: PreferredLanguage.values()){
				buf.append(preferredLanguage.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};

	/**
	 * 
	 * The preferredScript field of an input data.
	 *
	 */
	public static enum PreferredScript {
		DATABASE, POSTAL_ADMIN_PREF, POSTAL_ADMIN_ALT, ASCII_SIMPLIFIED, ASCII_EXTENDED, LATIN, LATIN_ALT;
		/**
		 * Validates the preferredScript field.
		 * @param value
		 * 			the value of the preferredScript field
		 * @return
		 *  		true if it is an valid preferredScript, otherwise false
		 */
		public static boolean isValidPreferredScript(String value) {
			try {
				PreferredScript.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		/**
		 * Get all the alternative values of preferredScript field.
		 * @return String
		 */
		public static String getPreferredScriptNames() {
			StringBuffer buf = new StringBuffer("");
			for(PreferredScript preferredScript: PreferredScript.values()){
				buf.append(preferredScript.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};
}
