package com.hp.it.cas.match.address.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;

/**
 * Simple health checking resource. This resource will interact with address doctor in a very simple way to establish that a healthy connection between the application server and
 * the engine exists.
 * 
 * @author paul.truax@hp.com
 * 
 */
@Path("about")
public class AddressMatchingHealthResource {
	private final Logger logger = LoggerFactory.getLogger(AddressMatchingHealthResource.class);

	private final AddressDoctorEngine engine;

	public AddressMatchingHealthResource(AddressDoctorEngine engine) {
		this.engine = engine;
	}

	/**
	 * If address doctor is up and running,then this operation will return a 204 (no content) http status code
	 * 
	 * @return the response
	 */
	@GET
	@Path("health")
	public Response getAddressDoctorStatus() {
		logger.debug("ENTRY {}");
		Stopwatch sw = Stopwatch.start();
		Response response = null;
		try {
			logger.debug(String.format("AddressDoctor Version: %s", engine.getVersion()));
			response = Response.noContent().build();
		} catch (RuntimeException e) {
			response = Response.serverError().build();
		}
		logger.debug("RETURN: {}", sw.toString());
		return response;
	}
}
