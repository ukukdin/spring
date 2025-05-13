package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserAccountInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(@RequestBody BookRequest bookRequest){

        System.out.println(bookRequest);
        return bookRequest.toString();

    }
  @PostMapping("/user")
    public UserAccountInfo User(@RequestBody UserAccountInfo userAccountInfo){
      System.out.println(userAccountInfo);
      return userAccountInfo;
  }
}
