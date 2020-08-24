package com.unisource.universitysource.model;

public class Tag {
    private int tagId;
    private String tagName;
    private String color;

    public Tag(String tagName, String color) {
        this.tagName = tagName;
        this.color = color;
    }

    public Tag() {

    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
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
