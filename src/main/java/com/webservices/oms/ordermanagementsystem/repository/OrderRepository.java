package com.webservices.oms.ordermanagementsystem.repository;

import com.webservices.oms.ordermanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
