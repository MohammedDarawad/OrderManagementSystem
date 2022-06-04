package com.webservices.oms.ordermanagementsystem.service;

import com.webservices.oms.ordermanagementsystem.dto.ProductOrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductOrderService {
    List<ProductOrderDTO> getAllProductOrders();

    List<ProductOrderDTO> getProductOrdersByOrderId(int orderId);

    ProductOrderDTO addProductOrder(ProductOrderDTO productOrder, int customerId);

    void removeProductOrder(int orderId, int customerId);

    ProductOrderDTO updateProductOrder(ProductOrderDTO productOrderDTO);
}
