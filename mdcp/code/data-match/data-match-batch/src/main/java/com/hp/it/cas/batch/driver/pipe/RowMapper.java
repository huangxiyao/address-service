package com.hp.it.cas.batch.driver.pipe;

import javax.validation.ConstraintViolationException;

/**
 * Implementations map row to type T.
 * 
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public interface RowMapper<T> {
	/**
	 * Maps the row to the type T.
	 * 
	 * @param row
	 *            row to be mapped
	 * 
	 * @return the mapped row
	 * 
	 * @throws ConstraintViolationException
	 *             Reports results of constraint violations. The driver logs the constraint violations in the audit log.
	 */
	T mapRow(Row row) throws ConstraintViolationException;
}
