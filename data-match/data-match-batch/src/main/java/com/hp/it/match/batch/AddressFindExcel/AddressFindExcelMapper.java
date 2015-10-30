package com.hp.it.match.batch.AddressFindExcel;

import javax.validation.ConstraintViolationException;

import com.hp.it.cas.batch.driver.pipe.ExcelFieldSet;
import com.hp.it.cas.batch.driver.pipe.ExcelFieldSetMapper;
import com.hp.it.match.batch.AddressFindExcel.AddressFind;
import com.hp.it.match.batch.AddressFindExcel.bean.AddressInput;
import com.hp.it.match.batch.AddressFindExcel.utilities.BatchUtils;
import com.hp.it.match.batch.AddressFindExcel.utilities.Constant;

/**
 * Mapper for AddressFind.
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindExcelMapper implements ExcelFieldSetMapper<AddressFind> {

	@Override
	public AddressFind map(ExcelFieldSet fieldSet) throws ConstraintViolationException {

		AddressFind addressFind = new AddressFind();

		/* empty data */
		if (fieldSet.size() == 0) {
			addressFind.setErrorMessage("This is an empty record.");
			return addressFind;
		}

		/* save outputFileName:InputFileName_OUTPUT.xlsx */
		if (BatchUtils.checkOutputFileName(fieldSet.getString(0))) {
			String filename = fieldSet.getString(0);
			filename = filename.substring(filename.indexOf(":") + 1, filename.length());
			addressFind.setOutputFileName(filename);
			return addressFind;
		}

		/* save the email address */
		if (BatchUtils.checkEmail(fieldSet.getString(0))) {
			addressFind.setEmailList(fieldSet.values());
			return addressFind;
		}

		/* save addressInput */
		addressFind.setAddressInput(parseInputRecord(fieldSet));

		return addressFind;
	}

	private AddressInput parseInputRecord(ExcelFieldSet fieldSet) {
		AddressInput addressInput = new AddressInput();
		int key = 0;
		for (String fieldValue : fieldSet.values()) {
			addressInput.setFieldValue(addressInput, Constant.getInputColumnNamesMap().get(key++), fieldValue);
		}
		
		return addressInput;
	}
}
