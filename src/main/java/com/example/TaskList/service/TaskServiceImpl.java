package com.example.TaskList.service;

import com.example.TaskList.entity.Task;
import com.example.TaskList.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
        Сервис для работы с задачами.
        Предоставляет методы для создания, получения списка,
        получения задачи по ID.
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask(){
        return taskRepository.findAll();

    }
    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Task not found"));
    }
}
