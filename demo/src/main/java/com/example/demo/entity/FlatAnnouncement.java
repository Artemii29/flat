package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "FlatAnnouncement")
public class FlatAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer price;
    private Float area;
    private Integer rooms;
    private Enum type;

    @ManyToOne
    @JoinColumn(name = "FlatStyle")
    private FlatStyle flatStyle;

    @ManyToOne
    @JoinColumn(name = "tb_users")
    private User user;

    // getters and setters
}