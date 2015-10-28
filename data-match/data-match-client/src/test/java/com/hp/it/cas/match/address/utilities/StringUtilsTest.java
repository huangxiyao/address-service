package com.hp.it.cas.match.address.utilities;

import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	private static final String IRRELEVANT_VALUE = "irrelevant value";

	@Test
	public void passing_null_value_returns_true() {
		assertTrue(isNullOrEmpty(null));
	}
	
	@Test
	public void passing_empty_string_returns_true(){
		assertTrue(isNullOrEmpty(""));
	}
	
	@Test
	public void passing_non_empty_string_returns_false(){
		assertFalse(isNullOrEmpty(IRRELEVANT_VALUE));
	}

	
}
