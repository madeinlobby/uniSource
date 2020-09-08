package com.unisource.universitysource.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class ExamExpensePostDto {
    private MultipartFile file;
    private int courseId;
    private List<Integer> tags;
    private Date date;

    public ExamExpensePostDto(MultipartFile file, int courseId, List<Integer> tags, Date date) {
        this.file = file;
        this.courseId = courseId;
        this.tags = tags;
        this.date = date;
    }

    public ExamExpensePostDto() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
