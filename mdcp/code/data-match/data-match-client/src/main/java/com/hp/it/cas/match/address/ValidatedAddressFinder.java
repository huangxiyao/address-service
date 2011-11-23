package com.hp.it.cas.match.address;

/**
 * This address finder is intended to be used in batch processing environments when no human input or selection is possible. It is optimized for speed and will terminate its
 * attempts to correct an address when ambiguous data is encountered that cannot be corrected automatically. The operation will fall back to Parse Only, when the respective
 * database is missing for a specific country.
 * 
 * @author paul.truax@hp.com
 */
public interface ValidatedAddressFinder {

	/**
	 * Execute standardization routine.
	 * 
	 * @param query
	 *            the address query
	 * @return the address query result
	 */
	public abstract AddressQueryResult find(AddressQuery query);

}