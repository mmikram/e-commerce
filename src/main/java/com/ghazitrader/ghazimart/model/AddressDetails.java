package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class    AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(length = 200)
    private String address1;
    @Column
    private double pincode;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String district;
    @Column(nullable = true)
    private String landmark;
    @Column(nullable = true)
    private String latitute;
    @Column(nullable = true)
    private String logitute;
    @Column
    private String locallity;
    public String getLocallity() {
        return locallity;
    }

    public void setLocallity(String locallity) {
        this.locallity = locallity;
    }

    @Column
    private String mobile;

    @Column
    private String deliveryMobile;
    @Column
    private String addressType;   

    private int isDefault;
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getDeliveryMobile() {
        return deliveryMobile;
    }

    public void setDeliveryMobile(String deliveryMobile) {
        this.deliveryMobile = deliveryMobile;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

   

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public double getPincode() {
        return pincode;
    }

    public void setPincode(double pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLogitute() {
        return logitute;
    }

    public void setLogitute(String logitute) {
        this.logitute = logitute;
    }

   

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
}
