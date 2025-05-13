package com.example.restapi.controller;

import com.example.restapi.model.UserAccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//controller로 어노테이션을 주면 밑에 받을 값을 @ResponseBody를 줘야한다.
//@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {

    //http://localhost:8080/api/vi
   /* @GetMapping("")*/
    //RequestMapping을 사용하면 반드시 method를 지정해주는것이 좋다. 그렇지 않고 path만 받으면 get이든 post등 모든것이 동작하게 되는것이다.그냥 어떠ㅏㄴ값을 받겟다라고 겟매핑에 주소를 넣는게 좋다.
    //@RequestMapping(path = "", method = RequestMethod.GET)
    //Controller로 어노테이션을 지정하고 @ResponseBody를 지정해주지 않으면 안된다 404뜬다. 그리고 우리는 컨트롤러 사용보다 api를 만들기 때문에 RestController 를 사용하는것을 추천한다.
    //@ResponseBody
    //메소드 자체에서는 객체를 리턴하는것을 주로 사용하고 리스폰스에니티는 우리가 해당 로직을 처리하다가 예외가 발생했을때 응답 코드를 내리는 방법이 있는데 그때 사용한다.
   /* public UserAccountInfo user(){
        var user = new UserAccountInfo();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        log.info("user : {}", user);

        var response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("x-custom","hi")
                .body(user);

        return user;
    }*/
}
