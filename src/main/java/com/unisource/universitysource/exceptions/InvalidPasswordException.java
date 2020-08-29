package com.unisource.universitysource.exceptions;

public class InvalidPasswordException extends Exception {
    String password;

    public InvalidPasswordException(String message, String password) {
        super(message);
        this.password = password;
    }
    public InvalidPasswordException(String message ){
        super(message);
    }
}
