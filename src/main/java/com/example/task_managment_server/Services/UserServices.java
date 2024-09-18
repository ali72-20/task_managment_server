package com.example.task_managment_server.Services;

import com.example.task_managment_server.Entities.User;

public interface UserServices {
    User register(User user);
    User login(String username, String password);
}
