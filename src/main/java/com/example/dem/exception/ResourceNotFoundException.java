package com.example.dem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)// cause Spring boot to respond with the specified
// Http status code whenever this exception is thrown form your controller.
public class ResourceNotFoundException {

	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Long getFieldValue() {
		return fieldValue;
	}
	
}
