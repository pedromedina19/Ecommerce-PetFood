package com.web.petfood.validation;

import com.web.petfood.validation.util.AttributesRelation;
import com.web.petfood.validation.validator.DoubleAttributesRelationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DoubleAttributesRelationValidator.class)
@Documented
public @interface DoubleAttributesRelation {

	String attribute1();

	String attribute2();

	AttributesRelation relation();

	double epsilon() default 0.0001;

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		DoubleAttributesRelation[] value();
	}

}