package com.revature.logistics;

import java.io.Serializable;
import java.util.Date;


public class LoanApplication implements Serializable {
	private static final long serialVersionUID = 3L;

	// Basic personal info
	private String firstName,lastName; 
	private String dateOfBirth;
	
	// Contact Info
	private long phone;
	private String email;
	
	
	// Income and current employment
	private int monthlyGrossIncome;
	private String employer, occupation, employerAddress;
	Date commenced = new Date();
	private long workPhone;
	
	
	// Previous employer
	private String previousEmployer;
	private int yearsAtPreviousEmployer;
	
	
	// Marital info
	private String martialStatus, spouseName, spouseDOB;
	
	
	// Loan amount
	private int loanAmount;


	// My constructor for a loan application
	public LoanApplication(String firstName, String lastName, String dateOfBirth, long phone, String email,
			int monthlyGrossIncome, String employer, String occupation, String employerAddress, Date commenced,
			long workPhone, String previousEmployer, int yearsAtPreviousEmployer, String martialStatus,
			String spouseName, String spouseDOB, int loanAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.monthlyGrossIncome = monthlyGrossIncome;
		this.employer = employer;
		this.occupation = occupation;
		this.employerAddress = employerAddress;
		this.commenced = commenced;
		this.workPhone = workPhone;
		this.previousEmployer = previousEmployer;
		this.yearsAtPreviousEmployer = yearsAtPreviousEmployer;
		this.martialStatus = martialStatus;
		this.spouseName = spouseName;
		this.spouseDOB = spouseDOB;
		this.loanAmount = loanAmount;
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


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMonthlyGrossIncome() {
		return monthlyGrossIncome;
	}


	public void setMonthlyGrossIncome(int monthlyGrossIncome) {
		this.monthlyGrossIncome = monthlyGrossIncome;
	}


	public String getEmployer() {
		return employer;
	}


	public void setEmployer(String employer) {
		this.employer = employer;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getEmployerAddress() {
		return employerAddress;
	}


	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}


	public Date getCommenced() {
		return commenced;
	}


	public void setCommenced(Date commenced) {
		this.commenced = commenced;
	}


	public long getWorkPhone() {
		return workPhone;
	}


	public void setWorkPhone(long workPhone) {
		this.workPhone = workPhone;
	}


	public String getPreviousEmployer() {
		return previousEmployer;
	}


	public void setPreviousEmployer(String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}


	public int getYearsAtPreviousEmployer() {
		return yearsAtPreviousEmployer;
	}


	public void setYearsAtPreviousEmployer(int yearsAtPreviousEmployer) {
		this.yearsAtPreviousEmployer = yearsAtPreviousEmployer;
	}


	public String getMartialStatus() {
		return martialStatus;
	}


	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}


	public String getSpouseName() {
		return spouseName;
	}


	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}


	public String getSpouseDOB() {
		return spouseDOB;
	}


	public void setSpouseDOB(String spouseDOB) {
		this.spouseDOB = spouseDOB;
	}


	public int getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}


	@Override
	public String toString() {
		return "LoanApplication [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", phone=" + phone + ", email=" + email + ", monthlyGrossIncome=" + monthlyGrossIncome + ", employer="
				+ employer + ", occupation=" + occupation + ", employerAddress=" + employerAddress + ", commenced="
				+ commenced + ", workPhone=" + workPhone + ", previousEmployer=" + previousEmployer
				+ ", yearsAtPreviousEmployer=" + yearsAtPreviousEmployer + ", martialStatus=" + martialStatus
				+ ", spouseName=" + spouseName + ", spouseDOB=" + spouseDOB + ", loanAmount=" + loanAmount + "]";
	}




	
	
	
}

