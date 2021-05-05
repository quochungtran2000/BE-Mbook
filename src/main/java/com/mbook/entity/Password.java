package com.mbook.entity;

public class Password {
	private String passwordOld;
	private String passwordNew;
	private String repeatpasswordNew;
	
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Password(String passwordOld, String passwordNew, String repeatpasswordNew) {
		super();
		this.passwordOld = passwordOld;
		this.passwordNew = passwordNew;
		this.repeatpasswordNew = repeatpasswordNew;
	}
	
	
	public String getPasswordOld() {
		return passwordOld;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public String getRepeatpasswordNew() {
		return repeatpasswordNew;
	}
	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public void setRepeatpasswordNew(String repeatpasswordNew) {
		this.repeatpasswordNew = repeatpasswordNew;
	}
	
	
	
}
