package com.mbook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "modifiedby")
	private String modifiedby;
	
	@Column(name = "modifieddate")
	private Date modifieddate;
	
	
	
	public Long getId() {
		return id;
	}


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public String getModifiedby() {
		return modifiedby;
	}


	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}


	public Date getModifieddate() {
		return modifieddate;
	}


	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
}
