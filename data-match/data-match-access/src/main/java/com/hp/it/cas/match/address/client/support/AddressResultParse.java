package com.hp.it.cas.match.address.client.support;

import java.util.List;

import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;

/**
 * Its role is parsing the AddressResult to the string formation .Because the
 * construction of AddressResult is complicated ,and without any toString()
 * method. The only way to check out whether the AddressResult output is correct
 * or not, just to parse the AddressResult to the string and compare it to the
 * correct string with the same and fixed formation. So this class is used to
 * parse the AddressResult output to the string to suit for comparing with the
 * right string in junit test.
 * 
 * @version 1.0
 * @author Hu, Fei-Yang (Edward, HPIT-DS-CDC)
 * 
 */
public class AddressResultParse {

	/**
	 * Parse the addressQueryResult output to string.
	 * 
	 * @param addressQueryResult
	 *            The result need to be parsed
	 * @return The addressQueryResult string.
	 */
	public static String parseAddressQueryResultToString(AddressQueryResult addressQueryResult) {

		StringBuilder strBuilder = new StringBuilder(1000);
		strBuilder.append("AddressQueryResult:{");
		parseAddressQueryResultAttributesToStringBuilder(addressQueryResult, strBuilder);
		parseAddressDataToStringBuilder(addressQueryResult, strBuilder);
		strBuilder.append(" }");
		return strBuilder.toString();
	}

	/**
	 * Parse the AddressQueryResultAttributes to StringBuilder
	 * 
	 * @param addressQueryResult
	 *            The result attributes need to be parsed
	 * @param strBuilder
	 *            The addressQueryResult string.
	 */
	private static void parseAddressQueryResultAttributesToStringBuilder(AddressQueryResult addressQueryResult,
			StringBuilder strBuilder) {

		strBuilder.append(" ProcessStatus:" + addressQueryResult.getProcessStatus() + ",");
		strBuilder.append(" ModeUsed:" + addressQueryResult.getProcessStatus() + ",");
		strBuilder.append(" CountOverFlow:" + (addressQueryResult.isCountOverFlow() ? "true" : "false") + ",");
		strBuilder.append(" ISO3:" + addressQueryResult.getIso3() + ",");
		strBuilder.append(" PreferredScript:" + addressQueryResult.getPreferredScript() + ",");
		strBuilder.append(" PreferredLanguage:" + addressQueryResult.getPreferredLanguage() + ",");
	}

	/**
	 * Parse the AddressData to StringBuilder
	 * 
	 * @param addressQueryResult
	 *            the addressDate in addressQueryResult need to be parsed
	 * @param strBuilder
	 *            The addressQueryResult string.
	 */
	private static void parseAddressDataToStringBuilder(AddressQueryResult addressQueryResult, StringBuilder strBuilder) {

		List<AddressData> addressDataList = addressQueryResult.getAddressData();
		if (addressDataList != null && !addressDataList.isEmpty()) {
			for (int i = 0; i < addressDataList.size(); i++) {
				AddressData addressData = addressDataList.get(i);
				strBuilder.append(" AddressData{");
				strBuilder.append(" MailabilityScore:" + addressData.getMailabilityScore() + ",");
				strBuilder.append(" ResultPercentage:" + addressData.getResultPercentage() + ",");
				strBuilder.append(" ElementResultStatus:" + addressData.getElementResultStatus() + ",");
				strBuilder.append(" ElementInputStatus:" + addressData.getElementInputStatus() + ",");
				strBuilder.append(" ElementRelevance:" + addressData.getElementRelevance() + ",");
				strBuilder.append(" CassStatus:" + addressData.getCassStatus() + ",");
				strBuilder.append(" SerpStatus:" + addressData.getSerpStatus() + ",");
				strBuilder.append(" SnaStatus:" + addressData.getSnaStatus() + ",");
				strBuilder.append(" SupplementaryGBStatus:" + addressData.getSupplementaryGBStatus() + ",");
				strBuilder.append(" SupplementaryUSStatus:" + addressData.getSupplementaryUSStatus() + ",");

				parseAddressElementListToStringBuilder(addressData.getKeys(), strBuilder, "Keys");
				parseAddressElementListToStringBuilder(addressData.getCountries(), strBuilder, "Countries");
				parseAddressElementListToStringBuilder(addressData.getLocalities(), strBuilder, "Localities");
				parseAddressElementListToStringBuilder(addressData.getPostalCodes(), strBuilder, "PostalCodes");
				parseAddressElementListToStringBuilder(addressData.getProvinces(), strBuilder, "Provinces");
				parseAddressElementListToStringBuilder(addressData.getSubProvinces(), strBuilder, "SubProvinces");
				parseAddressElementListToStringBuilder(addressData.getStreets(), strBuilder, "Streets");
				parseAddressElementListToStringBuilder(addressData.getNumbers(), strBuilder, "Numbers");
				parseAddressElementListToStringBuilder(addressData.getBuildings(), strBuilder, "Buildings");
				parseAddressElementListToStringBuilder(addressData.getSubBuildings(), strBuilder, "SubBuildings");
				parseAddressElementListToStringBuilder(addressData.getDeliveryServices(), strBuilder,
						"DeliveryServices");
				parseAddressElementListToStringBuilder(addressData.getOrganizations(), strBuilder, "Organizations");
				parseAddressElementListToStringBuilder(addressData.getContacts(), strBuilder, "Contacts");
				parseAddressElementListToStringBuilder(addressData.getResidues(), strBuilder, "Residues");

				parseArrayListToStringBuilder(addressData.getRecipientLines(), strBuilder, "RecipientLines");
				parseArrayListToStringBuilder(addressData.getDeliveryAddressLines(), strBuilder, "DeliveryAddressLines");
				parseArrayListToStringBuilder(addressData.getCountrySpecificLocalityLines(), strBuilder,
						"CountrySpecificLocalityLines");
				parseArrayListToStringBuilder(addressData.getFormattedAddressLines(), strBuilder,
						"FormattedAddressLines");

				strBuilder.append("CompleteAddress:{" + addressData.getCompleteAddress() + "} ");

				parseAddressElementListToStringBuilder(addressData.getCass(), strBuilder, "Cass");
				parseAddressElementListToStringBuilder(addressData.getSerp(), strBuilder, "Serp");
				parseAddressElementListToStringBuilder(addressData.getSna(), strBuilder, "Sna");
				parseAddressElementListToStringBuilder(addressData.getSupplementaryGb(), strBuilder, "SupplementaryGB");
				parseAddressElementListToStringBuilder(addressData.getSupplementaryUs(), strBuilder, "SupplementaryUS");

				strBuilder.append("} ");
			}
		}
	}

	/**
	 * Parse the AddressElementList to StringBuilder
	 * 
	 * @param addressElementList
	 *            The addressElementList contained in addressData.
	 * @param strBuilder
	 *            The addressQueryResult string.
	 * @param addressElementType
	 *            Indicate the name of every AddressElement.
	 * 
	 */
	private static void parseAddressElementListToStringBuilder(List<AddressElement> addressElementList,
			StringBuilder strBuilder, String addressElementType) {

		if (addressElementList != null && !addressElementList.isEmpty()) {
			strBuilder.append(addressElementType + ":{");
			for (int i = 0; i < addressElementList.size(); i++) {
				AddressElement addressElement = addressElementList.get(i);
				if (!addressElement.getValue().isEmpty()) {
					strBuilder.append(addressElement.getType() + ":" + addressElement.getValue());
					if (i != addressElementList.size() - 1) {
						strBuilder.append(", ");
					}
				}
			}
			strBuilder.append("} ");
		}
	}

	/**
	 * Parse the ArrayList to StringBuilder
	 * 
	 * @param list
	 *            The list contained in addressData.
	 * @param strBuilder
	 *            The addressQueryResult string.
	 * @param addressElementType
	 *            Indicate the name of every AddressElement.
	 * 
	 */
	private static void parseArrayListToStringBuilder(List<String> list, StringBuilder strBuilder,
			String addressElementType) {
		if (list != null && !list.isEmpty()) {
			strBuilder.append(addressElementType + ":{");
			for (int i = 0; i < list.size(); i++) {
				strBuilder.append(list.get(i));
				if (i != list.size() - 1) {
					strBuilder.append(", ");
				}
			}
			strBuilder.append("} ");
		}
	}
}
