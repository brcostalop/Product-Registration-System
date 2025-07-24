package com.brcostalop.products.utils;

import lombok.Builder;
import lombok.Getter;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Builder
public class ApiResponse<T> {

    private int code;
    private String message;
    private T dados;
//    private String errorData;

    public ApiResponse() {
    }

    public ApiResponse(int code, String message, T dados) {
        this.code = code;
        this.message = message;
        this.dados = dados;
    }

    public static <T> ResponseEntity<T> successFactory() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<T>(null, responseHeaders, HttpStatus.CREATED);

    }

    public static <T> ResponseEntity<T> successFactory(T t) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
//        Object obj = t;
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.OK);
    }

    public static <T> ApiResponse<T> successFactory(String msg, T t) {
        return new ApiResponse<T>(200, msg, t);
//        return new ApiResponse<T>(200, msg != null ? null : "" , t);
    }

    public static <T> ApiResponse<T> failureFactory(T t) {
        return new ApiResponse<T>(200, "failure", t);
    }
}
