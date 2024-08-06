package com.study.eodini.error;

import org.springframework.http.HttpStatus;

public interface BaseExceptionMessage {
    HttpStatus getStatus();
    String getMessage();
}
