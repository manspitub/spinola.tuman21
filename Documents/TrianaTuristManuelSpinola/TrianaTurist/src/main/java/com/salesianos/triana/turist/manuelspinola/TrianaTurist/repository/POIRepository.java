package com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepository extends JpaRepository<POI, Long> {
}