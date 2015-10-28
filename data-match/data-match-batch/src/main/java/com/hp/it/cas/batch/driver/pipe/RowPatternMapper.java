package com.hp.it.cas.batch.driver.pipe;

import javax.validation.ConstraintViolationException;
import java.util.regex.Pattern;

/**
 * For a given row, if the row pattern matches the row, map the row fields to type T. If the pattern does not match the
 * {@link #mapRow(Row)} return null.
 * 
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public class RowPatternMapper<T> implements RowMapper<T> {
	/**
	 * A pattern that matches any row.
	 */
	public static final Pattern MATCH_ANY_ROW = Pattern.compile("");

	private final Pattern rowPattern;
	private final ExcelFieldSetMapper<T> mapper;

	/**
	 * Creates a new RowPatternMapper object.
	 * 
	 * @param rowPattern
	 *            the row pattern
	 * @param mapper
	 *            the row mapper
	 */
	public RowPatternMapper(Pattern rowPattern, ExcelFieldSetMapper<T> mapper) {
		this.rowPattern = rowPattern;
		this.mapper = mapper;
	}

	@Override
	public T mapRow(Row row) throws ConstraintViolationException {
		return row == null ? null : rowPattern.matcher(
				ExcelUtil.getRowValuesAsString(row.getRowValue(), ExcelUtil.DEFAULT_DELIMITER)).find() ? mapper
				.map(new ExcelFieldSet(row.getRowValue())) : null;
	}
}