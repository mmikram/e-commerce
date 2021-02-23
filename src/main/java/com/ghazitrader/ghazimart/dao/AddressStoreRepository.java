package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.AddressStore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStoreRepository extends CrudRepository<AddressStore, Integer> {
    public AddressStore findByMobileNo(final String mobileNo);

    public AddressStore findByCustName(final String custName);
}
