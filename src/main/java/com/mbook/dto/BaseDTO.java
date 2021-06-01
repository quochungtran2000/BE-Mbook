package com.mbook.dto;

import java.util.Date;

public class BaseDTO {
	private String createdby;
	
	private Date createddate;
	
	private String modifiedby;
	
	private Date modifieddate;

	
	public BaseDTO() {
		super();
	}

	public BaseDTO(String createdby, Date createddate, String modifiedby, Date modifieddate) {
		super();
		this.createdby = createdby;
		this.createddate = createddate;
		this.modifiedby = modifiedby;
		this.modifieddate = modifieddate;
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
