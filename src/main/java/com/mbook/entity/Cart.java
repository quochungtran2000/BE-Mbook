package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
	
@Entity
public class Cart extends BaseEntity {

	@Column
	int quantity; 
	@Column 
	Long totalPrice;
	@Column
	boolean checkout;
	@ManyToOne
	@JoinColumn(name = "account_id",referencedColumnName = "id")	
	Account accountCart;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "bill")
	Orders orders;
	
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
	
	
	public Cart(int quantity, Long totalPrice, boolean checkout, Account accountCart, Orders orders,
			List<Product> listProduct) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.checkout = checkout;
		this.accountCart = accountCart;
		this.orders = orders;
		this.listProduct = listProduct;
	}


	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public int getQuantity() {
		return quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
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

	public void setAccountCart(Account accountCart) {
		this.accountCart = accountCart;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}



	public boolean isCheckout() {
		return checkout;
	}
	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}




	

	
}
