package com.salesianos.triana.turist.manuelspinola.TrianaTurist.dto;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {
    public Category createCategoryDtoToCategory(CategoryDto c) {
        return new Category(
                c.getName()
        );
    }

    public CategoryDto categoryToGetcategoryDto(Category c) {
        return CategoryDto.builder().
                name(c.getName()).
                build();
    }

}
