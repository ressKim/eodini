package com.study.eodini.user.controller;

import com.study.eodini.user.domain.UserDto;
import com.study.eodini.user.error.UserException;
import com.study.eodini.user.error.UserExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public void createUser(UserDto userDto) {
        UserDto.isValid(userDto);
        if(userRepository.existsByEmail(userDto.getEmail()).equals(false)){
            throw new UserException(UserExceptionMessage.DUPLICATED_EMAIL);
        }


    }
}
