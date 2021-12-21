package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators.CategoryExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryExistsValidator.class)
@Documented
public @interface CategoryIdExists {

    String message() default "El id de la categoría debe pertenecer a una categoría existente.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
