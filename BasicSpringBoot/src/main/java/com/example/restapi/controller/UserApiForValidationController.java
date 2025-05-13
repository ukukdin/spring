package com.example.restapi.controller;

import com.example.restapi.model.Api;
import com.example.restapi.model.UserRegisterRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/register/user")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserApiForValidationController {
    //valid 어노테이션을 달아주면 요청이 들어올때 자동으로 해당 클래스에 대해서 어노테이션을 기반으로 검증을 해주게된다.
    @PostMapping("")
    public Api<UserRegisterRequest> register(@Valid @RequestBody Api<UserRegisterRequest> userRegisterRequest){

        log.error("init : {}", userRegisterRequest);

        var body = userRegisterRequest.getData();

        Api<UserRegisterRequest> response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;

    }
}
