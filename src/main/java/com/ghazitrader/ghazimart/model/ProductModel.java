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


@Entity
@Table(name = "ProductDetails")
public class ProductModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column
    private String productName;
    @Column
    private int status;
    @Column
    private int userId;
    @Column
    private int subCatId;
    @Column
    private String Description;
    @Column
    private String startTIme;

    @Column(columnDefinition = "integer default 0")
    private int isVerified;

    @Column(nullable = true)
    private String statusMessage;

    @OneToMany(targetEntity = BannerModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",referencedColumnName = "productId")
    public List<BannerModel> bannerList;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStartTIme() {
        return startTIme;
    }

    public void setStartTIme(String startTIme) {
        this.startTIme = startTIme;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public List<BannerModel> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerModel> bannerList) {
        this.bannerList = bannerList;
    }

    public int getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(int isVerified) {
        this.isVerified = isVerified;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
