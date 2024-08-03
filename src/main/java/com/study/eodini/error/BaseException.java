package com.study.eodini.error;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {

    private final BaseExceptionMessage baseExceptionMessage;

    public BaseException(BaseExceptionMessage e) {
        super(e.getGetMessage());
        this.baseExceptionMessage = e;
    }
}
