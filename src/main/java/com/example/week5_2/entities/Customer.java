package com.example.week5_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    @OneToMany (mappedBy = "customer",
            cascade = CascadeType. ALL,
            fetch = FetchType. LAZY)
    private ArrayList<Booking> sinhVien = new ArrayList<>();

}
