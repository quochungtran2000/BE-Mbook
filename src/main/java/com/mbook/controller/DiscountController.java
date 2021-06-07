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

import com.mbook.entity.Discount;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.DiscountRepository;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/discount")
public class DiscountController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private DiscountRepository repo;
	
	@GetMapping("/get")
	public ResponseEntity<List<Discount>> getAll() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	@PostMapping("/upload")
	public ResponseEntity<Discount> AddDiscount(@Validated @RequestBody Discount data, HttpServletRequest request) {
		if(repo.findOneByName(data.getName()) == null) {
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
