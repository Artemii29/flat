package com.example.demo.service;

import com.example.demo.entity.FlatAnnouncement;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AnnouncementRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public FlatAnnouncement findAnnouncementById(Long id) {
        return announcementRepository.findById(id).orElseThrow();
    }

    public List<FlatAnnouncement> getAnnouncementAll() {
        return announcementRepository.findAll();
    }

    public void deleteAnnouncement(Long id){
        announcementRepository.deleteById(id);
    }
    public FlatAnnouncement updateAnnouncement(FlatAnnouncement flatAnnouncement){
        // TODO: add some business logic here
        return announcementRepository.save(flatAnnouncement);
    }
}
