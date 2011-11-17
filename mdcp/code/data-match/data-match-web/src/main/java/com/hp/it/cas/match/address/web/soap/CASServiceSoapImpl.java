package com.hp.it.cas.match.address.web.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.validation.Verifier;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.legacy.LegacyAddressDoctorAddressAnalyzer;
import com.hp.it.cas.match.address.soap.ArrayOfString;
import com.hp.it.cas.match.address.soap.CASServiceSoap;
import com.hp.it.cas.match.address.soap.ObjectFactory;


/**
 * Legacy soap implementation of the CID CAS interface. This interface simulates the CID CAS address standardization
 * service. It is meant to support all legacy users of CID CAS between the time that CID CAS service is decommissioned
 * and when the new ReST-based service is made available.
 * 
 * @author paul.truax@hp.com
 * 
 */
@WebService(targetNamespace = "http://localhost/", serviceName = "CASServiceSoapImplService", portName="CASServiceSoapImplPort", name="CASServiceSoap")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED )
@XmlSeeAlso({
    ObjectFactory.class
})
public class CASServiceSoapImpl implements CASServiceSoap{
	private final int inputHybridAddressSizeMin = 8;
	private final int inputHybridAddressSizeMax = 13;
	private final int inputDiscreteAddressSizeMin = 13;
	private final int inputDiscreteAddressSizeMax = 15;
	private final LegacyAddressDoctorAddressAnalyzer analyzer;
	final Logger logger = LoggerFactory.getLogger(CASServiceSoapImpl.class);

	
	public CASServiceSoapImpl() {
		this.analyzer = new LegacyAddressDoctorAddressAnalyzer(AddressDoctorEngine.INSTANCE);
	}

	/**
	 * Not implemented. No Op.
	 */
	@Override
    @WebMethod(operationName = "ProcessAddress", action = "http://localhost/ProcessAddress")
    @WebResult(name = "ProcessAddressResult", targetNamespace = "http://localhost/")
    @RequestWrapper(localName = "ProcessAddress", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.ProcessAddress")
    @ResponseWrapper(localName = "ProcessAddressResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.ProcessAddressResponse")
	public String processAddress(byte[] buffer) {
		logger.warn("processAddress() invoked.  Method not implemented.");
		// no-op
		return null;
	}

	/**
	 * Not implemented. No Op.
	 */
	@Override
	@WebMethod(action = "http://localhost/testlog")
    @RequestWrapper(localName = "testlog", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.Testlog")
    @ResponseWrapper(localName = "testlogResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.TestlogResponse")
    public void testlog() {
		logger.warn("testlog() invoked.  Method not implemented.");
		// no-op

	}

	/**
	 * @see 
	 *      com.com.hp.it.cas.match.address.legacy.LegacyAddressDoctorAddressAnalyzer#analyzeDiscreteAddress(List<String>
	 *      )
	 */
	@Override
	@WebMethod(action = "http://localhost/standardizeDiscreteAddress")
	@WebResult(name = "standardizeDiscreteAddressResult", targetNamespace = "http://localhost/")
	@RequestWrapper(localName = "standardizeDiscreteAddress", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.StandardizeDiscreteAddress")
	@ResponseWrapper(localName = "standardizeDiscreteAddressResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.StandardizeDiscreteAddressResponse")
	public ArrayOfString standardizeDiscreteAddress(@WebParam(name = "DistInput", targetNamespace = "http://localhost/") ArrayOfString distInput) {
		logger.debug("ENTER");
		Stopwatch sw = Stopwatch.start();
		logger.trace("Input received: {}", distInput);
		new Verifier().isNotNull(distInput, "Input must not be null").throwIfError();
		new Verifier().isNotNull(distInput.getString(), "String array must not be null.").throwIfError();
		new Verifier()
				.isTrue((distInput.getString().size() == inputDiscreteAddressSizeMin || distInput.getString().size() == inputDiscreteAddressSizeMax),
						"String array must be either %s or %s elements long", inputDiscreteAddressSizeMin,
						inputDiscreteAddressSizeMax).throwIfError();
		List<String> outcome = analyzer.analyzeDiscreteAddress(distInput.getString());
		ArrayOfString response = new ArrayOfString();
		response.getString().addAll(outcome);
		logger.debug("RETURN: {}", sw.toString());
		return response;
	}

	/**
	 * @see com.com.hp.it.cas.match.address.legacy.LegacyAddressDoctorAddressAnalyzer#analyzeHybridAddress(List<String>)
	 */
	@Override
    @WebMethod(action = "http://localhost/standardizeHybridAddress")
    @WebResult(name = "standardizeHybridAddressResult", targetNamespace = "http://localhost/")
    @RequestWrapper(localName = "standardizeHybridAddress", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.StandardizeHybridAddress")
    @ResponseWrapper(localName = "standardizeHybridAddressResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.StandardizeHybridAddressResponse")
    public ArrayOfString standardizeHybridAddress(@WebParam(name = "HybdInput", targetNamespace = "http://localhost/") ArrayOfString hybdInput) {
		logger.debug("ENTER");
		Stopwatch sw = Stopwatch.start();
		logger.trace("Input received: {}", hybdInput);
		new Verifier().isNotNull(hybdInput, "Input must not be null").throwIfError();
		new Verifier().isNotNull(hybdInput.getString(), "String array must not be null.").throwIfError();
		new Verifier()
				.isTrue((hybdInput.getString().size() >= inputHybridAddressSizeMin && hybdInput.getString().size() <= inputHybridAddressSizeMax),
						"String array must be between %s and %s elements long", inputHybridAddressSizeMin,
						inputHybridAddressSizeMax).throwIfError();
		List<String> outcome = analyzer.analyzeHybridAddress(hybdInput.getString());
		ArrayOfString response = new ArrayOfString();
		response.getString().addAll(outcome);
		logger.debug("RETURN: {}", sw.toString());
		return response;
	}

	/**
	 * Not implemented. No Op.
	 */
	@Override
    @WebMethod(operationName = "Initialize", action = "http://localhost/Initialize")
    @RequestWrapper(localName = "Initialize", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.Initialize")
    @ResponseWrapper(localName = "InitializeResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.InitializeResponse")
    public void initialize() {
		logger.warn("initialize() invoked.  Method not implemented.");
		// no-op

	}

	/**
	 * Not implemented. No Op.
	 */
	@Override
    @WebMethod(operationName = "InitializeCAS", action = "http://localhost/InitializeCAS")
    @RequestWrapper(localName = "InitializeCAS", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.InitializeCAS")
    @ResponseWrapper(localName = "InitializeCASResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.InitializeCASResponse")
    public void initializeCAS() {
		logger.warn("initializeCAS() invoked.  Method not implemented.");
		// no-op

	}

	/**
	 * Tests availability of the server. Returns true if the server is available.
	 */
	@Override
    @WebMethod(operationName = "PingServer", action = "http://localhost/PingServer")
    @WebResult(name = "PingServerResult", targetNamespace = "http://localhost/")
    @RequestWrapper(localName = "PingServer", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.PingServer")
    @ResponseWrapper(localName = "PingServerResponse", targetNamespace = "http://localhost/", className = "com.hp.it.cas.data.match.legacy.PingServerResponse")
    public boolean pingServer() {
		logger.debug("ENTER");
		Stopwatch sw = Stopwatch.start();
		boolean returnValue = false;
		returnValue = analyzer.pingServer();
		logger.debug("RETURN: {}", sw.toString());
		return returnValue;
	}

}
