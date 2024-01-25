package com.globalhitss.examenglobalhitss.ManejadorDeExcepciones;

public class ExcepcionMalaPeticion extends RuntimeException {
    public ExcepcionMalaPeticion(String causa){
        super(causa);
    }
}
