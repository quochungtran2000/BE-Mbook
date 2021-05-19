package com.mbook.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {


	@Column(name = "name")
	private String name;

	 @JsonIgnore
	 @ManyToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Poster> posts = new ArrayList<Poster>();
	 
	 @JsonIgnore
	 @ManyToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Product> products = new ArrayList<Product>();
	 
	public List<Poster> getPosts() {
		return posts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setPosts(List<Poster> posts) {
		this.posts = posts;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}