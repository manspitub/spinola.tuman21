package com.salesianos.triana.turist.manuelspinola.TrianaTurist.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class POI {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String location;
    private String descripcion;
    private LocalDateTime date;



    @OneToOne(mappedBy = "puntoDeInteres", fetch = FetchType.EAGER)
    private Category category;

    @OneToOne
    private Route ruta;

    private String coverPhoto;
    private String photo2;
    private String photo3;

}
