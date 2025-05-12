package com.example.AiPlatform.services;

import com.example.AiPlatform.models.Task;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TaskRepository {
    void createTask(Task task);

    Task getTask(Integer id);

    void updateTask(Task updateTask);

    void deleteTask(Integer id);

    Map<Integer, Task> getTaskList();
}