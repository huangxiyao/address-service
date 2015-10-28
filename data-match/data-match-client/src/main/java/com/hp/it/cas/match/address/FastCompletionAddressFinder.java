package com.hp.it.cas.match.address;

/**
 * This class is used in quick address entry applications. It allows input of
 * truncated data in several address fields and will generate suggestions for
 * this input. Due to its fast response time, the engine can also be used to
 * create suggestions while users type. The Fast Completion type is best suited
 * when users are aware that they can purposely truncate input data.
 * 
 * @author hong-bol@hp.com
 */
public interface FastCompletionAddressFinder {

	/**
	 * Find a fast completion validated address
	 * 
	 * @param query  the address query
	 * @return the address query result
	 */
	public abstract AddressQueryResult find(AddressQuery query);
}
