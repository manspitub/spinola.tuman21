package com.salesianos.triana.turist.manuelspinola.TrianaTurist.controller;



import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.POIDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.SingleEntityNotFoundException;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.POI;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.POIRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.CategoryService;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RestController
@Validated
@RequiredArgsConstructor
public class POIController {

    private final POIService service;
    private final POIRepository repo;
    private final CategoryService categoryService;
    private final POIDtoConverter poiDToConverter;



    @GetMapping("/POIs")
    public ResponseEntity<List<POI>> allPOIs(){

        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @GetMapping("POIs/{id}")
    public ResponseEntity<POI>findOne(@PathVariable @Min(value = 0, message = "No se puede introducir un id negativo") Long id ){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findOne(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> nuevoPOI(@Valid @RequestBody POIDto nuevo){
        Category cat = categoryService.findOne(nuevo.getCategoryId());
        repo.save(poiDToConverter.createPoiDtoToPoi(nuevo,cat));
        return ResponseEntity.status(HttpStatus.CREATED).body(poiDToConverter.createPOIDtoToPOI(nuevo));

    }

    @PutMapping("POIs/{id}")
    public POI setPOI(@Valid @RequestBody POIDto edit, Category cat,  @PathVariable Long id){
        return repo.findById(id).map(p -> {
            p.setName(edit.getName());
            p.setCategory(edit.getCategory());
            p.setCoverPhoto(edit.getCoverPhoto());
            p.setDescripcion(edit.getDescripcion());
            p.setDate(LocalDateTime.now());
            p.setLocation(edit.getLocation());
            p.setPhoto2(edit.getPhoto2());
            p.setPhoto3(edit.getPhoto3());
            return repo.save(p);

        }).orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    @DeleteMapping("POIs/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        repo.findById(id).map(p->{
            p.setCategory(null);
            return repo.save(p);
        });
        return ResponseEntity.noContent().build();
    }



}
