package com.hp.it.cas.batch.driver.pipe;

import com.hp.it.cas.foundation.pipe.AbstractPipe;
import com.hp.it.cas.foundation.pipe.Pipe;
import com.hp.it.cas.foundation.pipe.Pipeline;
import com.hp.it.cas.foundation.pipe.SingleIterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

import java.util.NoSuchElementException;

/**
 * Takes InputStream and gives {@link Row}. The InputStream is used by {@link OPCPackage} to retrieve the
 * {@link XSSFWorkbook}, then loop all the {@link XSSFSheet} in {@link XSSFWorkbook}. For each {@link XSSFSheet},
 * retrieve each {@link XSSFRow}, gives {@link Row} cantains {@link XSSFRow}.
 * 
 * @author quintin.may@hp.com
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public class RowReaderPipe extends AbstractPipe<InputStream, Row> {
	private Pipe<XSSFWorkbook, Row> pipe;

	OPCPackage opcPackage;
	XSSFWorkbook xssfWorkbook;
	int headerRowCount;

	/**
	 * Creates a new RowReaderPipe object.
	 * 
	 * @param headerRowCount
	 *            the number of header rows to be skipped in each file and each sheet
	 */
	public RowReaderPipe(int headerRowCount) {
		this.headerRowCount = headerRowCount;
	}

	@Override
	protected Row processNextStart() throws NoSuchElementException {
		try {
			while (true) {
				if (xssfWorkbook == null) {
					openOPCPackage(getStarts().next());
					initialPipeLine();
				}

				try {
					return pipe.next();
				} catch (NoSuchElementException e) {
					closeOPCPackage();
				}
			}
		} catch (RuntimeException e) {
			closeOPCPackage();
			throw e;
		}
	}

	/**
	 * Initial pipe line with SheetPipe and RowPipe.
	 * 
	 */
	private void initialPipeLine() {
		pipe = new Pipeline<XSSFWorkbook, Row>(new SheetPipe(), new RowPipe(headerRowCount));
		pipe.setStarts(new SingleIterator<XSSFWorkbook>(xssfWorkbook));
	}

	/**
	 * Open a package with the inputStream.
	 * 
	 * @param inputStream
	 *            the InputStream to read the package from
	 */
	private void openOPCPackage(InputStream inputStream) {
		try {
			opcPackage = OPCPackage.open(inputStream);
			xssfWorkbook = new XSSFWorkbook(opcPackage);
		} catch (InvalidFormatException e) {
			throw new TunnelledException(e);
		} catch (IOException e) {
			throw new TunnelledException(e);
		}
	}

	/**
	 * Close the package.
	 */
	private void closeOPCPackage() {
		try {
			if (opcPackage != null) {
				opcPackage.close();
			}
		} catch (IOException e) {
			throw new TunnelledException(e);
		} finally {
			xssfWorkbook = null;
		}
	}

	class RowPipe extends AbstractPipe<XSSFSheet, Row> {
		private final int headerRowCount;
		private XSSFSheet xssfSheet;
		private int previousRow;

		/**
		 * Creates a new RowPipe object.
		 * 
		 * @param headerRowCount
		 *            the number of header rows to be skipped in each sheet
		 */
		public RowPipe(int headerRowCount) {
			this.headerRowCount = headerRowCount;
		}

		/**
		 * Skips the file header rows.
		 */
		private void skipFileHeaderRows() {
			previousRow = headerRowCount;
		}

		@Override
		protected Row processNextStart() throws NoSuchElementException {
			try {
				while (true) {
					if (xssfSheet == null) {
						xssfSheet = getStarts().next();
						skipFileHeaderRows();
					}

					try {
						XSSFRow xssfRow = readRow();
						return new Row(previousRow - 1, xssfRow);
					} catch (NoSuchElementException e) {
						xssfSheet = null;
					}
				}
			} catch (RuntimeException e) {
				xssfSheet = null;
				throw e;
			}
		}

		/**
		 * Reads a row from the input stream.
		 * 
		 * @return the xssf row
		 * 
		 */
		XSSFRow readRow() {
			XSSFRow xssfRow = xssfSheet.getRow(previousRow++);
			if (xssfRow == null && previousRow > xssfSheet.getLastRowNum()) {
				throw new NoSuchElementException();
			}
			return xssfRow;
		}
	}

	class SheetPipe extends AbstractPipe<XSSFWorkbook, XSSFSheet> {
		private XSSFWorkbook xssfWorkbook;
		private int previousSheet = 0;

		@Override
		protected XSSFSheet processNextStart() throws NoSuchElementException {
			try {
				while (true) {
					if (xssfWorkbook == null) {
						xssfWorkbook = getStarts().next();
					}

					try {
						return xssfWorkbook.getSheetAt(previousSheet++);
					} catch (IllegalArgumentException e) {
						xssfWorkbook = null;
					}
				}
			} catch (RuntimeException e) {
				xssfWorkbook = null;
				throw e;
			}
		}
	}
}
