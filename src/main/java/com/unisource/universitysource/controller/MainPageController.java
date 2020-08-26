package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.Note;
import com.unisource.universitysource.repository.ExamRepository;
import com.unisource.universitysource.service.ExamService;
import com.unisource.universitysource.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainPageController {
    private NoteService noteService;
    private ExamService examService;

    @PostMapping(/*address*/)
    public ResponseEntity<List<Note>> getAllNotesWithFilter(@RequestBody Map body) {
        //TODO list addign fiters to respond
        Map<String, String> filter = new HashMap<>();
        return new ResponseEntity<>(noteService.getAllNotes(filter), HttpStatus.OK);
    }

    @PostMapping(/*address*/)
    public ResponseEntity<List<Exam>> getAllExamsWithFilter(@RequestBody Map body) {
        //TODO list addign fiters to respond
        Map<String, String> filter = new HashMap<>();
        return new ResponseEntity<>(examService.getAllExams(filter), HttpStatus.OK);
    }
}
