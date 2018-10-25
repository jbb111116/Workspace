package services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.BankAccount;
import models.Customer;
import models.JunctionTable;

public class Logistics {
	static UserService userService = new UserService();
	static Scanner sc = new Scanner(System.in);
	
	public static List<Customer> getCustomerByUsername() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter username to search for");
		String username = scan.nextLine().toLowerCase();
		List<Customer> customers = userService.getCustomerByUsername(username);
		if(!customers.isEmpty()) {
			scan.close();
			return customers;
		}else {
			System.out.println("Please enter valid user");
			scan.close();
			return getCustomerByUsername();
			}
	}

	public static void updateEmail(Customer customer) {
		System.out.println("Insert new email:");
		String newEmail = sc.nextLine();
		customer.setEmail(newEmail);
		userService.update(customer);
	}
	
	public static void updateBankAccountStatus(BankAccount account) {
		int decision = -1;
		Scanner updater = new Scanner(System.in);
		while(decision < 1 || decision > 3) {
			System.out.println("Approve account? \n1. Approve\n2. Do not approve");
			decision = updater.nextInt();
			if(sc.hasNextInt()) {
				if(decision == 1) {
					account.setApproved(true);
					System.out.println("The account was approved.");
				}
				else if(decision==2) {
					account.setApproved(false);
					System.out.println("The account was not approved.");
				}
				else {
					System.out.println("Closing terminal. You're not an admin if you don't know what to input..");
				}
			}
			else {
				try {
					decision = updater.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Input valid option.");
					updater.nextInt();
				}
			}
		}
		updater.close();
	}

	public static BankAccount deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like to deposit to?");
		List<BankAccount> account = Logistics.getAccountById();
		System.out.println("Current balance: $" + account.get(0).getBalance());
		System.out.println("How much would you like to deposit?");
		float deposit = scan.nextFloat();
		float balance = account.get(0).getBalance();
		if(deposit < 0) {
			System.out.println("Invalid deposit amount. Please try again.");
			deposit();
		}
		else {
			account.get(0).setBalance(balance + deposit);
			System.out.println("Balance for account " + account.get(0).getAccount_id()+" is $" + account.get(0).getBalance());
		}
		scan.close();
		return account.get(0);
	}
	
	public static BankAccount withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like to withdraw from?");
		List<BankAccount> account = Logistics.getAccountById();
		System.out.println("Current balance: $" + account.get(0).getBalance());
		System.out.println("How much would you like to withdraw?");
		float withdraw = scan.nextFloat();
		float balance = account.get(0).getBalance();
		float newBalance = balance - withdraw;
		if(newBalance < 0 || withdraw < 0) {
			System.out.println("Can't do transaction. Funds too low. Enter another amount.");
			withdraw();
		}
		else {
			account.get(0).setBalance(balance - withdraw);
			System.out.println("Balance for account " + account.get(0).getAccount_id()+" is $" + account.get(0).getBalance());	
		}
		scan.close();
		return account.get(0);
	}
	
	public static void transfer() {
		userService.updateAccount(withdraw());
		userService.updateAccount(deposit());
	}

	public static void viewAllBalances() {
		// Use joins in sql or figure out how to use it so I won't have to do 2 separate queries
		List<Customer> customer = getCustomerByUsername();
		String username = customer.get(0).getUsername();
		List<JunctionTable> accounts = userService.getAllAccounts(username);
		System.out.println(accounts);
//		List<String> account_ids = new ArrayList<>();
//		while(i < accounts.size()) {
//			account_ids.add(accounts.get(i).getUsername());
//			System.out.println(account_ids.get(i));
//			i++;
//		}
//		List<String> users = new ArrayList<>();
	}
	public static void viewAllCustomers() {
		List<BankAccount> accounts = getAccountById();
		long account_id = accounts.get(0).getAccount_id();
		List<JunctionTable> customers = userService.getAllCustomers(account_id);
		System.out.println(customers);
	}

	public static Customer promptCreateCustomer() {
		System.out.println("Enter user first and last name");
		String firstName = sc.next();
		String lastName = sc.nextLine().trim();
		System.out.println("Enter email address");
		String email = sc.nextLine();
		System.out.println("Enter username");
		String username = sc.nextLine();

		Customer customer = new Customer(0, firstName, lastName, email, username);
		return customer;
	}

	public static BankAccount promptCreateAccount() {
		System.out.println("Will this be a joint account?");
		boolean joint_account = sc.nextBoolean();
		System.out.println("What will the initial deposit be?");
		float initialDeposit = sc.nextFloat();

		BankAccount bankAccount = new BankAccount(0, joint_account, initialDeposit, false);
		return bankAccount;
	}

	public static List<BankAccount> getAccountById() {
		System.out.println("Enter your account number:");
		long id = sc.nextLong();
		List<BankAccount> accounts = userService.getAccountById(id);
		if(!accounts.isEmpty()) {
			return accounts;
		}
		else {
			System.out.println("Please enter valid account.");
			return getAccountById();
		}
	}
}
