package com.hp.it.cas.match.address;


public interface AddressSuggestionsFinder {
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
	public abstract AddressQueryResult suggest(AddressQuery query);

}