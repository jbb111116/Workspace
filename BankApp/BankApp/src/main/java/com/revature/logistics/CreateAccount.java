package com.revature.logistics;

import java.io.Serializable;

public class CreateAccount implements Serializable {
	private static final long serialVersionUID = 3L;
	
	private String firstName, lastName, email;
	
	private long phone;
	
	private String userName, password, passwordTest;
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordTest() {
		return passwordTest;
	}


	public void setPasswordTest(String passwordTest) {
		this.passwordTest = passwordTest;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getUserName() {
		return userName;
	}
	


	@Override
	public String toString() {
		return "CreateAccount [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", userName=" + userName + ", password=" + password + ", passwordTest=" + passwordTest + "]";
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	// New account constructor
	public CreateAccount(String firstName, String lastName, String email, long phone, String userName, String password,
			String passwordTest) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.passwordTest = passwordTest;
	}
	
	
	

}


