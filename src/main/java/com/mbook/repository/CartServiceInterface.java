package com.mbook.repository;

import java.util.List;
import java.util.UUID;

import com.mbook.dto.CartDTO;
import com.mbook.entity.Cart;

public interface CartServiceInterface {
	public List<Cart> ListAll();
	public Cart get(UUID id) ;
	public void delete(UUID id) ;
	public Cart save(CartDTO acc);
	void deleteItem(UUID id,String username);
}
