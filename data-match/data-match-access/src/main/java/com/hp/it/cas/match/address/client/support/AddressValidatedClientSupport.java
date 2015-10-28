package com.hp.it.cas.match.address.client.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;
import com.hp.it.cas.match.address.soap.ArrayOfString;

/**
 * This class provides the static methods to support both rest and soap access.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class AddressValidatedClientSupport {

	/**
	 * This constant value indicate path position of
	 * addressDoctorUrlProperty.properties containing the all urls for visiting
	 * data-match-web.
	 */
	private final static String ADDRESSDOCTOR_CLIENT_URL_PROPERTY_PATH = AddressValidatedClientSupport.class
			.getResource("/addressDoctorUrlProperty.properties").getPath();

	/**
	 * This constant value indicate path of the address result string property
	 * for both rest and soap access.
	 */
	private final static String ADDRESSRESULT_PROPERTY_PATH = AddressValidatedClientSupport.class.getResource(
			"/addressResultProperty.properties").getPath();

	/**
	 * This constant value indicate path of the log4j
	 */
	private final static String LOG_FOR_CLIENT_PROPERTY_PATH = AddressValidatedClientSupport.class.getResource(
			"/log4j.properties").getPath();

	/**
	 * This constant value indicate path of restQueryInputProperties.properties
	 */
	private final static String REST_QUERY_INPUT_PATH = AddressValidatedClientSupport.class.getResource(
			"/restQueryInputProperties.properties").getPath();

	/**
	 * This constant value indicate path of soapQueryInputProperties.properties
	 */
	private final static String SOAP_QUERY_INPUT_PATH = AddressValidatedClientSupport.class.getResource(
			"/soapQueryInputProperties.properties").getPath();

	/**
	 * This value indicate whether user use this client by inputing address,
	 * "true" means user use this client by inputing address directly,"false"
	 * user don't use this client by inputing address
	 */
	public static boolean DIRECT_URL_ACCESS_FLAG = false;

	/**
	 * This value indicate the url when user use this client by inputing address
	 * directly
	 */
	public static String DIRECT_ACCESS_URL = "";

	/**
	 * This constant value indicate the Representative value of validatedAddress
	 * rest access to avoid hard coding
	 */
	public final static String VALIDATEDADDRESS_ACCESS_URL_CODE = "ValidatedAddress_url";

	/**
	 * This constant value indicate the Representative value of
	 * AddressSuggestions rest access to avoid hard coding
	 */
	public final static String ADDRESSSUGGESTIONS_ACCESS_URL_CODE = "AddressSuggestions_url";

	/**
	 * This constant value indicate the Representative value of CertifiedAddress
	 * rest access to avoid hard coding
	 */
	public final static String CERTIFIEDADDRESS_ACCESS_URL_CODE = "CertifiedAddress_url";

	/**
	 * This constant value indicate the Representative value of LooselyValidated
	 * rest access to avoid hard coding
	 */
	public final static String LOOSEVALIDATED_ACCESS_URL_CODE = "LooselyValidated_url";

	/**
	 * This constant value indicate the Representative value of
	 * FastCompletionAddress rest access
	 */
	public final static String FASECOMPLETION_ADDRESS_URL_CODE = "FastCompletionAddress_url";

	/**
	 * This constant value indicate the Representative value of Soap Service
	 * WSDL url to avoid hard coding.
	 */
	public final static String SOAPSERVCE_WSDL_CODE = "SoapServiceWSDL_url";

	/**
	 * This constant value indicate the Representative value of soap access to
	 * avoid hard coding.
	 */
	public final static String SOAPSERVCE_ACCESS_CODE = "SoapService_url";

	/**
	 * This value indicate map collect the all AddressQueryResultSuit assembled
	 * in getAddressQueryResultSuit(), the key is AddressQueryResultSuitID, the
	 * value is AddressQueryResultSuit
	 */
	private static Map<String, AddressQueryResultSuit> addressQueryResultSuitMap = new HashMap<String, AddressQueryResultSuit>();

	/**
	 * This value indicate map collect the all SoapInOutputSuit assembled in
	 * getSoapInOutputSuitMap, the key is SoapInOutputSuitID, the value is
	 * SoapInOutputSuit
	 */
	private static Map<String, SoapInOutputSuit> soapInOutputSuitMap = new HashMap<String, SoapInOutputSuit>();

	/**
	 * Create the logger instance for logging when the error happens
	 */
	static Logger logger = Logger.getLogger(AddressValidatedClientSupport.class.getName());

	/**
	 * To load the log4j.properties for logging.
	 */
	static {
		PropertyConfigurator.configure(LOG_FOR_CLIENT_PROPERTY_PATH);
	}

	/**
	 * Get the result string from addressResultProperty.properties by the
	 * representative value of the result
	 * 
	 * @param resultCode
	 *            Representative value of the result that is match to
	 *            addressResultProperty.properties
	 * @return The result string from addressDoctorUrlProperty.properties
	 */
	public static String getResultStringByResultCode(String resultCode) throws IOException {
		Properties props = AddressValidatedClientSupport.loadPropertyFile(ADDRESSRESULT_PROPERTY_PATH);
		return new String(props.getProperty(resultCode).getBytes("iso-8859-1"), "utf-8");
	}

	/**
	 * Get the url from addressDoctorUrlProperty.properties by the
	 * representative value of the access way
	 * 
	 * @param accessWay
	 *            Representative value of the access way that is fixed according
	 *            to the property file
	 * @return The url from addressDoctorUrlProperty.properties
	 */
	public static String getAddressDoctorURL(String accessWay) throws IOException {
		Properties props = AddressValidatedClientSupport.loadPropertyFile(ADDRESSDOCTOR_CLIENT_URL_PROPERTY_PATH);
		return props.getProperty(accessWay);
	}

	/**
	 * Get the rest Properties HashTable from
	 * restQueryInputProperties.properties
	 * 
	 * @return The Properties from addressQuery input
	 */
	public static Properties getRestQueryInputProperties() throws IOException {
		Properties props = AddressValidatedClientSupport.loadPropertyFile(REST_QUERY_INPUT_PATH);
		return props;
	}

	/**
	 * Get the soap Properties HashTable from
	 * soapQueryInputProperties.properties
	 * 
	 * @return The Properties from ArrayOfString input
	 */
	public static Properties getSoapQueryInputProperties() throws IOException {
		Properties props = AddressValidatedClientSupport.loadPropertyFile(SOAP_QUERY_INPUT_PATH);
		return props;
	}

	/**
	 * Get the Properties instance from addressQueryInput.properties by the path
	 * value.
	 * 
	 * @param path
	 *            The path of the file.
	 * 
	 * @return The url from addressDoctorUrlProperty.properties
	 */
	private static Properties loadPropertyFile(String path) {

		Properties props = new java.util.Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			props.load(fis);
		} catch (FileNotFoundException e) {
			logger.error(e.toString(), e);
		} catch (IOException e) {
			logger.error(e.toString(), e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				logger.error(e.toString(), e);
			}
		}
		return props;
	}

	/**
	 * Before the address processed with AddressDoctor, every request shall be
	 * checked by CAS security module, this method indicates that it initialize
	 * CAS security context preparing for check.
	 * 
	 * @see {@link com.hp.it.cas.match.address.rest.ExampleAddressFinderRestProxyTest}
	 * 
	 */
	public static void buildSecurityContext() {
		try {
			SecurityContextTestController securityController = new SecurityContextTestController();
			securityController.collectAndSetupSecurityContext(new ClientTestEnvironment("w-mdcp:prd-http", null, null));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	/**
	 * Assembling the ArrayOfString to complete the address input for the soap
	 * access. The meaning of every element reference to
	 * LegacyAddressDoctorAddressAnalyzer.mapDiscreteInputToAddressObject() or
	 * LegacyAddressDoctorAddressAnalyzer.mapHybridInputToAddressObject().
	 * 
	 * @see {@link com.hp.it.cas.match.address.engine.legacy.LegacyAddressDoctorAddressAnalyzer}
	 * @return map collect the all SoapInOutputSuit assembled in
	 *         getSoapInOutputSuitMap, the key is SoapInOutputSuitID, the value
	 *         is SoapInOutputSuit
	 */
	public static Map<String, SoapInOutputSuit> getSoapInOutputSuitMap() {

		// Avoid repeating loading the query data
		if (soapInOutputSuitMap.isEmpty()) {

			Hashtable hashtable = null;
			try {
				hashtable = getSoapQueryInputProperties();
				Iterator iterator = hashtable.entrySet().iterator();
				ArrayOfString as = null;

				while (iterator.hasNext()) {
					as = new ArrayOfString();
					String resultcode = new String();
					Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
					String str = new String();
					str = entry.getValue();
					if (str.isEmpty()) {
						continue;
					}
					String[] array = new String[10];
					array = str.split("\\|");
					for (int i = 0; i < array.length; i++) {

						if (i == array.length - 1) {
							resultcode = array[i];
							if (resultcode.isEmpty()) {
								break;
							}
						} else {
							as.getString().add(array[i]);
						}
					}
					assembleSoapInOutputSuitToMap(as, entry.getKey(), resultcode);
				}
			} catch (Exception e) {
				logger.error(e.toString(), e);
			}
		}
		return soapInOutputSuitMap;
	}

	/**
	 * Assembling the SoapInOutputSuit and put the new SoapInOutputSuit instance
	 * to SoapInOutputSuitMap
	 * 
	 * @param soapInOutputSuitMap
	 *            This map is to collect the SoapInOutputSuit had been assembled
	 * 
	 * @param as
	 *            The ArrayOfString input had been assembled
	 * 
	 * @param soapInOutputSuitID
	 *            The ID to identify the every soapInOutputSuit
	 * 
	 * @param outputCode
	 *            The ArrayOfString output code, That represent the string value
	 *            for soap output
	 */
	private static void assembleSoapInOutputSuitToMap(

	ArrayOfString as, String soapInOutputSuitID, String outputCode) {
		SoapInOutputSuit soapInOutputSuit = new SoapInOutputSuit();
		soapInOutputSuit.setSioID(soapInOutputSuitID);
		soapInOutputSuit.setInput(as);
		soapInOutputSuit.setOutputCode(outputCode);
		soapInOutputSuitMap.put(soapInOutputSuit.getSioID(), soapInOutputSuit);
	}

	/**
	 * Assembling the AddressQueryResultSuit to complete the address query input
	 * for the rest access.
	 * 
	 * @return map collect the all AddressQueryResultSuit assembled in
	 *         getAddressQueryResultSuit(), the key is AddressQueryResultSuitID,
	 *         the value is AddressQueryResultSuit
	 */
	public static Map<String, AddressQueryResultSuit> getAddressQueryResultSuitMap() {

		// Avoid repeating loading the query data
		if (addressQueryResultSuitMap.isEmpty()) {

			Hashtable hashtable = null;
			try {
				hashtable = getRestQueryInputProperties();

				Iterator iterator = hashtable.entrySet().iterator();
				AddressQuery query = null;
				while (iterator.hasNext()) {
					query = new AddressQuery();
					Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
					StringTokenizer element = new StringTokenizer(entry.getValue(), "|");
					Map<String, String> map = new HashMap<String, String>();
					while (element.hasMoreTokens()) {
						StringTokenizer value = new StringTokenizer(element.nextToken(), "=");
						String attributeName = value.nextToken().toString();
						String attributeValue = value.nextElement().toString();
						AddressInputParse.assembleAddressQueryByEveryAttribute(query, attributeName, attributeValue,
								map);
					}
					assembleAddessQueryResultSuitToMap(query, entry.getKey(), map.get("ValidatedAddress_Result"),
							map.get("CertifiedAddress_Result"), map.get("LooselyValidated_Result"),
							map.get("AddressSuggestions_Result"), map.get("FastCompletionAddress_Result"));
				}
			} catch (Exception e) {
				logger.error(e.toString(), e);
			}
		}

		return addressQueryResultSuitMap;
	}

	/**
	 * Assembling the AddessQueryResultSuit and put the new
	 * AddessQueryResultSuit instance to addressQueryResultSuitMap
	 * 
	 * @param query
	 *            The AddessQuery input instance had been assembled
	 * 
	 * @param addressQueryResultSuitID
	 *            The ID to identify the every AddressQueryResultSuit
	 * 
	 * @param validatedAddress_Result_Code
	 *            The ID for result string for validatedAddress access when the
	 *            above addressQueryResultSuit input
	 * 
	 * @param certifiedAddress_Result_Code
	 *            The ID for result string for certifiedAddress access when the
	 *            above addressQueryResultSuit input
	 * 
	 * @param looselyValidated_Result_Code
	 *            The ID for result string for looselyValidated access when the
	 *            above addressQueryResultSuit input
	 * 
	 * @param addressSuggestions_Result_Code
	 *            The ID for result string for addressSuggestions access when
	 *            the above addressQueryResultSuit input
	 * 
	 * @param fastCompeltionAddress_Result_Code
	 *            The ID for result string for fastCompeltionAddress access when
	 *            the above addressQueryResultSuit input
	 * 
	 */
	private static void assembleAddessQueryResultSuitToMap(AddressQuery query, String addressQueryResultSuitID,
			String validatedAddress_Result_Code, String certifiedAddress_Result_Code,
			String looselyValidated_Result_Code, String addressSuggestions_Result_Code,
			String fastCompeltionAddress_Result_Code) {
		AddressQueryResultSuit addressQueryResultSuit = new AddressQueryResultSuit();
		addressQueryResultSuit.setAddressQuery(query);
		addressQueryResultSuit.setAqsID(addressQueryResultSuitID);
		addressQueryResultSuit.setValidatedAddressResultCode(validatedAddress_Result_Code);
		addressQueryResultSuit.setCertifiedAddressResultCode(certifiedAddress_Result_Code);
		addressQueryResultSuit.setLooselyValidatedResultCode(looselyValidated_Result_Code);
		addressQueryResultSuit.setAddressSuggestionsResultCode(addressSuggestions_Result_Code);
		addressQueryResultSuit.setFastCompletionAddressResultCode(fastCompeltionAddress_Result_Code);
		addressQueryResultSuitMap.put(addressQueryResultSuit.getAqsID(), addressQueryResultSuit);
	}
}
