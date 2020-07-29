package com.globallogic.ejercicio.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globallogic.ejercicio.service.exception.EjercicioException;

/**
 * Created by julio cornejo on 29-07-19.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger(ExceptionControllerAdvice.class);

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(EjercicioException.class)
    public ResponseEntity<RagnaxError> handlerException(EjercicioException lie) {
        LOGGER.error("[ExceptionControllerAdvice] Error en ejercicio: {} .", lie.getMessage());
        
        return new ResponseEntity<>(new RagnaxError(lie.getMessage()),
                HttpStatus.NOT_ACCEPTABLE);
        
    }
    
}