package com.ckoipapa.com.ckoipapa.web;

public class UserForm {
	
	private String username;
	private String password;
	private String repassword;
	
	
	
	
	public UserForm(String username, String password, String repassword) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
	}
	
	
	
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
}
