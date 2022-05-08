package com.example.restbank.controller;

import com.example.restbank.model.Customer;
import com.example.restbank.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final AccountController accountController;

    public CustomerController(CustomerService customerService, AccountController accountController) {
        this.customerService = customerService;
        this.accountController = accountController;
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        accountController.createAccount(customer.getAccountID(), 0, "Active");
    }

    @GetMapping("/customer/{accountID}")
    public Customer getCustomerInfo(@PathVariable int accountID) {
        return customerService.getCustomerInfo(accountID);
    }

    @DeleteMapping("/customer/{accountID}")
    public void deleteCustomer(@PathVariable int accountID) {
        customerService.deleteCustomer(accountID);
    }

}