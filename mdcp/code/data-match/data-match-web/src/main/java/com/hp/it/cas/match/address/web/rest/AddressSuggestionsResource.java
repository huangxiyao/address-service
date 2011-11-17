package com.hp.it.cas.match.address.web.rest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Variant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.message.LocalizationContextHolder;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.foundation.message.MessageInterpolator;
import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.IAddressFinder;

@Path("addressSuggestions")
public class AddressSuggestionsResource extends AbstractAddressResource {
	private final Logger logger = LoggerFactory.getLogger(AddressSuggestionsResource.class);
	private final IAddressFinder finder;
	private MessageInterpolator messageInterpolator;
	private List<Variant> variants;
	
	public AddressSuggestionsResource(IAddressFinder finder, MessageInterpolator messageInterpolator, Locale[] locales){
		this.finder = finder;
		this.messageInterpolator = messageInterpolator;
		this.variants = Variant.languages(locales).add().build();
	}
	
	@GET
    @Produces({MediaType.APPLICATION_JSON})
	public Response handle(@Context Request request, @Context UriInfo uriInfo){
		logger.debug("ENTRY {}");
		Stopwatch sw = Stopwatch.start();
		MessageContext messageContext = new MessageContext();
		AddressQuery query = new AddressQuery();
		AddressQueryResult result = null;
		ConstraintViolationContext<AddressQuery> errors = new ConstraintViolationContext<AddressQuery>(query);
		configureLocalization(request, variants, messageInterpolator);
		Response response = null;
		try {
			bind(query, uriInfo.getQueryParameters(), errors);
			result = finder.findAddressSuggestions(query);
			response = Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=utf-8").entity(new AddressQueryResultJsonRepresentation(result, messageContext)).build();
		} catch (ConstraintViolationException e) {
			response = handle(e, messageContext);
		} catch (Exception e) {
			response = handle(e, messageContext);
		} finally {
			LocalizationContextHolder.clear();
		}
		logger.trace("RETURN {}", sw);
		return response;
	}
	
	@GET
    @Produces({MediaType.TEXT_HTML})
	@Path("documentation")
	public Response handleDocumentation(@Context ServletContext servletContext) throws MalformedURLException, URISyntaxException{
		logger.debug("ENTRY {}");
		return Response.ok().entity(servletContext.getResourceAsStream("/WEB-INF/addressSuggestionsResourceDocumentation.html")).build();
	}

}
