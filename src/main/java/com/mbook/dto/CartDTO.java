package com.mbook.dto;

import java.util.Date;

public class CartDTO extends BaseDTO{
	String idProduct;
	int quantity; 
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super(createdby, createddate, modifiedby, modifieddate);
		// TODO Auto-generated constructor stub
	}
	public String getIdProduct() {
		return idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartDTO(String idProduct, int quantity) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	
	
	
}
