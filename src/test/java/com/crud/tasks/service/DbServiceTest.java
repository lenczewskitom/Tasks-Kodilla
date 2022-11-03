package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    void shouldGetAllTasks() {
        // Given
        Task task = new Task(3L, "test 2", "test 2");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        when(repository.findAll()).thenReturn(tasks);
        // When
        int size = dbService.getAllTasks().size();
        // Then
        assertEquals(1, size);
    }

    @Test
    void shouldSaveTask() {
        // Given
        Task task = new Task(3L, "test 2", "test 2");
        when(repository.save(task)).thenReturn(task);
        // When
        String title = dbService.saveTask(task).getTitle();
        // Then
        assertEquals("test 2", title);
    }

    @Test
    void shouldGetTask() throws TaskNotFoundException {
        // Given
        Task task = new Task(3L, "test 2", "test 2");
        Optional<Task> optionalTask = Optional.of(task);
        when(repository.findById(3L)).thenReturn(optionalTask);
        // When
        Optional<Task> fetchedTask = Optional.ofNullable(dbService.getTask(3L));
        // Then
        assertEquals(optionalTask, fetchedTask);
    }
}

