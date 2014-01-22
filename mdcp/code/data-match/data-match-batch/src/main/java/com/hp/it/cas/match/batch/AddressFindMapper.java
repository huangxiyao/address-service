package com.hp.it.cas.match.batch;

import java.io.StringReader;
import java.util.List;

import javax.validation.ConstraintViolationException;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.hp.it.cas.batch.driver.pipe.FieldSet;
import com.hp.it.cas.batch.driver.pipe.FieldSetMapper;
import com.hp.it.cas.match.batch.utilities.BatchUtils;
import com.hp.it.cas.match.batch.utilities.Constant;

/**
 * Mapper for AddressFind.
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindMapper implements FieldSetMapper<AddressFind>{
	
	@Override
	public AddressFind map(FieldSet fieldSet) throws ConstraintViolationException {
		AddressFind addressFind = new AddressFind();
		
		/* empty data */
		if (fieldSet.size() == 0) {
			addressFind.setErrorMessage("This is an empty record.");
			return addressFind;
		}
		
		/* save outputFileName:InputFileName_OUTPUT.csv or "outputFileName:filename,withcomma_OUTPUT.csv"*/
		if (BatchUtils.checkOutputFileName(fieldSet.getString(0))){
			String filename = fieldSet.getString(0);
			if (filename.endsWith("\"")) {
				filename = filename.substring(filename.indexOf(":") + 1, filename.length()-1);
			} else {
				filename = filename.substring(filename.indexOf(":") + 1, filename.length());
			}
			addressFind.setOutputFileName(filename);
			return addressFind;
		}
		
		/* save the email */
		if (BatchUtils.checkEmail(fieldSet.getString(0))){
			addressFind.setEmailList(fieldSet.values());
			return addressFind;
		}
			
		/* save addressInput */
		addressFind.setAddressInput(parseInputCsvFile(fieldSet));
		
		return addressFind;
	}
	
	private AddressInput parseInputCsvFile(FieldSet fieldSet){
		/* get input file Header */
		ColumnPositionMappingStrategy<AddressInput> strategy=new ColumnPositionMappingStrategy<AddressInput>();
		CsvToBean<AddressInput> csvToBean = new CsvToBean<AddressInput>();
		
		strategy.setType(AddressInput.class);
	    strategy.setColumnMapping(Constant.INPUT_CSV_HEADER);
	    
	    /* Parse the CSV */
	    List<AddressInput> addressInputList = csvToBean.parse(strategy, new StringReader(BatchUtils.arrayToString(fieldSet.values().toArray())));
	  	return addressInputList.get(0);
	}
}
