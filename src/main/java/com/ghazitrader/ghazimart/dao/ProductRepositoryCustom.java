package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.TempProduct;

public interface ProductRepositoryCustom {

    List<TempProduct> search(final String productName, final String description, final String productSearch);

}
