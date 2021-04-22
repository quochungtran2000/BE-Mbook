package com.mbook.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "poster")
public class Poster extends BaseEntity {

	private String title;

	private String category;

	private String sub;
	
	private String content;

	private String url;

	public Poster() {
	}

	public Poster(String title, String category, String sub, String content, String url) {
		super();
		this.title = title;
		this.category = category;
		this.sub = sub;
		this.content = content;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
