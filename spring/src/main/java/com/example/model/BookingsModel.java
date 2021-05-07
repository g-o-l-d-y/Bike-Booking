package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingsModel {
    
    @Id
    int bikeId;
    String admin;
    String user;
    
    public int getBikeId() {
        return bikeId;
    }
    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    
 
}
