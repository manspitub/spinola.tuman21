package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class POIDto {


    private String name;
    private String location;
    private String descripcion;
    private Category category;
    private Route ruta;
    private String coverPhoto;
    private String photo2;
    private String photo3;

}
