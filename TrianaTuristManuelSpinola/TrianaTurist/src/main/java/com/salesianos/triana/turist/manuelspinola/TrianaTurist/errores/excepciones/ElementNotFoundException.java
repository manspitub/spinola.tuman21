package com.salesianos.triana.turist.manuelspinola.TrianaTurist.errores.excepciones;

public class ElementNotFoundException extends EntityNotFoundException{

    public ElementNotFoundException( Class clase, Long id) {
        super(String.format("No se puede encontrar %s con el id %s " , clase.getName() ,id));
    }

}
