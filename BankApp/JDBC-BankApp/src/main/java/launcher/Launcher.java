package launcher;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import daos.UserDao;
import models.BankAccount;
import models.Customer;
import models.JunctionTable;
import services.Logistics;
import services.UserService;

public class Launcher {
	static Scanner sc = new Scanner(System.in);
	static UserService userService = new UserService();
	static UserDao userDao = new UserDao();


	public static void main(String[] args) {
//		Logistics.viewAllBalances(); // Views all balances of user successfully
//		Logistics.viewAllCustomers(); // Views all customers in an account successfully
//		System.out.println("Done!");
		System.out.println("Welcome to Revature Bank!");
		
		Scanner sc = new Scanner(System.in);
		int typeOfUser = -1;
		// Catches any errors
		while (typeOfUser < 1 || typeOfUser > 4) {
			System.out.println("Please input the number that corresponds to you: ");
			System.out.println("1. Admin \n2. Employee \n3. Customer \n4. Create new user");
			if (sc.hasNextInt()) {
				typeOfUser = sc.nextInt();
			}
			else {
				try {
					typeOfUser = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					sc.nextLine();
				}
			}

		}
		if(typeOfUser == 4) {
			System.out.println("Welcome new user!\nPlease input your credentials to create a new account.");
			Logistics.promptCreateCustomer();
			System.out.println("Your new user has been created.");
			main(null);
		}
		System.out.println("Please log in.");
		Scanner userInput = new Scanner(System.in);
		String login = userInput.nextLine();
		List<Customer> customers = userService.getCustomerByUsername(login);
		if(!customers.isEmpty()) {
			sc.nextLine();
			switch (typeOfUser) {
			case 1:
				int adminOption = -1;
				while(adminOption < 1 || adminOption > 3) {
					Scanner admin = new Scanner(System.in);
					System.out.println("Welcome!\nWhat would you like to do?");
					System.out.println("1. View account balances of customer\n2. View customers in joint account\n3. Approve accounts \n0. Go back to main menu");
					adminOption = -1;
					if(admin.hasNextInt()) {
						adminOption = admin.nextInt();
						switch(adminOption){
						case 1: 
							Logistics.viewAllBalances();
							break;
						case 2:
							Logistics.viewAllCustomers();
							break;
						case 3:
							System.out.println("Please input account number.");
							Scanner input = new Scanner(System.in);
							long id = input.nextLong();
							Logistics.updateBankAccountStatus(userService.getAccountById(id).get(0));
							userDao.createAccount(userService.getAccountById(id).get(0) ,customers.get(0));
							break;
						case 0:
							main(null);
						}
					}
					else {
						try {
							adminOption = sc.nextInt();
						}catch(InputMismatchException e) {
							System.out.println("Input valid option");
							sc.nextLine();
						}
					}
				}
				switch(adminOption) {
				case 1:
					Logistics.viewAllBalances();
				case 2:
					Logistics.viewAllCustomers();
				case 3:
					System.out.println("Please enter what account you would like to approve");
					long id = sc.nextLong();
					Logistics.updateBankAccountStatus(userService.getAccountById(id).get(0));
				case 0:
					main(null);
				}
				
				break;
			case 2:
				System.out.println("No employees currently :(");
				main(null);
				break;
			case 3:
				System.out.println("Please log in:");
				Logistics.getCustomerByUsername();
				int option = -1;
				while(option < 1 || option > 4) {
					System.out.println("Enter the number option that corresponds to you.");
					System.out.println("1. View Account Balances \n2. Deposit \n3. Withdraw \n4. Transfer \n5. Create new bank account \n6. Delete Account");
					if(sc.hasNextInt()) {
						option = sc.nextInt();
					}
					else {
						try {
							option = sc.nextInt();
						}catch(InputMismatchException e) {
							System.out.println("Input valid option");
							sc.nextLine();
						}
					}
				}
//				BankAccount account1 = Logistics.getAccountById().get(0);
				switch(option) {
					case 1:
						Logistics.viewAllBalances();
						break;
					case 2:
						userService.updateAccount(Logistics.deposit());
						break;
					case 3:
						userService.updateAccount(Logistics.withdraw());
						break;
					case 4:
						Logistics.transfer();
						break;
					case 5:
						Logistics.promptCreateAccount();
						break;
					case 6:
						Long someID = sc.nextLong();
						List<BankAccount> accounts = userService.getAccountById(someID);
						userDao.deleteAccountByAccountId(accounts.get(0));
				}
				
			}
		
		}
		else {
			System.out.println("Please try again.");
		}
		System.out.println("Would you like to go back? 'yes' or 'no'");
		String answer = sc.nextLine();
		if(answer.equals("yes")) {
			main(null);			
		}
		else {
			main(null);
			sc.close();			
		}
	}
//		if (!customers.isEmpty()) {
//			Customer test = customers.get(0);
//			System.out.println(test);
//		} else {
//			System.out.println("User does not exist, enter user that does exist");
//			System.out.println("Would you like to create a new user? /nEnter 'yes' or 'no'");
//			String answer = sc.next().toLowerCase();
//			if (answer.equals("no")) {
//				System.out.println("Search closed!");
//			} else if (answer.equals("yes")) {
//				Customer newCustomer = Logistics.promptCreateCustomer();
//				savedCustomer = userService.saveCustomer(newCustomer);
//				System.out.println("Your new saved user account info: " + savedCustomer);
//				// Where create implementation would go
//			} else {
//				System.out.println("Invalid input, terminal is being restarted..");
//			}
//			
//			// Code below would create a new user
//			System.out.println("Now change the email, bitch..");
//			Logistics.updateEmail(savedCustomer);
//			System.out.println(savedCustomer);
//		}
//		
//		
//		
//		List<BankAccount> viewableAccounts = Logistics.getAccountById();
////		System.out.println(viewableAccounts);
//
//		// Testing out the deposit function
//		System.out.println("Please input your account number you want to look at:");
//		long id = sc.nextLong();
////		List<BankAccount> accounts = userService.getAccountById(id);
//		for(int j = 0; j < accounts.size(); j++) {
//			System.out.println(accounts.get(j).getBalance());
//		}
//		System.out.println(accounts.get(0).getBalance());
//
//		// This creates a new bank account and saves it
//		BankAccount newAccount = new BankAccount();
//		BankAccount savedAccount = new BankAccount();
//		newAccount = Logistics.promptCreateAccount();
//		savedAccount = userService.saveBankAccount(newAccount);
//		System.out.println(savedAccount);
		// ---------------works--------------------------------

	

	
}
