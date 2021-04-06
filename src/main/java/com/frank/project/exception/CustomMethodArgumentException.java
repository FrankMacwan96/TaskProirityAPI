// package com.frank.project.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice
// public class CustomMethodArgumentException extends ResponseEntityExceptionHandler{

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
                
//                 ErrorDetails er = new ErrorDetails(ex.getMessage(),HttpStatus.BAD_REQUEST);
//                 return new ResponseEntity<>(er, null, 404);
//             }
// }