package com.mbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	
	@Column
	private String name;
	@Column
	private String image;
	@Column
	private String imageDetail;
	@Column
	private String quantity;
	@Column
	private String description;
	@Column
	private int rating;
	@Column
	private boolean hot;
	@Column
	private boolean sale;
	@Column
	private Long priceOld;
	@Column
	private Long pricePresent;
	
	
	@ManyToOne
	@JoinColumn(name = "author_id",referencedColumnName = "id")
	Author author;
	public Product() {
		super();
	}

	public Product(String name, String image, String imageDetail, String quantity, String description, int rating,
			boolean hot, boolean sale, Long priceOld, Long pricePresent, Author author) {
		super();
		this.name = name;
		this.image = image;
		this.imageDetail = imageDetail;
		this.quantity = quantity;
		this.description = description;
		this.rating = rating;
		this.hot = hot;
		this.sale = sale;
		this.priceOld = priceOld;
		this.pricePresent = pricePresent;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageDetail() {
		return imageDetail;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	public int getRating() {
		return rating;
	}
	
	public boolean isHot() {
		return hot;
	}
	public boolean isSale() {
		return sale;
	}
	public Long getPriceOld() {
		return priceOld;
	}
	public Long getPricePresent() {
		return pricePresent;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}
	public void setPriceOld(Long priceOld) {
		this.priceOld = priceOld;
	}
	public void setPricePresent(Long pricePresent) {
		this.pricePresent = pricePresent;
	}
}