package com.example.Ecommerce.service;

import java.lang.classfile.ClassFile.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userrepo;
    


    public User createUesr(User user){

        return userrepo.save(user);


        
    }
    public Optional<User> login(String username, String password){
        
        return userrepo.findByEmailAndPassword(username,password );
        


    }
    
}
