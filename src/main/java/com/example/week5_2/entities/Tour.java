package com.example.week5_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Double price;
    private String location;
    private Integer durationDays;
    private LocalDate departureDate;
    private Integer maxCapacity; // Giới hạn số người (max khách)
    private String description;
    private Boolean isAvailable; // Trang thái (còn/hết tour)
    @OneToMany (mappedBy = "tour",
            cascade = CascadeType. ALL,
            fetch = FetchType. LAZY)
    private ArrayList<Booking> sinhVien = new ArrayList<>();

}
