package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.OnlineExam;
import com.unisource.universitysource.repository.OnlineExamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OnlineExamService {
    @Autowired
    private OnlineExamRepository onlineExamRepository;
    public List<OnlineExam> getAllExamOfSpecialCourse(int courseId){
        return onlineExamRepository.findAllByCourse_CourseId(courseId);
    }
    public OnlineExam getSingleOnlineExam(int examId){
        return onlineExamRepository.findById(examId).get();

    }
    public void addOnlineExam(OnlineExam newExam){
        onlineExamRepository.save(newExam);

    }
    public void deleteOnlineExamById(int examId){
        onlineExamRepository.deleteById(examId);

    }
}
