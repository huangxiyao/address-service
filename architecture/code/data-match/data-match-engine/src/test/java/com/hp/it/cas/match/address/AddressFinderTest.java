package com.hp.it.cas.match.address;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.match.address.engine.AddressDoctorEngine;
import com.hp.it.cas.match.address.engine.AddressFinder;

@Ignore
public class AddressFinderTest {
	private static AddressDoctorEngine engine;
	private IAddressFinder finder;

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
		finder = new AddressFinder(true);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAddressUsingQuery() {
		AddressQuery query = new AddressQuery();
		query.setDeliveryAddressLine1("Riverhaven Drive");
		query.setLocality1("Suwanee");
		query.setProvince1("GA");
		query.setPostalCode1("30024");
		query.setCountry1("US");
		System.out.println(finder.findAddressSuggestions(query));
	}
}
