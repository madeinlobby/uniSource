package com.unisource.universitysource.model;

import java.util.ArrayList;

public class Exam {
    private int examId;
    private Course course;
    private String writer;
    private User uploader;
    private ArrayList<Tag> tags;
    private byte[] file;

    public Exam(Course course, String writer, User uploader, ArrayList<Tag> tags, byte[] file) {
        this.course = course;
        this.writer = writer;
        this.uploader = uploader;
        this.tags = tags;
        this.file = file;
    }

    public Exam() {

    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
