package com.hp.it.cas.match.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.DelimitedLineTokenizer;
import com.hp.it.cas.batch.driver.pipe.FileDisposition;
import com.hp.it.cas.batch.driver.pipe.FileDispositionDelete;
import com.hp.it.cas.batch.driver.pipe.LineMapper;
import com.hp.it.cas.batch.driver.pipe.PatternLineMapper;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.cas.batch.driver.pipe.TransactionFileDriver;

/**
 * 1. Move the input file from INPUT to WIP
 * 2. Each line in the input file call AD service and got the result
 * 3. Save the query and the result in the FEZ output file
 * 4. Send notification email to specified customer of each InputFile
 * 
 * @author yu-juan.zhang@hp.com
 *
 */
public class AddressFindDriver extends TransactionFileDriver<AddressFind, Void> {
	

	public AddressFindDriver(Configuration configuration) {
		super(configuration);
	}

	@Override
	protected Pattern getBoundaryLinePattern() {
		return PatternLineMapper.MATCH_ANY_LINE;
	}

	@Override
	protected FileDisposition getFileDisposition() {
		return new FileDispositionDelete();
	}

	@Override
	protected int getFileHeaderLineCount() {
		return 1;
	}

	@Override
	protected LineMapper<AddressFind> getLineMapper() {
		return new PatternLineMapper<AddressFind>(getBoundaryLinePattern(),  new DelimitedLineTokenizer(','), 	new AddressFindMapper());
	}

	@Override
	protected Collection<TransactionController<AddressFind, Void>> getTransactionControllers() {
		return Collections.<TransactionController<AddressFind, Void>> singletonList(new AddressFindController(getConfiguration()));
	}

}
