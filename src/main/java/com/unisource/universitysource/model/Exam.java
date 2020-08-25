package com.unisource.universitysource.model;

import java.time.LocalDate;
import java.util.List;

public class Exam {
    private int examId;
    private Course course;
    private User uploader;
    private LocalDate date;
    private List<Tag> tags;
    private byte[] file;

    public Exam(Course course, User uploader, LocalDate date, List<Tag> tags, byte[] file) {
        this.course = course;
        this.uploader = uploader;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
