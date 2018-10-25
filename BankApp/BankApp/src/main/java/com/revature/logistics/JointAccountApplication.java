package com.revature.logistics;

import java.io.Serializable;

public class JointAccountApplication implements Serializable{
	private static final long serialVersionUID = 3L;

	private int initialDepositAmount;
	protected static final int MIN_CHECKINGS = 50;
	protected static final int MIN_SAVINGS = 200;

	// Basic personal info
	private String firstName, lastName; 
	private String password, dateOfBirth;

	
	// Contact Info
	private int phone;
	private String email;

	static boolean willBeAJointAccount = true;
	static boolean willBeACheckingAccount;
	static boolean willBeASavingsAccount = !willBeACheckingAccount;


	// Basic personal info
	private String firstName2, lastName2; 
	private String password2, dateOfBirth2;


	// Contact Info
	private String email2;
	private int phone2;
	
	// Joint account application constructor
	public JointAccountApplication(int initialDepositAmount, String firstName, String lastName, String password,
			String dateOfBirth, String address, String city, String state, int zip, int phone, String email,
			String firstName2, String lastName2, String password2, String dateOfBirth2, String address2, String city2,
			String state2, int zip2, int phone2, String email2) {
		super();
		this.initialDepositAmount = initialDepositAmount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.firstName2 = firstName2;
		this.lastName2 = lastName2;
		this.password2 = password2;
		this.dateOfBirth2 = dateOfBirth2;
		this.phone2 = phone2;
		this.email2 = email2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean isWillBeAJointAccount() {
		return willBeAJointAccount;
	}

	public static void setWillBeAJointAccount(boolean willBeAJointAccount) {
		JointAccountApplication.willBeAJointAccount = willBeAJointAccount;
	}

	public static boolean isWillBeACheckingAccount() {
		return willBeACheckingAccount;
	}

	public static void setWillBeACheckingAccount(boolean willBeACheckingAccount) {
		JointAccountApplication.willBeACheckingAccount = willBeACheckingAccount;
	}

	public static boolean isWillBeASavingsAccount() {
		return willBeASavingsAccount;
	}

	public static void setWillBeASavingsAccount(boolean willBeASavingsAccount) {
		JointAccountApplication.willBeASavingsAccount = willBeASavingsAccount;
	}

	public String getFirstName2() {
		return firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	public String getDateOfBirth2() {
		return dateOfBirth2;
	}

	public void setDateOfBirth2(String dateOfBirth2) {
		this.dateOfBirth2 = dateOfBirth2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public int getInitialDepositAmount() {
		return initialDepositAmount;
	}

	public void setInitialDepositAmount(int initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}

	
}
