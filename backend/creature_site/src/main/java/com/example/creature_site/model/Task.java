package com.example.creature_site.model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private boolean taskDone;
    private String name;
    private LocalTime timePassedOnIt;
    private LocalTime totalTime;
    private Date creationDate;
    private Date doneDate;

    @ManyToOne
    @JoinColumn(name = "domainId")
    private Domain projectDomain;

    @ManyToMany
    @JoinTable(name = "session_task_mapping",
        joinColumns = @JoinColumn(name = "taskId"),
        inverseJoinColumns = @JoinColumn(name = "sessionId")
    )
    private List<Horodateur_session> sessions = new ArrayList<>();

    public boolean getTaskDone() {
        return this.taskDone;
    }
}
