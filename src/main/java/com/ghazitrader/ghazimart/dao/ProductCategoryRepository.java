package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.ProductCategory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer>{

    @Query(value = "SELECT * FROM product_category ORDER BY RAND() LIMIT 4", nativeQuery = true)
    public List<ProductCategory> findRandonCategory();
    
}
