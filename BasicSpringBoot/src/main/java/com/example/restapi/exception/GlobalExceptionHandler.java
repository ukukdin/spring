package com.example.restapi.exception;

import com.example.restapi.model.Api;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
//order에서 value 값으로 integer.max_value가 이미 오더에서 디폴트값으로 max밸류로 지정을 해서 굳이 선언을 하지 않아도 됩니다.
//@Order(value =  Integer.MAX_VALUE)
public class GlobalExceptionHandler {

    //예측하지 못한 익셉션을 최상위 클래스로 다 받아서 처리해줍니다. 예측하지 못한 모든 예외를 여기서 처리한다는 구문입니다ㅏ. 
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
}
