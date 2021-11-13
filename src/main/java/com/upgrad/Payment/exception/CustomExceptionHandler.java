package com.upgrad.Payment.exception;

import com.upgrad.Payment.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)

    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
