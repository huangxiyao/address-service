package com.hp.it.cas.match.address.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.LooselyValidatedAddressFinder;

/**
 * @see {@link com.hp.it.cas.match.address.LooselyValidatedAddressFinder}
 * 
 * @author paul.truax@hp.com
 * 
 */
public class LooselyValidatedAddressFinderImpl extends AbstractAddressFinder implements LooselyValidatedAddressFinder  {
	protected final Logger logger = LoggerFactory.getLogger(LooselyValidatedAddressFinderImpl.class);
	/**
	 * Construct an address finder.
	 */
	public LooselyValidatedAddressFinderImpl(boolean doValidation) {
		super(doValidation);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.LooselyValidatedAddressFinder#find(AddressQuery)}
	 */
	public AddressQueryResult find(AddressQuery query) {
		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}
		AddressQueryResult result = withLogging(query, wideOptimizationModeParametersXmlString, InvokedMethod.LOOSE);
		return result;
	}

}
