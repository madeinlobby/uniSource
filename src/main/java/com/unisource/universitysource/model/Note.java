package com.unisource.universitysource.model;

import java.util.List;

public class Note {
    private int noteId;
    private Course course;
    private String writer;
    private User uploader;
    private byte[] file;
    private List<Tag> tags;

    public Note(Course course, String writer, User uploader, byte[] file, List<Tag> tags) {
        this.course = course;
        this.writer = writer;
        this.uploader = uploader;
        this.file = file;
        this.tags = tags;
    }

    public Note() {

    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
