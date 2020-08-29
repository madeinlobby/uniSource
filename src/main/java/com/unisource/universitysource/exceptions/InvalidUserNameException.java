package com.unisource.universitysource.exceptions;

public class InvalidUserNameException extends Exception {
    String userName;
    public InvalidUserNameException(String message) {
        super(message);
    }

    public InvalidUserNameException(String message, String userName) {
        super(message);
        this.userName = userName;
    }
}
