package com.mbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.Author;
import com.mbook.entity.CategoryEntity;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.CategoryRepository;

@CrossOrigin()
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/get")
	public ResponseEntity<List<CategoryEntity>> getAll() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	@PostMapping("/upload")
	public ResponseEntity<CategoryEntity> CreateCategory(@Validated @RequestBody CategoryEntity data, HttpServletRequest request) {
		if(repo.findOneByName(data.getName())== null) {
			String authorizationHeader = request.getHeader("Authorization");
			String jwt = authorizationHeader.substring(7);
			String username = jwtUtil.extractUsername(jwt);
			data.setCreatedby(username);
			return ResponseEntity.status(HttpStatus.OK).body(repo.save(data));
		}else {	
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(repo.save(data));
		}
		
	}
}
