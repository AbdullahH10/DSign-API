package com.example.dsignapi.service;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.dtos.LoginDTO;
import com.example.dsignapi.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final String FOLDER_PATH = "F:/LoginWithJavaMail/Dsign-API/src/main/resources/static/files/";
    @Autowired
    private UserRepository repository;
    
    public User saveUser(User user){
        return (User) repository.save(user);
    }

//  ->>  This method is used for getting profile & signature image location + Saving Json data <<-
    public User addUser(String userId, List<MultipartFile> file){
        User userJson = new User();

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            userJson = objectMapper.readValue(userId,User.class);
        }
        catch(IOException error){
            System.out.printf("Error",error.toString());
        }
        userJson.setProfileImageLocation(String.valueOf(FOLDER_PATH+file.get(0).getOriginalFilename()));
        userJson.setSignatureImageLocation(FOLDER_PATH+file.get(1).getOriginalFilename());

        return (User) repository.save(userJson);
    }
    public List<User> getUsers(){
        return repository.findAll();
    }
    public User getUserById(String userId){
        return (User) repository.findByUserId(userId).orElse(null);
    }

//    public User getUserByEmail(String Email, User user){
//        return repository.findByEmail(Email);
//    }


//    public User updateUser(int userId){
//        return (User) repository.findById(userId).orElse(null);
//    }

    public String deleteById(String userId){
        repository.deleteByuserId(userId);
        return "user removed ||"+userId;
    }
    public User deleteAll() {
        repository.deleteAll();
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

    public User updateUser(String user, List<MultipartFile> file) {
        User userJson = new User();

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            userJson = objectMapper.readValue(user,User.class);
            User existingUser = repository.findByUserId(userJson.getUserId())
                            .orElseThrow(()-> new RuntimeException("user not found!"));

            existingUser.setFirstName(userJson.getFirstName());
            existingUser.setLastName(userJson.getLastName());
            existingUser.setEmail(userJson.getEmail());
            existingUser.setPassword(userJson.getPassword());
            existingUser.setPhoneNo(userJson.getPhoneNo());
            existingUser.setOrganization(userJson.getOrganization());
            existingUser.setDesignation(userJson.getDesignation());

            existingUser.setProfileImageLocation(FOLDER_PATH+file.get(0).getOriginalFilename());
            existingUser.setSignatureImageLocation(FOLDER_PATH+file.get(1).getOriginalFilename());


            repository.save(existingUser);
//            System.out.println("ashse");
            return existingUser;
        }
        catch(IOException error){
            System.out.printf("Error",error.toString());
        }
        return null;

    }

//    public Optional<User> updateUserImage(UserImageUpdateDTO userImageUpdateDTO) {
//
//
////        User user2 = repository.findByProfileImageLocation(userImageUpdateDTO.getUserid());
//        Optional<User> user2 = repository.findById(userImageUpdateDTO.getUserid());
//
////        User user3 = repository.findBySignatureImageLocation(userImageUpdateDTO.getUserid());
//        Optional<User> user3 = repository.findById(userImageUpdateDTO.getUserid());
//
//        if(user2==null) {
////            throw  new RuntimeException("User not found");
//            System.out.print("user not found!");
//            return null;
//        }
//        else if (user2!=null){
//            return user2;
//        }
//
//        else if(user3==null) {
////            throw  new RuntimeException("User not found");
//            System.out.print("user not found!");
//            return null;
//        }
//        else {
//            return user3;
//        }
//
//    }


}
