package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.User;
import com.unisource.universitysource.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private UserService userService;
    //@PostMapping(/*address*/)
    public ResponseEntity<String> register(@RequestBody Map body) {
        //TODO no idea of
        String username = null;// = username
        String password = null;// = username
        String firstName = null;// = username
        String lastName = null;// = username


        if(userService.getUserByName(username) != null){
            return new ResponseEntity<>("userName is already taken", HttpStatus.OK);
        }
        User user = new User(username,password,firstName,lastName);
        userService.addUser(user);
        return new ResponseEntity<>("successful", HttpStatus.OK);
    }

}
