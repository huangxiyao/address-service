package com.hp.it.cas.match.batch;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import com.hp.it.cas.batch.driver.pipe.FieldSet;
import com.hp.it.cas.batch.driver.pipe.FieldSetMapper;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.batch.utilities.BatchUtils;

public class AddressFindMapper implements FieldSetMapper<AddressFind>{

	public static int 	KEY1	=	0	;
	public static int 	KEY2	=	1	;
	public static int 	KEY3	=	2	;
	public static int 	MODEUSED	=	3	;
	public static int 	PREFERREDLANGUAGE	=	4	;
	public static int 	PREFERREDSCRIPT	=	5	;
	public static int 	CHARACTERSCRIPTDETECTIONINDICATOR	=	6	;
	public static int 	COUNTRY1	=	7	;
	public static int 	COUNTRY2	=	8	;
	public static int 	COUNTRY3	=	9	;
	public static int 	ADDRESSCOMPLETE	=	10	;
	public static int 	BUILDING1	=	11	;
	public static int 	BUILDING2	=	12	;
	public static int 	BUILDING3	=	13	;
	public static int 	BUILDING4	=	14	;
	public static int 	BUILDING5	=	15	;
	public static int 	BUILDING6	=	16	;
	public static int 	LOCALITY1	=	17	;
	public static int 	LOCALITY2	=	18	;
	public static int 	LOCALITY3	=	19	;
	public static int 	LOCALITY4	=	20	;
	public static int 	LOCALITY5	=	21	;
	public static int 	LOCALITY6	=	22	;
	public static int 	POSTALCODE1	=	23	;
	public static int 	POSTALCODE2	=	24	;
	public static int 	POSTALCODE3	=	25	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE1	=	26	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE2	=	27	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE3	=	28	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE4	=	29	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE5	=	30	;
	public static int 	COUNTRYSPECIFICLOCALITYLINE6	=	31	;
	public static int 	STREET1	=	32	;
	public static int 	STREET2	=	33	;
	public static int 	STREET3	=	34	;
	public static int 	STREET4	=	35	;
	public static int 	STREET5	=	36	;
	public static int 	STREET6	=	37	;
	public static int 	NUMBER1	=	38	;
	public static int 	NUMBER2	=	39	;
	public static int 	NUMBER3	=	40	;
	public static int 	NUMBER4	=	41	;
	public static int 	NUMBER5	=	42	;
	public static int 	NUMBER6	=	43	;
	public static int 	PROVINCE1	=	44	;
	public static int 	PROVINCE2	=	45	;
	public static int 	PROVINCE3	=	46	;
	public static int 	PROVINCE4	=	47	;
	public static int 	PROVINCE5	=	48	;
	public static int 	PROVINCE6	=	49	;
	public static int 	DELIVERYADDRESSLINE1	=	50	;
	public static int 	DELIVERYADDRESSLINE2	=	51	;
	public static int 	DELIVERYADDRESSLINE3	=	52	;
	public static int 	DELIVERYADDRESSLINE4	=	53	;
	public static int 	DELIVERYADDRESSLINE5	=	54	;
	public static int 	DELIVERYADDRESSLINE6	=	55	;
	public static int 	DELIVERYSERVICE1	=	56	;
	public static int 	DELIVERYSERVICE2	=	57	;
	public static int 	DELIVERYSERVICE3	=	58	;
	public static int 	DELIVERYSERVICE4	=	59	;
	public static int 	DELIVERYSERVICE5	=	60	;
	public static int 	DELIVERYSERVICE6	=	61	;
	public static int 	FORMATTEDADDRESSLINE1	=	62	;
	public static int 	FORMATTEDADDRESSLINE2	=	63	;
	public static int 	FORMATTEDADDRESSLINE3	=	64	;
	public static int 	FORMATTEDADDRESSLINE4	=	65	;
	public static int 	FORMATTEDADDRESSLINE5	=	66	;
	public static int 	FORMATTEDADDRESSLINE6	=	67	;
	public static int 	FORMATTEDADDRESSLINE7	=	68	;
	public static int 	FORMATTEDADDRESSLINE8	=	69	;
	public static int 	FORMATTEDADDRESSLINE9	=	70	;
	public static int 	FORMATTEDADDRESSLINE10	=	71	;
	public static int 	FORMATTEDADDRESSLINE11	=	72	;
	public static int 	FORMATTEDADDRESSLINE12	=	73	;
	public static int 	FORMATTEDADDRESSLINE13	=	74	;
	public static int 	FORMATTEDADDRESSLINE14	=	75	;
	public static int 	FORMATTEDADDRESSLINE15	=	76	;
	public static int 	FORMATTEDADDRESSLINE16	=	77	;
	public static int 	FORMATTEDADDRESSLINE17	=	78	;
	public static int 	FORMATTEDADDRESSLINE18	=	79	;
	public static int 	FORMATTEDADDRESSLINE19	=	80	;
	public static int 	ORGANIZATION1	=	81	;
	public static int 	ORGANIZATION2	=	82	;
	public static int 	ORGANIZATION3	=	83	;
	public static int 	CONTACT1	=	84	;
	public static int 	CONTACT2	=	85	;
	public static int 	CONTACT3	=	86	;
	public static int 	RECIPIENTLINE1	=	87	;
	public static int 	RECIPIENTLINE2	=	88	;
	public static int 	RECIPIENTLINE3	=	89	;
	public static int 	RESIDUE1	=	90	;
	public static int 	RESIDUE2	=	91	;
	public static int 	RESIDUE3	=	92	;
	public static int 	RESIDUE4	=	93	;
	public static int 	RESIDUE5	=	94	;
	public static int 	RESIDUE6	=	95	;
	public static int 	SUBBUILDING1	=	96	;
	public static int 	SUBBUILDING2	=	97	;
	public static int 	SUBBUILDING3	=	98	;
	public static int 	SUBBUILDING4	=	99	;
	public static int 	SUBBUILDING5	=	100	;
	public static int 	SUBBUILDING6	=	101	;
	
	@Override
	public AddressFind map(FieldSet fieldSet) throws ConstraintViolationException {
		AddressFind addressFind = new AddressFind();
		
		int size = fieldSet.size();
		System.out.println("size:" + size);

		// save outputFileName
		// TODO 
		if (BatchUtils.checkCSVFileName(fieldSet.getString(0))){
			addressFind.setOutputFileName(fieldSet.getString(0).substring(fieldSet.getString(0).indexOf(":") + 1, fieldSet.getString(0).length()));
			return addressFind;
		}
		
		// TODO
		// last row email address
		// flag send
		if (BatchUtils.checkEmail(fieldSet.getString(0))){
			ArrayList<String> emailList = new ArrayList<String>();
			for (int i=0; i < size; i++) {
				emailList.add(fieldSet.getString(i));
			}
			addressFind.setEmailList(emailList);
			return addressFind;
		}
		
				
		addressFind.setModeUsed(BatchUtils.trimString( MODEUSED < size ? fieldSet.getString(MODEUSED) : "BATCH"));
		
		AddressQuery query = new AddressQuery();
		
		query.setKey1	(BatchUtils.trimString(	KEY1	< size ?	fieldSet.getString(	KEY1	) : null));
		query.setKey2	(BatchUtils.trimString(	KEY2	< size ?	fieldSet.getString(	KEY2	) : null));
		query.setKey3	(BatchUtils.trimString(	KEY3	< size ?	fieldSet.getString(	KEY3	) : null));
		query.setPreferredLanguage	(BatchUtils.trimString(	PREFERREDLANGUAGE	< size ?	fieldSet.getString(	PREFERREDLANGUAGE	) : null));
		query.setPreferredScript	(BatchUtils.trimString(	PREFERREDSCRIPT	< size ?	fieldSet.getString(	PREFERREDSCRIPT	) : null));
		
		query.setCharacterScriptDetectionIndicator	(CHARACTERSCRIPTDETECTIONINDICATOR	< size ?	Boolean.valueOf(fieldSet.getString(	CHARACTERSCRIPTDETECTIONINDICATOR	)) : false);
		
		query.setCountry1	(BatchUtils.trimString(	COUNTRY1	< size ?	fieldSet.getString(	COUNTRY1	) : null));
		query.setCountry2	(BatchUtils.trimString(	COUNTRY2	< size ?	fieldSet.getString(	COUNTRY2	) : null));
		query.setCountry3	(BatchUtils.trimString(	COUNTRY3	< size ?	fieldSet.getString(	COUNTRY3	) : null));
		query.setAddressComplete	(BatchUtils.trimString(	ADDRESSCOMPLETE	< size ?	fieldSet.getString(	ADDRESSCOMPLETE	) : null));
		query.setBuilding1	(BatchUtils.trimString(	BUILDING1	< size ?	fieldSet.getString(	BUILDING1	) : null));
		query.setBuilding2	(BatchUtils.trimString(	BUILDING2	< size ?	fieldSet.getString(	BUILDING2	) : null));
		query.setBuilding3	(BatchUtils.trimString(	BUILDING3	< size ?	fieldSet.getString(	BUILDING3	) : null));
		query.setBuilding4	(BatchUtils.trimString(	BUILDING4	< size ?	fieldSet.getString(	BUILDING4	) : null));
		query.setBuilding5	(BatchUtils.trimString(	BUILDING5	< size ?	fieldSet.getString(	BUILDING5	) : null));
		query.setBuilding6	(BatchUtils.trimString(	BUILDING6	< size ?	fieldSet.getString(	BUILDING6	) : null));
		query.setLocality1	(BatchUtils.trimString(	LOCALITY1	< size ?	fieldSet.getString(	LOCALITY1	) : null));
		query.setLocality2	(BatchUtils.trimString(	LOCALITY2	< size ?	fieldSet.getString(	LOCALITY2	) : null));
		query.setLocality3	(BatchUtils.trimString(	LOCALITY3	< size ?	fieldSet.getString(	LOCALITY3	) : null));
		query.setLocality4	(BatchUtils.trimString(	LOCALITY4	< size ?	fieldSet.getString(	LOCALITY4	) : null));
		query.setLocality5	(BatchUtils.trimString(	LOCALITY5	< size ?	fieldSet.getString(	LOCALITY5	) : null));
		query.setLocality6	(BatchUtils.trimString(	LOCALITY6	< size ?	fieldSet.getString(	LOCALITY6	) : null));
		query.setPostalCode1	(BatchUtils.trimString(	POSTALCODE1	< size ?	fieldSet.getString(	POSTALCODE1	) : null));
		query.setPostalCode2	(BatchUtils.trimString(	POSTALCODE2	< size ?	fieldSet.getString(	POSTALCODE2	) : null));
		query.setPostalCode3	(BatchUtils.trimString(	POSTALCODE3	< size ?	fieldSet.getString(	POSTALCODE3	) : null));
		query.setCountrySpecificLocalityLine1	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE1	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE1	) : null));
		query.setCountrySpecificLocalityLine2	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE2	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE2	) : null));
		query.setCountrySpecificLocalityLine3	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE3	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE3	) : null));
		query.setCountrySpecificLocalityLine4	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE4	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE4	) : null));
		query.setCountrySpecificLocalityLine5	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE5	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE5	) : null));
		query.setCountrySpecificLocalityLine6	(BatchUtils.trimString(	COUNTRYSPECIFICLOCALITYLINE6	< size ?	fieldSet.getString(	COUNTRYSPECIFICLOCALITYLINE6	) : null));
		query.setStreet1	(BatchUtils.trimString(	STREET1	< size ?	fieldSet.getString(	STREET1	) : null));
		query.setStreet2	(BatchUtils.trimString(	STREET2	< size ?	fieldSet.getString(	STREET2	) : null));
		query.setStreet3	(BatchUtils.trimString(	STREET3	< size ?	fieldSet.getString(	STREET3	) : null));
		query.setStreet4	(BatchUtils.trimString(	STREET4	< size ?	fieldSet.getString(	STREET4	) : null));
		query.setStreet5	(BatchUtils.trimString(	STREET5	< size ?	fieldSet.getString(	STREET5	) : null));
		query.setStreet6	(BatchUtils.trimString(	STREET6	< size ?	fieldSet.getString(	STREET6	) : null));
		query.setNumber1	(BatchUtils.trimString(	NUMBER1	< size ?	fieldSet.getString(	NUMBER1	) : null));
		query.setNumber2	(BatchUtils.trimString(	NUMBER2	< size ?	fieldSet.getString(	NUMBER2	) : null));
		query.setNumber3	(BatchUtils.trimString(	NUMBER3	< size ?	fieldSet.getString(	NUMBER3	) : null));
		query.setNumber4	(BatchUtils.trimString(	NUMBER4	< size ?	fieldSet.getString(	NUMBER4	) : null));
		query.setNumber5	(BatchUtils.trimString(	NUMBER5	< size ?	fieldSet.getString(	NUMBER5	) : null));
		query.setNumber6	(BatchUtils.trimString(	NUMBER6	< size ?	fieldSet.getString(	NUMBER6	) : null));
		query.setProvince1	(BatchUtils.trimString(	PROVINCE1	< size ?	fieldSet.getString(	PROVINCE1	) : null));
		query.setProvince2	(BatchUtils.trimString(	PROVINCE2	< size ?	fieldSet.getString(	PROVINCE2	) : null));
		query.setProvince3	(BatchUtils.trimString(	PROVINCE3	< size ?	fieldSet.getString(	PROVINCE3	) : null));
		query.setProvince4	(BatchUtils.trimString(	PROVINCE4	< size ?	fieldSet.getString(	PROVINCE4	) : null));
		query.setProvince5	(BatchUtils.trimString(	PROVINCE5	< size ?	fieldSet.getString(	PROVINCE5	) : null));
		query.setProvince6	(BatchUtils.trimString(	PROVINCE6	< size ?	fieldSet.getString(	PROVINCE6	) : null));
		query.setDeliveryAddressLine1	(BatchUtils.trimString(	DELIVERYADDRESSLINE1	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE1	) : null));
		query.setDeliveryAddressLine2	(BatchUtils.trimString(	DELIVERYADDRESSLINE2	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE2	) : null));
		query.setDeliveryAddressLine3	(BatchUtils.trimString(	DELIVERYADDRESSLINE3	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE3	) : null));
		query.setDeliveryAddressLine4	(BatchUtils.trimString(	DELIVERYADDRESSLINE4	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE4	) : null));
		query.setDeliveryAddressLine5	(BatchUtils.trimString(	DELIVERYADDRESSLINE5	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE5	) : null));
		query.setDeliveryAddressLine6	(BatchUtils.trimString(	DELIVERYADDRESSLINE6	< size ?	fieldSet.getString(	DELIVERYADDRESSLINE6	) : null));
		query.setDeliveryService1	(BatchUtils.trimString(	DELIVERYSERVICE1	< size ?	fieldSet.getString(	DELIVERYSERVICE1	) : null));
		query.setDeliveryService2	(BatchUtils.trimString(	DELIVERYSERVICE2	< size ?	fieldSet.getString(	DELIVERYSERVICE2	) : null));
		query.setDeliveryService3	(BatchUtils.trimString(	DELIVERYSERVICE3	< size ?	fieldSet.getString(	DELIVERYSERVICE3	) : null));
		query.setDeliveryService4	(BatchUtils.trimString(	DELIVERYSERVICE4	< size ?	fieldSet.getString(	DELIVERYSERVICE4	) : null));
		query.setDeliveryService5	(BatchUtils.trimString(	DELIVERYSERVICE5	< size ?	fieldSet.getString(	DELIVERYSERVICE5	) : null));
		query.setDeliveryService6	(BatchUtils.trimString(	DELIVERYSERVICE6	< size ?	fieldSet.getString(	DELIVERYSERVICE6	) : null));
		query.setFormattedAddressLine1	(BatchUtils.trimString(	FORMATTEDADDRESSLINE1	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE1	) : null));
		query.setFormattedAddressLine2	(BatchUtils.trimString(	FORMATTEDADDRESSLINE2	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE2	) : null));
		query.setFormattedAddressLine3	(BatchUtils.trimString(	FORMATTEDADDRESSLINE3	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE3	) : null));
		query.setFormattedAddressLine4	(BatchUtils.trimString(	FORMATTEDADDRESSLINE4	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE4	) : null));
		query.setFormattedAddressLine5	(BatchUtils.trimString(	FORMATTEDADDRESSLINE5	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE5	) : null));
		query.setFormattedAddressLine6	(BatchUtils.trimString(	FORMATTEDADDRESSLINE6	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE6	) : null));
		query.setFormattedAddressLine7	(BatchUtils.trimString(	FORMATTEDADDRESSLINE7	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE7	) : null));
		query.setFormattedAddressLine8	(BatchUtils.trimString(	FORMATTEDADDRESSLINE8	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE8	) : null));
		query.setFormattedAddressLine9	(BatchUtils.trimString(	FORMATTEDADDRESSLINE9	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE9	) : null));
		query.setFormattedAddressLine10	(BatchUtils.trimString(	FORMATTEDADDRESSLINE10	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE10	) : null));
		query.setFormattedAddressLine11	(BatchUtils.trimString(	FORMATTEDADDRESSLINE11	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE11	) : null));
		query.setFormattedAddressLine12	(BatchUtils.trimString(	FORMATTEDADDRESSLINE12	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE12	) : null));
		query.setFormattedAddressLine13	(BatchUtils.trimString(	FORMATTEDADDRESSLINE13	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE13	) : null));
		query.setFormattedAddressLine14	(BatchUtils.trimString(	FORMATTEDADDRESSLINE14	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE14	) : null));
		query.setFormattedAddressLine15	(BatchUtils.trimString(	FORMATTEDADDRESSLINE15	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE15	) : null));
		query.setFormattedAddressLine16	(BatchUtils.trimString(	FORMATTEDADDRESSLINE16	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE16	) : null));
		query.setFormattedAddressLine17	(BatchUtils.trimString(	FORMATTEDADDRESSLINE17	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE17	) : null));
		query.setFormattedAddressLine18	(BatchUtils.trimString(	FORMATTEDADDRESSLINE18	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE18	) : null));
		query.setFormattedAddressLine19	(BatchUtils.trimString(	FORMATTEDADDRESSLINE19	< size ?	fieldSet.getString(	FORMATTEDADDRESSLINE19	) : null));
		query.setOrganization1	(BatchUtils.trimString(	ORGANIZATION1	< size ?	fieldSet.getString(	ORGANIZATION1	) : null));
		query.setOrganization2	(BatchUtils.trimString(	ORGANIZATION2	< size ?	fieldSet.getString(	ORGANIZATION2	) : null));
		query.setOrganization3	(BatchUtils.trimString(	ORGANIZATION3	< size ?	fieldSet.getString(	ORGANIZATION3	) : null));
		query.setContact1	(BatchUtils.trimString(	CONTACT1	< size ?	fieldSet.getString(	CONTACT1	) : null));
		query.setContact2	(BatchUtils.trimString(	CONTACT2	< size ?	fieldSet.getString(	CONTACT2	) : null));
		query.setContact3	(BatchUtils.trimString(	CONTACT3	< size ?	fieldSet.getString(	CONTACT3	) : null));
		query.setRecipientLine1	(BatchUtils.trimString(	RECIPIENTLINE1	< size ?	fieldSet.getString(	RECIPIENTLINE1	) : null));
		query.setRecipientLine2	(BatchUtils.trimString(	RECIPIENTLINE2	< size ?	fieldSet.getString(	RECIPIENTLINE2	) : null));
		query.setRecipientLine3	(BatchUtils.trimString(	RECIPIENTLINE3	< size ?	fieldSet.getString(	RECIPIENTLINE3	) : null));
		query.setResidue1	(BatchUtils.trimString(	RESIDUE1	< size ?	fieldSet.getString(	RESIDUE1	) : null));
		query.setResidue2	(BatchUtils.trimString(	RESIDUE2	< size ?	fieldSet.getString(	RESIDUE2	) : null));
		query.setResidue3	(BatchUtils.trimString(	RESIDUE3	< size ?	fieldSet.getString(	RESIDUE3	) : null));
		query.setResidue4	(BatchUtils.trimString(	RESIDUE4	< size ?	fieldSet.getString(	RESIDUE4	) : null));
		query.setResidue5	(BatchUtils.trimString(	RESIDUE5	< size ?	fieldSet.getString(	RESIDUE5	) : null));
		query.setResidue6	(BatchUtils.trimString(	RESIDUE6	< size ?	fieldSet.getString(	RESIDUE6	) : null));
		query.setSubBuilding1	(BatchUtils.trimString(	SUBBUILDING1	< size ?	fieldSet.getString(	SUBBUILDING1	) : null));
		query.setSubBuilding2	(BatchUtils.trimString(	SUBBUILDING2	< size ?	fieldSet.getString(	SUBBUILDING2	) : null));
		query.setSubBuilding3	(BatchUtils.trimString(	SUBBUILDING3	< size ?	fieldSet.getString(	SUBBUILDING3	) : null));
		query.setSubBuilding4	(BatchUtils.trimString(	SUBBUILDING4	< size ?	fieldSet.getString(	SUBBUILDING4	) : null));
		query.setSubBuilding5	(BatchUtils.trimString(	SUBBUILDING5	< size ?	fieldSet.getString(	SUBBUILDING5	) : null));
		query.setSubBuilding6	(BatchUtils.trimString(	SUBBUILDING6	< size ?	fieldSet.getString(	SUBBUILDING6	) : null));

		addressFind.setQuery(query);
		
		return addressFind;
		
	}
	
	
	public static void main(String[] args){
		System.out.println(Boolean.valueOf(null));
	}

}
