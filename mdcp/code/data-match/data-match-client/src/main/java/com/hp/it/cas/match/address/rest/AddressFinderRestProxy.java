package com.hp.it.cas.match.address.rest;

import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.hp.it.cas.foundation.json.JsonParser;
import com.hp.it.cas.foundation.json.JsonReader;
import com.hp.it.cas.foundation.message.LocalizationContext;
import com.hp.it.cas.foundation.message.LocalizationContextHolder;
import com.hp.it.cas.foundation.message.Message;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.foundation.message.MessageInterpolator;
import com.hp.it.cas.foundation.message.MessageSource;
import com.hp.it.cas.foundation.message.MessageSourceMessageInterpolator;
import com.hp.it.cas.foundation.message.ResourceBundleMessageSource;
import com.hp.it.cas.foundation.serial.StandardResponse;
import com.hp.it.cas.foundation.serial.StandardResponseJsonReader;
import com.hp.it.cas.foundation.validation.ConstraintViolationContext;
import com.hp.it.cas.foundation.validation.Verifier;
import com.hp.it.cas.foundation.web.JsonHttpClient;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;
import com.hp.it.cas.match.address.AddressQueryValidator;
import com.hp.it.cas.match.address.IAddressFinder;

/**
 * This class acts as a proxy to the backend address standardization interface. It directly mirrors the interface provided on the server side. This should make the network in
 * between transparent to the user of the client.
 * 
 * @see {@link http://hpedia.hp.com/wiki/MDCP_Security} for detailed instructions on how to configure security prior to using this proxy
 * 
 * @author paul.truax@hp.com
 * 
 */
public class AddressFinderRestProxy extends StandardResponseJsonReader<AddressQueryResult> implements IAddressFinder {
	private final MessageInterpolator messageInterpolator;
	private final String[] MESSAGES = { "com.hp.it.cas.match.address.messages" };
	private final AddressQueryValidator validator = new AddressQueryValidator();
	private final URL VALIDATED_ADDRESS_SERVICE_URL;
	private final URL CERTIFIED_ADDRESS_SERVICE_URL;
	private final URL WIDE_OPTIMIZATION_SERVICE_URL;
	private final URL ADDRESS_SUGGESTIONS_SERVICE_URL;

	/**
	 * Construct an address finder rest proxy with a URL.
	 * 
	 * @param urlPrefix
	 *            URL of the end point service
	 * @throws MalformedURLException
	 */
	public AddressFinderRestProxy(String urlPrefix) {
		try {
			VALIDATED_ADDRESS_SERVICE_URL = new URL(String.format("%s/%s", urlPrefix, "validatedAddress"));
			CERTIFIED_ADDRESS_SERVICE_URL = new URL(String.format("%s/%s", urlPrefix, "certifiedAddress"));
			WIDE_OPTIMIZATION_SERVICE_URL = new URL(String.format("%s/%s", urlPrefix, "looselyValidatedAddress"));
			ADDRESS_SUGGESTIONS_SERVICE_URL = new URL(String.format("%s/%s", urlPrefix, "addressSuggestions"));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
		this.messageInterpolator = createMessageInterpolator();
		LocalizationContextHolder.setContext(new LocalizationContext(Locale.ENGLISH, messageInterpolator));
	}

	/**
	 * @see com.hp.it.cas.match.address.IAddressFinder#findValidatedAddress(AddressQuery)
	 */
	public AddressQueryResult findValidatedAddress(@NotNull AddressQuery query) {
		return processRequest(query, VALIDATED_ADDRESS_SERVICE_URL);
	}

	/**
	 * @see com.hp.it.cas.match.address.IAddressFinder#findCertifiedAddress(AddressQuery)
	 */
	public AddressQueryResult findCertifiedAddress(@NotNull AddressQuery query) {
		return processRequest(query, CERTIFIED_ADDRESS_SERVICE_URL);
	}

	/**
	 * @see com.hp.it.cas.match.address.IAddressFinder#findValidatedAddressWithWideOptimization(AddressQuery)
	 */
	public AddressQueryResult findValidatedAddressWithWideOptimization(@NotNull AddressQuery query) {
		return processRequest(query, WIDE_OPTIMIZATION_SERVICE_URL);
	}

	/**
	 * @see com.hp.it.cas.match.address.IAddressFinder#findAddressSuggestions(AddressQuery)
	 */
	public AddressQueryResult findAddressSuggestions(@NotNull AddressQuery query) {
		return processRequest(query, ADDRESS_SUGGESTIONS_SERVICE_URL);
	}

	private Map<String, List<String>> parameterize(AddressQuery query) {
		Map<String, List<String>> parameters = new HashMap<String, List<String>>();
		add(parameters, "addressComplete", query.getAddressComplete());
		add(parameters, "building1", query.getBuilding1());
		add(parameters, "building2", query.getBuilding2());
		add(parameters, "building3", query.getBuilding3());
		add(parameters, "building4", query.getBuilding4());
		add(parameters, "building5", query.getBuilding5());
		add(parameters, "building6", query.getBuilding6());
		add(parameters, "contact1", query.getContact1());
		add(parameters, "contact2", query.getContact2());
		add(parameters, "contact3", query.getContact3());
		add(parameters, "country1", query.getCountry1());
		add(parameters, "country2", query.getCountry2());
		add(parameters, "country3", query.getCountry3());
		add(parameters, "countrySpecificLocalityLine1", query.getCountrySpecificLocalityLine1());
		add(parameters, "countrySpecificLocalityLine2", query.getCountrySpecificLocalityLine2());
		add(parameters, "countrySpecificLocalityLine3", query.getCountrySpecificLocalityLine3());
		add(parameters, "countrySpecificLocalityLine4", query.getCountrySpecificLocalityLine4());
		add(parameters, "countrySpecificLocalityLine5", query.getCountrySpecificLocalityLine5());
		add(parameters, "countrySpecificLocalityLine6", query.getCountrySpecificLocalityLine6());
		add(parameters, "deliveryAddressLine1", query.getDeliveryAddressLine1());
		add(parameters, "deliveryAddressLine2", query.getDeliveryAddressLine2());
		add(parameters, "deliveryAddressLine3", query.getDeliveryAddressLine3());
		add(parameters, "deliveryAddressLine4", query.getDeliveryAddressLine4());
		add(parameters, "deliveryAddressLine5", query.getDeliveryAddressLine5());
		add(parameters, "deliveryAddressLine6", query.getDeliveryAddressLine6());
		add(parameters, "deliveryService1", query.getDeliveryService1());
		add(parameters, "deliveryService2", query.getDeliveryService2());
		add(parameters, "deliveryService3", query.getDeliveryService3());
		add(parameters, "deliveryService4", query.getDeliveryService4());
		add(parameters, "deliveryService5", query.getDeliveryService5());
		add(parameters, "deliveryService6", query.getDeliveryService6());
		add(parameters, "formattedAddressLine1", query.getFormattedAddressLine1());
		add(parameters, "formattedAddressLine2", query.getFormattedAddressLine2());
		add(parameters, "formattedAddressLine3", query.getFormattedAddressLine3());
		add(parameters, "formattedAddressLine4", query.getFormattedAddressLine4());
		add(parameters, "formattedAddressLine5", query.getFormattedAddressLine5());
		add(parameters, "formattedAddressLine6", query.getFormattedAddressLine6());
		add(parameters, "formattedAddressLine7", query.getFormattedAddressLine7());
		add(parameters, "formattedAddressLine8", query.getFormattedAddressLine8());
		add(parameters, "formattedAddressLine9", query.getFormattedAddressLine9());
		add(parameters, "formattedAddressLine10", query.getFormattedAddressLine10());
		add(parameters, "formattedAddressLine11", query.getFormattedAddressLine11());
		add(parameters, "formattedAddressLine12", query.getFormattedAddressLine12());
		add(parameters, "formattedAddressLine13", query.getFormattedAddressLine13());
		add(parameters, "formattedAddressLine14", query.getFormattedAddressLine14());
		add(parameters, "formattedAddressLine15", query.getFormattedAddressLine15());
		add(parameters, "formattedAddressLine16", query.getFormattedAddressLine16());
		add(parameters, "formattedAddressLine17", query.getFormattedAddressLine17());
		add(parameters, "formattedAddressLine18", query.getFormattedAddressLine18());
		add(parameters, "formattedAddressLine19", query.getFormattedAddressLine19());
		add(parameters, "key1", query.getKey1());
		add(parameters, "key2", query.getKey2());
		add(parameters, "key3", query.getKey3());
		add(parameters, "locality1", query.getLocality1());
		add(parameters, "locality2", query.getLocality2());
		add(parameters, "locality3", query.getLocality3());
		add(parameters, "locality4", query.getLocality4());
		add(parameters, "locality5", query.getLocality5());
		add(parameters, "locality6", query.getLocality6());
		add(parameters, "number1", query.getNumber1());
		add(parameters, "number2", query.getNumber2());
		add(parameters, "number3", query.getNumber3());
		add(parameters, "number4", query.getNumber4());
		add(parameters, "number5", query.getNumber5());
		add(parameters, "number6", query.getNumber6());
		add(parameters, "organization1", query.getOrganization1());
		add(parameters, "organization2", query.getOrganization2());
		add(parameters, "organization3", query.getOrganization3());
		add(parameters, "postalCode1", query.getPostalCode1());
		add(parameters, "postalCode2", query.getPostalCode2());
		add(parameters, "postalCode3", query.getPostalCode3());
		add(parameters, "province1", query.getProvince1());
		add(parameters, "province2", query.getProvince2());
		add(parameters, "province3", query.getProvince3());
		add(parameters, "province4", query.getProvince4());
		add(parameters, "province5", query.getProvince5());
		add(parameters, "province6", query.getProvince6());
		add(parameters, "recipientLine1", query.getRecipientLine1());
		add(parameters, "recipientLine2", query.getRecipientLine2());
		add(parameters, "recipientLine3", query.getRecipientLine3());
		add(parameters, "residue1", query.getResidue1());
		add(parameters, "residue2", query.getResidue2());
		add(parameters, "residue3", query.getResidue3());
		add(parameters, "residue4", query.getResidue4());
		add(parameters, "residue5", query.getResidue5());
		add(parameters, "residue6", query.getResidue6());
		add(parameters, "street1", query.getStreet1());
		add(parameters, "street2", query.getStreet2());
		add(parameters, "street3", query.getStreet3());
		add(parameters, "street4", query.getStreet4());
		add(parameters, "street5", query.getStreet5());
		add(parameters, "street6", query.getStreet6());
		add(parameters, "subBuilding1", query.getSubBuilding1());
		add(parameters, "subBuilding2", query.getSubBuilding2());
		add(parameters, "subBuilding3", query.getSubBuilding3());
		add(parameters, "subBuilding4", query.getSubBuilding4());
		add(parameters, "subBuilding5", query.getSubBuilding5());
		add(parameters, "subBuilding6", query.getSubBuilding6());
		return parameters;
	}

	private void add(Map<String, List<String>> parameters, String name, String value) {
		if (!(value == null || value.trim().equals(""))) {
			List<String> item = new ArrayList<String>();
			item.add(value);
			parameters.put(name, item);
		}
	}

	@SuppressWarnings("unchecked")
	public AddressQueryResult readContent(JsonParser jsonParser) throws IOException {
		Object content = JsonReader.read(jsonParser);
		Map<String, Object> jsonMap = null;
		if (content != null) {
			try {
				jsonMap = (Map<String, Object>) content;
			} catch (ClassCastException classCastException) {
				throw new IllegalStateException(String.format("Expecting result but got %s", content));
			}
		}
		return mapObject(jsonMap);
	}

	@SuppressWarnings("unchecked")
	private AddressQueryResult mapObject(Map<String, Object> jsonObject) {
		AddressQueryResult result = null;
		if (jsonObject != null) {
			result = new AddressQueryResult();
			Map<String, Object> resultMappedJson = (Map<String, Object>) jsonObject.get("result");
			populateHeader(resultMappedJson, result);
			List<Object> resultDataMappedJson = (List<Object>) jsonObject.get("resultData");
			populateResultData(resultDataMappedJson, result);
		}

		return result;
	}

	private void populateHeader(Map<String, Object> jsonObject, AddressQueryResult result) {
		result.setProcessStatus((String) jsonObject.get("processStatus"));
		result.setModeUsed((String) jsonObject.get("modeUsed"));
		result.setPreferredLanguage((String) jsonObject.get("preferredLanguage"));
		result.setPreferredScript((String) jsonObject.get("preferredScript"));
		result.setIso3((String) jsonObject.get("countryCode"));
		String overFlowCount = (String) jsonObject.get("countOverflow");
		if (!isNullOrEmpty(overFlowCount)) {
			result.setCountOverFlow(Boolean.valueOf(overFlowCount));
		}
	}

	@SuppressWarnings("unchecked")
	private void populateResultData(List<Object> jsonList, AddressQueryResult result) {
		for (Object jsonResult : jsonList) {
			if (jsonResult instanceof Map) {
				Map<String, Object> jsonResultMap = (Map<String, Object>) jsonResult;
				AddressData addressData = result.new AddressData();
				result.getAddressData().add(addressData);
				addressData.setElementInputStatus((String) jsonResultMap.get("elementInputStatus"));
				addressData.setElementResultStatus((String) jsonResultMap.get("elementResultStatus"));
				addressData.setElementRelevance((String) jsonResultMap.get("elementRelevance"));
				addressData.setMailabilityScore((String) jsonResultMap.get("mailabilityScore"));
				addressData.setResultPercentage((String) jsonResultMap.get("resultPercentage"));
				addressData.setCassStatus((String) jsonResultMap.get("cassStatus"));
				addressData.setSerpStatus((String) jsonResultMap.get("serpStatus"));
				addressData.setSnaStatus((String) jsonResultMap.get("snaStatus"));
				addressData.setSupplementaryGBStatus((String) jsonResultMap.get("supplementaryGBStatus"));
				addressData.setSupplementaryUSStatus((String) jsonResultMap.get("supplementaryUSStatus"));
				populateAddressElement((List<Object>) jsonResultMap.get("key"), addressData.getKeys());
				populateAddressElement((List<Object>) jsonResultMap.get("country"), addressData.getCountries());
				populateAddressElement((List<Object>) jsonResultMap.get("locality"), addressData.getLocalities());
				populateAddressElement((List<Object>) jsonResultMap.get("postalCode"), addressData.getPostalCodes());
				populateAddressElement((List<Object>) jsonResultMap.get("province"), addressData.getProvinces());
				populateAddressElement((List<Object>) jsonResultMap.get("street"), addressData.getStreets());
				populateAddressElement((List<Object>) jsonResultMap.get("number"), addressData.getNumbers());
				populateAddressElement((List<Object>) jsonResultMap.get("building"), addressData.getBuildings());
				populateAddressElement((List<Object>) jsonResultMap.get("subBuilding"), addressData.getSubBuildings());
				populateAddressElement((List<Object>) jsonResultMap.get("deliveryService"), addressData.getDeliveryServices());
				populateAddressElement((List<Object>) jsonResultMap.get("organization"), addressData.getOrganizations());
				populateAddressElement((List<Object>) jsonResultMap.get("contact"), addressData.getContacts());
				populateAddressElement((List<Object>) jsonResultMap.get("residue"), addressData.getResidues());
				populateStreetElement((List<Object>) jsonResultMap.get("recipientLines"), addressData.getRecipientLines());
				populateStreetElement((List<Object>) jsonResultMap.get("deliveryAddressLine"), addressData.getDeliveryAddressLines());
				populateStreetElement((List<Object>) jsonResultMap.get("countrySpecificLocalityLine"), addressData.getCountrySpecificLocalityLines());
				populateStreetElement((List<Object>) jsonResultMap.get("formattedAddressLine"), addressData.getFormattedAddressLines());
				addressData.setCompleteAddress((String) jsonResultMap.get("completeAddress"));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void populateAddressElement(List<Object> jsonList, List<AddressElement> addressElement) {
		for (Object jsonResult : jsonList) {
			if (jsonResult instanceof Map) {
				Map<String, Object> jsonResultMap = (Map<String, Object>) jsonResult;
				addressElement.add(new AddressElement((String) jsonResultMap.get("type"), (String) jsonResultMap.get("value")));
			}
		}
	}

	private void populateStreetElement(List<Object> jsonList, List<String> streetList) {
		for (Object jsonResult : jsonList) {
			if (jsonResult instanceof String) {
				streetList.add((String) jsonResult);
			}
		}
	}

	private void handle(MessageContext messageContext, AddressQuery query) {
		if (messageContext != null && !messageContext.getErrors().isEmpty()) {
			ConstraintViolationContext<AddressQuery> context = new ConstraintViolationContext<AddressQuery>(query);
			for (Message message : messageContext.getErrors()) {
				context.buildConstraintViolationWithTemplate(message.getTemplate()).putAttributes(message.getAttributes()).addConstraintViolationForValue("");
			}
			throw new ConstraintViolationException(new LinkedHashSet<ConstraintViolation<?>>(context.getConstraintViolations()));
		}
	}

	private void validate(AddressQuery query) {
		Set<ConstraintViolation<AddressQuery>> violations = validator.validate(query);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new LinkedHashSet<ConstraintViolation<?>>(violations));
		}
	}

	private MessageInterpolator createMessageInterpolator() {
		MessageSource messageSource = new ResourceBundleMessageSource(MESSAGES);
		return new MessageSourceMessageInterpolator(messageSource);
	}

	private AddressQueryResult processRequest(AddressQuery query, URL endpoint) {
		new Verifier().isNotNull(query, "Input must not be null").throwIfError();
		JsonParser parser;
		AddressQueryResult content = null;
		try {
			validate(query);
			parser = new JsonHttpClient(endpoint).get(parameterize(query));
			try {
				StandardResponse<AddressQueryResult> response = read(parser);
				handle(response.getMessages(), query);
				content = response.getContent();
			} finally {
				parser.close();
			}
		} catch (IOException ioException) {
			throw new IllegalStateException("Error with backend service.", ioException);
		}

		return content;
	}

}
