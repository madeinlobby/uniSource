package com.unisource.universitysource.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note")
public class NoteResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id", nullable = false, unique = true)
    private int noteId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course", referencedColumnName = "course_id", foreignKey = @ForeignKey(name = "FK_Note_Course"), nullable = false)
    private Course course;

    @Column(name = "writer")
    private String writer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uploader", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "FK_Note_Uploader"), nullable = false)
    private User uploader;

    @ManyToMany
    @JoinTable(
            name = "note_tag",
            joinColumns = @JoinColumn(name = "note"),
            inverseJoinColumns = @JoinColumn(name = "tag"))
    private List<Tag> tags;

    public NoteResponse(Course course, String writer, User uploader, List<Tag> tags) {
        this.course = course;
        this.writer = writer;
        this.uploader = uploader;
        this.tags = tags;
    }

    public NoteResponse() {

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
