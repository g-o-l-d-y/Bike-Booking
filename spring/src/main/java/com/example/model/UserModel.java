package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserModel {
    
    @Id
    String username;
    String password;
    String email;
    String mobileNumber;
    int age;
    String userRole;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public UserModel(String username, String password, String email, String mobileNumber, int age, String userRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.userRole = userRole;
    }
    public UserModel() {
    }
}
