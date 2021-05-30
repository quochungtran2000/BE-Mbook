package com.mbook.entity;

import java.util.Date;

public class CartDTO extends BaseDTO{
	Long idProduct;
	int quantity; 
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super(createdby, createddate, modifiedby, modifieddate);
		// TODO Auto-generated constructor stub
	}
	
	public CartDTO(Long idProduct, int quantity) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
