package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.OrderDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, Integer>{
    public List<OrderDetails> findByCustId(final int custId);
    
}
