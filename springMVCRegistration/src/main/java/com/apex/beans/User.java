package com.apex.beans;

import jakarta.validation.constraints.NotBlank;

public class User {

	@NotBlank(message="FirstName cannot be blank")
	private String firstName;
	
	@NotBlank(message="LastName cannot be blank")
	private String lastName;
	
	@NotBlank(message="userName cannot be blank")
	private String userName;
	
	
	@NotBlank(message="valid password is required")
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
