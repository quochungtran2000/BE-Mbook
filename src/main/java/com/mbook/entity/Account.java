package com.mbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {
	private String username;
	private String password;
	private String fullname;
	private int status;
	private Long roleid;
	private String token;

	@JsonIgnore
	@ManyToMany(mappedBy = "listlike", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Poster> postlike = new ArrayList<Poster>();


	public List<Poster> getPostlike() {
		return postlike;
	}

	public void setPostlike(List<Poster> postlike) {
		this.postlike = postlike;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

}
