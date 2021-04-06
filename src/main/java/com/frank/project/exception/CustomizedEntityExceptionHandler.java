package com.frank.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomizedException.class)
    public final ResponseEntity<Object> handleAllException(CustomizedException ex){
        ErrorDetails er = new ErrorDetails(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }
}