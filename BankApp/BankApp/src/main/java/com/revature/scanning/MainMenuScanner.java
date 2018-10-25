package com.revature.scanning;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.logistics.CreateAccount;
import com.revature.logistics.Transactions;
import com.revature.serialization.SerializationSaver;

public class MainMenuScanner extends Users{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Preset Admin
		CreateAccount admin1 = new CreateAccount("Jonathan", "Bedolla", "jon.bed@aol.com", 512254896, "jbed", "password1", "password1");
		CreateAccount admin2 = new CreateAccount("J", "Dawg", "jdawg@aol.com", 512254896, "j-dawg", "password2", "password2");
		SerializationSaver.writeAccountToFile(admin1);
		SerializationSaver.writeAccountToFile(admin2);
//		SerializationLoader.readAccountFile("Jonathan", "Bedolla");
		
//		 Print out Admins
//		SerializationLoader.readAccountFile("J", "Dawg");
		
		// Preset Employees
		CreateAccount employee1 = new CreateAccount("Bob", "Nelson", "bobnelson@aol.com", 512254896, "bnelson", "password1", "password1");
		CreateAccount employee2 = new CreateAccount("Jeff", "Neegan", "jneegan@aol.com", 512257896, "jneegan", "password2", "password2");
		CreateAccount employee3 = new CreateAccount("Joseph", "Arduino", "jduino@aol.com", 512257896, "duino123", "password3", "password3");
		CreateAccount employee4 = new CreateAccount("Alex", "Avocado", "axe_avocado@aol.com", 512254796, "avocadoGOAT", "password4", "password4");
		SerializationSaver.writeAccountToFile(employee1);
		SerializationSaver.writeAccountToFile(employee2);
		SerializationSaver.writeAccountToFile(employee3);
		SerializationSaver.writeAccountToFile(employee4);
				
		// Print out Employees
//		SerializationLoader.readAccountFile("Bob", "Nelson");
		
	
		// I can call SerializationLoader and SerializationSaver on the main method
		Scanner sc = new Scanner(System.in);
		int typeOfUser = -1;
		// Catches any errors
		while (typeOfUser < 1 || typeOfUser > 4) {
			System.out.println("Welcome to Revature Bank!");
			System.out.println("Please input the number that corresponds to you: ");
			System.out.println("1. Admin \n2. Employee \n3. Customer \n4. New User");
			if (sc.hasNextInt())
				typeOfUser = sc.nextInt();
			else {
				try {
					typeOfUser = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					sc.nextLine();
				}
			}

		}
		switch (typeOfUser) {
		case 1:
			//vvvvvvvvvvvvvvv Sign in process vvvvvvvvvvvvvvvvvvvvvvvv
			String username = sc.nextLine();
			
			boolean userCheck1 = username.equals(admin1.getUserName());
			boolean userCheck2 = username.equals(admin2.getUserName());
			while(userCheck1==false && userCheck2==false){
				System.out.println("++++++++Admin Login++++++++"
							   + "\nPlease enter your username:");
				username = sc.nextLine();
				userCheck1 = username.equals(admin1.getUserName());
				userCheck2 = username.equals(admin2.getUserName());
			 }
			System.out.println("Please enter your password:");
			String password = sc.nextLine();
			boolean passCheck1 = password.equals(admin1.getPassword());
			boolean passCheck2 = password.equals(admin2.getPassword());
			while(passCheck1==false && passCheck2==false) {
				System.out.println("Try different password:");
				password = sc.nextLine();
				passCheck1 = password.equals(admin1.getPassword());
				passCheck2 = password.equals(admin2.getPassword());
			}
			
			System.out.println("You have successfully logged in!");
			//^^^^^^^^^^^^^^^^ Sign in process ^^^^^^^^^^^^^^^^^^^^^^^^
			Admin();
			
			
			break;
		case 2:
			//vvvvvvvvvvvvvvv Sign in process vvvvvvvvvvvvvvvvvvvvvvvv
			username = sc.nextLine();
			
			userCheck1 = username.equals(employee1.getUserName());
			userCheck2 = username.equals(employee2.getUserName());
			boolean userCheck3 = username.equals(employee3.getUserName());
			boolean userCheck4 = username.equals(employee4.getUserName());			
			while(userCheck1==false && userCheck2==false && userCheck3==false && userCheck4==false){
				System.out.println("++++++++Employee Login++++++++"
							   + "\nPlease enter your username:");
				username = sc.nextLine();
				userCheck1 = username.equals(employee1.getUserName());
				userCheck2 = username.equals(employee2.getUserName());
				userCheck3 = username.equals(employee3.getUserName());
				userCheck4 = username.equals(employee4.getUserName());
			 }
			System.out.println("Please enter your password:");
			password = sc.nextLine();
			passCheck1 = password.equals(employee1.getPassword());
			passCheck2 = password.equals(employee2.getPassword());
			boolean passCheck3 = password.equals(employee3.getPassword());
			boolean passCheck4 = password.equals(employee4.getPassword());
			while(passCheck1==false && passCheck2==false) {
				System.out.println("Try different password:");
				password = sc.nextLine();
				passCheck1 = password.equals(admin1.getPassword());
				passCheck2 = password.equals(admin2.getPassword());
			}
			
			System.out.println("You have successfully logged in!");
			//^^^^^^^^^^^^^^^^ Sign in process ^^^^^^^^^^^^^^^^^^^^^^^^
			Employee();
			break;
		case 3:
			System.out.println("Customer Login");
			System.out.println("Please enter your log in");
			Customer();
			break;
		case 4:
			System.out.println("Welcome!");
			newUser();
		}
		sc.close();
	}
//================================================================= Code Runs above ==========================================================================

}