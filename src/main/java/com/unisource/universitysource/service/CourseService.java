package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Course;
import com.unisource.universitysource.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }
    public void addCourse(Course newCourse){
        courseRepository.save(newCourse);
    }

    public void deleteCourseById(int id){
        courseRepository.deleteById(id);
    }

    public void deleteCourseByCourseName(String name){
        courseRepository.deleteByCourseName(name);
    }

    public void deleteCourseByCourseCode(String code){
        courseRepository.deleteByCourseCode(code);
    }

    public void edit(int id, Course newCourse){
        courseRepository.save(newCourse);
    }

    public Course getSingleCourseById(int id){
        return courseRepository.findById(id).get();
    }

    public Course getSingleCourseByCourseCode(String code){
        return courseRepository.findByCourseCode(code);
    }
}
