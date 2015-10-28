package com.hp.it.cas.match.address;

/**
 * Finds a certified address per a given postal authority using this class. A number of countries have special requirements for the processing of addresses from their countries. An
 * example of such a special processing requirement is the CASS certification of the United States Postal Service (USPS). Operation will fall back to findValidatedAddress if it is
 * not supported for a specific country.
 * 
 * @author paul.truax@hp.com
 */
public interface CertifiedAddressFinder {

	/**
	 * Finds a certified address.
	 * 
	 * @param query
	 *            the address query
	 * @param messageContext
	 *            message context
	 * @return the address query result
	 */
	public abstract AddressQueryResult find(AddressQuery query);

}