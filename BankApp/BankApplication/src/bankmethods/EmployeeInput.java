package bankmethods;

import java.util.Scanner;

public class EmployeeInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Username: ");
		String username = sc.nextLine();
		
		System.out.println("Password: ");
		String password = sc.nextLine();
		
		System.out.println("Any transactions today? Choose from any of the following options:");
		System.out.println("1. Transfer to an account.");
		System.out.println("2. Deposit to account.");
		System.out.println("3. View account balance");
		System.out.println("4. View personal information of account.");
		System.out.println("5. View applications.");
		System.out.println("0. Close terminal.");
	}
}
