package com.mbook.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "author")
@Entity
public class Author extends BaseEntity{
	@Column
	private String name;
	@Column
	private String age;
	@Column(columnDefinition="TEXT")
	private String slogan;
	@Column
	private String image;
	@Column(columnDefinition="TEXT")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author")
	List<Product> productList;

	public Author() {
		super();
	}

	public Author(String name, String age, String slogan, String image, String description, List<Product> productList) {
		super();
		this.name = name;
		this.age = age;
		this.slogan = slogan;
		this.image = image;
		this.description = description;
		this.productList = productList;
	}


	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getSlogan() {
		return slogan;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}