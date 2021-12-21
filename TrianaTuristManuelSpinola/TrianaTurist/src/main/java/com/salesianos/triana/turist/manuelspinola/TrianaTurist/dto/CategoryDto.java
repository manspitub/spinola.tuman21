package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {


    @NotBlank(message = "{category.name.blank}")
    @UniqueName(message = "{category.name.unique")
    private String name;
    private POI puntodeInteres;
}
