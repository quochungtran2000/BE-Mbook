package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.entity.Account;
import com.mbook.entity.Cart;
import com.mbook.entity.CartDTO;
import com.mbook.entity.Product;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.CartRepository;
import com.mbook.repository.CartServiceInterface;
import com.mbook.repository.ProductRepository;


@Service
public class CartService implements CartServiceInterface {

	@Autowired
	CartRepository repo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	AccountRepository accountRepo;
	@Override
	public List<Cart> ListAll() {
		return repo.findAll();
	}
	@Override
	public void save(CartDTO cartDTO) {
		Cart cartEntity = new Cart();
		List<Cart> listCart = repo.findAll();
		boolean check = false;
		for (Cart cart : listCart) {
			System.out.println("index" + cart.getListProduct().indexOf(cartDTO.getIdProduct()));
			if(cart.getAccountCart().getUsername().equalsIgnoreCase(cartDTO.getCreatedby())
			&& cart.getListProduct().indexOf(cartDTO.getIdProduct()) != -1){
				//Tìm id product chưa đúng 
				check = true;
				cartEntity = cart;
			}else {
				
			}
		}
		if(check == true) {
			cartEntity.setQuantity(cartEntity.getQuantity() + 1);
			cartEntity.setTotalPrice(cartEntity.getPrice() * cartEntity.getQuantity());
			
		}else {
			Product productEntity = productRepo.findById(cartDTO.getIdProduct()).get();
			Account accountEntity = accountRepo.findOneByUsername(cartDTO.getCreatedby());
			cartEntity.setCreatedby(cartDTO.getCreatedby());
			cartEntity.setAccountCart(accountEntity);
			cartEntity.getListProduct().add(productEntity);
			cartEntity.setPrice(cartDTO.getPrice());
			cartEntity.setQuantity(cartDTO.getQuantity());
			cartEntity.setTotalPrice(cartDTO.getPrice() * cartDTO.getQuantity());
		}
		repo.save(cartEntity);	
	}

	@Override
	public Cart get(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);	
	}
	
	
}
