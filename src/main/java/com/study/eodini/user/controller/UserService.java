package com.study.eodini.user.controller;

import com.study.eodini.user.domain.UserDto;
import com.study.eodini.user.domain.UserValue;
import com.study.eodini.user.error.UserException;
import com.study.eodini.user.error.UserExceptionMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {


    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        UserDto.isValid(userDto);
        if (userRepository.existsByEmail(userDto.email()).equals(true)) {
            throw new UserException(UserExceptionMessage.DUPLICATED_EMAIL);
        }
        userRepository.save(userDto.toEntity());

    }

    public UserValue getUser(UserDto userDto) {

        if (userDto.name() != null) {
            return userRepository.findByName(userDto.name()).orElseThrow(
                    () -> new UserException(UserExceptionMessage.NOT_FOUND_USER));
        } else if (userDto.email() != null) {
            return userRepository.findByEmail(userDto.email()).orElseThrow(
                    () -> new UserException(UserExceptionMessage.NOT_FOUND_USER));
        } else
            throw new UserException(UserExceptionMessage.WRONG_USER_FORM);
    }
}
