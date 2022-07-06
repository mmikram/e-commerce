package com.ghazitrader.ghazimart.model;

import java.util.List;

public class AddToCartResponse {
    List<OrderProduct> cartItems;
    AddressDetails addressDetail;
    public List<OrderProduct> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<OrderProduct> cartItems) {
        this.cartItems = cartItems;
    }
    public AddressDetails getAddressDetail() {
        return addressDetail;
    }
    public void setAddressDetail(AddressDetails addressDetail) {
        this.addressDetail = addressDetail;
    }

    

}
