package com.example.task_managment_server.Impl;

import com.example.task_managment_server.Entities.Task;
import com.example.task_managment_server.Repositary.TaskRepository;
import com.example.task_managment_server.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServicesImpl implements TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task editTask(Long id, Task task) {
        if (taskRepository.existsById(id)){
           task.setId(id);
           return taskRepository.save(task);
        }
        throw new RuntimeException("Task not found");
    }

    @Override
    public void deleteTask(Long id) {
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }else{
            throw new RuntimeException("Task not found");
        }
    }
    @Override
    public List<Task> getTasks(Optional<String> statue, Long userId) {
        return statue
                .map(s -> taskRepository.findByStatueAndId(s, userId))
                .orElseGet(() -> taskRepository.findByUserId(userId));
    }
}
