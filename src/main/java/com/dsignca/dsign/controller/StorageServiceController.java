package com.dsignca.dsign.controller;

import com.dsignca.dsign.entity.CAUser.FileData;
import com.dsignca.dsign.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/image")
@CrossOrigin("http://localhost:4200")
public class StorageServiceController {


    @Autowired
    private StorageService service2;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageFromFileSystem(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = service2.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem")
   public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<FileData> allFiles = service2.getAllFiles();
        List<ResponseFile> files = allFiles.stream().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("C:/Users/Asus/IdeaProjects/MyWebApp/DSign-API/src/main/resources/static/Images/")
                    .path(String.valueOf(dbFile.getWid()))
                    .toUriString();

            return new ResponseFile(
                    dbFile.getFileName(),
                    fileDownloadUri, 128);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = service2.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

}
