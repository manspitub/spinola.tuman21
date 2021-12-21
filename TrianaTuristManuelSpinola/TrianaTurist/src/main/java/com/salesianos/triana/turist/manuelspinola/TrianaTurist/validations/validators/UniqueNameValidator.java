package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.CategoryRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CategoryRepository repo;

    @Override
    public void initialize(UniqueName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(name) && !repo.existsByName(name);
    }
}
