package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordIsNotExist extends Exception {

	public RecordIsNotExist(String message)
	{
		super(message);
	}
	
}
