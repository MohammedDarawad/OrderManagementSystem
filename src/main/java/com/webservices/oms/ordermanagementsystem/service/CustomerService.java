package com.webservices.oms.ordermanagementsystem.service;

import com.webservices.oms.ordermanagementsystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(int customerId);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    void removeCustomer(int customerId);
}
