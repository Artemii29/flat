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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public FlatStyle getFlatStyle() {
        return flatStyle;
    }

    public void setFlatStyle(FlatStyle flatStyle) {
        this.flatStyle = flatStyle;
    }

    public List<FlatPhoto> getFlatPhoto() {
        return flatPhoto;
    }

    public void setFlatPhoto(List<FlatPhoto> flatPhoto) {
        this.flatPhoto = flatPhoto;
    }

    public User getUser() {
        return user;
    }

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