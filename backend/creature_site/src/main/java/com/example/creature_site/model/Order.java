package com.example.creature_site.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client orderClient;
    
    private int price;
    private String content;
    private boolean payed;
    private Date orderCreationDate;
    private Date orderPayementDate;
}
