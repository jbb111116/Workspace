package bankmethods;

import java.util.Date;

/**
 * My idea below is set up an outline for what can be done w/ 
 * a bank account
 *
 */
public abstract class BankTransactions {
	
	// setting an checking account balance variable
	float checkingAccountBalance;
	float savingsAccountBalance;
	final static int minSavings = 100;
	
	// fields that will interact w/ an account
	float transactionAmount;
	int numberOfTransactions;
	Date dateOfTransaction;
	
	abstract void withdrawMoney();
	abstract void transferMoney();
	
	abstract public void depositMoney();
	
	
	
	
}


