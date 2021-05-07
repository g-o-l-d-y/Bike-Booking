package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class BikeModel {
    
    @Id
    @GeneratedValue
    int bikeId;
    String bikeNo;
    String admin;
    String status;
    String price;
    
    
    public int getBikeId() {
        return bikeId;
    }
    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    public String getBikeNo() {
        return bikeNo;
    }
    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }
    
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public BikeModel(String bikeNo, String admin, String status, String price) {
        
        this.bikeNo = bikeNo;
        this.admin = admin;
        this.status = status;
        this.price = price;
    }

    public BikeModel()
    {

    }
    
}
