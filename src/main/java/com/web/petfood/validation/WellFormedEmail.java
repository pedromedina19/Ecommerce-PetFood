package com.web.petfood.validation;

import com.web.petfood.validation.validator.WellFormedEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = WellFormedEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Documented
public @interface WellFormedEmail {

	public String message() default "O formato do e-mail não é válido";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default{};

}