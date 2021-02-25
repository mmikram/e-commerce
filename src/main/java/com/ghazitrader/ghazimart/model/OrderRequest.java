package com.ghazitrader.ghazimart.model;

import java.util.List;

public class OrderRequest {

    private List<TempOrder> orders;

    public List<TempOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<TempOrder> orders) {
        this.orders = orders;
    }
    
}
