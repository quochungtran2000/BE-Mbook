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
import com.mbook.repository.ProductServiceInterface;

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
		return productRepo.save(productEntity);
	} 
	@Override
	public Product get(Long id) {
		return productRepo.getOne(id);
	}

	@Override
	public void delete(Long id) {
		productRepo.deleteById(id);
	}

}
