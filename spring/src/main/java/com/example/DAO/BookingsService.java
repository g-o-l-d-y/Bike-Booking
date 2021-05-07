package com.example.DAO;

import com.example.model.BookingsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {

        @Autowired
        BookingsRepo bookingsRepo;

        public void addBooking(int bikeId, String admin, String user){
            BookingsModel newBooking=new BookingsModel();
            newBooking.setBikeId(bikeId);
            newBooking.setAdmin(admin);
            newBooking.setUser(user);
            bookingsRepo.save(newBooking);
        }

}
