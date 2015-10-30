package com.hp.it.cas.match.address.rest.client;

import org.apache.log4j.Logger;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.client.support.AddressQueryResultSuit;
import com.hp.it.cas.match.address.client.support.AddressResultParse;
import com.hp.it.cas.match.address.client.support.AddressValidatedClientSupport;
import com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy;

/**
 * This class acts as a client to invoke AddressDoctor standardization rest
 * interface process the address defined by yourself with ValidatedAddress way
 * 
 * @see {@link com.hp.it.cas.match.address.rest.ValidatedAddressFinderRestProxy}
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class ValidatedAddressFinderRestProxyClient {

	/**
	 * Create the logger for log process status
	 */
	static Logger logger = Logger.getLogger(AddressValidatedClientSupport.class.getName());

	/**
	 * Input addressQueryResultSuitID get the AddressQueryResult
	 * 
	 * @param addressQueryResultSuitID
	 *            To get the addressQueryResultSuit by addressQueryResultSuitID
	 * 
	 * @return The AddressQueryResult parsed by rest
	 */
	public final static AddressQueryResult executeValidatedAddressAccess(String addressQueryResultSuitID) {
		ValidatedAddressFinderRestProxy validatedAddressFinderRestProxy = null;
		AddressQueryResultSuit addressQueryResultSuit = null;

		try {
			addressQueryResultSuit = AddressValidatedClientSupport.getAddressQueryResultSuitMap().get(
					addressQueryResultSuitID);

			if (!AddressValidatedClientSupport.DIRECT_URL_ACCESS_FLAG
					|| AddressValidatedClientSupport.DIRECT_ACCESS_URL.isEmpty()) {
				validatedAddressFinderRestProxy = new ValidatedAddressFinderRestProxy(
						AddressValidatedClientSupport
								.getAddressDoctorURL(AddressValidatedClientSupport.VALIDATEDADDRESS_ACCESS_URL_CODE));
			} else {
				validatedAddressFinderRestProxy = new ValidatedAddressFinderRestProxy(
						AddressValidatedClientSupport.DIRECT_ACCESS_URL);
			}

		} catch (Exception e) {
			logger.error(e.toString(), e);
		}

		AddressQueryResult result = validatedAddressFinderRestProxy.find(addressQueryResultSuit.getAddressQuery());
		return result;
	}

	/**
	 * Compare expected result with actual result by input
	 * addressQueryResultSuitID
	 * 
	 * @param addressQueryResultSuitID
	 *            AddressQueryResultSuitID to get addressQueryResultSuit.
	 * 
	 * @return false:Actual result is not fit for Expect result, and pass the
	 *         test true :Actual result is fit for Expect result, and fail the
	 *         test
	 */
	public static boolean compareExpectedWithActual(String AddressQueryResultSuitID) {

		AddressQueryResultSuit addressQueryResultSuit = null;
		AddressQueryResult result = null;
		try {
			addressQueryResultSuit = AddressValidatedClientSupport.getAddressQueryResultSuitMap().get(
					AddressQueryResultSuitID);
			result = executeValidatedAddressAccess(addressQueryResultSuit.getAqsID());
			String actual = AddressResultParse.parseAddressQueryResultToString(result);
			String expected = null;
			expected = AddressValidatedClientSupport.getResultStringByResultCode(addressQueryResultSuit
					.getValidatedAddressResultCode());
			String actualStatements = "Actual   AddressQueryResult with AddressQuery "
					+ addressQueryResultSuit.getAqsID() + " through ValidatedAddress of rest way is " + actual;
			String expectedStatements = "Expected AddressQueryResult with AddressQuery "
					+ addressQueryResultSuit.getAqsID() + " through ValidatedAddress of rest way is " + expected;

			if (expected.equals(actual)) {

				logger.fatal(actualStatements);
				logger.fatal(expectedStatements);
				logger.fatal("The AddressQueryResult with AddressQueryID:" + AddressQueryResultSuitID
						+ " through ValidatedAddress of rest way is right!");
				return true;
			} else {
				logger.fatal(actualStatements);
				logger.fatal(expectedStatements);
				logger.fatal("The AddressQueryResult with AddressQueryID:" + AddressQueryResultSuitID
						+ "  through ValidatedAddress of rest way is wrong!");
				return false;
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			logger.fatal("The AddressQueryResult with AddressQueryID:" + AddressQueryResultSuitID + " is wrong!");
			return false;
		}
	}
}
