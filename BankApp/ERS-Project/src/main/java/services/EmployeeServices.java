package services;

import java.util.List;

import daos.ReimbursementDao;
import daos.UserDao;
import models.Instantiations;
import models.ReimbursementRequest;

public class EmployeeServices {
	UserDao userDao = new UserDao();
	ReimbursementDao reimbDao = new ReimbursementDao();
	
	public ReimbursementRequest submitRequest() {
		ReimbursementRequest request;
		request = Instantiations.newRequest();
		return reimbDao.createRequest(request);
	}
	
	public List<ReimbursementRequest> getPendingRequestsByUsername(String username){
		return reimbDao.UserPendingRequests(username);
	}
	
	public List<ReimbursementRequest> getProcessedRequestsByUsername(String username){
		return reimbDao.UserProcessedRequests(username);
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