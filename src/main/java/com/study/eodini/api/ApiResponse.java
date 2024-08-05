package com.study.eodini.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private HttpStatus status;
    private T data;
    private String message;


    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(HttpStatus.OK, null, null);
    }
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(HttpStatus.OK, data, null);
    }

    public static <T> ApiResponse<T> fail(HttpStatus status, String message) {
        return new ApiResponse<>(status, null, message);
    }
}
