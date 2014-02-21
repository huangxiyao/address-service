package com.hp.it.cas.batch.driver.pipe;

import java.text.DateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.hp.it.cas.xa.lang.StringUtils;

/**
 * The Excel utils class has some common utility routines for Excels.
 * 
 * @author hong-bol@hp.com
 */
public class ExcelUtil {
	/**
	 * A default delimiter with a space
	 */
	public static String DEFAULT_DELIMITER = " ";

	/**
	 * Get the cell representing a given column (logical cell) 0-based. If you ask for a cell that is not defined or the
	 * row is null....you get a null cell.
	 * 
	 * @param row
	 *            the excel row contains the cells needed
	 * @param index
	 *            0 based index number
	 * 
	 * @return Cell representing that column or null if undefined or the row is null
	 */
	public static Cell getCell(Row row, int index) {
		return row == null ? null : row.getCell(index);
	}

	/**
	 * Get the value of the given cell as a string.
	 * 
	 * @param cell
	 *            the cell contains the value
	 * @return the string value of the cell
	 */
	public static String getStringFromCell(Cell cell) {
		if (cell == null) {
			return StringUtils.EMPTY;
		}
		return getStringFromCell(cell, cell.getCellType() == Cell.CELL_TYPE_FORMULA ? cell.getCachedFormulaResultType()
				: cell.getCellType());
	}

	/**
	 * Get the value of the given cell as a string base on cell type.
	 * 
	 * @param cell
	 *            the cell contains the value
	 * @param cellType
	 *            the cell type, value should be in ({@link Cell#CELL_TYPE_NUMERIC}, {@link Cell#CELL_TYPE_STRING},
	 *            {@link Cell#CELL_TYPE_FORMULA}, {@link Cell#CELL_TYPE_BLANK}, {@link Cell#CELL_TYPE_BOOLEAN} ,
	 *            {@link Cell#CELL_TYPE_ERROR })
	 * @return the string value of the cell
	 */
	public static String getStringFromCell(Cell cell, int cellType) {
		if (cell == null) {
			return StringUtils.EMPTY;
		}
		String value = null;
		switch (cellType) {
		case Cell.CELL_TYPE_NUMERIC:
			value = DateUtil.isCellDateFormatted(cell) ? DateFormat.getInstance().format(cell.getDateCellValue())
					: NumberToTextConverter.toText(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_FORMULA:
			value = getStringFromCell(cell, cell.getCachedFormulaResultType());
			break;
		case Cell.CELL_TYPE_BLANK:
			value = StringUtils.EMPTY;
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			value = String.valueOf(cell.getErrorCellValue());
			break;
		default:
			value = StringUtils.EMPTY;
			break;
		}
		return value;
	}

	/**
	 * Get the all the cell values in the row and concat all the values as a String with the given delimiter.
	 * 
	 * @param row
	 *            the row contains all the cells value
	 * @param delimiter
	 *            the delimiter used to separate the cell values
	 * @return the cell values string
	 */
	public static String getRowValuesAsString(Row row, String delimiter) {
		if (row == null) {
			return StringUtils.EMPTY;
		}
		delimiter = delimiter == null ? DEFAULT_DELIMITER : delimiter;

		StringBuffer values = new StringBuffer("");
		Iterator<Cell> cellIterator = row.iterator();
		while (cellIterator.hasNext()) {
			Cell cell = (Cell) cellIterator.next();
			values.append(ExcelUtil.getStringFromCell(cell));
			if (cell.getColumnIndex() != row.getLastCellNum() - 1) {
				values.append(delimiter);
			}
		}
		return values.toString();
	}
}
