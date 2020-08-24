package com.unisource.universitysource;

import java.io.File;
import java.util.ArrayList;

public class Note {
    private int noteId;
    private Course course;
    private String writer;
    private User uploader;
    private byte[] file;
    private ArrayList<Tag> tags;
}
