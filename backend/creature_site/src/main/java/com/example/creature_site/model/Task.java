package com.example.creature_site.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private boolean status;
    private String title;

}
