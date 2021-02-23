package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int productValueId;
    @Column
    private long price;
    @Column
    private long offerPrice;
    @Column
    private long saveMoney;
    @Column
    private String unitType;
    @Column
    private String weight;
    @Column
    private int quanties;
    @Column
    private String quality;
    @Column
    private int productId;
    @Column
    private long txt;
    @Column
    private long totalBeforTax;
    @Column
    private int deliveryWithin;

    public int getProductValueId() {
        return productValueId;
    }

    public void setProductValueId(int productValueId) {
        this.productValueId = productValueId;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getQuanties() {
        return quanties;
    }

    public void setQuanties(int quanties) {
        this.quanties = quanties;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(long offerPrice) {
        this.offerPrice = offerPrice;
    }

    public long getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(long saveMoney) {
        this.saveMoney = saveMoney;
    }

    public long getTxt() {
        return txt;
    }

    public void setTxt(long txt) {
        this.txt = txt;
    }

    public long getTotalBeforTax() {
        return totalBeforTax;
    }

    public void setTotalBeforTax(long totalBeforTax) {
        this.totalBeforTax = totalBeforTax;
    }

    public int getDeliveryWithin() {
        return deliveryWithin;
    }

    public void setDeliveryWithin(int deliveryWithin) {
        this.deliveryWithin = deliveryWithin;
    }

}
