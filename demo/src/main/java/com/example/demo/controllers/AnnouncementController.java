package com.example.demo.controllers;

import com.example.demo.entity.Favorites;
import com.example.demo.repository.FavoritesRepository;
import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.FlatAnnouncement;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/announcements")
//@CrossOrigin(origins = "http://localhost:5173")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final FavoritesRepository favoritesRepository;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, FavoritesRepository favoritesRepository) {
        this.announcementService = announcementService;
        this.favoritesRepository = favoritesRepository;
    }

    @GetMapping
    public List<FlatAnnouncement> getAllAnnouncements() {
        return announcementService.getAnnouncementAll();
    }

    // TODO: move to appropriate controller
    // /users/{userId}/favorites - GET, POST, etc
    @PostMapping("/createAnnouncement")
    public FlatAnnouncement createAnnouncement(FlatAnnouncement flatAnnouncement,@AuthenticationPrincipal Principal principal){
        return announcementService.createAnnouncement(flatAnnouncement,principal);
}
    @GetMapping("/favorites/{userId}")
    public List<Favorites> getUserFavorites(@PathVariable Long userId) {
        return favoritesRepository.findAllByUserId(userId);
        //
    }
}
