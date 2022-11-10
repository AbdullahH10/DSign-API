package com.example.dsignapi.controller;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.dtos.LoginDTO;
import com.example.dsignapi.entity.dtos.UserImageUpdateDTO;
import com.example.dsignapi.service.StorageService;
import com.example.dsignapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StorageService storageService;

//    @PostMapping("/addUser")
//    public User addUser(@RequestBody User user){
//        return service.saveUser(user);
//    }



// ->> Adding profile Image and Signature Image with multipart form data(JSON) DATE:9/11/2022 <<-
    @PostMapping(value="/addUser",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public User addUser(@RequestPart("user") String userId, @RequestPart ("file") List<MultipartFile> file){
        return userService.addUser(userId,file);
    }
    @PutMapping(value="/updateUser",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public User updateUser(@RequestPart("user") String user, @RequestParam ("file") List<MultipartFile> file){
        return userService.updateUser(user,file);
    }
//    @DeleteMapping(value="/deleteUser",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
//    public User updateUser(@RequestPart("user") String user, @RequestParam ("file") List<MultipartFile> file){
//        return userService.deleteByUserId(user,file);

    // ->> Adding profile Image and Signature Image with multipart form data(JSON) <<-

    @PostMapping("/login")
    public User addUserByEmail(@RequestBody LoginDTO dto){
        return userService.loginUser(dto);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
   }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }
    @Transactional
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteById(userId);
    }

    @Transactional
    @DeleteMapping("/deleteAll")
    public User deleteAllUsers(User user){
        return userService.deleteAll();
    }


//    @GetMapping("/userProfileImage/{userId}")
//    public User findUseByProfileImage(@PathVariable String userId){
//        return userService.getUserById(userId);
//    }
//
//    @GetMapping("/userSignatureImage/{userId}")
//    public User findUseBySignatureImage(@PathVariable String userId){
//        return userService.getUserById(userId);

//@GetMapping("/user/profileImageLocation/{UserId}")
//public ResponseEntity<?> downloadProfileImage(@PathVariable String UserId) throws IOException{
//    byte[] imageData=storageService.downloadProfileImageFromFileSystem(UserId);
//    return ResponseEntity.status(HttpStatus.OK)
//            .contentType(MediaType.valueOf("image/jpg"))
//            .body(imageData);
//}
//
//    @GetMapping("/user/signatureImageLocation/{UserId}")
//    public ResponseEntity<?> downloadSignatureImage(@PathVariable String UserId) throws IOException{
//        byte[] imageDataTwo=storageService.downloadSignImageFromFileSystem(UserId);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/jpg"))
//                .body(imageDataTwo);
//    }

    }



