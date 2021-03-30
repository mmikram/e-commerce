package com.ghazitrader.ghazimart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class TempOrder {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column
    private String custName;
    @Column
    private String custMobile;
    @Column(length = 500)
    private String fullAddress;
    @Column
    private String totalPrice;
    @Column
    private int status;
    @Column
    private String orederDate;
    @Column
    private String deliveryDate;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    public List<OrderProduct> orderProducts= new ArrayList<>();

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrederDate() {
        return orederDate;
    }

    public void setOrederDate(String orederDate) {
        this.orederDate = orederDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

}
