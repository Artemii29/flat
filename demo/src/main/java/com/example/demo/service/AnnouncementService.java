package com.example.demo.service;

import com.example.demo.entity.FlatAnnouncement;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AnnouncementRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository, UserRepository userRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
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
    public FlatAnnouncement createAnnouncement(FlatAnnouncement flatAnnouncement,@AuthenticationPrincipal Principal principal){
        String username = principal.getName();
        User user = userRepository.findByName(username)
                 .orElseThrow(() -> new EntityNotFoundException("User not found"));
        flatAnnouncement.setUser(user);
                //установить ссылку на пользователя из бд
        //пользоваетлю в список добавляем новое объявление добавить проверки

        return announcementRepository.save(flatAnnouncement);
    }
}
