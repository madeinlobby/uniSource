package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.ExamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResponseRepository extends JpaRepository<ExamResponse, Integer> {
}
