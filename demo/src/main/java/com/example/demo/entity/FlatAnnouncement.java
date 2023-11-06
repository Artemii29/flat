package com.example.demo.entity;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlatStyle> flatStyle;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlatPhoto> flatPhoto;

    // getters and setters
}