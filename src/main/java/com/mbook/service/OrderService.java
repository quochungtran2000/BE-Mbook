package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.OrderConvert;
import com.mbook.entity.Cart;
import com.mbook.entity.OrderDTO;
import com.mbook.entity.Orders;
import com.mbook.repository.CartRepository;
import com.mbook.repository.OrderRepository;
import com.mbook.repository.OrderServiceInterface;

@Service
public class OrderService implements OrderServiceInterface{
	
	@Autowired
	OrderRepository repo;
	@Autowired 
	OrderConvert convert;
	@Autowired 
	CartRepository cartRepo;
	@Override
	public List<Orders> ListAll() {
		return repo.findAll();
	}

	@Override
	public Orders get(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}	

	@Override
	public Orders save(OrderDTO orderDTO) {
		Orders orderEntity =new Orders();
		Cart cart = cartRepo.findById(orderDTO.getIdCart()).get();
		orderEntity = convert.toEntity(orderDTO);
		orderEntity.setBill(cart);
		return repo.save(orderEntity);
	}
	
	
}
