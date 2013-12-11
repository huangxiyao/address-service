package com.hp.it.cas.match.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import com.hp.it.cas.batch.driver.pipe.Configuration;
import com.hp.it.cas.batch.driver.pipe.DelimitedLineTokenizer;
import com.hp.it.cas.batch.driver.pipe.FileDisposition;
import com.hp.it.cas.batch.driver.pipe.FileDispositionMove;
import com.hp.it.cas.batch.driver.pipe.LineMapper;
import com.hp.it.cas.batch.driver.pipe.PatternLineMapper;
import com.hp.it.cas.batch.driver.pipe.TransactionController;
import com.hp.it.cas.batch.driver.pipe.TransactionFileDriver;

public class AddressFindDriver extends TransactionFileDriver<AddressFind, Void> {
	
	private final Configuration configuration;

	public AddressFindDriver(Configuration configuration) {
		super(configuration);
		this.configuration = configuration;
	}

	@Override
	protected Pattern getBoundaryLinePattern() {
		return PatternLineMapper.MATCH_ANY_LINE;
	}

	@Override
	protected FileDisposition getFileDisposition() {
		return new FileDispositionMove(configuration);
	}

	/**
	 * 
	 */
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
