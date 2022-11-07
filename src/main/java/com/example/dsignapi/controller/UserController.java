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

import java.io.IOException;
import java.util.List;
import java.util.Optional;
//@RequestMapping("/image")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private StorageService service2;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @PostMapping("/login")
    public User addUserByEmail(@RequestBody LoginDTO dto){
        return service.loginUser(dto);
    }

//    @PostMapping("/image/profileImage")
//    public Optional<User> addProfileImage(@RequestBody UserImageUpdateDTO dto){
//        return service.updateUserImage(dto);
//    }
//
//    @PostMapping("image/signatureImage")
//    public Optional<User> addSignatureImage(@RequestBody UserImageUpdateDTO dto){
//        return service.updateUserImage(dto);
//    }

    @PostMapping("/user/profileImage")
    public ResponseEntity<?> uploadProfileImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service2.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
    @PostMapping("/user/signatureImage")
    public ResponseEntity<?> uploadSignatureImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service2.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

//    @GetMapping("/user/profileImageLocation/{userId}")
//    public ResponseEntity<?> downloadProfileImage(@PathVariable int userId) throws IOException{
//        byte[] imageData=service2.downloadImageFromFileSystem(userId);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/jpg"))
//                .body(imageData);
//    }
//
//    @GetMapping("/user/signatureImageLocation/{userId}")
//    public ResponseEntity<?> downloadSignatureImage(@PathVariable int userId) throws IOException{
//        byte[] imageData=service2.downloadImageFromFileSystem(filename);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/jpg"))
//                .body(imageData);
//    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
   }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable int userId){
        return service.getUserById(userId);
    }

    @GetMapping("/userProfileImage/{userId}")
    public User findUseByProfileImage(@PathVariable int userId){
        return service.getUserById(userId);
    }

    @GetMapping("/userSignatureImage/{userId}")
    public User findUseBySignatureImage(@PathVariable int userId){
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
