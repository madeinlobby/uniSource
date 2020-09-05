package com.unisource.universitysource.model;

import java.util.List;

public class AllCoursesAndTagsResponse {
    private List<Course> courses;
    private List<Tag> tags;

    public AllCoursesAndTagsResponse(List<Course> courses, List<Tag> tags) {
        this.courses = courses;
        this.tags = tags;
    }

    public AllCoursesAndTagsResponse() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
