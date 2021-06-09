package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "poster")
public class Poster extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "sub")
	private String sub;

	@Column(name = "content")
	private String content;

	@Column(name = "urlImage")
	private String urlImage;

	
//	@JsonIgnore
	@ManyToMany
    @JoinTable(
            name = "listpost_like",
            joinColumns = @JoinColumn(name = "poster_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id",referencedColumnName = "id")
    )
	List<Account> listlike = new ArrayList<Account>();
	
//	@JsonIgnore
	@ManyToMany
    @JoinTable(
            name = "category_enrolled",
            joinColumns = @JoinColumn(name = "poster_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id")
    )
	private List<CategoryEntity> categoryId = new ArrayList<CategoryEntity>();
	

	public List<CategoryEntity> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<CategoryEntity> categoryId) {
		this.categoryId = categoryId;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getTitle() {
		return title;
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

	public List<Account> getListlike() {
		return listlike;
	}

	public void setListlike(List<Account> listlike) {
		this.listlike = listlike;
	}

	

	
}
