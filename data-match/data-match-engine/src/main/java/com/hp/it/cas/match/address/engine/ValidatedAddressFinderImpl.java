package com.hp.it.cas.match.address.engine;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.ValidatedAddressFinder;

/**
 * @see {@link com.hp.it.cas.match.address.ValidatedAddressFinder}
 * 
 * @author paul.truax@hp.com
 * 
 */
public class ValidatedAddressFinderImpl extends AbstractAddressFinder implements ValidatedAddressFinder  {
	/**
	 * Construct an address finder.
	 */
	public ValidatedAddressFinderImpl(boolean doValidation) {
		super(doValidation);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.ValidatedAddressFinder#find(AddressQuery)}
	 */
	public AddressQueryResult find(AddressQuery query) {
		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}
		AddressQueryResult result = withLogging(query, defaultParametersXmlString, InvokedMethod.VALIDATED);
		return result;
	}

}
