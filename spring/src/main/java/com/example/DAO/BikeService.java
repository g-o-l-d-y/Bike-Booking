package com.example.DAO;

import java.util.List;
import java.util.Optional;

import com.example.model.BikeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    BikeRepo bikeRepo;

    @Autowired
    BookingsRepo bookingsRepo;

    public List<BikeModel> getBikes(String admin){
		return bikeRepo.findByAdmin(admin);
	}

    public List<BikeModel> getAllBikes(){
        return bikeRepo.findAll();
    }

    public void addBike(BikeModel bike){
        bikeRepo.save(bike);
    }

    public void editBike(BikeModel bike){
        bikeRepo.save(bike);
    }

    public void deleteBike(int bikeId){
        
        if(bikeRepo.findById(bikeId).get().getStatus().equals("booked"))
            bookingsRepo.deleteById(bikeId);
        bikeRepo.deleteById(bikeId);
    }

    public void bookBike(int bikeId){
        Optional<BikeModel> l=bikeRepo.findById(bikeId);
        BikeModel bike=l.get();
        bike.setStatus("booked");
        bikeRepo.save(bike);
    }

    public BikeModel getBikeDetails(int bikeId){
        return bikeRepo.findById(bikeId).get();
    }
}
