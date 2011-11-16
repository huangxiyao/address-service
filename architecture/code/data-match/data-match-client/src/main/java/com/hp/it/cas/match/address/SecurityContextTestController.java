package com.hp.it.cas.match.address;

import com.hp.it.cas.foundation.security.SecurityContextController;
import com.hp.it.cas.security.RichSecurityContext;

/**
 * A security context test controller to establish a security context for testing the webservice client interactively
 * 
 * @author paul.truax@hp.com
 * 
 */
public class SecurityContextTestController extends SecurityContextController<RichSecurityContext, ClientTestEnvironment> {

	@Override
	protected RichSecurityContext collect(ClientTestEnvironment environment) {
		return new RichSecurityContext(null, environment.getCredentials(), null, null);
	}

}
