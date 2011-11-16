package com.hp.it.cas.match.address.web.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import com.hp.it.cas.foundation.bind.FormBinder;
import com.hp.it.cas.foundation.message.LocalizationContext;
import com.hp.it.cas.foundation.message.LocalizationContextHolder;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.foundation.message.MessageInterpolator;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.foundation.validation.ConstraintViolationMessage;
import com.hp.it.cas.foundation.web.MessageContextJsonRepresentation;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryValidator;
import com.hp.it.cas.match.address.IAddressFinder;

public abstract class AbstractAddressResource {
	protected final AddressQueryValidator validator = new AddressQueryValidator();
	protected IAddressFinder finder;
	protected MessageInterpolator messageInterpolator;
	protected List<Variant> variants;
	
	Response handle(ConstraintViolationException exception, MessageContext messageContext){
		for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
			messageContext.addError(new ConstraintViolationMessage(violation));
		}
		return Response.status(Response.Status.BAD_REQUEST)
			.entity(new MessageContextJsonRepresentation(messageContext))
			.build();
	}
	
	Response handle(Exception exception, MessageContext messageContext){
		messageContext.buildMessageWithTemplate(exception.getMessage()).addError();
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
			.entity(new MessageContextJsonRepresentation(messageContext))
			.build();
	}
	
	void configureLocalization(Request request, List<Variant> variants, MessageInterpolator messageInterpolator){
		Variant variant = request.selectVariant(variants);
		Locale locale = variant == null ? null : variant.getLanguage();
		LocalizationContextHolder.setContext(new LocalizationContext(locale, messageInterpolator));
	}

    void bind(AddressQuery query, Map<String, List<String>> queryParms, ConstraintViolationContext<AddressQuery> errors) throws ConstraintViolationException{
		FormBinder binder = new FormBinder();
		binder.bind(query, queryParms, errors);
		if(!errors.getConstraintViolations().isEmpty()){
			 throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(errors.getConstraintViolations()));
		}
    }

}
