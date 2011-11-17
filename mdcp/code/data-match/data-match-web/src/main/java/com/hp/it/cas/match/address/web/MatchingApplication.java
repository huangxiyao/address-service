package com.hp.it.cas.match.address.web;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.hp.it.cas.foundation.message.MessageSource;
import com.hp.it.cas.foundation.message.MessageSourceMessageInterpolator;
import com.hp.it.cas.foundation.message.ResourceBundleMessageSource;
import com.hp.it.cas.match.address.IAddressFinder;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.AddressFinder;
import com.hp.it.cas.match.address.web.rest.AddressFinderConfigurationResource;
import com.hp.it.cas.match.address.web.rest.AddressSuggestionsResource;
import com.hp.it.cas.match.address.web.rest.CertifiedValidatedAddressResource;
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
	private IAddressFinder finder = new AddressFinder(true);

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
		resources.add(new ValidatedAddressResource(finder, messageInterpolator, LOCALIZATIONS));
		resources.add(new CertifiedValidatedAddressResource(finder, messageInterpolator, LOCALIZATIONS));
		resources.add(new LooselyValidatedAddressResource(finder, messageInterpolator, LOCALIZATIONS));
		resources.add(new AddressSuggestionsResource(finder, messageInterpolator, LOCALIZATIONS));
		resources.add(new AddressFinderConfigurationResource(AddressDoctorEngine.INSTANCE.getConfiguration(), messageInterpolator, LOCALIZATIONS));
		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		return resources;
	}
}
