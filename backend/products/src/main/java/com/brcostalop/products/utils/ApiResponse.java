package com.brcostalop.products.utils;

import com.brcostalop.products.exception.HandlerException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ApiResponse<T> {

    private int code;
    private String message;
    private T dados;

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
        return new ResponseEntity<T>(t, responseHeaders, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Object> failureFactory(HandlerException e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        return new ResponseEntity<Object>(e.toDTO(HttpStatus.FORBIDDEN.value()), responseHeaders, HttpStatus.FORBIDDEN);
    }
}
