package com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones;

public class PoiAlreadyExistsInRouteException extends RuntimeException{
    public PoiAlreadyExistsInRouteException(String id, String id2 ) {

        super(String.format("POI con el ID: %s ya se emcuentra en la ruta con ID: %s", id, id2));
    }
}
