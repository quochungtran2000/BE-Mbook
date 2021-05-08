package com.mbook.dto;

public class ProductDTO {
	
	private String name;
	private String image;
	private String imageDetail;
	private String quantity;
	private String description;
	private int rating;
	private boolean hot;
	private boolean sale;
	private Long priceOld;
	private Long pricePresent;
	private Long authorId;
	private String createdBy;
	public ProductDTO() {
		super();
	}
	public ProductDTO(String name, String image, String imageDetail, String quantity, String description, int rating,
			boolean hot, boolean sale, Long priceOld, Long pricePresent, Long authorId, String createdBy) {
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
		this.authorId = authorId;
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}
	public String getImage() {
		return image;
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
	public Long getAuthorId() {
		return authorId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImage(String image) {
		this.image = image;
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
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	
}
