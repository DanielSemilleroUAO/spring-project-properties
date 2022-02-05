package com.daniel.propertymanagment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldValidation(MethodArgumentNotValidException methodArgumentNotValidException){
        List<FieldError> fieldErrorList = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        logger.info("Inside validartion");
        logger.debug("Debug");
        logger.warn("Warn");
        logger.error("Error");
        return new ResponseEntity(fieldErrorList,  HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessExeception(BusinessException businessException){
        System.out.println("BusinessException is throw");
        return new ResponseEntity(businessException.getErrors(),  HttpStatus.BAD_REQUEST);
    }

}
