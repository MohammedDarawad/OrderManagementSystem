package com.webservices.oms.ordermanagementsystem.repository;

import com.webservices.oms.ordermanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);
}
