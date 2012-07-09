package com.hp.it.cas.match.address;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.ValidatedAddressFinderImpl;

public class AddressFinderTest {
	private static AddressDoctorEngine engine;
	private ValidatedAddressFinder finder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		engine = AddressDoctorEngine.INSTANCE;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		engine.shutdown();
	}

	@Before
	public void setUp() throws Exception {
		finder = new ValidatedAddressFinderImpl(true);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAddressUsingQuery() {
		AddressQuery query = new AddressQuery();
		query.setDeliveryAddressLine1("12410 TAYLORWOOD LN");
		query.setLocality1("Houston");
		query.setProvince1("TX");
		query.setPostalCode1("77070");
		query.setCountry1("US");
		System.out.println(finder.find(query));
	}
}
