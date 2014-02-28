package com.hp.it.match.batch.AddressFindExcel.utilities;

/**
 * Valid the input fields.
 * 
 * @author yu-juan.zhang@hp.com
 * 
 */
// TODO add java doc
public class ValidInputFields {
	public static enum ModeUsed {
		BATCH, INTERACTIVE, FASTCOMPLETION, CERTIFIED, PARSE, COUNTRYRECOGNITION;
		public static boolean isValidMode(String value) {
			try {
				ModeUsed.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		public static String getModeNames() {
			StringBuffer buf = new StringBuffer("");
			for(ModeUsed modeUsed: ModeUsed.values()){
				buf.append(modeUsed.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};

	public static enum PreferredLanguage {
		DATABASE, ENGLISH, ALTERNATIVE_1, ALTERNATIVE_2, ALTERNATIVE_3;
		public static boolean isValidPreferredLanguage(String value) {
			try {
				PreferredLanguage.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		public static String getPreferredLanguageNames() {
			StringBuffer buf = new StringBuffer("");
			for(PreferredLanguage preferredLanguage: PreferredLanguage.values()){
				buf.append(preferredLanguage.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};

	public static enum PreferredScript {
		DATABASE, POSTAL_ADMIN_PREF, POSTAL_ADMIN_ALT, ASCII_SIMPLIFIED, ASCII_EXTENDED, LATIN, LATIN_ALT;
		public static boolean isValidPreferredScript(String value) {
			try {
				PreferredScript.valueOf(value);
				return true;
			} catch (Exception e) {
			}
			return false;
		}

		public static String getPreferredScriptNames() {
			StringBuffer buf = new StringBuffer("");
			for(PreferredScript preferredScript: PreferredScript.values()){
				buf.append(preferredScript.name()).append(",");
			}
			return buf.substring(0, buf.length()-1);
		}
	};
}
