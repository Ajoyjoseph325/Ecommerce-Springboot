package com.example.Ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Ecommerce.dto.LoginRequest;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService uService;

    @GetMapping("/register")
    public ResponseEntity<User> registeruser(@RequestBody User user){
        

            uService.createUesr(user);
            return ResponseEntity.ok(user);
         
    }
    

    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginrequest){
        if(loginrequest.getEmail() == null || loginrequest.getPassword() == null){
            return ResponseEntity.badRequest().body("username or password must not be empty");


        }
        Optional<User> user = uService.login(loginrequest.getEmail(), loginrequest.getPassword());

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
            
        }
        else{
            return ResponseEntity.badRequest().body("username password does not exist");
        }
    

    }
    
}
