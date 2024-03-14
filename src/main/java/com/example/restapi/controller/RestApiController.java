package com.example.restapi.controller;


import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path="/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name= "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message : " + msg);
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);

        //TODO 대문자 변환해서 RETURN
        if(msg == msg.toLowerCase()){
            System.out.println("echo message : " + msg.toUpperCase());
            System.out.println("echo age : " + age);
            System.out.println("echo isMan : " + isMan);
            return msg.toUpperCase();

        }
        return msg;

    }
    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issued_month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
           @RequestParam String category,
           @RequestParam String issuedYear,
           @RequestParam (name = "issued-month")String issuedMonth,
           @RequestParam (name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }
    //http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryParamDto(BookQueryParam bookQueryParam){

        System.out.println(bookQueryParam);

    }
    // TODO Parameter 2가지를 받습니다. 해당 2가지를 int 형태로 받아 두 수의 덧셈, 곱셈
    @GetMapping(path = "/book3")
    public String queryParam3(
            @RequestParam Integer category,
            @RequestParam Integer issuedYear

    ){
        System.out.println("두 수의 덧셈 category + issuedYear : "+ (category + issuedYear));
        System.out.println("두 수의 곱셈 category x issuedYear : "+ category * issuedYear);
        Integer plused = category+issuedYear;
        Integer times = category*issuedYear;
        Map<String, Integer> pluse2 =new HashMap<String,Integer>();
        pluse2.put("더하기 ",plused);
        pluse2.put("곱하기" , times);

        return getValueOfMap(pluse2);
    }
    public static String getValueOfMap(Map<String,Integer> map){
        StringBuilder res = new StringBuilder();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            res.append(entry.getKey()).append(" 값은? : ").append(entry.getValue()).append("\n");
        }
        return res.toString();
    }
}
