package com.SpringApi.SpringApi11.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) { //create contructor

        super(message);
    }
}
