package com.dsignca.dsign.controller;

import com.dsignca.dsign.entity.CAUser.User;
import com.dsignca.dsign.entity.CAUser.dtos.LoginDTO;
import com.dsignca.dsign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SuppressWarnings("S")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public User addUserByEmail(@RequestBody LoginDTO dto){
        return service.LoginUser(dto);
    }

//    @PostMapping("/addUsers")
//    public List<User> AddUsers(@RequestBody List<User> users){
//        return service.saveUsers(users);
//    }
    @GetMapping("/users")
    public List <User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable int userId){
        return service.getUserById(userId);
    }

<<<<<<< HEAD
    @GetMapping("/users/name/{firstName}")
    public User findByName(@PathVariable String firstName){
        return service.getUserByName(firstName);
    }
=======
//    @GetMapping("/usersByName/{firstName}")
//    public User findByName(@PathVariable String firstName){
//        return service.getUserByName(firstName);
//    }
>>>>>>> 3c253611325b7c57535c00d1bc305b8a52a285f7

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return service.upadateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        return service.deleteUser(userId);
    }
}
