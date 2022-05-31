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

    @GetMapping("/{id}}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") int customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.addCustomer(customerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") int customerId) {
        customerService.removeCustomer(customerId);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
