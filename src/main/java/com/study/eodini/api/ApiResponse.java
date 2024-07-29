package com.study.eodini.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private ApiHeader apiHeader;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ApiHeader.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(ApiHeader.FAIL, null, message);
    }

}
