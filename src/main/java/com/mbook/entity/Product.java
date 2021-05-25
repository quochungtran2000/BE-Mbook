package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	
	@Column
	private String name;
	@Column
	private String imageBef;
	@Column
	private String imageAf;
	@Column
	private String quantity;
	@Column
	private String thumbnails;
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
	
	@ManyToMany
    @JoinTable(
            name = "category_product",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id")
    )
	private List<CategoryEntity> categoryId = new ArrayList<CategoryEntity>();
	@ManyToMany
    @JoinTable(
            name = "DetailsOrders",
            joinColumns = @JoinColumn(name = "orders_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id")
    )
	private List<Product> listProduct = new ArrayList<Product>();
	public Product() {
		super();
	}


	public List<CategoryEntity> getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(List<CategoryEntity> categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public Author getAuthor() {
		return author;
	}


	public Product(String name, String imageBef, String imageAf, String quantity, String thumbnails, String description,
			int rating, boolean hot, boolean sale, Long priceOld, Long pricePresent, Author author,
			List<CategoryEntity> categoryId) {
		super();
		this.name = name;
		this.imageBef = imageBef;
		this.imageAf = imageAf;
		this.quantity = quantity;
		this.thumbnails = thumbnails;
		this.description = description;
		this.rating = rating;
		this.hot = hot;
		this.sale = sale;
		this.priceOld = priceOld;
		this.pricePresent = pricePresent;
		this.author = author;
		this.categoryId = categoryId;
	}


	public String getImageBef() {
		return imageBef;
	}


	public String getImageAf() {
		return imageAf;
	}


	public String getThumbnails() {
		return thumbnails;
	}


	public void setImageBef(String imageBef) {
		this.imageBef = imageBef;
	}


	public void setImageAf(String imageAf) {
		this.imageAf = imageAf;
	}


	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}


	public void setAuthor(Author author) {
		this.author = author;
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