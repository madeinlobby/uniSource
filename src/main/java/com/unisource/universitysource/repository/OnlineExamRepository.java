package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.OnlineExam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineExamRepository extends CrudRepository<OnlineExam, Integer> {
}
