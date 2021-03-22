package presentation.HibernateMenu;

import java.util.List;
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

public class GetAllMenu {
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		System.out.println("\nGet all : "
				+ "\n1. Customers"
				+ "\n2. Employees"
				+ "\n3. Offices"
				+ "\n4. Orders"
				+ "\n5. Products"
				+ "\n6. Reclaims"
				+ "\n7. Warehouses"
				+ "\n0. Exit");
		
		choice = Integer.parseInt(s.nextLine());
		
		switch(choice) {
		case 1: {
			getAllCustomers(s);
			break;
		}
		case 2: {
			getAllEmployees(s);
			break;
		}
		case 3: {
			getAllOffices(s);
			break;
		}
		case 4: {
			getAllOrders(s);
			break;
		}
		case 5: {
			getAllProducts(s);
			break;
		}
		case 6: {
			getAllReclaims(s);
			break;
		}
		case 7:{
			getAllWarehouses(s);
			break;
		}
		case 0:{
			break;
		}
		}
	}
	
	public void getAllCustomers(Scanner s) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAllCustomers();
		
		for(Customer c : customers) {
			System.out.println(c.toString());
		}
	}
	
	public void getAllEmployees(Scanner s) {
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee e : employees) {
			System.out.println(e.toString());
		}
	}
	
	public void getAllOffices(Scanner s) {
		OfficeService officeService = new OfficeService();
		List<Office> offices = officeService.getAllOffices();
		
		for(Office o : offices) {
			System.out.println(o.toString());
		}
	}
	
	public void getAllOrders(Scanner s) {
		OrderService orderService = new OrderService();
		List<Order> orders = orderService.getAllOrders();
		
		for(Order o : orders) {
			System.out.println(o.toString());
		}
	}
	
	public void getAllProducts(Scanner s) {
		ProductService productService = new ProductService();
		List<Product> products = productService.getAllProducts();
		
		for(Product p : products) {
			System.out.println(p.toString());
		}
	}
	
	public void getAllReclaims(Scanner s) {
		ReclaimService reclaimService = new ReclaimService();
		List<Reclaim> reclaims = reclaimService.getAllReclaims();
		
		for(Reclaim r : reclaims) {
			System.out.println(r.toString());
		}
	}
	
	public void getAllWarehouses(Scanner s) {
		WarehouseService warehouseService = new WarehouseService();
		List<Warehouse> warehouses = warehouseService.getAllWarehouses();
		
		for(Warehouse w : warehouses) {
			System.out.println(w.toString());
		}
	}
}
