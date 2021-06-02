package com.mbook.dto;

import java.util.Date;
import java.util.UUID;

public class CartDTO extends BaseDTO{
	UUID idProduct;
	int quantity; 
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super(createdby, createddate, modifiedby, modifieddate);
		// TODO Auto-generated constructor stub
	}
	public CartDTO(UUID idProduct, int quantity) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	public UUID getIdProduct() {
		return idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setIdProduct(UUID idProduct) {
		this.idProduct = idProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
