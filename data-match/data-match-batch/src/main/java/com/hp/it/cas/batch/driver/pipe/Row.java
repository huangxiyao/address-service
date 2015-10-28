package com.hp.it.cas.batch.driver.pipe;

import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * A numbered row of value.
 * 
 * @author quintin.may@hp.com
 * @author hong-bol@hp.com
 */
public class Row {
	private final Integer number;
	private final XSSFRow rowValue;

	/**
	 * Creates a new row object.
	 * 
	 * @param number
	 *            the row number
	 * @param rowValue
	 *            the row value
	 */
	Row(Integer number, XSSFRow rowValue) {
		this.number = number;
		this.rowValue = rowValue;
	}

	/**
	 * Gets the number.
	 * 
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Gets the row value.
	 * 
	 * @return the row value
	 */
	public XSSFRow getRowValue() {
		return rowValue;
	}

	@Override
	public String toString() {
		return String.format("%s[%,d, %s]", getClass().getSimpleName(), number, rowValue);
	}
}
