package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
	
@Entity
public class Cart extends BaseEntity {

	@Column
	int quantity; 
	@Column 
	Long totalPrice;
	@Column 
	Long price;
	
	@ManyToOne
	@JoinColumn(name = "account_id",referencedColumnName = "id")	
	Account accountCart;
	
	@ManyToMany
    @JoinTable(
            name = "DetailsCart",
            joinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id",referencedColumnName = "id")
    )
	private List<Product> listProduct = new ArrayList<Product>();
	
	public Cart() {
		super();
	}

	public Cart(int quantity, Long totalPrice, Long price, Account accountCart, List<Product> listProduct) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.price = price;
		this.accountCart = accountCart;
		this.listProduct = listProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public Long getPrice() {
		return price;
	}

	public Account getAccountCart() {
		return accountCart;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setAccountCart(Account accountCart) {
		this.accountCart = accountCart;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}




	

	
}
