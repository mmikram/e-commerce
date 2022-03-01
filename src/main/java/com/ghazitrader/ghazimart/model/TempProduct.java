package com.ghazitrader.ghazimart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class TempProduct {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column
    private String productName;
    @Column
    private String banner;

    @Column
    private String returnIn;
    
    public String getReturnIn() {
        return returnIn;
    }

    public void setReturnIn(String returnIn) {
        this.returnIn = returnIn;
    }

    @Column
    private String description;
    @Column
    private int status;

    @Column
    private int catId;
    @Column(length = 400)
    private String productSearch;


    @OneToMany(targetEntity = PriceDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",referencedColumnName = "productId")
    public List<PriceDetails> priceList;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductSearch() {
        return productSearch;
    }

    public void setProductSearch(String productSearch) {
        this.productSearch = productSearch;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

      
}
