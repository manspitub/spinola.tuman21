package com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
