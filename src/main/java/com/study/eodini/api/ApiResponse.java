package com.study.eodini.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@Getter
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends ResponseEntity<T>{

//    private HttpStatus status;
//    private T data;
    private String message;

    static public <T> ApiResponse<T> success() {
        return new ApiResponse<>(HttpStatus.OK);
    }
    static public <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, HttpStatus.OK);
    }
    static public <T> ApiResponse<T> fail() {
        return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    static public <T> ApiResponse<T> fail(HttpStatus httpStatus, String message) {
        return new ApiResponse<>(httpStatus, message);
    }



    public ApiResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiResponse(T body, HttpStatusCode status) {
        super(body, status);
    }

    public ApiResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ApiResponse(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public ApiResponse(T body, MultiValueMap<String, String> headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }

    public ApiResponse(HttpStatusCode status, String message) {
        super(status);
        this.message = message;
    }




}
