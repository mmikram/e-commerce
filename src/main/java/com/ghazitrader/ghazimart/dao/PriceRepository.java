package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.PriceDetails;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PriceRepository extends PagingAndSortingRepository<PriceDetails,Integer> {
    
}
