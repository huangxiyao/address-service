package com.hp.it.cas.batch.driver.pipe;

import com.hp.it.cas.foundation.pipe.AbstractPipe;

import javax.validation.constraints.NotNull;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * Takes {@link Row Row} and gives type T.
 * 
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public class RowMapperPipe<T> extends AbstractPipe<Row, T> {
	private final RowMapper<T> rowMapper;
	private final Pattern boundaryRowPattern;
	private Row nextRow;

	/**
	 * Creates a new RowMapperPipe object.
	 * 
	 * @param rowMapper
	 *            the row mapper
	 * @param boundaryRowPattern
	 *            the boundary row pattern
	 * 
	 * @throws IllegalArgumentException
	 *             if rowMapper or boundaryRowPattern are invalid
	 */
	public RowMapperPipe(@NotNull RowMapper<T> rowMapper, @NotNull Pattern boundaryRowPattern) {
		if (rowMapper == null) {
			throw new IllegalArgumentException("rowMapper cannot be null.");
		}

		if (boundaryRowPattern == null) {
			throw new IllegalArgumentException("boundaryLinePattern cannot by null.");
		}

		this.rowMapper = rowMapper;
		this.boundaryRowPattern = boundaryRowPattern;
	}

	@Override
	protected T processNextStart() throws NoSuchElementException {
		T mappedRows = rowMapper.mapRow(nextRow());

		while (!isBoundaryRow()) {
			mappedRows = rowMapper.mapRow(nextRow());
		}

		return mappedRows;
	}

	/**
	 * Gets the next row.
	 * 
	 * @return the next row
	 */
	private Row nextRow() {
		Row row = (nextRow == null) ? getStarts().next() : nextRow;

		try {
			nextRow = getStarts().next();
		} catch (NoSuchElementException e) {
			nextRow = null;
		}

		return row;
	}

	/**
	 * Gets the boundary row.
	 * 
	 * @return the boundary row
	 */
	private boolean isBoundaryRow() {
		return nextRow == null
				|| boundaryRowPattern.matcher(
						ExcelUtil.getRowValuesAsString(nextRow.getRowValue(), ExcelUtil.DEFAULT_DELIMITER)).find();
	}
}
