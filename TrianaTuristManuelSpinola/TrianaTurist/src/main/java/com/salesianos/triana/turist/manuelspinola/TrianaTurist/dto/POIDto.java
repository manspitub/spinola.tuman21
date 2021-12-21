package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POIDto {


    @NotBlank(message = "{poi.name.blank}")
    private String name;

    @Pattern(
            regexp = "^(\\-?\\d+(\\.\\d+)?),\\w*(\\-?\\d+(\\.\\d+)?)$",
            message = "{poi.mapsFormat.validate}"
    )

    private String location;

    @Lob
    private String descripcion;
    private LocalDate date;

    private Category category;
    private List<Route> ruta;

    @Lob
    @URL(message = "{POI.url.format}")
    @NotBlank
    @NonNull
    private String coverPhoto;


    private Long categoryId;

    @Lob
    @URL(message = "{POI.url.format}")
    @Builder.Default
    private String photo2 = null;

    @Lob
    @URL(message = "{POI.url.format}")
    @Builder.Default
    private String photo3 = null;

}
