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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FlatAnnouncement getFlatAnnouncement() {
        return flatAnnouncement;
    }

    public void setFlatAnnouncement(FlatAnnouncement flatAnnouncement) {
        this.flatAnnouncement = flatAnnouncement;
    }
}