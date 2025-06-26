package com.propertymanagement.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ErrorModel> errorModelList  = new ArrayList<>();

        List<FieldError> fieldErrorList = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrorList) {
            logger.debug("Inside field validation: {} - {}",error.getField(),error.getDefaultMessage());
            logger.info("Inside field validation: {} - {}",error.getField(),error.getDefaultMessage());
            ErrorModel model   = new ErrorModel();
            model.setCode(error.getField());
            model.setMessage(error.getDefaultMessage());
            errorModelList .add(model);
        }
           return new ResponseEntity<List<ErrorModel>>(errorModelList ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException e)
    {
        for(ErrorModel errorModel:e.getErrors()) {
            logger.debug("BusinessException is thrown -level-debug: {} - {}", errorModel.getCode(), e.getMessage());
            logger.info("BusinessException is thrown -level-info: {} - {}", errorModel.getCode(), e.getMessage());
            logger.warn("BusinessException is thrown -level-warn: {} - {}", errorModel.getCode(), e.getMessage());
            logger.error("BusinessException is thrown -error-warn: {} - {}", errorModel.getCode(), e.getMessage());
        }
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }

}
