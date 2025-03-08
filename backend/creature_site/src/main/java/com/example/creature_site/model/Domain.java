package com.example.creature_site.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Domain {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int domainId;

    private String name;
    private boolean domainDone;
    private Date creationDate;
    private Date doneDate;
    private String color;
    
    @OneToMany(mappedBy = "projectDomain")
    private List<Task> listTasks = new ArrayList<>();

}
