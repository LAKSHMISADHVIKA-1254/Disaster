package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    // REGISTER
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    // LOGIN ✅ ADD THIS
    public User login(String email, String password){

        User user = repo.findByEmail(email);

        if(user != null && encoder.matches(password, user.getPassword())){
            return user; // ✅ success
        }

        return null; // ❌ fail
    }

    // FIND USER
    public User findByEmail(String email){
        return repo.findByEmail(email);
    }
}