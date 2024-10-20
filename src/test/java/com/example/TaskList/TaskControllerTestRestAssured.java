package com.example.TaskList;

import com.example.TaskList.dto.TaskDTO;
import com.example.TaskList.facade.TaskFacade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTestRestAssured {

    @MockBean
    private TaskFacade taskFacade;

    @LocalServerPort
    private int port;

    @Test
    public void testCreateTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Test Task");

        // Настройка мока для facade
        when(taskFacade.createTask(any(TaskDTO.class))).thenReturn(taskDTO);

        given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(taskDTO)
                .when()
                .post("/api/tasks")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("title", equalTo("Test Task"));
    }

    @Test
    public void testGetAllTasks() {
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTitle("Task 1");

        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setTitle("Task 2");

        // Настройка мока для facade
        when(taskFacade.getAllTasks()).thenReturn(List.of(taskDTO1, taskDTO2));

        given()
                .port(port)
                .when()
                .get("/api/tasks")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("[0].title", equalTo("Task 1"))
                .body("[1].title", equalTo("Task 2"));
    }
}