package com.salesianos.triana.turist.manuelspinola.TrianaTurist.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String location;
    private String descripcion;
    private LocalDateTime date;



    @ManyToMany(mappedBy = "steps",fetch = FetchType.EAGER)
    @Builder.Default
    private List<Route> routes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    private String coverPhoto;
    private String photo2;
    private String photo3;

    public POI(Category category, String location, String coverPhoto, String name, String photo2, Route ruta, String descripcion) {
    }






}
