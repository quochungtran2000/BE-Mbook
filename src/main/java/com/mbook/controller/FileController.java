package com.mbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mbook.entity.Account;
import com.mbook.entity.FileDB;
import com.mbook.entity.Poster;
import com.mbook.reponse.ResponseFile;
import com.mbook.reponse.ResponseMessage;
import com.mbook.service.FileStorageService;


@Controller
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@WebServlet("/FileStorageService")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100) 
public class FileController {

  @Autowired
  private FileStorageService storageService;

//  @PostMapping("/upload")
//  public FileDB uploadFile(@RequestParam(name = "file",required = false) MultipartFile file) {
//	  try {
//      storageService.store(file);
//      System.out.println("Đã lưu "+file);
//      System.out.println("UPLOADED SUCESS");
////      return storageService.getFile(file.getOriginalFilename());
//      
//    } catch (Exception e) {
//    	System.out.println("Giá trị của file là "+file + "Nên FAILD");
//    	System.out.println("UPLOADED FAILD " + e);
//    }
//	  return storageService.getFile(file.getOriginalFilename());
//  }
  @PostMapping("/upload")
  public ResponseEntity<?> uploadFile(@RequestBody Poster post) {
	  System.out.println("FILE : " + post);
//	  if(post != null) {
//		  System.out.println("\n\n\n File \n\n\n");
//		  try {
//				storageService.store(post);
//				System.out.println("Upload Success");
				return new ResponseEntity<>(HttpStatus.OK);
//			}
//		  catch (IOException e) {
//				System.out.println(e);
//				return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//			}
//	  }
//	  else {
//		  return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//	  }
  	}
//  public String uploadAvatar(String authToken, String email, String isAvatarSinglePerson, MultipartFile file) {
//      User user = userService.getUser(authToken, email);
//      if (user != null) {
//          String publicId = upload(authToken, email, file);
//          if ("true".equalsIgnoreCase(isAvatarSinglePerson)) {
//              user.setAvatar_SinglePerson_PublicID(publicId);
//          } else {
//              user.setAvatar_Collective_PublicID(publicId);
//          }
//          userRepository.save(user);
//          logger.info("Saved the new avatar for the user: " + email);
//          return publicId;
//      } else {
//          logger.warn("Cannot authenticate the user " + email + " to upload him/her avatar");
//          return null;
//      }
//  }
 
  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
}