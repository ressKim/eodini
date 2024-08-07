package com.study.eodini.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.eodini.user.domain.UserDto;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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

        ExtractableResponse<Response> createResponse = RestAssured
                .given().log().all()
                .contentType("application/json")
                .body(getUserDtoMap)
                .when()
                .post("/user/join")
                .then().log().ifError()
//                .then().log().all()
                .statusCode(200)
                .extract();

        Assertions.assertThat(createResponse.statusCode()).isEqualTo(200);


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