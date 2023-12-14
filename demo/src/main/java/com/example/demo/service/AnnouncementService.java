package com.example.demo.service;

import com.example.demo.entity.FlatAnnouncement;
import com.example.demo.entity.FlatPhoto;
import com.example.demo.entity.User;
import com.example.demo.repository.FlatPhotoRepository;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AnnouncementRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;
    private FlatPhotoRepository flatPhotoRepository;
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository, UserRepository userRepository,FlatPhotoRepository flatPhotoRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
        this.flatPhotoRepository = flatPhotoRepository;
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
    public FlatAnnouncement createAnnouncement(FlatAnnouncement flatAnnouncement,@AuthenticationPrincipal UserDetails principal,MultipartFile[] files){
        String username = principal.getUsername();
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        flatAnnouncement.setUser(user);
        //установить ссылку на пользователя из бд
        //пользоваетлю в список добавляем новое объявление добавить проверки
// Сохранить объявление
        FlatAnnouncement savedAnnouncement = announcementRepository.save(flatAnnouncement);

        // Сохранить фото для объявления
        for (MultipartFile file : files) {
            saveFlatPhoto(file, savedAnnouncement);
        }

        return savedAnnouncement;
    }
    public void saveFlatPhoto(MultipartFile file,FlatAnnouncement announcement)  {
        // Создать экземпляр FlatPhoto на основе MultipartFile
        FlatPhoto flatPhoto = new FlatPhoto();
        flatPhoto.setFileName(file.getOriginalFilename());
        flatPhoto.setFlatAnnouncement(announcement);

        // Сохранить FlatPhoto в репозитории
        flatPhotoRepository.save(flatPhoto);
    }

}