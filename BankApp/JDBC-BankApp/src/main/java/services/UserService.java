package services;

import java.util.List;

import daos.UserDao;
import models.BankAccount;
import models.Customer;
import models.JunctionTable;

public class UserService {
	UserDao userDao = new UserDao();

	public List<Customer> getCustomerByUsername(String str) {
		return userDao.getCustomerByUsername(str);
	}

	public List<BankAccount> getAccountById(long account_id) {
		return userDao.getAccountInfoById(account_id);
	}

	public List<JunctionTable> getAllAccounts(String str) {
		return userDao.getAccountsFromJunction(str);
	}
	public List<JunctionTable> getAllCustomers(long id){
		return userDao.getCustomersFromJunction(id);
	}

	public Customer saveCustomer(Customer customer) {
		return userDao.createCustomer(customer);
	}

	public BankAccount saveBankAccount(BankAccount account) {
		return userDao.createAccount(account);
	}
	
//	public JunctionTable saveAccount(JunctionTable account) {
//		return userDao.createAccount(account);
//	}

	public void update(Customer customer) {
		userDao.update(customer);
	}

	public void updateAccount(BankAccount account) {
		userDao.updateAccountBalance(account);
	}
}
