package com.ghazitrader.ghazimart.service;

import com.ghazitrader.ghazimart.dao.CustomerRepository;
import com.ghazitrader.ghazimart.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public void registerCustomer(final Customer customer) {
        customerRepository.save(customer);
    }
}
