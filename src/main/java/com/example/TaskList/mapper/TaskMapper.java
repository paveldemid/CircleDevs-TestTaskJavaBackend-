package com.example.TaskList.mapper;

import com.example.TaskList.dto.TaskDTO;
import com.example.TaskList.entity.Task;
import org.springframework.stereotype.Component;

/**
        Класс-маппер для преобразования объектов Task и TaskDTO.
        Этот класс предоставляет методы для преобразования объектов Task в TaskDTO и наоборот.
 */

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        return dto;
    }
    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        return task;
    }
}
