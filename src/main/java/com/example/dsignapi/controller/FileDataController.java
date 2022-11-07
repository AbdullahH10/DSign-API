package com.example.dsignapi.controller;

import com.example.dsignapi.service.StorageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileDataController {

    @Autowired
    private StorageService service2;

    @PostMapping("/fileSystem")
    public ResponseEntity <?> uploadPdfToFileSystem(@RequestParam("file")MultipartFile file) throws IOException{
        String uploadImage = service2.uploadPdfToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
        }

        @GetMapping("/fileSystem/{filename}")
        public ResponseEntity<?> downloadPdfFromFileSystem(@PathVariable String filename) throws IOException{
            byte[] fileData=service2.downloadPdfFromFileSystem(filename);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(fileData);
        }




    }



