package com.hoteis.hoteis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hoteis.hoteis.dto.erroDTO.ErrorDTO;
import com.hoteis.hoteis.exception.NotFoundError;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(NotFoundError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handlerGeneralError(NotFoundError notFoundError){
        return new ErrorDTO(notFoundError.getMessage());
    }
}
