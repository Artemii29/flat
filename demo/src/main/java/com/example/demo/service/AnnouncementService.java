package com.example.demo.service;

import com.example.demo.entity.FlatAnnouncement;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AnnouncementRepository;
import java.util.List;
@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public FlatAnnouncement getAnnouncementById(Long id) {
        return announcementRepository.findFlatAnnouncementById(id);
    }

    public List<FlatAnnouncement> getAnnouncementAll() {
        return announcementRepository.findAll();
    }
   
    public FlatAnnouncement deleteAnnouncement(Long id){
        return announcementRepository.deleteFlatAnnouncementById(id);
    }
    public FlatAnnouncement updateAnnouncement(Long id){
        return announcementRepository.updateById(id);
    }
}
