package com.webservices.oms.ordermanagementsystem.repository;

import com.webservices.oms.ordermanagementsystem.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}
