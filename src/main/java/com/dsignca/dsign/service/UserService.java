package com.dsignca.dsign.service;

import com.dsignca.dsign.entity.CAUser.User;
import com.dsignca.dsign.entity.CAUser.dtos.LoginDTO;
import com.dsignca.dsign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
//    public List<User> saveUsers(List<User> users){
//        return repository.saveAll(users);
//    }

    public List <User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int userId){
        return repository.findById(userId).orElse(null ) ;
    }

    public User getUserByName(String firstName){
        return repository.findUserByFirstName(firstName);
    }

    public String deleteUser(int userId){
        repository.deleteById(userId);
        return "product removed || "+userId;
    }

    public User upadateUser(User user){
        User existinguser = repository.findById(user.getUserId()).orElse(null);
        existinguser.setEmail(user.getEmail());
        existinguser.setPassword(user.getPassword());
        existinguser.setFirstName(user.getFirstName());
        existinguser.setLastName(user.getLastName());
        existinguser.setPhoneNo(user.getPhoneNo());
        existinguser.setOrganization(user.getOrganization());
        existinguser.setDesignation(user.getDesignation());
//        existinguser.setPdfLocation(user.getPdfLocation());
        existinguser.setProfileImageLocation(user.getProfileImageLocation());
        existinguser.setSignImageLocation(user.getSignImageLocation());
        return repository.save(existinguser);
    }

    public User LoginUser(LoginDTO loginDTO){
        User user =repository.findByEmail(loginDTO.getEmail());
        if(user==null){
            System.out.print("user not found");
            return null;
        }
        if(user.getPassword().equals(loginDTO.getPassword())){
            return user;
        }
        else{
            System.out.print("Invalid Password");
            return null;
        }

    }
}
