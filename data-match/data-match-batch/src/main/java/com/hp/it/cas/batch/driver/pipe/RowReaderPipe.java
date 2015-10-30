package com.hp.it.cas.batch.driver.pipe;

import com.hp.it.cas.foundation.pipe.AbstractPipe;
import com.hp.it.cas.foundation.pipe.EmptyIterator;
import com.hp.it.cas.foundation.pipe.Pipe;
import com.hp.it.cas.foundation.pipe.Pipeline;
import com.hp.it.cas.foundation.pipe.SingleIterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

import java.util.NoSuchElementException;

/**
 * Takes OPCPackage and gives {@link Row}. The {@link OPCPackage} is used to retrieve the {@link XSSFWorkbook}, then
 * loop all the {@link XSSFSheet} in {@link XSSFWorkbook}. For each {@link XSSFSheet}, retrieve each {@link XSSFRow},
 * gives {@link Row} cantains {@link XSSFRow}.
 * 
 * @author quintin.may@hp.com
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public class RowReaderPipe extends AbstractPipe<OPCPackage, Row> {
	private Pipe<XSSFWorkbook, Row> pipe;

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
					openWorkbook(getStarts().next());
					initialPipeLine();
				}

				try {
					return pipe.next();
				} catch (NoSuchElementException e) {
					xssfWorkbook = null;
				}
			}
		} catch (RuntimeException e) {
			xssfWorkbook = null;
			throw e;
		}
	}

	/**
	 * Initial pipe line with SheetPipe and RowPipe.
	 * 
	 */
	private void initialPipeLine() {
		pipe = new Pipeline<XSSFWorkbook, Row>(new SheetPipe(), new RowPipe(headerRowCount));
		pipe.setStarts(xssfWorkbook == null ? new EmptyIterator<XSSFWorkbook>() : new SingleIterator<XSSFWorkbook>(xssfWorkbook));
	}

	/**
	 * Open XSSFWorkbook with opcPackage.
	 * 
	 * @param opcPackage {@link OPCPackage}
	 */
	private void openWorkbook(OPCPackage opcPackage) {	
		try {
			xssfWorkbook = opcPackage == null ? null : new XSSFWorkbook(opcPackage);
		} catch (IOException e) {
			throw new TunnelledException(e);
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
