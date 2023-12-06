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
    private int price;
    private Float area;
    private int rooms;

    enum type{
        active,archive,sell,buy
    };

    @ManyToOne
    private FlatStyle flatStyle;

    @OneToMany(mappedBy = "flatAnnouncement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlatPhoto> flatPhoto;

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // getters and setters
    //
}