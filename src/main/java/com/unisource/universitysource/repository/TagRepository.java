package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Exam;
import com.unisource.universitysource.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
     Tag findByName_TagName(String name);
     void deleteTagByName(String tagName);

}
