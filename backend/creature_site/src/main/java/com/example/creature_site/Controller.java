package com.example.creature_site;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.creature_site.model.Domain;
import com.example.creature_site.model.Task;
import com.example.creature_site.services.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Controller {
    
    @Autowired
    TaskService taskService;

    // GetMapping
    @GetMapping("/tasks/{taskId}")
    public Task getTaskById(@PathVariable int taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/taskDone")
    public List<Task> getTaskByStatus(@RequestParam boolean taskDone) {
        return taskService.getTaskByStatus(taskDone);
    }
    
    @GetMapping("/tasks/projectDomain")
    public List<Task> getTaskByProject_domain(@RequestParam Domain projectDomain) {
        return taskService.getTaskByProject_domain(projectDomain);
    }
    
    // PostMapping
    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
        return taskService.save(task);
    }   

    // DeleteMapping
    @DeleteMapping("/tasks/{taskId}")
    public void deleteTaskByID(@PathVariable int taskId) {
        taskService.deleteById(taskId);
    }

    // PatchMapping
    @PatchMapping("/tasks/taskDone/{taskId}")
    public void PatchTaskTaskDone(@PathVariable int taskId) {
        taskService.patchTaskTaskDone(taskId);
    }

    @PatchMapping("tasks/timePassedOnIt/{taskId}")
    public void PatchTaskTime_passed_on_it(@PathVariable int taskId, @RequestParam LocalTime timePassedOnIt) {
        taskService.PatchTaskTime_passed_on_it(taskId, timePassedOnIt);
    }

    @PatchMapping("tasks/totalTime/{taskId}")
    public void PatchTaskTotal_time(@PathVariable int taskId, @RequestParam LocalTime totalTime) {
        taskService.patchTaskTotal_time(taskId, totalTime);
    }
}
