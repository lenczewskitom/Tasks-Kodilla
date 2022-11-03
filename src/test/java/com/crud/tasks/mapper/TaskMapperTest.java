package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        // Given
        Long taskDtoId = 1L;
        String taskDtoTitle = "taskDtoTitle";
        String taskDtoContent = "taskDtoContent";
        TaskDto taskDto = new TaskDto(taskDtoId, taskDtoTitle, taskDtoContent);
        // When
        Task task = taskMapper.mapToTask(taskDto);
        // Then
        assertEquals(taskDtoId, task.getId());
        assertEquals(taskDtoTitle, task.getTitle());
        assertEquals(taskDtoContent, task.getContent());
    }

    @Test
    void testMapToTaskDto() {
        // Given
        Long taskId = 1L;
        String taskTitle = "taskTitle";
        String taskContent = "taskContent";
        Task task = new Task(taskId, taskTitle, taskContent);
        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        // Then
        assertEquals(taskId, task.getId());
        assertEquals(taskTitle, task.getTitle());
        assertEquals(taskContent, task.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        // Given
        Long taskId = 1L;
        String taskTitle = "taskTitle";
        String taskContent = "taskContent";
        Task task = new Task(taskId, taskTitle, taskContent);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        // When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);
        // Then
        assertEquals(1, taskDtos.size());
        assertEquals(taskId, taskDtos.get(0).getId());
        assertEquals(taskTitle, taskDtos.get(0).getTitle());
        assertEquals(taskContent, taskDtos.get(0).getContent());
    }
}
