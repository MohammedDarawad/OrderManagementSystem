package com.webservices.oms.ordermanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_order")
//@IdClass(ProductOrderId.class)
@Entity
public class ProductOrder {
    @EmbeddedId
    private ProductOrderId pk;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productid", nullable = false)
    @MapsId("productId")
    private Product product;


    @ManyToOne(optional = false)
    @JoinColumn(name = "orderid", nullable = false)
    @MapsId("orderId")
    private Order order;

    private int quantity;
    private double price;
    private double vat;


}
