package com.example.week5_2.repositories;

import com.example.week5_2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Tìm customer theo email
     * 
     * @param email Email của customer
     * @return Customer nếu tồn tại
     */
    Optional<Customer> findByEmail(String email);
}
