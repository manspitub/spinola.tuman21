package com.salesianos.triana.turist.manuelspinola.TrianaTurist.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToOne
    private POI puntoDeInteres;


    public Category(String name) {
    }
}
