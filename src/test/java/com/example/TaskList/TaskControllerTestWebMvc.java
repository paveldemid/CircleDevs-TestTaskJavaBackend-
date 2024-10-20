package com.example.TaskList;

import com.example.TaskList.controller.TaskController;
import com.example.TaskList.dto.TaskDTO;
import com.example.TaskList.facade.TaskFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTestWebMvc {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskFacade taskFacade;

    @Test
    public void testCreateTask() throws Exception {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Test Task");

        // Настройка мока для facade
        when(taskFacade.createTask(any(TaskDTO.class))).thenReturn(taskDTO);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Test Task\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Task"));
    }

    @Test
    public void testGetAllTasks() throws Exception {
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTitle("Task 1");

        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setTitle("Task 2");

        // Настройка мока для facade
        when(taskFacade.getAllTasks()).thenReturn(List.of(taskDTO1, taskDTO2));

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[1].title").value("Task 2"));
    }
}