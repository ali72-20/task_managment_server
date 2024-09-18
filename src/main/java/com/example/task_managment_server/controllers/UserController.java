package com.example.task_managment_server.controllers;

import com.example.task_managment_server.Entities.User;
import com.example.task_managment_server.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServices userService;

    @PostMapping("/register")
    public Map<String,String> register(@RequestBody User user) {
        User newUser = userService.register(user);
        HashMap<String,String> map = new HashMap<>();
        map.put("Statue", "Ok");
        map.put("username", newUser.getUsername());
        map.put("id", newUser.getId().toString());
        return map;
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest loginRequest) {
       User user = userService.login(loginRequest.getUsername(),loginRequest.getPassword());
        HashMap<String,String> map = new HashMap<>();
        map.put("Statue", "Ok");
        map.put("username", user.getUsername());
        map.put("id", user.getId().toString());
        return map;
    }
}
