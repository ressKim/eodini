package com.study.eodini.user.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.eodini.error.BaseExceptionMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 메세지 관리를 편하게하기 위해 enum 으로 관리
 * 나중에 한글 텍스트를 바꿀때 편하도록 구현
 * 나중에 더 모을 필요가 있으면 yml 파일에 모아서 관리
 *
 * ++ 여기는 원래 Throwable에 있는 code, getMessage 를 상속을 이용하여 다시 구현한것
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum UserExceptionMessage implements BaseExceptionMessage {

    WRONG_EMAIL(HttpStatus.BAD_REQUEST, "아이디 형식이 잘못되었습니다."),
    DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "Email 이 이미 사용중입니다."),
    WRONG_PASSWORD_FORM(HttpStatus.BAD_REQUEST, "패스워드 형식이 잘못되었습니다."),
    WRONG_USER_FORM(HttpStatus.BAD_REQUEST, "유저 정보가 잘못되었습니다."),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "해당 유저가 존재하지 않습니다."),







    ;



    private final HttpStatus getStatus;
    private final String getMessage;

    UserExceptionMessage(HttpStatus getStatus, String getMessage) {
        this.getStatus = getStatus;
        this.getMessage = getMessage;
    }

    @Override
    public HttpStatus getStatus() {
        return getStatus;
    }

    @Override
    public String getMessage() {
        return getMessage;
    }
}
