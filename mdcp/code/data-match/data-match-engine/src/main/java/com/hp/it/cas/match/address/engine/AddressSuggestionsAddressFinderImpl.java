package com.hp.it.cas.match.address.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressSuggestionsFinder;

/**
 * @see {@link com.hp.it.cas.match.address.AddressSuggestionsFinder}
 * 
 */
public class AddressSuggestionsAddressFinderImpl extends AbstractAddressFinder implements AddressSuggestionsFinder {

	protected final Logger logger = LoggerFactory.getLogger(AddressSuggestionsAddressFinderImpl.class);
	protected final Logger requestLogger = LoggerFactory.getLogger(AddressSuggestionsAddressFinderImpl.class.getName() + "RequestLogger");

	
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
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		requestLogger.debug("Address Query: {}", query);

		if (doValidation) {
			validate(query, new ConstraintViolationContext<AddressQuery>(query));
		}

		AddressQueryResult result = process(query, interactiveModeParametersXmlString);
		logger.debug("RETURN: {}", sw.toString());
		return result;
	}

}
