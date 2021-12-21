package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.CategoryRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.CategoryService;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations.CategoryIdExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExistsValidator implements ConstraintValidator<CategoryIdExists, Long> {

    @Autowired
    private CategoryRepository repo;

    @Override
    public void initialize(CategoryIdExists constraintAnnotation) { }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return repo.existsById(id);
    }

}
