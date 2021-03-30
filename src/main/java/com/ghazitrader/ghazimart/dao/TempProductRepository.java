package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempProduct;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempProductRepository extends PagingAndSortingRepository<TempProduct,Integer>,ProductRepositoryCustom{
    @Query(value = "SELECT * FROM temp_product tp WHERE tp.cat_id =?1 ORDER BY RAND() LIMIT 4", nativeQuery = true)
    public List<TempProduct> getByCatId(final int catId);

}
