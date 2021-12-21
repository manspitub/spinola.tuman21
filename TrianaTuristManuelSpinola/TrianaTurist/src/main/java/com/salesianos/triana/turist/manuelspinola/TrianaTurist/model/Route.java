package com.salesianos.triana.turist.manuelspinola.TrianaTurist.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private List<POI> steps =new ArrayList<>();


    public Route(String name, List<POI> steps) {
    }

    public void addStep(POI p){
        this.steps.add(p);
        p.getRoutes().add(this);
    }

    public void removeStep(POI p){
        this.steps.remove(p);
        p.getRoutes().remove(this);
    }

}
