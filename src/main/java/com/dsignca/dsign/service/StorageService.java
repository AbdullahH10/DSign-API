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
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private FileRepository fileRepository;
    private final String FOLDER_PATH="/home/abdullah/Documents/";

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
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileRepository.findByFileName(fileName);
        String filePath=fileData.get().getPdfLocation() ;
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
