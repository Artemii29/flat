package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_status")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status") //название таблицы в БД

    private Enum status;


}