package com.hp.it.cas.match.address.engine;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.CertifiedAddressFinder;

/**
 * @see {@link com.hp.it.cas.match.address.CertifiedAddressFinder}
 * 
 * @author paul.truax@hp.com
 * 
 */
public class CertifiedAddressFinderImpl extends AbstractAddressFinder implements CertifiedAddressFinder  {

	/**
	 * Construct a certified address finder.
	 */
	public CertifiedAddressFinderImpl(boolean doValidation) {
		super(doValidation);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.CertifiedAddressFinder#find(AddressQuery)}
	 */
	public AddressQueryResult find(AddressQuery query) {
		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = withLogging(query, certifiedModeParametersXmlString, InvokedMethod.CERTIFIED);
		return result;
	}

}
