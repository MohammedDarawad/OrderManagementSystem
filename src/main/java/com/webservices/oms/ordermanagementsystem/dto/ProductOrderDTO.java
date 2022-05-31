package com.webservices.oms.ordermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDTO {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private double vat;
}
