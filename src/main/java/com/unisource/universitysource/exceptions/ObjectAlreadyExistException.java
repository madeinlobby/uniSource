package com.unisource.universitysource.exceptions;

public class ObjectAlreadyExistException extends Exception {
    private String key;
    private String obj;

    public ObjectAlreadyExistException(String message, String key, String obj) {
        super(message);
        this.key = key;
        this.obj = obj;
    }
}
