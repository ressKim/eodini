package com.study.eodini.user.controller;

import com.study.eodini.user.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public void createUser(UserDto userDto) {
        userService.createUser(userDto);
    }
}
