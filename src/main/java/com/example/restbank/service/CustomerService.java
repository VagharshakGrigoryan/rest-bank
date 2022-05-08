package com.example.restbank.service;

import com.example.restbank.model.Customer;
import com.example.restbank.reapsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerInfo(int acctID) {
        return customerRepository.findById(acctID).orElse(null);
    }

    public void deleteCustomer(int acctID) {
        customerRepository.deleteById(acctID);
    }

}