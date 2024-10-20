package com.example.TaskList.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
       Сущность "Задача" (Task) для приложения TaskList.
       Представляет собой объект, содержащий информацию о задаче.
 */

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
