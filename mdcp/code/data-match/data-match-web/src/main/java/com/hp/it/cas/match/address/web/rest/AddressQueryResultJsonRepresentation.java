package com.hp.it.cas.match.address.web.rest;

import java.io.IOException;
import java.util.List;

import com.hp.it.cas.foundation.json.JsonArrayWriter;
import com.hp.it.cas.foundation.json.JsonItemWriter;
import com.hp.it.cas.foundation.json.JsonObjectWriter;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.foundation.serial.StandardResponse;
import com.hp.it.cas.foundation.web.StandardResponseJsonRepresentation;
import com.hp.it.cas.match.address.AddressElement;
import com.hp.it.cas.match.address.AddressQueryResult;
import com.hp.it.cas.match.address.AddressQueryResult.AddressData;

class AddressQueryResultJsonRepresentation extends StandardResponseJsonRepresentation<AddressQueryResult>{
	
	AddressQueryResultJsonRepresentation(AddressQueryResult result, MessageContext messageContext){
		super(new StandardResponse<AddressQueryResult>(null, messageContext, result));
	}
	
	void writeResult(JsonItemWriter<?> resultWriter, AddressQueryResult result) throws IOException {
		resultWriter.object()
			.pair("countryCode", result.getIso3())
		 	.pair("modeUsed", result.getModeUsed())
		 	.pair("preferredLanguage", result.getPreferredLanguage())
		 	.pair("preferredScript", result.getPreferredScript())
		 	.pair("processStatus", result.getProcessStatus())
		 	.pair("countOverflow", result.isCountOverFlow())
		 .endObject();	
	}
	
	void writeResultData(JsonItemWriter<?> resultDataWriter, List<AddressData> result) throws IOException {
		JsonArrayWriter<?> arrayWriter = resultDataWriter.array();
		for(AddressData addressData : result){
			writeAddressDataItem(arrayWriter, addressData);
		}
		arrayWriter.endArray();
	}
	
	void writeAddressDataItem(JsonItemWriter<?> addressDataItemWriter, AddressData result) throws IOException {
		JsonObjectWriter<?> objectWriter = addressDataItemWriter.object()
			.pair("elementInputStatus", result.getElementInputStatus())
			.pair("elementResultStatus", result.getElementResultStatus())
			.pair("elementRelevance", result.getElementRelevance())
			.pair("mailabilityScore", result.getMailabilityScore())
			.pair("resultPercentage", result.getResultPercentage())
			.pair("cassStatus", result.getCassStatus())
			.pair("serpStatus", result.getSerpStatus())
			.pair("snaStatus", result.getSnaStatus())
			.pair("supplementaryGBStatus", result.getSupplementaryGBStatus())
			.pair("supplementaryUSStatus", result.getSupplementaryUSStatus())
			.pair("geoCodingStatus", result.getGeoCodingStatus());
		
		JsonArrayWriter<?> arrayWriter = objectWriter.name("key").array();
		for(AddressElement element: result.getKeys()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("country").array();
		for(AddressElement element: result.getCountries()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("supplementaryUS").array();
		for(AddressElement element: result.getSupplementaryUs()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("geoCoding").array();
		for(AddressElement element: result.getGeoCoding()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("locality").array();
		for(AddressElement element: result.getLocalities()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("postalCode").array();
		for(AddressElement element: result.getPostalCodes()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("province").array();
		for(AddressElement element: result.getProvinces()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("subProvince").array();
		for(AddressElement element: result.getSubProvinces()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("street").array();
		for(AddressElement element: result.getStreets()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("number").array();
		for(AddressElement element: result.getNumbers()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("building").array();
		for(AddressElement element: result.getBuildings()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("subBuilding").array();
		for(AddressElement element: result.getSubBuildings()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("deliveryService").array();
		for(AddressElement element: result.getDeliveryServices()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("organization").array();
		for(AddressElement element: result.getOrganizations()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("contact").array();
		for(AddressElement element: result.getContacts()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("residue").array();
		for(AddressElement element: result.getResidues()){
			writeAddressElement(arrayWriter, element);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("recipientLines").array();
		for(String line: result.getRecipientLines()){
			arrayWriter.value(line);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("deliveryAddressLine").array();
		for(String line: result.getDeliveryAddressLines()){
			arrayWriter.value(line);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("countrySpecificLocalityLine").array();
		for(String line: result.getCountrySpecificLocalityLines()){
			arrayWriter.value(line);
		}
		arrayWriter.endArray();
		
		arrayWriter = objectWriter.name("formattedAddressLine").array();
		for(String line: result.getFormattedAddressLines()){
			arrayWriter.value(line);
		}
		arrayWriter.endArray();
		objectWriter.pair("completeAddress", result.getCompleteAddress());
		objectWriter.endObject();
	}
	
	void writeAddressElement(JsonItemWriter<?> writer, AddressElement element) throws IOException{
		writer.object()
		 .pair("type", element.getType())
		 .pair("value", element.getValue())
		 .endObject();
	}
	
	 @Override
     protected void writeContent(JsonItemWriter<?> contentWriter, AddressQueryResult result) throws IOException {
		 JsonObjectWriter<?> objectWriter = contentWriter.object();
		 writeResult(objectWriter.name("result"), result);
		 writeResultData(objectWriter.name("resultData"), result.getAddressData());
		 objectWriter.endObject();		 
	 }
	
}