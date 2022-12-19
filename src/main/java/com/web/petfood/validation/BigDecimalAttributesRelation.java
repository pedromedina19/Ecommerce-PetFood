package com.web.petfood.validation;

import com.web.petfood.validation.util.AttributesRelation;
import com.web.petfood.validation.validator.BigDecimalAttributesRelationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BigDecimalAttributesRelationValidator.class)
@Documented
public @interface BigDecimalAttributesRelation {

	String attribute1();

	String attribute2();

	AttributesRelation relation();

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		BigDecimalAttributesRelation[] value();
	}

}
