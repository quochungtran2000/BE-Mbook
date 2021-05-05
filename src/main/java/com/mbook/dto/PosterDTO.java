package com.mbook.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mbook.entity.BaseEntity;

public class PosterDTO extends BaseEntity{
	private String title;
	private String sub;
	private String content;
	private List<String> categoryCode = new ArrayList<String>();
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
	
	public List<String> getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(List<String> categoryCode) {
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
