package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Tag;
import com.unisource.universitysource.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void addTag(Tag tag){
        tagRepository.save(tag);

    }
    public void deleteTagByName(String tagName){
        tagRepository.deleteTagByName(tagName);
    }
    public void deleteTagById(int id){
        tagRepository.deleteById(id);
    }
    public void editTag(Tag newTag){
        tagRepository.save(newTag);

    }
    public Tag getSingleTagByName(String name){
        return tagRepository.findByName_TagName(name);
    }
    public Tag getSingleTagById(int id){
        return tagRepository.findById(id).get();


    }
}
