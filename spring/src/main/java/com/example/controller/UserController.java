package com.example.controller;

import java.util.List;

import com.example.DAO.BikeService;
import com.example.DAO.UserService;
import com.example.model.BikeModel;
import com.example.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @Autowired
    BikeService bikeService;

    @GetMapping("/user/bookings")
    public List<BikeModel> getBookings(@RequestParam String user) {
        return userService.getBookings(user);
    }

    @PostMapping(value={"/user/editProfile","/admin/editProfile"})
    public void editUser(@RequestBody UserModel user){
        userService.editUser(user);
    }

    @GetMapping(value={"/user/profile","/admin/profile"})
    public UserModel getUser(@RequestParam String username)
    {
        return userService.getUser(username);
    }

    @GetMapping("/superadmin/dashboard")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/superadmin/deleteUser")
    public void deleteUser(@RequestParam String username)
    {
        userService.deleteUser(username);
    }

}
