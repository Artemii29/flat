package com.example.demo.controllers;

import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.FlatAnnouncement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    private AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public List<FlatAnnouncement> getAllAnnouncements() {
        return announcementService.getAnnouncementAll();
    }

}
