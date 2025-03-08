package com.example.creature_site.model;

import java.io.File;
import java.util.List;
import java.util.Set;

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
public class Creature {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int creatureId;

    private String creatureName;
    private String creatureType;
    private File glbFile;
    @ManyToMany
    @JoinTable(
        name = "creature_animation_mapping",
        joinColumns = @JoinColumn(name = "creatureId"),
        inverseJoinColumns = @JoinColumn(name = "animationId")
    )
    private Set<Animation> listAnimations;
}
