package com.example.demo.repository;

import com.example.demo.entity.FlatAnnouncement;
import com.example.demo.entity.FlatStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<FlatAnnouncement, Long> {
    List<FlatAnnouncement> findByflatStyleAndRooms(FlatStyle flatStyle, int rooms);

}