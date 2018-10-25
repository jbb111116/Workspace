package com.revature.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.revature.logistics.BankAccountApplication;
import com.revature.logistics.CreateAccount;
import com.revature.logistics.JointAccountApplication;
import com.revature.logistics.LoanApplication;

public class SerializationSaver {
	static CreateAccount a;
	

	public static void writeAccountToFile(CreateAccount a) throws IOException {
		String client = a.getUserName();
		File file = new File("./Accounts/" + client + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(a);
//		System.out.println("Hello new user. Come back and open an account with us or make your transactions mobile!");
		oos.close();
	}
	
	public static void writeLoanApplicationToFile(LoanApplication l) throws IOException {
		String client = l.getLastName() + l.getFirstName();
		File file = new File("./LoanApplications/" + client + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(l);
//		System.out.println("Your application has been submitted and saved!\nWe will review your application as soon as possible!");
		oos.close();
	}
	
	public static void writeBankAccountToFile(BankAccountApplication b) throws IOException {
		// NEED to declare variables
		int initialDeposit = 0;
		long phone = 6446131;
		String firstName = "";
		String lastName = "";
		String password = "";
		String DOB = "";
		String email = "";
		
		b = new BankAccountApplication(initialDeposit, firstName, lastName, password, DOB, phone, email);
		String client = a.getUserName();
		File file = new File("./BankAccounts/" + client + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(b);
//		System.out.println("You bank account application has been submitted \nand is up for review!");
		oos.close();
	}
	public static void writeJointBankAccountToFile(JointAccountApplication jb) throws IOException {
		String client = a.getUserName();
		File file = new File("./JointBankAccounts/" + client + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(jb);
//		System.out.println("You bank account application has been submitted \nand is up for review!");
		oos.close();
	}
}
