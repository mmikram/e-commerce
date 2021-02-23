package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.ProductValue;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductValueRepository extends CrudRepository<ProductValue,Integer> {

    public List<ProductValue> findByProductId(final int productId);
    
}
