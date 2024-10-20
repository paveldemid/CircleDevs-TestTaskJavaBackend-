package com.example.TaskList.dto;

import lombok.Data;

/**
  DTO (Data Transfer Object) для представления задачи.
  Используется для передачи данных о задаче между различными компонентами приложения.
 */

@Data
public class TaskDTO {
    private Long id;
    private String title;
}
