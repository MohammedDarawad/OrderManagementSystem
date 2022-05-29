package com.webservices.oms.ordermanagementsystem.service.impl;

import com.webservices.oms.ordermanagementsystem.dto.CustomerDTO;
import com.webservices.oms.ordermanagementsystem.entity.Customer;
import com.webservices.oms.ordermanagementsystem.exception.ResourceNotFoundException;
import com.webservices.oms.ordermanagementsystem.repository.CustomerRepository;
import com.webservices.oms.ordermanagementsystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        return mapToDTO(customer);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = mapToEntity(customerDTO);

        Customer newCustomer = customerRepository.save(customer);

        CustomerDTO customerResponse = mapToDTO(newCustomer);
        return customerResponse;
    }

    @Override
    public void removeCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        customerRepository.delete(customer);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    private Customer mapToEntity(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }
}
