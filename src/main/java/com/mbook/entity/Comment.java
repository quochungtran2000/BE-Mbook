package com.mbook.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
	
	String noidung;

	@ManyToOne
	@JoinColumn(name = "poster_id",referencedColumnName = "id")
	Poster poster;
	
	@ManyToOne
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	Account account;
	
	
	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	
	
}
