package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OfferProduct {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OfferProductId;
    @Column
    private int productId;
    @Column
    private int subCatId;

    public int getOfferProductId() {
        return OfferProductId;
    }

    public void setOfferProductId(int offerProductId) {
        OfferProductId = offerProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }
    
}
