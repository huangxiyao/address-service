package com.hp.it.cas.match.address;


public interface IAddressFinder {

	/**
	 * This operation is intended to be used in batch processing environments when no human input or selection is possible. It is optimized for speed and will terminate its
	 * attempts to correct an address when ambiguous data is encountered that cannot be corrected automatically. The operation will fall back to Parse Only, when the respective
	 * database is missing for a specific country.
	 * 
	 * @param query
	 *            the address query
	 * @return the address query result
	 */
	public abstract AddressQueryResult findValidatedAddress(AddressQuery query);

	/**
	 * Finds a certified address per a given postal authority. A number of countries have special requirements for the processing of addresses from their countries. An example of
	 * such a special processing requirement is the CASS certification of the United States Postal Service (USPS). Operation will fall back to findValidatedAddress if it is not
	 * supported for a specific country.
	 * 
	 * @param query
	 *            the address query
	 * @param messageContext
	 * 			  message context
	 * @return the address query result
	 */
	public abstract AddressQueryResult findCertifiedAddress(AddressQuery query);

	/**
	 * This operation is intended to be used in batch processing environments when no human input or selection is possible. It is optimized for speed and will terminate its
	 * attempts to correct an address when ambiguous data is encountered that cannot be corrected automatically. The operation will fall back to Parse Only, when the respective
	 * database is missing for a specific country. This operation differs from findValidatedAddress because the matching logic is widened. Parser separation will happen similarly
	 * to STANDARD , but additionally up to 10 parsing candidates will be passed to validation for processing. Validation will widen its search tree and take additional reference
	 * data entries into account for matching.
	 * 
	 * @param query
	 *            the address query
	 * @param messageContext
	 * 			  message context
	 * @return the address query result
	 */
	public abstract AddressQueryResult findValidatedAddressWithWideOptimization(AddressQuery query);

	/**
	 * Finds a number of address suggestions. When working in interactive environments, it is often useful to generate suggestions when an address input is ambiguous. This can be
	 * achieved by using this operation. This validation type is especially useful in Web based data entry environments when capturing data from customers or prospects. It requires
	 * the input of an almost complete address and will attempt to validate or correct the data provided. If ambiguities are detected, this validation type will generate up to 20
	 * suggestions that can be used for pick lists. The Interactive processing mode will fall back to Parse Only, when the respective database is missing for a specific country.
	 * 
	 * @param query
	 *            the address query
	 * @param messageContext
	 * 			  message context
	 * @return the address query result
	 */
	public abstract AddressQueryResult findAddressSuggestions(AddressQuery query);

}