package com.mbook.repository;

import java.util.List;

import com.mbook.entity.Cart;
import com.mbook.entity.CartDTO;
import com.mbook.entity.OrderDTO;
import com.mbook.entity.Orders;

public interface OrderServiceInterface {
	public List<Orders> ListAll();
	public Orders get(Long id) ;
	public void delete(Long id) ;
	public Orders save(OrderDTO order);
//	List<Cart> getListByUser(Long id);
}
