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
    @Autowired
    private UserRepository userRepository2;
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
        String filePath = fileData.get().getDocumentLocation();
        byte[] pdf = Files.readAllBytes(new File(filePath).toPath());
        return pdf;
    }



    public String uploadProfileImageToFileSystem(MultipartFile file) throws IOException{

        String filepath=FOLDER_PATH+file.getOriginalFilename();

        User userData = userRepository.save(User.builder()
                                .userId(file.getOriginalFilename())
//                        .email(file.getOriginalFilename())
                        .profileImageLocation(filepath).build());

        file.transferTo(new File(filepath));

        if(userData != null){
            return "Profile image file uploaded successfully:" + filepath;
        }
        return null;
    }

    public byte[] downloadProfileImageFromFileSystem(String filename) throws IOException{
        Optional<User> userData = userRepository.findByUserId(filename);
//        Optional<User> userData = userRepository.findById(userId);
//        String filePath = userData.get().getProfileImageLocation();
        String filePath = userData.get().getProfileImageLocation();
        byte[] ProfileImages = Files.readAllBytes(new File(filePath).toPath());
//        System.out.println("ashse");
        return ProfileImages;

    }

    public String uploadSignImageToFileSystem(MultipartFile file) throws IOException{

        String filepath=FOLDER_PATH+file.getOriginalFilename();

        User userData2 = userRepository.save(User.builder()
                .userId(file.getOriginalFilename())
//                        .email(file.getOriginalFilename())
                .signatureImageLocation(filepath).build());

        file.transferTo(new File(filepath));

        if(userData2 != null){
            return "Signature image file uploaded successfully:" + filepath;
        }
        return null;
    }

    public byte[] downloadSignImageFromFileSystem(String filename) throws IOException{
        Optional<User> userData2 = userRepository2.findByUserId(filename);
//        Optional<User> userData = userRepository.findById(userId);
//        String filePath = userData.get().getProfileImageLocation();
        String filePath = userData2.get().getSignatureImageLocation();
        byte[] SignatureImages = Files.readAllBytes(new File(filePath).toPath());
        return SignatureImages;
    }


}






