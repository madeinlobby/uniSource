package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.*;
import com.unisource.universitysource.service.*;
import com.unisource.universitysource.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
            Note note = new Note(course, noteUploadRequest.getWriter(), uploader, file.getBytes(), tags);
            noteService.addNote(note);
            return ResponseEntity.ok(new MessageResponse("Note Added successfully."));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
        }
    }


}
