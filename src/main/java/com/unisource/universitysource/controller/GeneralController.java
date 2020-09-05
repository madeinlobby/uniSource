package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.AllCoursesAndTagsResponse;
import com.unisource.universitysource.service.CourseService;
import com.unisource.universitysource.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
    @Autowired
    private TagService tagService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/get-all-tags-courses")
    public ResponseEntity<?> getAllTagsAndCourses() {
        AllCoursesAndTagsResponse response = new AllCoursesAndTagsResponse(
                courseService.getAllCourses(), tagService.getAllTags()
        );
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all-tags")
    public ResponseEntity<?> getAllTags() {
        return ResponseEntity.ok().body(tagService.getAllTags());
    }

    @GetMapping("/all-courses")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }
}
