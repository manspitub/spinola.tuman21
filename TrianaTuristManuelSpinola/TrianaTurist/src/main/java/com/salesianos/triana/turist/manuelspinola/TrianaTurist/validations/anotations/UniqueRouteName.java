package com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.anotations;

import com.salesianos.triana.turist.manuelspinola.TrianaTurist.validations.validators.UniqueRouteNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRouteNameValidator.class)
@Documented
public @interface UniqueRouteName {
    String message() default "No puede haber dos rutas con el mismo nombre.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
