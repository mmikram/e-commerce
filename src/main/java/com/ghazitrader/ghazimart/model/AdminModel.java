package com.ghazitrader.ghazimart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AdminDetail")
public class AdminModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int userId;
    @Column
    private String fullName;
    @Column
    private String mobleNo;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String role;
    @Column
    private int status;
    @Column
    private int parentId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobleNo() {
        return mobleNo;
    }

    public void setMobleNo(String mobleNo) {
        this.mobleNo = mobleNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    
    
}
