package com.unisource.universitysource.model;

public class TagRequest {
    private String tagName;
    private String color;

    public TagRequest(String tagName, String color) {
        this.tagName = tagName;
        this.color = color;
    }

    public TagRequest() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
