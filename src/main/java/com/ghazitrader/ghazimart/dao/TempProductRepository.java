package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempProduct;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TempProductRepository extends PagingAndSortingRepository<TempProduct,Integer>,ProductRepositoryCustom{
    @Query(value = "SELECT * FROM temp_product tp WHERE tp.cat_id =?1 AND tp.status=1 ORDER BY RAND() LIMIT 4", nativeQuery = true)
    public List<TempProduct> getByCatId(final int catId);

    @Query(value = "SELECT * FROM temp_product p WHERE p.status=1 AND p.cat_id IN :catId", nativeQuery = true)
    public List<TempProduct> getProductByCatIds(@Param("catId") List<Integer> catId);

    @Query(value = "SELECT * FROM temp_product p WHERE p.status=0 AND p.cat_id IN :catId", nativeQuery = true)
    public List<TempProduct> getActiviProductByCatIds(@Param("catId") List<Integer> catId);

    @Modifying(flushAutomatically  = true, clearAutomatically = true)
    @Query(value = "UPDATE temp_product p SET p.status = :status WHERE p.product_id = :product_id", nativeQuery = true)
    public void verifyProduct(@Param("product_id") int productId,@Param("status") int status);


   

   

}
