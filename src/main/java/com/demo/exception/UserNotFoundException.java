package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class UserNotFoundException extends RuntimeException{

	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
