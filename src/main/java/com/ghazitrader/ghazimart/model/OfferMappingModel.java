package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer_mapping")
public class OfferMappingModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int slideOfferId;
    @Column
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlideOfferId() {
        return slideOfferId;
    }

    public void setSlideOfferId(int slideOfferId) {
        this.slideOfferId = slideOfferId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
}
