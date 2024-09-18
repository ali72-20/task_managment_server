package com.example.task_managment_server.Services;

import com.example.task_managment_server.Entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServices {
    Task createTask(Task task);
    Task editTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> getTasks( Optional<String> statue);

}
