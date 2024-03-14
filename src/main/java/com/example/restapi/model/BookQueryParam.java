package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

//수동으로 매칭은 받는것이 다 가능하지만 한번의 객체로 받을때는 불가능하다 그래서 한번의 객체로 받고자 할때는 규칙을 정해야한다ㅣ.
//우리 서버는 한정적으로 카멜기법으로 가양한다 혹은 예외르 둘수있지만 자바의 컨벤션을 따라가는것을 추천한다.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
