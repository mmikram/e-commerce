package com.ghazitrader.ghazimart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int catId;
    @Column
    private String name;
    @Column
    private String banner;
    @Column(columnDefinition = "integer default 1")
    private int status;
    @Column
    private int userId;
    @Column(nullable = true)
    private String startTIme;

    // @OneToMany(targetEntity = SubCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinColumn(name = "catId",referencedColumnName = "catId")
    // public List<SubCategory> subCategories;

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
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

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }


}
