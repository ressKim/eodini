package com.study.eodini.user.controller;

import com.study.eodini.user.domain.UserDto;
import com.study.eodini.user.domain.UserValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/get")
    public ResponseEntity<UserValue> getUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.getUser(userDto));
    }

}
