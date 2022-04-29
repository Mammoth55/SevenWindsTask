package com.example.sevenwindstask.exeptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ApiError> handleException(Exception ex) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()),
                ex instanceof EntityNotFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
    }
}