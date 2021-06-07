package com.mbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.dto.CartDTO;
import com.mbook.entity.Account;
import com.mbook.entity.Author;
import com.mbook.entity.Cart;
import com.mbook.entity.Product;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.AuthorRepository;
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
	@Autowired
	AuthorRepository AuthorRepo;
	@Override
	public List<Cart> ListAll() {
		return repo.findAll();
	}
	@Override
	@Transactional
	public Cart save(CartDTO cartDTO) {
		Product p = productRepo.findById(cartDTO.getIdProduct()).get();
		Cart cartEntity = new Cart();
		List<Cart> listCart = repo.findAll();
		boolean checkCart = false;
		boolean checkOut = false;
		int checkProduct = -1; 
		if(listCart != null) {
			for (Cart cart : listCart) {
				//Kiểm tra sản phẩm có nằm trong giỏ hàng của account
				if(cart.getAccountCart().getUsername().equalsIgnoreCase(cartDTO.getCreatedby())){
					checkCart = true;
					cartEntity = cart;
					//Product isExist
					checkProduct = cart.getListProduct().indexOf(p);
					if(cart.isCheckout() == false) {
						checkOut = false;
					}else {
						checkOut = true;
					}
				}
			}	
		}
		//Handle Cart with status
		if(checkCart == true) {
			if(checkOut == true) {
				cartEntity = new Cart();
				Product productEntity = p;
				productEntity.setQuantity(cartDTO.getQuantity());
				Account accountEntity = accountRepo.findOneByUsername(cartDTO.getCreatedby());
				cartEntity.setCreatedby(cartDTO.getCreatedby());
				cartEntity.setAccountCart(accountEntity);
				cartEntity.getListProduct().add(productEntity);
				cartEntity.setQuantity(cartDTO.getQuantity());
			}else {
				Product productEntity = p;
				if(checkProduct != -1) {
					cartEntity.getListProduct().get(checkProduct).setQuantity(
							cartEntity.getListProduct().get(checkProduct).getQuantity()+ cartDTO.getQuantity());
				}else {
					productEntity.setQuantity(cartDTO.getQuantity());
					cartEntity.getListProduct().add(productEntity);
				}
				cartEntity.setQuantity(cartEntity.getQuantity() + cartDTO.getQuantity());
			}
			
		}else {
			Product productEntity = productRepo.findById(cartDTO.getIdProduct()).get();
			productEntity.setQuantity(cartDTO.getQuantity());
			List<Product> newList = new ArrayList<Product>();
			newList.add(productEntity);	
			Account accountEntity = accountRepo.findOneByUsername(cartDTO.getCreatedby());
			cartEntity.setCreatedby(cartDTO.getCreatedby());
			cartEntity.setAccountCart(accountEntity);
			cartEntity.setListProduct(newList);;
			cartEntity.setQuantity(cartDTO.getQuantity());
			cartEntity.setCheckout(false);
		}
		long total= 0;
		for (Product product : cartEntity.getListProduct()) {
			if(product.getPricePresent() != null) {
				total += product.getPricePresent() *  product.getQuantity();
			}else {
				total += product.getPriceOld() *  product.getQuantity();
			}
		}
		cartEntity.setTotalPrice(total);
		return repo.save(cartEntity);	
	}

	@Override
	public Cart get(UUID id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(UUID id) {
		repo.deleteById(id);	
	}
	public void deleteItem(UUID id, String username) {
		Cart cartEntity = new Cart();
		List<Cart> listCart = repo.findAll();
		boolean checkCart = false;
		int checkProduct = -1;
		for (Cart cart : listCart) {	
			//Kiểm tra sản phẩm có nằm trong giỏ hàng của account
			if(cart.getAccountCart().getUsername().equalsIgnoreCase(username)){
				checkCart = true;
				cartEntity = cart;
				//Product isExist
				
				checkProduct = cart.getListProduct().indexOf(productRepo.findById(id).get());
				
			}
		}
		if(checkCart == true) {
			Product productEntity = productRepo.findById(id).get();
			if(checkProduct != -1) {
				if(cartEntity.getQuantity() > 0) {
					cartEntity.setQuantity(cartEntity.getQuantity() - productEntity.getQuantity());
					cartEntity.getListProduct().remove(checkProduct);
				}
				
			}
			long total= 0;
			for (Product product : cartEntity.getListProduct()) {
				if(product.getPricePresent() != null) {
					total += product.getPricePresent() *  product.getQuantity();
				}else {
					total += product.getPriceOld() *  product.getQuantity();
				}
			}
			cartEntity.setTotalPrice(total);
		}
		repo.save(cartEntity);
	}
	
}
