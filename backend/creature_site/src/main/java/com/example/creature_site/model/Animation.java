package com.example.creature_site.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Animation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int animationId;

    private String animationName;

    @ManyToMany(mappedBy = "listAnimations")
    private Set<Creature> creaturesUtilisantLAnimation;
}
