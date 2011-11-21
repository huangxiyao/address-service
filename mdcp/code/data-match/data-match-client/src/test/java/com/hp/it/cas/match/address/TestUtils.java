package com.hp.it.cas.match.address;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.ConstraintDescriptor;

import org.junit.Ignore;

import junit.framework.Assert;

@Ignore
public class TestUtils {
	
	public static void assertIncludes(Set<ConstraintViolation<AddressQuery>> violations, String messageTemplate ){
		boolean includesTemplate = false;
		
		for (ConstraintViolation<AddressQuery> constraintViolation : violations) {
			if(messageTemplate.equals(constraintViolation.getMessageTemplate())){
				includesTemplate = true;
			}
		}
		
		Assert.assertTrue(String.format("Expected '%s' template.", messageTemplate), includesTemplate);
	}
	
	public static void assertIncludes(Set<ConstraintViolation<AddressQuery>> violations, String messageTemplate, String propertyPath){
		boolean includesViolation = false;
		
		for (ConstraintViolation<AddressQuery> constraintViolation : violations) {
			if(messageTemplate.equals(constraintViolation.getMessageTemplate()) && propertyPath.equals(constraintViolation.getPropertyPath().toString())){				
				includesViolation = true;
			}
		}
		
		Assert.assertTrue(String.format("Expected '%s' template against propertyPath '%s'.", messageTemplate, propertyPath), includesViolation);
	}
	
	public static void assertIncludes(Set<ConstraintViolation<AddressQuery>> violations, String messageTemplate, String propertyPath, String attribute1, String attribute2){
		boolean includesViolation = false;
		
		for (ConstraintViolation<AddressQuery> constraintViolation : violations) {
			if(messageTemplate.equals(constraintViolation.getMessageTemplate()) && propertyPath.equals(constraintViolation.getPropertyPath().toString())){
				ConstraintDescriptor<?> descriptor = constraintViolation.getConstraintDescriptor();
				Map<String, Object> attributes = descriptor.getAttributes();
				
				if(attributes.get("attribute1") == attribute1 && attributes.get("attribute2") == attribute2 ){
					includesViolation = true;
				}			
			}
		}
		
		Assert.assertTrue(String.format("Expected '%s' template against propertyPath '%s' with attributes '%s' and '%s'.", messageTemplate, propertyPath, attribute1, attribute2), includesViolation);
	}

}
