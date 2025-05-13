package com.example.restapi;

import com.example.restapi.model.UserAccountInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		//var user = new UserAccountInfo("홍길동",10,"Hong@gmail.com",true);
		//System.out.println(user);
		//user.setUserName("홍길동");
		//user.setUserAge(10);
		//user.setEmail("hong@gmail.com");
		//user.setIsKorean(true);

		var json = "{\"user_names\":\"홍길동\",\"user_age\":10,\"email\":\"Hong@gmail.com\",\"is_korean\":true}";
		System.out.println(json);

		var dto = objectMapper.readValue(json, UserAccountInfo.class);
		System.out.println(dto);
	}

}
