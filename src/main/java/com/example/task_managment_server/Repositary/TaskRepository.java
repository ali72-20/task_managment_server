package com.example.task_managment_server.Repositary;

import com.example.task_managment_server.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatueAndId(String statue, Long id);

    List<Task> findByUserId(Long userId);
}
