package com.hp.it.cas.match.address;

/**
 * Fielded address component.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class AddressElement {
	private String type;
	private String value;

	/**
	 * Construct a fielded address component from a type and value.
	 * 
	 * @param type
	 *            a type
	 * @param value
	 *            a value
	 */
	public AddressElement(String type, String value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * Returns a type.
	 * 
	 * @return a type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the address component type.
	 * 
	 * @param type
	 *            the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the value of the address component.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the address component to the value passed.
	 * 
	 * @param value
	 *            the value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
