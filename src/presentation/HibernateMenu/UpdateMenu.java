package presentation.HibernateMenu;

import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.Office;
import model.Order;
import model.Product;
import model.Reclaim;
import model.Warehouse;
import serviceHibernate.CustomerService;
import serviceHibernate.EmployeeService;
import serviceHibernate.OfficeService;
import serviceHibernate.OrderService;
import serviceHibernate.ProductService;
import serviceHibernate.ReclaimService;
import serviceHibernate.WarehouseService;

public class UpdateMenu {
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		System.out.println("\nUpdate : "
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
		System.out.println(order.toString());
		
		System.out.println("Enter new product id: ");
		order.setProduct_id(Integer.parseInt(s.nextLine()));
		
		orderService.updateOrder(order);
	}
	
	public void updateProduct(Scanner s) {
		ProductService productService = new ProductService();
		Product product = null;
		
		System.out.println("Enter product id to update: ");
		product = productService.getProduct(Integer.parseInt(s.nextLine()));
		System.out.println(product.toString());
		
		System.out.println("Enter new product name: ");
		product.setProduct_name(s.nextLine());
		
		productService.updateProduct(product);
	}
	
	public void updateReclaim(Scanner s) {
		ReclaimService reclaimService = new ReclaimService();
		Reclaim reclaim = null;
		
		System.out.println("Enter Reclaim id to update: ");
		reclaim = reclaimService.getReclaim(Integer.parseInt(s.nextLine()));
		System.out.println(reclaim.toString());
		
		System.out.println("Enter reclaim reason: ");
		reclaim.setReclaim_reason(s.nextLine());
		
		reclaimService.updateReclaim(reclaim);
	}
	
	public void updateWarehouse(Scanner s) {
		WarehouseService warehouseService = new WarehouseService();
		Warehouse warehouse = null;
		
		System.out.println("Enter warehouse id to update: ");
		warehouse = warehouseService.getWarehouse(Integer.parseInt(s.nextLine()));
		System.out.println(warehouse.toString());
		
		System.out.println("Enter new warehouse name: ");
		warehouse.setWarehouse_name(s.nextLine());
		
		warehouseService.updateWarehouse(warehouse);
	}
}
