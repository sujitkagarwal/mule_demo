package com.dev.sa.data.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Anie on 7/16/2016.
 */

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullElementsValidator.class)
@Documented
public @interface NotNullElements {
    String message() default "{Null Elements are not allowed in List}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    }
