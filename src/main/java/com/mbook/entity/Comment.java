package com.mbook.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
	
	String content;
	String level;
	String replyTo;
	@ManyToOne
	@JoinColumn(name = "poster_id",referencedColumnName = "id")
	Poster poster;
	
	@ManyToOne
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	Account account;

	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String content, String level, String replyTo, Poster poster, Account account) {
		super();
		this.content = content;
		this.level = level;
		this.replyTo = replyTo;
		this.poster = poster;
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public String getLevel() {
		return level;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public Poster getPoster() {
		return poster;
	}

	public Account getAccount() {
		return account;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}
