package com.mbook.controller;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@CrossOrigin(origins = "*", maxAge = 3600)
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
	@GetMapping("/details/{idOrder}")
	public ResponseEntity<Orders> getOneByID(@PathVariable UUID idOrder) {
		return new ResponseEntity<>(service.get(idOrder), HttpStatus.OK);
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
