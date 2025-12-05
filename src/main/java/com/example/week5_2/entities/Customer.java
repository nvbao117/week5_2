package com.example.week5_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data // <-- thêm annotation này
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();  // đổi tên cho đúng ý nghĩa
}
