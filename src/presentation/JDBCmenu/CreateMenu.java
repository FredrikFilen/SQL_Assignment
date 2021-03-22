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

public class CreateMenu {
	public void run() {
		Scanner s = new Scanner(System.in);
		int choice;
		System.out.println("\ncreate : "
				+ "\n1. Customer"
				+ "\n2. Employee"
				+ "\n3. Office"
				+ "\n4. Order"
				+ "\n5. Product"
				+ "\n6. Reclaim"
				+ "\n7. Warehouse"
				+ "\n0. exit");
		
			choice = Integer.parseInt(s.nextLine());
			
			switch (choice) {
				case 1: {
					//create customer
					createCustomer(s);
					break;
				}
				case 2: {
					//create employee
					createEmployee(s);
					break;
				}
				case 3: {
					//create office
					createOffice(s);
					break;
				}
				case 4: {
					//create Order
					createOrder(s);
					break;
				}
				case 5: {
					//create Product
					createProduct(s);
					break;
				}
				case 6: {
					//create reclaim
					createReclaim(s);
					break;
				}
				case 7: {
					//create Warehouse
					createWarehouse(s);
					break;
				}
				case 0:{
					//exit
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
			}
	}
	
	public void createCustomer(Scanner s) {
		CustomerService customerService = new CustomerService();
		Customer newCustomer = new Customer();
		System.out.println("Enter first name: ");
		newCustomer.setFirst_name(s.nextLine());
	
		System.out.println("Enter last name: ");
		newCustomer.setLast_name(s.nextLine());
	
		System.out.println("Enter email: ");
		newCustomer.setEmail(s.nextLine());
	
		System.out.println("Enter address: ");
		newCustomer.setAddress(s.nextLine());
	
		customerService.createCustomer(newCustomer);
	
		System.out.println(newCustomer.toString() + " created");
	}
	
	public void createEmployee(Scanner s) {
		EmployeeService employeeService = new EmployeeService();
		Employee newEmployee = new Employee();
		
		System.out.println("Enter first name: ");
		newEmployee.setFirst_name(s.nextLine());
		
		System.out.println("Enter last name: ");
		newEmployee.setLast_name(s.nextLine());
		
		System.out.println("Enter email: ");
		newEmployee.setEmail(s.nextLine());
		
		System.out.println("Enter address: ");
		newEmployee.setAddress(s.nextLine());
		
		System.out.println("Enter office id: ");
		newEmployee.setOffice_id(Integer.parseInt(s.nextLine()));
		
		employeeService.createEmployee(newEmployee);
		System.out.println(newEmployee.toString() + " created");
	}
	
	public void createOffice(Scanner s) {
		OfficeService officeService = new OfficeService();
		Office newOffice = new Office();
		
		System.out.println("Enter name: ");
		newOffice.setOffice_name(s.nextLine());
		
		System.out.println("Enter Address: ");
		newOffice.setAdress(s.nextLine());
		
		officeService.createOffice(newOffice);
		System.out.println(newOffice.toString() + " created");
	}
	
	public void createOrder(Scanner s) {
		OrderService orderService = new OrderService();
		Order newOrder = new Order();
		
		System.out.println("Enter product id: ");
		newOrder.setProduct_id(Integer.parseInt(s.nextLine()));
		
		System.out.println("Enter Customer id: ");
		newOrder.setCustomer_id(Integer.parseInt(s.nextLine()));
		
		System.out.println("Enter amount: ");
		newOrder.setAmount(Integer.parseInt(s.nextLine()));
		
		System.out.println("Enter Order date as YYYY-MM-DD: ");
		newOrder.setOrder_date(s.nextLine());
		
		orderService.createOrder(newOrder);
		System.out.println(newOrder.toString() + " created");
	}
	
	public void createProduct(Scanner s) {
		ProductService productService = new ProductService();
		Product product = new Product();
		
		System.out.println("Enter product name: ");
		product.setProduct_name(s.nextLine());
		
		System.out.println("Enter product description: ");
		product.setProduct_description(s.nextLine());
		
		System.out.println("Enter product price: ");
		product.setProduct_price(Double.parseDouble(s.nextLine()));
		
		productService.createProduct(product);
		System.out.println(product.toString() + " created");
		
		
	}
	
	public void createReclaim(Scanner s) {
		ReclaimService reclaimService = new ReclaimService();
		Reclaim reclaim = new Reclaim();
		
		System.out.println("Enter product id: ");
		reclaim.setProduct_id(Integer.parseInt(s.nextLine()));
		
		System.out.println("Enter reclaim date as YYYY-MM-DD: ");
		reclaim.setReclaim_date(s.nextLine());
		
		reclaimService.createReclaim(reclaim);
		System.out.println(reclaim.toString() + " created");
	}
	
	public void createWarehouse(Scanner s) {
		WarehouseService warehouseService = new WarehouseService();
		Warehouse warehouse = new Warehouse();
		
		System.out.println("Enter warehouse name: ");
		warehouse.setWarehouse_name(s.nextLine());
		
		System.out.println("Enter warehouse address: ");
		warehouse.setAddress(s.nextLine());
		
		warehouseService.createWarehouse(warehouse);
		System.out.println(warehouse.toString() + " Created");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
