package com.example.creature_site.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creature_site.model.Domain;
import com.example.creature_site.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTaskDone(boolean taskDone);
    List<Task> findByProjectDomain(Domain projectDomain);
}
