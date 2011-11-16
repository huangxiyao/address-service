package com.hp.it.cas.match.address.engine.legacy;

import java.util.ArrayList;
import java.util.List;

import com.addressdoctor.AddressDoctorException;

/**
 * This exception resolver takes address doctor exceptions and resolves them to legacy error codes.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class AddressDoctorExceptionResolver {
	private final int outputSize = 50;

	/**
	 * Turn an address doctor exception into a legacy return type with the error codes in the proper slot.
	 * 
	 * @param exception
	 *            the address doctor exception
	 * @return the result to be returned
	 */
	public List<String> resolve(AddressDoctorException exception) {
		List<String> returnValue = emptyList(outputSize);
		if (exception.getNumber() == 1500) {
			returnValue.add(23, "E272");
			returnValue.add(24, "Country is not recognized.");
		} else {
			returnValue.add(23, "E000");
			returnValue.add(24, exception.getExtendedMessage());
		}
		return returnValue;
	}

	private List<String> emptyList(int size) {
		List<String> returnList = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			returnList.add("");
		}
		return returnList;
	}
}
