package com.example.demo.repository;

import com.example.demo.entity.FlatAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<FlatAnnouncement, Long> {

}