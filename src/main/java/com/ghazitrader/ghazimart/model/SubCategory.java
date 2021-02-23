package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int subCatId;
    @Column(length = 100)
    private String name;
    @Column
    private int catId;
    @Column
    private int status;
    @Column(columnDefinition = "boolean default false")
    private Boolean isForSlid;
    @Column
    private String banner;

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getIsForSlid() {
        return isForSlid;
    }

    public void setIsForSlid(Boolean isForSlid) {
        this.isForSlid = isForSlid;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
        
}
