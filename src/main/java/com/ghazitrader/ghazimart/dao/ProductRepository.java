package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.ProductModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {
    public List<ProductModel> findByUserId(final int userId);

    public List<ProductModel> findBySubCatId(final int subCatId);

    public List<ProductModel> findByIsVerified(final boolean isVerified);

    @Query(value = "SELECT * FROM product_details p WHERE p.is_verified = 1 AND p.sub_cat_id IN :ids", nativeQuery = true)
    public List<ProductModel> findOfferProduct(@Param("ids") List<Integer> ids);

    @Query(value = "SELECT * FROM product_details p WHERE p.is_verified = 0", nativeQuery = true)
    public List<ProductModel> findUnVerifiedProduct();

    @Modifying(flushAutomatically  = true, clearAutomatically = true)
    @Query(value = "UPDATE product_details p SET p.is_verified = 1 WHERE p.product_id = :id", nativeQuery = true)
    public void verifyProduct(@Param("id") int productId);

}
