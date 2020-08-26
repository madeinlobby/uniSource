package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
     Tag findByTagName(String name);
     void deleteByTagName(String tagName);

}
