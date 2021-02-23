package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int ratId;
    @Column
    private int rating;
    @Column(nullable = true)
    private String comment;
    @Column
    private int custId;
    @Column
    private int productId;
    @Column(nullable = true)
    private String images;
    @Column(nullable = true)
    private String video;

    public int getRatId() {
        return ratId;
    }

    public void setRatId(int ratId) {
        this.ratId = ratId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
    
}
