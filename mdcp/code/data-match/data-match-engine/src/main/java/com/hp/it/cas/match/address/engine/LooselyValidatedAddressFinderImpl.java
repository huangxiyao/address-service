package com.hp.it.cas.match.address.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
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
	protected final Logger requestLogger = LoggerFactory.getLogger(LooselyValidatedAddressFinderImpl.class.getName() + "RequestLogger");

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
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Address Query: {}", query);

		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = process(query, wideOptimizationModeParametersXmlString);
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

}
