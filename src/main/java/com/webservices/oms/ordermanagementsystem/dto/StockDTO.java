package com.webservices.oms.ordermanagementsystem.dto;

import com.webservices.oms.ordermanagementsystem.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private int id;
    private int quantity;
    private LocalDateTime updatedAt;
}
