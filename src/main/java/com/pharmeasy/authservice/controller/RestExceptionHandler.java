package com.pharmeasy.authservice.controller;

import com.pharmeasy.authservice.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(ResourceNotFoundException ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<Object>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}

@Data
@AllArgsConstructor
class ApiError{
    private String error;
}
