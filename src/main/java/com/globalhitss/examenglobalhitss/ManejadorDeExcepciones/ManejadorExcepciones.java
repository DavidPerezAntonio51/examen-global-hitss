package com.globalhitss.examenglobalhitss.ManejadorDeExcepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManejadorExcepciones {
    private static final Logger logger = LoggerFactory.getLogger(ManejadorExcepciones.class);
    @ExceptionHandler({
            ExcepcionNoEncontrado.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> manejadorRecursosNoEncontrados(Exception e){
        logger.trace(e.getMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler({
            ExcepcionMalaPeticion.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> manejadorParaBadRequest(Exception e){
        logger.trace(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
