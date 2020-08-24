package com.unisource.universitysource.model;

import java.util.ArrayList;

public class OnlineExam {
    private int onlineCourseId;
    private Course course;
    private ArrayList<Question> questions;
    private ArrayList<Tag> tags;

    public OnlineExam(Course course, ArrayList<Question> questions, ArrayList<Tag> tags) {
        this.course = course;
        this.questions = questions;
        this.tags = tags;
    }

    public OnlineExam() {

    }

    public int getOnlineCourseId() {
        return onlineCourseId;
    }

    public void setOnlineCourseId(int onlineCourseId) {
        this.onlineCourseId = onlineCourseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}