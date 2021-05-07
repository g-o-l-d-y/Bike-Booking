package com.example.DAO;

import com.example.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,String>{
    public UserModel findByUsername(String username);
}