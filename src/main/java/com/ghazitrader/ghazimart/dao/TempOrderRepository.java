package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempOrder;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TempOrderRepository extends PagingAndSortingRepository<TempOrder, Integer>{

    public List<TempOrder> findByStatus(final int status,final Pageable pageable);

    public List<TempOrder> findByCustMobile(final String custMobile,final Pageable pageable);

    @Modifying(flushAutomatically  = true, clearAutomatically = true)
    @Query(value = "UPDATE temp_order p SET p.status = :status WHERE p.order_id = :order_id", nativeQuery = true)
    public void orderStatus(@Param("order_id") int orderId,@Param("status") int status);



}
