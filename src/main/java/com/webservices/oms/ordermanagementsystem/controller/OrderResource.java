package com.webservices.oms.ordermanagementsystem.controller;

import com.webservices.oms.ordermanagementsystem.dto.OrderDTO;
import com.webservices.oms.ordermanagementsystem.dto.ProductDTO;
import com.webservices.oms.ordermanagementsystem.dto.ProductOrderDTO;
import com.webservices.oms.ordermanagementsystem.service.OrderService;
import com.webservices.oms.ordermanagementsystem.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/productOrder")
    public ResponseEntity<List<ProductOrderDTO>> getAllProductOrders() {
        return ResponseEntity.ok().body(productOrderService.getAllProductOrders());
    }

    @GetMapping("/productOrder/{orderId}")
    public ResponseEntity<List<ProductOrderDTO>> getProductOrderByOrderId(@PathVariable(name = "orderId") int orderId) {
        return ResponseEntity.ok().body(productOrderService.getProductOrdersByOrderId(orderId));
    }

    @DeleteMapping("/productOrder/{orderId}/{productId}")
    public ResponseEntity<String> deleteProductOrder(@Valid @PathVariable(name = "orderId") int orderId, @Valid @PathVariable(name = "productId") int productId) {
        productOrderService.removeProductOrder(orderId, productId);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

    @PostMapping("/productOrder/{customerId}")
    public ResponseEntity<ProductOrderDTO> createProductOrder(@Valid @RequestBody ProductOrderDTO productOrderDTO, @Valid @PathVariable(name = "customerId") int customerId) {
        return new ResponseEntity<>(productOrderService.addProductOrder(productOrderDTO, customerId), HttpStatus.CREATED);
    }

    @PutMapping("/productOrder")
    public ResponseEntity<ProductOrderDTO> updateProductOrder(@Valid @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.updateProductOrder(productOrderDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable(name = "id") int customerId) {
        return ResponseEntity.ok(orderService.getOrderById(customerId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") int orderId) {
        orderService.removeOrder(orderId);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
