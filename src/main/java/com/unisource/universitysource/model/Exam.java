package com.unisource.universitysource.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id", nullable = false, unique = true)
    private int examId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course", referencedColumnName = "course_id", foreignKey = @ForeignKey(name = "FK_Exam_Course"), nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uploader", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "FK_Exam_Uploader"), nullable = false)
    private User uploader;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exam_date", nullable = false)
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "exam_tag",
            joinColumns = @JoinColumn(name = "exam"),
            inverseJoinColumns = @JoinColumn(name = "tag"))
    private List<Tag> tags;

    @Lob
    @Column(name = "file", columnDefinition = "longblob")
    private byte[] file;

    public Exam(Course course, User uploader, Date date, List<Tag> tags, byte[] file) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
