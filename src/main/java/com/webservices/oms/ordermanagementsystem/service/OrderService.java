package com.webservices.oms.ordermanagementsystem.service;

import com.webservices.oms.ordermanagementsystem.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(int orderId);

    OrderDTO addOrder(OrderDTO orderDTO, int customerId);

    void removeOrder(int orderId);
}
