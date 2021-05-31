package com.mbook.repository;

import java.util.List;
import java.util.UUID;

import com.mbook.dto.ProductDTO;
import com.mbook.entity.Product;

public interface ProductServiceInterface {
	public List<Product> ListAll();
	public Product save(ProductDTO product);
	public Product get(UUID id) ;
	public void delete(UUID id) ;
}
