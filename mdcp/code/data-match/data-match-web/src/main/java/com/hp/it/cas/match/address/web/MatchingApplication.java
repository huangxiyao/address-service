package com.hp.it.cas.match.address.web;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.hp.it.cas.foundation.message.MessageSource;
import com.hp.it.cas.foundation.message.MessageSourceMessageInterpolator;
import com.hp.it.cas.foundation.message.ResourceBundleMessageSource;
import com.hp.it.cas.match.address.AddressSuggestionsFinder;
import com.hp.it.cas.match.address.CertifiedAddressFinder;
import com.hp.it.cas.match.address.FastCompletionAddressFinder;
import com.hp.it.cas.match.address.LooselyValidatedAddressFinder;
import com.hp.it.cas.match.address.ValidatedAddressFinder;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.AddressSuggestionsAddressFinderImpl;
import com.hp.it.cas.match.address.engine.CertifiedAddressFinderImpl;
import com.hp.it.cas.match.address.engine.FastCompletionAddressFinderImpl;
import com.hp.it.cas.match.address.engine.LooselyValidatedAddressFinderImpl;
import com.hp.it.cas.match.address.engine.ValidatedAddressFinderImpl;
import com.hp.it.cas.match.address.web.rest.AddressFinderConfigurationResource;
import com.hp.it.cas.match.address.web.rest.AddressMatchingHealthResource;
import com.hp.it.cas.match.address.web.rest.AddressSuggestionsResource;
import com.hp.it.cas.match.address.web.rest.CertifiedValidatedAddressResource;
import com.hp.it.cas.match.address.web.rest.FastCompletionAddressResource;
import com.hp.it.cas.match.address.web.rest.LooselyValidatedAddressResource;
import com.hp.it.cas.match.address.web.rest.ValidatedAddressResource;

/**
 * Configures the matching engine rest services.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class MatchingApplication extends Application {
	private final String[] MESSAGES = { "com.hp.it.cas.match.address.messages" };
	private final Locale[] LOCALIZATIONS = { Locale.ENGLISH };
	private final Set<Object> resources;
	MessageSourceMessageInterpolator messageInterpolator;
	private ValidatedAddressFinder validatedFinder = new ValidatedAddressFinderImpl(true);
	private CertifiedAddressFinder certifiedFinder = new CertifiedAddressFinderImpl(true);
	private LooselyValidatedAddressFinder looselyValidatedFinder = new LooselyValidatedAddressFinderImpl(true);
	private AddressSuggestionsFinder addressSuggestions = new AddressSuggestionsAddressFinderImpl(true);
	private FastCompletionAddressFinder fastCompletionValidatedFinder = new FastCompletionAddressFinderImpl(true);
	
	/**
	 * Instantiate a matching application
	 * 
	 * @throws Exception
	 */
	public MatchingApplication() throws Exception {
		MessageSource messageSource = new ResourceBundleMessageSource(MESSAGES);
		messageInterpolator = new MessageSourceMessageInterpolator(messageSource);
		resources = createResources();
	}

	private Set<Object> createResources() {
		Set<Object> resources = new HashSet<Object>();
		resources.add(new ValidatedAddressResource(validatedFinder, messageInterpolator, LOCALIZATIONS));
		resources.add(new CertifiedValidatedAddressResource(certifiedFinder, messageInterpolator, LOCALIZATIONS));
		resources.add(new LooselyValidatedAddressResource(looselyValidatedFinder, messageInterpolator, LOCALIZATIONS));
		resources.add(new AddressSuggestionsResource(addressSuggestions, messageInterpolator, LOCALIZATIONS));
		resources.add(new FastCompletionAddressResource(fastCompletionValidatedFinder, messageInterpolator, LOCALIZATIONS));
		resources.add(new AddressFinderConfigurationResource(AddressDoctorEngine.INSTANCE.getConfiguration(), messageInterpolator, LOCALIZATIONS));
		resources.add(new AddressMatchingHealthResource(AddressDoctorEngine.INSTANCE));
		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		return resources;
	}
}
