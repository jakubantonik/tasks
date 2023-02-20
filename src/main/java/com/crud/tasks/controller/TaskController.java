package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;


    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }
    @GetMapping (value = "/tasks/id={taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId){
        return taskMapper.mapToTaskDto(service.getTaskById(taskId));
    }

    @GetMapping(value = "{taskId}")
    public TaskDto getTask(Long taskId){
        return new TaskDto(1L, "test title", "test_content");
    }
    @DeleteMapping(value = "{taskId}")
    public void deleteTask(Long taskId){

    }
    @PutMapping(value = "/{id}/{title}/{content}")
    public TaskDto updateTask(TaskDto task){
        return new TaskDto(1L, "Edited test title", "Test content");
    }
    @PostMapping(value = "{id}")
    public void createTask(TaskDto task){
        
    }
}
