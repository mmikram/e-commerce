package com.ghazitrader.ghazimart.model;

public class StandardResponse {

    private String description;
    private int statusCode;
    private String ActionName;
    private String data;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }
   
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
     
}
