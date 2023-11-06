package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flat_announcement_id")
    private FlatAnnouncement flatAnnouncement;


    // getters and setters
}