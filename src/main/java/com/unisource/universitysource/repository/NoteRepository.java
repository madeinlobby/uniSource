package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
    List<Note> findAllByCourse_CourseId(int courseId);
}
