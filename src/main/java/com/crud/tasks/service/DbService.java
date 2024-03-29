package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    public Task getTaskById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }
    public Task getTask(final Long taskId) throws TaskNotFoundException {
        return repository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }

    public void deleteTaskById(Long id){
        repository.deleteById(id);
    }


}