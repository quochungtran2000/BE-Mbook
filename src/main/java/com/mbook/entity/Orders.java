package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@JsonIgnore
	@ManyToMany(mappedBy = "listProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> productOrders = new ArrayList<Product>();

	@JsonIgnore
	@ManyToMany(mappedBy = "listDiscount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Discount> discountOrders = new ArrayList<Discount>();

	@ManyToOne
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	Account orders;
}
