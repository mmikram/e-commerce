package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.AddToCard;

import org.springframework.data.repository.CrudRepository;

public interface AddToCardRepository extends CrudRepository<AddToCard,Integer> {
    public List<AddToCard> findByMobileNo(final String mobileNo);
    public Long deleteByMobileNo(final String mobileNo);
   
}
