package com.example.restapi.annotation;

import com.example.restapi.validator.PhoneNumberValidator;
import com.example.restapi.validator.YearMonthValidator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String message() default "날짜 형식이 맞지 않습니다 ex) 20240101";

    String pattern() default "yyyyMMdd";


}
