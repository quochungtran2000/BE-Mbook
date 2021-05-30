package com.mbook.convert;

import org.springframework.stereotype.Component;

import com.mbook.entity.OrderDTO;
import com.mbook.entity.Orders;
@Component
public class OrderConvert {
	public OrderDTO toDTO(Orders orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setAddress(orderEntity.getAddress());
		orderDTO.setFullname(orderEntity.getFullname());
		orderDTO.setNumberPhone(orderEntity.getNumberPhone());
		orderDTO.setDiscount(orderEntity.getDiscount());
		orderDTO.setMethodPay(orderEntity.getMethodPay());
		orderDTO.setQuantity(orderEntity.getQuantity());
		orderDTO.setShip(orderEntity.getShip());
		orderDTO.setTotal(orderEntity.getTotal());
		orderDTO.setTotalMoneyProduct(orderEntity.getTotalMoneyProduct());
		return orderDTO;
	}
	public Orders toEntity(OrderDTO orderDTO) {
		Orders orderEntity = new Orders();
		orderEntity.setAddress(orderDTO.getAddress());
		orderEntity.setFullname(orderDTO.getFullname());
		orderEntity.setNumberPhone(orderDTO.getNumberPhone());
		orderEntity.setDiscount(orderDTO.getDiscount());
		orderEntity.setMethodPay(orderDTO.getMethodPay());
		orderEntity.setQuantity(orderDTO.getQuantity());
		orderEntity.setShip(orderDTO.getShip());
		orderEntity.setTotal(orderDTO.getTotal());
		orderEntity.setTotalMoneyProduct(orderDTO.getTotalMoneyProduct());
		return orderEntity;
	}
}
