package com.mbook.repository;

import java.util.List;

import com.mbook.entity.Cart;
import com.mbook.entity.CartDTO;

public interface CartServiceInterface {
	public List<Cart> ListAll();
	public Cart get(Long id) ;
	public void delete(Long id) ;
	void save(CartDTO acc);
//	List<Cart> getListByUser(Long id);
}
