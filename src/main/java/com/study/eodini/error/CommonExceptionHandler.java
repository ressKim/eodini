package com.study.eodini.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException e) {
        if (e instanceof BaseException baseException) {
            log.debug("[runtime exception 내용 ={}]", e.getMessage());
            return ResponseEntity
                    .status(baseException.getBaseExceptionMessage().getStatus())
                    .body(baseException.getMessage());
        }
        log.warn("[runtime exception 내용 ={}]", e.getMessage());
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ResponseEntity<String> exHandler(Exception e) {
        log.error("[error ex] = {}]", e.getLocalizedMessage());
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

}