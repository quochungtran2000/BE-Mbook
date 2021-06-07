package com.mbook.dto;

import java.util.Date;
import java.util.UUID;

public class OrderDTO extends BaseDTO{
	String address;
	UUID discount;
	String fullname;
	String methodPay;
	String numberPhone;
	String idCart;
	Long total;
	Long totalMoneyProduct;
	int quantity;
	int ship;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super(createdby, createddate, modifiedby, modifieddate);
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(String address, UUID discount, String fullname, String methodPay, String numberPhone,
			String idCart, Long total, Long totalMoneyProduct, int quantity, int ship) {
		super();
		this.address = address;
		this.discount = discount;
		this.fullname = fullname;
		this.methodPay = methodPay;
		this.numberPhone = numberPhone;
		this.idCart = idCart;
		this.total = total;
		this.totalMoneyProduct = totalMoneyProduct;
		this.quantity = quantity;
		this.ship = ship;
	}
	public String getAddress() {
		return address;
	}
	public UUID getDiscount() {
		return discount;
	}
	public String getFullname() {
		return fullname;
	}
	public String getMethodPay() {
		return methodPay;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public String getIdCart() {
		return idCart;
	}
	public Long getTotal() {
		return total;
	}
	public Long getTotalMoneyProduct() {
		return totalMoneyProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getShip() {
		return ship;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDiscount(UUID discount) {
		this.discount = discount;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setMethodPay(String methodPay) {
		this.methodPay = methodPay;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public void setTotalMoneyProduct(Long totalMoneyProduct) {
		this.totalMoneyProduct = totalMoneyProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setShip(int ship) {
		this.ship = ship;
	}

	
	
	
}
