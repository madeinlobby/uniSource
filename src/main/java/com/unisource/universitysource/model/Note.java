package com.unisource.universitysource.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note")
public class Note {
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

    @Lob
    @Column(name = "file", columnDefinition = "longblob")
    private byte[] file;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_type", nullable = false)
    private String fileType;

    @ManyToMany
    @JoinTable(
            name = "note_tag",
            joinColumns = @JoinColumn(name = "note"),
            inverseJoinColumns = @JoinColumn(name = "tag"))
    private List<Tag> tags;

    @Column(name = "likes", nullable = false)
    private int likes;

    public Note(Course course, String writer, User uploader, byte[] file, String fileName, String fileType, List<Tag> tags) {
        this.course = course;
        this.writer = writer;
        this.uploader = uploader;
        this.file = file;
        this.fileName = fileName;
        this.fileType = fileType;
        this.tags = tags;
        this.likes = 0;
    }

    public Note() {
        this.likes = 0;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
