package com.example.creature_site.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clientId;

    private String clientName;
    private String location;
    private Date clientCreationDate;
    private Date clientLastOrderDate;
    private String email;
    private boolean newEmail; //Pour savoir si le client a envoyé un nouvel email ou non
    private int clientPhone;
    
    @OneToMany(mappedBy = "orderClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> listDesOrders = new ArrayList<>();
}
