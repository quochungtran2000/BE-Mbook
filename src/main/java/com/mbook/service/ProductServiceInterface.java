package com.mbook.service;

import java.util.List;

import com.mbook.dto.ProductDTO;
import com.mbook.entity.Product;

public interface ProductServiceInterface {
	public List<Product> ListAll();
	public Product save(ProductDTO product);
	public Product get(Long id) ;
	public void delete(Long id) ;
}
