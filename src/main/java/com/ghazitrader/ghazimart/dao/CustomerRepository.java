package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
    
}
