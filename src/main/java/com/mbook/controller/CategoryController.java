package com.mbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.CategoryEntity;
import com.mbook.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {

	
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/get")
	public ResponseEntity<List<CategoryEntity>> getAll() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
}
