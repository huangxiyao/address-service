package com.hp.it.cas.match.address.soap.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import org.apache.log4j.Logger;
import com.hp.it.cas.match.address.client.support.AddressValidatedClientSupport;
import com.hp.it.cas.match.address.client.support.SoapInOutputSuit;
import com.hp.it.cas.match.address.soap.ArrayOfString;
import com.hp.it.cas.match.address.soap.CASServiceSoap;

/**
 * This class acts as a client to invoke AddressDoctor standardization soap
 * interface process the address defined by yourself.
 * 
 * @see {@link com.hp.it.cas.match.address.rest.CertifiedAddressFinderRestProxy}
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
@SuppressWarnings("deprecation")
public class SoapAddressAccessClient {

	/**
	 * Create the logger for log process status 
	 */
	static Logger logger = Logger.getLogger(AddressValidatedClientSupport.class.getName());
	
	/**
	 * Create qualified name as defined in the XML specifications for webservice.
	 */
	private static final QName SERVICE_NAME = new QName("http://localhost/", "CASServiceSoapImplService");
	
	/**
	 * Input SoapInOutputSuitID get the SoapInOutputSuit
	 * 
	 * @param SoapInOutputSuitID
	 *            To get the SoapInOutputSuit by SoapInOutputSuitID
	 * 
	 * @return 
	 * 			  The ArrayOfString output parsed by soap
	 */
	public static ArrayOfString executeSoapAccess(String SoapInOutputSuitID){
		Service service = null;
		CASServiceSoap client = null;
		SoapInOutputSuit soapInOutputSuit = null;
		try {
			service = Service.create(new URL(AddressValidatedClientSupport.getAddressDoctorURL(AddressValidatedClientSupport.SOAPSERVCE_WSDL_CODE)),SERVICE_NAME);
			client = service.getPort(CASServiceSoap.class);
			BindingProvider bp = (BindingProvider) client;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,AddressValidatedClientSupport.getAddressDoctorURL(AddressValidatedClientSupport.SOAPSERVCE_ACCESS_CODE));
			soapInOutputSuit = AddressValidatedClientSupport.getSoapInOutputSuitMap().get(SoapInOutputSuitID);
		} catch (MalformedURLException e) {
			logger.error(e.toString(),e);
		} catch (IOException e) {
			logger.error(e.toString(),e);
		}
		return client.standardizeHybridAddress(soapInOutputSuit.getInput());
	}
	
	/**
	 * Compare expected result with actual result by input SoapInOutputSuitID 
	 * 
	 * @param SoapInOutputSuitID
	 *            SoapInOutputSuitID to get SoapInOutputSuit.
	 * 
	 * @return 
	 * 
	 * 			  false:Actual result is not fit for Expect result, and pass the test 
	 * 			  true :Actual result is fit for Expect result, and fail the test 
	 */
	public static boolean compareExpectedWithActual(String SoapInOutputSuitID){

		String expectedOutput = null;
		ArrayOfString actualOutput = null;
		try {
			actualOutput = executeSoapAccess(SoapInOutputSuitID);
			SoapInOutputSuit soapInOutputSuit = AddressValidatedClientSupport.getSoapInOutputSuitMap().get(SoapInOutputSuitID);
			expectedOutput = AddressValidatedClientSupport.getResultStringByResultCode(soapInOutputSuit.getOutputCode());
			String actualStatements=  "The actual   ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+ " is "+String.valueOf(actualOutput.getString());
			String expectedStatements="The expected ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+ " is "+expectedOutput;		
			if (expectedOutput.equals(String.valueOf(actualOutput.getString()))) {
				logger.fatal(actualStatements);
				logger.fatal(expectedStatements);
				logger.fatal("The ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+" through soap way is right!");
				return true;
			} else {
				logger.fatal(actualStatements);
				logger.fatal(expectedStatements);
				logger.fatal("The ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+" through soap way is wrong!");
				return false;
			}
		} catch (IOException e) {
			logger.error(e.toString(),e);
			logger.fatal("The ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+" through soap way is wrong!");
			return false;
		}
		catch (Exception e) {
			logger.error(e.toString(),e);
			logger.fatal("The ArrayOfString output with SoapInOutputSuitID:" +SoapInOutputSuitID+" through soap way is wrong!");
			return false;
		}		
	}

}
