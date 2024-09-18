package com.example.task_managment_server.Impl;
import com.example.task_managment_server.Entities.User;
import com.example.task_managment_server.Repositary.UserRepository;
import com.example.task_managment_server.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
         userRepository.save(user);
         return "Ok";
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())){
            return user;
        }
        throw new BadCredentialsException("Invalid password for user: " + username);
    }
}
