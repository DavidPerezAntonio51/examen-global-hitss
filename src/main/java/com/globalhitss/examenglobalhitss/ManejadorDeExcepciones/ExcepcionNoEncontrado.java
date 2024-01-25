package com.globalhitss.examenglobalhitss.ManejadorDeExcepciones;

public class ExcepcionNoEncontrado extends RuntimeException{
    private static final String MENSAJE = "El recurso solicitado no fue encontrado";
    public ExcepcionNoEncontrado(){
        super(MENSAJE);
    }
}
