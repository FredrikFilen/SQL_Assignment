package presentation.JDBCmenu;

import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.Office;
import model.Order;
import model.Product;
import model.Reclaim;
import model.Warehouse;
import serviceJDBC.CustomerService;
import serviceJDBC.EmployeeService;
import serviceJDBC.OfficeService;
import serviceJDBC.OrderService;
import serviceJDBC.ProductService;
import serviceJDBC.ReclaimService;
import serviceJDBC.WarehouseService;

public class DeleteMenu {
	
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		System.out.println("delete : "
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
			deleteCustomer(s);
			break;
		}
		case 2: {
			deleteEmployee(s);
			break;
		}
		case 3:{
			deleteOffice(s);
			break;
		}
		case 4:{
			deleteOrder(s);
			break;
		}
		case 5:{
			deleteProduct(s);
			break;
		}
		case 6:{
			deleteReclaim(s);
			break;
		}
		case 7:{
			deleteWarehouse(s);
			break;
		}
		case 0:{
			break;
		}
		}
		
		
	}
	
	public void deleteCustomer(Scanner s) {
		CustomerService customerService = new CustomerService();
		Customer customer = null;
		
		System.out.println("Enter customer id to delete: ");
		customer = customerService.getCustomer(Integer.parseInt(s.nextLine()));
		System.out.println(customer.toString());
		
		
		customerService.deleteCustomer(customer);
	}
	
	public void deleteEmployee(Scanner s) {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = null;
		
		System.out.println("Enter employee id to delete: ");
		employee = employeeService.getEmployee(Integer.parseInt(s.nextLine()));
		System.out.println(employee.toString());
		
		
		employeeService.deleteEmployee(employee);
	}
	
	public void deleteOffice(Scanner s) {
		OfficeService officeService = new OfficeService();
		Office office = null;
		
		System.out.println("Enter office id to delete: ");
		office = officeService.getOffice(Integer.parseInt(s.nextLine()));
		System.out.println(office.toString());
		
		officeService.deleteOffice(office);
	}
	
	public void deleteOrder(Scanner s) {
		OrderService orderService = new OrderService();
		Order order = null;
		
		System.out.println("Enter order id to delete: ");
		order = orderService.getOrder(Integer.parseInt(s.nextLine()));
		System.out.println(order.toString());
		
		orderService.deleteOrder(order);
	}
	
	public void deleteProduct(Scanner s) {
		ProductService productService = new ProductService();
		Product product = null;
		
		System.out.println("Enter product id to delete: ");
		product = productService.getProduct(Integer.parseInt(s.nextLine()));
		System.out.println(product.toString());
		
		productService.deleteProduct(product);
	}
	
	public void deleteReclaim(Scanner s) {
		ReclaimService reclaimService = new ReclaimService();
		Reclaim reclaim = null;
		
		System.out.println("Enter Reclaim id to delete: ");
		reclaim = reclaimService.getReclaim(Integer.parseInt(s.nextLine()));
		System.out.println(reclaim.toString());
		
		reclaimService.deleteReclaim(reclaim);
	}
	
	public void deleteWarehouse(Scanner s) {
		WarehouseService warehouseService = new WarehouseService();
		Warehouse warehouse = null;
		
		System.out.println("Enter warehouse id to delete: ");
		warehouse = warehouseService.getWarehouse(Integer.parseInt(s.nextLine()));
		System.out.println(warehouse.toString());
		
		warehouseService.deleteWarehouse(warehouse);
	}
}
