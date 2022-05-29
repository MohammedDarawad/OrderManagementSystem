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

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllProducts() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/{id}}")
    public ResponseEntity<CustomerDTO> getProductById(@PathVariable(name = "id") int productId) {
        return ResponseEntity.ok(customerService.getCustomerById(productId));
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDTO> createProduct(@Valid @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.addCustomer(customerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") int customerId) {
        customerService.removeCustomer(customerId);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
