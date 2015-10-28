package com.hp.it.cas.batch.driver.pipe;

import java.beans.PropertyEditorSupport;

/**
 * Property editor for {@link Row} row numbers.
 * 
 * @author quintin.may@hp.com
 * @author hong-bol@hp.com
 */
class RowNumberPropertyEditor extends PropertyEditorSupport {
	@Override
	public String getAsText() {
		Integer value = (Integer) getValue();

		return (value == null) ? null : value.toString();
	}

	@Override
	public void setValue(Object value) {
		super.setValue((value == null) ? null : ((Row) value).getNumber());
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null) {
			setValue(null);
		} else {
			setValue(Integer.valueOf(text));
		}
	}
}
