package com.hp.it.cas.match.address.soap.client;

import java.net.MalformedURLException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * This class acts as a junit test class to test
 * SoapAddressAccessClient.
 * 
 * @see {@link com.hp.it.cas.match.address.soap.client.SoapAddressAccessClient}
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class SoapAddressAccessClientTest {
	
	/**
	 * Junit test main method
	 * Execute the address process with Junit case by soap way.
	 * @see {@link com.hp.it.cas.match.address.soap.SampleWSClientTest} 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testExecute() throws MalformedURLException {
				
		// The user write the SoapInOutputSuitID here for specify which
		// ArrayOfString shall be input
		String SoapInOutputSuitID="Soap005";
		Assert.assertTrue(SoapAddressAccessClient.compareExpectedWithActual(SoapInOutputSuitID));
	}
	
}
