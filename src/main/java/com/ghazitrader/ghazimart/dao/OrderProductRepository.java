package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.OrderProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer>{
    
}
