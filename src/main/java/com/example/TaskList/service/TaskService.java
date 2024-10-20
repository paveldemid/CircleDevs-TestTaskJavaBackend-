package com.example.TaskList.service;

import com.example.TaskList.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
}
