package com.ghazitrader.ghazimart.service;

import com.ghazitrader.ghazimart.dao.CustomerRepository;
import com.ghazitrader.ghazimart.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public Customer registerCustomer(final Customer customer) {
       return customerRepository.save(customer);
    }

    public String getVerifyOTP(final String mobileNo){
        return customerRepository.getOTPByMobileNo(mobileNo);
    }

    public Customer getAlreadyRegisterMobileNo(final String mobileNo){
        return customerRepository.findByMobileNo(mobileNo);
    }
}
