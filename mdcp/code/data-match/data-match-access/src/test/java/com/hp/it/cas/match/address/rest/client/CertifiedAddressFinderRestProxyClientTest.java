package com.hp.it.cas.match.address.rest.client;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.hp.it.cas.match.address.client.support.AddressValidatedClientSupport;

/**
 * This class acts as a junit test class to test
 * CertifiedAddressFinderRestProxyClient
 * 
 * @see {@link com.hp.it.cas.match.address.rest.client.CertifiedAddressFinderRestProxyClient}
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class CertifiedAddressFinderRestProxyClientTest {
	
	/**
	 * Before the address processed with AddressDoctor, every request shall be
	 * checked by CAS security module, this method indicates that it initialize
	 * CAS security context preparing for check.
	 * 
	 * @see {@link com.hp.it.cas.match.address.rest.ExampleAddressFinderRestProxyTest}
	 * 
	 */
	@Before
	public void buildSecurityContext(){
		AddressValidatedClientSupport.buildSecurityContext();
	}
	
	/**
	 * Junit test main method
	 * 
	 */
	@Ignore
	@Test
	public void testExecute() {
		// The user write the AddressQueryResultSuitID here for specify which
		// AddressQuery shall be input
		String AddressQueryResultSuitID="Query001";
		Assert.assertTrue(CertifiedAddressFinderRestProxyClient.compareExpectedWithActual(AddressQueryResultSuitID));
	}
	
}
