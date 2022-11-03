package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskControllerTest {

    private static final String PATH = "/v1/tasks";

    @Autowired
    private TaskController taskController;

    @Test
    void shouldGetTasksList() {

        //When
        ResponseEntity<List<TaskDto>> taskDtoList = taskController.getTasks();
        //Then
        assertEquals(taskDtoList.getBody().size(), 9);
    }

    @Test
    void shouldGetTask() throws TaskNotFoundException {

        //When
        ResponseEntity<TaskDto> taskDtoResponseEntity = taskController.getTask(3L);
        //Then
        assertEquals(taskDtoResponseEntity.getBody().getTitle(), "test 2");
    }

    @Test
    void shouldCreateTask() {
        //When
        ResponseEntity<TaskDto> task = taskController.createTask(new TaskDto(20L, "Test", "Test Content"));
        //Then
        assertThat(task.getStatusCode()).isEqualTo(HttpStatus.OK);
        //CleanUp
        taskController.deleteTask(task.getBody().getId());
    }

    @Test
    void shouldDeleteTask() {
        //Given
        ResponseEntity<TaskDto> task = taskController.createTask(new TaskDto(21L, "Test", "Test Content"));
        //When
        ResponseEntity<Object> responseEntity = taskController.deleteTask(task.getBody().getId());
        //Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
