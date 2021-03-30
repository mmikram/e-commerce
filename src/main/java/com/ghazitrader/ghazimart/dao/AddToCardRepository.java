package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.AddToCard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AddToCardRepository extends CrudRepository<AddToCard,Integer> {
     List<AddToCard> findByMobileNo(final String mobileNo);
     void deleteByMobileNo(final String mobileNo);

    @Query(value = "SELECT count(*) FROM add_to_card tp WHERE tp.mobile_no =?1", nativeQuery = true)
    int totalCart(final String mobileNo);


   
}
