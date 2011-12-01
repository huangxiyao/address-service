package com.hp.it.cas.match.address.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
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

	protected final Logger logger = LoggerFactory.getLogger(CertifiedAddressFinderImpl.class);
	protected final Logger requestLogger = LoggerFactory.getLogger(CertifiedAddressFinderImpl.class.getName() + "RequestLogger");

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
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Address Query: {}", query);

		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = process(query, certifiedModeParametersXmlString);
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

}
