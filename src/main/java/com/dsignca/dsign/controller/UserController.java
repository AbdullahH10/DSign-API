package com.dsignca.dsign.controller;

import com.dsignca.dsign.entity.CAUser.User;
import com.dsignca.dsign.entity.CAUser.dtos.LoginDTO;
import com.dsignca.dsign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SuppressWarnings("S")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("login")
    public User addUserByEmail(@RequestBody LoginDTO dto){
        return service.LoginUser(dto);
    }

//    @PostMapping("/addUsers")
//    public List<User> AddUsers(@RequestBody List<User> users){
//        return service.saveUsers(users);
//    }
    @GetMapping("/Users")
    public List <User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/usersById/{userId}")
    public User findById(@PathVariable int userId){
        return service.getUserById(userId);
    }

    @GetMapping("/usersByName/{firstName}")
    public User findByName(@PathVariable String firstName){
        return service.getUserByName(firstName);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.upadateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId){
        return service.deleteUser(userId);
    }
}