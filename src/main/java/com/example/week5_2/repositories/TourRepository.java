package com.example.week5_2.repositories;

import com.example.week5_2.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
