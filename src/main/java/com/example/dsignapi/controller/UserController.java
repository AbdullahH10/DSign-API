package com.example.dsignapi.controller;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.dtos.LoginDTO;
import com.example.dsignapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @PostMapping("/login")
    public User addUserByEmail(@RequestBody LoginDTO dto){
        return service.loginUser(dto);
    }
    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
   }
    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable int userId){
        return service.getUserById(userId);
   }
    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId,@RequestBody User user){
        return service.updateUser(userId,user);
    }
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId){
        return service.deleteUser(userId);
    }

    @DeleteMapping("/deleteAll")
    public User deleteAllUsers(User user){

        return service.deleteAll();
    }
}
