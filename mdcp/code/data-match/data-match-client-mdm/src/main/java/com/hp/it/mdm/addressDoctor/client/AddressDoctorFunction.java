package com.hp.it.mdm.addressDoctor.client;

import java.util.Map;

import org.apache.log4j.Logger;
import com.hp.it.mdm.addressDoctor.client.AddressDoctorClient;
import com.hp.it.mdm.addressDoctor.client.AddressDoctorClientPool;
import com.siperian.mrm.cleanse.api.CleanseException;
import com.siperian.mrm.cleanse.api.CleanseFunction;
import com.siperian.common.util.TypedProps;

public class AddressDoctorFunction implements CleanseFunction {
	private AddressDoctorClientPool clientPool = null;
	private static final Logger log = Logger.getLogger(AddressDoctorFunction.class);

	public AddressDoctorFunction(AddressDoctorClient client, TypedProps p) {

		clientPool = new AddressDoctorClientPool(p);
		clientPool.initPool(client);

	}

	public void cleanse(Map context, Map input, Map output)
	throws CleanseException {

		AddressDoctorClient client = null;
		try {
			client = clientPool.borrowClient();
		} catch (Exception e) {
			throw new RuntimeException(
					"Could not borrow client from pool execption was " + e);
		}

		try {
			client.cleanse(context, input, output);

		} finally { // should anything go wrong, the client always needs be
			// returned
			try {
				clientPool.returnClient(client);
			} catch (Exception e) {
				throw new RuntimeException("Could not return client to pool exception was " + e);
			}
		}
	}
}
