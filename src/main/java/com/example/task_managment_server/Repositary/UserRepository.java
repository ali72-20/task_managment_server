package com.example.task_managment_server.Repositary;

import com.example.task_managment_server.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
