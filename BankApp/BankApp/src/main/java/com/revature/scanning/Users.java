package com.revature.scanning;
/***Use the code below to check if a file already exists
 * File f = new File(filePathString);
 * if(f.exists() && !f.isDirectory()) { 
 * 		// do something
 * }
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.logistics.BankAccountApplication;
import com.revature.logistics.CreateAccount;
import com.revature.logistics.Transactions;
import com.revature.serialization.SerializationLoader;
import com.revature.serialization.SerializationSaver;

public class Users extends Transactions {

	public static void Employee() {
		Scanner input = new Scanner(System.in);
		System.out.println("View account");
		System.out.println("View applications");
		int choice = -1;
		// Catches any errors
		while (choice < 1 || choice > 4) {

			System.out.println("Please input the number that corresponds to you: ");
			System.out.println("1. Admin \n2. Employee \n3. Customer \n4. New User");
			if (input.hasNextInt())
				choice = input.nextInt();
			else {
				try {
					choice = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					input.nextLine();
				}
			}
			input.close();
		}
	}

	public static void Customer() {
		Scanner input = new Scanner(System.in);

		int choice = -1;
		// Catches any errors
		while (choice < 0 || choice > 6) {
			System.out.println("1. Apply for an account!");
			System.out.println("2. Withdraw from account.");
			System.out.println("3. Transfer to an account.");
			System.out.println("4. Deposit to account.");
			System.out.println("5. View account balance");
			System.out.println("0. Close terminal.");
			if (input.hasNextInt())
				choice = input.nextInt();
			else {
				try {
					choice = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					input.nextLine();
				}
			}

		}
		switch (choice) {
		case 0:
			input.close();
			System.out.println("Console has been closed!");
			break;
		case 1:
			BankAccountApplication g = new BankAccountApplication(choice, null, null, null, null, choice, null);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
		input.close();
	}

	public static void newUser() throws IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Please create an account!");
		System.out.println("Fist name:");
//		input.nextLine();//skips to next input
		String firstName = input.next();
		System.out.println("Last name:");
		input.nextLine();
		String lastName = input.next();
		System.out.println("email:");
		input.nextLine();
		String email = input.next();
		System.out.println("username:");
		input.nextLine();
		String userName = input.next();
		System.out.println("Enter a password:");
		String password1 = input.next();
		int phone = -1;
		while (phone < 1 || phone > 1000000000) {
			System.out.println("Phone:");
			if (input.hasNextInt())
				phone = input.nextInt();
			else {
				try {
					phone = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					input.nextLine();
				}
			}

		}
		System.out.println("Please re-enter password:");
		System.out.println("Please don't mess up. It will send you back to the main menu :(");
		String passwordTest = input.next();
		if (password1.equals(passwordTest)) {
			CreateAccount newAccount = new CreateAccount(firstName, lastName, email, phone, userName, password1,
					passwordTest);
			SerializationSaver.writeAccountToFile(newAccount);
			SerializationLoader.readAccountFile(firstName, lastName);
			System.out.println("Your account has been saved!");
			MainMenuScanner.main(null);
		} else {
			System.out.println("Please try again. Input all credentials again.");
			newUser();
		}
		input.close();
	}

	public static void Admin() {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Check loan application");
		System.out.println("2. Withdraw from account.");
		System.out.println("3. Transfer to an account.");
		System.out.println("4. Deposit to account.");
		System.out.println("5. View account balance");
		System.out.println("6. Approve bank account");
		System.out.println("0. Close console.");
		
		// Catches any errors
		int choice = -1;
		while (choice < 0 || choice > 6) {

			System.out.println("Which would you like to do? Please input the corresponding number: ");
			if (input.hasNextInt())
				choice = input.nextInt();
			else {
				try {
					choice = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					input.nextLine();
				}
			}

		}
		switch(choice) {
		case 0:
			input.close();
			System.out.println("Console has been closed!");
			break;
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		input.close();
	}

}
