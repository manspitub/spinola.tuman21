package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.ListEntityNotFoundException;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.error.excepciones.SingleEntityNotFoundException;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public Category create(CategoryDto categoryDto){
         return categoryRepository.save(Category.builder()
                 .name(categoryDto.getName())
                 .build());
    }

    public List<Category> findAll(){
        List<Category> result = categoryRepository.findAll();

        if (result.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }
        else {
            return result;
        }

    }

    public Category findOne(@PathVariable Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() ->  new SingleEntityNotFoundException(id.toString(),Category.class ))   ;

        return category;
    }

    public void delete(@PathVariable Long id) {


        categoryRepository.deleteById(id);
    }







}
