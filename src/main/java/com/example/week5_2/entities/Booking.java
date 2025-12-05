package com.example.week5_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfPeople;
    private Double totalPrice;
    private LocalDate bookingDate;
    private String Status;
    @ManyToOne(fetch = FetchType. LAZY)
    @JoinColumn (name = "customer_id",
            foreignKey = @ForeignKey (name = "FK_Customer_Booking"))
    private Customer customer;

    @ManyToOne(fetch = FetchType. LAZY)
    @JoinColumn (name = "tour_id",
            foreignKey = @ForeignKey (name = "FK_Tour_Booking"))
    private Tour tour;


}
