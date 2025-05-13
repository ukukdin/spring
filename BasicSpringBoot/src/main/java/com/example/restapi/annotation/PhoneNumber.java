package com.example.restapi.annotation;

import com.example.restapi.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex) 000-0000-0000";
    String regexp() default "^\\d{3}-\\d{4}-\\d{4}$";

}
