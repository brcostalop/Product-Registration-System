package com.brcostalop.products.dto;

public record ExceptionDTO(
        int code,
        String title,
        String message,
        String messageHtml
){}
