package com.hp.it.cas.match.batch.opencsv.bean;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.bean.BeanToCsv;

import com.hp.it.cas.match.batch.OutputRecord;

public class AddressDoctorBeanToCsv extends BeanToCsv<OutputRecord> {
	
	@Override
    protected String[] processObject(List<Method> getters, Object bean)
            throws IntrospectionException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        List<String> values = new ArrayList<String>();
        // retrieve bean values
        for (Method getter : getters) {
            Object value = getter.invoke(bean, (Object[]) null);
            if (value == null) {
                values.add("");
            } else {
                values.add(value.toString());
            }
        }
        return values.toArray(new String[0]);
    }

}
