package com.unisource.universitysource.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class NoteExpensePstDto {
    private MultipartFile file;
    private int courseId;
    private List<Integer> tags;
    private String writer;

    public NoteExpensePstDto(MultipartFile file, int courseId, List<Integer> tags, String writer) {
        this.file = file;
        this.courseId = courseId;
        this.tags = tags;
        this.writer = writer;
    }

    public NoteExpensePstDto() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
