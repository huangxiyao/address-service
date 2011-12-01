package com.hp.it.cas.match.address.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
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
	protected final Logger logger = LoggerFactory.getLogger(ValidatedAddressFinderImpl.class);
	protected final Logger requestLogger = LoggerFactory.getLogger(ValidatedAddressFinderImpl.class.getName() + "RequestLogger");

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
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Address Query: {}", query);

		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = process(query, defaultParametersXmlString);
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

}
