package com.ckoipapa.com.ckoipapa.web;

import com.ckoipapa.com.ckoipapa.dao.ClientRepository;
import com.ckoipapa.com.ckoipapa.entities.Client;
import com.ckoipapa.com.ckoipapa.storage.FileStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UploadRestService {

	@Autowired
	FileStorage fileStorage;
	
    @GetMapping("/")
    public String index() {
        return "multipartfile/uploadform.html";
    }
    
    @PostMapping("/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			fileStorage.store(file);
			model.addAttribute("message", "File uploaded successfully! -> filename = " + file.getOriginalFilename());
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
        return "multipartfile/uploadform.html";
    }

}
