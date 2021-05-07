package com.example.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.model.BikeModel;
import com.example.model.BookingsModel;
import com.example.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    BookingsRepo bookingsRepo;

    @Autowired
    BikeRepo bikeRepo;
	
	public List<BikeModel> getBookings(String user){
        List<BookingsModel> l=bookingsRepo.findByUser(user);
        List<BikeModel> res=new ArrayList<BikeModel>();
        for(BookingsModel booking:l){
            Optional<BikeModel> opt=bikeRepo.findById(booking.getBikeId());
            if(!opt.isEmpty())
                res.add(opt.get());
        }
		return res;
	}

    public void editUser(UserModel user){
        userRepo.save(user);
    }

    public void saveUser(UserModel user){
        userRepo.save(user);
    }

    public UserModel getUser(String username)
    {
        return userRepo.findById(username).get();
    }

    public List<UserModel> getAllUsers()
    {
        return userRepo.findAll();
    }

    public void deleteUser(String username)
    {
        userRepo.deleteById(username);
    }

}
