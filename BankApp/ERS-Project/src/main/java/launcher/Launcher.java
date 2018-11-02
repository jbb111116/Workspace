package launcher;

import models.Instantiations;
import models.ReimbursementRequest;
import services.EmployeeServices;

public class Launcher {
//	public static void main(String[] args) {
//		EmployeeView view = new EmployeeView();
//		view.Login();
//	}
	public static void main(String[] args) {
		EmployeeServices employeeServices = new EmployeeServices();
		ReimbursementRequest request = new ReimbursementRequest();
		
		request = Instantiations.newRequest();
		
		employeeServices.submitRequest(request);
		
		
	}
}
