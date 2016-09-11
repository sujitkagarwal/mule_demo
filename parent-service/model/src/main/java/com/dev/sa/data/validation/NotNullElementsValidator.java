package com.dev.sa.data.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;


/**
 * Created by Anie on 7/16/2016.
 */
public class NotNullElementsValidator implements ConstraintValidator<NotNullElements,Collection<?>> {


    @Override
    public void initialize(NotNullElements notNullElements) {

    }

    @Override
    public boolean isValid(Collection<?> col, ConstraintValidatorContext constraintValidatorContext) {
        boolean ret=true;
        for(Object obj:col){
            if(obj==null)
            {
                ret=false;
            }
        }
        return ret;
    }
}
