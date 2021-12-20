package com.salesianos.triana.turist.manuelspinola.TrianaTurist.services;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDto;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto.CategoryDtoConverter;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.errores.excepciones.ElementNotFoundException;
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
    private final CategoryDto categoryDto;
    private final CategoryDtoConverter categoryDtoConverter;

    public Category create(CategoryDto categoryDto){
         return categoryRepository.save(Category.builder()
                 .name(categoryDto.getName())
                 .build());
    }

    public List<CategoryDto> findAll(){
        List <CategoryDto> categories = categoryRepository.findAll().stream()
                .map(categoryDtoConverter::categoryToGetcategoryDto )
                .collect(Collectors.toList());
        return categories;
    }

    public Category findOne(@PathVariable Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() ->  new ElementNotFoundException(Category.class,id ))   ;

        return category;
    }

    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }







}
