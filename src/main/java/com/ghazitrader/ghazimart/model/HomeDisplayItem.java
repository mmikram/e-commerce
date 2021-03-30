package com.ghazitrader.ghazimart.model;

import java.util.List;

public class HomeDisplayItem {
    private int catId;
    private String catName;
    private List<TempProduct> products;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<TempProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TempProduct> products) {
        this.products = products;
    }
   }
