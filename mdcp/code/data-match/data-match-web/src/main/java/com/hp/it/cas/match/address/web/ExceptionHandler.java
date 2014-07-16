package com.hp.it.cas.match.address.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Slawek Zachcial (slawomir.zachcial@hp.com), yu-juan.zhang@hp.com
 */
interface ExceptionHandler
{
    void handleException(Exception e, HttpServletResponse response) throws IOException, ServletException;
}
