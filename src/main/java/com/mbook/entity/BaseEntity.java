package com.mbook.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;


@MappedSuperclass
public class BaseEntity {
	@Id
    @GeneratedValue(generator = "UUID")
	@Column(name = "id", columnDefinition = "BINARY(16)")
    @GenericGenerator( name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "modifiedby")
	private String modifiedby;
	
	@Column(name = "modifieddate")
	private Date modifieddate;

	public UUID getId() {
		return id;
	}

	public String getCreatedby() {
		return createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	
	
	
	
	
}
