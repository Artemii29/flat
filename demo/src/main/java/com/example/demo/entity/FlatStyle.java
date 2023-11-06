package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "FlatStyle")
public class FlatStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String style;

    // getters and setters
}
