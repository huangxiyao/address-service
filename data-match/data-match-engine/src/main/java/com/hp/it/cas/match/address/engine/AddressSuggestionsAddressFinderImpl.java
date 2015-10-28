package com.hp.it.cas.match.address.engine;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressSuggestionsFinder;

/**
 * @see {@link com.hp.it.cas.match.address.AddressSuggestionsFinder}
 * 
 */
public class AddressSuggestionsAddressFinderImpl extends AbstractAddressFinder implements AddressSuggestionsFinder {
	
	/**
	 * Construct an address suggestions finder.
	 */
	public AddressSuggestionsAddressFinderImpl(boolean doValidation) {
		super(doValidation);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.AddressSuggestionsFinder#suggest(AddressQuery)}
	 */
	public AddressQueryResult suggest(AddressQuery query) {
		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = withLogging(query, interactiveModeParametersXmlString, InvokedMethod.SUGGESTIONS);
		return result;
	}

}
