package com.mbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {
	@Column
	String address;
	@Column
	String fullname;
	@Column
	String methodPay;
	@Column
	String numberPhone;
	@Column
	Long total;
	@Column
	Long totalMoneyProduct;
	@Column
	int quantity;
	@Column
	int ship;

	@OneToOne
	@JoinColumn(name = "cart_id",referencedColumnName = "id")	
	Cart bill;
	
	@ManyToOne
	@JoinColumn(name = "discount_id",referencedColumnName = "id")
	Discount codeDiscount;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String address, String fullname, String methodPay, String numberPhone, Long total,
			Long totalMoneyProduct, int quantity, int ship, Cart bill, Discount codeDiscount) {
		super();
		this.address = address;
		this.fullname = fullname;
		this.methodPay = methodPay;
		this.numberPhone = numberPhone;
		this.total = total;
		this.totalMoneyProduct = totalMoneyProduct;
		this.quantity = quantity;
		this.ship = ship;
		this.bill = bill;
		this.codeDiscount = codeDiscount;
	}

	public String getAddress() {
		return address;
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

	public Cart getBill() {
		return bill;
	}

	public Discount getCodeDiscount() {
		return codeDiscount;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setBill(Cart bill) {
		this.bill = bill;
	}

	public void setCodeDiscount(Discount codeDiscount) {
		this.codeDiscount = codeDiscount;
	}

	
	
}
