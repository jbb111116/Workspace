package bankmethods;

import java.util.Scanner;

public class CustomerInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Username: ");
		String username = sc.nextLine();
		
		System.out.println("Password: ");
		String password = sc.nextLine();
		
		System.out.println("Any transactions today? Choose from any of the following options:");
		System.out.println("1. Sign up!");
		System.out.println("1. Apply for an account!");
		System.out.println("2. Witdraw from account.");
		System.out.println("3. Transfer to an account.");
		System.out.println("4. Deposit to account.");
		System.out.println("5. View account balance");
		System.out.println("0. Close terminal.");
		int input = sc.nextInt();
//		if(input != (int)) {
//			System.out.println("");
//		}
		sc.close();
		
		
	}
}
