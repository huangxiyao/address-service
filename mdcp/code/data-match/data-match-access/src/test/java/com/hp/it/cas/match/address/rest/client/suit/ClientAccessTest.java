package com.hp.it.cas.match.address.rest.client.suit;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import com.hp.it.cas.match.address.client.support.AddressValidatedClientSupport;
import com.hp.it.cas.match.address.rest.client.*;

/**
 * Its role is that the user can only directly input the address and query input
 * code in the testClientByAddressAndInput() of this class in order to check out
 * whether the result is correct or not.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class ClientAccessTest {
	
	/**
	 * Every rest way need build security context before the access begin.
	 * 
	 * @version 1.0
	 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
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
	public void testClientByAddressAndInput(){
		//The user write the address here for specify the input address
		String address = "http://cas-team3.asiapacific.hpqcorp.net:8380/match/validatedAddress";
		//The user write the InputID here for specify the input
		String InputID = "Query005";		
		// The user set the flag about whether access the client by your address
		// directly, true means by you address directly, false means not.
		AddressValidatedClientSupport.DIRECT_URL_ACCESS_FLAG = true;
		
		AddressValidatedClientSupport.DIRECT_ACCESS_URL = address;
		Assert.assertTrue(executeClientByAddressAndInput(address,InputID));

	}
	
	/**
	 * Compare expected result with actual result by inputID and address 
	 * 
	 * @param inputID
	 *            To decide which query shall be input.
	 * 
	 * return 
	 * 			  false:Actual result is not fit for Expect result, and pass the test 
	 * 			  true :Actual result is fit for Expect result, and fail the test 
	 */
	private Boolean executeClientByAddressAndInput(String address,String inputID){
		
		if(inputID==null||address==null||address.isEmpty()||inputID.isEmpty()){
			return false;
		}else if(address.endsWith("/validatedAddress")){
			return ValidatedAddressFinderRestProxyClient.compareExpectedWithActual(inputID);
		}else if(address.endsWith("/addressSuggestions")){
			return AddressSuggestionsAddressFinderRestProxyClient.compareExpectedWithActual(inputID);
		}else if(address.endsWith("/certifiedAddress")){
			return CertifiedAddressFinderRestProxyClient.compareExpectedWithActual(inputID);
		}else if(address.endsWith("/looselyValidatedAddress")){
			return LooselyAddressFinderRestProxyClient.compareExpectedWithActual(inputID);
		}
		return false;
	}
}