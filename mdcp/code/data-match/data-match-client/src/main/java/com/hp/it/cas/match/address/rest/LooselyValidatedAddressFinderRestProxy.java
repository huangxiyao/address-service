package com.hp.it.cas.match.address.rest;

import java.net.MalformedURLException;

import javax.validation.constraints.NotNull;

import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.LooselyValidatedAddressFinder;

/**
 * This class acts as a proxy to the backend address standardization interface. It directly mirrors the interface provided on the server side. This should make the network in
 * between transparent to the user of the client.
 * 
 * @see {@link com.hp.it.cas.match.address.LooselyValidatedAddressFinder}
 * @see {@link http://hpedia.hp.com/wiki/MDCP_Security}
 * 
 * @author paul.truax@hp.com
 * 
 */
public class LooselyValidatedAddressFinderRestProxy extends AbstractAddressFinderRestProxy implements LooselyValidatedAddressFinder {

	/**
	 * Construct an address finder rest proxy with a URL.
	 * 
	 * @param url
	 *            URL of the end point service
	 * @throws MalformedURLException
	 */
	public LooselyValidatedAddressFinderRestProxy(String url) {
		super(url);
	}

	/**
	 * @see {@link com.hp.it.cas.match.address.LooselyValidatedAddressFinder#find(AddressQuery)}
	 */
	public AddressQueryResult find(@NotNull AddressQuery query) {
		return processRequest(query, SERVICE_URL);
	}

}
