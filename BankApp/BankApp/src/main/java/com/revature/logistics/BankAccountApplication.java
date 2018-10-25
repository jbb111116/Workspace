package com.revature.logistics;

import java.io.Serializable;

public class BankAccountApplication implements Serializable {
	private static final long serialVersionUID = 3L;

	int initialDepositAmount;
	protected static final int MIN_CHECKINGS = 50;
	protected static final int MIN_SAVINGS = 200;


	// Basic personal info
	private String firstName, lastName;
	private String password, dateOfBirth;


	// Contact Info
	private long phone;
	private String email;

	// Distinguishing between savings/checking and joint account
	static boolean willBeAJointAccount = false;
	static boolean willBeACheckingAccount;
	static boolean willBeASavingsAccount = !willBeACheckingAccount;
	
	// Single account application constructor
	public BankAccountApplication(int initialDepositAmount, String firstName, String lastName, String password,
			String dateOfBirth, long phone, String email) {
		super();
		this.initialDepositAmount = initialDepositAmount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
	}
	
	

	public String getPassword() {
		return password;
	}




	public int getInitialDepositAmount() {
		return initialDepositAmount;
	}



	public void setInitialDepositAmount(int initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
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



	public static boolean isWillBeAJointAccount() {
		return willBeAJointAccount;
	}



	public static void setWillBeAJointAccount(boolean willBeAJointAccount) {
		BankAccountApplication.willBeAJointAccount = willBeAJointAccount;
	}



	public static boolean isWillBeACheckingAccount() {
		return willBeACheckingAccount;
	}



	public static void setWillBeACheckingAccount(boolean willBeACheckingAccount) {
		BankAccountApplication.willBeACheckingAccount = willBeACheckingAccount;
	}



	public static boolean isWillBeASavingsAccount() {
		return willBeASavingsAccount;
	}



	public static void setWillBeASavingsAccount(boolean willBeASavingsAccount) {
		BankAccountApplication.willBeASavingsAccount = willBeASavingsAccount;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "BankAccountApplication [initialDepositAmount=" + initialDepositAmount + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", phone="
				+ phone + ", email=" + email + "]";
	}

	

}

