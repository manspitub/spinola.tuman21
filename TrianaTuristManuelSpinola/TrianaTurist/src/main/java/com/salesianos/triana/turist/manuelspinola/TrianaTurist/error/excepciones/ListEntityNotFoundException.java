package com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones;

public class ListEntityNotFoundException extends EntityNotFoundException{
    public ListEntityNotFoundException(Class clazz){
        super(String.format(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName()))); //fichero properties
    }
}
