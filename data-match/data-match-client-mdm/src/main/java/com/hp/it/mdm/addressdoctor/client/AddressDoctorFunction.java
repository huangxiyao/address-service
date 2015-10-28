package com.hp.it.mdm.addressdoctor.client;

import java.util.Map;

import org.apache.log4j.Logger;

import com.siperian.common.util.TypedProps;
import com.siperian.mrm.cleanse.api.CleanseException;
import com.siperian.mrm.cleanse.api.CleanseFunction;

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
			long startTime = System.currentTimeMillis();
			client.cleanse(context, input, output);
			long endTime = System.currentTimeMillis();
            long doAllCleanseTime = endTime - startTime;
            printTimeInfo(doAllCleanseTime,1);//numCalls value is 1 due to only one record executed each time in hub cleanse
		} finally { // should anything go wrong, the client always needs be
			// returned
			try {
				clientPool.returnClient(client);
			} catch (Exception e) {
				throw new RuntimeException("Could not return client to pool exception was " + e);
			}
		}
	}
	
	/** Prints the timing information */
	private void printTimeInfo(long totalTime, int numCalls) {
		long timePerCall;
		System.out.println("Time to cleanse " + numCalls + " records: "
				+ totalTime + " ms");
		if (numCalls == 0)
			timePerCall = 0;
		else
			timePerCall = totalTime / numCalls;

		System.out.println("Time per record: " + timePerCall + " ms");
	}
}
