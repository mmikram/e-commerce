package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CustomerDetail")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int custId;
    private String custName;
    @Column
    private String mobileNo;
    @Column(length = 500)
    private String fcmToken;
    @Column(nullable = true)
    private String custEmail;

    @Column
    private String loginType;

    @Column
    private String loginId;


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }


}
