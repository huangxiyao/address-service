package com.hp.it.match.batch.AddressFindExcel;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.ExcelFileDriver;
import com.hp.it.cas.batch.driver.pipe.FileDisposition;
import com.hp.it.cas.batch.driver.pipe.FileDispositionDelete;
import com.hp.it.cas.batch.driver.pipe.RowMapper;
import com.hp.it.cas.batch.driver.pipe.RowPatternMapper;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.match.batch.AddressFindExcel.AddressFind;

/**
 * 1. Read the input file from Input FEZ folder
 * 2. Each line in the input file call AD service and get the result
 * 3. Save the input data and its result into the specified output file
 * 4. Send notification email to the specified customer of each input File
 * 5. Delete the input file from the input folder after processing
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindExcelDriver extends ExcelFileDriver<AddressFind, Void>{

	public AddressFindExcelDriver(Configuration configuration) {
		super(configuration);
	}

	@Override
	protected int getFileHeaderRowCount() {
		return 1;
	}

	@Override
	protected FileDisposition getFileDisposition() {
		return new FileDispositionDelete();
	}

	@Override
	protected RowMapper<AddressFind> getRowMapper() {
		return new RowPatternMapper<AddressFind>(getBoundaryRowPattern(), new AddressFindExcelMapper());
		
	}

	@Override
	protected Pattern getBoundaryRowPattern() {
		return RowPatternMapper.MATCH_ANY_ROW;
	}

	@Override
	protected Collection<TransactionController<AddressFind, Void>> getTransactionControllers() {
		return Collections.<TransactionController<AddressFind, Void>> singletonList(new AddressFindExcelController(getConfiguration()));
	}

}
