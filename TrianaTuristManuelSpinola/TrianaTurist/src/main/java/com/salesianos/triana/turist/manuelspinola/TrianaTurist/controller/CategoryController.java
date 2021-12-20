package com.salesianos.triana.turist.manuelspinola.TrianaTurist.controller;


import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.CategoryService;
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
public class CategoryController {

    private final CategoryService service

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> allCategories(){

        if (service.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron elementos del tipo Categoria");
        } else{
            return ResponseEntity.ok(service.findAll()) ;
        }


    }

    public ResponseEntity<Category> findOne(@PathVariable @Min(value = 0, message = "No se puede introducir un id negativo") Long id){

            return ResponseEntity.status(HttpStatus.FOUND).body(service.findOne(id));

    }

    @PostMapping("/")
    public ResponseEntity<?> nuevaCategoria(@Valid @RequestBody CategoryDto nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(nuevo));
    }

    @PutMapping("categories/{id}")
    public ResponseEntity<?> setCategoria(@Valid @RequestBody CategoryDto edit, @PathVariable Long id){
        return service.findOne(id)
    }



}
