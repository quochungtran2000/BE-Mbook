package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.ProductConvert;
import com.mbook.dto.ProductDTO;
import com.mbook.entity.Author;
import com.mbook.entity.Product;
import com.mbook.repository.AuthorRepository;
import com.mbook.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	AuthorRepository AuthorRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProductConvert convert;

	@Override
	public List<Product> ListAll() {
		return null;
	}


	@Override
	public Product save(ProductDTO productdto) {
		Product productEntity =new Product();
		Author authorEntity = AuthorRepo.getOne(productdto.getAuthorId());
		productEntity = convert.toEntity(productdto);
		productEntity.setAuthor(authorEntity);
		return productRepo.save(productEntity);
	} 
	
	@Override
	public Product get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
