package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.*;
import com.unisource.universitysource.repository.NoteResponseRepository;
import com.unisource.universitysource.service.*;
import com.unisource.universitysource.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotesController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private NoteResponseRepository noteResponseRepository;

    @PostMapping("/note/upload")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> uploadNotes(@ModelAttribute NoteExpensePstDto noteExpensePstDto, @RequestHeader(value = "Authorization") String token) {
        if (token == null || !token.startsWith("Bearer "))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        if (!jwtUtil.validateToken(jwt, userDetail))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        User uploader = userService.getUserByName(username);
        Course course = courseService.getSingleCourseById(noteExpensePstDto.getCourseId());
        List<Tag> tags = noteExpensePstDto.getTags().stream().map(tag -> tagService.getSingleTagById(tag)).collect(Collectors.toList());
        try {
            String fileName = StringUtils.cleanPath(noteExpensePstDto.getFile().getOriginalFilename());
            Note note = new Note(course, noteExpensePstDto.getWriter(), uploader, noteExpensePstDto.getFile().getBytes(), fileName, noteExpensePstDto.getFile().getContentType(), tags);
            noteService.addNote(note);
            return ResponseEntity.ok(new MessageResponse("Note Added successfully."));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
        }
    }

    @GetMapping("/note/all")
    public ResponseEntity<?> getAllNotes() {
        System.out.println("all");
        System.out.println(noteResponseRepository.findAll());
        return ResponseEntity.ok().body(noteResponseRepository.findAll());
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable int id) {
        if (!noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        return ResponseEntity.ok().body(noteResponseRepository.findById(id).get());
    }

    @GetMapping("/note/download/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> downloadNote(@PathVariable int id) {
        if (!noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        Note note = noteService.getSingleNote(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + note.getFileName() + "\"").body(note.getFile());
    }

    @GetMapping("/note/tags/{id}")
    public ResponseEntity<?> getNoteTags(@PathVariable int id) {
        if (!noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        NoteResponse noteResponse = noteResponseRepository.findById(id).get();
        return ResponseEntity.ok().body(noteResponse.getTags());
    }

    @GetMapping("/note/page/{number}")
    public ResponseEntity<?> getExamsWithPagination(@PathVariable int number) {
        List<NoteResponse> responses = noteResponseRepository.findAll();
        if (responses.size() <= (number - 1) * 10)
            return ResponseEntity.ok().body(responses.subList((number - 1) * 10, number * 10));
        else if (responses.size() > (number - 1) * 10 && responses.size() <= number * 10)
            return ResponseEntity.ok().body(responses.subList((number - 1) * 10, responses.size()));
        else
            return ResponseEntity.badRequest().body(new MessageResponse("page is out of range."));
    }

    @PutMapping("/note/like/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> likeExamPost(@PathVariable int id) {
        if (!noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        Note note = noteService.getSingleNote(id);
        note.setLikes(note.getLikes() + 1);
        noteService.updateNote(note);
        return ResponseEntity.ok().body(new MessageResponse("post liked successfully."));
    }

}
