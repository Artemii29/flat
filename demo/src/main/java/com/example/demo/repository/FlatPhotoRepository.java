package com.example.demo.repository;

import com.example.demo.entity.FlatPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatPhotoRepository extends JpaRepository<FlatPhoto, Long> {
}
