package com.example.creature_site.services;

import java.util.Optional;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.creature_site.Repositories.TaskRepository;
import com.example.creature_site.model.Domain;
import com.example.creature_site.model.Task;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task getTaskById(int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElse(null);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTaskByStatus(boolean taskDone) {
        return taskRepository.findByTaskDone(taskDone);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTaskByProject_domain(Domain projectDomain) {
        return taskRepository.findByProjectDomain(projectDomain);
    }

    public void deleteById(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public void patchTaskTaskDone(int taskId) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found with taskId: " + taskId));   
        task.setTaskDone(!task.getTaskDone());
        // task.setTaskDone_date(current date);
        taskRepository.save(task);
    }

    public void PatchTaskTime_passed_on_it(int taskId, LocalTime timePassedOnIt) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found with taskId: " + taskId));
        task.setTimePassedOnIt(task.getTimePassedOnIt()
                                            .plusHours(timePassedOnIt.getHour())
                                            .plusMinutes(timePassedOnIt.getMinute())
                                            .plusSeconds(timePassedOnIt.getSecond())
        );
        taskRepository.save(task);
    }

    public void patchTaskTotal_time(int taskId, LocalTime totalTime) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found with taskId: " + taskId));
        task.setTotalTime(totalTime);        
        taskRepository.save(task);
    }
}
