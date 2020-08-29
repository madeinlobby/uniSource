package com.unisource.universitysource.exceptions;

public class NotFoundObjectException  extends Exception{

    private String key;
    private  String searchingObj;

    public NotFoundObjectException(String message, String key, String searchingObj) {
        super(message);
        this.key = key;
        this.searchingObj = searchingObj;
    }

    public NotFoundObjectException(String key) {
        this.key = key;
    }

    public NotFoundObjectException(String message, String key) {
        super(message);
        this.key = key;
    }
}
