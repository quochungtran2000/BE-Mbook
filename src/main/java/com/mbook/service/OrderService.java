package com.mbook.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.OrderConvert;
import com.mbook.dto.OrderDTO;
import com.mbook.entity.Cart;
import com.mbook.entity.Discount;
import com.mbook.entity.Orders;
import com.mbook.repository.CartRepository;
import com.mbook.repository.DiscountRepository;
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
	@Autowired 
	DiscountRepository discountRepo;
	@Override
	public List<Orders> ListAll() {
		return repo.findAll();
	}

	@Override
	public Orders get(UUID id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(UUID id) {
		repo.deleteById(id);
	}	

	@Override
	public Orders save(OrderDTO orderDTO) {
		Orders orderEntity =new Orders();
		Discount discount = new Discount();
		Cart cart = cartRepo.findById( UUID.fromString(orderDTO.getIdCart())).get();
		if(orderDTO.getDiscount() != null) {
			discount = discountRepo.findById(orderDTO.getDiscount()).get();
		}else {
			discount = null;
		}
		orderEntity = convert.toEntity(orderDTO);
		orderEntity.setBill(cart);
		orderEntity.setCodeDiscount(discount);
		return repo.save(orderEntity);
	}
	
	
}
