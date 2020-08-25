package com.unisource.universitysource.model;

import java.util.List;

public class OnlineExam {
    private int onlineExamId;
    private Course course;
    private List<Question> questions;
    private List<Tag> tags;

    public OnlineExam(Course course, List<Question> questions, List<Tag> tags) {
        this.course = course;
        this.questions = questions;
        this.tags = tags;
    }

    public OnlineExam() {

    }

    public int getOnlineExamId() {
        return onlineExamId;
    }

    public void setOnlineExamId(int onlineExamId) {
        this.onlineExamId = onlineExamId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}