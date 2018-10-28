package services;

import daos.UserDao;
import models.User;

public class ManagerServices {
	UserDao userDao = new UserDao();
	
	public User saveManager(User user) {
		return userDao.createManager(user);
	}
	
	public User saveEmployee(User user) {
		return userDao.createEmployee(user);
	}
	
	//---------------------Optional ----------------------------
	
	public void promoteEmployee(User user) {
		if(user.getRole()==1) {
			userDao.promoteByUsername(user);
		}System.out.println("User is already a manager.");
	}
	
	public void demoteManager(User user) {
		if(user.getRole()==2) {
			userDao.demoteByUsername(user);
		}System.out.println("User is already an employee.");
	}
	//-----------------------------------------------------------
}
