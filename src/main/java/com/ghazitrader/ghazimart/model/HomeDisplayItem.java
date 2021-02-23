package com.ghazitrader.ghazimart.model;

import java.util.List;

public class HomeDisplayItem {
    private int catId;
    private String catName;
    private List<SubCategory> categories;

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

    public List<SubCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<SubCategory> categories) {
        this.categories = categories;
    }
   }
