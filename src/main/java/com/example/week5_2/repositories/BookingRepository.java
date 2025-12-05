package com.example.week5_2.repositories;

import com.example.week5_2.entities.Booking;
import com.example.week5_2.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    /**
     * Tìm tất cả booking theo tour ID
     * 
     * @param tourId ID của tour
     * @return Danh sách booking
     */
    List<Booking> findByTourId(Long tourId);
    
    /**
     * Tìm tất cả booking theo tour
     * 
     * @param tour Tour entity
     * @return Danh sách booking
     */
    List<Booking> findByTour(Tour tour);
}
