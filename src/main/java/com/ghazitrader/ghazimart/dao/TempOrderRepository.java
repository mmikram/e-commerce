package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempOrder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempOrderRepository extends CrudRepository<TempOrder, Integer>{

    @Query(value = "SELECT * FROM temp_order WHERE status = 1", nativeQuery = true)
    public List<TempOrder> tempOrders();
}
