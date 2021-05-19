package com.mbook.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.mbook.dto.ProductDTO;
import com.mbook.entity.Product;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.ProductRepository;
import com.mbook.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private JwtUtil jwtUtil;
	@GetMapping("/get")
	public ResponseEntity<List<Product>> all() {
		return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
	}
	@GetMapping("/details/{productID}")
	public ResponseEntity<Product> get(@PathVariable Long productID) {
		return ResponseEntity.status(HttpStatus.OK).body(productRepo.getOne(productID));
	}
	@PostMapping("/upload")
	public String CreateProduct(@Validated @RequestBody ProductDTO pro, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if(pro != null) {
			pro.setCreatedby(username);
			productService.save(pro); 	
			return "Thêm Sản Phẩm Mới Thành Công";
		}else {
			return "Thêm Thất Bại, Vui Lòng Kiểm Tra Lại";
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			productService.delete(id);
			System.out.println("Xóa : " + id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
