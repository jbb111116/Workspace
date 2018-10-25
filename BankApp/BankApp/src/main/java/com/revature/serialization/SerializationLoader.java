package com.revature.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.revature.logistics.BankAccountApplication;
import com.revature.logistics.CreateAccount;
import com.revature.logistics.JointAccountApplication;
import com.revature.logistics.LoanApplication;

public class SerializationLoader {

	
	public static void readAccountFile(String firstName, String lastName) throws IOException, ClassNotFoundException{
		String client = firstName + lastName;
		CreateAccount a = null;
		File file = new File("./Accounts/"+ client +".ser");

		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			a = (CreateAccount) ois.readObject();
//			System.out.println(a);
//			System.out.println("Account has been loaded!");
			
		} catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		System.out.println(a.getFirstName()+a.getLastName());
			
	}
	
	public static void readBankAccountFile(String firstName, String lastName) throws IOException, ClassNotFoundException{
		String client = lastName + firstName;
		BankAccountApplication b = null;
		File file = new File("./BankAccounts/"+ client +".ser");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			b = (BankAccountApplication) ois.readObject();
//			System.out.println(b);
//			System.out.println("Bank account info has been loaded!");
			ois.close();
		} catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		System.out.println(b);
	}
	
	public static void readJointBankAccountFile(String firstName, String lastName) throws IOException, ClassNotFoundException{
		String client = lastName + firstName;
		JointAccountApplication b = null;
		File file = new File("./JointBankAccounts/"+ client +".ser");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			b = (JointAccountApplication) ois.readObject();
//			System.out.println(b);
//			System.out.println("Bank account info has been loaded!");
			ois.close();
		} catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		System.out.println(b);
	}
	
	public static void readLoanApplication(String clientName)throws IOException, ClassNotFoundException {
		String client = clientName;
		LoanApplication l = null;
		File file = new File("./LoanApplications/"+ client +".ser");

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			l = (LoanApplication) ois.readObject();
			System.out.println(l);
			System.out.println("Loan Application has been loaded!");
			ois.close();
		}catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		System.out.println(l);
	}
}
