package com.webservices.oms.ordermanagementsystem.repository;

import com.webservices.oms.ordermanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
