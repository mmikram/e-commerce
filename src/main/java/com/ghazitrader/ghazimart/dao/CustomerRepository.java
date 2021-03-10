package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query(value = "SELECT login_id FROM customer_detail WHERE mobile_no = ?1", nativeQuery = true)
    public String getOTPByMobileNo(final String mobile);
    public Customer findByMobileNo(final String mobileNo);

}
