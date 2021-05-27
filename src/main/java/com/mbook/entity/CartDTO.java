package com.mbook.entity;

import java.util.Date;

public class CartDTO extends BaseDTO{
	Long idProduct;
	int quantity; 
	Long price;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super(createdby, createddate, modifiedby, modifieddate);
		// TODO Auto-generated constructor stub
	}
	public CartDTO(Long idProduct, int quantity, Long price) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
