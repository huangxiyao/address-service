package com.hp.it.cas.match.address.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SampleWSClientTest {
	private static final QName SERVICE_NAME = new QName("http://localhost/", "CASServiceSoapImplService");

	@Test
	public void testPing() throws MalformedURLException {
		String endpointAddress = "http://it-services.corp.hp.com/legacy-match/address/v1";
		Service service = Service.create(SERVICE_NAME);

		CASServiceSoap client = service.getPort(CASServiceSoap.class);

		BindingProvider bp = (BindingProvider) client;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);

		Boolean val = client.pingServer();
		Assert.assertTrue(val);
	}
	
	@Test
	public void testStandardizer() throws MalformedURLException{
		
		Service service = Service.create(new URL("http://it-services.corp.hp.com/legacy-match/address/v1?wsdl"), SERVICE_NAME);
		String endpointAddress = "http://it-services.corp.hp.com/legacy-match/address/v1";
		//Service service = Service.create(SERVICE_NAME);

		CASServiceSoap client = service.getPort(CASServiceSoap.class);

		BindingProvider bp = (BindingProvider) client;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);

		//Boolean val = client.pingServer();
		ArrayOfString input = new ArrayOfString();
		input.getString().add("堂島 21ＮＴＴDATA堂島ビル");
		input.getString().add("");
		input.getString().add("");
		input.getString().add("大阪市北区");
		input.getString().add("大阪府");
		input.getString().add("");
		input.getString().add("530-0003");
		input.getString().add("JP");

		ArrayOfString output = client.standardizeHybridAddress(input);
		System.out.println(output.getString());
	}

}
