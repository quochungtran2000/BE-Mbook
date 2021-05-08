package com.mbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.Author;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AuthorRepository;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/author")
@RestController
public class AuthorController {
	@Autowired
	AuthorRepository repo;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@GetMapping("")
	public ResponseEntity<List<Author>> all() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	@GetMapping("/details/{AuthorId}")
	public ResponseEntity<Author> get(@PathVariable Long AuthorId) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.getOne(AuthorId));
	}
	@PostMapping("")
	public ResponseEntity<Author> CreateAuthor(@Validated @RequestBody Author data, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		data.setCreatedby(username);
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(data));
	}
}
