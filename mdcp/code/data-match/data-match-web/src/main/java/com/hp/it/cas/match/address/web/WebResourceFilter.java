package com.hp.it.cas.match.address.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.hp.it.cas.foundation.security.AccessDeniedException;

/**
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class WebResourceFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(WebResourceFilter.class);
	private final static String APPLICATION_PROCESS_UID = "X-HP-Application-Process-UID";

	private ExceptionHandler exceptionHandler;

	@Override
	public void destroy() {
		exceptionHandler = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String applicationProcessUid = httpRequest.getHeader(APPLICATION_PROCESS_UID);
		String requestUri = httpRequest.getRequestURI();
		
		try {
			if (webResourceIsAvailableWithoutApplicationProcessUid(requestUri)) {
				filterChain.doFilter(httpRequest, httpResponse);
				return;
			}
			
			checkApplicationProcessUid(applicationProcessUid);
			MDC.put("ap-uid", applicationProcessUid);
			filterChain.doFilter(httpRequest, httpResponse);
		} catch (Exception e) {
			handleException(e, httpResponse);
		} finally {
			MDC.remove("ap-uid");
		}
	}
	
	private boolean webResourceIsAvailableWithoutApplicationProcessUid(String requestUri) {
		String uriPatternRegEx = ".*/documentation";
		return requestUri.matches(uriPatternRegEx);	
	}

	private void checkApplicationProcessUid(String applicationProcessUid) throws Exception {
		// Reject app-uid with null
		if (applicationProcessUid == null || "".equals(applicationProcessUid.trim())) {
			String errorMessage = String.format("HTTP request comes without or with an empty HTTP header: %s. ", APPLICATION_PROCESS_UID);
			LOG.debug(errorMessage);
			throw new AccessDeniedException(errorMessage);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		exceptionHandler = new ServiceExceptionHandler();
	}
	
	private void handleException(Exception e, HttpServletResponse response) throws IOException, ServletException {
		exceptionHandler.handleException(e, response);
	}
}
