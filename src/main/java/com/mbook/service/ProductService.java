package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.ProductConvert;
import com.mbook.dto.ProductDTO;
import com.mbook.entity.Author;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Product;
import com.mbook.repository.AuthorRepository;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	AuthorRepository AuthorRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	ProductConvert convert;

	@Override
	public List<Product> ListAll() {
		return null;
	}


	@Override
	public Product save(ProductDTO productdto) {
		Product productEntity =new Product();
		Author authorEntity = AuthorRepo.findOneByName(productdto.getAuthorName());
		CategoryEntity category = categoryRepo.findOneByName(productdto.getCategory());
		productEntity = convert.toEntity(productdto);
		productEntity.setAuthor(authorEntity);
		productEntity.getCategoryId().add(category);
		System.out.println("product name : " + productEntity.getName());
		System.out.println("author name : " + productEntity.getAuthor().getName());
		System.out.println("category name : " + productEntity.getCategoryId());
		return productRepo.save(productEntity);
//		return null;
	} 
	
	@Override
	public Product get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		productRepo.deleteById(id);
	}

}
