package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Tag;
import com.unisource.universitysource.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void addTag(Tag tag){
        tagRepository.save(tag);

    }
    public void deleteTagByName(String tagName){
        tagRepository.deleteByTagName(tagName);
    }
    public void deleteTagById(int id){
        tagRepository.deleteById(id);
    }
    public void editTag(Tag newTag){
        tagRepository.save(newTag);

    }
    public Tag getSingleTagByName(String name){
        return tagRepository.findByTagName(name);
    }
    public Tag getSingleTagById(int id){
        return tagRepository.findById(id).get();


    }
}
