package com.study.eodini.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.eodini.api.ApiResponse;
import com.study.eodini.error.CommonExceptionHandler;
import com.study.eodini.user.domain.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class UserControllerMockTest {

    private MockMvc mvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private JacksonTester<UserDto> jsonUserValue;


    @BeforeEach
    void setup() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new CommonExceptionHandler())
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("회원가입 테스트 - 성공")
    void canUserJoin() throws Exception {
        UserDto getUserValue =
                new UserDto.Builder("testUser@naver.com")
                        .password("test1234")
                        .name("홍길동")
                        .age(20)
                        .build();

        MockHttpServletResponse getResponse = getMockHttpServletResponseUserJoin(getUserValue);
        String contentAsString = getResponse.getContentAsString();


        assertThat(getResponse.getStatus()).isEqualTo(200);
        assertThat(contentAsString).isEqualTo(
                new ObjectMapper().writeValueAsString(
                        ApiResponse.success()
                )
        );
    }

    private MockHttpServletResponse getMockHttpServletResponseUserJoin(UserDto userDto) throws Exception {
        return mvc.perform(
                post("/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUserValue.write(userDto)
                                .getJson()
                        )).andReturn().getResponse();
    }

}