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

import com.mbook.dto.OrderDTO;
import com.mbook.entity.Orders;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.OrderRepository;
import com.mbook.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository repo;
	@Autowired
	private OrderService service;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/get")
	public ResponseEntity<List<Orders>> list() {
		return new ResponseEntity<>(service.ListAll(), HttpStatus.OK);
	}

	@PostMapping("/upload")
	public Orders Create(@Validated @RequestBody OrderDTO order, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if (order != null) {
			order.setCreatedby(username);
			return service.save(order);
		} else {
			return null;
		}

	}
}
