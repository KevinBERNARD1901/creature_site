package com.example.creature_site.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.creature_site.Repositories.TaskRepository;
import com.example.creature_site.model.Task;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTaskByStatus(boolean status) {
        return taskRepository.findByStatus(status);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }
}
