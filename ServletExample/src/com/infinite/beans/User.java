package com.infinite.beans;

import java.util.Date;

public class User {
	private String usernmae;
	private String password;
	private Date logindate;
	
	public String getUsernmae() {
		return usernmae;
	}
	public void setUsernmae(String usernmae) {
		this.usernmae = usernmae;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public void display(){
		System.out.println(usernmae+"  "+password);
		System.out.println(logindate);
		
	}
	
	
	

}
