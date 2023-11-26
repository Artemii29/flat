package com.example.demo.entity;
import jakarta.persistence.*;


import java.util.List;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String location;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorites> favorites;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlatAnnouncement> flatAnnouncements;
    public enum UserStatus{
        SELL,BUY
    }
}