package com.example.TaskList.facade;

import com.example.TaskList.dto.TaskDTO;
import com.example.TaskList.entity.Task;
import com.example.TaskList.mapper.TaskMapper;
import com.example.TaskList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
        Фасад для работы с задачами.
        Предоставляет методы для создания, получения всех, получения по ID,
        а также для преобразования объектов между DTO и Entity.
 */

@Component
public class TaskFacade {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    public TaskDTO createTask(TaskDTO dto) {
        Task task = taskMapper.toEntity(dto); // Создаем задачу без категории
        Task createdTask = taskService.createTask(task);
        return taskMapper.toDTO(createdTask);
    }
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskService.getAllTask();
        return tasks.stream().map(taskMapper::toDTO).collect(Collectors.toList());
    }
    public TaskDTO getTaskById(Long id) {
        Task task = taskService.getTaskById(id);
        return taskMapper.toDTO(task);
    }
}

