package com.study.eodini.error;

import com.study.eodini.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * 우리가 만든(예상한) 예외에 대한 처리
     * 나중에 message 를 관리하기 편하도록 BaseExceptionMessage 를 만들어서 사용
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<RuntimeException> runtimeException(RuntimeException e) {
        log.warn("[runtime exception 내용 ={}]", e.getMessage());
        if (e instanceof BaseException baseException) {
            return ApiResponse.fail(baseException.getBaseExceptionMessage().getStatus(), baseException.getLocalizedMessage());
        }
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ApiResponse<Error> exHandler(Exception e) {
        log.error("[error ex] = {}]", e.getLocalizedMessage());
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    }

}