package com.study.eodini.user.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.eodini.error.BaseExceptionMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 메세지 관리를 편하게하기 위해 enum 으로 관리
 * 나중에 한글 텍스트를 바꿀때 편하도록 구현
 * 나중에 더 모을 필요가 있으면 yml 파일에 모아서 관리
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum UserExceptionMessage implements BaseExceptionMessage {

    WRONG_EMAIL(HttpStatus.BAD_REQUEST, "아이디 형식이 잘못되었습니다."),
    DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "Email 이 이미 사용중입니다."),
    WRONG_PASSWORD_FORM(HttpStatus.BAD_REQUEST, "패스워드 형식이 잘못되었습니다."),







    ;



    private final HttpStatus httpStatus;
    private final String getMessage;

    UserExceptionMessage(HttpStatus httpStatus, String getMessage) {
        this.httpStatus = httpStatus;
        this.getMessage = getMessage;
    }

}
