package com.mbook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.dto.CartDTO;
import com.mbook.entity.Account;
import com.mbook.entity.Author;
import com.mbook.entity.Cart;
import com.mbook.entity.Orders;
import com.mbook.entity.Product;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.AuthorRepository;
import com.mbook.repository.CartRepository;
import com.mbook.repository.OrderRepository;
import com.mbook.repository.ProductRepository;
import com.mbook.service.CartService;
import com.mbook.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	AccountRepository accountRepo;
	@Autowired
	ProductRepository proRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	CartRepository repo;
	@Autowired
	CartService service;
	@Autowired
	AuthorRepository AuthorRepo;
	@Autowired
	private JwtUtil jwtUtil;
	@GetMapping("/get")
	public List<Cart> getCartByUserName(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		Account acc = accountRepo.findOneByUsername(username);
		List<Cart> listAll = repo.findAll();
		List<Cart> cart = new ArrayList<Cart>();
		for (Cart item : listAll) {
			if(item.getAccountCart().getId() == acc.getId()) {
				cart.add(item);
			}
		}		
		return cart;
	}
	@PostMapping("/upload")
	public String CreateProduct(@Validated @RequestBody CartDTO cart, HttpServletRequest request) {
		
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if (cart != null) {
			cart.setCreatedby(username);
			System.out.println("username : " + username	);
			service.save(cart);
			return "Thêm Sản Phẩm Mới Thành Công";
		} else {
			return "Thêm Thất Bại, Vui Lòng Kiểm Tra Lại";
		}

	}
	@PutMapping("/update/{id}")
	public String updateQuantity(@PathVariable UUID id,
			@Validated	@RequestBody String quantity, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		boolean status = false;
		List<Cart> listCart = service.ListAll();
		Product pro = proRepo.findById(id).get();
		for (Cart cart : listCart) {
			int index =  cart.getListProduct().indexOf(pro);
			if(cart.getAccountCart().getUsername().equalsIgnoreCase(username) && cart.isCheckout() == false
			&& cart.getListProduct().indexOf(pro) != -1){
				cart.setQuantity(cart.getQuantity() + Integer.parseInt(quantity));
				cart.getListProduct().get(index).setQuantity(cart.getListProduct().get(index).getQuantity() + Integer.parseInt(quantity));
				long total= 0;
				for (Product product : cart.getListProduct()) {
					if(product.getPricePresent() != null) {
						total += product.getPricePresent() *  product.getQuantity();
					}else {
						total += product.getPriceOld() *  product.getQuantity();
					}
				}
				cart.setTotalPrice(total);
				cart.setModifiedby(username);	
				repo.save(cart);
				status = true;
			}else {
				status = false;
			}
		}
		if (status == true) {
			return "Thêm Sản Phẩm Thành Công";
		} else {
			return "Thêm Sản Phẩm Thất Bại";
		}
	}
	@PutMapping("/checkout/{idCart}/{idOrder}")
	public String checkout(@PathVariable UUID idCart,@PathVariable UUID idOrder) {
		if (idOrder != null) {
			System.out.println("id orders : " + idOrder);
			Cart cart = repo.findById(idCart).get();
			Orders order = orderRepo.findById(idOrder).get();
			cart.setOrders(order);
			cart.setCheckout(true);
			repo.save(cart);
			return "Checkout Thành Công";
		} else {
			return "Checkout Thất Bại";
		}
	}
	@PostMapping("/delete/products/{id}")
	public String delete(@PathVariable UUID id,HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		try {
			service.deleteItem(id,username);
			return "Xóa Sản Phẩm Thành Công";
		} catch (NoSuchElementException e) {
			return "Xóa Sản Phẩm Thất Baị";
		}
	}
}
