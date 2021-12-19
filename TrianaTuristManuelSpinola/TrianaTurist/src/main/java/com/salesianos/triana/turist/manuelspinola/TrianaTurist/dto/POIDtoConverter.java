package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import org.springframework.stereotype.Component;

@Component

public class POIDtoConverter {

    private POI createPOIDtoToPOI(POIDto p){
        return new POI(
                p.getCategory(),
                p.getLocation(),
                p.getCoverPhoto(),
                p.getName(),
                p.getPhoto2(),
                p.getRuta(),
                p.getDescripcion()
        );
    }

    public POIDto poiToGetPOIDTO(POI p){
        return POIDto
                .builder()
                .category(p.getCategory())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .descripcion(p.getDescripcion())
                .ruta(p.getRuta())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }

}
