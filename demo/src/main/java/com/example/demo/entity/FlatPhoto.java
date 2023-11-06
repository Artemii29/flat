package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_photo")
public class FlatPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_name")
    private String fileName;
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FlatAnnouncement_id")
    private FlatAnnouncement flatAnnouncement;
}