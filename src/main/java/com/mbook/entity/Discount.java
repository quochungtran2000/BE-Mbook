package com.mbook.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discount")
public class Discount extends BaseEntity{
	@Column
	boolean type;
	@Column
	String name;
	@Column
	Long money;
	
	@JsonIgnore
	@OneToMany(mappedBy = "codeDiscount")
	List<Orders> idOrders;
	
	public Discount(boolean type, String name, Long money, List<Orders> idOrders) {
		super();
		this.type = type;
		this.name = name;
		this.money = money;
		this.idOrders = idOrders;
	}
	public List<Orders> getIdOrders() {
		return idOrders;
	}
	public void setIdOrders(List<Orders> idOrders) {
		this.idOrders = idOrders;
	}
	public Discount() {
		super();
	}
	public boolean isType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public Long getMoney() {
		return money;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	
	
}
