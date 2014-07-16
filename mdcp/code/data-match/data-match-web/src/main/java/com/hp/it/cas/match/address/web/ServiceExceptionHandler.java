package com.hp.it.cas.match.address.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.security.AccessDeniedException;
import com.hp.it.cas.foundation.security.AuthenticationRequiredException;

/**
 * @author Slawek Zachcial (slawomir.zachcial@hp.com), yu-juan.zhang@hp.com
 */
class ServiceExceptionHandler implements ExceptionHandler
{
    private static final Logger LOG = LoggerFactory.getLogger(ServiceExceptionHandler.class);


    public void handleException(Exception e, HttpServletResponse response) throws IOException, ServletException
    {
        int statusCode = convert(e);
        if (statusCode != -1) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("A security exception occurred: %s. It was translated into HTTP status code: %s", e, statusCode), e);
            }
            response.sendError(statusCode);
            return;
        }

        if (e instanceof IOException) throw (IOException) e;
        if (e instanceof ServletException) throw (ServletException) e;
        if (e instanceof RuntimeException) throw (RuntimeException) e;

        throw new IllegalStateException("Don't know how to handle or propagate exception: " + e, e);
    }


    int convert(Throwable t)
    {
        while (t != null) {
            if (t instanceof AuthenticationRequiredException) return HttpServletResponse.SC_UNAUTHORIZED;
            if (t instanceof AccessDeniedException) return HttpServletResponse.SC_FORBIDDEN;

            t = t.getCause();
        }

        return -1;
    }

}
