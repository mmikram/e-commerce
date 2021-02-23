package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.BannerModel;

import org.springframework.data.repository.CrudRepository;

public interface BannerRepository extends CrudRepository<BannerModel,Integer> {
    public List<BannerModel> findByProductId(final int productId);
    public BannerModel findByCatId(final int catId);
    public BannerModel findBySubCatId(final int subCatId);

    
}
