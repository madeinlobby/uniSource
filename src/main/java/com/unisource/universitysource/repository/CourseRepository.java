package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> getAllCourseWithFilter(Map<String,String> maps );
}
