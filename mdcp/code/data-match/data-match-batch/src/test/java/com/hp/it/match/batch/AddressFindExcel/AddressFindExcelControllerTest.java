package com.hp.it.match.batch.AddressFindExcel;

import com.hp.it.cas.batch.bar.BarRunner;

public class AddressFindExcelControllerTest {
	public static void main(String[] args) {
		BarRunner runner = new BarRunner();
		try {
			runner.run("src/test/resources/AddressFindExcel.properties");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
