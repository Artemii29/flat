package com.example.demo.controllers;

import ch.qos.logback.core.model.Model;
import com.example.demo.entity.Favorites;
import com.example.demo.entity.FlatPhoto;
import com.example.demo.repository.FavoritesRepository;
import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.FlatAnnouncement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/announcements")
//@CrossOrigin(origins = "http://localhost:5173/createAnnouncement")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final FavoritesRepository favoritesRepository;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, FavoritesRepository favoritesRepository) {
        this.announcementService = announcementService;
        this.favoritesRepository = favoritesRepository;
    }

    @GetMapping("getAnnouncement")
    public List<FlatAnnouncement> getAllAnnouncements() {
        return announcementService.getAnnouncementAll();
    }


    // /users/{userId}/favorites

    @GetMapping("/favorites/{userId}")
    public List<Favorites> getUserFavorites(@PathVariable Long userId) {
        return favoritesRepository.findAllByUserId(userId);
        //
    }

    @PostMapping(path = "/createAnnouncement", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public FlatAnnouncement createAnnouncement(@RequestPart FlatAnnouncement flatAnnouncement
                                            //   @RequestPart MultipartFile[] files,
                                              /* @AuthenticationPrincipal UserDetails principal*/) {
        System.out.println(flatAnnouncement);
        return announcementService.createAnnouncement(flatAnnouncement, /*principal*/null,/*files*/ null);
    }

    @PostMapping("/addphoto")
    public void addPhoto(@RequestParam("file") MultipartFile file, FlatAnnouncement announcement) throws IOException {
        announcementService.saveFlatPhoto(file, announcement);

    }


}