package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {
	private String username;
	private String password;
	private String fullname;
	private boolean status;
	private boolean roleid;
	private String token;
	
	@ManyToMany(mappedBy = "listlike", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Poster> postlike = new ArrayList<Poster>();
	@JsonIgnore
	@OneToMany(mappedBy = "accountCart")
	List<Cart> cart;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String username, String password, String fullname, boolean status, boolean roleid, String token,
			List<Poster> postlike, List<Cart> cart) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.status = status;
		this.roleid = roleid;
		this.token = token;
		this.postlike = postlike;
		this.cart = cart;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullname;
	}
	public boolean isStatus() {
		return status;
	}
	public boolean isRoleid() {
		return roleid;
	}
	public String getToken() {
		return token;
	}
	public List<Poster> getPostlike() {
		return postlike;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setRoleid(boolean roleid) {
		this.roleid = roleid;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setPostlike(List<Poster> postlike) {
		this.postlike = postlike;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}


	
}
