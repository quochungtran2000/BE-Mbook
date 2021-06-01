package com.mbook.controller;

import java.util.List;
import java.util.UUID;

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

	@GetMapping("/get")
	public ResponseEntity<List<Author>> all() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/details/{AuthorId}")
	public ResponseEntity<Author> get(@PathVariable UUID AuthorId) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(AuthorId).get());
	}

	@PostMapping("/upload")
	public String CreateAuthor(@Validated @RequestBody Author data, HttpServletRequest request) {
		List<Author> list = repo.findAll();
		for (Author item : list) {
			if (item.getName().equals(data.getName())) {
				return "Tác Giả Đã Tồn Tại";
			}
		}
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);

		System.out.println("name : " + data.getName());
		System.out.println("name : " + data.getProductList());
		System.out.println("desciption : " + data.getDescription());
		data.setCreatedby(username);
		repo.save(data);
		return "Thêm Tác Giả Thành Công";

	}
}
