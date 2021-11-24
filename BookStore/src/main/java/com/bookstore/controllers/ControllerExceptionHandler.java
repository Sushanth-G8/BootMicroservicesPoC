package com.bookstore.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public String resourceNotFoundException(BookNotFoundException ex){
		
		return ex.getMessage();
	}
	
	@ExceptionHandler(BookAvailableException.class)
	public String bookAvailableException(BookAvailableException ex){
		
		return ex.getMessage();
	}

}
