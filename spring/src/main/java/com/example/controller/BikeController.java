package com.example.controller;

import java.util.List;

import com.example.DAO.BikeService;
import com.example.DAO.BookingsService;
import com.example.model.BikeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BikeController {
    
    @Autowired
    BikeService bikeService;

    @Autowired
    BookingsService bookingsService;

    @GetMapping(value={"/user/bikes","/admin/dashboard"})
    public List<BikeModel> getBikes(@RequestParam String admin) {
        System.out.println(admin);
        return bikeService.getBikes(admin);
    }

    @GetMapping("/user/dashboard")
    public List<BikeModel> getAllBikes(){
        return bikeService.getAllBikes();
    }

    @PostMapping("/admin/addBike")
    public void addBike(@RequestBody BikeModel bike) {
        bikeService.addBike(bike);
    }

    @GetMapping("/admin/deleteBike")
    public void deleteBike(@RequestParam int bikeId) {
        bikeService.deleteBike(bikeId);
    }

    @PostMapping("/admin/editBike")
    public void editBike(@RequestBody BikeModel bike) {
        bikeService.editBike(bike);
    }

    @GetMapping("/user/bookBike")
    public void bookBike(@RequestParam String bikeId, @RequestParam String user, @RequestParam String admin) {
        System.out.println("Booking");
        int bikeId_INT = Integer.parseInt(bikeId);
        bikeService.bookBike(bikeId_INT);
        bookingsService.addBooking(bikeId_INT,admin,user);
    }

    @GetMapping("/user/bikeDetails")
    public BikeModel getBikeDetails(@RequestParam int bikeId){
        return bikeService.getBikeDetails(bikeId);
    }

}
