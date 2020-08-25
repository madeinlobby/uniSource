package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Exam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Integer> {
    List<Exam> findAllByCourse_CourseId(int courseId);
}
