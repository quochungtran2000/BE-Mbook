package com.mbook.dto;

import com.mbook.entity.BaseDTO;

public class ProductDTO extends BaseDTO{
	
	private String name;
	private String imageBef;
	private String imageAf;
	private int quantity;
	private String description;
	private String thumbnails;
	private int rating;
	private boolean hot;
	private boolean sale;
	private Long priceOld;
	private Long pricePresent;
	private String authorName;
	private String category;
	public ProductDTO() {
		super();
	}
	public ProductDTO(String name, String imageBef, String imageAf, int quantity, String description, String thumbnails,
			int rating, boolean hot, boolean sale, Long priceOld, Long pricePresent, String authorName,
			String category) {
		super();
		this.name = name;
		this.imageBef = imageBef;
		this.imageAf = imageAf;
		this.quantity = quantity;
		this.description = description;
		this.thumbnails = thumbnails;
		this.rating = rating;
		this.hot = hot;
		this.sale = sale;
		this.priceOld = priceOld;
		this.pricePresent = pricePresent;
		this.authorName = authorName;
		this.category = category;
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
	public String getDescription() {
		return description;
	}
	public String getThumbnails() {
		return thumbnails;
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
	public String getAuthorName() {
		return authorName;
	}
	public String getCategory() {
		return category;
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
	public void setDescription(String description) {
		this.description = description;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
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
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
