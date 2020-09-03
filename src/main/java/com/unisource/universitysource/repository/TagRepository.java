package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    Tag findByTagName(String name);

    void deleteByTagName(String tagName);

    Optional<Tag> findByTagNameAndColor(String tagName, String color);

    Boolean existsByTagNameAndColor(String tagName, String color);
}
