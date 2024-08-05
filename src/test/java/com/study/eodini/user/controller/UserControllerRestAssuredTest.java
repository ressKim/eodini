package com.study.eodini.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.eodini.user.domain.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest
class UserControllerRestAssuredTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    @DisplayName("회원가입 테스트 - 성공")
    void createUserRestAssuredTest() {
        var getUserDtoMap = getUserDtoMap();


//        RestAssured
//                .post("/user/join", getUserValue)
//                .then()
//                .statusCode(200);
        RestAssured
                .given().log().all()
                    .contentType("application/json")
                    .body(getUserDtoMap)
                .when()
                    .post("/user/join")
                .then()
                    .log().all()
                    .statusCode(200);

    }

    private static Map getUserDtoMap() {
        UserDto getUserValue =
                new UserDto.Builder("testUser@naver.com")
                        .password("test1234")
                        .name("홍길동")
                        .age(20)
                        .build();

        return new ObjectMapper()
                .convertValue(getUserValue, Map.class);
    }

}