package com.SpringApi.SpringApi11.exception;

import com.SpringApi.SpringApi11.payload.ErrorDeteils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDeteils> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    )
    {
        ErrorDeteils errorDeteils = new ErrorDeteils(e.getMessage(),new Date(), webRequest.getDescription(true));
        return new ResponseEntity<>(errorDeteils, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

// because it send the response back to postman