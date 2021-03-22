package presentation.JDBCmenu;

import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.Office;
import model.Order;
import serviceJDBC.CustomerService;
import serviceJDBC.EmployeeService;
import serviceJDBC.OfficeService;
import serviceJDBC.OrderService;

public class UpdateMenu {
	
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		System.out.println("update : "
				+ "\n1. Customer"
				+ "\n2. Employee"
				+ "\n3. Office"
				+ "\n4. Order"
				+ "\n5. Product"
				+ "\n6. Reclaim"
				+ "\n7. Warehouse"
				+ "\n0. Exit");
		
		choice = Integer.parseInt(s.nextLine());
		
		switch(choice) {
		case 1: {
			updateCustomer(s);
			break;
		}
		case 2: {
			updateEmployee(s);
			break;
		}
		case 3: {
			updateOffice(s);
			break;
		}
		case 4:{
			updateOrder(s);
			break;
		}
		case 5:{
			updateProduct(s);
			break;
		}
		case 6:{
			updateReclaim(s);
			break;
		}
		case 7:{
			updateWarehouse(s);
			break;
		}
		case 0:{
			break;
		}
		}
		s.close();
	}
	
	public void updateCustomer(Scanner s) {
		CustomerService customerService = new CustomerService();
		Customer customer = null;
		
		System.out.println("Enter customer id to update: ");
		customer = customerService.getCustomer(Integer.parseInt(s.nextLine()));
		System.out.println(customer.toString());
		
		System.out.println("Enter new first name: ");
		customer.setFirst_name(s.nextLine());
		
		customerService.updateCustomer(customer);
	}
	
	public void updateEmployee(Scanner s) {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = null;
		
		System.out.println("Enter employee id to update: ");
		employee = employeeService.getEmployee(Integer.parseInt(s.nextLine()));
		System.out.println(employee.toString());
		
		System.out.println("Enter new first name: ");
		employee.setFirst_name(s.nextLine());
		
		employeeService.updateEmployee(employee);
	}
	
	public void updateOffice(Scanner s) {
		OfficeService officeService = new OfficeService();
		Office office = null;
		
		System.out.println("Enter office id to update: ");
		office = officeService.getOffice(Integer.parseInt(s.nextLine()));
		System.out.println(office.toString());
		
		System.out.println("Enter new office name; ");
		office.setOffice_name(s.nextLine());
		
		officeService.updateOffice(office);
	}
	
	public void updateOrder(Scanner s) {
		OrderService orderService = new OrderService();
		Order order = null;
		
		System.out.println("Enter order id to update: ");
		order = orderService.getOrder(Integer.parseInt(s.nextLine()));
	}
	
	public void updateProduct(Scanner s) {
		
	}
	
	public void updateReclaim(Scanner s) {
		
	}
	
	public void updateWarehouse(Scanner s) {
		
	}
	
	
}
