package services;

import daos.ReimbursementDao;
import daos.UserDao;
import models.ReimbursementRequest;

public class EmployeeServices {
	UserDao userDao = new UserDao();
	ReimbursementDao reimbursementDao = new ReimbursementDao();
	
	public ReimbursementRequest submitRequest(ReimbursementRequest request) {
		return reimbursementDao.createRequest(request);
	}
	
	
	
	
}
//	public static User saveEmployee(String username, String password) {
//		User LinkedEmployee =  UserDao.employeeLogin(username, password);
//		if(username.equals(LinkedEmployee.getUsername())) {
//			if(password.equals(LinkedEmployee.getPassword())) {
//				return LinkedEmployee;
//			}
//		}
//	return null;
//	}
//	public List<ReimbursementRequest> getHistoryOfReimbursement(String str) {
//		return userDao.g
//	}