package com.example.restapi.validator;

import com.example.restapi.annotation.YearMonth;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = Pattern.matches(String.valueOf(value), pattern);

        var reValue = value+"01";
        var rePattern = pattern +"dd";
        try{
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));

            return true;
        }catch (Exception e){
            return false;
        }
    }


}
