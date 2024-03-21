package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
//스네이크 기법으로 변경해주는 jsonNaming 어노테이션입니다.
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserAccountInfo {
    @JsonProperty("user_names")
    private String userName;
    private Integer userAge;
/*    @JsonProperty("user_email")*/
    private String email;
    private Boolean isKorean; //default 값이 false

    private UserAccountInfo(){

    }

    @Override
    public String toString() {
        return "UserAccountInfo{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
}

