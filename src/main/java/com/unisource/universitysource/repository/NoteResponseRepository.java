package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.NoteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteResponseRepository extends JpaRepository<NoteResponse, Integer> {
}
