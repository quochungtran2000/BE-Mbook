package com.mbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mbook.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
