package com.mbook.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.convert.ProductConvert;
import com.mbook.dto.ProductDTO;
import com.mbook.entity.Author;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Product;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AuthorRepository;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.ProductRepository;
import com.mbook.service.ProductService;

@CrossOrigin()
@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProductService productService;
	@Autowired
	AuthorRepository AuthorRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	ProductConvert convert;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/get")
	public List<Product> all() {
		return productRepo.findAll();
	}

	@GetMapping("/details/{productID}")
	public ResponseEntity<Product> get(@PathVariable UUID productID) {
		return ResponseEntity.status(HttpStatus.OK).body(productRepo.findById(productID).get());
	}
	@PostMapping("/upload")
	public String CreateProduct(@Validated @RequestBody ProductDTO pro, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if (pro != null) {
			pro.setCreatedby(username);
			productService.save(pro);
			return "Thêm Sản Phẩm Mới Thành Công";
		} else {
			return "Thêm Thất Bại, Vui Lòng Kiểm Tra Lại";
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			productService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);	
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody ProductDTO dataUpdate, @PathVariable UUID id, HttpServletRequest request) {
		try {
			Product productEntity = new Product();
			String authorizationHeader = request.getHeader("Authorization");
			String jwt = authorizationHeader.substring(7);
			String username = jwtUtil.extractUsername(jwt);
			Product product = productRepo.findById(id).get();
			product.setModifiedby(username);
			product.setModifieddate(dataUpdate.getModifieddate());
			Author authorEntity = AuthorRepo.findOneByName(dataUpdate.getAuthorName());
			CategoryEntity category = categoryRepo.findOneByName(dataUpdate.getCategory());
			List<CategoryEntity> cateList = new ArrayList<CategoryEntity>();
			cateList.add(category);
			productEntity = convert.toEntity(dataUpdate);
			productEntity.setAuthor(authorEntity);
			productEntity.setCategoryId(cateList);
			//////////////////////////////////////////
			product.setName(productEntity.getName());
			product.setDescription(productEntity.getDescription());
			product.setHot(productEntity.isHot());
			product.setSale(productEntity.isSale());
			product.setRating(productEntity.getRating());
			product.setQuantity(productEntity.getQuantity());
			product.setImageBef(productEntity.getImageBef());
			product.setImageAf(productEntity.getImageAf());
			product.setPriceOld(productEntity.getPriceOld());
			product.setPricePresent(productEntity.getPricePresent());
			product.setDescription(productEntity.getDescription());
			product.setThumbnails(productEntity.getThumbnails());
			product.setCategoryId(productEntity.getCategoryId());
			product.setAuthor(productEntity.getAuthor());
			productRepo.save(product);
			return "true";
		} catch (NoSuchElementException e) {
			return "false";
		}
	}
}
