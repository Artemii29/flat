package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "FlatStyle")
public class FlatStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "style")
    private String style;

    // getters and setters
}
