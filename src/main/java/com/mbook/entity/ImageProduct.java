package com.mbook.entity;

public class ImageProduct {
	private String imageBefore;
	private String imageAfter;
	public String getImageBefore() {
		return imageBefore;
	}
	public String getImageAfter() {
		return imageAfter;
	}
	public void setImageBefore(String imageBefore) {
		this.imageBefore = imageBefore;
	}
	public void setImageAfter(String imageAfter) {
		this.imageAfter = imageAfter;
	}
	public ImageProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageProduct(String imageBefore, String imageAfter) {
		super();
		this.imageBefore = imageBefore;
		this.imageAfter = imageAfter;
	}
	
	
	
}
