package com.hp.it.cas.batch.driver.pipe;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * Excel FieldSet used to encapsulate concerns of converting {@link XSSFRow} to Java native types. A bit like the role
 * played by {@link ResultSet} in JDBC, clients will know the name or position of strongly typed fields that they want
 * to extract.
 * 
 * @author hong-bol@hp.com
 * 
 */
public class ExcelFieldSet {
	private static final List<String> NO_STRINGS = Arrays.asList();

	private final List<String> values;
	private final List<String> names;
	private final Map<String, Integer> nameIndices = new HashMap<String, Integer>();
	private final AtomicReference<Map<String, String>> map = new AtomicReference<Map<String, String>>();

	public ExcelFieldSet(XSSFRow row) {
		this(row, null);
	}

	public ExcelFieldSet(XSSFRow row, List<String> names) {
		this.values = retrieveXSSFRow(row);
		this.names = names == null ? NO_STRINGS : names;
		for (int i = 0, ii = this.names.size(); i < ii; ++i) {
			String name = this.names.get(i);
			if (nameIndices.containsKey(name)) {
				throw new IllegalArgumentException(String.format("Name '%s' occurs more than once in %s.", name, names));
			}
			nameIndices.put(name, i);
		}
	}

	private List<String> retrieveXSSFRow(XSSFRow row) {
		if (row == null) {
			return NO_STRINGS;
		}

		List<String> values = new ArrayList<String>();
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = (Cell) row.getCell(i, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			values.add(ExcelUtil.getStringFromCell(cell));
		}

		return values;
	}

	/**
	 * 
	 * @return the size of field set values
	 */
	public int size() {
		return values.size();
	}

	/**
	 * @return the names of fields
	 */
	public List<String> names() {
		return names;
	}

	/**
	 * Convert values from List to Map. Key is from names list and value is from values list.
	 * 
	 * @return the map
	 */
	public Map<String, String> asMap() {
		if (map.get() == null) {
			synchronized (map) {
				if (map.get() == null) {
					Map<String, String> map = new LinkedHashMap<String, String>();
					this.map.set(Collections.unmodifiableMap(map));

					for (int i = 0, ii = names.size(); i < ii; ++i) {
						String value = readAndTrim(i);
						if (!"".equals(value)) {
							map.put(names.get(i), value);
						}
					}
				}
			}
		}

		return map.get();
	}

	/**
	 * @return the field set values
	 */
	public List<String> values() {
		return values;
	}

	/**
	 * Read the {@link java.math.BigDecimal} value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return BigDecimal value
	 */
	public BigDecimal getBigDecimal(int index) {
		return new BigDecimal(readAndTrim(index));
	}

	/**
	 * Read the {@link BigDecimal} value at index '<code>index</code>', returning the supplied <code>defaultValue</code>
	 * if the trimmed string value at index '<code>index</code>' is blank.
	 * 
	 * @param index
	 *            the field index.
	 * @param defaultValue
	 *            the default BigDecimal value
	 * @return BigDecimal value
	 */
	public BigDecimal getBigDecimal(int index, BigDecimal defaultValue) {
		String value = readAndTrim(index);
		return "".equals(value) ? defaultValue : new BigDecimal(value);
	}

	/**
	 * Read the {@link java.math.BigDecimal} value from column with given '<code>name</code>.
	 * 
	 * @param name
	 *            the field name.
	 * @return BigDecimal value
	 */
	public BigDecimal getBigDecimal(String name) {
		return getBigDecimal(indexOf(name));
	}

	/**
	 * Read the {@link BigDecimal} value from column with given '<code>name</code>, returning the supplied
	 * <code>defaultValue</code> if the trimmed string value at index '<code>index</code>' is blank.
	 * 
	 * @param name
	 *            the field name.
	 * @param defaultValue
	 *            the default BigDecimal value
	 * @return BigDecimal value
	 */
	public BigDecimal getBigDecimal(String name, BigDecimal defaultValue) {
		return getBigDecimal(indexOf(name), defaultValue);
	}

	/**
	 * Read the '<code>boolean</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return Boolean value
	 */
	public Boolean getBoolean(int index) {
		return Boolean.valueOf(readAndTrim(index));
	}

	/**
	 * Read the '<code>boolean</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @param trueValue
	 *            the value that signifies {@link Boolean#TRUE true}; case-sensitive.
	 * @return Boolean value
	 */
	public Boolean getBoolean(int index, String trueValue) {
		String value = readAndTrim(index);
		return value.equals(trueValue);
	}

	/**
	 * Read the '<code>boolean</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name.
	 * @return Boolean value
	 */
	public Boolean getBoolean(String name) {
		return getBoolean(indexOf(name));
	}

	/**
	 * Read the '<code>boolean</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name.
	 * @param trueValue
	 *            trueValue the value that signifies {@link Boolean#TRUE true}; case-sensitive.
	 * @return Boolean value
	 */
	public Boolean getBoolean(String name, String trueValue) {
		return getBoolean(indexOf(name), trueValue);
	}

	/**
	 * Read the '<code>byte</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return byte value
	 */
	public byte getByte(int index) {
		return Byte.valueOf(readAndTrim(index));
	}

	/**
	 * Read the '<code>byte</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name.
	 * @return byte value
	 */
	public byte getByte(String name) {
		return getByte(indexOf(name));
	}

	/**
	 * Read the '<code>char</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return char value
	 */
	public char getChar(int index) {
		String value = readAndTrim(index);
		return value.charAt(0);
	}

	/**
	 * Read the '<code>char</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name.
	 * @return char value
	 */
	public char getChar(String name) {
		return getChar(indexOf(name));
	}

	/**
	 * Read the <code>java.util.Date</code> value in given format at designated column <code>index</code>.
	 * 
	 * @param index
	 *            the field index.
	 * @param format
	 *            date format
	 * @return Date value
	 */
	private Date getDate(int index, DateFormat format) {
		Date date = null;
		try {
			date = format.parse(readAndTrim(index));
		} catch (ParseException e) {
			throw new ExcelFieldSetParseException(String.format("Unable to parse date text '%s' using format '%s'.",
					format), e);
		}
		return date;
	}

	/**
	 * Read the <code>java.util.Date</code> value in default DateFormat at designated column <code>index</code>.
	 * 
	 * @param index
	 *            the field index.
	 * @return Date value
	 */
	public Date getDate(int index) {
		return getDate(index, DateFormat.getInstance());
	}

	/**
	 * Read the <code>java.util.Date</code> value in SimpleDateFormat with given pattern at designated column
	 * <code>index</code>.
	 * 
	 * @param index
	 *            the field index.
	 * @param pattern
	 *            the pattern describing the date and time format
	 * @return Date value
	 */
	public Date getDate(int index, String pattern) {
		return getDate(index, new SimpleDateFormat(pattern));
	}

	/**
	 * Read the <code>java.util.Date</code> value in given format from column with given <code>name</code>.
	 * 
	 * @param name
	 *            the field name
	 * @return Date value
	 */
	public Date getDate(String name) {
		return getDate(indexOf(name));
	}

	/**
	 * Read the <code>java.util.Date</code> value in SimpleDateFormat with given pattern from column with given
	 * <code>name</code>.
	 * 
	 * @param name
	 *            the field name
	 * @param pattern
	 *            the pattern describing the date and time format
	 * @return Date value
	 */
	public Date getDate(String name, String pattern) {
		return getDate(indexOf(name), pattern);
	}

	/**
	 * Read the '<code>double</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return double value
	 */
	public double getDouble(int index) {
		return Double.valueOf(readAndTrim(index));
	}

	/**
	 * Read the '<code>double</code>' value from column with given '<code>name</code>.
	 * 
	 * @param name
	 *            the field name.
	 * @return double value
	 */
	public double getDouble(String name) {
		return getDouble(indexOf(name));
	}

	/**
	 * Read the '<code>float</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return float value
	 */
	public float getFloat(int index) {
		return Float.valueOf(readAndTrim(index));
	}

	/**
	 * Read the '<code>float</code>' value from column with given '<code>name</code>.
	 * 
	 * @param name
	 *            the field name.
	 * @return float value
	 */
	public float getFloat(String name) {
		return getFloat(indexOf(name));
	}

	/**
	 * Read the '<code>int</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return int value
	 */
	public int getInt(int index) {
		return Integer.valueOf(readAndTrim(index));
	}

	/**
	 * Read the '<code>int</code>' value at index '<code>index</code>', using the supplied <code>defaultValue</code> if
	 * the field value is blank.
	 * 
	 * @param index
	 *            the field index.
	 * @param defaultValue
	 *            default int value
	 * @return int value
	 */
	public int getInt(int index, int defaultValue) {
		String value = readAndTrim(index);
		return "".equals(value) ? defaultValue : Integer.parseInt(value);
	}

	/**
	 * Read the '<code>int</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name
	 * @return int value
	 */
	public int getInt(String name) {
		return getInt(indexOf(name));
	}

	/**
	 * Read the '<code>int</code>' value from column with given '<code>name</code>', using the supplied
	 * <code>defaultValue</code> if the field value is blank.
	 * 
	 * @param name
	 *            the field name
	 * @param defaultValue
	 *            default int value
	 * @return int value
	 */
	public int getInt(String name, int defaultValue) {
		return getInt(indexOf(name), defaultValue);
	}

	/**
	 * Read the '<code>long</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return long value
	 */
	public long getLong(int index) {
		return Long.parseLong(readAndTrim(index));
	}

	/**
	 * Read the '<code>long</code>' value at index '<code>index</code>', using the supplied <code>defaultValue</code> if
	 * the field value is blank.
	 * 
	 * @param index
	 *            the field index.
	 * @param defaultValue
	 *            default long value
	 * @return long value
	 */
	public long getLong(int index, long defaultValue) {
		String value = readAndTrim(index);
		return "".equals(value) ? defaultValue : Long.parseLong(value);
	}

	/**
	 * Read the '<code>long</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name
	 * @return long value
	 */
	public long getLong(String name) {
		return getLong(indexOf(name));
	}

	/**
	 * Read the '<code>long</code>' value from column with given '<code>name</code>', using the supplied
	 * <code>defaultValue</code> if the field value is blank.
	 * 
	 * @param name
	 *            the field name
	 * @param defaultValue
	 *            default long value
	 * @return long value
	 */
	public long getLong(String name, long defaultValue) {
		return getLong(indexOf(name), defaultValue);
	}

	/**
	 * Read the {@link String} value at index '<code>index</code>' including trailing whitespace (don't trim).
	 * 
	 * @param index
	 *            the field index.
	 * @return string value
	 */
	public String getRawString(int index) {
		return values.get(index);
	}

	/**
	 * Read the {@link String} value from column with given '<code>name</code>' including trailing whitespace (don't
	 * trim).
	 * 
	 * @param name
	 *            the field name
	 * @return string value
	 */
	public String getRawString(String name) {
		return getRawString(indexOf(name));
	}

	/**
	 * Read the '<code>short</code>' value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return short value
	 */
	public short getShort(int index) {
		return Short.parseShort(readAndTrim(index));
	}

	/**
	 * Read the '<code>short</code>' value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name
	 * @return short value
	 */
	public short getShort(String name) {
		return getShort(indexOf(name));
	}

	/**
	 * Read the {@link String} value at index '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index.
	 * @return string value
	 */
	public String getString(int index) {
		return readAndTrim(index);
	}

	/**
	 * Read the {@link String} value from column with given '<code>name</code>'.
	 * 
	 * @param name
	 *            the field name
	 * @return string value
	 */
	public String getString(String name) {
		return getString(indexOf(name));
	}

	/**
	 * Read and trim the {@link String} value at '<code>index</code>'.
	 * 
	 * @param index
	 *            the field index
	 * @return null if the field value is <code>null</code>.
	 */
	protected String readAndTrim(int index) {
		return getRawString(index).trim();
	}

	/**
	 * Get the index with given ' <code>name</code>.
	 * 
	 * @param name
	 *            the field name
	 * @return the field index
	 */
	protected int indexOf(String name) {
		Integer index = nameIndices.get(name);
		if (index == null) {
			throw new IllegalArgumentException(String.format("'%s' is not a valid name.", name));
		}
		return index;
	}

	@Override
	public String toString() {
		return String.format("%s[%s]", getClass().getSimpleName(), (names == null) ? values : asMap());
	}

	public static class ExcelFieldSetParseException extends RuntimeException {

		private static final long serialVersionUID = 6429148528667398480L;

		public ExcelFieldSetParseException(String message, Throwable throwable) {
			super(message, throwable);
		}
	}
}
