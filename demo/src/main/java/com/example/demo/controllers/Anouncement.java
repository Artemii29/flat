package com.example.demo.controllers;
import com.example.demo.entity.FlatAnnouncement;
import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/anouncement")
public class Anouncement {
    private AnnouncementService announcementService;
    @Autowired
    public Anouncement(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public List<Anouncement> getAllAnnouncement(){
       return FlatAnnouncement.getAllAnnouncement();
   }
   @PostMapping
    public FlatAnnouncement createAnnouncement(FlatAnnouncement flatAnnouncement){

   }

}
//создать репозиторий который будет общаться с бд
// на каждый entity отдельный репозиторий
// репозиторий jpa
// авторизацию через форму или jvt spring security
// контроллер сервис репозиторий по объявлениям