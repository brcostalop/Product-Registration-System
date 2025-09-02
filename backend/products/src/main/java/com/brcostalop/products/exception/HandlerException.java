package com.brcostalop.products.exception;

import com.brcostalop.products.dto.ExceptionDTO;
import lombok.Getter;

@Getter
public abstract class HandlerException extends Exception {
    String title;
    String messageStr;
    public HandlerException(String title, String messageStr, String message) {
        super(message);
        this.title = title;
        this.messageStr = messageStr;
    }

    public ExceptionDTO toDTO(int code) {
        return new ExceptionDTO(code, this.title, this.messageStr, this.getMessage());
    }
}