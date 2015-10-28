package com.hp.it.cas.match.address.rest.client;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import com.hp.it.cas.match.address.client.support.AddressValidatedClientSupport;

/**
 * This class acts as a junit test class to test
 * LooselyAddressFinderRestProxyClient
 * 
 * @see {@link com.hp.it.cas.match.address.rest.client.LooselyAddressFinderRestProxyClient}
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class LooselyAddressFinderRestProxyClientTest  {

	/**
	 * Create the logger for log process status 
	 */
	static Logger logger = Logger.getLogger(LooselyAddressFinderRestProxyClient.class.getName());
	
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
	@Test
	public void testExecute() {	
		// The user write the AddressQueryResultSuitID here for specify which
		// AddressQuery shall be input
		String AddressQueryResultSuitID="Query001";
		Assert.assertTrue(LooselyAddressFinderRestProxyClient.compareExpectedWithActual(AddressQueryResultSuitID));
	}
}
