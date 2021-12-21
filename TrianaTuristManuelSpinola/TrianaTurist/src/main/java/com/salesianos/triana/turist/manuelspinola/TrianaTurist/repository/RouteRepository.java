package com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    boolean existsByName(String name);
}