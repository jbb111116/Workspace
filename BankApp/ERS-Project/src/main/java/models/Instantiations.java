package models;

import java.util.Date;
import java.util.Scanner;

import launcher.Logistics;

public class Instantiations {
	public static User promptCreateEmployee() {
		User emp = new User();
		return emp;
	}
	
	public static ReimbursementRequest newRequest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("amount");
		double amount = sc.nextDouble();
		System.out.println("author");
		int author_id = Logistics.correctInput(0, 3);
		System.out.println("discript");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.println("type");
		int type_id = Logistics.correctInput(0, 3);
		
		ReimbursementRequest request = new ReimbursementRequest(0,amount,description, author_id,type_id);
		return request;
	}
}
