package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private int quantity;
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
            joinColumns = @JoinColumn(name = "products_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id",referencedColumnName = "id")
    )
	private List<Product> listProduct = new ArrayList<Product>();
	
	 @JsonIgnore
	 @ManyToMany(mappedBy = "listProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Cart> listCart = new ArrayList<Cart>();

	public Product() {
		super();
	}

	public Product(String name, String imageBef, String imageAf, int quantity, String thumbnails, String description,
			int rating, boolean hot, boolean sale, Long priceOld, Long pricePresent, Author author,
			List<CategoryEntity> categoryId, List<Product> listProduct, List<Cart> listCart) {
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
		this.listProduct = listProduct;
		this.listCart = listCart;
	}

	public String getName() {
		return name;
	}

	public String getImageBef() {
		return imageBef;
	}

	public String getImageAf() {
		return imageAf;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getThumbnails() {
		return thumbnails;
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

	public Author getAuthor() {
		return author;
	}

	public List<CategoryEntity> getCategoryId() {
		return categoryId;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public List<Cart> getListCart() {
		return listCart;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageBef(String imageBef) {
		this.imageBef = imageBef;
	}

	public void setImageAf(String imageAf) {
		this.imageAf = imageAf;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
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

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setCategoryId(List<CategoryEntity> categoryId) {
		this.categoryId = categoryId;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public void setListCart(List<Cart> listCart) {
		this.listCart = listCart;
	}



}