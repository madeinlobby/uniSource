package com.unisource.universitysource.service;

import com.unisource.universitysource.model.Course;
import com.unisource.universitysource.model.*;
import com.unisource.universitysource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);

    }

    public void editUser(User editedUser) {
        userRepository.save(editedUser);
    }

    public void deleteUserById(int id) {

        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();

    }

    public User getUserByName(String name) {
        return userRepository.findByName_UserName(name);
    }


}
