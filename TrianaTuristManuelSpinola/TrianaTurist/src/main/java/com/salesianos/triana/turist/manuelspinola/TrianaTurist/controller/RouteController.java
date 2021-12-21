package com.salesianos.triana.turist.manuelspinola.TrianaTurist.controller;


import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.RouteDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.SingleEntityNotFoundException;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Route;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.RouteRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.POIService;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@Validated
@RequiredArgsConstructor
public class RouteController {

    private final RouteService service;
    private final POIService poiService;
    private final RouteRepository repo;


    @GetMapping("/routes")
    public ResponseEntity<List<Route>> allRoutes(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @GetMapping("routes/{id}")
    public ResponseEntity<Route> findOne(@PathVariable @Min(value = 0, message = "No se puede introducir un id negativo") Long id){

        return ResponseEntity.status(HttpStatus.FOUND).body(service.findOne(id));

    }

    @PostMapping("/")
    public ResponseEntity<?> nuevaRuta(@Valid @RequestBody RouteDto nuevo){


        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(nuevo));
    }

    @PutMapping("routes/{id}")
    public Route setRoute(@Valid @RequestBody RouteDto edit, @PathVariable Long id){
        return repo.findById(id).map(c ->{
            c.setName(edit.getName());
            c.setSteps(edit.getSteps());
            return repo.save(c);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    @DeleteMapping("routes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        repo.findById(id).map(c -> {
            c.setSteps(new ArrayList<>());
            return repo.save(c);
        });
        return ResponseEntity.noContent().build();
    }



}
