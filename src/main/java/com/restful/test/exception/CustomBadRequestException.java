package com.restful.test.exception;

public class CustomBadRequestException extends Exception {
    public CustomBadRequestException(String message){
        super(message);
    }
}
