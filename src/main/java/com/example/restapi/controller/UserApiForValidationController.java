package com.example.restapi.controller;

import com.example.restapi.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/register/user")
public class UserApiForValidationController {
    //valid 어노테이션을 달아주면 요청이 들어올때 자동으로 해당 클래스에 대해서 어노테이션을 기반으로 검증을 해주게된다.
    @PostMapping("")
    public UserRegisterRequest register(@Valid @RequestBody UserRegisterRequest userRegisterRequest){
        log.error("init : {}", userRegisterRequest);

        return userRegisterRequest;

    }
}
