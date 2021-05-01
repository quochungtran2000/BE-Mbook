package com.mbook.dto;

import java.util.Date;

import com.mbook.entity.BaseEntity;

public class PosterDTO extends BaseEntity{
	private String title;
	private String sub;
	private String content;
	private String categoryCode;
	private Date createddate;
	public String getTitle() {
		return title;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	private String urlImage;
}
