package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.Note;
import com.unisource.universitysource.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteService {
    @Autowired
    NoteRepository noteRepository;
    public List<Note> getAllNoteOfSpecialCourse(int courseId){
        return noteRepository.findAllByCourse_CourseId(courseId);
    }
    public Note getSingleNote(int noteId){
       return noteRepository.findById(noteId).get();
    }
    public void addNote(Note newNote){
        noteRepository.save(newNote);

    }
    public void deleteNoteById(int noteId){
       noteRepository.deleteById(noteId);
    }
}
