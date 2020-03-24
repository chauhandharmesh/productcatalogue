package com.productcatalogue.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonExceptionHandler {


	@ExceptionHandler(value = RuntimeException.class)
	public String handleException() {
		return "Error occurred while returning result";
	}
	
	
}
