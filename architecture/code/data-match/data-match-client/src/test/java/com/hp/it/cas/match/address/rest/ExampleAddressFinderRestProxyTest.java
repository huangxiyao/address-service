package com.hp.it.cas.match.address.rest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hp.it.cas.foundation.security.SecurityContextHolder;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;

@Ignore
public class ExampleAddressFinderRestProxyTest {

	@Before
	public void setUp() throws Exception {
		//System.setProperty("http.proxyHost", "127.0.0.1");
		//System.setProperty("http.proxyPort", "8888");
	}

	@Test
	public void testFindValidatedAddress() {
		SecurityContextTestController securityController = new SecurityContextTestController();
		securityController.collectAndSetupSecurityContext(testEnvironment());
		Assert.assertTrue(SecurityContextHolder.isSecurityContextSet());
		AddressFinderRestProxy proxy = new AddressFinderRestProxy("http://it-services-itg-g2.austin.hp.com/match");
		AddressQueryResult result = proxy.findValidatedAddress(addressQuery());
		System.out.println(result);
	}
	
	
	private AddressQuery addressQuery(){
		AddressQuery query = new AddressQuery();
		query.setDeliveryAddressLine1("745 Riverhaven Drive");
		query.setCountry1("US");
		query.setPostalCode1("30024");
		//query.setFormattedAddressLine1("test");
		//query.setBuilding1("building1");
		return query;
	}
	
	private ClientTestEnvironment testEnvironment(){
		return new ClientTestEnvironment("callingAppUid", null, null);
	}

}
