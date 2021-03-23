package presentation.HibernateMenu;

import java.util.List;
import java.util.Scanner;

import model.Order;
import model.Product;
import serviceHibernate.ProductService;
import serviceHibernate.CustomerService;
import serviceHibernate.OrderService;



public class MenuHibernate {
	public void run() {
		boolean menuRunning = true;
		Scanner s = new Scanner(System.in);
		
		while(menuRunning) {
			System.out.println(
					"\n1. Create"
				+ "\n2. Get by id"
				+ "\n3. Get all"
				+ "\n4. Update"
				+ "\n5. Delete"
				+ "\n6. Get products with low stock"
				+ "\n7. Get best customer"
				+ "\n0. Exit");
		
			int choice = Integer.parseInt(s.nextLine());
		
			switch (choice) {
			case 1: {
				//creation menu
				CreateMenu createMenu = new CreateMenu();
				createMenu.run();
				break;
				
			}
			case 2:{
				//get by id
				GetByIdMenu getByIdMenu = new GetByIdMenu();
				getByIdMenu.run();
				break;
			}
			case 3:{
				// get all
				GetAllMenu getAllMenu = new GetAllMenu();
				getAllMenu.run();
				break;
			}
			case 4:{
				//update
				UpdateMenu updateMenu = new UpdateMenu();
				updateMenu.run();
				break;
			}
			case 5:{
				//delete
				DeleteMenu deleteMenu = new DeleteMenu();
				deleteMenu.run();
				break;
			}
			case 6:{
				ProductService productService = new ProductService();
				List<Product> products = productService.getLowStock();
				System.out.println("Products with stock below 10: ");
				
				for(Product p : products) {
					System.out.println(p.toString());
				}
				
				System.out.println("Total amount of low stock products are: " + products.size());
				break;
			}
			case 7:{
				CustomerService customerService = new CustomerService();
				OrderService orderService = new OrderService();
				ProductService productService = new ProductService();
				int totalPrice = 0;
				for(Order o: orderService.getAllOrders()) {
					if(o.getCustomer_id() == customerService.getBestCustomer().getCustomer_Id()) {
						totalPrice += productService.getProduct(o.getProduct_id()).getProduct_price() * o.getAmount();
					}
				}
				System.out.println("Best customer is: " + customerService.getBestCustomer().getFirst_name() + " " + customerService.getBestCustomer().getLast_name());
				System.out.println("Total amount spent is: " + totalPrice);
				
				break;
			}
			case 0:{
				menuRunning = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
}
