package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Question;
import com.unisource.universitysource.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question getById(int id) {
        return questionRepository.findById(id).get();
    }

    public void edit(Question question) {
        questionRepository.save(question);
    }

    public void deleteById(int id) {
        questionRepository.deleteById(id);
    }

}
