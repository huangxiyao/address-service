package com.hp.it.cas.batch.driver.pipe;

import javax.validation.ConstraintViolationException;

/**
 * Implementations maps field to type T.
 * 
 * @author hugh.mckee@hp.com
 * @author hong-bol@hp.com
 */
public interface ExcelFieldSetMapper<T> {
	/**
	 * Maps the field set to type T.
	 * 
	 * @param fieldSet
	 *            the field set to be mapped
	 * 
	 * @return the mapped type T
	 * 
	 * @throws ConstraintViolationException
	 *             Reports results of constraint violations. The driver logs the constraint violations in the audit log.
	 */
	T map(ExcelFieldSet fieldSet) throws ConstraintViolationException;
}
