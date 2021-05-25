package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount extends BaseEntity{
	@Column
	boolean type;
	@Column
	String name;
	@Column
	Long money;
	
	
	@ManyToMany
    @JoinTable(
            name = "DiscountDetails",
            joinColumns = @JoinColumn(name = "orders_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id",referencedColumnName = "id")
    )
	private List<Orders> listDiscount = new ArrayList<Orders>();
	public Discount() {
		super();
	}
	public Discount(boolean type, String name, Long money) {
		super();
		this.type = type;
		this.name = name;
		this.money = money;
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
