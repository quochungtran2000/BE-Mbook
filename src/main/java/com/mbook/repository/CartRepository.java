package com.mbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	
	
}
