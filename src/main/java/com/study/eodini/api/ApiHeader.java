package com.study.eodini.api;


public record ApiHeader(int status, String message) {
    public static final ApiHeader SUCCESS = new ApiHeader(200, "OK");
    public static final ApiHeader FAIL = new ApiHeader(500, "FAIL");
    public static final ApiHeader UNAUTHORIZED = new ApiHeader(401, "UNAUTHORIZED");
    public static final ApiHeader FORBIDDEN = new ApiHeader(403, "FORBIDDEN");
    public static final ApiHeader NOT_FOUND = new ApiHeader(404, "NOT FOUND");
    public static final ApiHeader BAD_REQUEST = new ApiHeader(400, "BAD REQUEST");
}
