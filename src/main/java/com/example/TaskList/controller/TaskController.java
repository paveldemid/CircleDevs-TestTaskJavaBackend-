package com.example.TaskList.controller;

import com.example.TaskList.dto.TaskDTO;
import com.example.TaskList.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
     Контроллер для управления задачами.
    Предоставляет API для создания и получения задач.
 */

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskFacade taskFacade;

    // Создание задачи
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        TaskDTO createdTask = taskFacade.createTask(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    // Получение всех задач
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<TaskDTO> tasks = taskFacade.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    /*
    // Получение задачи по ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        TaskDTO task = taskFacade.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    */
}
