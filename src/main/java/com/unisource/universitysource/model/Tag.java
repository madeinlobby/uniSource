package com.unisource.universitysource.model;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false, unique = true)
    private int tagId;

    @Column(name = "name", nullable = false)
    private String tagName;

    @Column(name = "color", nullable = false)
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
