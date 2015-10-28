package com.hp.it.cas.match.address;

/**
 * This class is intended to be used in batch processing environments when no human input or selection is possible. It is optimized for speed and will terminate its attempts to
 * correct an address when ambiguous data is encountered that cannot be corrected automatically. The operation will fall back to Parse Only, when the respective database is missing
 * for a specific country. This operation differs from findValidatedAddress because the matching logic is widened. Parser separation will happen similarly to STANDARD , but
 * additionally up to 10 parsing candidates will be passed to validation for processing. Validation will widen its search tree and take additional reference data entries into
 * account for matching.
 * 
 * @author paul.truax@hp.com
 */
public interface LooselyValidatedAddressFinder {

	/**
	 * Find a loosely validated address
	 * 
	 * @param query
	 *            the address query
	 * @param messageContext
	 *            message context
	 * @return the address query result
	 */
	public abstract AddressQueryResult find(AddressQuery query);

}