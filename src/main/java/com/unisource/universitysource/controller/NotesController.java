package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.*;
import com.unisource.universitysource.repository.NoteResponseRepository;
import com.unisource.universitysource.service.*;
import com.unisource.universitysource.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/notes")
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

    @PostMapping("/upload")
    public ResponseEntity<?> uploadNotes(@RequestParam("file")MultipartFile file, @RequestBody NoteUploadRequest noteUploadRequest, @RequestHeader(value = "Authorization") String token) {
        if (token == null || !token.startsWith("Bearer "))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        if (!jwtUtil.validateToken(jwt, userDetail))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        User uploader = userService.getUserByName(username);
        Course course = courseService.getSingleCourseById(noteUploadRequest.getCourseId());
        List<Tag> tags = new ArrayList<>();
        for (TagRequest tag : noteUploadRequest.getTags()) {
            if (tagService.existTagByNameAndColor(tag.getTagName(), tag.getColor())) {
                tags.add(tagService.getTagByNameAndColor(tag.getTagName(), tag.getColor()));
            } else {
                Tag newTag = new Tag(tag.getTagName(), tag.getColor());
                tagService.addTag(newTag);
                tags.add(newTag);
            }
        }
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Note note = new Note(course, noteUploadRequest.getWriter(), uploader, file.getBytes(), fileName, file.getContentType(), tags);
            noteService.addNote(note);
            return ResponseEntity.ok(new MessageResponse("Note Added successfully."));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllNotes() {
        return ResponseEntity.ok().body(noteResponseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable int id) {
        if (noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        return ResponseEntity.ok().body(noteResponseRepository.findById(id).get());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadNote(@PathVariable int id) {
        if (noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        Note note = noteService.getSingleNote(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + note.getNoteId() + "\"").body(note.getFile());
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<?> getNoteTags(@PathVariable int id) {
        if (noteService.existNoteById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        NoteResponse noteResponse = noteResponseRepository.findById(id).get();
        return ResponseEntity.ok().body(noteResponse.getTags());
    }

}
