package com.hp.it.cas.match.address.utilities;

/**
 * String utilities leveraged by address doctor classes.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class StringUtils {

	/**
	 * Returns true if string is either null or empty.
	 * 
	 * @param input
	 *            the string
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(String input) {
		boolean nullOrEmpty = true;

		if (!(input == null || input.trim().equals(""))) {
			nullOrEmpty = false;
		}

		return nullOrEmpty;
	}

}
