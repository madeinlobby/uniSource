package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.*;
import com.unisource.universitysource.repository.ExamResponseRepository;
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
public class ExamController {
    @Autowired
    private ExamService examService;
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
    private ExamResponseRepository examResponseRepository;

    @PostMapping("/exam/upload")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> uploadExams(@ModelAttribute ExamExpensePostDto examExpensePostDto, @RequestHeader(value = "Authorization") String token) {
        if (token == null || !token.startsWith("Bearer "))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        if (!jwtUtil.validateToken(jwt, userDetail))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        User uploader = userService.getUserByName(username);
        Course course = courseService.getSingleCourseById(examExpensePostDto.getCourseId());
        List<Tag> tags = examExpensePostDto.getTags().stream().map(tag -> tagService.getSingleTagById(tag)).collect(Collectors.toList());
        try {
            String fileName = StringUtils.cleanPath(examExpensePostDto.getFile().getOriginalFilename());
            Exam exam = new Exam(course, uploader, examExpensePostDto.getDate(), tags, examExpensePostDto.getFile().getBytes(), fileName, examExpensePostDto.getFile().getContentType());
            examService.addExam(exam);
            return ResponseEntity.ok(new MessageResponse("Note Added successfully."));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
        }
    }

    @GetMapping("/exam/all")
    public ResponseEntity<?> getAllExams() {
        return ResponseEntity.ok().body(examResponseRepository.findAll());
    }

    @GetMapping("/exam/{id}")
    public ResponseEntity<?> getExamById(@PathVariable int id) {
        if (!examService.existExamById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        return ResponseEntity.ok().body(examResponseRepository.findById(id).get());
    }

    @GetMapping("/exam/download/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> downloadExam(@PathVariable int id) {
        if (!examService.existExamById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        Exam exam = examService.getSingleExam(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + exam.getFileName() + "\"").body(exam.getFile());
    }

    @GetMapping("/exam/tags/{id}")
    public ResponseEntity<?> getExamTags(@PathVariable int id) {
        if (!examService.existExamById(id))
            return ResponseEntity.badRequest().body(new MessageResponse("not found note with this id"));
        ExamResponse examResponse = examResponseRepository.findById(id).get();
        return ResponseEntity.ok().body(examResponse.getTags());
    }

    @GetMapping("/exam/page/{number}")
    public ResponseEntity<?> getExamsWithPagination(@PathVariable int number) {
        List<ExamResponse> responses = examResponseRepository.findAll();
        if (responses.size() <= (number - 1) * 10)
            return ResponseEntity.ok().body(responses.subList((number - 1) * 10, number * 10));
        else if (responses.size() > (number - 1) * 10 && responses.size() <= number * 10)
            return ResponseEntity.ok().body(responses.subList((number - 1) * 10, responses.size()));
        else
            return ResponseEntity.badRequest().body(new MessageResponse("page is out of range."));
    }
}
