package com.study.eodini.api;

import lombok.Getter;

@Getter
public record ApiHeader(int status, String message) {
    public static final ApiHeader SUCCESS = new ApiHeader(200, "OK");
    public static final ApiHeader FAIL = new ApiHeader(500, "FAIL");

}
