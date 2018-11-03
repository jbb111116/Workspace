package launcher;

import java.util.Scanner;

import services.EmployeeServices;
import services.ManagerServices;

public class Launcher {
//	public static void main(String[] args) {
//		EmployeeView view = new EmployeeView();
//		view.Login();
//	}
	public static void main(String[] args) {
		EmployeeServices es = new EmployeeServices();
		ManagerServices ms = new ManagerServices();
		Scanner sc = new Scanner(System.in);
		
		es.submitRequest();
		
	}
}
