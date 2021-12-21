package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidator.class)
@Documented
public @interface UniqueName {

    String message() default "El nombre del producto debe ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}