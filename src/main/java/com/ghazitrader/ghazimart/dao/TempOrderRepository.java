package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempOrder;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempOrderRepository extends PagingAndSortingRepository<TempOrder, Integer>{

    public List<TempOrder> findByStatus(final int status,final Pageable pageable);

    public List<TempOrder> findByCustMobile(final String custMobile,final Pageable pageable);

}
