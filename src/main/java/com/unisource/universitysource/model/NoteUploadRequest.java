package com.unisource.universitysource.model;

import java.util.ArrayList;
import java.util.List;

public class NoteUploadRequest {
    private int courseId;
    private String writer;
    private List<TagRequest> tags;

    public NoteUploadRequest(int courseId, String writer, List<TagRequest> tags) {
        this.courseId = courseId;
        this.writer = writer;
        this.tags = tags;
    }

    public NoteUploadRequest() {
        this.tags = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public List<TagRequest> getTags() {
        return tags;
    }

    public void setTags(List<TagRequest> tags) {
        this.tags = tags;
    }
}
