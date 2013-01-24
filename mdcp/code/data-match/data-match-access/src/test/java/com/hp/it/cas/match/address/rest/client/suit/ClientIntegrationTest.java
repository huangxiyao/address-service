package com.hp.it.cas.match.address.rest.client.suit;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.hp.it.cas.match.address.rest.client.*;
import com.hp.it.cas.match.address.soap.client.SoapAddressAccessClientTest;

/**
 * Its role is that the users could test the all five clients together one time
 * in this junit annotations method by using SuiteClasses from junit tools.
 * Specified the class you need to test just in the @Suite.SuiteClasses({.. ).
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ValidatedAddressFinderRestProxyClientTest.class,
		CertifiedAddressFinderRestProxyClientTest.class,
		AddressSuggestionsAddressFinderRestProxyClientTest.class,
		FastCompletionAddressFinderRestProxyClientTest.class,
		SoapAddressAccessClientTest.class })
public class ClientIntegrationTest {
	
}
