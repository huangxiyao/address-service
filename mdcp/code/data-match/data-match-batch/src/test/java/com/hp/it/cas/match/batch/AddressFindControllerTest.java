package com.hp.it.cas.match.batch;

import com.hp.it.cas.batch.bar.BarRunner;

public class AddressFindControllerTest {

	public static void main(String[] args){
		BarRunner runner = new BarRunner();
		try {
			runner.run("src/test/resources/AddressFind.properties");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.exit(0);
		}
	}
}
