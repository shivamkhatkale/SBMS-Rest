package com.example.demo.globalhandler;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.ErResp.MyErrorResponse;
import com.example.demo.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> globalHandler(ProductNotFoundException pnfe) {
	   

	    return new ResponseEntity<>(new MyErrorResponse(
	    		LocalDateTime.now(), 
	            "Exception In Process",
	            500,
	            pnfe.getMessage()
	    ), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

