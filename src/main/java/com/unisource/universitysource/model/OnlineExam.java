package com.unisource.universitysource.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "online_exam")
public class OnlineExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "online_exam_id", nullable = false, unique = true)
    private int onlineExamId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course", referencedColumnName = "course_id", foreignKey = @ForeignKey(name = "FK_OnlineExam_Course"), nullable = false)
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "online_exam_question",
            joinColumns = @JoinColumn(name = "online_exam"),
            inverseJoinColumns = @JoinColumn(name = "question"))
    private List<Question> questions;

    @ManyToMany
    @JoinTable(
            name = "online_exam_tag",
            joinColumns = @JoinColumn(name = "online_exam"),
            inverseJoinColumns = @JoinColumn(name = "tag"))
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