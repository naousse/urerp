/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;

/**
 *
 * @author samuel
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface Unique {
    
    String message() default "Cette valeur existe déjà veuillez choisir une autre valeur";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload()default {};
}
