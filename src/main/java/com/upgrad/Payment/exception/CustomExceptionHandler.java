package com.upgrad.Payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransactionNotFoundException.class)

    /*

     */
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(TransactionNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
        System.out.println(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
