package com.example.restapi.model;

import com.example.restapi.annotation.PhoneNumber;
import com.example.restapi.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//    @NotBlank
    private String name;

    private String nickName;

    @NotBlank
    @Size(min = 1, max=12)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    //번호는 따로 어노테이션이 없어서 정규식을 사용해보자
    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.")
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name 또는 nickName 은 반드시 1개가 존재 해야합니다.")
    public boolean isNameCheck(){

       if(Objects.nonNull(name) && !name.isBlank()){
           return true;
       }
        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }

        return false;
    }
}
