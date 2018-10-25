package com.revature.logistics;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Transactions {

	// Minimum amount that must be available in a savings account
	final static int minSavings = 100;

	// Field that keeps track of a customer's different type of balances
	float checkingAccountBalance;
	float savingsAccountBalance;

	// fields that will interact w/ an account
	float transactionAmount;
	int numberOfTransactions;
	Date dateOfTransaction = new Date();

	// methods to adjust an account balance
	public void viewBalance(String firstName, String lastName, float balance) {
		File file = new File("./Accounts/"+firstName + lastName+".ser");
//		readAccountFile(firstName,lastName)
		System.out.println(balance);
	}
	public void withdrawMoney(float transactionAmount, float balance, Date dateOfTransaction) {
		balance -= transactionAmount;
		DateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(dateFormatter.format(dateOfTransaction) + " Your new balance is: $" + balance);

	}

	public void transferMoney(float balance1, float balance2, float amount, Date dateOfTransaction) {
		balance1 -= amount;
		balance2 += amount;
		DateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(dateFormatter.format(dateOfTransaction) + " The balance of the account money was transferred from is $" + balance1);
		System.out.println(dateFormatter.format(dateOfTransaction) + " The balance of the account money was transferred to is $" + balance2);
	}

	public void depositMoney(float transactionAmount, float balance, Date dateOfTransaction) {
		DateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		balance += transactionAmount;
		System.out.println(dateFormatter.format(dateOfTransaction) + " The new balance to this account is $" + balance);
	}
}
