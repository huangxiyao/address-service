package com.hp.it.cas.match.batch;

import java.io.StringReader;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.BeanUtils;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.hp.it.cas.batch.driver.pipe.FieldSet;
import com.hp.it.cas.batch.driver.pipe.FieldSetMapper;
import com.hp.it.cas.match.address.AddressQuery;
import com.hp.it.cas.match.address.utilities.StringUtils;
import com.hp.it.cas.match.batch.utilities.BatchUtils;
import com.hp.it.cas.match.batch.utilities.Constant;

/**
 * Mapper for AddressFind.
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindMapper implements FieldSetMapper<AddressFind>{
	private AddressInput address;
	
	public enum ModeUse {
		BATCH, INTERACTIVE, FASTCOMPLETION, CERTIFIED, PARSE, COUNTRYRECOGNITION;
		public static boolean matchMode(String value){
			if (ModeUse.BATCH.name().equals(value)){
				return true;
			} else if (ModeUse.INTERACTIVE.name().equals(value)){
				return true;
			} else if (ModeUse.FASTCOMPLETION.name().equals(value)){
				return true;
			} else if (ModeUse.CERTIFIED.name().equals(value)){
				return true;
			} else if (ModeUse.PARSE.name().equals(value)){
				return true;
			} else if (ModeUse.COUNTRYRECOGNITION.name().equals(value)){
				return true;
			} else {
				return false;
			}
		}
		
		public static String getModeNames(){
			return ModeUse.BATCH.name() + ", " + ModeUse.INTERACTIVE.name() + ", " + ModeUse.FASTCOMPLETION.name() + ", " + ModeUse.CERTIFIED.name() + ", " + ModeUse.PARSE.name() + ", " + ModeUse.COUNTRYRECOGNITION.name();
 		}
	};
	
	@Override
	public AddressFind map(FieldSet fieldSet) throws ConstraintViolationException {
		AddressFind addressFind = new AddressFind();
		
		/* empty data */
		if (fieldSet.size() == 0) {
			addressFind.setErrorMessage("This is an empty record.");
			return addressFind;
		}
		
		/* save outputFileName:InputFileName_OUTPUT.csv */
		if (BatchUtils.checkOutputFileName(fieldSet.getString(0))){
			String filename = fieldSet.getString(0);
			addressFind.setOutputFileName(filename.substring(filename.indexOf(":") + 1, filename.length()));
			return addressFind;
		}
		
		/* save the email */
		if (BatchUtils.checkEmail(fieldSet.getString(0))){
			addressFind.setEmailList(fieldSet.values());
			return addressFind;
		}
			
		/* save address query */
		addressFind.setQuery(retrieveAddressQuery(fieldSet));
		
		/* save Mode */		
		String mode = StringUtils.isNullOrEmpty(address.getModeUsed()) ? address.getModeUsed() : address.getModeUsed().trim();
		if (StringUtils.isNullOrEmpty(mode)) {
			addressFind.setErrorMessage("The modeUsed can't be null. The value should be in the list of {" + ModeUse.getModeNames() + "}.");
		} else if (ModeUse.matchMode(mode)){
			addressFind.setModeUsed(mode);
		} else {
			addressFind.setModeUsed(mode);
			addressFind.setErrorMessage("The modeUsed("+ mode +") is invalid. The value should be in the list of {" + ModeUse.getModeNames() + "}.");
		}
		
		return addressFind;
	}
	
	private AddressQuery retrieveAddressQuery(FieldSet fieldSet){
		/* get input file Header */
		ColumnPositionMappingStrategy<AddressInput> strategy=new ColumnPositionMappingStrategy<AddressInput>();
		CsvToBean<AddressInput> csvToBean = new CsvToBean<AddressInput>();
		
		strategy.setType(AddressInput.class);
	    strategy.setColumnMapping(Constant.INPUT_CSV_HEADER);
	    
	    /* Parse the CSV */
	    List<AddressInput> addresses = csvToBean.parse(strategy, new StringReader(BatchUtils.arrayToString(fieldSet.values().toArray())));
	    address =  addresses.get(0);
	    
	    /* map to AddressQuery */
		AddressQuery query = new AddressQuery();
		BeanUtils.copyProperties(address, query);
		
		return query;
	}
}
