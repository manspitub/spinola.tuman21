package com.salesianos.triana.turist.manuelspinola.TrianaTurist.controller;


import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.SingleEntityNotFoundException;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.CategoryRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RestController
@Validated
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryRepository repo;
    private final CategoryService catService;
    private final CategoryDtoConverter dtoConverter;


    @GetMapping("/categories")
    public ResponseEntity<List<Category>> allCategories(){

        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());


    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> findOne(@PathVariable @Min(value = 0, message = "No se puede introducir un id negativo") Long id){

            return ResponseEntity.status(HttpStatus.FOUND).body(service.findOne(id));

    }

    @PostMapping("/")
    public ResponseEntity<?> nuevaCategoria(@Valid @RequestBody CategoryDto nuevo){
        Category categoriaBuscada = dtoConverter.createCategoryDtoToCategory(nuevo);
        repo.save(categoriaBuscada);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaBuscada);
    }

    @PutMapping("categories/{id}")
    public Category setCategoria(@Valid @RequestBody CategoryDto edit, @PathVariable Long id){
        return repo.findById(id).map(c ->{
            c.setName(edit.getName());
            c.setPuntoDeInteres(edit.getPuntodeInteres());
            return repo.save(c);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        repo.findById(id).map(c -> {
            c.setPuntoDeInteres(null);
            return repo.save(c);
        });
        return ResponseEntity.noContent().build();
    }


}
