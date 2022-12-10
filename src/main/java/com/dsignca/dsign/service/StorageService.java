package com.dsignca.dsign.service;
import com.dsignca.dsign.controller.StorageServiceController;


import com.dsignca.dsign.entity.CAUser.FileData;
import com.dsignca.dsign.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StorageService {
    @Autowired
    private FileRepository fileRepository;
<<<<<<< HEAD
    private final String FOLDER_PATH="C:/Users/Asus/IdeaProjects/MyWebApp/DSign-API/src/main/resources/static/Images/";
=======
    private final String FOLDER_PATH="/home/abdullah/Documents/";
>>>>>>> 3c253611325b7c57535c00d1bc305b8a52a285f7

    public String uploadImageToFileSystem(MultipartFile file) throws IOException{
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData = fileRepository.save(FileData.builder()
                .fileName(file.getOriginalFilename())
                .pdfLocation(filePath).build());
        file.transferTo(new File(filePath));

        if(fileData != null){
            return "file uploaded successfully"+filePath;
        }
        return null;
    }

    public List<FileData> getAllFiles() {
        return fileRepository.findAll();
   }
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileRepository.findByFileName(fileName);
        String filePath=fileData.get().getPdfLocation() ;
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}
