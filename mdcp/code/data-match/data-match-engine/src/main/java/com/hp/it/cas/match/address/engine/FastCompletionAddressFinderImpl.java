package com.hp.it.cas.match.address.engine;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.FastCompletionAddressFinder;

/**
 * @see {@link com.hp.it.cas.match.address.FastCompletionAddressFinder}}
 * 
 *@author hong-bol@hp.com
 *
 */
public class FastCompletionAddressFinderImpl extends AbstractAddressFinder implements FastCompletionAddressFinder{

	/**
	 * Construct a fast completion validated address finder.
	 */
	public FastCompletionAddressFinderImpl(boolean doValidation) {
		super(doValidation);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.FastCompletionAddressFinder#find(AddressQuery)}}
	 */
	public AddressQueryResult find(AddressQuery query) {
		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}
		
		AddressQueryResult result = withLogging(query, fastCompletionModeParametersXmlString, InvokedMethod.FASTCOMPLETION);
		return result;
	}
}
