package com.ghazitrader.ghazimart.model;

import java.util.List;

public class HomeScreen {
    private List<ProductCategory> categories;
    private List<SubCategory> slidingItems;
    private List<HomeDisplayItem> homeDisplayItem;

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    public List<SubCategory> getSlidingItems() {
        return slidingItems;
    }

    public void setSlidingItems(List<SubCategory> slidingItems) {
        this.slidingItems = slidingItems;
    }

    public List<HomeDisplayItem> getHomeDisplayItem() {
        return homeDisplayItem;
    }

    public void setHomeDisplayItem(List<HomeDisplayItem> homeDisplayItem) {
        this.homeDisplayItem = homeDisplayItem;
    }

    
    
}
