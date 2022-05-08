package com.example.restbank.reapsitory;

import com.example.restbank.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {}