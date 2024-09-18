package com.example.task_managment_server.controllers;

import com.example.task_managment_server.Entities.User;
import com.example.task_managment_server.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServices userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        userService.login(loginRequest.getUsername(),loginRequest.getPassword());
        return ResponseEntity.ok().build();
    }
}
