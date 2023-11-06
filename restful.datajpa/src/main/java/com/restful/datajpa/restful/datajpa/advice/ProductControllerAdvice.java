package com.restful.datajpa.restful.datajpa.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restful.datajpa.restful.datajpa.exception.CategoryException;
import com.restful.datajpa.restful.datajpa.exception.CustomerException;
import com.restful.datajpa.restful.datajpa.exception.ProductException;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<String> handleProductException(ProductException productException){
		return new ResponseEntity<String>(productException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<String> handleProductException(CustomerException customerException){
		return new ResponseEntity<String>(customerException.getMessage(), HttpStatus.BAD_REQUEST);
		}
	
	
	
}
