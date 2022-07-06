package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.AddressDetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends CrudRepository<AddressDetails, Integer>{
    public List<AddressDetails> findByMobile(final String mobile);


    @Query(value = "SELECT *  FROM address_details ad WHERE ad.delivery_mobile =?1 AND ad.is_default=1", nativeQuery = true)
   public AddressDetails defaultAddress(final String mobileNo);

    
}
