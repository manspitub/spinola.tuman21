package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.repository.RouteRepository;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.services.RouteService;
import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations.UniqueRouteName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteNameValidator implements ConstraintValidator<UniqueRouteName, String> {

    @Autowired
    private RouteRepository repo;

    @Override
    public void initialize(UniqueRouteName constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !repo.existsByName(name);
    }

}
