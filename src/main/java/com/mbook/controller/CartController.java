package com.mbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.Account;
import com.mbook.entity.Cart;
import com.mbook.entity.CartDTO;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.CartRepository;
import com.mbook.service.CartService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	AccountRepository accountRepo;
	@Autowired
	CartRepository repo;
	@Autowired
	CartService service;
	@Autowired
	private JwtUtil jwtUtil;
	@GetMapping("/get")
	public List<Cart> getCartByUserName(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		Account acc = accountRepo.findOneByUsername(username);
		List<Cart> listAll = repo.findAll();
		List<Cart> cart = new ArrayList<Cart>();
		for (Cart item : listAll) {
			if(item.getAccountCart().getId() == acc.getId()) {
				cart.add(item);
			}
		}
		return cart;
	}
	@PostMapping("/upload")
	public String CreateProduct(@Validated @RequestBody CartDTO cart, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if (cart != null) {
			cart.setCreatedby(username);
			service.save(cart);
			return "Thêm Sản Phẩm Mới Thành Công";
		} else {
			return "Thêm Thất Bại, Vui Lòng Kiểm Tra Lại";
		}

	}

	@PutMapping("/update/{id}")
	public String updateQuantity(@PathVariable Long id,
			@Validated	@RequestBody int quantity, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		
		boolean status = false;
		List<Cart> listCart = service.ListAll();
		for (Cart cart : listCart) {
			if(cart.getAccountCart().getUsername().equalsIgnoreCase(username)
			&& cart.getListProduct().indexOf(id) != -1){
				cart.setQuantity(cart.getQuantity() + quantity);
				cart.setModifiedby(username);
				repo.save(cart);
				status = true;
			}else {
				status = false;
			}
		}
		if (status == true) {
			return "Thêm Sản Phẩm Thành Công";
		} else {
			return "Thêm Sản Phẩm Thất Bại";
		}
	}

}
