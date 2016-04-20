package com.hp.it.cas.match.address.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.jcip.annotations.Immutable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.lang.UScript;

/**
 * This Enumeration provides script detection service. It is the skeleton of
 * detection logic. It first fetches all script segments appearing in input
 * string, and then identifies string script by every concrete detector.
 * 
 * @author <link href="yin-hao.liang@hp.com">Leon Liang</link>
 * @version 1.0
 */
public enum CharacterScript {
	/**
	 * Input Strings which are appropriate for Arabic should contain: 1 to many
	 * occurrences of Arabic characters plus 0 to many occurrences of Latin or
	 * Common characters that may be followed by a non spacing mark.
	 */
	ARABIC("ARAB") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.ARABIC);// "Arabic";
		}
	},
	/**
	 * Input Strings which are appropriate for Cyrillic should contain: 1 to
	 * many occurrences of Cyrillic, characters plus 0 to many occurrences of
	 * Latin or Common characters that may be followed by a non spacing mark.
	 */
	CYRILLIC("CYRL") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.CYRILLIC);// "Cyrillic";
		}
	},
	/**
	 * Input Strings which are appropriate for Chinese Simplified or Chinese
	 * Traditional should contain: 1 to many occurrences of Han plus 0 to many
	 * occurrences of , Latin or Common characters that may be followed by a non
	 * spacing mark.
	 */
	HAN("HAN*") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.HAN);// "Han";
		}
	},
	/**
	 * Input Strings which are appropriate for Hebrew should contain: 1 to many
	 * occurrences of Hebrew plus 0 to many occurrences of Latin or Common
	 * characters that may be followed by a non spacing mark.
	 */
	HEBREW("HEBR") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.HEBREW);// "Hebrew";
		}
	},
	/**
	 * Input Strings which are appropriate for Japanese should contain: 1 to
	 * many occurrences of Han character and 1 to many occurrences of Hiragana
	 * or Katakana characters plus 0 to many occurrences of Latin or Common
	 * characters that may be followed by a non spacing mark.
	 */
	JAPAN("JPAN") {
		@Override
		protected CharacterScript match(Set<String> scriptSet) {
			// Create a java.util.HashSet<String> object named as allowedScript
			// and put LATIN and COMMON into it.
			Set<String> allowedScripts = new HashSet<String>();
			allowedScripts.add(UScript.getName(UScript.LATIN).toLowerCase());
			allowedScripts.add(UScript.getName(UScript.COMMON).toLowerCase());
			String HAN = UScript.getName(UScript.HAN);
			String HIRAGANA = UScript.getName(UScript.HIRAGANA);
			String KATAKANA = UScript.getName(UScript.KATAKANA);

			Iterator<String> i = scriptSet.iterator();
			boolean containsHan = false;
			boolean containsHiragana = false;
			boolean containsKatakana = false;
			while (i.hasNext()) {
				String script = i.next();
				if (StringUtils.isNotEmpty(script)) {
					if (HAN.equalsIgnoreCase(script)) {
						containsHan = true;
					} else if (HIRAGANA.equalsIgnoreCase(script)) {
						containsHiragana = true;
					} else if (KATAKANA.equalsIgnoreCase(script)) {
						containsKatakana = true;
					} else {
						if (!allowedScripts.contains(script.toLowerCase())) {
							return null;
						}
					}
				}
			}

			if (!containsHan) {
				return null;
			}

			if (!containsHiragana && !containsKatakana) {
				return null;
			}

			return this;
		}
	},
	/**
	 * Input Strings which are appropriate for Japanese - Kana should contain: 1
	 * to many occurrences of Hiragana or Katakana characters plus 0 to many
	 * occurrences of Latin or Common characters that may be followed by a non
	 * spacing mark.
	 */
	KATAKANA("KANA") {
		@Override
		protected CharacterScript match(Set<String> scriptSet) {
			// Create a java.util.HashSet<String> object named as allowedScript
			// and put LATIN and COMMON into it.
			Set<String> allowedScripts = new HashSet<String>();
			allowedScripts.add(UScript.getName(UScript.LATIN).toLowerCase());
			allowedScripts.add(UScript.getName(UScript.COMMON).toLowerCase());
			String HIRAGANA = UScript.getName(UScript.HIRAGANA);
			String KATAKANA = UScript.getName(UScript.KATAKANA);

			Iterator<String> i = scriptSet.iterator();
			boolean containsHiragana = false;
			boolean containsKatakana = false;
			while (i.hasNext()) {
				String script = i.next();
				if (StringUtils.isNotEmpty(script)) {
					if (HIRAGANA.equalsIgnoreCase(script)) {
						containsHiragana = true;
					} else if (KATAKANA.equalsIgnoreCase(script)) {
						containsKatakana = true;
					} else {
						if (!allowedScripts.contains(script.toLowerCase())) {
							return null;
						}
					}
				}
			}

			if (!containsHiragana && !containsKatakana) {
				return null;
			}

			return this;
		}
	},
	/**
	 * Input Strings which are appropriate for Korean should contain: 1 to many
	 * occurrences of Hangula plus 0 to many occurrences of Han, Latin or Common
	 * characters that may be followed by a non spacing mark.
	 */
	HANGUL("KORE") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.HANGUL);// "Hangul";
		}

		@Override
		protected Set<String> getAllowedScripts() {
			// Override it because Han is also allowed for Hangul.
			Set<String> allowedScripts = new HashSet<String>();
			allowedScripts.add(UScript.getName(UScript.HAN));
			allowedScripts.add(UScript.getName(UScript.LATIN));
			allowedScripts.add(UScript.getName(UScript.COMMON));
			return allowedScripts;
		}
	},
	/**
	 * Input Strings which are appropriate for Latin should contain: 0 to many
	 * occurrences of Latin or Common characters that may be followed by a non
	 * spacing mark.
	 */
	LATIN("LATN") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.LATIN);// "Latin";
		}
	},
	/**
	 * Input Strings which are appropriate for Greek should contain: 1 to many
	 * occurrences of Greek characters plus 0 to many occurrences of Latin or
	 * Common characters that may be followed by a non spacing mark.
	 */
	GREEK("GREK") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.GREEK);// "Greek";
		}
	},
	/**
	 * Input Strings which are appropriate for Common should contain only Common
	 * characters.
	 */
	COMMON("COMM") {
		@Override
		protected String getDominatedScript() {
			return UScript.getName(UScript.COMMON);// "Common";
		}

		@Override
		protected Set<String> getAllowedScripts() {
			Set<String> allowedScripts = new HashSet<String>();
			allowedScripts.add(UScript.getName(UScript.COMMON));
			return allowedScripts;
		}
	};

	private final static Logger logger = LoggerFactory.getLogger(CharacterScript.class);

	/**
	 * Script alias, the length of alias is 4.
	 */
	private String alias;

	/**
	 * This is a service, detecting a Unicode string’s script (aka writing
	 * system). The input is a Unicode string and the output is an instance of
	 * Analysis.
	 * 
	 * @param source
	 *            The Unicode string to be detected.
	 * @return The final result of detection service, if unidentified, return
	 *         <code>null</code>
	 */
	public static Analysis analyze(String source) {
		if (StringUtils.isNotEmpty(source)) {
			List<UnicodeString> usList = locateScriptBoundaries(source);

			Set<String> scriptSet = getScriptSet(usList);

			CharacterScript identifiedScript = identifyScript(scriptSet);
			if (null == identifiedScript) {
				logger.warn("Cannot identify the script of input string");
				return null;
			}

			int length = source.codePointCount(0, source.length());

			boolean isNonLatin = isNonLatin(identifiedScript);

			return new Analysis(identifiedScript, length, isNonLatin);
		} else {
			logger.warn("The input string is null or empty");
			return null;
		}
	}

	/**
	 * This is a service, detecting a Unicode string’s script (aka writing
	 * system). The input is a Unicode string and the output is identified
	 * script alias.
	 * 
	 * @param source
	 *            The Unicode string to be detected.
	 * @return The identified script, if unidentified, return <code>null</code>.
	 */
	public static CharacterScript detect(String source) {
		Analysis analysisTmp = analyze(source);
		if(analysisTmp != null){
			return analysisTmp.getScript();
		}
		return null;
	}

	/**
	 * The match method contains the vast majority of the logic for analyzing
	 * whether the given Unicode Script set is appropriate for a certain writing
	 * system. It covers the processing narrative which is common for handling
	 * most cases. For those writing systems which have multiple dominated
	 * scripts, like {@link com.hp.it.cas.match.script.CharacterScript.JAPAN}
	 * and {@link com.hp.it.cas.match.script.CharacterScript.KATAKANA}, the
	 * common logic doesn't work, so that those enum types need to override this
	 * method with their own logic.
	 * 
	 * @param scriptSet
	 *            A set of Unicode Script
	 * @return The enum type if the given script set is appropriate for it. Else
	 *         return null.
	 */
	protected CharacterScript match(Set<String> scriptSet) {
		String dominatedScript = getDominatedScript();
		Set<String> allowedScripts = getAllowedScripts();
		if (dominatedScript == null || allowedScripts == null || dominatedScript.length() < 1) {
			return null;
		}
		// convert all elements of the allowedScripts into lower cased.
		Iterator<String> allowedScriptsIter = allowedScripts.iterator();
		Set<String> tempAllowedScripts = new HashSet<String>();
		while (allowedScriptsIter.hasNext()) {
			String script = allowedScriptsIter.next();
			if (script != null) {
				tempAllowedScripts.add(script.toLowerCase());
			}
		}

		Iterator<String> i = scriptSet.iterator();
		boolean containsDominatedScript = false;
		while (i.hasNext()) {
			String script = i.next();
			if (StringUtils.isNotEmpty(script)) {
				if (dominatedScript.equalsIgnoreCase(script)) {
					containsDominatedScript = true;
				} else {
					if (!tempAllowedScripts.contains(script.toLowerCase())) {
						return null;
					}
				}
			}
		}
		if (!containsDominatedScript) {
			return null;
		}

		return this;

	}

	/**
	 * Return null and let most CharacterScript enum types override it for the
	 * corresponding language.
	 * 
	 * @return The dominated script which will be used in distinguishing a
	 *         sequence of characters appropriate for certain writing system.
	 */
	protected String getDominatedScript() {
		return null;
	}

	/**
	 * Return a set whose elements are UScript.getName(UScript.LATIN),
	 * UScript.getName(UScript.COMMON)
	 * 
	 * @return The allowed script set which will be used in distinguishing a
	 *         sequence of characters appropriate for certain writing system.
	 */
	protected Set<String> getAllowedScripts() {
		Set<String> allowedScripts = new HashSet<String>();
		allowedScripts.add(UScript.getName(UScript.LATIN));
		allowedScripts.add(UScript.getName(UScript.COMMON));
		return allowedScripts;
	}

	/**
	 * Constructor of CharacterScript, initialize member alias.
	 * 
	 * @param alias
	 *            specify character script alias
	 */
	private CharacterScript(String alias) {
		this.alias = alias;
	}

	/**
	 * This method is used to detect input string and locate the script
	 * boundaries, and return result as a UnicodeString list.
	 * 
	 * @param source
	 *            The string value of the input that to be detected
	 * @return This list contains all script pieces appearing in input string
	 */
	private static List<UnicodeString> locateScriptBoundaries(String source) {
		List<UnicodeString> usList = new ArrayList<UnicodeString>();
		ScriptRun sr = new ScriptRun();

		sr.setText(source.toCharArray(), 0, source.toCharArray().length);
		while (sr.next()) {
			UnicodeString us = new UnicodeString(sr.getLength(), sr.getScript());
			usList.add(us);
		}

		return usList;
	}

	/**
	 * This method is used to collect all scripts that appearing in list of
	 * script boundary.
	 * 
	 * @param usList
	 *            This list contains all script boundaries appearing in input
	 *            string.
	 * @return Script set collected from input string
	 */
	private static Set<String> getScriptSet(List<UnicodeString> usList) {
		Set<String> scriptSet = new HashSet<String>();
		for (UnicodeString us : usList) {
			scriptSet.add(us.getScript());
		}
		return scriptSet;
	}

	/**
	 * This method is used to check if the input string contains Latin
	 * character.
	 * 
	 * @param script
	 *            Identified script of the input string.
	 * @return <code>true</code> if script is LATIN, otherwise
	 *         <code>false</code>
	 */
	private static boolean isNonLatin(CharacterScript script) {
		if (script.equals(CharacterScript.LATIN)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method is used to analyze the length of input string.
	 * 
	 * @param usList
	 *            This list contains all script boundaries appearing in input
	 *            string
	 * @return Analyzed length of input string
	 */
	private static int analyzeLength(List<UnicodeString> usList) {
		int length = 0;
		for (UnicodeString us : usList) {
			length += us.getLength();
		}
		return length;
	}

	/**
	 * This method is used to identify the script of input string by every
	 * available script concrete detectors.
	 * 
	 * @param scriptSet
	 *            Script set contains all scripts appearing in input string.
	 * @return The identified script, if unidentified, return <code>null</code>.
	 */
	private static CharacterScript identifyScript(Set<String> scriptSet) {
		for (CharacterScript detector : CharacterScript.values()) {
			CharacterScript characterScript = detector.match(scriptSet);
			if (characterScript != null) {
				return characterScript;
			}
		}
		return null;
	}

	/**
	 * This class is as the result of character script detection service.
	 * Storing all that required fields. It’s an inner class of CharacterScript
	 * 
	 * @author <link href="yin-hao.liang@hp.com">Leon Liang</link>
	 * @version 1.0
	 */
	@Immutable
	public static final class Analysis {

		/**
		 * Input string’s script identified
		 */
		private final CharacterScript script;

		/**
		 * Analyzed length of full input string
		 */
		private final int length;

		/**
		 * Indicator if input string includes non-Latin characters
		 */
		private final boolean nonLatin;

		/**
		 * Getter for script
		 * 
		 * @return script
		 */
		public CharacterScript getScript() {
			return script;
		}

		/**
		 * Getter for length
		 * 
		 * @return length
		 */
		public int getLength() {
			return length;
		}

		/**
		 * Getter for nonLatin
		 * 
		 * @return nonLatin
		 */
		public boolean isNonLatin() {
			return nonLatin;
		}

		/**
		 * Constructor for Analysis, instancing and initializing all members
		 * 
		 * @param script
		 * @param leng
		 * @param nonLatin
		 */
		public Analysis(CharacterScript script, int leng, boolean nonLatin) {
			this.script = script;
			this.length = leng;
			this.nonLatin = nonLatin;

		}
	}

	/**
	 * This class is inner class of CharacterScript which is used to store
	 * script segments retrieved from input string.
	 * 
	 * @author <link href="yin-hao.liang@hp.com">Leon Liang</link>
	 * @version 1.0
	 */
	private static class UnicodeString {
		/**
		 * Analyzed length for one piece of input string
		 */
		private int length;

		/**
		 * The script of one piece of input string
		 */
		private String script;

		/**
		 * Constructor of UnicodeString, instancing and initializing all members
		 * 
		 * @param length
		 * @param script
		 */
		UnicodeString(int length, String script) {
			this.length = length;
			this.script = script;
		}

		public int getLength() {
			return length;
		}

		public String getScript() {
			return script;
		}

	}

	@Override
	public String toString() {
		return this.alias;
	}
	
}
