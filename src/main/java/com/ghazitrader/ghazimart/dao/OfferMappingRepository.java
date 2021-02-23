package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.OfferMappingModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OfferMappingRepository extends CrudRepository<OfferMappingModel, Integer> {

    @Query(value = "SELECT product_id FROM offer_mapping om WHERE om.slide_offer_id = ?1", nativeQuery = true)
    public List<Integer> findProductId(final int slideOfferId);

    @Modifying
    @Query(value = "DELETE FROM offer_mapping om WHERE om.slide_offer_id = ?1", nativeQuery = true)
    public Integer deleteOfferItemBySlideOfferId(final int slideOfferId);

}
