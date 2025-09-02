package com.brcostalop.products.exception;

public class InvalidFieldException extends HandlerException {

    public InvalidFieldException(String title, String messageStr, String message) {
        super(title, messageStr, message);
    }
}
