package com.webservices.oms.ordermanagementsystem.service.impl;

import com.webservices.oms.ordermanagementsystem.dto.OrderDTO;
import com.webservices.oms.ordermanagementsystem.entity.Customer;
import com.webservices.oms.ordermanagementsystem.entity.Order;
import com.webservices.oms.ordermanagementsystem.exception.ResourceNotFoundException;
import com.webservices.oms.ordermanagementsystem.repository.CustomerRepository;
import com.webservices.oms.ordermanagementsystem.repository.OrderRepository;
import com.webservices.oms.ordermanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        return mapToDTO(order);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO, int customerId) {
        Order order = mapToEntity(orderDTO);

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", customerId));
        order.setCustomer(customer);

        Order newOrder = orderRepository.save(order);

        OrderDTO orderResponse = mapToDTO(newOrder);
        return orderResponse;
    }

    @Override
    public void removeOrder(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        orderRepository.delete(order);
    }

    private OrderDTO mapToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderedAt(order.getOrderedAt());
        return orderDTO;
    }

    private Order mapToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setOrderedAt(orderDTO.getOrderedAt());
        return order;
    }
}
