package com.example.demo.repository;
import com.example.demo.entity.FlatAnnouncement;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<FlatAnnouncement, Long> {
    FlatAnnouncement findFlatAnnouncementById(Long id);
    @NonNull
    List<FlatAnnouncement> findAll();
    FlatAnnouncement createFlatAnnouncement(FlatAnnouncement flatAnnouncement);
    FlatAnnouncement deleteFlatAnnouncementById(Long id);
    FlatAnnouncement updateById(Long id);
}