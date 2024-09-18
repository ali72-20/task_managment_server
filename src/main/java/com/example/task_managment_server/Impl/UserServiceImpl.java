package com.example.task_managment_server.Impl;

import com.example.task_managment_server.Entities.User;
import com.example.task_managment_server.Repositary.UserRepository;
import com.example.task_managment_server.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user != null && Objects.equals(password, user.getPassword())){
            return user;
        }
        throw  new RuntimeException("Invalid user");
    }
}
