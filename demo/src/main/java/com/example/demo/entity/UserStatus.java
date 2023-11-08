package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_status")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     enum Status{
        SELL,BUY
    };

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}