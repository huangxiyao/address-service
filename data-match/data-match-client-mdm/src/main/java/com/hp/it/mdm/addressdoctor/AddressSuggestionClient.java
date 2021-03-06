package com.hp.it.mdm.addressdoctor;

import java.net.URL;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.ClientTestEnvironment;
import com.hp.it.cas.match.address.SecurityContextTestController;
import com.hp.it.cas.match.address.rest.AddressSuggestionsAddressFinderRestProxy;
import com.hp.it.mdm.addressdoctor.client.AddressDoctorClient;
import com.siperian.common.util.TypedProps;

public class AddressSuggestionClient extends AddressDoctorClient {

	public static final Logger log = Logger
			.getLogger(AddressSuggestionClient.class);

	// list of function names
	protected static String fName = "Address Suggestion";

	protected static String fDesc = "Address Suggestion Function";

	private static URL configFile = AddressSuggestionClient.class
			.getResource("/addressDoctor.properties");

	Properties cleanseProps = new Properties();
	boolean allGood = true;

	private static String[] fInputName = AddressDoctorInputs.fInputName;

	private static String[] fInputType = AddressDoctorInputs.fInputType;

	private static String[] fInputDesc = AddressDoctorInputs.fInputName;

	private static String[] fOutputName = AddressDoctorOutputs.fOutputName;

	private static String[] fOutputType = AddressDoctorOutputs.fOutputType;

	private static String[] fOutputDesc = AddressDoctorOutputs.fOutputName;

	/* create a new client based in information from property file */
	public AddressSuggestionClient(TypedProps props) {

		setFunctionText();
	}

	/* create a new client by duplicating an existing one */
	public AddressSuggestionClient(AddressSuggestionClient client) {

		setFunctionText();
	}

	private void setFunctionText() {
		functionName = fName;
		functionDesc = fDesc;
		functionInputName = fInputName;
		functionInputType = fInputType;
		functionInputDesc = fInputDesc;
		functionOutputName = fOutputName;
		functionOutputType = fOutputType;
		functionOutputDesc = fOutputDesc;
	}

	public void init() {
		try {

			/* any initialization for the address doctor client would go here */

		} catch (Exception e) {
			throw new RuntimeException("Could not initalize Adapter");
		}
	}

	public void cleanse(Map context, Map input, Map output) {
		/*
		 * The real work of the address doctor goes here
		 */
		SecurityContextTestController securityController = new SecurityContextTestController();
		securityController.collectAndSetupSecurityContext(testEnvironment());
		/* get properties configuration */
		cleanseProps = AddressDoctorInputs.loadPropertyFile(configFile);
		if (!allGood)
			return;
		String server_url = cleanseProps
				.getProperty("AddressSuggestionsAddressFinderRestProxy_URL");
		AddressSuggestionsAddressFinderRestProxy proxy = new AddressSuggestionsAddressFinderRestProxy(
				server_url);

		AddressQueryResult result = proxy.suggest(new AddressDoctorQuery()
				.addressQuery(input));

		// output.put(ADDRESSRES,
		// AddressDoctorOutputs.populateAddressDoctorResultToString(result));
		output = AddressDoctorOutputs.populateRsltMap(result, output);

	}

	private ClientTestEnvironment testEnvironment() {
		return new ClientTestEnvironment("w-mdcp:prd-http", null, null);
	}

	public Object clone() {
		return new AddressSuggestionClient(this);
	}

	public void disconnect() {
		/*
		 * Any things that need to be done to free up any resources need to be
		 * done here
		 */
	}

}
