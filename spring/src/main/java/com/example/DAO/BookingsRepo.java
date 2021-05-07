package com.example.DAO;

import java.util.List;

import com.example.model.BookingsModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepo extends JpaRepository<BookingsModel,Integer>{
    
    public List<BookingsModel> findByUser(String user);
}
