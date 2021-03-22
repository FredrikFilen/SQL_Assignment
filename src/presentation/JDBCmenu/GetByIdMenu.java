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

public class GetByIdMenu {
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		System.out.println("get by id : "
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
			//get customer
			getCustomer(s);
			break;
		}
		case 2: {
			//get employee
			getEmployee(s);
			break;
		}
		case 3: {
			//get office
			getOffice(s);
			break;
		}
		case 4: {
			//get order
			getOrder(s);
			break;
		}
		case 5: {
			//get product
			getProduct(s);
			break;
		}
		case 6: {
			//get reclaim
			getReclaim(s);
			break;
		}
		case 7: {
			//get warehouse
			getWarehouse(s);
			break;
		}
		case 0: {
			//exit
			break;
		}
		}
		
	}
	
	public void getCustomer(Scanner s) {
		CustomerService customerService = new CustomerService();
		Customer customer = null;
		
		System.out.println("Enter customer id: ");
		int customerId = Integer.parseInt(s.nextLine());
		
		customer = customerService.getCustomer(customerId);
		System.out.println(customer.toString());
	}
	
	public void getEmployee(Scanner s) {
		EmployeeService employeeService  = new EmployeeService();
		Employee employee = null;
		
		System.out.println("Enter employee id: ");
		int employeeId = Integer.parseInt(s.nextLine());
		
		employee = employeeService.getEmployee(employeeId);
		System.out.println(employee.toString());
		
	}
	
	public void getOffice(Scanner s) {
		OfficeService officeService = new OfficeService();
		Office office = null;
		
		System.out.println("Enter office id: ");
		int officeId = Integer.parseInt(s.nextLine());
		
		office = officeService.getOffice(officeId);
		System.out.println(office.toString());
	}
	
	public void getOrder(Scanner s) {
		OrderService orderService = new OrderService();
		Order order = null;
		
		System.out.println("Enter order id: ");
		int orderId = Integer.parseInt(s.nextLine());
		
		order = orderService.getOrder(orderId);
		System.out.println(order.toString());
	}
	
	public void getProduct(Scanner s) {
		ProductService productService = new ProductService();
		Product product = null;
		
		System.out.println("Enter product id: ");
		int productId = Integer.parseInt(s.nextLine());
		
		product = productService.getProduct(productId);
		System.out.println(product.toString());
	}
	
	public void getReclaim(Scanner s) {
		ReclaimService reclaimService = new ReclaimService();
		Reclaim reclaim = null;
		
		System.out.println("Enter reclaim id: ");
		int reclaimId = Integer.parseInt(s.nextLine());
		
		reclaim = reclaimService.getReclaim(reclaimId);
		System.out.println(reclaim.toString());
	}
	
	public void getWarehouse(Scanner s) {
		WarehouseService warehouseService = new WarehouseService();
		Warehouse warehouse = null;
		
		System.out.println("Enter warehouse id: ");
		int warehouseId = Integer.parseInt(s.nextLine());
		
		warehouse = warehouseService.getWarehouse(warehouseId);
		System.out.println(warehouse.toString());
	}
}
