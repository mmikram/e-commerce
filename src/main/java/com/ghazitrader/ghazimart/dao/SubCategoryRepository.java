package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.SubCategory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubCategoryRepository extends CrudRepository<SubCategory, Integer> {

    public List<SubCategory> findByIsForSlid(final boolean isForSlid);
    
    @Query(value = "SELECT * FROM sub_category sc WHERE sc.cat_id =?1 ORDER BY RAND() LIMIT 4", nativeQuery = true)
    public List<SubCategory> getByCatId(final int catId);

    @Query(value = "SELECT sub_cat_id FROM sub_category sc WHERE sc.cat_id =?1", nativeQuery = true)
    public List<Integer> findByCatIds(int catId);


    @Modifying
    @Query(value = "DELETE FROM sub_category sc WHERE sub_cat_id = ?1", nativeQuery = true)
    public Integer deleteOfferItem(final int subCatId);


}
