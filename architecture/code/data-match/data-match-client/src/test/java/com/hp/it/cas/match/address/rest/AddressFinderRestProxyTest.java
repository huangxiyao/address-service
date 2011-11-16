package com.hp.it.cas.match.address.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressFinderRestProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=IllegalArgumentException.class)
	public void null_input_to_find_validated_address_throws_illegal_argument_exception() {
		AddressFinderRestProxy proxy = new AddressFinderRestProxy("http://irrelevant.url.com");
		proxy.findValidatedAddress(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void null_input_to_find_certified_address_throws_illegal_argument_exception() {
		AddressFinderRestProxy proxy = new AddressFinderRestProxy("http://irrelevant.url.com");
		proxy.findCertifiedAddress(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void null_input_to_find_address_suggestions_throws_illegal_argument_exception() {
		AddressFinderRestProxy proxy = new AddressFinderRestProxy("http://irrelevant.url.com");
		proxy.findAddressSuggestions(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void null_input_to_find_validated_address_with_wide_optimizations_throws_illegal_argument_exception() {
		AddressFinderRestProxy proxy = new AddressFinderRestProxy("http://irrelevant.url.com");
		proxy.findValidatedAddressWithWideOptimization(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void bad_url_throws_illegal_argument_exception() {
		new AddressFinderRestProxy("bad url");
	}
	

}
