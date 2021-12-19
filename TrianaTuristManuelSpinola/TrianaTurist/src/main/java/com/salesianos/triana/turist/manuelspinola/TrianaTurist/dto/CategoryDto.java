package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {


    private String name;
    private POI puntodeInteres;
}
