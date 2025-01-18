package com.example.creature_site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.creature_site.model.Task;
import com.example.creature_site.services.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Controller {
    
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks/all")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks")
    public List<Task> getTaskByStatus(@RequestParam boolean status) {
        return taskService.getTaskByStatus(status);
    }
    
    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
        return taskService.save(task);
    }   

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskByID(@PathVariable int id) {
        taskService.deleteById(id);
    }
}
