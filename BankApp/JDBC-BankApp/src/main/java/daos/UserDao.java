package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.BankAccount;
import models.Customer;
import models.JunctionTable;
import util.ConnectionUtil;

public class UserDao {
	String createCustomerQuery = "INSERT INTO customers (first_name, last_name, email, username) VALUES(?,?,?,?) RETURNING id;";
	String createBankAccountQuery = "INSERT INTO bank_accounts (joint_account, balance) VALUES(?,?) RETURNING account_id;";
	String createJunctionQuery = "INSERT INTO customers_bank_accounts ";
	String updateAccountBalanceQuery ="UPDATE bank_accounts SET balance = ? WHERE username = ?";
	String updateAccountStatusQuery = "UPDATE bank_accounts SET approved = ? WHERE username = ?";
	String updateUserEmailQuery ="UPDATE customers SET email = ? WHERE username = ?";
	String updateUsernameQuery = "UPDATE customers SET username = ? WHERE username = ?";
	String getCustomersFromJunctionQuery = "SELECT * FROM customers_bank_accounts WHERE account_id = ?";
	String deleteAccount = "DELETE FROM customers_bank_accounts WHERE account_id = ? ; DELETE FROM bank_accounts WHERE account_id = ?;";

	private Customer extractCustomer(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		// Extract data from result set
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));
		customer.setUsername(rs.getString("username"));
				
		return customer;
	}
	private BankAccount extractAccount(ResultSet rs) throws SQLException {
		BankAccount account = new BankAccount();
		// Extract data from result set
		account.setAccount_id(rs.getLong("account_id"));
		account.setJoint_account(rs.getBoolean("joint_account"));
		account.setBalance(rs.getFloat("balance"));
		account.setApproved(rs.getBoolean("approved"));
		
		
		return account;
	}
	
	private JunctionTable extractFromJunction(ResultSet rs) throws SQLException{
		JunctionTable junction = new JunctionTable();
		junction.setAccount_id(rs.getLong("account_id"));
		junction.setUsername(rs.getString("username"));
		return junction;
	}
	/**
	 * Accepts a User object, insert to the database, and updates it
	 * to include the database generated ID value.
	 * @param user - User to save
	 * @return - User updated w/ persisted ID
	 */
		
	public Customer createCustomer(Customer customer) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "INSERT INTO customers (first_name, last_name, email, username) VALUES(?,?,?,?) RETURNING id;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getUsername());
			
			// ResultSet starts before the first result, so we need to call next at least once
			ResultSet rs = ps.executeQuery();
			rs.next();
			customer.setId(rs.getInt("id"));
			return customer;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public List<Customer> getCustomerByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM customers WHERE LOWER(username) = ?";
			// DON'T EVER DO THIS, WE'LL FIND OUT SOON WHY
//			String query = "SELECT * FROM users WHERE first_name = '" + firstName.toLowerCase()+ "'";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			List<Customer> customers = new ArrayList<>();
			
			// Runs for every row in result set, next moves to next row
			while(rs.next()) {
				Customer customer = extractCustomer(rs);
				
				
				// Add user to list
				customers.add(customer);
			}
			return customers;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public void update(Customer customer) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, username = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail()); 
			ps.setString(4, customer.getUsername());
			ps.setInt(5, customer.getId());
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
//			return null;
		}
	}
	
	public void updateAccountBalance(BankAccount account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "UPDATE bank_accounts SET balance = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setFloat(1, account.getBalance());
			ps.setLong(2, account.getAccount_id());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public float getBalance(ResultSet rs) throws SQLException{
		BankAccount account = new BankAccount();
		account.setAccount_id(rs.getLong("account_id"));
		account.setJoint_account(rs.getBoolean("joint_account"));
		account.setBalance(rs.getFloat("balance"));
		account.setApproved(rs.getBoolean("approved"));
		
				
		return account.getBalance();
	}
	
	public List<BankAccount> getAccountInfoById(long account_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM bank_accounts WHERE account_id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setLong(1, account_id);
			ResultSet rs = statement.executeQuery();
			List<BankAccount> accounts = new ArrayList<>();
			
			// Runs for every row in result set, next moves to next row
			while(rs.next()) {
				BankAccount account = extractAccount(rs);
				
				
				// Add user to list
				accounts.add(account);
			}
			return accounts;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public List<JunctionTable> getCustomersFromJunction(long account_id){
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM customers_bank_accounts WHERE account_id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setLong(1, account_id);
			ResultSet rs = statement.executeQuery();
			List<JunctionTable> customers = new ArrayList<>();
			List<String> users = new ArrayList<>();
			
			// Runs for every row in result set, next moves to next row
			while(rs.next()) {
				JunctionTable customer = extractFromJunction(rs);
				
				
				// Add user to list
				users.add(customer.getUsername());
				customers.add(customer);
			}
			return customers;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<JunctionTable> getAccountsFromJunction(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM customers_bank_accounts WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			List<JunctionTable> accounts = new ArrayList<>();
			List<Long> account_numbers = new ArrayList<>();
			
			// Runs for every row in result set, next moves to next row
			while(rs.next()) {
				JunctionTable account = extractFromJunction(rs);
				
				
				// Add user to list
				accounts.add(account);
				account_numbers.add(account.getAccount_id());
			}
			return accounts;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public BankAccount createAccount(BankAccount newAccount) {
//		Scanner scan = new Scanner(System.in);
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "INSERT INTO bank_accounts (joint_account, balance) VALUES(?,?) RETURNING account_id";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBoolean(1, newAccount.isJoint_account());
			ps.setFloat(2, newAccount.getBalance());
			
			// ResultSet starts before the first result, so we need to call next at least once
			ResultSet rs = ps.executeQuery();
			rs.next();
			// Line below may cause problem
			newAccount.setAccount_id(rs.getLong("account_id"));
			newAccount.setApproved(false);
			return newAccount;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public JunctionTable createAccount(BankAccount newAccount, Customer newUser) {
//		Scanner scan = new Scanner(System.in);
		JunctionTable junction = new JunctionTable();
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "INSERT INTO customers_bank_accounts (account_id, username) VALUES(?,?) RETURNING account_id";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, newAccount.getAccount_id());
			ps.setString(2, newUser.getUsername());
			
			// ResultSet starts before the first result, so we need to call next at least once
			ResultSet rs = ps.executeQuery();
			rs.next();
			// Line below may cause problem
			junction.setAccount_id(rs.getLong("account_id"));
			junction.setUsername(rs.getString("username"));
			return junction;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteAccountByAccountId(BankAccount account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement(deleteAccount);
			ps.setFloat(1, account.getAccount_id());
			ps.setLong(2, account.getAccount_id());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public List<BankAccount> getAccountByUsername(JunctionTable junction) {
//		
//	}
	
	
	
}

// ResultSet starts before the first result, so we need to call next at least once
//			ResultSet rs = ps.executeQuery();
//			rs.next();
//			user.setId(rs.getInt("id"));
//			return user;