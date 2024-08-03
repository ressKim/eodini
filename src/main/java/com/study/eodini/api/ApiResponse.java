package com.study.eodini.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private ApiHeader apiHeader;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(ApiHeader.SUCCESS, null, null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ApiHeader.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(ApiHeader.FAIL, null, message);
    }

    public static <T> ApiResponse<T> fail(ApiHeader apiHeader, String message) {
        return new ApiResponse<>(apiHeader, null, message);
    }
}
