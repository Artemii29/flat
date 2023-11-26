package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "tb_photo")
public class FlatPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fileName;
    @ManyToOne
    private FlatAnnouncement flatAnnouncement;
}