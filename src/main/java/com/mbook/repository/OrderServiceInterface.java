package com.mbook.repository;

import java.util.List;
import java.util.UUID;

import com.mbook.dto.OrderDTO;
import com.mbook.entity.Orders;

public interface OrderServiceInterface {
	public List<Orders> ListAll();
	public Orders get(UUID id) ;
	public void delete(UUID id) ;
	public Orders save(OrderDTO order);
//	List<Cart> getListByUser(Long id);
}
