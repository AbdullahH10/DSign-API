package com.example.dsignapi.service;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.dtos.LoginDTO;
import com.example.dsignapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public User saveUser(User user){
        return (User) repository.save(user);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }
    public User getUserById(int userId){
        return (User) repository.findById(userId).orElse(null);
    }

//    public User getUserByEmail(String Email, User user){
//        return repository.findByEmail(Email);
//    }


//    public User updateUser(int userId){
//        return (User) repository.findById(userId).orElse(null);
//    }

    public String deleteUser(int userId){
        repository.deleteById(userId);
        return "user removed ||"+userId;
    }
    public User deleteAll() {
        repository.deleteAll();
        return null;
    }

    public User updateUser(Integer userId, User user){
        User existingUser = repository.findById(userId).orElse(null);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNo(user.getPhoneNo());
        existingUser.setOrganization(user.getOrganization());
        existingUser.setDesignation(user.getDesignation());
        existingUser.setProfileImageLocation(user.getProfileImageLocation());
        existingUser.setSignatureImageLocation(user.getSignatureImageLocation());
        return repository.save(existingUser);
    }


    public User updateUserById(String userId) {
        return null;
    }


    public User loginUser(LoginDTO loginDTO) {
        User user = repository.findByEmail(loginDTO.getEmail());
        if(user==null) {
//            throw  new RuntimeException("User not found");
            System.out.print("user not found!");
            return null;
        }
        if(user.getPassword().equals(loginDTO.getPassword())) {
            return user;
        }
        else {
//            throw new RuntimeException("invalid password!");
            System.out.print("invalid password!");
            return null;
        }
    }

}
