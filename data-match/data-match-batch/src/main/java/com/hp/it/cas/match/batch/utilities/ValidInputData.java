package com.hp.it.cas.match.batch.utilities;

/**
 * Valid the input data.
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class ValidInputData {
	public static enum ModeUsed {
		BATCH, INTERACTIVE, FASTCOMPLETION, CERTIFIED, PARSE, COUNTRYRECOGNITION;
		public static boolean isValidMode(String value) {
			try {
				ModeUsed.valueOf(value);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public static String getModeNames() {
			return ModeUsed.BATCH.name() + ", " + ModeUsed.INTERACTIVE.name() + ", " + ModeUsed.FASTCOMPLETION.name() + ", " + ModeUsed.CERTIFIED.name() + ", " + ModeUsed.PARSE.name() + ", " + ModeUsed.COUNTRYRECOGNITION.name();
		}
	};

	public static enum PreferredLanguage {
		DATABASE, ENGLISH, ALTERNATIVE_1, ALTERNATIVE_2, ALTERNATIVE_3;
		public static boolean isValidPreferredLanguage(String value) {
			try {
				PreferredLanguage.valueOf(value);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public static String getPreferredLanguageNames() {
			return PreferredLanguage.DATABASE.name() + "," + PreferredLanguage.ENGLISH.name() + "," + PreferredLanguage.ALTERNATIVE_1.name() + "," + PreferredLanguage.ALTERNATIVE_2.name() + "," + PreferredLanguage.ALTERNATIVE_3.name();
		}

	}

	public static enum PreferredScript {
		DATABASE, POSTAL_ADMIN_PREF, POSTAL_ADMIN_ALT, ASCII_SIMPLIFIED, ASCII_EXTENDED, LATIN, LATIN_ALT;
		public static boolean isValidPreferredScript(String value) {
			try {
				PreferredScript.valueOf(value);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public static String getPreferredScriptNames() {
			return PreferredScript.DATABASE.name() + "," + PreferredScript.POSTAL_ADMIN_PREF.name() + "," + PreferredScript.POSTAL_ADMIN_ALT + "," + PreferredScript.ASCII_SIMPLIFIED.name() + "," + PreferredScript.ASCII_EXTENDED.name() + ","
					+ PreferredScript.LATIN.name() + "," + PreferredScript.LATIN_ALT.name();
		}

	}
	
}
