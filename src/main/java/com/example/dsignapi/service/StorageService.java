package com.example.dsignapi.service;

import com.example.dsignapi.entity.FileData;
import com.example.dsignapi.entity.User;
import com.example.dsignapi.repository.FileDataRepository;
import com.example.dsignapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import  java.util.Optional;

@Service
@RestController
public class StorageService {
//    private StorageRepository repository;
    @Autowired
    private FileDataRepository fileDataRepository;

    @Autowired
    private UserRepository userRepository;
    private final String FOLDER_PATH = "F:/LoginWithJavaMail/Dsign-API/src/main/resources/static/files/";


    public String uploadPdfToFileSystem(MultipartFile file) throws IOException{

        String filepath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(FileData.builder()
                .workFlowName(file.getOriginalFilename())
                .documentLocation(filepath).build());

        file.transferTo(new File(filepath));

        if(fileData != null){
            return "pdf file uploaded successfully:" + filepath;
        }
        return null;
    }

    public byte[] downloadPdfFromFileSystem(String fileName) throws IOException{
        Optional<FileData> fileData = fileDataRepository.findByworkFlowName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] pdf = Files.readAllBytes(new File(filePath).toPath());
        return pdf;
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException{

        String filepath=FOLDER_PATH+file.getOriginalFilename();

        User userData = userRepository.save(User.builder()
                                .Userid(file.getOriginalFilename())
//                        .email(file.getOriginalFilename())
                        .ProfileImageLocation(filepath).build());

        file.transferTo(new File(filepath));

        if(userData != null){
            return "image file uploaded successfully:" + filepath;
        }
        return null;
    }

//    public byte[] downloadImageFromFileSystem(String userId) throws IOException{
//        Optional<User> userData = userRepository.findByUserId(userId);
////        Optional<User> userData = userRepository.findById(userId);
////        String filePath = userData.get().getProfileImageLocation();
//        String filePath = userData.get().getProfileImageLocation();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }


}






