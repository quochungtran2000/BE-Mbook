package com.mbook.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column
	private String slogan;
	@Column
	private String image;
	@Column
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author", fetch=FetchType.EAGER)
	List<Product> product;

	public Author() {
		super();
	}

	public Author(String name, String age, String slogan, String image, String description, List<Product> product) {
		super();
		this.name = name;
		this.age = age;
		this.slogan = slogan;
		this.image = image;
		this.description = description;
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
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