package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class POIDtoConverter {

    public POI createPOIDtoToPOI(POIDto p){
        return POI.builder()
                .name(p.getName())
                .location(p.getLocation())
                .descripcion(p.getDescripcion())
                .date(LocalDateTime.now())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }

    public POI createPoiDtoToPoi(POIDto p, Category cat){
        return POI.builder()
                .name(p.getName())
                .location(p.getLocation())
                .descripcion(p.getDescripcion())
                .date(LocalDateTime.now())
                .category(cat)//TODO Validar que existe
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }


    public POIDto poiToGetPOIDTO(POI p){
        return POIDto
                .builder()
                .category(p.getCategory())
                .location(p.getLocation())
                .coverPhoto(p.getCoverPhoto())
                .descripcion(p.getDescripcion())
                .ruta(p.getRoutes())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }

}
