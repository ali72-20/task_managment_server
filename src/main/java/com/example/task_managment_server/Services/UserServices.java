package com.example.task_managment_server.Services;

import com.example.task_managment_server.Entities.User;
import org.springframework.stereotype.Service;


@Service
public interface UserServices {
    User register(User user);
    User login(String username, String password);
}
