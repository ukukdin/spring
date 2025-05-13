package com.example.restapi.exception;

import com.example.restapi.model.Api;
import com.example.restapi.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.IndexedReadOnlyStringMap;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.restapi.controller")
@Order(2)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api>exception(Exception e){
        log.error("",e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity exception(Exception e){
//
//        log.error("RestApiExceptionHandler",e);
//
//        return ResponseEntity.status(200).build();
//    }
    //원하는 예외만 잡기
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})

    public ResponseEntity outOfBound(IndexOutOfBoundsException e){

        log.error("IndexOutOfBoundsException",e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = { NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement( NoSuchElementException e){
        log.error("",e);

        var response =  Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build()
                ;
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response)
                ;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<UserRegisterRequest> methodArg( MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException",e);

        return ResponseEntity.status(400).build();
    }

}
