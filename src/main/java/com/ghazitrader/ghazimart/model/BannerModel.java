package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Banner")
public class BannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int bannerId;
    @Column
    private String fileName;
    @Column
    private String fileDownloadUri;
    @Column
    private String fileType;
    @Column
    private long size;
    @Column
    private int productId;
    @Column
    private int catId;
    @Column
    private int subCatId;

    public BannerModel(){
        
    }
    public BannerModel(String fileName, String fileDownloadUri, String fileType, long size,
            final int productId, final int catId, final int subCatId){
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
        this.productId = productId;
        this.catId= catId;
        this.subCatId=subCatId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
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
