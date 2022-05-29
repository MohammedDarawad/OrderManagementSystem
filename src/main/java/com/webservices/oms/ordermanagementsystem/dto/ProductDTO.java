package com.webservices.oms.ordermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stockable;
}