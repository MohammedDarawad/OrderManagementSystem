package com.webservices.oms.ordermanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderId implements Serializable {
    private Product product;
    private Order order;
}
