package com.webservices.oms.ordermanagementsystem.repository;

import com.webservices.oms.ordermanagementsystem.entity.ProductOrder;
import com.webservices.oms.ordermanagementsystem.entity.ProductOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId> {
    List<ProductOrder> findAllByOrderId(int orderId);
    ProductOrder findByOrderIdAndProductId(int orderId,int productId);
}
