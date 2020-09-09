package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Note;
import com.unisource.universitysource.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> getAllNoteOfSpecialCourse(int courseId) {
        return noteRepository.findAllByCourse_CourseId(courseId);
    }

    public Note getSingleNote(int noteId) {
        return noteRepository.findById(noteId).get();
    }

    public void addNote(Note newNote) {
        noteRepository.save(newNote);
    }

    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNoteById(int noteId) {
        noteRepository.deleteById(noteId);
    }

    public List<Note> getAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public Boolean existNoteById(int noteId) {
        return noteRepository.existsByNoteId(noteId);
    }
}
