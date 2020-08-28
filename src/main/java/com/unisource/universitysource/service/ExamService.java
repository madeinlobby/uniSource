package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.Note;
import com.unisource.universitysource.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    public List<Exam> getAllExamOfSpecialCourse(int courseId){
        return examRepository.findAllByCourse_CourseId(courseId);
    }
    public Exam getSingleExam(int examId){
        return examRepository.findById(examId).get();

    }
    public void addExam(Exam newExam){
        examRepository.save(newExam);

    }
    public void deleteExamById(int examId){
        examRepository.deleteById(examId);

    }
    public List<Exam> getAllExams(Map filters){
        ArrayList<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }



}
