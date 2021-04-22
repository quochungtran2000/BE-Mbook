package com.mbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.Poster;
import com.mbook.service.PosterService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/poster")
public class PosterController {
	
	@Autowired
	private PosterService posterService;
	
	@GetMapping("/get")
	public List<Poster> list() {
		return posterService.ListAll();
	}

	@GetMapping("/{id}")
	public Poster get(@PathVariable Long id) {
		return posterService.get(id);
	}	
	@PostMapping("/upload")
	public void uploadFile(@RequestBody Poster post) {
	Long idTemp = null;
	if(post != null) {
		try {
			  
//			  posterService.save(post);
			  idTemp = post.getId();
			  System.out.println("Đã lưu "+post);
			  System.out.println("UPLOADED SUCESS");
	      
	    } catch (Exception e) {
	    	System.out.println("Giá trị của file là "+ post + "Nên FAILD");
	    	System.out.println("UPLOADED FAILD " + e);
	    }
	}
	  
//	  return posterService.get(idTemp);
  }

}
