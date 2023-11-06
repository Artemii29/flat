package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") //название таблицы в БД

    private String name;
    @Column(name = "email") //название таблицы в БД

    private String email;
    @Column(name = "password") //название таблицы в БД

    private String password;
    @Column(name = "phone") //название таблицы в БД
    private String phone_number;
    @ManyToOne
    @JoinColumn(name = "tb_status")
    private UserStatus userStatus;

}