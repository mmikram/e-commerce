package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.TempProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempProductRepository extends CrudRepository<TempProduct,Integer>{
    
}
