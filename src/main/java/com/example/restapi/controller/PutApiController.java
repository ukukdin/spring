package com.example.restapi.controller;

import com.example.restapi.model.UserAccountInfo;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public  void put(@RequestBody UserAccountInfo userAccountInfo){
        log.info("Request : {}",userAccountInfo);
    }
}
