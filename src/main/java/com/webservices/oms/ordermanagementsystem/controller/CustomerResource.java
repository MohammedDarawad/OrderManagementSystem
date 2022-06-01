package com.webservices.oms.ordermanagementsystem.controller;

import com.webservices.oms.ordermanagementsystem.dto.CustomerDTO;
import com.webservices.oms.ordermanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "customerId") int customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
