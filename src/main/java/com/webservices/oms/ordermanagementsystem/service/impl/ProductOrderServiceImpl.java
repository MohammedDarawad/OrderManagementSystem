package com.webservices.oms.ordermanagementsystem.service.impl;

import com.webservices.oms.ordermanagementsystem.dto.OrderDTO;
import com.webservices.oms.ordermanagementsystem.dto.ProductOrderDTO;
import com.webservices.oms.ordermanagementsystem.entity.*;
import com.webservices.oms.ordermanagementsystem.exception.ResourceNotFoundException;
import com.webservices.oms.ordermanagementsystem.repository.CustomerRepository;
import com.webservices.oms.ordermanagementsystem.repository.OrderRepository;
import com.webservices.oms.ordermanagementsystem.repository.ProductOrderRepository;
import com.webservices.oms.ordermanagementsystem.repository.ProductRepository;
import com.webservices.oms.ordermanagementsystem.service.OrderService;
import com.webservices.oms.ordermanagementsystem.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    @Override
    public List<ProductOrderDTO> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        return productOrders.stream().map(productOrder -> mapToDTO(productOrder)).collect(Collectors.toList());
    }

    @Override
    public List<ProductOrderDTO> getProductOrdersByOrderId(int orderId) {
        List<ProductOrder> productOrders = productOrderRepository.findAllByOrderId(orderId);
        return productOrders.stream().map(productOrder -> mapToDTO(productOrder)).collect(Collectors.toList());
    }

    @Override
    public ProductOrderDTO addProductOrder(ProductOrderDTO productOrderDTO, int customerId) {
        ProductOrder productOrder = mapToEntity(productOrderDTO);

        int orderId = productOrderDTO.getOrderId();
        Order order = new Order();
        try {
            order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        } catch (ResourceNotFoundException ex) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderedAt(LocalDateTime.now());
            order = orderRepository.save(orderService.mapToEntity(orderDTO));
            order.setCustomer(customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId)));
        }
        productOrder.setOrder(order);

        int productId = productOrderDTO.getProductId();
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productOrder.setProduct(product);
        ProductOrderId pk = new ProductOrderId();
        pk.setOrderId(productOrderDTO.getOrderId());
        pk.setProductId(productOrderDTO.getProductId());
        productOrder.setPk(pk);

        ProductOrder newProductOrder = productOrderRepository.save(productOrder);

        return mapToDTO(newProductOrder);
    }

    @Override
    public void removeProductOrder(int orderId, int productId) {
        ProductOrder productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId);
        productOrderRepository.delete(productOrder);
    }

    private ProductOrderDTO mapToDTO(ProductOrder productOrder) {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setOrderId(productOrder.getOrder().getId());
        productOrderDTO.setProductId(productOrder.getProduct().getId());
        productOrderDTO.setPrice(productOrder.getPrice());
        productOrderDTO.setQuantity(productOrder.getQuantity());
        productOrderDTO.setVat(productOrder.getVat());
        return productOrderDTO;
    }

    private ProductOrder mapToEntity(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        return productOrder;
    }
}
