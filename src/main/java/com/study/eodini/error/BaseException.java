package com.study.eodini.error;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final BaseExceptionMessage baseExceptionMessage;

    public BaseException(BaseExceptionMessage e) {
        super(e.message());
        this.baseExceptionMessage = e;
    }
}
