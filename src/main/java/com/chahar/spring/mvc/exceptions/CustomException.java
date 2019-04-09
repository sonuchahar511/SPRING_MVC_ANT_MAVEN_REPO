package com.chahar.spring.mvc.exceptions;

import java.util.Arrays;

public class CustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + "]";
	}

	
}
