package com.example.creature_site.model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Horodateur_session {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sessionId;

    private Date sessionDate;
    private LocalTime time;
    @ManyToMany
    @JoinTable(name = "session_task_mapping",
            joinColumns = @JoinColumn(name = "sessionId"),
            inverseJoinColumns = @JoinColumn(name = "taskId")
    )
    private List<Task> sessionTasks;
    
    private String note;
}
